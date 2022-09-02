"use strict";
/**
 *  selettore: dove passo la stringa per agganciarmi all'anchor
 *  target: mi fa il queryselector di selettore
 */
class PhoneInterface {
    constructor(selettore, carica) {
        this.selettore = selettore;
        this.target = document.querySelector(selettore);
        this.carica = carica;
        this.numeroChiamate = 0;
        this.costoPerMinuto = 0.20;
        this.creaHTML();
    }
    // ------------ ISMARTPHONE implementation
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
            console.log(`Credito insufficiente, costo chiamata: ${costoChiamata}, credito residuo: ${this.carica}`);
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
        this.creaHTMLCredito();
        this.creaHTMLRicarica();
        this.creaHTMLChiamata();
        this.eliminaPhone();
    }
    creaHTMLCredito() {
        //creo container globale
        let phoneContainer = document.createElement('div');
        //creo elementi
        let credContainer = document.createElement('div');
        let credDisplay = document.createElement('span');
        let credLabel = document.createElement('p');
        phoneContainer.className = 'phone';
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
        ricInput.placeholder = '0'; //value deve essere string
        ricBtn.textContent = 'Ricarica';
        ricContainer.append(ricInput, ricBtn);
        this.phoneContainer.append(ricContainer);
        ricBtn.addEventListener('click', () => {
            this.carica = this.carica += Number(ricInput.value);
            this.checkCredito();
        });
    }
    creaHTMLChiamata() {
        var _a;
        let callContainer = document.createElement('div');
        let callBtn = document.createElement('button');
        let callInput = document.createElement('input');
        callContainer.className = 'callContainer';
        callBtn.textContent = 'Chiama';
        callInput.placeholder = '0 min';
        callContainer.append(callInput, callBtn);
        this.phoneContainer.append(callContainer);
        (_a = this.target) === null || _a === void 0 ? void 0 : _a.append(this.phoneContainer);
        callBtn.addEventListener('click', () => {
            this.chiamata(Number(callInput.value));
            this.checkCredito();
        });
    }
    eliminaPhone() {
        let delBtn = document.createElement('button');
        delBtn.className = 'delBtn';
        delBtn.textContent = 'Elimina';
        this.phoneContainer.append(delBtn);
        delBtn.addEventListener('click', () => {
            this.phoneContainer.remove();
        });
    }
    checkCredito() {
        this.credDisplay.textContent = this.carica.toString() + ' €';
        if (this.carica < this.costoChiamata) {
            this.credDisplay.style.color = 'red';
        }
        else {
            this.credDisplay.style.color = 'black';
        }
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
        addContainer.className = 'addBtn';
        addBtn.textContent = '+';
        addContainer.append(addBtn);
        (_a = this.target) === null || _a === void 0 ? void 0 : _a.append(addContainer);
        addBtn.addEventListener('click', () => {
            new PhoneInterface('#anchor', 0);
        });
    }
}
new Start('#anchor');
//# sourceMappingURL=script.js.map