import {Component, OnInit} from '@angular/core';
import {AppService} from '@services/app.service';
import {SocialAuthService, SocialUser} from "angularx-social-login";
import {TokenService} from "@services/token.service";
import {MenuItem} from "primeng/api";
import {MenuService} from "@services/menu.service";
import {forEach} from "@angular-devkit/schematics";

@Component({
  selector: 'app-menu-sidebar',
  templateUrl: './menu-sidebar.component.html',
  styleUrls: ['./menu-sidebar.component.scss']
})
export class MenuSidebarComponent implements OnInit {
  userLogged: SocialUser;
  isLogged: boolean;

  items: MenuItem[];
  menus: any;


  constructor(public appService: AppService,
              public menuService: MenuService,
              private authService: SocialAuthService,
              private tokenService: TokenService) {
  }

  ngOnInit() {
    this.verificarUsuario();
    this.llenarMenus();
  }


  //TODO: traer los menus por aplicacicion y perfil + permiso

  verificarUsuario() {

    this.authService.authState.subscribe(
      data => {
        this.userLogged = data;
        this.isLogged = (this.userLogged != null && this.tokenService.getToken() != null);
      }
    );
  }

  llenarMenus() {
    //this.menus = this.appService.getMenuByUsername();

    this.menuService.findByUsername(this.userLogged.email).subscribe(
      data => {
        this.menus = data;

        this.items = new Array();
        for (let objMenu of this.menus) {
          let item: MenuItem;
          item = {
            label: objMenu.itemDTO.label,
            icon: objMenu.itemDTO.icon,
            url: objMenu.itemDTO.url,
            routerLink: objMenu.itemDTO.routerLink,
            items: objMenu.itemsDTO
          }
          this.items.push(item);
        }
      }
    );


  }
}
