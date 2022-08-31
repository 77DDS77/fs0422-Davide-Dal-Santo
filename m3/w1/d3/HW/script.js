"use strict";
class Lavoratore {
    constructor(redditoAnnuoLordo, tasseInps) {
        this.codRedd = this.getCodRedd();
        this.redditoAnnuoLordo = redditoAnnuoLordo;
        this.tasseInps = tasseInps;
        this.tasseIrpef = this.getTasseIrpef();
    }
    getCodRedd() {
        let tax;
        let redd = this.redditoAnnuoLordo;
        if (redd > 50000) {
            tax = 43;
        }
        else if (redd > 28000) {
            tax = 35;
        }
        else if (redd > 15000) {
            tax = 25;
        }
        else {
            tax = 23;
        }
        return tax;
    }
    getTasseInps() {
        return ((this.redditoAnnuoLordo / 100) * this.tasseInps);
    }
    getTasseIrpef() {
        let tax;
        let redd = this.redditoAnnuoLordo;
        if (redd > 75000) {
            tax = 43;
        }
        else if (redd > 55000) {
            tax = 41;
        }
        else if (redd > 28000) {
            tax = 38;
        }
        else if (redd > 15000) {
            tax = 27;
        }
        else {
            tax = 23;
        }
        return (this.redditoAnnuoLordo / 100) * tax;
    }
    getUtileTasse() {
        return this.getTasseInps() + this.getTasseIrpef();
    }
    getRedditoAnnuoNetto() {
        return this.redditoAnnuoLordo - this.getUtileTasse();
    }
}
class Dipendente extends Lavoratore {
    constructor(redditoAnnuoLordo) {
        super(redditoAnnuoLordo, 9.19);
    }
}
class DDL extends Lavoratore {
    constructor(redditoAnnuoLordo) {
        super(redditoAnnuoLordo, 23.81);
    }
}
let ugo = new Dipendente(24000);
let brambilla = new DDL(24000);
console.table(ugo);
console.log('Tasse INPS: ' + ugo.getTasseInps() + '$');
console.log('Reddito NETTO: ' + ugo.getRedditoAnnuoNetto() + '$');
console.log('------------------------------------');
console.table(brambilla);
console.log('Tasse da pagare: ' + brambilla.getTasseInps() + '$');
