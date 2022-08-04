
const apiUtenti = 'http://localhost:3000/utenti';

const tabellaUtenti = document.querySelector('#tabellaUtenti')


if (tabellaUtenti) {

    fetch(apiUtenti)
        .then(res => res.json())
        .then(utenti => {

            for (let utente of utenti) {

                let tr = document.createElement('tr');
                let tdNome = document.createElement('td');
                let tdCognome = document.createElement('td');
                let tdEta = document.createElement('td');

                tdNome.textContent = utente.nome;
                tdCognome.textContent = utente.cognome;
                tdEta.textContent = utente.eta;

                //creo una td per i bottoni delle azioni
                let tdAzioni = document.createElement('td');
                let btnModifica = document.createElement('a');
                let btnElimina = document.createElement('button')

                
                btnModifica.textContent = 'Modifica'
                btnElimina.textContent = 'Elimina'

                //?id='+utente.id per farmi portare direttamente sulla modifica di QUEL utente
                btnModifica.href = 'modifica.html?id='+utente.id;//do l'href all'a direttamente cosi
                btnElimina.addEventListener('click',() =>{
                    eliminaUtente(utente.id, tr)
                })

                btnModifica.classList.add('btn', 'btn-warning');
                btnElimina.classList.add('btn', 'btn-danger', 'text-dark');

                tdAzioni.append(btnModifica, btnElimina)
                //fine bottoni azioni


                tr.append(tdNome, tdCognome, tdEta, tdAzioni);
                tabellaUtenti.appendChild(tr);
            }

        })
}
