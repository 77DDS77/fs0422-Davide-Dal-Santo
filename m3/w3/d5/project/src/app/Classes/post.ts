export class Post {
  id!:number;
  title:string;
  content:string;
  ownerId:number;
  edited:boolean;

  constructor(title:string, content:string, ownerId:number){
    this.title = title;
    this.content = content;
    this.ownerId = ownerId;
    this.edited = false;
  }
}
