import { Customer } from "./customer";

export class Invoice {
  id!:number;
  date!:Date|null;
  importo:number;
  numero:number;
  customer:Customer;
  statoFattura:string;

  constructor(importo:number, numero:number, customer:Customer){
    this.importo = importo;
    this.numero = numero;
    this.customer = customer;
    this.statoFattura = "CREATA";
  }

}
