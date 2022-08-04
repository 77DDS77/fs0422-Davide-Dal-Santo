const express = require('express');
const app = express()
const path = require('path')

let fs = require('fs');
app.engine('html', require('ejs').renderFile);
app.set('view engine', 'html');
let file = fs.readFileSync('utenti.json','utf-8');






app.get("/chi-siamo", (req,res) => {
    
  //  res.sendFile(path.join(__dirname+ '/chi-siamo.html'))

  res.render('utenti')
})
app.get("/test", (req,res) => {
    
    res.send(faiCose())
})

app.listen(81,() => {
    
    console.log('http://127.0.0.1:81')
})



app.get('/', (req, res) => {
    res.render(path.join(__dirname+'/home.html'),{mostra: file})
})

function faiCose(){
    let target = document.querySelector('#target')
    fetch('utenti.json')
    .then(res => res.json())
    .then(utenti => {
        console.log('ciao')
        for(let utente of utenti){
            let tr = document.createElement('tr')
            for(let prop in utente){
                let td = document.createElement('td')
                td.textContent = utente[prop]
                tr.append(td)
            }
            target.append(tr)
        }
    })
} 

