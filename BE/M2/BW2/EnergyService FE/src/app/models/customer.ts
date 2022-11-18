import { Address } from "./address";

export class Customer {
  id!:number;
  ragioneSociale:string;
  partitaIVA:string;
  email:string;
  dataInserimento:Date;
  dataUltimoContatto:Date;
  fatturatoAnnuale:number;
  pec:string;
  telefono:string;
  emailContatto:string;
  nomeContatto:string;
  cognomeContatto:string;
  telefonoContatto:string;
  sedeLegale:Address;
  sedeOperativa:Address|null;
  tipo:string;

  constructor(ragioneSociale:string, partitaIVA:string,
    email:string, fatturatoAnnuale:number,
    pec:string, telefono:string, emailContatto:string, nomeContatto:string, cognomeContatto:string, telefonoContatto:string,
    sedeLegale:Address, sedeOperativa:Address|null, tipo:string){
      this.ragioneSociale = ragioneSociale;
      this.partitaIVA = partitaIVA;
      this.email = email;
      this.dataInserimento = new Date(Date.now());
      this.dataUltimoContatto = this.dataInserimento;
      this.fatturatoAnnuale = fatturatoAnnuale;
      this.pec = pec;
      this.telefono = telefono;
      this.emailContatto = emailContatto;
      this.nomeContatto = nomeContatto;
      this.cognomeContatto = cognomeContatto;
      this.telefonoContatto = telefonoContatto;
      this.sedeLegale = sedeLegale;
      this.sedeOperativa = sedeOperativa;
      this.tipo = tipo;
    }
}
