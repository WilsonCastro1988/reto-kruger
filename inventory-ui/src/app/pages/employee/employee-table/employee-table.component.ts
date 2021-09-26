import {Component, Input, OnInit, Output} from '@angular/core';
import {EventEmitter} from '@angular/core';
import {KgrtEmployeeDto} from "@/dto/KgrtEmployeeDto";
import {EmployeeService} from "@services/employee.service";
import {AppService} from "@services/app.service";
import {ConfirmationService} from "primeng/api";
import * as FileSaver from 'file-saver';
import jsPDF from "jspdf";
import "jspdf-autotable";
import {formatDate} from "@angular/common";
import {Table} from "primeng/table";

@Component({
  selector: 'app-employee-table',
  templateUrl: './employee-table.component.html',
  styleUrls: ['./employee-table.component.scss']
})
export class EmployeeTableComponent implements OnInit {

  tipoPlanDialog: boolean;

  @Input() employeeDtos: KgrtEmployeeDto[];
  @Output() employeeSelect = new EventEmitter();

  employeeDto: KgrtEmployeeDto;

  selectedEmployeeDto: KgrtEmployeeDto[];

  submitted: boolean;

  loading: boolean;

  exportColumns: any[];

  cols: any[];

  constructor(private employeeservice: EmployeeService, private appservice: AppService, private confirmationService: ConfirmationService) {
  }

  ngOnInit() {
    this.construirTabla();
  }

  construirTabla() {
    this.cols = [
      {field: 'employeevDni', header: 'NDI'},
      {field: 'employeevName', header: 'Name'},
      {field: 'employeevLastname', header: 'Last Name'},
      {field: 'employeedBirthDate', header: 'Birth Date'},
      {field: 'employeevAdrress', header: 'Address'},
      {field: 'employeevMail', header: 'Email'},
      {field: 'employeevPhone', header: 'Phone'},
      {field: 'employeebActive', header: 'Is Active ? '},

    ];

    this.exportColumns = this.cols.map(col => ({title: col.header, dataKey: col.field}));
    this.loading = false;

  }

  clear(table: Table) {
    table.clear();
  }

  openNew() {
    this.employeeDto = new KgrtEmployeeDto();
    this.submitted = false;
    this.tipoPlanDialog = true;
  }

  deleteSelectedTipoPlan() {
    this.confirmationService.confirm({
      acceptLabel: 'Aceptar',
      rejectLabel: 'Cancelar',
      acceptButtonStyleClass: 'p-button-outlined p-button-rounded p-button-success',
      rejectButtonStyleClass: 'p-button-outlined p-button-rounded p-button-danger',
      message: 'Esta seguro de Eliminar los elementos seleccionados?, Algunos registros pueden contener usuarios asignados',
      header: 'Confirmar',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.eliminarPlanSelected();
      }
    });
  }


  eliminarPlanSelected() {

    let indexLista: number = 0;
    for (let i = 0; i < this.selectedEmployeeDto.length; i++) {
      this.employeeservice.deleteObject(this.selectedEmployeeDto[i].employeevDni).subscribe(
        data => {
          indexLista++;
          if (indexLista == this.selectedEmployeeDto.length) {
            this.employeeDtos = this.employeeDtos.filter(val => !this.selectedEmployeeDto.includes(val));
            this.selectedEmployeeDto = null;
            this.appservice.msgInfoDetail('error', 'Eliminación', 'Se han eliminado todos los datos seleccionados',)
          }
        }
      );
    }


  }

  editTipoPlan(employeeDto) {
   // this.employeeDto = {...employeeDto};
   // this.tipoPlanDialog = false;
    this.employeeSelect.emit(employeeDto);
  }

  deleteEmployee(emp: KgrtEmployeeDto) {
    let msgDeleteWhitUser = 'El empleado tiene un Usuario asignado, está seguro de eliminarlo también ?'
    let msgDeleteWhitOutUser = 'Esta seguro de eliminar ' + emp.employeevDni + '?';
    let mensaje = msgDeleteWhitOutUser;
    if(emp.flagemployeevUser !== '')
    {
      mensaje = msgDeleteWhitUser
    }
    this.confirmationService.confirm({
      acceptLabel: 'Aceptar',
      rejectLabel: 'Cancelar',
      acceptButtonStyleClass: 'p-button-outlined p-button-rounded p-button-success',
      rejectButtonStyleClass: 'p-button-outlined p-button-rounded p-button-danger',
      message: mensaje,
      header: 'Confirmar',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.eliminarEmployeeSimple(emp);
      }
    });
  }

  eliminarEmployeeSimple(emp: KgrtEmployeeDto) {
    this.employeeservice.deleteObject(emp.employeevDni).subscribe(
      data => {
        this.employeeDtos = this.employeeDtos.filter(val => val.employeevDni !== emp.employeevDni);
        this.employeeDto = new KgrtEmployeeDto();
        this.appservice.msgDelete();
      }
    );
  }

  hideDialog() {
    this.tipoPlanDialog = false;
    this.submitted = false;
  }


  findIndexById(id: string): number {
    let index = -1;
    for (let i = 0; i < this.employeeDtos.length; i++) {
      if (this.employeeDtos[i].employeevDni === id) {
        index = i;
        break;
      }
    }
    return index;
  }

  createId(): number {
    let id = 0;
    for (var i = 0; i < 5; i++) {
      id += (Math.floor(Math.random()));
    }
    return id;
  }


  exportPdf() {
    const currentDate = new Date();
    const date = formatDate(currentDate, 'yyyy-MM-dd HH:mm:ss', 'en-US');
    // const doc = new jsPDF();
    const doc = new jsPDF('p', 'pt');
    doc['autoTable'](this.exportColumns, this.employeeDtos);
    // doc.autoTable(this.exportColumns, this.products);
    //doc.save(tipoPlanEstudioDTO.name+".pdf");
    doc.save("TiposPlanesEstudio-" + date + ".pdf");
  }

  exportExcel() {
    import("xlsx").then(xlsx => {
      const currentDate = new Date();
      const date = formatDate(currentDate, 'yyyy-MM-dd HH:mm:ss', 'en-US');
      const worksheet = xlsx.utils.json_to_sheet(this.employeeDtos);
      const workbook = {Sheets: {'data': worksheet}, SheetNames: ['data']};
      const excelBuffer: any = xlsx.write(workbook, {bookType: 'xlsx', type: 'array'});
      this.saveAsExcelFile(excelBuffer, "TiposPlanesEstudio-" + date);
    });
  }

  saveAsExcelFile(buffer
                    :
                    any, fileName
                    :
                    string
  ):
    void {
    let EXCEL_TYPE = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';
    let EXCEL_EXTENSION = '.xlsx';
    const data
      :
      Blob = new Blob([buffer], {
      type: EXCEL_TYPE
    });
    FileSaver.saveAs(data, fileName + EXCEL_EXTENSION);
  }


}
