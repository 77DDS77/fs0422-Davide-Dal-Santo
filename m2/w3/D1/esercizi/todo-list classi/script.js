class Todo{
    
    constructor(target){

        this.toDoName = target;
        this.target = document.querySelector(target);
        this.input = '';
        this.button = '';
        this.list = '';

        //per local storage
        this.allTodos = localStorage.getItem(target) ? JSON.parse(localStorage.getItem(target)) : [];


        this.createBaseHTML();
        
        // if(this.allTodos.length > 0){
        //     for(let td of this.allTodos){
        //         this.addTodo(td);
        //     }
        // } work in progress
        
    }
    
    createInput() {
        let input = document.createElement('input');
        input.classList.add('form-control');
        input.type = 'text';
        this.input = input;
    }
    
    createButton() {
        let button = this.createELementWithClass('button','btn btn-primary');
        button.innerHTML = 'Save';

        button.addEventListener('click',() => this.addTodo());

        this.button = button;
    }

    addTodo() {
        let todo = this.createELementWithClass('div','alert alert-success');
        todo.innerHTML = this.input.value;

        todo.addEventListener('dblclick',() => {
            todo.remove()
            let index = this.allTodos.indexOf(this.input.value)
            this.allTodos.splice(index,1);
            this.saveTodos();
        });

        //per local storage
        this.allTodos.push(this.input.value);
        this.saveTodos();

        this.list.append(todo);
        this.input.value = '';
    }

    saveTodos(){
        localStorage.setItem(this.toDoName, JSON.stringify(this.allTodos));
    }

    createELementWithClass(tag, className){
        let element = document.createElement(tag);
        element.className = className;
        return element;
    }



    createBaseHTML(){
        
        //creo il mio HTML base
        //creo i container
        let formContainer = this.createELementWithClass('div','container');
        let listContainer = this.createELementWithClass('div','container');     

        //creo input e bottone
        this.createInput();

        this.createButton();

        //creo lista
        let list = document.createElement('div');
        list.classList.add('row');
        this.list = list;

        //appendo input e button a formContainer
        formContainer.append(this.input, this.button);


        //appendo list a list container
        listContainer.append(list);

        //appendo tutto al mio div di aggancio
        this.target.append(formContainer, listContainer);

    }

}

let todo = new Todo('#todo1');
let todo2 = new Todo('#todo2');


/*
    <h1>TO DO CLASSI</h1>


     <div class="container"> --> form container

        <input type="text" class="form-control" id="testo">
        <button id="salva" class="btn btn-primary">Salva</button>
    </div>

    <div class="container"> -> list container
        <div class="row" id="lista">

        </div>
    </div>
*/