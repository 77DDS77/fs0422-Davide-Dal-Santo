export class Post {
  id!:number;
  title:string;
  content:string;
  ownerId:number;

  constructor(title:string, content:string, ownerId:number){
    this.title = title;
    this.content = content;
    this.ownerId = ownerId;
  }
}
