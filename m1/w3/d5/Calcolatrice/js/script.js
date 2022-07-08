//selector
const clientText = document.querySelector('.client-text');//testo in alto
const result = document.querySelector('.result');//risulato sotto
const keys = document.querySelectorAll('.calcbtn');//bottoni

//event listener, for each button clicked execute finction

keys.forEach(tastoPremuto =>{
    tastoPremuto.addEventListener('click',calculate);
});

function calculate() {
    let tastoPremutoText = this.innerText;
    try {
        if (tastoPremutoText === 'AC') {
            clientText.innerText = '';
            result.innerText = '0';
            result.style.animation = ''; //animation reset
            clientText.style.animation = ''; //animation reset
            return;
        }
        if (tastoPremutoText === 'DEL') {
            clientText.textContent = clientText.textContent.substring(
                0, clientText.textContent.length - 1);
            return;
        }

        if (tastoPremutoText === '=') {
            result.innerText = eval(clientText.innerText); //eval = EVIL
            result.style.animation = 'big 0.3s ease-in-out';
            clientText.style.animation = 'small 0.3s ease-in-out';
            result.style.animationFillMode = 'forwards';
            clientText.style.animationFillMode = 'forwards'; //fa in modo che lanimazione non torni alla sua initial position
            return
        }

        if (tastoPremutoText === 'X') {
            clientText.innerText += '*'
        }
        else {
            clientText.innerText += tastoPremutoText;

            return;
        }
    } catch {
        result.innerText = 'Syntax error';
    }
}


//function to change the stiling of calculator + body background color
function change(elemento){
    let vanish = document.querySelector(elemento);
    
    if(!vanish.classList.contains('vanish')){
        document.querySelector('body').style = 'background: rgb(81,70,137);background: linear-gradient(315deg, rgba(81,70,137,1) 20%, rgba(167,164,224,1) 100%);'
        vanish.classList.add('vanish');
    }else{
        document.querySelector('body').style = 'background-color: #df8200;background-image: linear-gradient(315deg, #df8200 0%, #ffe692 74%);';
        vanish.classList.remove('vanish');
    }
    
    // vanish.classList.toggle('vanish'); non funziona piu perche' cho messo il background
}
