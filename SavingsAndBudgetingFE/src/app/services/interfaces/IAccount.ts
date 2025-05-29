import { IApiResponse } from './IApiResponse';

export interface IAccount {
  accountNumber: string;
  userId: string;
  accountType: string;
  balance: number;
}

export interface IAccountsResponse extends IApiResponse {
  data: IAccount[];
}
