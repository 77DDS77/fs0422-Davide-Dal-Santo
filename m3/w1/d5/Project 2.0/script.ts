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

interface ISmartphone {
    carica: number;
    numeroChiamate: number;
    costoPerMinuto: number;

    ricarica(unaRicarica: number): void;
    chiamata(minutiDurata: number): void;
    numero404(): number;
    getNumeroChiamate(): number;
    azzeraChiamate(): void;

}

class PhoneInterface implements ISmartphone {

    nome!:string;
    selettore!: string;
    target!: HTMLElement | null;

    carica: number;
    numeroChiamate: number;
    costoPerMinuto: number;

    //dati che mi salvo
    credDisplay!: HTMLElement;
    costoChiamata!: number;
    phoneContainer!: HTMLElement;
    callNum!: HTMLElement;

    constructor(nome:string, selettore: string, carica: number) {
        this.nome = nome;
        this.selettore = selettore;
        this.target = document.querySelector(selettore)

        this.carica = carica;
        this.numeroChiamate = 0;
        this.costoPerMinuto = 0.20;

        this.creaHTML();
    }

    // ------------------ ISMARTPHONE implementation
    ricarica(unaRicarica: number): void {
        this.carica += unaRicarica;
        console.log(`Credito: ${this.carica}`);
    }
    chiamata(minutiDurata: number): void {
        let parseMinuti: number = (Number((minutiDurata).toFixed(2)) * 10) / 10;
        let parseCosto: number = (Number((this.costoPerMinuto).toFixed(2)) * 10) / 10

        let costoChiamata: number = (Number((parseMinuti * parseCosto).toFixed(2)) * 10) / 10;

        this.costoChiamata = costoChiamata;

        if (this.carica >= costoChiamata) {

            console.log(`Chiamata ${minutiDurata}min effettuata, costo chiamata: ${costoChiamata}`);
            this.carica -= (costoChiamata * 10) / 10;
            this.numeroChiamate++;

        } else {
            this.phoneContainer.classList.add('shake')
            console.log(`Credito insufficiente, costo chiamata: ${costoChiamata}, credito residuo: ${this.carica}`);
            setInterval( () => {
                this.phoneContainer.classList.remove('shake');
            },1100)
        }
    }
    numero404(): number {
        console.log(`Credito residio: ${parseFloat((this.carica).toFixed(2))}`);
        return parseFloat((this.carica).toFixed(2));
    }
    getNumeroChiamate(): number {
        console.log(`Hai effettuato ${this.numeroChiamate} chiamate`);
        return this.numeroChiamate;
    }
    azzeraChiamate(): void {
        console.log(`Chiamate azzerate!`);
        this.numeroChiamate = 0;
    }
    // ------------------/ISMARTPHONE

    protected creaHTML(): void {
        this.creaHTMLCredito()
        this.creaFlagNome()
        this.creaHTMLRicarica()
        this.creaHTMLChiamata()
        this.creaHTMLcallCounter()
        this.eliminaPhone()
        this.target?.append(this.phoneContainer);
    }

    protected creaFlagNome(){
        let nomeContainer: HTMLElement = document.createElement('div')
        
        nomeContainer.className = 'nomeContainer';
        nomeContainer.textContent = this.nome;

        this.phoneContainer.append(nomeContainer);
    }

    protected creaHTMLCredito(): void {
        //creo container globale
        let phoneContainer: HTMLElement = document.createElement('div');
        //creo elementi
        let credContainer: HTMLElement = document.createElement('div');
        let credDisplay: HTMLElement = document.createElement('span');
        let credLabel: HTMLElement = document.createElement('p');

        phoneContainer.className = 'phone slideInRight';
        credContainer.className = 'credContainer'

        //salvo nell'oggetto il credito
        this.credDisplay = credDisplay;
        this.phoneContainer = phoneContainer

        //continuo con definizione contenuto
        credDisplay.textContent = this.carica.toString() + ' €';
        credLabel.textContent = "Credito disponibile: ";

        credLabel.append(credDisplay)
        credContainer.append(credLabel)
        phoneContainer.append(credContainer)
    }

    protected creaHTMLRicarica(): void {
        //input + button , click del button cambia valore di credito
        let ricContainer: HTMLElement = document.createElement('div');
        let ricInput: HTMLInputElement = document.createElement('input');
        let ricBtn: HTMLElement = document.createElement('button');

        ricContainer.className = 'ricContainer'
        ricInput.placeholder = '0 €'; //value deve essere string
        ricInput.type = 'number';
        ricBtn.textContent = 'Ricarica'

        ricContainer.append(ricInput, ricBtn);
        this.phoneContainer.append(ricContainer);

        ricBtn.addEventListener('click', () => {
            this.carica = this.carica += Number(ricInput.value)
            this.checkCredito();
        })
    }

    protected creaHTMLChiamata(): void {
        let callContainer: HTMLElement = document.createElement('div');
        let callBtn: HTMLElement = document.createElement('button');
        let callInput: HTMLInputElement = document.createElement('input');

        callContainer.className = 'callContainer';

        callBtn.textContent = 'Chiama';
        callInput.placeholder = '0 min';
        callInput.type = 'number';

        callContainer.append(callInput, callBtn);
        this.phoneContainer.append(callContainer);

        callBtn.addEventListener('click', () => {
            if(Number(callInput.value) > 0){
                this.chiamata(Number(callInput.value));
                this.checkCredito();
                this.checkNumCall(); 
            }else{
                this.phoneContainer.classList.add ('shake')
                setTimeout(() => {
                    this.phoneContainer.classList.remove ('shake')
                    this.phoneContainer.classList.remove ('slideInRight')
                }, 1100)
            }

        })
    }

    protected creaHTMLcallCounter(){
        let counterContainer: HTMLElement = document.createElement('div');
        let counterP: HTMLElement = document.createElement('p');
        let callNum: HTMLElement = document.createElement('span');

        counterContainer.className = 'counterContainer';

        counterP.textContent = 'Chiamate effettuate: ';
        callNum.textContent = this.numeroChiamate.toString();

        this.callNum = callNum;

        counterP.append(callNum);
        counterContainer.append(counterP);
        this.phoneContainer.append(counterContainer);
        
    }
    
    protected eliminaPhone() {
        let delBtn: HTMLElement = document.createElement('button');
        delBtn.className = 'delBtn';
        delBtn.textContent = 'Elimina';
        this.phoneContainer.append(delBtn);

        delBtn.addEventListener('click', () => {
            this.phoneContainer.classList.add('slideOutLeft');
            setInterval( () => {
                this.phoneContainer.remove();
            },1000);
        })
    }
    

    private checkCredito(): void {
        this.credDisplay.textContent = this.carica.toString() + ' €';
        if (this.carica < this.costoChiamata) {
            this.credDisplay.style.color = 'red';
        } else {
            this.credDisplay.style.color = 'black';
            this.phoneContainer.classList.remove('shake');
            this.phoneContainer.classList.remove('slideInRight');
        }
    }

    private checkNumCall(){
        this.callNum.textContent = this.numeroChiamate.toString();
    }



}


class Start {

    protected selettore!: string;
    protected target!: HTMLElement | null;

    constructor(selettore: string) {
        this.selettore = selettore;
        this.target = document.querySelector(selettore);

        this.addBtn();
    }

    protected addBtn() {
        let addContainer: HTMLElement = document.createElement("div");
        let addBtn: HTMLElement = document.createElement('button');
        let nomeInput:HTMLInputElement = document.createElement('input');

        addContainer.className = 'addBtn';
        addBtn.textContent = '+';
        nomeInput.type = 'name';
        nomeInput.placeholder = 'Inserisci nome';

        addContainer.append(nomeInput, addBtn);
        this.target?.append(addContainer);
        
        addBtn.addEventListener('click', () => {
            let nome:string = nomeInput.value;
            if(nome == ''){
                alert('Inserisci il nome');
            }else{
                nomeInput.value = '';
                new PhoneInterface(nome,'#anchor', 0);
            }
        })
    }

}

new Start('#anchor');