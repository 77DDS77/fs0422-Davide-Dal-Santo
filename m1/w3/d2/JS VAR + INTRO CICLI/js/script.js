// variabili.html

var stringa = 'prova';
var stringa2 = "prova";  //apice o apici doppi non cambia nulla

var html = '<div class="test"></div>'; //qui apro per forza con quelli singoli
                                    //perche se no va in conflito con gli apici doppi della classe
var html = "<div class=\"test\"></div>"; //backslash prima di apici doppi per dire che fanno parte della stringa

var html3 = '<class="test>' + stringa + '</div>'; //concatenamento

//interpolazione di stringe

var html4 = `<div class="test"> ${stringa} </div>`;
console.log(html4);

// var id = '#blocco';
// document.querySelector(id);
var separatore = '============';
console.log(separatore);


// let ----------------------------------------------------------------

let a = 5;
console.log(a);

{
    console.log(a);
}

{//blocco
    let b = 4;
    console.log(b);//se queesto lo sposto fuori dal blocco mi da errore
}

//let e' una variabile di scopo, vuol dire che se io creo una let dentro un blocco
// essa rimarra' utilizzabile solo dentro al blocco (si dice block scope)


console.log(separatore);
// const--------------------------------------------------------
// per convenzione le const hanno nomi IN STAMPATELLO
// const come let e' una variabile di scopo, nasce e muore all'interno di un blocco

const c = 2;
console.log(c);
// c = 1;  errore: non posso riassegnare il valore di una costante


//caso in cui posso modificare una const
const obj = {
    nome: 'Fabiola',
    cognome: 'Barone'
}

obj.nome = 'Davide';
console.log(obj);


console.log(separatore);
//OPERATORI------------------------

var x =  10;
x = 11;

x += 2; //assegan un valore +2 mantenendo il valore precedente
console.log(x);

x++   //+1
console.log(x);

x--   //-1
console.log(x);

//+ operatore matematica ma anche operatire concatenamento

var saluto = 'Ciao ';
saluto += 'Mario';
console.log(saluto);

let prova = document.querySelector('#prova');
prova.innerHTML += '<li>item</li>';
prova.innerHTML += '<li>item</li>';
prova.innerHTML += '<li>item</li>';
prova.innerHTML += '<li>item</li>';
console.log(prova.innerHTML);


console.log(separatore);
console.log(separatore);
//---------------------------------------
//--------------IF.html-------------------
//---------------------------------------

console.log( 1 == 1);

console.log( 1 === 1);
console.log( 1 === '1'); 
//triplo uguale STRETTAMENTE uguale, controllo anche se il tipo di dato e' identico

let z = 'ciao';

let y = 'Hi';
console.log(x != y);
//  != diverso !== strettamente diverso

let n = 10;

console.log(n >= 10);//true solo se superiore
console.log(n >= 10); //true se n e' superiore o uguale a 10
console.log(n < 10);
console.log(n <= 10);

console.log(separatore);

console.log(!(n <= 10)); 
//not usato per invertire il risultato di un valore boolean

console.log(n > 10 || n == 10);
//OR, n>10 or n==10

console.log(n > 10 && n == 10);
//AND, n>10 E n==10

console.log(separatore);

//---------------IF-------------

let condizione = true;
if(condizione){
    console.log('vero');
}else{
    console.log('falso');
}


let numero = 28;
if(numero > 30){ //se numero > 30 allora:
    console.log('superiore');
}else if(numero == 30){ //altrimenti se numero uguale a 30:
    console.log('uguale');
}else{// altrimenti se NE numero > 30  NE numero = 30 allora:
    console.log('inferiore');
}


let h = 'ciao';
let l = 'ciao';
if(h == l){  //'trabocchetto', ricordarsi il doppio == e no =singolo
    console.log('vero');
}


