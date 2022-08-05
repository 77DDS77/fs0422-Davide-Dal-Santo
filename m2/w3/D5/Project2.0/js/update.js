const apiUtenti = 'http://localhost:3000/users';


let params = new URLSearchParams(location.search);

if(!params.has('user')){
    location.href = 'index.html';
}

let userId = params.get('user');

fetch(apiUtenti+'/'+userId)
.then(res => res.json())
.then(utente=> {


    let nome = document.querySelector('#nome');
    let cognome = document.querySelector('#cognome');
    let gender = document.querySelector('#gender');
    let mail = document.querySelector('#mail');
    let profileURL = document.querySelector('#profileURL');
    let username = document.querySelector('#username');


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
        body: JSON.stringify(user),
        headers: {
            "content-type": "application/json"
        }

    }


    fetch(apiUtenti+'/'+userId, options)
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