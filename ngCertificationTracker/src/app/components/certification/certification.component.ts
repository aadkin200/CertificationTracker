import { Component, OnInit } from '@angular/core';
import { Certification } from '../../models/certification';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { CertificationService } from '../../services/certification.service';
import { User } from '../../models/user';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-certification',
  templateUrl: './certification.component.html',
  styleUrl: './certification.component.scss',
})
export class CertificationComponent implements OnInit {
  userCerts: Certification[] = [];
  loginUser: User = new User();
  newCert: Certification = new Certification();
  newForm = false;

  constructor(
    private auth: AuthService,
    private userServ: UserService,
    private router: Router,
    private certServ: CertificationService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.loadUser();
    //throw new Error('Method not implemented.');
  }

  loadUser() {
    this.userServ.getUser().subscribe(
      (user) => {
        this.loginUser = user;
        this.userCerts = user.certifications;
      },
      (noUsers) => {
        console.log('Error gettings users from service');
        console.log(noUsers);
      }
    );
  }

  createCertification() {
    console.log(this.newCert.company);
    this.certServ.newCertification(this.newCert).subscribe(
      (data) => {
        this.newCert = data;
        location.reload();
      },
      (fail) => {
        this.router.navigateByUrl('/certifications');
        location.reload();
        console.error(
          'Error in certification component -- createCertification()'
        );
      }
    );
  }

  flipForm() {
    this.newForm = this.newForm = true;
  }

  flipFormOff() {
    this.newForm = this.newForm = false;
  }

}
