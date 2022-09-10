import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Todo } from 'src/app/Classes/todo';
import { TodoService } from 'src/app/Services/todo.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.scss', '../../../styles.scss']
})
export class ListItemComponent implements OnInit {

  @Input() todos:Todo[] = [];
  @Input() completedTodos:Todo[] = [];
  @Input() noContent!:boolean;

  constructor(private todoSvc:TodoService, private activeRoute:ActivatedRoute) { }

  route:any;

  ngOnInit(): void {
    this.findRoute();
  }

  findRoute(){
    this.route = this.activeRoute.routeConfig?.path
  }

  getAll():void{
    this.todoSvc.getAllTodos().then(res => (this.todos = res));
  }

  delete(id:number| undefined):void{
    this.todoSvc.deleteTodo(id)
    setTimeout(() => {
      this.getAll();
    },500)
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


  // METHOD FOR COMPLETED TODO ARRAY

  getAllComp():void{
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

  deleteComp(id:number| undefined):void{
    this.todoSvc.deleteTodo(id)
    setTimeout(() => {
      this.getAllComp();
    },500)
  }

  swalDeleteComp(todo:Todo){
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
        this.deleteComp(todo.id)
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

  doneComp(todo:Todo):void{
    todo.completed = !todo.completed;
    this.todoSvc.editTodo(todo, todo.id)
    setTimeout(() => {
      this.getAllComp();
    },1000)
    this.swalDone(todo)
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
