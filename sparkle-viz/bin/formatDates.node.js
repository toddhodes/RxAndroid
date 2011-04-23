
/** simple location data timestamp --> date formatting helper
 */

var util = require('util'),
    exec = require('child_process').exec,
    puts = require("sys").puts;

if (process.argv.length != 3) {
  puts("Usage: node formatDates.js <mdn>");
  puts("   eg: node formatDates.js 5103326150");
  return;
}

var times = [];

puts('formatting dates from: data/' + process.argv[2] + '.json');
var child = exec('grep time data/' + process.argv[2] + '.json | cut -d: -f2',
  function (error, stdout, stderr) {
     times = stdout.split(",");
     for (var i=0; i < times.length; i++) {
        var t = times[i].replace(/^\s\s*/, '').replace(/\s\s*$/, '');
        if (t != "") {
           puts(t + ": " + new Date(times[i] * 1000));
        }
     }

    //console.log('stdout: ' + stdout);
    //console.log('stderr: ' + stderr);
    if (error !== null) {
      console.log('exec error: ' + error);
    }
});

