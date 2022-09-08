import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/Classes/todo';
import { User } from 'src/app/Classes/user';
import { TodoService } from 'src/app/Services/todo.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-new-todo',
  templateUrl: './new-todo.component.html',
  styleUrls: ['./new-todo.component.scss']
})
export class NewTodoComponent implements OnInit {

  allUsers:User[] = [];

  newTodo:Todo = new Todo('', '', '');

  constructor(
    private todoSvc: TodoService,
    private userSvc: UserService
  ) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(){
    this.userSvc.getAllUsers().then(res => (this.allUsers = res));
  }

  add(){
    this.todoSvc.addTodo(this.newTodo)
    this.newTodo = new Todo('', '', '');
  }



}
