import { Component, inject, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { SavingsAccountService } from 'src/app/services/savings-account/savings-account.service';

@Component({
  selector: 'app-add-savings-account',
  templateUrl: './add-savings-account.component.html',
  styleUrls: ['./add-savings-account.component.scss'],
})
export class AddSavingsAccountComponent {
  activeModal = inject(NgbActiveModal);
  errorMessage: string = '';
  addSavingsAccountForm: FormGroup;
  isFormSubmitted = false;
  @Input() userId: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private savingsAccountService: SavingsAccountService
  ) {
    this.addSavingsAccountForm = this.formBuilder.group({
      goalName: ['', Validators.required],
      targetAmount: [null, Validators.required],
      currentAmount: [null, Validators.required],
      targetDate: [null, Validators.required],
    });
  }

  addSavingsAccount() {
    this.isFormSubmitted = true;
    if (this.addSavingsAccountForm.valid) {
      this.savingsAccountService
        .addSavingsAccount(
          this.userId,
          this.addSavingsAccountForm.value.goalName,
          this.addSavingsAccountForm.value.targetAmount,
          this.addSavingsAccountForm.value.currentAmount,
          this.addSavingsAccountForm.value.targetDate
        )
        .subscribe(
          (response) => {
            this.activeModal.dismiss();
            console.log(response);
          },
          (errorResp) => {
            console.log(errorResp);
            this.errorMessage = 'Account creation failed';
          }
        );
    }
  }
}
