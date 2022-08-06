
let options = {

    method: 'DELETE',
    headers: {
        "content-type": "application/json"
    }
}

//delete option with confirmation pop up
function eliminaUtente(id, el) {
    const apiUtenti = 'http://localhost:3000/users';


    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, changed my mind!'
        }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                'Deleted!',
                'This user has been deleted successfully!',
                'success'
            )
            fetch(apiUtenti + '/' + id, options)
                .then(res => res.json())
                .then(res => {
                    el.remove();
                })


        }


    })

}
