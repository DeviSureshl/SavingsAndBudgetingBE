import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ISavingsAccount } from 'src/app/services/interfaces/ISavingsAccount';
import { AddSavingsAccountComponent } from '../add-savings-account/add-savings-account.component';
import { SavingsAccountDetailsComponent } from '../savings-account-details/savings-account-details.component';

@Component({
  selector: 'app-savings-summary',
  templateUrl: './savings-summary.component.html',
  styleUrls: ['./savings-summary.component.scss'],
})
export class SavingsSummaryComponent {
  @Input() accounts: ISavingsAccount[] = [];
  @Input() userId: string = '';
  @Output() onSavingsAccountCreation = new EventEmitter();
  private modalService = inject(NgbModal);

  addSavingsAccount() {
    const modalRef = this.modalService.open(AddSavingsAccountComponent);
    modalRef.componentInstance.userId = this.userId;

    modalRef.result.then(
      (result) => {
        console.log(result);
      },
      (res) => {
        this.onSavingsAccountCreation.emit();
      }
    );
  }

  showSavingsDetails(account: ISavingsAccount) {
    const modalRef = this.modalService.open(SavingsAccountDetailsComponent, {
      size: 'lg',
    });
    modalRef.componentInstance.account = account;
  }
}
