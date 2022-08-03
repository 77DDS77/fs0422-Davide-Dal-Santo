class TodoElement{
    constructor(testo, data){
        this.testo = testo;
        this.data = data;
    }
}


let button = document.querySelector('#salva');

let coseDaFare = localStorage.getItem('todo') ? JSON.parse(localStorage.getItem('todo')) : [];

document.onload = LSPrint();


button.addEventListener('click', function(e){

    e.preventDefault();

    let testo = document.querySelector('#testo');
    let data = document.querySelector('#data');

    creaTodo(testo.value, data.value);

    let todo = new TodoElement(testo.value, data.value);

    coseDaFare.push(todo);

    localStorage.setItem('todo', JSON.stringify(coseDaFare));

    console.log(todo);

    //essendo un form al posto di resettare tutto a stringa vuota
    //posso selezionare il form e usare reset()
    document.querySelector('#formTodo').reset();

});


function LSPrint(){
    for(let cosa of coseDaFare){
        creaTodo(cosa.testo, cosa.data)
    }
}
    
function creaTodo(testo, data){

    let div = document.createElement('div');

    div.textContent = testo;
    div.classList.add('alert', 'alert-success');

    let dataDiv = document.createElement('div');
    dataDiv.textContent = data;
    div.append(dataDiv);
    document.querySelector('#lista').append(div);
}