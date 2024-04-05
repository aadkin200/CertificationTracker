import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) {}

  login(email: string, password: string) {
    return this.http
      .post<User>('/api/auth/signin', { email, password })
      .pipe(tap((res) => this.setSession));
  }

  private setSession(authResult: any) {
    //const expiresAt = moment().add(authResult.expiresIn, 'second');

    localStorage.setItem('id_token', authResult.idToken);
    localStorage.setItem('expires_at', JSON.stringify(authResult.expiresIn));
  }

  logout() {
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
  }

  public isLoggedIn() {
    //return moment().isBefore(this.getExpiration());
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
