

// sul terminale scrivo
// tsc nomefile.ts 
// il  .ts posso ometterlo, tsc andra' in cerca del file /ts con il nome che gli scrivo
// mi compila il file.ts e crea il file.js da collegare poi sui .html

// tsc nomefile.ts -w
// mi fa partire il watch per non dover compilare manualmente ogni volta

// tipizzazione forte
let a:number = 5;
let b:string = '5';
const MIONOME:string = 'Davide';

let ternario:string = a < 2 ? 'is true' : 'is false';

console.log(ternario);


let bool:boolean = true;

// cacate con il not !
if(!!!!!!!!!!!!!!!!!!bool){
    console.log('ciao');
}

// qui gli dico che 'c' SE b esiste prende il suo valore altrimenti e' un array vuoto
// MA se io dichiaro c:string non posso asegnargli []
// quidni uso | per dirgli che se b esiste allora sei una stringa altrimenti sei un []
let c:string|[] = b || [];

//dichiarare array

//array di string
let arr:string[] = ['ciao'] 

// array illegale
let att:any[]= ['ciao', 5, true]


/*
    CICLI
*/ 

//quando dichiaro l'inidice devo dichiarare che e' number
//posso ometterlo ma lui lo mette come 'any' che si e' 
//ok ma e' meglio se glielo dico, si dice ANY IMPLICITO
for(let i:number = 0; i <= 10; i++){
    //fai cose
}