export class Post {
  id:number | undefined;
  body!:string;
  title!:string;
  type!:string;
  active!:boolean;

  constructor(body:string, title:string, type:string){
    this.body = body;
    this.title = title;
    this.type = type;
    this.active = true;
  }
}

