"use strict";
/**
 * Test base di creazione e distruzione del DOM con OOP
 *
 * Stile e colori sono obnoxious come al solito ma questa voleva
 * essere una esercitazione nella creazione e distruzione di
 * Elementi del DOM con la Programmazione ad ogetti.
 *
 * Prima o poi diventero' bravo nel Design pure io
 *
*/
class PhoneInterface {
    constructor(nome, selettore, carica) {
        this.nome = nome;
        this.selettore = selettore;
        this.target = document.querySelector(selettore);
        this.carica = carica;
        this.numeroChiamate = 0;
        this.costoPerMinuto = 0.20;
        this.creaHTML();
    }
    // ------------------ ISMARTPHONE implementation
    ricarica(unaRicarica) {
        this.carica += unaRicarica;
        console.log(`Credito: ${this.carica}`);
    }
    chiamata(minutiDurata) {
        let parseMinuti = (Number((minutiDurata).toFixed(2)) * 10) / 10;
        let parseCosto = (Number((this.costoPerMinuto).toFixed(2)) * 10) / 10;
        let costoChiamata = (Number((parseMinuti * parseCosto).toFixed(2)) * 10) / 10;
        this.costoChiamata = costoChiamata;
        if (this.carica >= costoChiamata) {
            console.log(`Chiamata ${minutiDurata}min effettuata, costo chiamata: ${costoChiamata}`);
            this.carica -= (costoChiamata * 10) / 10;
            this.numeroChiamate++;
        }
        else {
            this.phoneContainer.classList.add('shake');
            console.log(`Credito insufficiente, costo chiamata: ${costoChiamata}, credito residuo: ${this.carica}`);
            setInterval(() => {
                this.phoneContainer.classList.remove('shake');
            }, 1100);
        }
    }
    numero404() {
        console.log(`Credito residio: ${parseFloat((this.carica).toFixed(2))}`);
        return parseFloat((this.carica).toFixed(2));
    }
    getNumeroChiamate() {
        console.log(`Hai effettuato ${this.numeroChiamate} chiamate`);
        return this.numeroChiamate;
    }
    azzeraChiamate() {
        console.log(`Chiamate azzerate!`);
        this.numeroChiamate = 0;
    }
    // ------------------/ISMARTPHONE
    creaHTML() {
        var _a;
        this.creaHTMLCredito();
        this.creaFlagNome();
        this.creaHTMLRicarica();
        this.creaHTMLChiamata();
        this.creaHTMLcallCounter();
        this.eliminaPhone();
        (_a = this.target) === null || _a === void 0 ? void 0 : _a.append(this.phoneContainer);
    }
    creaFlagNome() {
        let nomeContainer = document.createElement('div');
        nomeContainer.className = 'nomeContainer';
        nomeContainer.textContent = this.nome;
        this.phoneContainer.append(nomeContainer);
    }
    creaHTMLCredito() {
        //creo container globale
        let phoneContainer = document.createElement('div');
        //creo elementi
        let credContainer = document.createElement('div');
        let credDisplay = document.createElement('span');
        let credLabel = document.createElement('p');
        phoneContainer.className = 'phone slideInRight';
        credContainer.className = 'credContainer';
        //salvo nell'oggetto il credito
        this.credDisplay = credDisplay;
        this.phoneContainer = phoneContainer;
        //continuo con definizione contenuto
        credDisplay.textContent = this.carica.toString() + ' €';
        credLabel.textContent = "Credito disponibile: ";
        credLabel.append(credDisplay);
        credContainer.append(credLabel);
        phoneContainer.append(credContainer);
    }
    creaHTMLRicarica() {
        //input + button , click del button cambia valore di credito
        let ricContainer = document.createElement('div');
        let ricInput = document.createElement('input');
        let ricBtn = document.createElement('button');
        ricContainer.className = 'ricContainer';
        ricInput.placeholder = '0 €'; //value deve essere string
        ricInput.type = 'number';
        ricBtn.textContent = 'Ricarica';
        ricContainer.append(ricInput, ricBtn);
        this.phoneContainer.append(ricContainer);
        ricBtn.addEventListener('click', () => {
            this.carica = this.carica += Number(ricInput.value);
            this.checkCredito();
        });
    }
    creaHTMLChiamata() {
        let callContainer = document.createElement('div');
        let callBtn = document.createElement('button');
        let callInput = document.createElement('input');
        callContainer.className = 'callContainer';
        callBtn.textContent = 'Chiama';
        callInput.placeholder = '0 min';
        callInput.type = 'number';
        callContainer.append(callInput, callBtn);
        this.phoneContainer.append(callContainer);
        callBtn.addEventListener('click', () => {
            if (Number(callInput.value) > 0) {
                this.chiamata(Number(callInput.value));
                this.checkCredito();
                this.checkNumCall();
            }
            else {
                this.phoneContainer.classList.add('shake');
                setTimeout(() => {
                    this.phoneContainer.classList.remove('shake');
                    this.phoneContainer.classList.remove('slideInRight');
                }, 1100);
            }
        });
    }
    creaHTMLcallCounter() {
        let counterContainer = document.createElement('div');
        let counterP = document.createElement('p');
        let callNum = document.createElement('span');
        counterContainer.className = 'counterContainer';
        counterP.textContent = 'Chiamate effettuate: ';
        callNum.textContent = this.numeroChiamate.toString();
        this.callNum = callNum;
        counterP.append(callNum);
        counterContainer.append(counterP);
        this.phoneContainer.append(counterContainer);
    }
    eliminaPhone() {
        let delBtn = document.createElement('button');
        delBtn.className = 'delBtn';
        delBtn.textContent = 'Elimina';
        this.phoneContainer.append(delBtn);
        delBtn.addEventListener('click', () => {
            this.phoneContainer.classList.add('slideOutLeft');
            setInterval(() => {
                this.phoneContainer.remove();
            }, 1000);
        });
    }
    checkCredito() {
        this.credDisplay.textContent = this.carica.toString() + ' €';
        if (this.carica < this.costoChiamata) {
            this.credDisplay.style.color = 'red';
        }
        else {
            this.credDisplay.style.color = 'black';
            this.phoneContainer.classList.remove('shake');
            this.phoneContainer.classList.remove('slideInRight');
        }
    }
    checkNumCall() {
        this.callNum.textContent = this.numeroChiamate.toString();
    }
}
class Start {
    constructor(selettore) {
        this.selettore = selettore;
        this.target = document.querySelector(selettore);
        this.addBtn();
    }
    addBtn() {
        var _a;
        let addContainer = document.createElement("div");
        let addBtn = document.createElement('button');
        let nomeInput = document.createElement('input');
        addContainer.className = 'addBtn';
        addBtn.textContent = '+';
        nomeInput.type = 'name';
        nomeInput.placeholder = 'Inserisci nome';
        addContainer.append(nomeInput, addBtn);
        (_a = this.target) === null || _a === void 0 ? void 0 : _a.append(addContainer);
        addBtn.addEventListener('click', () => {
            let nome = nomeInput.value;
            if (nome == '') {
                alert('Inserisci il nome');
            }
            else {
                nomeInput.value = '';
                new PhoneInterface(nome, '#anchor', 0);
            }
        });
    }
}
new Start('#anchor');
//# sourceMappingURL=script.js.map