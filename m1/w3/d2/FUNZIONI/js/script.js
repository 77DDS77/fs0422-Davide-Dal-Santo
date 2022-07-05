function saluta(){
    alert('CAIO!');
}

//saluta(); disattivata perche caga il cazzo

function ottieniSaluto(){
    return 'ciao'; //return decide qual'e' il dato ritornato dalla funzione ottieniSaluto e TERMINA la funzione
}

let saluto = ottieniSaluto();
console.log(saluto);

function salutaPRO(testo){ //testo e' una variabile che esiste solo dentro alla funzione, una specie di segnaposto
    alert(testo);
}

salutaPRO('ciao'); 

function creaTag(testo,tag){
    return '<'+tag+'>'+testo+'</'+tag+'>';
}

let grassetto = creaTag('prova', 'b');
let corsivo = creaTag('prova', 'i');
console.log(grassetto, corsivo);

document.write(corsivo);

function somma(a,b){
    return a + b;
}

console.log(somma(15, 18)); //non fa 36

