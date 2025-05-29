import { Component, inject, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { IAccount } from 'src/app/services/interfaces/IAccount';
import { ISavingsAccount } from 'src/app/services/interfaces/ISavingsAccount';
import { TransactionService } from 'src/app/services/transaction/transaction.service';

@Component({
  selector: 'app-add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.scss'],
})
export class AddTransactionComponent {
  activeModal = inject(NgbActiveModal);
  errorMessage: string = '';
  addNewTransactionForm: FormGroup;
  isFormSubmitted = false;
  @Input() userId: string = '';
  @Input() accountList: IAccount[] = [];
  @Input() savingsAccountList: ISavingsAccount[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private transactionService: TransactionService
  ) {
    this.addNewTransactionForm = this.formBuilder.group({
      accountNumber: ['', Validators.required],
      transactionType: ['', Validators.required],
      transactionAmount: [null, Validators.required],
      transactionDate: [null, Validators.required],
      savingsAccountNumber: '',
    });
  }

  addNewTransaction() {
    this.isFormSubmitted = true;
    if (this.addNewTransactionForm.valid) {
      this.transactionService
        .addNewTransaction(
          this.userId,
          this.addNewTransactionForm.value.accountNumber,
          this.addNewTransactionForm.value.transactionType,
          this.addNewTransactionForm.value.transactionDate,
          this.addNewTransactionForm.value.transactionAmount,
          this.addNewTransactionForm.value.savingsAccountNumber
        )
        .subscribe(
          (response) => {
            this.activeModal.dismiss();
            console.log(response);
          },
          (errorResp) => {
            console.log(errorResp);
            this.errorMessage = 'Insufficient balance';
          }
        );
    }
  }

  onTransactionTypeSelected() {
    const selectedTransactionType =
      this.addNewTransactionForm.controls['transactionType'].value;
    if (selectedTransactionType === 'INVESTMENT') {
      this.addNewTransactionForm.controls['savingsAccountNumber'].addValidators(
        Validators.required
      );
    } else {
      this.addNewTransactionForm.controls[
        'savingsAccountNumber'
      ].clearValidators();
    }
    this.addNewTransactionForm.controls[
      'savingsAccountNumber'
    ].updateValueAndValidity();
  }
}
