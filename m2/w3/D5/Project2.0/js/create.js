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
            icon: 'success',
            title: 'New User created!',
            text: `User ${res.firstName} ${res.lastName} ID #${res.id} has been created and added succesfully`,
            showConfirmButton: true,
          }).then(() => {
            location.href = 'index.html' 
       })
    })

})