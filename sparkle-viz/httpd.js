
var sys = require("sys");
puts = require("sys").puts;

var reqs = 0;
var posts = 0;

function log(arg) {
  puts(new Date() + ": " + arg);
}

function stat() {
  log("have recv'd " + (reqs-posts) + " GETs, " + posts + " POSTs");
}
setInterval(stat, 15000);

process.addListener("SIGINT",
  function () {
    stat();
    log("goodbye");
    process.exit(0)
  });


var http = require('http');
var s = http.createServer(function (req, res) {
  req.on('data', function (chunk) {
    console.log('BODY:\n' + chunk);
    posts++;
  });
  reqs++;
  console.log('HEADERS: ');
  console.log(req.headers);
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.end('Hello World\n');
});
//s.listen(8421, "127.0.0.1");
s.listen(8421);
log('Server running at http://'+ s.address().address + ':' + s.address().port);

var util = require('util');

//log("server info: " + s.address());
//console.log(util.inspect(s.address(), true, null));
//for(prop in s) log("server " + prop + ": " + s[prop]);



