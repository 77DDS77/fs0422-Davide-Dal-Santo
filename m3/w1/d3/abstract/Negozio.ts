
abstract class Negozio{
    maglia:string;
    pantalone:string;
    scarpe:string;

    constructor(maglia:string, pantalone:string, scarpe:string) {
        this.maglia = maglia;
        this.pantalone = pantalone;
        this.scarpe = scarpe;

    }

    abstract abbigliamento():void //void solo per spegnerre l'errore
}

//let negozio = new Negozio()
//non posso istanziare una classe astratta