let eta = prompt('Quanti anni hai?');
console.log(eta);

// if (eta != '' && eta != null) { questo controllo posso semplicemente scriverlo cosi:
if (eta) {
    if (eta >= 18 && eta <= 120) {
        document.write('Sei maggiorenne!');
    } else if (eta >= 120) {
        document.write('Sei un dinosauro?');
    }

    else {
        document.write('Sei minorenne!');
        location.href = 'https://it.wikipedia.org/wiki/Peppa_Pig';
    }
}