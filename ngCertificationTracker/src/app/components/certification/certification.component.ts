import { Component, OnInit } from '@angular/core';
import { Certification } from '../../models/certification';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { CertificationService } from '../../services/certification.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-certification',
  templateUrl: './certification.component.html',
  styleUrl: './certification.component.scss',
})
export class CertificationComponent implements OnInit {
  userCerts: Certification[] = [];
  loginUser: User = new User();

  constructor(
    private auth: AuthService,
    private userServ: UserService,
    private router: Router,
    private certServ: CertificationService
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
        //console.log('USER IN LOAD USER AFTER CALL' + this.loginUser.firstName);
      },
      (noUsers) => {
        console.log('Error gettings users from service');
        console.log(noUsers);
      }
    );
    // console.log(this.loginUser);
  }
}
