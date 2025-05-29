import { IApiResponse } from './IApiResponse';

export interface ITransaction {
  accountNumber: string;
  transactionAmount: number;
  transactionDate: string;
  transactionId: string;
  transactionType: string;
  userId: string;
  savingsAccountNumber: string;
}

export interface ITransactionsResponse extends IApiResponse {
  data: ITransaction[];
}
