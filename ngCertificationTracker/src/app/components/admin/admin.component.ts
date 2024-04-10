import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { CertificationService } from '../../services/certification.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss',
})
export class AdminComponent implements OnInit {
  users: User[] = [];
  viewUsers: User[] = [];

  constructor(
    private auth: AuthService,
    private userServ: UserService,
    private router: Router,
    private certServ: CertificationService
  ) {}

  ngOnInit(): void {
    this.loadUsers();
    throw new Error('Method not implemented.');
  }

  loadUsers() {
    this.userServ.getUsers().subscribe(
      (users) => {
        this.users = users;
        this.viewUsers = this.users.map((x) => x);
      },
      (noUsers) => {
        console.error(noUsers + 'error getting users');
      }
    );
  }
}
