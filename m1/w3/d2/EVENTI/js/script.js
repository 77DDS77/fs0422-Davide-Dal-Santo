// function aggiungiNumero(bottone){
//     let display = document.getElementById('display');
//     display.value += bottone.innerHTML;
//     console.log(display.value);

// }

// function svuota(bottone){
//     let display = document.getElementById('display');
    
// }

/*.value mi serve per gli input o i tag autoconclusivi per vedere cosa c'e' dentro*/


function aggiungiNumero(bottone){
    
    if(bottone.innerHTML == 'AC'){
        display.value ='';
    }else if(bottone.innerHTML[0] != '0'){ //sbagliato no va il not non posso piu scrivere zero
        let display = document.getElementById('display');
        display.value += bottone.innerHTML;
        console.log(display.value);
    };
    

}