import {Component, Input, OnInit} from '@angular/core';
import {Warehouse} from "../warehouse/warehouse";
import {Users} from './users';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  public users: Users[] | undefined;
  public title: string = 'کاربران';
  public userTitle: string | undefined;
  @Input() sourceLoad: boolean = true;
  public editModeTitle: string = 'ویرایش کاربر';
  public editMode: boolean = false;

  constructor() {
  }

  ngOnInit(): void {
    this.users = [
      {
        id: '1',
        firstName: 'رحمان',
        lastName: 'زال',
        userName: 'zal',
        status: true,
        gender: 1,
      },
      {
        id: '2',
        firstName: 'سلمان',
        lastName: 'قاسمی',
        userName: 'ghasemi',
        status: true,
        gender: 1,
      },
      {
        id: '3',
        firstName: 'زهرا',
        lastName: 'رنجبر',
        userName: 'ranjbar',
        status: true,
        gender: 2,
      },
      {
        id: '4',
        firstName: 'رقیه',
        lastName: 'سعادتی',
        userName: 'saadati',
        status: false,
        gender: 1,
      },
      {
        id: '5',
        firstName: 'احمد',
        lastName: 'سعیدی',
        userName: 'saeedi',
        status: true,
        gender: 2,
      },
    ]
  }

  switchToEditMode() {
    editModeTitle: 'تعریف کاربر جدید';
    this.editMode = true;
  }
}
