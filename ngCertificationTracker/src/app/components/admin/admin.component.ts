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
  editedId = -1;

  edited: User = new User();

  constructor(
    private auth: AuthService,
    private userServ: UserService,
    private router: Router,
    private certServ: CertificationService
  ) {}

  ngOnInit(): void {
    this.loadUsers();
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


  assignEditId(num: number) {
    this.editedId = num;
  }

  defaultValueEdit() {
    this.editedId = -1;
  }

  updateRole(user: User) {
    console.log(user);
    this.userServ.update(user).subscribe(
      data=>{
        this.defaultValueEdit();
        this.loadUsers();
      },
      error=>{
        console.error(error);
        console.error('error updating user through service');
      }
    )

  }

}
