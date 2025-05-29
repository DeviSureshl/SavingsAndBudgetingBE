import { Component, inject, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AccountService } from 'src/app/services/account/account.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.scss'],
})
export class AddAccountComponent {
  activeModal = inject(NgbActiveModal);
  errorMessage: string = '';
  addNewAccountForm: FormGroup;
  isFormSubmitted = false;
  @Input() userId: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private accountService: AccountService
  ) {
    this.addNewAccountForm = this.formBuilder.group({
      accountType: ['', Validators.required],
      balance: [null, Validators.required],
    });
  }
  addNewAccount() {
    this.isFormSubmitted = true;
    console.log(this.addNewAccountForm.value);
    //userId;
    if (this.addNewAccountForm.valid) {
      this.accountService
        .addNewAccount(
          this.userId,
          this.addNewAccountForm.value.accountType,
          this.addNewAccountForm.value.balance
        )
        .subscribe(
          (response) => {
            this.activeModal.dismiss();
            console.log(response);
          },
          (errorResp) => {
            console.log(errorResp);
          }
        );
    }
  }
}
