//coalescenza
//se cio che c'e' a sinistra e' null allora metti 0
let eta = prompt('Quanti anni hai?') || 0;

//teranrio
let accesso = (eta >= 18) ? 'Acesso consenitto' : 'Acesso negato';

document.write(accesso);

//usare reutrn per bloccare la funzione

function checkAge(eta){
    if(eta >= 18){
        return 'accesso consentito';
    }
    return 'accesso negato';
}

console.log(checkAge(17));

//UTILIZZO DI VARIABILI GLOBALI

let contatore = 0;

function incrementa(){
    contatore++;
}

incrementa();

console.log(contatore);


//utilizzo di parametri

function somma(a,b,c){
    return a + b + c;
}

console.log(somma(1,2,3));

//funzione con parametri di default
//se non metti c,d,e o f viene usato quello default
function somma2 (a,b,c=0,d=0,e=0,f=0){
    return a + b + c + d + e + f;
}

console.log(somma2(1,2,3));


function somma3 (a,b,c,d,e){
    //controllare esistenza parametri

    //if
    if(!c){
        c=0;
    }

    //or
    d = d || 0;

    //ternario
    e = e ? e : 0;

    return a + b + c + d + e;
}

console.log(somma3(1, 2, 3, 4, 5));

function azione(tipoAzione = 1){
    if(tipoAzione == 1){
        //esegui questa cosa
    }else if(tipoAzione == 2){
        //edegui questo set di azioni
    }else if (tipoAzione == 3){
        //edegui questo set di azioni
    }else{
        //esegui questa cosa
    }
}

let funzione = function(){
    console.log('ciao');
}

console.log( funzione(), funzione);


//funzione autoinvocata
(function(){
    console.log('eseguita');
})();


let dato = (function(){
    return('eseguita');
})();

console.log(dato + ' questo')

//CLOSURE

function primaFn(){
    let dato = 10;
    function secondaFn(){
        return dato + dato;
    }
    let datoUltimo = secondaFn() * 2;
    return datoUltimo;
}

console.log(primaFn());


function fnAnnidata(a){
    return function(b){
        return function(c){
            return a + b + c;
        }
    }
}

console.log(fnAnnidata(5)(4)(7));






