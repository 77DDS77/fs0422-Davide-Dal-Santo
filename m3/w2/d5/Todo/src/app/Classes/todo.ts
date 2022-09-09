export class Todo {

  id:number| undefined;
  title:string;
  completed:boolean;

  constructor(title:string){
    this.title = title;
    this.completed = false;
  }

}
