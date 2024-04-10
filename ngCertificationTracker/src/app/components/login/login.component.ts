import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent implements OnInit {
  loginUser: User = new User();
  selected: User | null = null;

  constructor(private auth: AuthService, private router: Router) {}

  ngOnInit(): void {}

  login(user: User) {
    // {
    //   "entry": "server.ts"  --ssr
    // }
    console.log(user.username);
    console.log(user.password);
    this.auth.login(user.username, user.password).subscribe(
      (loggedIn) => {
        console.log(
          'login method of login component----' +
            localStorage.getItem('id_token')
        );
        console.log('LoginComponet.login(): user logged in');
        //this.loginUser = loggedIn;
        this.router.navigateByUrl('/certifications');
      },
      (fail) => {
        this.router.navigateByUrl('/home');
        console.error('error in login.component.ts login()qqq');
      }
    );
  }

  loggedIn(): boolean {
    return this.auth.checkLogin();
  }
}
