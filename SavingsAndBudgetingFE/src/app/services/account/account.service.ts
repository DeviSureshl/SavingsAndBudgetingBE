import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IAccountsResponse } from '../interfaces/IAccount';
import { IApiResponse } from '../interfaces/IApiResponse';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
  constructor(private http: HttpClient) {}

  private apiUrl = 'http://localhost:8080/api/accounts';

  getAccountsByUserId(userId: string): Observable<IAccountsResponse> {
    return this.http.get<IAccountsResponse>(this.apiUrl + '/' + userId);
  }

  addNewAccount(
    userId: string,
    accountType: string,
    balance: number
  ): Observable<IApiResponse> {
    const accountDetails = {
      userId: userId,
      accountType: accountType,
      balance: balance,
    };
    return this.http.post<IApiResponse>(
      this.apiUrl + '/create-account',
      accountDetails
    );
  }
}
