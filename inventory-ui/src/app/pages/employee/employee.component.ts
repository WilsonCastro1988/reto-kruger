import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {AppService} from "@services/app.service";
import {EmployeeService} from "@services/employee.service";
import {Router} from "@angular/router";
import {KgrtEmployeeDto} from "@/dto/KgrtEmployeeDto";
import {KgrtVaccinationDto} from "@/dto/KgrtVaccinationDto";
import {ToastrService} from 'ngx-toastr';
import {UsuarioDto} from "@/dto/UsuarioDto";
import {UserService} from "@services/user.service";
import {EmailService} from "@services/email.service";
import {EmailValuesDTO} from "@/dto/EmailValuesDtots";
import {ConfirmationService} from "primeng/api";


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  /***
   * variables globales
   * */
  form: FormGroup;
  @Input() employeeDto: KgrtEmployeeDto;
  employeeDtos: KgrtEmployeeDto[];
  dischargeVaccination: boolean = false;
  editEmployee: boolean = false;


  /***
   * Constructor: se agregar los servicios ncesarios
   * **/
  constructor(public appService: AppService,
              public formBuilder: FormBuilder,
              public employeeservice: EmployeeService,
              private userservice: UserService,
              private emailService: EmailService,
              private toastr: ToastrService,
              private confirmationService: ConfirmationService,
              public router: Router) {
  }

  /***
   * Constructir para inicializar antes del renderizado de la pagina
   * **/
  ngOnInit() {
    this.employeeDto = new KgrtEmployeeDto();
    this.crearForm();
    this.llenarListEmployee();


  }

  setSeleccionado(employee) {
    this.employeeDto = employee;
    this.employeeDto.employeedBirthDate = this.formatDateToForm(this.employeeDto.employeedBirthDate);
    this.form = this.formBuilder.group(this.employeeDto);
    this.editEmployee = true;
    if (this.employeeDto.flagemployeevUser !== '') {
      this.dischargeVaccination = true;
    }
  }

  formatDateToForm(dateInput) {
    let date = new Date(dateInput);
    let dateOutPut = new Date();
    dateOutPut.setDate(date.getUTCDate());
    dateOutPut.setMonth(date.getUTCMonth());
    dateOutPut.setFullYear(date.getUTCFullYear());
    return dateOutPut;
  }

  llenarListEmployee() {
    this.employeeservice.getAll().subscribe(
      data => {
        this.employeeDtos = data;
      }
    );
  }

  //Inicializa el formulario para el ingreso de la pagina y datos
  crearForm() {
    this.form = new FormGroup({
      employeevDni: new FormControl('', Validators.required),
      employeevName: new FormControl('', Validators.required),
      employeevLastname: new FormControl('', Validators.required),
      employeedBirthDate: new FormControl('', Validators.required),
      employeevAdrress: new FormControl('', Validators.required),
      employeevMail: new FormControl('', Validators.required),
      employeevPhone: new FormControl('', Validators.required),
      employeebActive: new FormControl('', Validators.required),
      audidCreationDate: new FormControl('',),
      audivUserCreation: new FormControl('',),
      audidModificationDate: new FormControl('',),
      audivUserModification: new FormControl('',),
      audidDeleteDate: new FormControl('',),
      audivUserDelete: new FormControl('',),
      flagemployeevUser: new FormControl('',),
      //kgrtVaccinationCollectionDTO:KgrtVaccinationDto[];


    });
    //this.form = this.formBuilder.group(this.tipoPlan);
  }

  /**
   * Métodos para funcionalidad de la pagina
   * **/
  guardar() {
    if (this.form.invalid) {
      this.appService.msgInfoDetail('warn', 'Verificacion', 'Verificar los Datos a Ingresar')
      return
    } else {
      this.employeeDto = this.form.value;

      this.employeeservice.getById(this.employeeDto.employeevDni).subscribe(value => {
          if (value.employeevDni == this.employeeDto.employeevDni && this.editEmployee == false) {
            let nameEmployee = value.employeevName + ' ' + value.employeevLastname;
            this.confirmationService.confirm({
              acceptLabel: 'Aceptar',
              rejectLabel: 'Cancelar',
              acceptButtonStyleClass: 'p-button-outlined p-button-rounded p-button-success',
              rejectButtonStyleClass: 'p-button-outlined p-button-rounded p-button-danger',
              message: 'El DNI ' + value.employeevDni + ' corresponde al Empleado ' + nameEmployee + ', desea ACTUALIZARLO de todas maneras ?',
              header: 'Confirmar',
              icon: 'pi pi-exclamation-triangle',
              accept: () => {
                this.saveObject();
              }
            });
          } else {
            console.log('FALG DE EMPLEADO: '+this.employeeDto.flagemployeevUser);
            if (this.dischargeVaccination && this.employeeDto.flagemployeevUser =='')
              this.saveEmpUser();
            else this.saveObject();
          }
        },
        err => {
          let mensaje = {
            status: 'ESTADO SOLICITUD: ' + err.error.status,
            error: 'PROBLEMA: ' + err.error.error
          }
          this.appService.msgInfoDetail('warn', 'Permisos', JSON.stringify(mensaje))
        }
      );


    }
  }

  saveEmpUser() {
    this.employeeservice.saveEmpUser(this.employeeDto).subscribe((data: any) => {
        if (!this.editEmployee) {
          this.appService.msgCreate();
        } else {
          this.appService.msgUpdate();
          this.editEmployee = false;
        }
        this.setearForm();
        this.llenarListEmployee();
      },
      err => {
        let mensaje = {
          status: 'ESTADO SOLICITUD: ' + err.error.status,
          error: 'PROBLEMA: ' + err.error.error
        }
        this.appService.msgInfoDetail('warn', 'Permisos', JSON.stringify(mensaje))
      }
    );
  }

  saveObject() {
    this.employeeservice.saveObject(this.employeeDto).subscribe((data: any) => {
        if (!this.editEmployee) {
          this.appService.msgCreate();
        } else {
          this.appService.msgUpdate();
          this.editEmployee = false;
        }
        this.sendEmail(data);
        this.setearForm();
        this.llenarListEmployee();
      },
      err => {
        let mensaje = {
          status: 'ESTADO SOLICITUD: ' + err.error.status,
          error: 'PROBLEMA: ' + err.error.error
        }
        this.appService.msgInfoDetail('warn', 'Permisos', JSON.stringify(mensaje))
      }
    );
  }

  setearForm() {
    this.employeeDto = new KgrtEmployeeDto();
    this.dischargeVaccination = false;
    this.form.reset();
  }

  sendEmail(employeeDto: KgrtEmployeeDto) {

    //TODO: completar envio con correo

    let emailDto = new EmailValuesDTO();

    emailDto.mailTo = employeeDto.employeevMail;
    emailDto.subject = 'ALTA en proceso COVID19';
    emailDto.userName = employeeDto.employeevName + ' ' + employeeDto.employeevLastname;
    emailDto.body = 'Proceso culminado';
    emailDto.jwt = '';
    this.emailService.sendEmail(emailDto).subscribe(value => {
    }, error => {
      this.appService.msgInfoDetail('error', 'Notification', 'Email Notification not Send')
    });
  }


  cancelar() {
    this.appService.msgInfoDetail('info', '', 'Acción Cancelada')
    this.setearForm();
  }
}

