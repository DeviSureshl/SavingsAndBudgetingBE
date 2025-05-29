import { Component } from '@angular/core';
import { ApiService } from '../services/api/api.service';
import { IUser } from '../services/interfaces/IUser';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss'],
})
export class AdminDashboardComponent {
  userList: IUser[] = [];
  constructor(private apiService: ApiService) {}
  ngOnInit() {
    this.getUserList();
  }
  viewUserDetails(userId: string) {}
  deleteUserDetails(userId: string) {
    if (window.confirm('Do you want to delete the user?')) {
      this.apiService.deleteUser(userId).subscribe(
        (response) => {
          alert('user deleted successfully');
          this.getUserList();
        },
        (errorResp) => {
          alert(errorResp.message);
        }
      );
    }
  }

  getUserList() {
    this.apiService.getAllUsers().subscribe(
      (response) => {
        this.userList = response.data;
      },

      (error) => {}
    );
  }
}
