import {Component, ElementRef, HostListener, Renderer2, ViewChild} from '@angular/core';
import {SocialAuthService, SocialUser} from "angularx-social-login";
import {AppService} from "@services/app.service";
import {TokenService} from "@services/token.service";
import {EmployeeService} from "@services/employee.service";
import {UsuarioDto} from "@/dto/UsuarioDto";
import {UserService} from "@services/user.service";
import {KgrtEmployeeDto} from "@/dto/KgrtEmployeeDto";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  userLogged: SocialUser;
  isLogged: boolean;
  userEmployee: KgrtEmployeeDto = new KgrtEmployeeDto();
  userGeneric: UsuarioDto = new UsuarioDto();

  constructor(
    private appService: AppService,
    private authService: SocialAuthService,
    private employeeservice: EmployeeService,
    private userservice: UserService,
    private tokenService: TokenService
  ) {
  }

  ngOnInit(): void {
    //this.user = this.appService.user;
    console.log('TOKEN DESDE LOGIN: ' + this.tokenService.getToken())
    this.authService.authState.subscribe(
      data => {
        this.userLogged = data;
        let userDto = new UsuarioDto();

        userDto.nombresUsuario = this.userLogged.email;

        this.userservice.getById(this.userLogged.email).subscribe(
          user => {
            this.userGeneric = user;
            this.employeeservice.getEmpByUser(this.userGeneric).subscribe(
              emp => {
                this.userEmployee = emp;
                console.log('EMPLOYEE DATA: '+this.userEmployee.employeevDni)
              }
            ), error => {
              this.appService.msgInfoDetail('error', 'Not Found', 'User don´t have Employee Registry')
            };
          }
        );


        this.isLogged = (this.userLogged != null && this.tokenService.getToken() != null);
      }
    );
    console.log('DATOS USUARIO: ' + JSON.stringify(this.userLogged));
  }
}
