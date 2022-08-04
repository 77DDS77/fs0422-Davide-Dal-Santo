const express = require('express');

const app = express();

const path = require('path')

app.get('/', (req, res) => {
    res.send('Welcome');
})

app.get('/chi-siamo', (req, res) => {
    res.sendFile(path.join(__dirname + '/chi-siamo.html'));
})

app.get('/contatti', (req, res) => {
    res.sendFile(path.join(__dirname + '/contatti.html'));
})

app.listen(3000, () => {
    console.log(`funziona tuttooooo all'indirizzo http://127.0.0.1:3000`);
})
