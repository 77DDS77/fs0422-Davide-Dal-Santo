import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  allUsers:User[] = [
    {
      id:1,
      name: 'John',
      lastname: 'Rossi',
      active: true
    },
    {
      id:2,
      name: 'Papa',
      lastname: 'Bergoglio',
      active: true
    },
    {
      id:3,
      name: 'Johnathan',
      lastname: 'Cucco',
      active: false
    }
  ];

  addNewUser(user: User): void {
    let userCopy:User = Object.assign({}, user);
    this.allUsers.push(userCopy);
  }

  deleteUser(id:string|number): void {
    let index = this.allUsers.findIndex(user => user.id === id);
    this.allUsers.splice(index, 1);
  }

  getUserById(id:string|number):User{
    return this.allUsers.find(user => user.id === id) || new User('','')
    //new User('','') solo per spegnerre l'errore
  }

  getAllActiveUsers(): User[]{
    return this.allUsers.filter(user => user.active === true);
  }

  getAllInactiveUsers(): User[]{
    return this.allUsers.filter(user => user.active === false);
  }


}
