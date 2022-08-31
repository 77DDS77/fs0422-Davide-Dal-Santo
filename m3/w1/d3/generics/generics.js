// IMPORTANTI PER ANGULAR
function numero(x) {
    return x;
}
/**
 * Dentro le parentesi uncinate posso metterci il carattere che
 * voglio io ma deve comparire in tutte le occorrenze
 * di tipizzazione
*/
function numeroGeneric(x) {
    return x;
}
/**
 * Qui mettendo <number> gli dico sia che il
 * parametro dentro le tonde DEVE essere un :number,
 * sia che il return DEVE essere un :number
 * perche' sotituisce tutte le occerrenze di 'T' in:
 *   numeroGeneric<T>(x:T):T{}
 */
numeroGeneric(5);
/**
 * posso avere piu generics in una stessa
 * funzione basta che output e sviluppo siano coerenti
*/
function sommaOConcatena(x, y) {
}
sommaOConcatena(['ciao'], 5);
var obj = {
    prop1: 'prova',
    prop2: 5
};
// CLASSI CON GENERICS
var CustomArray = /** @class */ (function () {
    function CustomArray() {
        this.arr = [];
    }
    CustomArray.prototype.getItems = function () {
        return this.arr;
    };
    CustomArray.prototype.addItem = function (item) {
        this.arr.push(item);
    };
    CustomArray.prototype.removeItem = function (item) {
        var index = this.arr.indexOf(item);
        this.arr.splice(index, 1);
    };
    CustomArray.prototype.removeItemPro = function (item) {
        this.arr = this.arr.filter(function (i) { return i != item; });
    };
    return CustomArray;
}());
var arr = new CustomArray;
console.log(arr);
arr.addItem('ciao');
console.log(arr.getItems());
arr.removeItem('ciao');
console.log(arr.getItems());
arr.addItem('ciao');
arr.addItem('pipo');
arr.addItem('pipo2');
arr.addItem('pipo3');
console.log(arr.getItems());
console.log(arr.removeItemPro('ciao'));
console.log(arr.getItems());
// TESTOPERATORE DI SPREAD CON GENERICS
function provaSpread() {
    var caratteri = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        caratteri[_i] = arguments[_i];
    }
    return caratteri;
}
