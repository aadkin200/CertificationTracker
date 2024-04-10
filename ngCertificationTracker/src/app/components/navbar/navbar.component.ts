import { Component, OnDestroy, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss',
})
export class NavbarComponent implements OnInit, OnDestroy {
  user: User = new User();

  constructor(
    private auth: AuthService,
    private router: Router,
    private userServ: UserService
  ) {}
  ngOnDestroy(): void {
    this.user = new User();
    //throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.getUser();
    console.log('end of navbar init');
    this.user = new User();
  }

  loggedIn(): boolean {
    return this.auth.checkLogin();
  }

  logout() {
    this.auth.logout();
  }

  isAdmin(): boolean {
    if (localStorage.getItem('admin') === 'true') {
      return true;
    } else {
      return false;
    }
  }

  isStaff(): boolean {
    if (localStorage.getItem('role') === 'Staff') {
      return true;
    } else {
      return false;
    }
  }

  isStudent(): boolean {
    if (localStorage.getItem('role') === 'Student') {
      return true;
    } else {
      return false;
    }
  }

  getUser() {
    if (this.loggedIn()) {
      this.userServ.getUser().subscribe(
        (user) => {
          this.user = user;
          console.log('finished getting user');
        },
        (fail) => {
          console.error('failed getting user');
          return null;
        }
      );
    }
  }
}
