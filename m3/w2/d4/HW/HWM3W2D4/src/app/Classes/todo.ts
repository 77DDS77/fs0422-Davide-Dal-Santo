export class Todo {
  id!:number|undefined;
  ownerName:string;
  title:string;
  content:string;

  constructor(ownerName:string, title:string, content:string) {
    this.ownerName = ownerName;
    this.title = title;
    this.content = content;

  }
}
