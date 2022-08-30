//ricordarsi dopo parentesi parametri di mettere il tipo di dato restituito dalla funzione
// :void dice che la funzione non restituisce niente

function prova():void{
    //non posso restituire niente perche' la funzione restituisce void
    console.log('ciao');    
}

prova();

//funzione restituisce una stringa
function stringa():string{
    return 'Questa funzione restituisce una stringa';
}

console.log(stringa());

//dati in entrata
// il parametro testo deve essere di tipo stringa ed e' obbligatorio
function maiusc(testo:string):string{
    return testo.toUpperCase();
}

let upper:string = maiusc('ciao come stai?');
console.log(upper);


// le funzioni void possono essere parametrizzate
function voidUpper(testo:string):void{
    console.log(testo.toUpperCase());
}
voidUpper('ciao')



//se passo con il mouse sul query selector vedo che restituisce un HTMLElement 
// o NULL quidni dove scrvo il tipo di output devo considerarli tutti e due
function $(selettore:string):HTMLElement|null{
    return document.querySelector(selettore);
}

//il ? serve a far si che gli attributi vengano letti 
//solo se la funzione $() non resituisce null
$('.elemento')?.style.color 

//syntassi funzione freccia ad una riga
let X = (selettore:string):HTMLElement|null => document.querySelector(selettore);

X('.elemento')
