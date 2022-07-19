let budget = document.querySelector('#budgetStart'); //input budget
const budgetButton = document.querySelector('#budgetSet');
const lista = document.querySelector('#listaSpese');//lista UL

let spesaManu = document.querySelector('#spesaManuale');//input spesa manuale
const manuBgt = document.querySelector('#manualBudget');//button set budget manuale
const manuBtn = document.querySelector('#spendiManuale');//bottone spesa manuale

let soldiRimasti = document.querySelector('#soldiRimasti');//soldi rimasti



// AUTOMATIC CASH BURNER
budgetButton.addEventListener('click', getBudget);

function getBudget() {

    let schei = budget.value;
    wasteBudget(schei);
}


function wasteBudget(schei) {
    let scheiRimasti = schei;
    while(scheiRimasti >= 0){

        let listItem = document.createElement('li')
        listItem.classList.add('listItemStyle')
        let spesaRandom = Math.floor(Math.random() * schei/10);

        if(scheiRimasti - spesaRandom > 0){
            scheiRimasti = scheiRimasti - spesaRandom;
            if (scheiRimasti <= schei / 2 && scheiRimasti > schei / 4) {
                listItem.innerHTML =`Hai speso piu' di meta' budget! Ti rimangono ${scheiRimasti} soldi`;
                lista.append(listItem);
                listItem.classList.add('listItemWarning')
            } else if (scheiRimasti <= schei / 4) {
                listItem.innerHTML =`Hai speso quasi tutto il budget! Ti rimangono ${scheiRimasti} soldi`;
                lista.append(listItem);
                listItem.classList.add('listItemAlert')
            } else {
                listItem.innerHTML =`Spendi spendiii! Ti rimangono ${scheiRimasti} soldi`;
                lista.append(listItem);    
            } 
        }else{
            listItem.innerHTML =`Stai inguaiato, hai ${scheiRimasti} soldi e volevi spendere ${spesaRandom} soldi`;
            lista.append(listItem);
            listItem.classList.add('listItemAuguri')
            break;
        }
    }
}


//MANUAL CASH BURNER

manuBgt.addEventListener('click', getBudgetManu);
manuBtn.addEventListener('click', spendiConsapevolmente);

function getBudgetManu() {

    soldiRimasti.innerHTML = budget.value;

}



function spendiConsapevolmente(){
    let sordi = budget.value;
    let spesa = spesaManu.value;
    console.log(spesa);

    if(sordi && spesa){
        if(sordi > spesa){
            
            if(soldiRimasti.innerHTML < sordi/2 && soldiRimasti.innerHTML > sordi/4){

                let transazione = sordi - spesa;
                soldiRimasti.innerHTML = transazione;
                let listItem = document.createElement('li');
                listItem.classList.add('listItemStyle');
                listItem.innerHTML =
                    `Transazione eseguita: -${spesa} soldini \n 
                    Ti e' rimasto meno di meta' del budget'`;
                    lista.append(listItem);
                    soldiRimasti.classList.add('soldiRimastiAlert');

            }else if(soldiRimasti.innerHTML < sordi/4){

                let transazione = sordi - spesa;
                soldiRimasti.innerHTML = transazione;
                let listItem = document.createElement('li');
                listItem.classList.add('listItemStyle');
                listItem.innerHTML =
                    `Transazione eseguita: -${spesa} soldini \n 
                    Ti e' rimasto meno di un quarto del budget'`;
                    lista.append(listItem);
                    soldiRimasti.classList.add('soldiRimastiWarning'); 

            }else{

                let transazione = sordi - spesa;
                soldiRimasti.innerHTML = transazione;
                let listItem = document.createElement('li');
                listItem.classList.add('listItemStyle');
                listItem.innerHTML =
                    `Transazione eseguita: -${spesa} soldini`;
                    lista.append(listItem);

            }

        }else{//se soldi < spesa
            let listItem = document.createElement('li');
            listItem.classList.add('listItemStyle');
            listItem.innerHTML =
                `Non ti puoi perfmettere questa spesa, il tuo saldo e' 
                ${sordi} soldini, la spesa e' ${spesa} soldini`;
                lista.append(listItem); 
        }
    }else{//se soldi e spesa non sono stati inseriti
        alert('INSERIRE BUDGET E SPESA');
    }
    
}

