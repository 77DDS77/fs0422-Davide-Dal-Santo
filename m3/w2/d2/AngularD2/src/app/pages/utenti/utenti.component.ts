import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-utenti',
  templateUrl: './utenti.component.html',
  styleUrls: ['./utenti.component.scss'],
})
export class UtentiComponent implements OnInit {
  utenti:User[] = [
    {
      id: 1,
      name: 'Leanne Graham',
      email: 'Sincere@april.biz'
    },
    {
      id: 2,
      name: 'Ervin Howell',
      email: 'test@test.it'

    },
    {
      id: 3,
      name: 'Clementine Bauch',
      email: 'Nathan@yesenia.net'
    }
  ];

  newUser:User = new User('', '')

  constructor() {}

  ngOnInit(): void {}

  addUser():void{
    let userCopy = Object.assign({}, this.newUser);
    this.utenti.push(userCopy)
    this.newUser = new User('', '');
  }
}
