import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { CertificationService } from '../../services/certification.service';
import { Certification } from '../../models/certification';

@Component({
  selector: 'app-user-feed',
  templateUrl: './user-feed.component.html',
  styleUrl: './user-feed.component.scss',
})
export class UserFeedComponent implements OnInit {
  users: User[] = [];
  viewUsers: User[] = [];

  certs: Certification[] = [];
  viewCerts: Certification[] = [];

  constructor(
    private auth: AuthService,
    private userServ: UserService,
    private router: Router,
    private certServ: CertificationService
  ) {}

  ngOnInit(): void {
    this.loadUsers();
    console.log('end of nginit' + this.users);
    //console.log(this.viewUsers);
  }

  // ngOnInit(): void {
  //   this.loadUsers();
  //   console.log('end of nginit' + this.users);
  //   console.log(this.viewUsers);
  // }

  loadUsers() {
    this.userServ.getUsers().subscribe(
      (users) => {
        this.users = users;
        this.viewUsers = this.users.map((x) => x);
        console.log(this.viewUsers[0]);
      },
      (noUsers) => {
        console.log('Error gettings users from service');
        console.log(noUsers);
      }
    );
    this.loadCerts();
  }

  loadCerts() {
    this.certServ.getCerts().subscribe(
      (certs) => {
        this.certs = certs;
        this.viewCerts = this.certs.map((x) => x);
      },
      (noUsers) => {
        console.log('Error gettings users from service');
        console.log(noUsers);
      }
    );
  }

  certAssign() {}
}
