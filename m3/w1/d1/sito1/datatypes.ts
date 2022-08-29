let stringa:string = 'Mario';
let numero:number = 0;
let booleano:boolean = false;
let oggetto:object = {};
let array:any[] = [];
let union:(string|number|boolean) = true;
let any:any[] = [];
let varvuota!:string; // per variabile vuota, ricordarsi il !, gli dice "so che non c'e niente, dopo  ariva qualcosa"
let altravuota:string|undefined;//se vuota la mette undefined
let sconosciuto:unknown = {};



//come dichiare un oggetto con tipizzazione
let oggetto2:{nome:string, cognome:string}
oggetto2 = {
    nome: 'Mario',
    cognome: 'Rossi'
}

console.log(oggetto2.nome);

//:void comunica che e' una funzione che non ritorna nulla, esegue e basta
function saluta():void{
    console.log('ciao');
}

//:string dichiaro che il valore di return e' una stringa
function saluta2():string{
    return "ciao";
}

function saluta3(saluto:string):string{
    return saluto;
}

//argomento/parametro facoltativo
function saluta4(saluto:string|null = null):string|null{
    return saluto;
}


saluta();
console.log(saluta2());
console.log(saluta3('We pirletti'));
console.log(saluta4());

class User{

    //devo dochiarare i valori del constructor
    nome:string;
    cognome:string;

    /*
    constructor(nome:string, cognome:string){
        this.nome = nome;
        this.cognome = cognome;
    }
    */
}

//il constructor non mi serve perche non istanzio un nuovo oggetto User
//sto solo dichiarando il tipo di dato che oggetto3 sara'
//e oggetto3 sara' quello che dichiaro dentro user
let oggetto3:User = {
    nome:'Mario',
    cognome:'Rossi'
}

//dichiaro che utenti e' un array di User, dentro posso metterci solo oggetti con le proprieta'
//di User
let utenti:User[] = [oggetto2, oggetto3]

console.log(utenti);


/*
DATE
*/

//posso usare Date per tipizzare la variabile
let oggi:Date = new Date();
