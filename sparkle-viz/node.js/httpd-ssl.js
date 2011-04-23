
// http://www.loggly.com/2010/09/node-js-ssl-server-example/

// includes
var sys = require("sys"),
    http = require("http"),
    net = require("net"),
    url = require("url"),
    fs = require("fs"),
    tls = require("tls"),
    crypto = require("crypto");

// crypto
var privatekey = fs.readFileSync('/opt/wm/ssl/wildcard.location-labs.com.key');
privatekey = privatekey.toString();
var certificate = fs.readFileSync('/opt/wm/ssl/wildcard.location-labs.com.crt');
certificate = certificate.toString();
var chain = fs.readFileSync('/opt/wm/ssl/location-labs-intermediate.crt');
chain = chain.toString();
var credentials = crypto.createCredentials({key: privatekey, cert: certificate, ca: chain});

var options = {
  key: privatekey,
  chain: chain,
  ca: [ certificate ]
};


// server object
var handler = function (request, response) {
    var content = "";
    var remoteip = request.connection.remoteAddress;

    request.addListener("data", function(chunk) {
        content += chunk;
        if (content.length > 32768) {
            response.writeHead(413, {"Content-Type": "application/json"});
            response.write("{ 'response': 'error: oversized event' }\n");
            response.end();
            return;
        }
    });
    request.addListener("end", function() {
        response.writeHead(201, {"Content-Type": "application/json"});
        response.write("{ 'response': 'success', 'length': "+content.length+"  }\n");
        response.end();
        return;
    });
};

// ssl'd http
var sslserver = tls.createServer(options);
sslserver.addListener("request", handler);
//sslserver.listen(443);
sslserver.listen(8421);

/*// regular ol' http
var httpserver = http.createServer();
httpserver.addListener("request", handler);
httpserver.listen(80);
*/

