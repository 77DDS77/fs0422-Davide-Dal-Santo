
let emoji = ['😀','🤣','😃','😎','😴',
'🤑','👽','😀','🤣','😃','😎','😴','🤑','👽'];

let position = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]

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




emoji.forEach(element => {
    let card = document.createElement('div');
    card.classList.add('card');

    while(position.length != 0) {
        let numRand = Math.floor(Math.random() * (position.length - 1));
        console.log(position);
        
        card.innerText = emoji[numRand];
        console.log(emoji[numRand]);
        container.appendChild(card);
        position.splice(numRand, 1);

    }

});