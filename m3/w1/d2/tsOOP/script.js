"use strict";
class User {
    constructor(name, cognome) {
        this.role = 'user';
        this.name = name;
        this.cognome = cognome;
    }
    //modificatori di accesso posso usarli anche sui metodi
    saluto() {
        console.log(`Ciao mi chiamo ${this.name} ${this.cognome}`);
    }
    get getName() {
        return this.name;
    }
    //per come e' fatto il setter non necessita della tipizzazione del return
    set setId(id) {
        this.id = id;
    }
}
let user1 = new User('Mario', 'Rossi');
//console.log(user1.name); name e' protected quindi non la posso usare cosi MA
//posso usarla dentro un metodo quindi posso usarla cosi
user1.saluto();
//getter
console.log('getter:', user1.getName);
//setter
user1.setId = 5;
console.log('setter:', user1);
class Admin extends User {
    // costruttore deve essere come quello di User + roba in piu di Admin
    constructor(name, cognome, fullAccess) {
        super(name, cognome); //super costruttore che pesca da User
        // nome cognome e id non li riscrivo perche li eredito
        this.role = 'Administrator';
        this.fullAccess = fullAccess;
    }
}
let admin = new Admin('Davide', 'Dal Santo', true);
admin.setId = 1;
console.log('admin:', admin);
//# sourceMappingURL=script.js.map