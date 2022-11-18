import { Provincia } from "./provincia";

export class Comune {
  id!:number;
  comune:string;
  provincia:Provincia;

  constructor(comune:string, provincia:Provincia) {
    this.comune = comune;
    this.provincia = provincia;
  }
}
