
var locData = [
  {"location":{"id":2922,"lon":-122.29375341,"lat":37.841896659999996,"unc":150.0,"time":1302296506,"expiration":1303160506}},
  {"location":{"id":2924,"lon":-122.29357625555556,"lat":37.841870088888896,"unc":155.0,"time":1302299476,"expiration":1303163476}},
  {"location":{"id":2954,"lon":-122.29352451,"lat":37.841428230000005,"unc":94.0,"time":1302306451,"expiration":1303170451}},
  {"location":{"id":2976,"lon":-122.29360003,"lat":37.841475870000004,"unc":127.0,"time":1302309801,"expiration":1303173801}},
  {"location":{"id":2985,"lon":-122.29361792,"lat":37.84187722,"unc":176.0,"time":1302313450,"expiration":1303177450}},
  {"location":{"id":2986,"lon":-122.29304866666666,"lat":37.84147203333333,"unc":160.0,"time":1302332868,"expiration":1303196868}},
  {"location":{"id":3029,"lon":-122.29356666000001,"lat":37.84172282,"unc":84.0,"time":1302367196,"expiration":1303231196}},
  {"location":{"id":3032,"lon":-122.2934872,"lat":37.8423684,"unc":446.0,"time":1302376341,"expiration":1303240341}},
  {"location":{"id":3033,"lon":-122.29244781666667,"lat":37.84217885,"unc":145.0,"time":1302392559,"expiration":1303256559}},
  {"location":{"id":3049,"lon":-122.29357968571428,"lat":37.84143125714286,"unc":121.0,"time":1302398325,"expiration":1303262325}},
  {"location":{"id":3079,"lon":-122.29359704000001,"lat":37.841446739999995,"unc":161.0,"time":1302419092,"expiration":1303283092}},
  {"location":{"id":3080,"lon":-122.29356182000001,"lat":37.84147779999999,"unc":165.0,"time":1302433824,"expiration":1303297824}},
  {"location":{"id":3087,"lon":-122.294442,"lat":37.8426883,"unc":404.0,"time":1302537261,"expiration":1303401261}},
  {"location":{"id":3089,"lon":-122.29136258333334,"lat":37.841574083333334,"unc":0.0,"time":1302537263,"expiration":1303401263}},
  {"location":{"id":3110,"lon":-122.29282814999999,"lat":37.841758049999996,"unc":63.0,"time":1302546407,"expiration":1303410407}}
];


var travelSpans;
var beginTime;
var endTime;

function Location(l) {
  this.id = l.id;
  this.lon = l.lon;
  this.lat = l.lat;
  this.unc = l.unc;
  this.time = l.time;
  this.expiration = l.expiration;
  this.latLon = function() {
    return new google.maps.LatLng(this.lat, this.lon);
  }
}


function TravelSpan(/*Location*/src, /*Location*/dest) {

  this.startTime = src.time;
  this.endTime = dest.time;
  this.timeSpan = dest.time - src.time;

  this.srcLatLng = new google.maps.LatLng(src.lat, src.lon);
  this.destLatLng = new google.maps.LatLng(dest.lat, dest.lon);
  //console.log("src: " + this.srcLatLng +", dest:"+ this.destLatLng);

  this.getPosAtTime = function(time) {
    var frac_src = (time - this.startTime) / this.timeSpan;
    var frac_dest = (this.endTime - time) / this.timeSpan;
    console.log((frac_src*100).toFixed(0) + "% along path");

    var lat = (this.srcLatLng.lat() * frac_src)
                + (this.destLatLng.lat() * frac_dest);
    var lon = (this.srcLatLng.lng() * frac_src)
                + (this.destLatLng.lng() * frac_dest);
    //console.log("lat: " + lat +", lon:"+ lon);

    return new google.maps.LatLng(lat, lon);
  }
}

function computeTimeline() {
  travelSpans = [];

  var cnt = locData.length;
  if (cnt < 2) {
    alert("Need at least two locations to animate anything");
    return;
  }

  beginTime = locData[0].location.time;
  endTime = locData[locData.length-1].location.time;

  for (var i=0; i < cnt-1; i++) {
    var travelSpan = new TravelSpan(locData[i].location,
                                        locData[i+1].location);
    travelSpans.push(travelSpan);
  }
  console.log(travelSpans);
}

function addRandomnessToLocData() {
  var cnt = locData.length;
  for (var i=0; i < cnt; i++) {
    locData[i].location.lat = locData[i].location.lat + 0.1 * Math.random();
    locData[i].location.lon = locData[i].location.lon + 0.1 * Math.random();
  }
}


function getTimeFromNubPos(nubPos) {
  //console.log("getTimeFromNubPos(" + nubPos + "): "
  //            + beginTime + "-" + endTime + " span=" + (endTime - beginTime));

  var offset =  (endTime - beginTime)
                  * (nubPos / (TIMELINE_WIDTH - TIMELINE_LEFT_EDGE));
  //console.log("offset from begin: " + offset);

  return beginTime + offset;
}

function getTravelLoc(time) {
  //console.log("getTravelLoc(" + time + ")");
  var lastLoc = undefined;
  var nextLoc = undefined;

  // try and set prev and dest
  var cnt = locData.length;
  for (var i=0; i < cnt; i++) {
    locVal = locData[i].location;
    if (locVal.time < time) {
      lastLoc = new Location(locVal);
    } else {
      nextLoc = new Location(locVal);
      break;
    }
  }

  // if next not set, next is beginning (prev is already set correctly)
  if (nextLoc == undefined) {
    nextLoc = new Location(locData[0].location);
  }

  //console.log("getTravelLoc: " + lastLoc.latLon()
  //                             + " -> " + nextLoc.latLon());

  var span = new TravelSpan(lastLoc, nextLoc);
  //console.log(span);
  var retpos = span.getPosAtTime(time);
  return retpos;
}
