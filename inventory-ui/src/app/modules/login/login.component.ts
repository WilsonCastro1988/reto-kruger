import {
  Component,
  OnInit,
  OnDestroy,
  Renderer2,
  HostBinding
} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {AppService} from '@services/app.service';
import {GoogleLoginProvider, SocialAuthService, SocialUser} from "angularx-social-login";
import {TokenDto} from "@/dto/token-dto";
import {Router} from "@angular/router";
import {TokenService} from '../../services/token.service'
import { UsuarioDto } from '@/dto/UsuarioDto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {
  @HostBinding('class') class = 'login-box';
  public loginForm: FormGroup;
  public isAuthLoading = false;
  public isGoogleLoading = false;
  public isFacebookLoading = false;

  socialUser: SocialUser;
  userLogged: SocialUser;
  isLogged: boolean;
  loginUsuario: UsuarioDto;
  roles: string[] = [];



  constructor(
    private renderer: Renderer2,
    private toastr: ToastrService,
    private appService: AppService,
    private authService: SocialAuthService,
    private router: Router,
    private tokenService: TokenService
  ) {
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required)
    });
  }

  async loginByAuth() {
    if (this.loginForm.valid) {
      this.isAuthLoading = true;
     // await this.appService.loginByAuth(this.loginForm.value);
      this.onLogin();
      this.isAuthLoading = false;
    } else {
      this.toastr.error('Form is not valid!');
    }
  }


  onLogin(): void {
    this.loginUsuario = new UsuarioDto();
    this.loginUsuario.nombreUsuario = this.loginForm.value.email;
    this.loginUsuario.password = this.loginForm.value.password;
    this.appService.login(this.loginUsuario).subscribe(
      data => {
        this.isLogged = true;
        this.tokenService.setToken(data.token);
        this.tokenService.setUserName(data.nombreUsuario);
        this.tokenService.setAuthorities(data.authorities);
        this.roles = data.authorities;
        this.toastr.success('Bienvenido ' + data.nombreUsuario, 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/']);
      },
      err => {
        this.isLogged = false;
        let mensaje = {
          status: 'ESTADO SOLICITUD: ' + err.error.status,
          error: 'PROBLEMA: ' + err.error.error
        }
        this.toastr.error(mensaje.error, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        // console.log(err.error.message);
      }
    );
  }

  async loginByGoogle() {
    this.isGoogleLoading = true;
   // await this.appService.loginByGoogle();
    this.isGoogleLoading = false;
  }

  signInWithGoogle(): void {
    this.isGoogleLoading = true;
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then(
      data => {
        this.socialUser = data;
        const tokenGoogle = new TokenDto(this.socialUser.idToken);
        this.appService.loginGoogle(tokenGoogle).subscribe(
          res => {
            this.appService.userLogged = this.socialUser;
            this.tokenService.setToken(res.value);
            this.isLogged = true;
            this.isGoogleLoading = false;
            this.router.navigate(['/']);
          },
          err => {
            console.log(err);
            this.logOut();
          }
        );
      }
    ).catch(
      err => {
        console.log(err);
      }
    );
  }

  logOut(): void {
    this.authService.signOut().then(
      data => {
        this.isGoogleLoading = false;
        this.tokenService.logOut();
        this.isLogged = false;
      }
    );
  }

  async loginByFacebook() {
    this.isFacebookLoading = true;
   // await this.appService.loginByFacebook();
    this.isFacebookLoading = false;
  }

  ngOnDestroy() {
    this.renderer.removeClass(
      document.querySelector('app-root'),
      'login-page'
    );
  }
}
