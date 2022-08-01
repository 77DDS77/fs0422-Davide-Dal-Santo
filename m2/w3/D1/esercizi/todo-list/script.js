let bottone = document.querySelector('#salva');


bottone.addEventListener('click', function(){

    let testo = document.querySelector('#testo');
    let lista = document.querySelector('#lista');

    if(testo.value == ''){
        alert('Please insert task');
    }else{
        
        let elemento = document.createElement('div');
        elemento.classList.add('alert','alert-success')
        elemento.innerHTML = testo.value;
        lista.append(elemento);
        testo.value = '';

        elemento.addEventListener('dblclick', function(){
            elemento.remove();
        })
    }

    

})