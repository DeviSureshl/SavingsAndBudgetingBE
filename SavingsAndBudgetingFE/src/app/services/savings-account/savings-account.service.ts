import { Injectable } from '@angular/core';
import { IUser } from '../interfaces/IUser';
import {
  ISavingsAccountResponse,
  ISavingsAccountTransactionResponse,
} from '../interfaces/ISavingsAccount';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IApiResponse } from '../interfaces/IApiResponse';

@Injectable({
  providedIn: 'root',
})
export class SavingsAccountService {
  constructor(private http: HttpClient) {}

  private apiUrl = 'http://localhost:8080/api/';

  getSavingsAccountsByUserId(
    userId: string
  ): Observable<ISavingsAccountResponse> {
    return this.http.get<ISavingsAccountResponse>(
      this.apiUrl + 'savingsAccounts/' + userId
    );
  }

  addSavingsAccount(
    userId: string,
    goalName: string,
    targetAmount: number,
    currentAmount: number,
    targetDate: string
  ): Observable<IApiResponse> {
    const accountDetails = {
      userId: userId,
      goalName: goalName,
      targetAmount: targetAmount,
      currentAmount: currentAmount,
      targetDate: targetDate,
    };
    return this.http.post<IApiResponse>(
      this.apiUrl + 'savingsAccounts/create-savings',
      accountDetails
    );
  }

  getSavingsAccountTransactions(
    savingsAccountNumber: string
  ): Observable<ISavingsAccountTransactionResponse> {
    return this.http.get<ISavingsAccountTransactionResponse>(
      this.apiUrl + 'savingsTransactions/' + savingsAccountNumber
    );
  }
}
