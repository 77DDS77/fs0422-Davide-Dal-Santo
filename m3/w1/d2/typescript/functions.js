//ricordarsi dopo parentesi parametri di mettere il tipo di dato restituito dalla funzione
// :void dice che la funzione non restituisce niente
var _a;
function prova() {
    //non posso restituire niente perche' la funzione restituisce void
    console.log('ciao');
}
prova();
//funzione restituisce una stringa
function stringa() {
    return 'Questa funzione restituisce una stringa';
}
console.log(stringa());
//dati in entrata
// il parametro testo deve essere di tipo stringa ed e' obbligatorio
function maiusc(testo) {
    return testo.toUpperCase();
}
var upper = maiusc('ciao come stai?');
console.log(upper);
// le funzioni void possono essere parametrizzate
function voidUpper(testo) {
    console.log(testo.toUpperCase());
}
voidUpper('ciao');
//se passo con il mouse sul query selector vedo che restituisce un HTMLElement 
// o NULL quidni dove scrvo il tipo di output devo considerarli tutti e due
function $(selettore) {
    return document.querySelector(selettore);
}
//il ? serve a far si che gli attributi vengano letti 
//solo se la funzione $() non resituisce null
(_a = $('.elemento')) === null || _a === void 0 ? void 0 : _a.style.color;
//syntassi funzione freccia ad una riga
var X = function (selettore) { return document.querySelector(selettore); };
X('.elemento');
