const apiUtenti = 'http://localhost:3000/users';

let button = document.querySelector('#btnNewUser');


button.addEventListener('click', function (e) {
    e.preventDefault();

    let nome = document.querySelector('#nome');
    let cognome = document.querySelector('#cognome');
    let gender = document.querySelector('#gender');
    let mail = document.querySelector('#mail');
    let profileURL = document.querySelector('#profileURL');
    let username = document.querySelector('#username');

    let user = {
        username: username.value,
        firstName: nome.value,
        lastName: cognome.value,
        gender: gender.value,
        email: mail.value,
        profileURL: profileURL.value
    }


    let options = {

        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            "content-type": "application/json"
        }

    }


    fetch(apiUtenti, options)
    .then(res => res.json())
    .then(res => {
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Nuovo utente creato',
            text: `L'utente ${res.nome} ${res.cognome} con ID ${res.id} e' stato creato`,
            showConfirmButton: true,
          }).then(() => {
            location.href = 'index.html' 
       })
    })
})