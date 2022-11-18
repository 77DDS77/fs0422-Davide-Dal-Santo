import { Comune } from "./comune";

export class Address {
  id!:number;
  via:string;
  civico:number;
  cap:number;
  comune:Comune;

  constructor(via:string, civico:number, cap:number, comune:Comune) {
    this.via = via;
    this.civico = civico;
    this.cap = cap;
    this.comune = comune;
  }
}
