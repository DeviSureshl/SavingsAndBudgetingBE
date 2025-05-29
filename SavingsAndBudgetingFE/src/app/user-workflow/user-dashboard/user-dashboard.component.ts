import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AccountService } from 'src/app/services/account/account.service';
import { ApiService } from 'src/app/services/api/api.service';
import { IAccount } from 'src/app/services/interfaces/IAccount';
import { ISavingsAccount } from 'src/app/services/interfaces/ISavingsAccount';
import { ITransaction } from 'src/app/services/interfaces/ITransaction';
import { IUser } from 'src/app/services/interfaces/IUser';
import { SavingsAccountService } from 'src/app/services/savings-account/savings-account.service';
import { TransactionService } from 'src/app/services/transaction/transaction.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.scss'],
})
export class UserDashboardComponent {
  userId: string = '';
  userDetails: IUser = {} as IUser;
  hasValidUserDetails: boolean = false;
  accounts: IAccount[] = [];
  transactions: ITransaction[] = [];
  savingsAccount: ISavingsAccount[] = [];

  constructor(
    private apiService: ApiService,
    private route: ActivatedRoute,
    private accountService: AccountService,
    private transactionService: TransactionService,
    private savingsAccountService: SavingsAccountService
  ) {}

  ngOnInit(): void {
    this.userId = this.route.snapshot.paramMap.get('userId') ?? '';
    this.getUserDetails();
    this.getAccountsByUserId();
    this.getTransactionsByUserId();
    this.getSavingsAccountsByUserId();
  }

  getUserDetails() {
    this.apiService.getUserById(this.userId).subscribe(
      (response) => {
        console.log(response);
        this.userDetails = response.data;
        this.hasValidUserDetails = true;
      },
      (errorResp) => {
        console.log(errorResp);
      }
    );
  }
  getAccountsByUserId() {
    this.accountService.getAccountsByUserId(this.userId).subscribe(
      (response) => {
        this.accounts = response.data;
      },
      (errorResp) => {
        console.log(errorResp);
      }
    );
  }
  getTransactionsByUserId() {
    this.transactionService.getTransactionsByUserId(this.userId).subscribe(
      (response) => {
        this.transactions = response.data;
        console.log(response);
      },
      (errorResp) => {
        console.log(errorResp);
      }
    );
  }
  getSavingsAccountsByUserId() {
    this.savingsAccountService
      .getSavingsAccountsByUserId(this.userId)
      .subscribe(
        (response) => {
          this.savingsAccount = response.data;
          console.log(response);
        },
        (errorResp) => {
          console.log(errorResp);
        }
      );
  }
}
