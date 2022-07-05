let nome = "Mirtilla";
console.log(nome);
var utente = "cliente";
console.log(utente);
const PI = 3.14;
console.log(PI);

//nome = "Lilla";
console.log(nome);
utente = "amministratore";
console.log(utente);
//PI = 4;
//console.log(PI);

let primoLavoro = "developing";
let secondoLavoro = "formazione";

let lavoro = primoLavoro + " e " + secondoLavoro;

console.log('io mi occupo di: ' + lavoro);
console.log('io mi occupo di: ' + primoLavoro + " e " + secondoLavoro);

let JS = true;
console.log('Let JS: ' + JS);

let anno;
console.log(anno);

anno = 1991;

const annoAttuale = 2021;

let anniMirtilla = annoAttuale - anno;
console.log(anniMirtilla);

console.log(nome + " ha: " + anniMirtilla + " anni");

let a = 10 + 5;
let b = 3;
let c = 10;
let somma = b + c + 2;
console.log(somma);

c++;
console.log(c);
a--;
console.log(a);

let nomePet = "Billo";
let colorePet = "rosso";
const pet = "il nome del pet: " + nomePet + "e il suo colore è: " + colorePet;
console.log(pet);

// sintassi letterale con backtick -> apice inverso
const pet1 = `il nome del pet: ${nomePet}  e il suo colore è: ${colorePet}`;
console.log(pet1);

console.log('string con \n\ righe \n\ multiple');
console.log(`string \n\ con \n\ righe \n\ multiple \n\n\n\n\n\n\n\ `);

const separatore = '++++++++++++++++++++++++++++++++';
console.log(separatore);

//STRUTTURA CON VAR LET E CONST


let raggio = 5;
const pGreco = 3.14;

function areaCerchio(raggio, pGreco){
     var area = raggio * raggio * pGreco;
    console.log('area del cerchio: ' + area);
}

areaCerchio(raggio, pGreco);


//DIFFERENZA TRA VARIABILE LET E VARIABILE CONST

let letNum = 2;
const CONSTNUM = 3;

letNum = 4; //questo modifica il valore di letNum perche' e' una variabile non costante
//constNum = 5; questo non funziona perche' sto cercando di riassegnare una variabile che ho definto costante

console.log('Variabile non costante: ' + letNum + " \n\ Variabile costante: " + CONSTNUM);

//BOOLEAN + STRINGHE

let carisio = true;
const DOMANDA = 'Carisio sei un goblin? \n\ ';
let risposta = 'Carisio risponde; ' + carisio;


console.log('Carisio sei un goblin?' + ' \n\ ' + 'Carisio rispnde: ' + carisio );

console.log(DOMANDA + risposta);

console.log(separatore);

//ESEGUI DELLE OPERAZIONI DI SOMMA E SOTTRAZIONE

let numerone = 10;
let numerino = 0;
var interazione = 0;

while(numerone > 0 && numerino < 10 ){
    
    interazione++;
    numerone--;
    numerino++;
    console.log('Interazione ciclo n: '+ interazione);
    console.log('numerone = ' + numerone + ' \n\ ' + 'numerino = ' + numerino);

}

