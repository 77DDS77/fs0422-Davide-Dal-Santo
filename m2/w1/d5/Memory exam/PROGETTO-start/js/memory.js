let arrayAnimali = ['🐱', '🦉', '🐾', '🦁', '🦋', '🐛', '🐝', '🐬', '🦊', '🐨', '🐰', '🐯', '🐱', '🦉', '🐾', '🦁', '🦋', '🐛', '🐝', '🐬', '🦊', '🐨', '🐯', '🐰'];
//libreria per icone
//https://html-css-js.com/html/character-codes/


let arrayComparison = [];

let scores = localStorage.getItem('Scores') || '[]';

scores = JSON.parse(scores);

console.log(scores);

let tbody = document.querySelector('#leaderboard tbody')

let nicknameSet = document.querySelector('#nicknameSet');

document.body.onload = startGame();


var interval; //var globale fuori dalla funct per resettarla ad ogni avvio

var iconsFind = document.getElementsByClassName('find'); //mi serve dopo

var modal = document.querySelector('#modal');//win message DIV

var timer = document.querySelector('.timer');//timer DIV

//card shuffle
function shuffle(a) {
    var currentIndex = a.length;
    var temporaryValue, randomIndex;

    while (currentIndex !== 0) {
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex -= 1;
        temporaryValue = a[currentIndex];
        a[currentIndex] = a[randomIndex];
        a[randomIndex] = temporaryValue;
    }
    return a;
}

//function to start the game

function startGame(){

    //shuffle
    var arrayShuffle = shuffle(arrayAnimali);

    //resetto il timer con metodo clearInterval
    clearInterval(interval);

    //svuoto l'array di appoggio da eventuali game precedenti
    arrayComparison = [];

    //aggancio div id griglia
    let griglia = document.querySelector('#griglia');

    //pulisco il suo contenuto
    griglia.innerHTML ='';

    //creazione della griglia
    //sistemato limite iterazione per miglior scalabilita'
    for(let z = 0; z < arrayAnimali.length; z++){ //justice for the 'i' variable
        let cardContainer = document.createElement('div');
        let card = document.createElement('div');
        card.classList.add('icon');
        card.innerHTML = arrayShuffle[z];//assegno ad ogni carta il valore z pescando dall'array shufflato

        griglia.append(cardContainer);
        cardContainer.append(card)
        card.addEventListener("click", displayIcon);
        card.addEventListener("click", popUpModal);
    }
    

    //invoco la funzione timerStart per far partire il timer
    timerStart();

    //creazione della leadeboard
    leaderboardGenerator();

}

// =============================================================================================

function displayIcon() {
    var icon = document.getElementsByClassName("icon");
    var icons = [...icon];

    //mette/toglie la classe show
    this.classList.toggle("show");
    //aggiunge l'oggetto su cui ha cliccato all'array del confronto
    arrayComparison.push(this);

    var len = arrayComparison.length;
    //se nel confronto ci sono due elementi
    if (len === 2) {
        //se sono uguali aggiunge la classe find
        if (arrayComparison[0].innerHTML === arrayComparison[1].innerHTML) {
            arrayComparison[0].classList.add("find", "disabled");
            arrayComparison[1].classList.add("find", "disabled");
            arrayComparison = [];
        } else {
            //altrimenti (ha sbagliato) aggiunge solo la classe disabled
            icons.forEach(function(item) {
                item.classList.add('disabled');
            });
            // con il timeout rimuove  la classe show per nasconderli
            setTimeout(function() {
                arrayComparison[0].classList.remove("show");
                arrayComparison[1].classList.remove("show");
                icons.forEach(function(item) {
                    item.classList.remove('disabled');
                    for (var i = 0; i < iconsFind.length; i++) {
                        iconsFind[i].classList.add("disabled");
                    }
                    
                });
                arrayComparison = [];
                
            }, 700);
        }
    }
}

//una funzione che viene mostrata alla fine quando sono tutte le risposte esatte

function popUpModal(){
    if(iconsFind.length == 24){
        clearInterval(interval);
        modal.classList.add('active');
        document.getElementById('tempoTrascorso').innerHTML = 
        timer.innerHTML;
 
    }

}


// una funzione che nasconde la modale alla fine e riavvia il gioco

function playAgain(){
        modal.classList.remove('active');
        startGame();
};


/*-------------------------------
Se non volessi usare l'Onclick dentro il tagHTML potrei usare lo script seguente:

let playAgainBtn = document.querySelector('p .button')

playAgainBtn.addEventListener('click', playAgain);

----------------------------------*/


// una funzione che calcola il tempo e aggiorna il contenitore sotto

function timerStart(){
    let sec = 0;
    let min = 0;

    //Setto il timer con metodo Set interval
    //intervallo da 1000ms, ogni iterazioen aumentano i secondi, 
    //logic check per avanzamento minuti
    interval = setInterval(function(){
        timer.innerHTML= `Timer: ${min} min e ${sec} sec`;

        sec++;

        if(sec == 60){
            min++;
            sec = 0;
        }
        if(min == 60){
            min = 0;
            window.alert('Achievement Unlocked! More than an hour for a Memory match!')
        }
    }, 1000)
}


//================================================EXTRA


//-----------------Local Storage test area
function set_Score(key,value){
 //localStorage.setItem("name of variable", "value to store");
    scores.push(value)
    localStorage.setItem(key, JSON.stringify(scores));
}//End set_LocalStorage


//Defining User obj construction 
class User{
    constructor(username, score){
        this.username = username;
        this.score = score;
    }
}

//HTML leaderboard generator

function leaderboardGenerator(){
    tbody.innerHTML = '';
    for(let score of scores){
        let tr = document.createElement('tr');
        for(let prop in score){
            let td = document.createElement('td');
            td.innerHTML = score[prop];
            tr.append(td);
        }
        tbody.append(tr);
    }
}

//setting the user input for his nickname to be stored in local storage
//and creating his user (nickname + timer)

nicknameSet.addEventListener('click', () => {
    let nickname = document.querySelector('#nickname');
    let newScore = new User(nickname.value , timer.innerHTML)
    //volevo un console log pulito, interpolazxione e concatenamento non funzionavano
    console.log('New user has been stored in local storage:'); 
    console.log(newScore);

    set_Score('Scores', newScore);

    modal.classList.remove('active');
    startGame();
});