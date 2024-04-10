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
    return this.http.post<User>(this.baseUrl + 'api/auth/signin', user).pipe(
      tap((res) => {
        this.setSession(res);
      })
    );
  }

  newUser(user: User) {
    return this.http.post<User>(this.baseUrl + 'api/auth/signup', user).pipe(
      tap((res) => {
        this.setSession(res);
      })
    );
  }

  private setSession(authResult: any) {
    localStorage.setItem('id_token', authResult.accessToken);
    localStorage.setItem('username', authResult.username);
    localStorage.setItem('admin', authResult.admin);
    localStorage.setItem('role', authResult.role);
    let key = localStorage.getItem('id_token');
  }

  logout() {
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
    localStorage.removeItem('username');
    localStorage.removeItem('admin');
    localStorage.removeItem('role');
  }

  public checkLogin() {
    if (localStorage.getItem('id_token')) {
      return true;
    }
    return false;
  }

}
