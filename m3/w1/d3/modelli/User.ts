import {Address} from "./Address"

export class User{

    //gli address li mettiamo undefined per farli definire/inserire all'utente 
    //in un secondo momento e non "all'iscrizione"
    protected id:number|undefined;
    name:string;
    lastname:string;
    address: Address|undefined;
    billingAddress: Address|undefined;

    constructor(name:string, lastname:string){
        this.name = name;
        this.lastname = lastname;
    }

    set setAddress(address:Address){
        this.address = address;
    }

    set setBillingAddress(billingAddress:Address){
        this.billingAddress = billingAddress;
    }
}

let user = new User('Mario', 'Rossi');

///////////////////////////////
// address settato in un secondo momento
let address:Address = new Address('Via Puccini 19', 'Vigonza', 'Italy', 35010)
user.setAddress = address;