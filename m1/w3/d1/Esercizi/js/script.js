var bloccoRosso = document.getElementById('blocco-rosso');
var blocchiGialli = document.getElementsByClassName('blocchi-gialli');


console.log(bloccoRosso); //ritorna HTTMLElement. ricevo un solo elemento
console.log(bloccoRosso.id); 
console.log(bloccoRosso.innerHTML);//comprende il contenuto dell'elemento preso in causa (quello che c'e scritto dentro)


var div = document.getElementsByTagName('div');
console.log(div);
console.log(div[1].innerHTML);

bloccoRosso.style.backgroundColor = 'red';

console.log(blocchiGialli);
blocchiGialli[0].style.backgroundColor = 'yellow';
blocchiGialli[1].style.backgroundColor = 'yellow';
blocchiGialli[2].style.backgroundColor = 'yellow';


/*consiglio di michele */

var bloccoRossoNew = document.querySelector('#blocco-rosso');
//queryselector accetta qualunque query css, restituisce il primo elemento trovato

var primoBlocco = document.querySelector('.blocchi-gialli');
//il primo elementocon class blocchi-gialli

var blocchiGialliNew = document.querySelectorAll('.blocchi-gialli');
//seleziona tutti i .blocchi-gialli e restituisceun array

var tutto = document.querySelectorAll('#blocco-rosso, .blocchi-gialli');
//prende tutti quelli indicati e restiuisce un array

//funzione

function saluta(){
    alert('Ciao');
}
