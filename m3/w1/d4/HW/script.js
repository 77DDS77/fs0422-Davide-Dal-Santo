"use strict";
class CapiAbb {
    constructor(id, codprod, collezione, capo, modello, quantita, colore, prezzoivaesclusa, prezzoivainclusa, disponibile, saldo) {
        this.id = id;
        this.codprod = codprod;
        this.collezione = collezione;
        this.capo = capo;
        this.modello = modello;
        this.quantita = quantita;
        this.colore = colore;
        this.prezzoivaesclusa = prezzoivaesclusa;
        this.prezzoivainclusa = prezzoivainclusa;
        this.disponibile = disponibile;
        this.saldo = saldo;
        console.log(this);
        console.log(`Prezzo intero ${this.capo} ${this.colore}: ${this.prezzoivainclusa}$`);
        console.log(`Prezzo scontato ${this.capo} ${this.colore}: ${this.getAcquistoCapo()}$`);
    }
    getSaldoCapo() {
        return (this.prezzoivainclusa / 100) * this.saldo;
    }
    getAcquistoCapo() {
        return this.prezzoivainclusa - this.getSaldoCapo();
    }
}
getCapi();
function getCapi() {
    fetch('http://localhost:3000/capi')
        .then(res => res.json())
        .then(capi => {
        for (let capo of capi) {
            new CapiAbb(capo.id, capo.codprod, capo.collezione, capo.capo, capo.modello, capo.quantita, capo.colore, capo.prezzoivaesclusa, capo.prezzoivainclusa, capo.disponibile, capo.saldo);
        }
    });
}
//# sourceMappingURL=script.js.map