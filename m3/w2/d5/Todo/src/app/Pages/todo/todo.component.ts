import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/Classes/todo';
import { TodoService } from 'src/app/Services/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {

  allTodos: Todo[] = [];
  newTodo:Todo = new Todo('')

  constructor(private todoSvc: TodoService) { }

  ngOnInit(): void {
    this.getAll()
  }

  getAll():void{
    this.todoSvc.getAllTodos().then(res => (this.allTodos = res));
  }

  add():void{
    this.todoSvc.addTodo(this.newTodo)
    this.newTodo = new Todo('')
  }

}
