import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/Classes/todo';
import { TodoService } from 'src/app/Services/todo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrls: ['./completed.component.scss', '../../../styles.scss']
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
