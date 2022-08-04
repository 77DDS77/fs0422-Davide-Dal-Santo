const apiUtenti = 'http://localhost:3000/utenti';

let button = document.querySelector('#create button');


button.addEventListener('click', function (e) {
    e.preventDefault();

    let nome = document.querySelector('#nome');
    let cognome = document.querySelector('#cognome');
    let eta = document.querySelector('#eta');

    let user = {
        nome: nome.value,
        cognome: cognome.value,
        eta: eta.value
    }


    let options = {

        method: 'POST',
        body: JSON.stringify(user), //questi sono i dati da inviare
        headers: {//serie di informazioni che definiscono la richiesta e la risposta
            "content-type": "application/json"
        }

    }


    fetch(apiUtenti, options)//questo andrebbe anche senza i then ma li uso per l'alert che mi da conferma della creazioen dell'utente
    .then(res => res.json())
    .then(res => {
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Nuovo utente creato',
            text: `L'utente ${res.nome} ${res.cognome} con ID ${res.id} e' stato creato`,
            showConfirmButton: false,
            timer: 5000
          })
    })
})
