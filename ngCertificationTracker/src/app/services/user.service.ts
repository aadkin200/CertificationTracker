import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable, catchError, throwError } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private auth: AuthService, private http: HttpClient) {}

  baseUrl = environment.baseUrl;

  getJWTToken() {
    return localStorage.getItem('id_token');
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}api/private/users`).pipe(
      catchError((err: any) => {
        console.error(`User.getAllUser: error GET users`);
        return throwError(err);
      })
    );
  }

  getUser(): Observable<User> {
    return this.http
      .get<User>(
        `${this.baseUrl}api/private/user/${localStorage.getItem('username')}`
      )
      .pipe(
        catchError((err: any) => {
          console.error('User.getUser: error Get user');
          return throwError(err);
        })
      );
  }


  update(user: User):Observable<User>{
    return this.http.put<User>(this.baseUrl + 'api/private/user', user).pipe(
      catchError((err:any) =>{
        console.error('User.update: error updating user');
        return throwError(err);
      })
    )
  }

}
