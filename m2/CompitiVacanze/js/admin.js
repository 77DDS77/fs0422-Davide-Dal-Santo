createAdminTable();

async function createAdminTable() {

    let adminTable = document.querySelector('#admin-table');

    let [comments] = await Promise.all([
        fetch('http://localhost:3000/comments').then(res => res.json())
    ])

    for (let comment of comments) {

        commentCreation(comment, adminTable)

    }
}




function commentCreation(comment, parent) {
    let commContainer = document.createElement('div');
    let name = document.createElement('div')
    let date = document.createElement('div')
    let divComm = document.createElement('div')
    let comm = document.createElement('textarea')
    let divBtns = document.createElement('div')
    let modBtn = document.createElement('button')
    let delBtn = document.createElement('button')

    name.textContent = `${comment.name} (#${comment.id})`;
    date.textContent = comment.date;
    comm.textContent = comment.comment;
    modBtn.textContent = 'Modify'
    delBtn.textContent = 'Delete'

    commContainer.className = 'comment-container'
    name.className = 'comment-name'
    date.className = 'comment-date'
    comm.className = 'admin-textarea'
    divBtns.className = 'buttons'
    modBtn.className = 'mod-btn'
    delBtn.className = 'del-btn'

    comm.setAttribute('readOnly', 'true')

    divBtns.append(modBtn, delBtn)
    divComm.append(comm)
    commContainer.append(name, date, divComm, divBtns)
    parent.prepend(commContainer);

    //buttons logic
    modBtn.addEventListener('click', () => {
        window.location.href = "modifica-commento.html?id=" + comment.id;
        //fare pagina modifica e js modifica
    })

    delBtn.addEventListener('click', () => {
        deleteComment(comment.id, commContainer)
    })

}



function deleteComment(id, elemento) {
    let api = 'http://localhost:3000/comments'
    let option = {
        method: "DELETE",
        headers: {
            "content-type": "application/json"
        }
    }

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
            fetch(api + "/" + id, option)
                .then(response => response.json())
                .then(response => {
                    Swal.fire({
                        icon: 'success',
                        title: 'Your work has been saved',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(() => {
                        elemento.remove()
                        window.location.reload();
                    })
                })
        }
    })
}
