
const crypto = require('crypto'),
      fs = require("fs"),
      http = require("http");

var privateKey = fs.readFileSync('privatekey.pem').toString();
var certificate = fs.readFileSync('certificate.pem').toString();

var credentials = crypto.createCredentials({key: privateKey, cert: certificate});

var handler = function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.end('Hello World\n');
};

var server = http.createServer();
server.setSecure(credentials);
server.addListener("request", handler);
server.listen(8000);

/*
openssl genrsa -out privatekey.pem 1024 
openssl req -new -key privatekey.pem -out certrequest.csr 
openssl x509 -req -in certrequest.csr -signkey privatekey.pem -out certificate.pem

http://www.silassewell.com/blog/2010/06/03/node-js-https-ssl-server-example/
 */
