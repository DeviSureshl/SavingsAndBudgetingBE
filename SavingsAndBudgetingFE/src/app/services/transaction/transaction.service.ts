import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ITransactionsResponse } from '../interfaces/ITransaction';
import { IApiResponse } from '../interfaces/IApiResponse';

@Injectable({
  providedIn: 'root',
})
export class TransactionService {
  constructor(private http: HttpClient) {}

  private apiUrl = 'http://localhost:8080/api/transactions';

  getTransactionsByUserId(userId: string): Observable<ITransactionsResponse> {
    return this.http.get<ITransactionsResponse>(this.apiUrl + '/' + userId);
  }

  addNewTransaction(
    userId: string,
    accountNumber: string,
    transactionType: string,
    transactionDate: string,
    transactionAmount: number,
    savingsAccountNumber: string
  ): Observable<IApiResponse> {
    const transactionDetails = {
      userId: userId,
      accountNumber: accountNumber,
      transactionType: transactionType,
      transactionDate: transactionDate,
      transactionAmount: transactionAmount,
      savingsAccountNumber: savingsAccountNumber,
    };
    return this.http.post<IApiResponse>(
      this.apiUrl + '/create-transaction',
      transactionDetails
    );
  }
}
