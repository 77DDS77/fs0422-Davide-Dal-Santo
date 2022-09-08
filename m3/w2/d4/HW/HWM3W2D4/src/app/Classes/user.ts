export class User {
  id:number|undefined;
  name:string;
  lastname:string;

  constructor(name:string, lastname:string){
    this.name = name;
    this.lastname = lastname;
  }
}
