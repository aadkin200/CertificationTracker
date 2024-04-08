import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Certification } from '../models/certification';
import { environment } from '../../environments/environment';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class CertificationService {
  constructor(private auth: AuthService, private http: HttpClient) {}
  baseUrl = environment.baseUrl;

  getCerts(): Observable<Certification[]> {
    return this.http
      .get<Certification[]>(`${this.baseUrl}api/private/certification/certs`)
      .pipe(
        catchError((err: any) => {
          console.error(`Certification.getCerts(): error GET certs`);
          return throwError(err);
        })
      );
  }
}
