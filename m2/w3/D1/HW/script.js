listaUtenti = localStorage.getItem('listaUtenti') ? JSON.parse(localStorage.getItem('listaUtenti')) : [];

class User {
    constructor() {

        this.nomeU = '';
        this.cognomeU = '';
        this.dobU = '';

        this.userData();
    }

    userData() {
        let submit = document.querySelector('#submit');
        submit.addEventListener('click', (e) => {
            e.preventDefault();
            let nome = document.querySelector('#userName').value;
            let cognome = document.querySelector('#userSurname').value;
            let dob = document.querySelector('#userDob').value;

            console.log(nome, cognome, dob);

            this.nomeU = nome;
            this.cognomeU = cognome;
            this.dobU = dob;

            let arrUser = [
                this.nomeU,
                this.cognomeU,
                this.dobU
            ];

            let user = new User(this.nomeU, cognome, dob);
            listaUtenti.push(user);
            let strUser = JSON.stringify(listaUtenti) 
            localStorage.setItem('Lista Utenti', strUser);

            this.createTable(arrUser);

        });

    }

    createTable(array) {

        let tableBody = document.querySelector('#tableBody');
        let tRow = document.createElement('tr');
        for (let prop of array) {
            let tElement = document.createElement('td');
            tElement.innerHTML = prop;
            tRow.append(tElement);
        }

        tableBody.append(tRow);
    }

}

let user1 = new User();
console.log(user1);