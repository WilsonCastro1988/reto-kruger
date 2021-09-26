import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from '@/app-routing.module';
import {AppComponent} from './app.component';
import {MainComponent} from '@modules/main/main.component';
import {LoginComponent} from '@modules/login/login.component';
import {HeaderComponent} from '@modules/main/header/header.component';
import {FooterComponent} from '@modules/main/footer/footer.component';
import {MenuSidebarComponent} from '@modules/main/menu-sidebar/menu-sidebar.component';
import {BlankComponent} from '@pages/blank/blank.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ProfileComponent} from '@pages/profile/profile.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RegisterComponent} from '@modules/register/register.component';
import {DashboardComponent} from '@pages/dashboard/dashboard.component';
import {ToastrModule} from 'ngx-toastr';
import {MessagesDropdownMenuComponent} from '@modules/main/header/messages-dropdown-menu/messages-dropdown-menu.component';
import {NotificationsDropdownMenuComponent} from '@modules/main/header/notifications-dropdown-menu/notifications-dropdown-menu.component';
import {AppButtonComponent} from './components/app-button/app-button.component';

import {registerLocaleData} from '@angular/common';
import localeEn from '@angular/common/locales/en';
import {UserDropdownMenuComponent} from '@modules/main/header/user-dropdown-menu/user-dropdown-menu.component';
import {ForgotPasswordComponent} from '@modules/forgot-password/forgot-password.component';
import {RecoverPasswordComponent} from '@modules/recover-password/recover-password.component';
import {LanguageDropdownComponent} from '@modules/main/header/language-dropdown/language-dropdown.component';
import {PrivacyPolicyComponent} from './modules/privacy-policy/privacy-policy.component';
import {PrimengModule} from './primeng/primeng.module';
import {MessageService} from 'primeng/api';
import {ConfirmationService} from 'primeng/api';
import {generalInterceptor} from "@/interceptor/general.interceptor";
import {
  FacebookLoginProvider,
  GoogleLoginProvider,
  SocialAuthServiceConfig,
  SocialLoginModule
} from 'angularx-social-login';
import {FullCalendarModule} from "@fullcalendar/angular";
import dayGridPlugin from "@fullcalendar/daygrid"
import interactionPlugin from '@fullcalendar/interaction';
import timeGridPlugin from '@fullcalendar/timegrid';
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {HttpClient} from '@angular/common/http';
import { EmployeeComponent } from './pages/employee/employee.component';
import { EmployeeTableComponent } from './pages/employee/employee-table/employee-table.component';


export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

FullCalendarModule.registerPlugins([
  dayGridPlugin,
  timeGridPlugin,
  interactionPlugin
]);

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    MenuSidebarComponent,
    BlankComponent,
    ProfileComponent,
    RegisterComponent,
    DashboardComponent,
    MessagesDropdownMenuComponent,
    NotificationsDropdownMenuComponent,
    AppButtonComponent,
    UserDropdownMenuComponent,
    ForgotPasswordComponent,
    RecoverPasswordComponent,
    LanguageDropdownComponent,
    PrivacyPolicyComponent,
    EmployeeComponent,
    EmployeeTableComponent,
  ],
  imports: [
    SocialLoginModule,
    PrimengModule,
    BrowserModule,
    FullCalendarModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 3000,
      positionClass: 'toast-bottom-right',
      preventDuplicates: true
    }),
    FormsModule,
  ],
  providers: [MessageService,
    ConfirmationService,
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '1023984850599-fjapi7oahth1q4o7b4nr8fre0apui80d.apps.googleusercontent.com'
            ),
          },
          {
            id: FacebookLoginProvider.PROVIDER_ID,
            provider: new FacebookLoginProvider('184557725491466'),
          },
        ],
      } as SocialAuthServiceConfig,
    },
    generalInterceptor,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
