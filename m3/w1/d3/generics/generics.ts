// IMPORTANTI PER ANGULAR

function numero(x:number):number{
    return x
}

/**
 * Dentro le parentesi uncinate posso metterci il carattere che 
 * voglio io ma deve comparire in tutte le occorrenze
 * di tipizzazione
*/
function numeroGeneric<T>(x:T):T{
    return x
}

/**
 * Qui mettendo <number> gli dico sia che il 
 * parametro dentro le tonde DEVE essere un :number,
 * sia che il return DEVE essere un :number
 * perche' sotituisce tutte le occerrenze di 'T' in:
 *   numeroGeneric<T>(x:T):T{}
 */
numeroGeneric<number>(5)


/**
 * posso avere piu generics in una stessa 
 * funzione basta che output e sviluppo siano coerenti  
*/
function sommaOConcatena<T, U>(x:T, y:U):any{

}

sommaOConcatena<string[], number>(['ciao'],5)


// INTERFACE CON GENERICS

interface keyValue<T, U>{
    prop1:T;
    prop2:U;
}


let obj:keyValue<string, number> = {
    prop1:'prova',
    prop2:5
};

// CLASSI CON GENERICS

class CustomArray<T>{

    private arr:T[] = [];

    getItems():T[]{
        return this.arr
    }

    addItem(item:T):void{
        this.arr.push(item);
    }

    removeItem(item:T):void{
        let index = this.arr.indexOf(item)
        this.arr.splice(index, 1);
    }

    removeItemPro(item:T):void{
        this.arr = this.arr.filter((i:T) => i != item)
    }

}

let arr:CustomArray<string> = new CustomArray;
console.log(arr);
arr.addItem('ciao')
console.log(arr.getItems());
arr.removeItem('ciao');
console.log(arr.getItems());
arr.addItem('ciao')
arr.addItem('pipo')
arr.addItem('pipo2')
arr.addItem('pipo3')
console.log(arr.getItems());
console.log(arr.removeItemPro('ciao'));
console.log(arr.getItems());



// TESTOPERATORE DI SPREAD CON GENERICS
function provaSpread<T>(...caratteri:T[]):T[]{
    return caratteri;
}