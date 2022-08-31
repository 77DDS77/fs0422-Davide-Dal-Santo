abstract class Veicolo{
    nRuote:number = 1;
    vel:number = 0;
    velMax:number;
    engine:boolean;

    constructor(nRuote:number,velMax:number, engine:boolean){
        this.nRuote = nRuote;
        this.velMax = velMax;
        this.engine = engine;
    }

    fermaVeicolo(){
        this.vel = 0;
    }

    limiteVelocita(vel:number):boolean{
        return vel <= this.velMax
    }

    abstract accelera(vel:number):void

    abstract frena(vel:number):void

}

/**
 * dichiarando due metodi astratti 
 * nella classe astratta quando ne creo una estesa 
 * dalla classe astratta SONO OBBLIGATO ad implementarli e,
 * nel caso non li avessi definiti nella classe astratta,
 * a definirli
 * 
 * fermaVeicolo e limiteVelocita non li definisco abstract perche 
 * li definisco interamente nella classe astratta quindi tutte le classi che
 * verranno estese avranno quei metodi e non potranno modificarli
 * 
 * accelera e frena sono astratti perche lascio alla classe estesa la
 * possibilita' di definirli a seconda delle necessita'
 * NB: su un metodo astratto, quando lo implemetnto su una classe 
 * estesa
 * 
 * POSSO:
 * non usare il o i parametrei definiti nel metodo astratto
 * cambiare la tipizzazione dell'output
 * 
 * NON POSSO:
 * aggiungere parametri
 * cambiare la tipizzazione del parametro definito nel metodo astratto
 */



class Automobile extends Veicolo{

    constructor(velMax:number){
        super(4,velMax,true)
    }

    accelera(vel: number) {
        this.vel += vel
    }
    frena(vel: number) {
        this.vel -= vel
    }

}

let auto = new Automobile(280);

class Bicicletta extends Veicolo{

    constructor(velMax:number){
        super(2,velMax,false)
    }

    accelera():string {
        this.vel++
        return 'accelerato'    
    }
    frena() {
        this.vel--
    }

}

let bici = new Bicicletta(250);


bici.accelera();
console.log(bici.accelera());
console.log(bici)