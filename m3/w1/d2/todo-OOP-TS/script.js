"use strict";
class Todo {
    constructor(selettore) {
        this.target = document.querySelector(selettore);
        this.selettore = selettore;
        let db = localStorage.getItem(selettore) || '[]';
        this.alltodos = JSON.parse(db);
        this.creaHTMLBase();
        if (this.alltodos.length > 0) {
            for (let todo of this.alltodos) {
                this.creaHTMLTodo(todo);
            }
        }
    }
    creaHTMLBase() {
        var _a;
        // creo gli elementi
        let input = document.createElement("input");
        let button = document.createElement("button");
        let list = document.createElement("div");
        // funxionalita' bottone
        button.addEventListener("click", () => {
            this.creaHTMLTodo();
            this.salvaNuovoTodo();
        });
        // formatto gli elementi
        input.classList.add('form-control', 'my-2');
        button.classList.add('btn', 'btn-primary', 'mx-2', 'my-2');
        button.textContent = 'Add';
        // salvo gli elementi nelle proprieta' della classe
        // o meglio, li ho messi a riga 6 e 7 altrimenti sarebbero stati raggiungibili
        // solo dal metodo creaHTMLBase
        // non mi servono nel costructor perche' al momento dell'instaziamento 
        //non li ho a disposizione
        this.input = input;
        this.button = button;
        this.list = list;
        // mostro gli elemetni
        if (this.target) {
            (_a = this.target) === null || _a === void 0 ? void 0 : _a.append(input, button, list);
        }
        else {
            throw new Error(`Elemento target ${this.selettore} non trovato`);
        }
    }
    creaHTMLTodo(testo = null) {
        let newTodo = document.createElement('div');
        newTodo.classList.add('alert', 'alert-success');
        newTodo.textContent = testo || this.input.value;
        this.list.append(newTodo);
    }
    salvaNuovoTodo() {
        this.alltodos.push(this.input.value);
        localStorage.setItem(this.selettore, JSON.stringify(this.alltodos));
        this.input.value = '';
    }
}
new Todo('#todo');
new Todo('#todo2');
// BO
/*
let todo1 = new Todo('#todo');

let btnProva:HTMLButtonElement|null = document.querySelector('#btnProva');

btnProva?.addEventListener('click', function(){
    todo1.creaHTMLTodo();
})
*/
//# sourceMappingURL=script.js.map