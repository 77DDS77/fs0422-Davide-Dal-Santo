export class Post {
  id!:number;
  title:string;
  content:string;
  ownerId:number;
  ownerName:string;
  edited:boolean;

  constructor(title:string, content:string, ownerId:number, ownerName:string){
    this.title = title;
    this.content = content;
    this.ownerId = ownerId;
    this.ownerName = ownerName;
    this.edited = false;
  }
}
