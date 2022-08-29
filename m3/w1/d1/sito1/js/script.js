// sul terminale scrivo
// tsc nomefile.ts 
// il  .ts posso ometterlo, tsc andra' in cerca del file /ts con il nome che gli scrivo
// mi compila il file.ts e crea il file.js da collegare poi sui .html
// tsc nomefile.ts -w
// mi fa partire il watch per non dover compilare manualmente ogni volta
// tipizzazione forte
var a = 5;
var b = '5';
var MIONOME = 'Davide';
var ternario = a < 2 ? 'is true' : 'is false';
console.log(ternario);
var bool = true;
// cacate con il not !
if (!!!!!!!!!!!!!!!!!!bool) {
    console.log('ciao');
}
// qui gli dico che 'c' SE b esiste prende il suo valore altrimenti e' un array vuoto
// MA se io dichiaro c:string non posso asegnargli []
// quidni uso | per dirgli che se b esiste allora sei una stringa altrimenti sei un []
var c = b || [];
//dichiarare array
//array di string
var arr = ['ciao'];
// array illegale
var att = ['ciao', 5, true];
/*
    CICLI
*/
//quando dichiaro l'inidice devo dichiarare che e' number
//posso ometterlo ma lui lo mette come 'any' che si e' 
//ok ma e' meglio se glielo dico, si dice ANY IMPLICITO
for (var i = 0; i <= 10; i++) {
    //fai cose
}
// 
// consizioni.ts
// 
// tsc script condizioni --outFile js/script.js -w
//  comando che mi compila tutti e due i miei file .ts 
// sullo stesso file .js
// -w mi attiva il watch
console.log(new Date().getDay());
var day = new Date().getDay();
if (day == 0) {
    console.log('Domenica');
}
else if (day == 1) {
    console.log('Lunedi');
} //blablabla
switch (day) {
    case 0:
        console.log('Domenica');
        break;
    case 1:
        console.log('Lunedi');
        break;
    case 2:
        console.log('Martedi');
        break;
    //eccetera, molto piu veloce e sensato
}
var stringa = 'Mario';
var numero = 0;
var booleano = false;
var oggetto = {};
var array = [];
var union = true;
var any = [];
var varvuota; // per variabile vuota, ricordarsi il !, gli dice "so che non c'e niente, dopo  ariva qualcosa"
var altravuota; //se vuota la mette undefined
var sconosciuto = {};
//come dichiare un oggetto con tipizzazione
var oggetto2;
oggetto2 = {
    nome: 'Mario',
    cognome: 'Rossi'
};
console.log(oggetto2.nome);
//:void comunica che e' una funzione che non ritorna nulla, esegue e basta
function saluta() {
    console.log('ciao');
}
//:string dichiaro che il valore di return e' una stringa
function saluta2() {
    return "ciao";
}
function saluta3(saluto) {
    return saluto;
}
//argomento/parametro facoltativo
function saluta4(saluto) {
    if (saluto === void 0) { saluto = null; }
    return saluto;
}
saluta();
console.log(saluta2());
console.log(saluta3('We pirletti'));
console.log(saluta4());
var User = /** @class */ (function () {
    function User() {
    }
    return User;
}());
//il constructor non mi serve perche non istanzio un nuovo oggetto User
//sto solo dichiarando il tipo di dato che oggetto3 sara'
//e oggetto3 sara' quello che dichiaro dentro user
var oggetto3 = {
    nome: 'Mario',
    cognome: 'Rossi'
};
//dichiaro che utenti e' un array di User, dentro posso metterci solo oggetti con le proprieta'
//di User
var utenti = [oggetto2, oggetto3];
console.log(utenti);
/*
DATE
*/
//posso usare Date per tipizzare la variabile
var oggi = new Date();
