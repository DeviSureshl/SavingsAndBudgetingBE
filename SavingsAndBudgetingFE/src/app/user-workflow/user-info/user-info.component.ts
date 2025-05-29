import { Component, Input } from '@angular/core';
import { IUser } from 'src/app/services/interfaces/IUser';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.scss'],
})
export class UserInfoComponent {
  @Input() userInfo: IUser = {} as IUser;
}
