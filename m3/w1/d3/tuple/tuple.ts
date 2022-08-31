
/**
 *  TUPLE DA NON CONFONDE CON ASSEGNAMENTO IN DESTRUTTURAZIONE
 * 
 * Tipizzo molto specificamente l'array
 */

let user:[number, string] = [1, 'Davide'];

// assegnamento in destrutturazione
//Crea due variabili 'id' 'nome' ricavando i dati da user
let [id, nome] = user;


// MATRICI DI TUPLE
/**
 *  scrivere userArr:[][] dice che e' un array con dentro altri array
 *  userArr:[number, string][] dichiara che sugli arrai dall'interno
 *  trovera' sempre prima un number e poi una stringa
 * 
 */
let userArr:[number, string][] = [
    user,
    [2,"Mario"],
    [3,"Carisio"],
    [4,"Caio"]
]