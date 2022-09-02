
// ----------------------------------------------FIRST USER
interface ISmartphone {
    carica: number;
    numeroChiamate: number;
    costoPerMinuto: number;

    ricarica(unaRicarica: number): void;
    chiamata(minutiDurata: number): void;
    numero404(): number;
    getNumeroChiamate(): number;
    azzeraChiamate(): void;

}

class FirstUser implements ISmartphone {

    carica: number;
    numeroChiamate: number;
    costoPerMinuto: number;

    constructor(carica: number) {
        this.carica = carica;
        this.numeroChiamate = 0;
        this.costoPerMinuto = 0.20;
    }

    ricarica(unaRicarica: number): void {
        this.carica += unaRicarica;
        console.log(`Credito: ${this.carica}`);
    }

    /**
     * costo per chiamata va parsato per non incorrere in problemi
     * con in decimali nel corso delle operazioni.
     * Una chiamata, ad esempio, di 2 minuti aveva il costo di 0.40000000001
     * e avrebbe intaccato tutte le operazioni successive.
    */
    chiamata(minutiDurata: number): void {

        let parseMinuti: number = (Number((minutiDurata).toFixed(2)) * 10) / 10;
        let parseCosto: number = (Number((this.costoPerMinuto).toFixed(2)) * 10) / 10

        let costoChiamata: number = (Number((parseMinuti * parseCosto).toFixed(2)) * 10) / 10;

        console.log(minutiDurata, this.costoPerMinuto, costoChiamata);
        console.log(this.carica);



        if (this.carica >= costoChiamata) {

            console.log(`Chiamata ${minutiDurata}min effettuata, costo chiamata: ${costoChiamata}`);
            this.carica -= (costoChiamata * 10) / 10;
            this.numeroChiamate++;

        } else {

            console.log(`Credito insufficiente, costo chiamata: ${costoChiamata}, credito residuo: ${this.carica}`);

        }
    }

    numero404(): number {
        console.log(`Credito residio: ${parseFloat((this.carica).toFixed(2))}`);
        return parseFloat((this.carica).toFixed(2));
    }

    getNumeroChiamate(): number {
        console.log(`Hai effettuato ${this.numeroChiamate} chiamate`);
        return this.numeroChiamate;
    }

    azzeraChiamate(): void {
        console.log(`Chiamate azzerate!`);
        this.numeroChiamate = 0;
    }
}
console.log('%cFIRST USER', 'color:red');


let mario:FirstUser = new FirstUser(0);

mario.numero404();
mario.ricarica(10);
mario.chiamata(27);
mario.chiamata(2);
mario.chiamata(2);
mario.chiamata(2);
mario.chiamata(2);
mario.chiamata(14);
mario.chiamata(1);
mario.numero404();


// ----------------------------------------------SECOND USER
class SecondUser implements ISmartphone {

    carica: number;
    numeroChiamate: number;
    costoPerMinuto: number;

    constructor(carica: number) {
        this.carica = carica;
        this.numeroChiamate = 0;
        this.costoPerMinuto = 0.20;
    }

    ricarica(unaRicarica: number): void {
        this.carica += unaRicarica;
        console.log(`Credito: ${this.carica}`);
    }
    chiamata(minutiDurata: number): void {
        let parseMinuti: number = (Number((minutiDurata).toFixed(2)) * 10) / 10;
        let parseCosto: number = (Number((this.costoPerMinuto).toFixed(2)) * 10) / 10

        let costoChiamata: number = (Number((parseMinuti * parseCosto).toFixed(2)) * 10) / 10;

        if (this.carica >= costoChiamata) {

            console.log(`Chiamata ${minutiDurata}min effettuata, costo chiamata: ${costoChiamata}`);
            this.carica -= (costoChiamata * 10) / 10;
            this.numeroChiamate++;

        } else {

            console.log(`Credito insufficiente, costo chiamata: ${costoChiamata}, credito residuo: ${this.carica}`);

        }
    }
    numero404(): number {
        console.log(`Credito residio: ${parseFloat((this.carica).toFixed(2))}`);
        return parseFloat((this.carica).toFixed(2));
    }
    getNumeroChiamate(): number {
        console.log(`Hai effettuato ${this.numeroChiamate} chiamate`);
        return this.numeroChiamate;
    }
    azzeraChiamate(): void {
        console.log(`Chiamate azzerate!`);
        this.numeroChiamate = 0;
    }
}

console.log('%cSECOND USER', 'color:red');

let piero:SecondUser = new SecondUser(0)
piero.numero404();
piero.ricarica(10);
piero.chiamata(27);
piero.chiamata(2);
piero.chiamata(15);
piero.chiamata(7);
piero.numero404();
piero.getNumeroChiamate();

// ----------------------------------------------THIRD USER
class ThirdUser implements ISmartphone {

    carica: number;
    numeroChiamate: number;
    costoPerMinuto: number;

    constructor(carica: number) {
        this.carica = carica;
        this.numeroChiamate = 0;
        this.costoPerMinuto = 0.20;
    }

    ricarica(unaRicarica: number): void {
        this.carica += unaRicarica;
        console.log(`Credito: ${this.carica}`);
    }
    chiamata(minutiDurata: number): void {
        let parseMinuti: number = (Number((minutiDurata).toFixed(2)) * 10) / 10;
        let parseCosto: number = (Number((this.costoPerMinuto).toFixed(2)) * 10) / 10

        let costoChiamata: number = (Number((parseMinuti * parseCosto).toFixed(2)) * 10) / 10;

        if (this.carica >= costoChiamata) {

            console.log(`Chiamata ${minutiDurata}min effettuata, costo chiamata: ${costoChiamata}`);
            this.carica -= (costoChiamata * 10) / 10;
            this.numeroChiamate++;

        } else {

            console.log(`Credito insufficiente, costo chiamata: ${costoChiamata}, credito residuo: ${this.carica}`);

        }
    }
    numero404(): number {
        console.log(`Credito residio: ${parseFloat((this.carica).toFixed(2))}`);
        return parseFloat((this.carica).toFixed(2));
    }
    getNumeroChiamate(): number {
        console.log(`Hai effettuato ${this.numeroChiamate} chiamate`);
        return this.numeroChiamate;
    }
    azzeraChiamate(): void {
        console.log(`Chiamate azzerate!`);
        this.numeroChiamate = 0;
    }
}

console.log('%cTHIRD USER', 'color:red');

let paola:ThirdUser = new SecondUser(0)
paola.numero404();
paola.ricarica(10);
paola.chiamata(10);
paola.chiamata(20);
paola.chiamata(5);
paola.chiamata(15);
paola.numero404();
paola.getNumeroChiamate();


