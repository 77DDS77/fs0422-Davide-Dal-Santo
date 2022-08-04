
let options = {
    
    method: 'DELETE',
    headers: {//serie di informazioni che definiscono la richiesta e la risposta
        "content-type": "application/json"
    }
}




function eliminaUtente(id, el){
    const apiUtenti = 'http://localhost:3000/utenti';

    fetch(apiUtenti+'/'+id, options)
    .then(res => res.json())
    .then(res => {

        el.remove();

        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Utente eliminato',
            text: `L'utente e' stato eliminato`,
            showConfirmButton: false,
            timer: 2500
        })
    })
}