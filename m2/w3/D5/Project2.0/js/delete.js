
let options = {
    
    method: 'DELETE',
    headers: {
        "content-type": "application/json"
    }
}




function eliminaUtente(id, el){
    const apiUtenti = 'http://localhost:3000/users';

    fetch(apiUtenti+'/'+id, options)
    .then(res => res.json())
    .then(res => {

        el.remove();

    })
    Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Utente eliminato',
        text: `L'utente e' stato eliminato`,
        showConfirmButton: true,
    }).then(() => {
        location.href = 'index.html'
    })
    
}