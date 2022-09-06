export class Post {
  id:number | undefined;
  body!:string;
  title!:string;
  active!:boolean;

  constructor(body:string, title:string){
    this.body = body;
    this.title = title;
    this.active = true;
  }
}
