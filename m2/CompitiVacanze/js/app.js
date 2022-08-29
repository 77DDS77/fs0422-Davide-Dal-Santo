//event listern for admin area access
let adminBtn = document.querySelector('#admin-area')

adminBtn.addEventListener('click', () => {
    Swal.fire({
        title: 'Insert Admin Password',
        input: 'password',
        inputAttributes: {
            autocapitalize: 'off'
        },
        showCancelButton: true,
        confirmButtonText: 'Try'
    }).then((result) => {
        if(result.isConfirmed){
            if(result.value === 'test'){
                adminBtn.innerHTML = '<i class="fa-solid fa-lock-open"></i>'
                window.location.href = "./admin.html";
            }else{
                Swal.fire({
                    icon: 'error',
                    title: 'Access Denied',
                    text: 'Incorrect Password!'
                  })
            }
        }
    })
})