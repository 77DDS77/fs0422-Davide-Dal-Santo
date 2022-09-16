export class User {
  id!:number;
  name:string;
  email:string;
  password:string;
  posts:number[] = [];

  constructor(name:string, email:string, password:string){
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
