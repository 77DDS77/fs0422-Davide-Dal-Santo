export class User {
  id!:number;
  username:string;
  email:string;
  password:string;
  nome:string;
  cognome:string;
  active:boolean = true;

  constructor(username:string, email:string, password:string, nome:string, cognome:string){
    this.username = username;
    this.email = email;
    this.password = password;
    this.nome = nome;
    this.cognome = cognome;
  }
}
