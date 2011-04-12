
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



function Location() {
  var id;
  var lon;
  var lat;
  var unc;
  var time;
  var expiration;
}


function Travel(/*Location*/src, /*Location*/dest) {
  var startTime = src.time;
  var endTime = dest.time;
  var timeSpan = dest.time - src.time;

  var srcLatLng = new google.maps.LatLng(src.lat, src.lon);
  var destLatLng = new google.maps.LatLng(dest.lat, dest.lon);

    /* this.
       getPosAtTime: function getPosAtTime(time) {
    }
   */
}



function computeTimeline() {
  var cnt = locData.length;
  for (var i=0; i < cnt; i++) {
    var locVal = locData[i].location;

  }

}

function setDest(time) {
  var locVal = undefined;

  // try and set prev and dest
  for (var i=0; i < cnt; i++) {
    locVal = locData[i].location;
    destLatLng = undefined;
    if (locVal.time < time) {
      prevLatLng = new google.maps.LatLng(locVal.lat, locVal.lon);
    } else {
      destLatLng = new google.maps.LatLng(locVal.lat, locVal.lon);
    }
  }

  // if dest not set, loop back to front
  if (destLatLng == undefined) {
    locVal = locData[0].location;
    destLatLng = new google.maps.LatLng(locVal.lat, locVal.lon);
    // prev is already set correctly
  }
}
