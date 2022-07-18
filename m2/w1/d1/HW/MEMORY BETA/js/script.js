
let emoji = ['😀','🤣','😎','😴',
'🤑','👽','😀','🤣','😎','😴','🤑','👽'];

let container = document.querySelector('#container');

// emoji.forEach(element => {
//     let card = document.createElement('div');
//     card.classList.add('card');

//     let numRand = Math.floor(Math.random() * 7);
//     console.log(numRand);
//     card.innerText = emoji[numRand]
//     container.appendChild(card);
// });

// let numRand = Math.floor(Math.random() * (position.length - 1));
// console.log(position);
// console.log(numRand);

// console.log(position.splice(numRand, 1), position);

let i = emoji.length;

while (i != 0 ){
    let card = document.createElement('div');
    card.classList.add('card');

    let numRand = Math.floor(Math.random() * i);

    card.innerText = emoji[numRand];
    container.appendChild(card);
    emoji.splice(numRand, 1);
    console.log(emoji);
    i--
}
