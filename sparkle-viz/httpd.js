
var sys = require("sys"),
    fs = require("fs"),
    http = require('http'),
    util = require('util');

var reqs = 0;
var posts = 0;

var puts = require("sys").puts;


function log(arg) {
  puts(new Date() + ': ' + arg + '\n');
}

function stat() {
  log("have recv'd " + (reqs-posts) + " GETs, " + posts + " POSTs");
}
//setInterval(stat, 15000);

process.addListener("SIGINT",
                    function () {
                      stat();
                      log("goodbye");
                      process.exit(0);
                    });

var s = http.createServer(function(req,res) {
  req.on('data', function (chunk) {
    console.log('\n' + chunk);
    var locStore =
      fs.createWriteStream('data/captured-data.txt', {'flags': 'a'});
    locStore.write(new Date() + ": " + chunk);

    var jsonStore =
      fs.createWriteStream('data/captured-data.json', {'flags': 'a'});
    jsonStore.write((""+chunk).replace("[","").replace("]",""));

    posts++;
  });

  reqs++;
  console.log(req.headers);

  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.end("OK");
});
//s.listen(8421, "127.0.0.1");
s.listen(8421);
log('Server running at http://'+ s.address().address + ':' + s.address().port);


//log("server info: " + s.address());
//console.log(util.inspect(s.address(), true, null));
//for(prop in s) log("server " + prop + ": " + s[prop]);



