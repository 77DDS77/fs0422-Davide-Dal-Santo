const apiUtenti = "http://localhost:3000/comments"
let parametri = new URLSearchParams(location.search)
let userId = parametri.get("id")

//fetch per prelevare dati utente esistente
fetch(apiUtenti + "/" + userId)
    .then(response => response.json())
    .then(comment => {

        let commContainer = document.createElement('div');
        let name = document.createElement('div')
        let date = document.createElement('div')
        let divComm = document.createElement('div')
        let comm = document.createElement('textarea')
        let divBtns = document.createElement('div')
        let modBtn = document.createElement('button')
        let parent = document.querySelector('#admin-table')

        name.textContent = `${comment.name} (#${comment.id})`;
        date.textContent = comment.date;
        comm.textContent = comment.comment;
        modBtn.textContent = 'Apply'

        commContainer.className = 'comment-container'
        name.className = 'comment-name'
        date.className = 'comment-date'
        comm.className = 'admin-textarea'
        divBtns.className = 'buttons'
        modBtn.className = 'mod-btn'

        divBtns.append(modBtn)
        divComm.append(comm)
        commContainer.append(name, date, divComm, divBtns)
        parent.prepend(commContainer);
        
        let button = document.querySelector(".mod-btn")
        
        
        button.addEventListener("click", function (e) {
            e.preventDefault();
            let date1 = document.querySelector('.comment-date')
            let comm1 = document.querySelector('.admin-textarea')
            console.log(comm1.value);
            sendUpdate(comment.name, date1, comm1, comment.fullDate);
        })
    })



    function sendUpdate(a, b, c, d){

        let comment = {
            name: a,
            date: b.textContent,
            comment: c.value,
            fullDate: d
        }
        
    
        let option = {
            method: "PUT",
            body: JSON.stringify(comment),
            headers: {
                "content-type": "application/json"
            }
        }
    
        Swal.fire({
            title: 'Do you want to save the changes?',
            showDenyButton: true,
            showCancelButton: true,
            confirmButtonText: 'Save',
            denyButtonText: `Don't save`,
        }).then((result) => {
            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) {
                fetch(apiUtenti + "/" + userId, option)
                    .then(res => res.json())
                    .then(res => {
                        Swal.fire({
                            icon: 'success',
                            title: 'Your work has been saved',
                            text: `Comment #${res.id} by ${res.name} has been updated`,
                            showConfirmButton: false,
                            timer: 2000
                        }).then(() => {
                            location.href = "admin.html"
                        })
    
                    })
            } else if (result.isDenied) {
                Swal.fire('Changes are not saved', 'you can keep updating', 'info')
            } else {
                location.href = "admin.html"
            }
        })
    }