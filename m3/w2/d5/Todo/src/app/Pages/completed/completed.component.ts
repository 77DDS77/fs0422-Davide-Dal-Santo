import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/Classes/todo';
import { TodoService } from 'src/app/Services/todo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrls: ['./completed.component.scss', '../../app.component.scss']
})
export class CompletedComponent implements OnInit {

  constructor(private todoSvc: TodoService) { }

  completedTodos:Todo[] = [];
  noContent:boolean = false;

  ngOnInit(): void {
    this.getAll();
  }

  getAll():void{
    this.todoSvc.getAllTodos().then(res => {
      this.completedTodos = res.filter(todo => todo.completed == true)
      if(this.completedTodos.length == 0){
        this.noContent = true;
        this.swalNoContent();
      }else{
        this.noContent = false;
      }
    });
  }

  delete(id:number| undefined):void{
    this.todoSvc.deleteTodo(id)
    setTimeout(() => {
      this.getAll();
    },500)
  }

  swalDelete(todo:Todo){
    Swal.fire({
      title: 'Do you want to delete the task?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Yes',
      denyButtonText: `No wait!`,
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire({
          icon: 'success',
          title: 'Task Deleted!',
          showConfirmButton: false,
          timer: 1200,
          timerProgressBar: true
        })
        this.delete(todo.id)
      } else if (result.isDenied) {
        Swal.fire({
          icon: 'error',
          title: 'Changes are not saved!',
          showConfirmButton: false,
          timer: 1200,
          timerProgressBar: true
        })
      }
    })
  }

  done(todo:Todo):void{
    todo.completed = !todo.completed;
    this.todoSvc.editTodo(todo, todo.id)
    setTimeout(() => {
      this.getAll();
    },1000)
    this.swalDone(todo)
  }

  swalDone(todo:Todo){
    if(todo.completed){
      Swal.fire({
        icon: 'success',
        title: 'Congrats!',
        text: 'Task completed!',
        showConfirmButton: false,
        timer: 1200,
        timerProgressBar: true
      })
    }else{
      Swal.fire({
        icon: 'error',
        title: 'Nevermind!',
        text: 'Take your time to complete it',
        showConfirmButton: false,
        timer: 1200,
        timerProgressBar: true
      })
    }
  }

  swalNoContent(){
    Swal.fire({
      icon: 'error',
      position: 'top-right',
      title: 'No Task Here!',
      text: 'You have no completed tasks',
      showConfirmButton: false,
      timer: 1500,
      timerProgressBar: true
    })
  }



}
