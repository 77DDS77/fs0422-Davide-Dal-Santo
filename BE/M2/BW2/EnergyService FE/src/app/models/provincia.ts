export class Provincia {
  id!:number;
  sigla:string;
  provincia:string;
  regione:string;

  constructor(sigla:string, provincia:string, regione:string){
    this.sigla = sigla;
    this.provincia = provincia;
    this.regione = regione;
  }
}
