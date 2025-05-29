import { Component, inject, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import {
  ISavingsAccount,
  ISavingsAccountTransaction,
} from 'src/app/services/interfaces/ISavingsAccount';
import { SavingsAccountService } from 'src/app/services/savings-account/savings-account.service';

@Component({
  selector: 'app-savings-account-details',
  templateUrl: './savings-account-details.component.html',
  styleUrls: ['./savings-account-details.component.scss'],
})
export class SavingsAccountDetailsComponent {
  activeModal = inject(NgbActiveModal);
  @Input() account: ISavingsAccount = {} as ISavingsAccount;
  savingsTransactions: ISavingsAccountTransaction[] = [];
  constructor(private savingsAccountService: SavingsAccountService) {}

  ngOnInit() {
    this.getSavingsAccountTransactions();
  }

  getSavingsAccountTransactions() {
    this.savingsAccountService
      .getSavingsAccountTransactions(this.account.savingsAccountNumber)
      .subscribe(
        (response) => {
          this.savingsTransactions = response.data;
        },
        (errorResp) => {
          console.log(errorResp);
        }
      );
  }
}
