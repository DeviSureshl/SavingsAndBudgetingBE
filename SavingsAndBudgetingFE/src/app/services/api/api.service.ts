import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IAuthenticationResponse } from '../interfaces/IAuthentication';
import { IUser, IUserListResponse, IUserResponse } from '../interfaces/IUser';
import { IApiResponse } from '../interfaces/IApiResponse';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private http: HttpClient) {}

  private apiUrl = 'http://localhost:8080/api/users';

  authenticateUser(
    email: string,
    password: string
  ): Observable<IAuthenticationResponse> {
    return this.http.post<IAuthenticationResponse>(
      this.apiUrl + '/authenticate-user',
      {
        email,
        password,
      }
    );
  }

  getAllUsers(): Observable<IUserListResponse> {
    return this.http.get<IUserListResponse>(this.apiUrl);
  }

  registerUser(userDetails: IUser): Observable<IApiResponse> {
    return this.http.post<IApiResponse>(
      this.apiUrl + '/register-user',
      userDetails
    );
  }

  deleteUser(userId: string): Observable<IApiResponse> {
    return this.http.delete<IApiResponse>(this.apiUrl + '/' + userId);
  }

  getUserById(userId: string): Observable<IUserResponse> {
    return this.http.get<IUserResponse>(this.apiUrl + '/' + userId);
  }
}
