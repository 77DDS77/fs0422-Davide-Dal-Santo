document.write('Ciao mondo'); //metodo da non usare

document.getElementById('test').innerHTML = 'Ciao mondo testS';
document.getElementById('test').style.backgroundColor = 'red';

console.log('%c test console log','color: red'); //console log con testo rosso ma usato solo per prova


console.log(3 + 4);


// variabili
var nomeVariabile = 'ciao';

var a = 4;
var b = 5;

console.log(a, b);
console.log(a + b); //spazi non richiesti
// se faccio console log priam di dichiarare la variabile mi mostra 'undefined'

var c = 5;

a = 1;
console.log(a); //posso riassegnare la variabile, da qui in giu a vale 1

// tipi di dato
/*

number
string
boolean
array
object

*/ 

var x = 5;  //variabile numerica

var y = '5'; //variabile stringa

var nome = 'Mario';
var saluto = 'Ciao ';
console.log(saluto + nome + ', sono gia le ' + y);

var b = true; //variabile boolean puo essere true o false

var h = [1,2,3,4,50,'ciao']; //variabile array
console.log(h[0]); 

var o = {
    nome: 'Edoardo',
    eta: 27,
    sposato: false //booleana
}

console.log(o.nome, o.sposato); //o.nome pesca dentro la variabile oggetto o il nome
console.table(o);

// array(100); //array di 100 elementi, vuoto


//conversioni e operazioni

a = 2; //sovrascrivo quelle di prima
b = 2;

console.log(a*b);

c = '2';
d = b + c;

console.log(b + c); //uno dei due valori era stringa quindi + fa concatenamento

console.log(d); //d viene convertita in stringa 

e = '2a';
console.log(a * e); //ritorna NaN, Not a Number
console.log(b * c); //c=stringa ma siccome ha solo un numero dentro lo converte in numerico

//casting

console.log(typeof a, typeof c); //typeof mi mostra il tipo della variabile che inserisco

console.log(typeof String(a)); //String(a) forza var a   a diventare un astringa

//funzioni

saluta(); //hoisting, la funzione puo essere invocata prima che venga dichiarata
//pero se non la dichiaro mi ritornera un errore

function saluta(){ //la funzione qui vine solo definita, per eseguirla devo invocarla
    console.log('ciao');
}

saluta(); //invocata e lanciata la funzione