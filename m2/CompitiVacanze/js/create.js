//CREATE

let commentBtn = document.querySelector('#comment-button');

commentBtn.addEventListener('click', (e) => {
    e.preventDefault();
    
    let name = document.querySelector('#name');
    let comContent = document.querySelector('#comment');
    let fullDate = new Date();

    let commento = {
        name: name.value,
        date: fullDate.toLocaleString(),
        comment: comContent.value,
        fullDate: fullDate.getTime(),
    
    }
    let option = {
        method: "POST",
        body: JSON.stringify(commento),
        headers: {
            "content-type": "application/json"
        }
    }

    if(name.value == ''){
        Swal.fire({
            position: 'top-start',
            icon: 'error',
            title: 'Oops...',
            text: 'You must insert your name!',
        })
        }else if(name.value.length > 25){
            Swal.fire({
                position: 'top-start',
                icon: 'error',
                title: 'Oops...',
                text: 'Your name is to long! You can use a nickname instead!',
            })
            
        }else if(comContent.value == ''){
            Swal.fire({
                position: 'top-start',
                icon: 'error',
                title: 'Oops...',
                text: 'We need some content for your post!',
            })
        }else{
            fetch('http://localhost:3000/comments', option)
            .then(res => res.json())
            .then(res => {
                Swal.fire({
                    position: 'top-start',
                    icon: 'success',
                    title: `Thank you ${commento.name} for this post!`,
                    text: `Go check it out!`,
                    showConfirmButton: false,
                    timer: 2000
                }).then(() => {
                    location.reload();
                })
            })
    }



})



