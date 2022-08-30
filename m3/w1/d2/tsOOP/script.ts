

class User{

    //istanziamento delle classi piu o meno uguali,
    //questo pezzo qua e' quello che cambia,
    //devo dichiarare e tipizzare i parametri del costruttore PRIMA del costruttore

    // ID
    //id lo metto :number | undefined perche non lo definisco io in fase di istanziamento 
    //ma lo definira' il backend

    // MODIFICATORI DI ACCESSO
    //public = proprieta' accessibili dall'esterno
    // private = proprieta' protetta e accessibile solo all'interno della classe user
    // protected = accessibile solo all'interno della classe e sottoclassi
    // non mettere il modificatore di accesso = sempre public
    private id:number | undefined; 
    protected name:string;
    protected cognome:string;
    public role:string = 'user'

    constructor(name:string, cognome:string){
        this.name = name;
        this.cognome = cognome;
    }

    //modificatori di accesso posso usarli anche sui metodi
    public saluto():void{
        console.log(`Ciao mi chiamo ${this.name} ${this.cognome}`);
    }

    get getName():string{
        return this.name;
    }

    //per come e' fatto il setter non necessita della tipizzazione del return
    set setId(id:number){
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

class Admin extends User{
    // nome cognome e id non li riscrivo perche li eredito
    public role:string = 'Administrator';
    private fullAccess:boolean;

    // costruttore deve essere come quello di User + roba in piu di Admin
    constructor(name:string, cognome:string, fullAccess:boolean){
        super(name, cognome); //super costruttore che pesca da User
        this.fullAccess = fullAccess;
    }
}

let admin = new Admin('Davide', 'Dal Santo', true);
admin.setId = 1
console.log('admin:', admin);

