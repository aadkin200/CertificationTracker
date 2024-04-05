import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { User } from '../models/user';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient, private router: Router) {}
  login(username: string, password: string) {
    var user = new User();
    user.username = username;
    user.password = password;
    console.log('made it to auth.login');
    console.log(username + 'auth.login email---------------------------');
    console.log(
      password + 'auth.login password-------------------------------'
    );
    console.log(
      'rest api pinged ===================================================' +
        this.baseUrl +
        'api/auth/signin'
    );
    return this.http.post<User>(this.baseUrl + 'api/auth/signin', user).pipe(
      tap((res) => {
        console.log('before set session');
        this.setSession(res);
        console.log('after set session');
        console.log(res);
      })
    );
  }

  private setSession(authResult: any) {
    //const expiresAt = moment().add(authResult.expiresIn, 'second');
    console.log('setSession------------------------------------------');
    console.log(authResult.accessToken);
    //console.log(authResult.expiresIn);

    localStorage.setItem('id_token', authResult.accessToken);
    //localStorage.setItem('expires_at', JSON.stringify(authResult.expiresIn));
    let key = localStorage.getItem('id_token');
    //console.log(key + '-----------keyyyyyyyyyyyyyyyyyyy');
  }

  logout() {
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
  }

  public isLoggedIn() {
    //return moment().isBefore(this.getExpiration());
  }

  public checkLogin() {
    if (localStorage.getItem('id_token')) {
      return true;
    }
    return false;
  }

  isLoggedOut() {
    //return !this.isLoggedIn();
  }

  getExpiration() {
    //const expiration = localStorage.getItem('expires_at');
    //const expiresAt = JSON.parse(expiration);
    //return moment(expiresAt);
  }
}
