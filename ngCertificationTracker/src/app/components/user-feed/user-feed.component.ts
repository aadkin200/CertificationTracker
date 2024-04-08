import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-feed',
  templateUrl: './user-feed.component.html',
  styleUrl: './user-feed.component.css',
})
export class UserFeedComponent implements OnInit {
  users: User[] = [];
  viewUsers: User[] = [];

  constructor(
    private auth: AuthService,
    private userServ: UserService,
    private router: Router
  ) {}

  
  ngOnInit(): void {
    this.loadUsers();
    console.log('end of nginit' + this.users);
    console.log(this.viewUsers);
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
        console.log(users + 'users----------');
        console.log(this.viewUsers + 'viewUsers---------------------');
      },
      (noUsers) => {
        console.log('Error gettings users from service');
        console.log(noUsers);
      }
    );
  }
}
