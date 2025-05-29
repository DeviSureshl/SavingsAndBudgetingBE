import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../services/api/api.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss'],
})
export class RegisterUserComponent {
  registerUserForm: FormGroup;
  isFormSubmitted = false;
  showPassword = false;
  apiErrorMessage: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private apiService: ApiService,
    private location: Location
  ) {
    this.registerUserForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      password: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
      gender: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }

  onSubmit() {
    this.isFormSubmitted = true;
    if (this.registerUserForm.valid) {
      this.apiService.registerUser(this.registerUserForm.value).subscribe(
        (response) => {
          this.apiErrorMessage = '';
          alert('user added successfully');
          this.goBack();
        },
        (errorResp) => {
          this.apiErrorMessage = errorResp.message;
        }
      );
    }
  }

  togglePassword() {
    this.showPassword = !this.showPassword;
  }
  goBack() {
    this.location.back();
  }
}
