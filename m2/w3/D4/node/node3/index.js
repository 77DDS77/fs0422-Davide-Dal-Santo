var http = require('http')

let server = http.createServer((rec, res) => {

    res.writeHead(200, {'Content-type': 'text/plain'});

    res.end('Hello World');
})

server.listen(81, '127.0.0.1');
console.log(`server attivo all'indirizzo http://127.0.0.1:81 `);