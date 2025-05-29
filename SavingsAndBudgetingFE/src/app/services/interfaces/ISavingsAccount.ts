import { IApiResponse } from './IApiResponse';

export interface ISavingsAccount {
  savingsAccountNumber: string;
  userId: string;
  targetAmount: number;
  currentAmount: number;
  targetDate: string;
  goalName: string;
}

export interface ISavingsAccountResponse extends IApiResponse {
  data: ISavingsAccount[];
}

export interface ISavingsAccountTransaction {
  transactionId: string;
  userId: string;
  savingsAccountNumber: string;
  accountNumber: string;
  transactionAmount: number;
  transactionDate: string;
}
export interface ISavingsAccountTransactionResponse extends IApiResponse {
  data: ISavingsAccountTransaction[];
}
