

interface ISmartphone{
    carica:number;
    numeroChiamate:number;
    costoPerMinuto:number;

    ricarica(unaRicarica:number):void;
    chiamata(minutiDurata:number):void;
    numero404():number;
    getNumeroChiamate():number;
    azzeraChiamate():void;
    
}

class FirstUser implements ISmartphone{

    carica: number;
    numeroChiamate: number;
    costoPerMinuto: number;

    constructor(carica:number){
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

        let parseMinuti:number = Number((minutiDurata).toFixed(2))
        let parseCosto:number = Number((this.costoPerMinuto).toFixed(2))

        let costoChiamata:number = Number((parseMinuti * parseCosto).toPrecision(2))

        console.log(minutiDurata, this.costoPerMinuto, costoChiamata);
        console.log(this.carica);
        
        

        if(this.carica >= costoChiamata){

            console.log(`Chiamata ${minutiDurata}min effettuata, costo chiamata: ${costoChiamata}`);  
            this.carica -= costoChiamata;
            this.numeroChiamate++;

        }else{

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

let mario = new FirstUser(0);

mario.numero404();
mario.ricarica(10);
mario.chiamata(27)
mario.chiamata(2)
mario.chiamata(2)
mario.chiamata(2)
mario.chiamata(2)
mario.chiamata(14)
mario.chiamata(1)

mario.numero404()



