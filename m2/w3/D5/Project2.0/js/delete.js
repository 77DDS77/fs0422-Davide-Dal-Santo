
let options = {

    method: 'DELETE',
    headers: {
        "content-type": "application/json"
    }
}




function eliminaUtente(id, el) {
    const apiUtenti = 'http://localhost:3000/users';

    fetch(apiUtenti + '/' + id, options)
        .then(res => res.json())
        .then(res => {
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted, reload the page!.',
                    'success'
                )
                el.remove();//drunk fix later
                location.href = 'index.html'
            }
        })

        })

}
