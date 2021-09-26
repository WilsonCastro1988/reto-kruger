import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmailService {
  constructor(private http: HttpClient) {
  }

  url = `${environment.HOST}/`;
  endpoint: string = 'email';

  sendEmail(obj): Observable<any> {
    return this.http.post(this.url + this.endpoint + '/send', obj);
  }

  sendTemplateEmail(obj): Observable<any> {
    return this.http.post(this.url + this.endpoint + '/send-html', obj);
  }
}
