import { IApiResponse } from './IApiResponse';

export interface IUser {
  userId: string;
  firstName: string;
  lastName: string;
  dateOfBirth: string;
  password: string;
  gender: string;
  email: string;
  isAdmin: boolean;
}

export interface IUserListResponse extends IApiResponse {
  data: IUser[];
}

export interface IUserResponse extends IApiResponse {
  data: IUser;
}
