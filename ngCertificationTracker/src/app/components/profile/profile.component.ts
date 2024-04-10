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
    console.log(this.loginUser.firstName);
  }

  loadUser() {
    this.userServ.getUser().subscribe(
      (user) => {
        this.loginUser = user;
      },
      (noUsers) => {
        console.log('Error gettings users from service');
      }
    );
  }
}
