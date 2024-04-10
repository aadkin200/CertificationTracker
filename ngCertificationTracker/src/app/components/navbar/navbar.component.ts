import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss',
})
export class NavbarComponent {
  constructor(private auth: AuthService, private router: Router) {}

  loggedIn(): boolean {
    return this.auth.checkLogin();
  }

  logout() {
    this.auth.logout();
  }
}
