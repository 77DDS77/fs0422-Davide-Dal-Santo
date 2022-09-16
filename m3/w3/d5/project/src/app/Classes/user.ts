export class User {
  id!:number;
  name:string;
  email:string;
  password:string;
  slug!:string;

  constructor(name:string, email:string, password:string){
    this.name = name;
    this.email = email;
    this.password = password;
    this.slug = User.slugify(name)
  }

  static slugify(name:string):string{
    return name.toLowerCase().replace(/ /g, '-').replace(/[^\w-]+/g, '');
  }
}

