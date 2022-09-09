import { Injectable } from '@angular/core';
import { Todo } from '../Classes/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor() { }

  getAllTodos():Promise<Todo[]> {
    return new Promise((resolve, reject) => {
      setTimeout(() =>{
        resolve(fetch('http://localhost:3000/todos').then((res) => res.json()))
      },2000)
    })
  }

  getTodoById(id:number| undefined):Promise<Todo[]> {
    return new Promise((resolve, reject) => {
      setTimeout(() =>{
        resolve(fetch('http://localhost:3000/todos/'+id).then((res) => res.json()))
      },2000)
    })
  }

  addTodo(todo:Todo):Promise<Todo[]> {
    return new Promise((resolve, reject) => {
      setTimeout(() =>{
        let todoCopy = Object.assign({}, todo);

        let option = {
          method: 'POST',
          body: JSON.stringify(todoCopy),
          headers: {
            'content-type': 'application/json',
          },
        };
        resolve(fetch('http://localhost:3000/todos', option).then((res) => res.json()))
      },2000)
    })
  }

  deleteTodo(id:number| undefined):Promise<Todo[]> {
    return new Promise((resolve, reject) => {
      setTimeout(() =>{
        let option = {
          method: 'DELETE',
          headers: {
            'content-type': 'application/json',
          },
        };

        resolve(fetch('http://localhost:3000/todos/'+id, option).then((res) => res.json()))
      },2000)
    })
  }

  editTodo(){}//devo pensarci


}
