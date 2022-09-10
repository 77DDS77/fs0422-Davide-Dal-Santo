import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/Classes/todo';
import { TodoService } from 'src/app/Services/todo.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss', '../../../styles.scss']
})
export class TodoComponent implements OnInit {

  allTodos: Todo[] = [];
  noContent:boolean = false;
  newTodo:Todo = new Todo('')

  constructor(private todoSvc: TodoService) { }

  ngOnInit(): void {
    this.getAll()
  }

  getAll():void{
    this.todoSvc.getAllTodos().then(res => {
      this.allTodos = res
      if(this.allTodos.length == 0){
        this.noContent = true;
      }else{
        this.noContent = false;
      }
    });
  }

  add():void{
    this.todoSvc.addTodo(this.newTodo)
    this.newTodo = new Todo('')
    Swal.fire({
      icon: 'success',
      title: 'Task added to your list!',
      showConfirmButton: false,
      timer: 1200,
      timerProgressBar: true
    })
    setTimeout(() => {
      this.getAll();
    },500)

  }

}
