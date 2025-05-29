import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { IAccount } from 'src/app/services/interfaces/IAccount';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddAccountComponent } from '../add-account/add-account.component';

@Component({
  selector: 'app-account-summary',
  templateUrl: './account-summary.component.html',
  styleUrls: ['./account-summary.component.scss'],
})
export class AccountSummaryComponent {
  @Input() userId: string = '';
  @Input() accountList: IAccount[] = [];
  @Output() onAccountCreation = new EventEmitter();
  private modalService = inject(NgbModal);

  constructor() {}
  ngOnInit(): void {}

  addAccount() {
    const modalRef = this.modalService.open(AddAccountComponent);
    modalRef.componentInstance.userId = this.userId;
    modalRef.result.then(
      (result) => {
        // closed
        console.log(result);
      },
      (res) => {
        // Dismissed
        //this.getAccountsByUserId();
        this.onAccountCreation.emit();
      }
    );
  }
}
