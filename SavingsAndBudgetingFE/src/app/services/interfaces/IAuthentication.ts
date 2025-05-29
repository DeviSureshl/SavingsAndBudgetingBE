import { IApiResponse } from './IApiResponse';
import { IUser } from './IUser';

export interface IAuthenticationResponse extends IApiResponse {
  data: IUser;
}
