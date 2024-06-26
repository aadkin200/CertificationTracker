import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Certification } from '../models/certification';
import { environment } from '../../environments/environment';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class CertificationService {
  baseUrl = environment.baseUrl;
  newCert: Certification = new Certification();
  deleteCert: Certification = new Certification();

  constructor(private auth: AuthService, private http: HttpClient) {}

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

  newCertification(cert: Certification) {
    console.log(cert.company + '-------Company in service----------------');
    return this.http
      .post<Certification>(
        this.baseUrl +
          'api/private/certification/certs/' +
          localStorage.getItem('username'),
        cert
      )
      .pipe(
        tap((res) => {
          this.newCert = res;
        })
      );
  }

  destroy(cert: Certification) {
    return this.http
      .put<Certification>(
        this.baseUrl + 'api/private/certification/cert/',
        cert
      )
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('error deleting');
        })
      );
  }

  update(cert: Certification) {
    console.log('in service now---');
    console.log(cert);
    return this.http
      .put<Certification>(
        this.baseUrl + 'api/private/certification/cert/cert',
        cert
      )
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('error updating');
        })
      );
  }
}
