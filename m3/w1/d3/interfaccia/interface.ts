/**
 * in una interfaccia non posso implementare il metodo,
 *  posso solo definirlo
 * 
 * non posso neanche definire un valore
 * EX. nPagine:number - 0; NON POSSO FARLO
 * Posso solo dirgli nPagine:number
 * 
 * L'interfaccai mi serve tipo l'ibretto di ustruzioni per
 *  la creazione di qualcosa, e' un supporto allo sviluppo
 * 
 * La differenza con le classsi astratte e' che
 * 
 * la classe astratta puo implementare valori e metodi che vengono ereditati
 * 
 * I metodi che dichiaro sulla interfaccia sono molto piu restrittivi
 * Non posso cambiare la tipizzazioen del return
 * Parametri da capire se funziona come le classi abstract
 */
interface IBook{
    nPagine:number;
    getBook():string;
}

interface IBook2{
    nPagine:number;
    getBook2():string;
}

class Book implements IBook, IBook2{
    getBook2(): string {
        throw new Error("Method not implemented.");
    }
    nPagine: number;
    getBook(): string {
        throw new Error("Method not implemented.");
    }

}