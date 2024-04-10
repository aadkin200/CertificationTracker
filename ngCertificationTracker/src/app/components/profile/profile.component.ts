import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.scss',
})
export class ProfileComponent implements OnInit {
  constructor(
    private auth: AuthService,
    private router: Router,
    private userServ: UserService
  ) {}

  loginUser: User = new User();

  ngOnInit(): void {
    this.loadUser();
    //throw new Error('Method not implemented.');
    console.log(this.loginUser.firstName);
  }

  loadUser() {
    this.userServ.getUser().subscribe(
      (user) => {
        this.loginUser = user;
        console.log('USER IN LOAD USER AFTER CALL' + this.loginUser.firstName);
      },
      (noUsers) => {
        console.log('Error gettings users from service');
        console.log(noUsers);
      }
    );
    // console.log(this.loginUser);
  }

  loadUserTest() {
    console.log(this.loginUser.firstName + 'test');
  }
}
