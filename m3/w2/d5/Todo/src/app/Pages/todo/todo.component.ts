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
    setTimeout(() => {
      this.getAll();
    },500)

  }

  // delete(id:number| undefined):void{
  //   this.todoSvc.deleteTodo(id)
  //   setTimeout(() => {
  //     this.getAll();
  //   },500)
  // }

  // done(todo:Todo):void{
  //   todo.completed = !todo.completed;
  //   this.todoSvc.editTodo(todo, todo.id)
  //   this.swalDone(todo)
  // }

  // swalDone(todo:Todo){
  //   if(todo.completed){
  //     Swal.fire({
  //       icon: 'success',
  //       title: 'Congrats!',
  //       text: 'Task completed!',
  //       showConfirmButton: false,
  //       timer: 1200,
  //       timerProgressBar: true
  //     })
  //   }else{
  //     Swal.fire({
  //       icon: 'error',
  //       title: 'Nevermind!',
  //       text: 'Take your time to complete it',
  //       showConfirmButton: false,
  //       timer: 1200,
  //       timerProgressBar: true
  //     })
  //   }
  // }

  // swalDelete(todo:Todo){
  //   Swal.fire({
  //     title: 'Do you want to delete the task?',
  //     showDenyButton: true,
  //     showCancelButton: true,
  //     confirmButtonText: 'Yes',
  //     denyButtonText: `No wait!`,
  //   }).then((result) => {
  //     if (result.isConfirmed) {
  //       Swal.fire({
  //         icon: 'success',
  //         title: 'Task Deleted!',
  //         showConfirmButton: false,
  //         timer: 1200,
  //         timerProgressBar: true
  //       })
  //       this.delete(todo.id)
  //     } else if (result.isDenied) {
  //       Swal.fire({
  //         icon: 'error',
  //         title: 'Changes are not saved!',
  //         showConfirmButton: false,
  //         timer: 1200,
  //         timerProgressBar: true
  //       })
  //     }
  //   })
  // }

}
