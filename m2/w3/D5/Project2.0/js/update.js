const apiUtenti = 'http://localhost:3000/users';



//URLSearchParams cerca cosa c'e scritto nell'urls
//loication.search restituscie il pezzo di URL dove ci sono scirtti i query params dell'utente
let params = new URLSearchParams(location.search);

//se tolgo l'id dall'url o se arrivo alla pagina per vie artificiose mi rispedisce all'index
if(!params.has('user')){
    location.href = 'index.html';
}

let userId = params.get('user');

fetch(apiUtenti+'/'+userId)//faccio una chiamata fetch per avere solo l'utente che sta modificando
.then(res => res.json())
.then(utente=> {//in risposata mi arriva ovviamente il singolo utente

    //mi aggancio ai campi
    let nome = document.querySelector('#nome');
    let cognome = document.querySelector('#cognome');
    let gender = document.querySelector('#gender');
    let mail = document.querySelector('#mail');
    let profileURL = document.querySelector('#profileURL');
    let username = document.querySelector('#username');

    //scrivo nei campi i dati messi in precedenza DA MODIFICARE
    nome.value = utente.firstName
    cognome.value = utente.lastName
    gender.value = utente.gender
    mail.value = utente.email
    profileURL.value = utente.profileURL
    username.value = utente.username
})

let button = document.querySelector('#update button');


button.addEventListener('click', function (e) {
    e.preventDefault();

    let nome = document.querySelector('#nome');
    let cognome = document.querySelector('#cognome');
    let gender = document.querySelector('#gender');
    let mail = document.querySelector('#mail');

    let user = {
        username: username.value,
        firstName: nome.value,
        lastName: cognome.value,
        gender: gender.value,
        email: mail.value,
        profileURL: profileURL.value
    }

    console.log(user);


    let options = {

        method: 'PUT',
        body: JSON.stringify(user), //questi sono i dati da inviare
        headers: {//serie di informazioni che definiscono la richiesta e la risposta
            "content-type": "application/json"
        }

    }


    fetch(apiUtenti+'/'+userId, options)//eseguo la chiamata PUT per aggiornare quel singolo utente
    .then(res => res.json())
    .then(res => {
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Utente aggiornato',
            text: `L'utente ${res.firstName} ${res.lastName} ID ${res.id} e' stato aggiornato`,
            showConfirmButton: false,
            timer: 2000
        }).then(() => {
             location.href = 'index.html' 
        })
    })
})