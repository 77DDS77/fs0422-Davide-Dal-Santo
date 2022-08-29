
//interface e' un libretto di istruzioni su quali sono le proprieta' che devono
//per forza essere presernti all'interno di una clase
interface Iuser{
    nome:string;
    cognome:string;
    email:string;
    password:string;
}

//la classe User deve seguire obbligatoriamente la struttura della interface Iuser
class User implements Iuser{
    nome:string;
    cognome!:string;
    email!: string;
    password!: string;

    constructor(nome:string){
        this.nome = nome;
    }

}

//attivando il ts confing con tsc --init mi si attivano degli scazzi
//nella class User o dichiaro il costruttore perle proprieta' della classe User
//o gli metto il punto esclamativo !: per dirgli stai buono arrivano dopo