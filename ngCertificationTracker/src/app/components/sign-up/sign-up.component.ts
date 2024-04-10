import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { CertificationService } from '../../services/certification.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.scss',
})
export class SignUpComponent implements OnInit {
  signupUser: User = new User();

  constructor(
    private auth: AuthService,
    private userServ: UserService,
    private router: Router,
    private certServ: CertificationService
  ) {}

  ngOnInit(): void {
    //throw new Error('Method not implemented.');
  }

  signup() {
    console.log(
      this.signupUser.firstName +
        ' firstname in signup method------------beginning'
    );
    this.auth.newUser(this.signupUser).subscribe(
      (loggedIn) => {
        this.auth
          .login(this.signupUser.username, this.signupUser.password)
          .subscribe(
            (login) => {
              this.router.navigateByUrl('/certifications');
            },
            (fail) => {
              this.router.navigateByUrl('home/sign-up');
              console.log(loggedIn.username + loggedIn.password);
              console.error('error logging in');
            }
          );
      },
      (fail) => {
        this.router.navigateByUrl('/home/sign-up');
        console.error('error signing up');
      }
    );
  }
}
