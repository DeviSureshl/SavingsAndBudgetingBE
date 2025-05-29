import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ITransaction } from 'src/app/services/interfaces/ITransaction';
import { AddTransactionComponent } from '../add-transaction/add-transaction.component';
import { IAccount } from 'src/app/services/interfaces/IAccount';
import { ISavingsAccount } from 'src/app/services/interfaces/ISavingsAccount';

@Component({
  selector: 'app-transaction-summary',
  templateUrl: './transaction-summary.component.html',
  styleUrls: ['./transaction-summary.component.scss'],
})
export class TransactionSummaryComponent {
  @Input() userId: string = '';
  @Input() transactionList: ITransaction[] = [];
  @Input() accountList: IAccount[] = [];
  @Input() savingsAccountList: ISavingsAccount[] = [];
  @Output() onTransactionCreation = new EventEmitter();
  private modalService = inject(NgbModal);

  constructor() {}
  ngOnInit(): void {}

  addTransaction() {
    const modalRef = this.modalService.open(AddTransactionComponent);
    modalRef.componentInstance.userId = this.userId;
    modalRef.componentInstance.accountList = this.accountList;
    modalRef.componentInstance.savingsAccountList = this.savingsAccountList;
    modalRef.result.then(
      (result) => {
        console.log(result);
      },
      (res) => {
        this.onTransactionCreation.emit();
      }
    );
  }
}
