import {Component, Input, OnInit} from '@angular/core';
import { PersonService } from './person.service';
import {Person} from "./person";

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  public persons: Person[] | undefined;
  public title: string = 'کاربران';
  public userTitle: string | undefined;
  @Input() sourceLoad: boolean = true;
  public editModeTitle: string = 'ویرایش کاربر';
  public editMode: boolean = false;

  constructor(private personService: PersonService) {
    // this.persons = new Person();
  }

  ngOnInit(): void {
   /* this.persons = [
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
