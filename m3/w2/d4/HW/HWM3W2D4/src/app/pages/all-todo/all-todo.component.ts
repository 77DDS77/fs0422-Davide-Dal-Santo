import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/Classes/todo';
import { TodoService } from 'src/app/Services/todo.service';

@Component({
  selector: 'app-all-todo',
  templateUrl: './all-todo.component.html',
  styleUrls: ['./all-todo.component.scss']
})
export class AllTodoComponent implements OnInit {

  allTodos: Todo[] = [];

  constructor(private todoSvc: TodoService) { }

  ngOnInit(): void {
    this.getTodos();
  }

  getTodos():void{
    this.todoSvc.getAllTodo().then(res => (this.allTodos = res))
  }

}
