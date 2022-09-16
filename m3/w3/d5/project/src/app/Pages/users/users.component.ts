import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Classes/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  allUsers: User[] = [];

  constructor(private userSvc: UserService) { }

  ngOnInit(): void {
    this.getAllUsers()
  }


  getAllUsers(){
    this.userSvc.getAllUsers()
    .subscribe(users => {
      this.allUsers = users;
    })
  }
}
