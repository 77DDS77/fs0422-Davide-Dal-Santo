// 
// consizioni.ts
// 
// tsc script condizioni --outFile js/script.js -w
//  comando che mi compila tutti e due i miei file .ts 
// sullo stesso file .js
// -w mi attiva il watch

console.log(new Date().getDay());

let day:number = new Date().getDay();

if(day == 0){
    console.log('Domenica');
}else if(day == 1){
    console.log('Lunedi');
}//blablabla

switch(day){
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