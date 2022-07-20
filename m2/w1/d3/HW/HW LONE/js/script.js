const UP = document.querySelector('#su');
const GIU = document.querySelector('#giu');
const DX = document.querySelector('#dx');
const SX = document.querySelector('#sx');

let box = document.querySelector('.box');
let deg = 0;

UP.addEventListener('click', () => {
    deg += 90;
    box.style.transform = `rotateX(${deg}deg)`
});
GIU.addEventListener('click', () => {
    deg -= 90;
    box.style.transform = `rotateX(${deg}deg)`
});
DX.addEventListener('click', () => {
    deg -= 90;
    box.style.transform = `rotateY(${deg}deg)`
});
SX.addEventListener('click', () => {
    deg += 90;
    box.style.transform = `rotateY(${deg}deg)`
});



