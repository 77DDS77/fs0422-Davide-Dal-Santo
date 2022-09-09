import { Injectable } from '@angular/core';
import { Todo } from '../Classes/todo';

@Injectable({
  providedIn: 'root',
})
export class TodoService {
  constructor() {}

  allUsers: Todo[] = [];
  singleUser!: Todo;

  getAllTodo(): Promise<Todo[]> {
    return fetch('http://localhost:3000/todos').then((res) => res.json());
    // .then(res => (this.allUsers = res)) da chiamare dentro il singolo componente dove mi serfve allsers
  }

  getTodoById(id: number): Promise<Todo> {
    return fetch('http://localhost:3000/todos/' + id).then((res) => res.json());
    // .then(res => (this.allUsers = res)) da chiamare dentro il singolo componente dove mi serfve allsers
  }

  addTodo(todo: Todo): void {
    let todoCopy = Object.assign({}, todo);

    let option = {
      method: 'POST',
      body: JSON.stringify(todoCopy),
      headers: {
        'content-type': 'application/json',
      },
    };

    fetch('http://localhost:3000/todos', option).then((res) => res.json());
    //forse c'e' da fare il reset
  }

  deleteTodo(id: number | undefined): void {
    let option = {
      method: 'DELETE',
      headers: {
        'content-type': 'application/json',
      },
    };

    fetch('http://localhost:3000/todos/' + id, option).then((res) =>
      res.json()
    );
  }

  editTodo(id:number){
    //ci devo pensare
  }


  // roba che mi serve domani
  perDomani():Promise<Todo[]> {
    return new Promise((resolve, reject) => {
      setTimeout(() =>{
        resolve(fetch('http://localhost:3000/todos').then((res) => res.json()))
      },200)
    })
  }
}
