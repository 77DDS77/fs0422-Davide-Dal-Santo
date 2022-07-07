//PUTNO 1

let str = 'Mario Rossi';

console.log(str.toLowerCase());
console.log(str.toUpperCase());

let strCh1 = str.split('')[0];
let strCh2 = str.split('')[6];
console.log(`Sigla: ${strCh1} ${strCh2}`);

//PUNTO 2 + PUNTO 3 + PUTNO 4

let p1 = 'Mario Menego';
let p2 = 'Gianni Fugassa';
let p3 = 'Alfredo Megiasso';
let p4 = 'Nosuki Makinoti';

let pArr = [p1, p2, p3, p4];
console.log(pArr);
console.log(pArr[2]);
console.log(`Lunghezza Array: ${pArr.length} elementi`);


//PUNTO 5

let numArr = [1, 2, 3, 4, 17];

function sommaArr(){
    let num1 = numArr[Math.floor(Math.random()*5)];
    let num2 = numArr[Math.floor(Math.random()*5)];
    console.log(`Sto sommando ${num1} e ${num2}`);
    return num1 + num2;
}

console.log(sommaArr());

//PUNTO 6

let array = ['Pippo Baudo', 'Lupo Lucio', 'Cristiano Malgioglio',
            'Bambula Star'];

console.log(array.pop(2,3));//tolgo Bambula Star
array.push('Katusha');//inserisco Katusha
console.log(array);

array = ['Pippo Baudo', 'Lupo Lucio', 'Cristiano Malgioglio',
            'Bambula Star'];
array.shift();//Pippo Baudo in nomination e viene eliminato
console.log(array);
array.unshift('Tonio Cartonio');
console.log(array);

