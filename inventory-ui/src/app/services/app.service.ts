import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {GoogleLoginProvider, SocialAuthService, SocialUser} from "angularx-social-login";
import {TokenService} from "@services/token.service";
import {MenuItem, MessageService} from "primeng/api";
import {MenuService} from "@services/menu.service";
import {TokenDto} from "@/dto/token-dto";
import { UsuarioDto } from '@/dto/UsuarioDto';
import {JwtDTO} from "@/dto/jwt-dto";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  url = `${environment.HOST}/oauth`;

  userLogged: SocialUser;
  isLogged: boolean;

  items: MenuItem[];
  menus: any;


  constructor(private router: Router,
              private toastr: ToastrService,
              private http: HttpClient,
              private messageService: MessageService,
              private authService: SocialAuthService,
              public menuService: MenuService,
              private tokenService: TokenService) {
  }

  public login(loginUsuario: UsuarioDto): Observable<JwtDTO> {
    return this.http.post<JwtDTO>(this.url + '/login', loginUsuario);
  }

  loginGoogle(tokenDTO): Observable<any> {
    return this.http.post(this.url + '/google', tokenDTO);
  }


  getMenuByUsername() {
    this.menuService.findByUsername(this.userLogged.email).subscribe(
      data => {
        this.menus = data;
        for (let objMenu of this.menus) {
          let item: MenuItem;
          item = {
            label: objMenu.itemDTO.label,
            icon: objMenu.itemDTO.icon,
            url: objMenu.itemDTO.url,
            routerLink: objMenu.routerLink,
            items: objMenu.itemsDTO
          }
          this.items = new Array();
          this.items.push(item);
        }
      }
    );
    return this.items;
  }


  /*
  async loginByAuth({email, password}) {
    try {
      const token = await Gatekeeper.loginByAuth(email, password);
      localStorage.setItem('token', token);
      await this.getProfile();
      this.router.navigate(['/']);
    } catch (error) {
      this.toastr.error(error.response.data.message);
    }
  }

  async registerByAuth({email, password}) {
    try {
      const token = await Gatekeeper.registerByAuth(email, password);
      localStorage.setItem('token', token);
      await this.getProfile();
      this.router.navigate(['/']);
    } catch (error) {
      this.toastr.error(error.response.data.message);
    }
  }


  async loginByGoogle() {
    try {
      const token = await Gatekeeper.loginByGoogle();
      localStorage.setItem('token', token);
      await this.getProfile();
      this.router.navigate(['/']);
    } catch (error) {
      this.toastr.error(error.response.data.message);
    }
  }

  async registerByGoogle() {
    try {
      const token = await Gatekeeper.registerByGoogle();
      localStorage.setItem('token', token);
      await this.getProfile();
      this.router.navigate(['/']);
    } catch (error) {
      this.toastr.error(error.response.data.message);
    }
  }

  async loginByFacebook() {
    try {
      const token = await Gatekeeper.loginByFacebook();
      localStorage.setItem('token', token);
      await this.getProfile();
      this.router.navigate(['/']);
    } catch (error) {
      this.toastr.error(error.response.data.message);
    }
  }

  async registerByFacebook() {
    try {
      const token = await Gatekeeper.registerByFacebook();
      localStorage.setItem('token', token);
      await this.getProfile();
      this.router.navigate(['/']);
    } catch (error) {
      this.toastr.error(error.response.data.message);
    }
  }

*/
  msgCreate() {
    this.messageService.add({severity: 'success', summary: 'Success', detail: 'Data Created'});
  }

  msgUpdate() {
    this.messageService.add({severity: 'warn', summary: 'Success', detail: 'Data Updated'});
  }

  msgDelete() {
    this.messageService.add({severity: 'error', summary: 'Delete', detail: 'Data Deleted'});
  }
  msgInfo() {
    this.messageService.add({severity: 'info', summary: 'Delete', detail: 'Data Deleted'});
  }

  msgInfoDetail(severity:string, header:string, content:string) {
    this.messageService.add({severity: severity, summary: header, detail: content});
  }

  async getProfile() {
    try {
      console.log('USERLOGGED: ' + this.userLogged)
      if (this.userLogged == undefined) {
        this.logout();
      } else {
        return this.userLogged;
      }
    } catch (error) {
      this.logout();
      throw error;
    }
  }


  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('gatekeeper_token');
    this.userLogged = null;
    this.isLogged = false;
    this.router.navigate(['/login']);
  }
}
