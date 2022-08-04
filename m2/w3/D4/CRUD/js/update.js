const apiUtenti = 'http://localhost:3000/utenti';



//URLSearchParams cerca cosa c'e scritto nell'urls
//loication.search restituscie il pezzo di URL dove ci sono scirtti i query params dell'utente
let params = new URLSearchParams(location.search);

//se tolgo l'id dall'url o se arrivo alla pagina per vie artificiose mi rispedisce all'index
if(!params.has('id')){
    location.href = 'index.html';
}

let userId = params.get('id');

fetch(apiUtenti+'/'+userId)//faccio una chiamata fetch per avere solo l'utente che sta modificando
.then(res => res.json())
.then(utente=> {//in risposata mi arriva ovviamente il singolo utente

    //mi aggancio ai campi
    let nome = document.querySelector('#nome');
    let cognome = document.querySelector('#cognome');
    let eta = document.querySelector('#eta');

    //scrivo nei campi i dati messi in precedenza DA MODIFICARE
    nome.value = utente.nome
    cognome.value = utente.cognome
    eta.value = utente.eta
})

let button = document.querySelector('#update button');


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
            text: `L'utente ${res.nome} ${res.cognome} con ID ${res.id} e' stato aggiornato`,
            showConfirmButton: false,
            timer: 2500
        }).then(() => {
            location.href = 'index.html' //dovrebbe reindirizzarmi dopo i 2500ms ma non vanno 
        })
    })
})