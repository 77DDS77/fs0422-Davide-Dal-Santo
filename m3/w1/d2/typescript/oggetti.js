//:object non ha le classiche proprieta'
//se loggetto che creo dovro utilizzarlo (spoiler devo utilizzarli) :object non va bene
// :{} e' gia meglio
// per oggetti piu complessi va tipizzata ogni proprieta' delloggetto
var obj = {};
// ------------------------
var states = {
    italy: 'Rome',
    england: 'London'
};
// console.log(states.italy);  
//dichiarando l'oggetto come sopra questo log non me lo fa fare perche'
//per come ho tipizzato l'oggetto non lo posso utilizzare
// ---------------------------
var states2 = {
    italy: 'Rome',
    england: 'London',
    id: function () {
        return this.italy + ' ' + this.england;
    }
};
console.log(states2.italy);
console.log(states2.id());
//dichiarando l'oggetto cosi, quindi tipizzando ogni sua proprieta'
//allora posso utilizzare l'oggetto per leggere il suo contenuto
// -------------------------------------
