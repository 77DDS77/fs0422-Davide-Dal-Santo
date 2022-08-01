listaUtenti = localStorage.getItem('listaUtenti') ? JSON.parse(localStorage.getItem('listaUtenti')) : [];

let submit = document.querySelector('#submit');

document.onload = LSTable();

submit.addEventListener('click', (e) => {
    e.preventDefault();
    let nome = document.querySelector('#userName');
    let cognome = document.querySelector('#userSurname');
    let data = document.querySelector('#userDob');

    let utente = new User(nome.value, cognome.value, data.value);

    setUserLS(utente);
})


function setUserLS(utente){ 

    listaUtenti.push(utente);

    localStorage.setItem('listaUtenti', JSON.stringify(listaUtenti));

}

function LSTable(){
    let tBody = document.getElementById('tableBody');
    for(let utente of listaUtenti){
        console.log(utente);
        let trLS= document.createElement('tr');
        for(let prop in utente){
            console.log(prop, utente[prop]);
            let tdLS = document.createElement('td');
            tdLS.textContent = utente[prop];
            trLS.append(tdLS);
        }
        tBody.append(trLS);
    }
}

class User {
    constructor(nome, cognome, data) {
        this.nome = nome;
        this.cognome = cognome;
        this.data = data;

        this.createTable();
    }

    createTable(){
        let tBody = document.getElementById('tableBody');
        let tr = document.createElement('tr');
        let tdNome = document.createElement('td');
        let tdCognome = document.createElement('td');
        let tdData = document.createElement('td');

        tdNome.textContent = this.nome;
        tdCognome.textContent = this.cognome;
        tdData.textContent = this.data;

        tr.append(tdNome, tdCognome, tdData);
        tBody.append(tr);

    }

}

