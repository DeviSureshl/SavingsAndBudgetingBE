import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../services/api/api.service';
import { Router } from '@angular/router';
import { IAuthenticationResponse } from '../services/interfaces/IAuthentication';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  loginForm: FormGroup;
  isFormSubmitted: boolean = false;
  authenticationFailed = false;

  constructor(
    private formBuilder: FormBuilder,
    private apiService: ApiService,
    private router: Router
  ) {
    this.loginForm = this.formBuilder.group({
      emailId: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }
  onSubmit() {
    this.isFormSubmitted = true;
    console.log(this.loginForm.value);
    if (this.loginForm.valid) {
      this.apiService
        .authenticateUser(
          this.loginForm.value.emailId,
          this.loginForm.value.password
        )
        .subscribe(
          (response: IAuthenticationResponse) => {
            this.authenticationFailed = false;
            if (response.data.isAdmin) {
              this.router.navigate(['/admin-dashboard', response.data.userId]);
            } else {
              this.router.navigate(['/user-dashboard', response.data.userId]);
            }
          },
          (error) => {
            this.authenticationFailed = true;
          }
        );
    }
  }
}
