import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { LoginDto } from 'src/app/dto/login-dto';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loginForm: FormGroup;
  private hide: boolean;

  constructor( private formBuilder: FormBuilder, private userService: UserService,
               private snackBar: MatSnackBar, private router: Router ) { }

  ngOnInit() {
    this.hide = true;
    this.loginForm = this.formBuilder.group({
      username: ['', [
        Validators.required
      ]],
      password: ['', [
        Validators.required,
      ]]
    });
  }

  get username() { return this.loginForm.controls.username.value as string; }
  get password() { return this.loginForm.controls.password.value as string; }


  onLogInSubmit() {
    const dto: LoginDto = new LoginDto(this.username, this.password);
    this.userService.login(dto).subscribe(
      (response => {
        if (response != null) {
          localStorage.setItem('token', response.token);
          const jwt: JwtHelperService = new JwtHelperService();
          const info = jwt.decodeToken(response.token);
          const role = info.role[0].authority;
          localStorage.setItem('role', info.role[0].authority);
          this.snackBar.open('Well done');
        } else {
          this.snackBar.open('Bad Credentials');
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }


}
