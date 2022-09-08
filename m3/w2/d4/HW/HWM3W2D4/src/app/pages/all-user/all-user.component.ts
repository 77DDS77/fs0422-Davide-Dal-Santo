import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Classes/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrls: ['./all-user.component.scss']
})
export class AllUserComponent implements OnInit {

  allUsers:User[] = [];

  constructor(private userSvc: UserService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(){
    this.userSvc.getAllUsers().then(res => (this.allUsers = res));
  }

}
