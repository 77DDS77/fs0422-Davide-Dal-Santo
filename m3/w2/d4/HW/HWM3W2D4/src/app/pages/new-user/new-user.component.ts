import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Classes/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {

  constructor(private userSvc: UserService) { }

  ngOnInit(): void {
  }

  newUser:User = new User('', '');

  add(){
    this.userSvc.addUser(this.newUser);
    this.newUser = new User('', '');
  }

}
