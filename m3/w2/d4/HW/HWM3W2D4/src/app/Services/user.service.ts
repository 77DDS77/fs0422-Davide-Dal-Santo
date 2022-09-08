import { Injectable } from '@angular/core';
import { User } from '../Classes/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  allUsers:User[] = [];
  singleUser!:User;

  getAllUsers():Promise<User[]>{
    return fetch('http://localhost:3000/users')
    .then(res => res.json())
    // .then(res => (this.allUsers = res)) da chiamare dentro il singolo componente dove mi serfve allsers
  }

  getUserById(id:number):Promise<User>{
    return fetch('http://localhost:3000/users/'+id)
    .then(res => res.json())
    // .then(res => (this.allUsers = res)) da chiamare dentro il singolo componente dove mi serfve allsers
  }

  addUser(user:User):void{

    user = Object.assign({}, user);

    let option = {
      method: "POST",
      body: JSON.stringify(user),
      headers: {
          "content-type": "application/json"
      }
    }

    fetch('http://localhost:3000/users', option).then((res) => res.json());
  }

}
