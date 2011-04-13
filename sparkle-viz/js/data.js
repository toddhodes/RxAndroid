
var locData;
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
  this.latLng = function() {
    return new google.maps.LatLng(this.lat, this.lon);
  };
}


function TravelSpan(/*Location*/src, /*Location*/dest) {
  this.src = src;
  this.dest = dest;

  this.startTime = src.time;
  this.endTime = dest.time;
  this.timeSpan = dest.time - src.time;

  this.getPosAtTime = function(time) {
    var frac_dest = (time - this.startTime) / this.timeSpan;
    var frac_src = (this.endTime - time) / this.timeSpan;
    //console.debug((frac_dest*100).toFixed(0) + "% along path");

    var lat = (this.src.latLng().lat() * frac_src)
                + (this.dest.latLng().lat() * frac_dest);
    var lon = (this.src.latLng().lng() * frac_src)
                + (this.dest.latLng().lng() * frac_dest);
    //console.debug("lat: " + lat +", lon:"+ lon);

    return new google.maps.LatLng(lat, lon);
  };
}

function loadLocData() {
  locData = [];
  var mdn = urlArg("mdn");
  if (mdn == "") mdn = "5105551212";

  var url = 'http://sparkledemo.locationlabs.com/finder-att-family/'
            + 'location_feed/' + mdn + '/playback.svc';

  var xhrArgs = {
    url: url,
    handleAs: 'json',
    postLoad: function() {
      addRandomnessToLocData();
      computeTimeline();
      // now we have data; init the map
      setTimeout(init,1000);
    },
    load: function(data) {
      for (var b in data) {
        locData.push(data[b]);
      }
      this.postLoad();
    },
    error: function(error) {
      console.warn("An unexpected error occurred: " + error);
      console.warn("using default data");
      locData = defaultLocationData;
      this.postLoad();
    }
  };
  var deferred = dojo.xhrGet(xhrArgs);
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
  console.debug("travelspans: ", travelSpans);

  var ticks = getTickPercentages();
  console.log("ticks: " , ticks);
  var tickHolder = dojo.byId("timelineBackground");
  for (var tick in ticks) {
    var left = 20 + ticks[tick]/100 * TIMELINE_WIDTH;
    dojo.create("span", { 'class': "tick",
                          style: { left: left.toFixed(0)+"px" }
                        }, tickHolder);
  }
}


function getTickPercentages() {
  var ticks = [];
  var cnt = locData.length;
  for (var i=0; i < cnt; i++) {
    ticks.push(getPercentAt(locData[i].location.time).toFixed(2));
  }
  return ticks;
}

function addRandomnessToLocData() {
  console.debug("locData: ", locData);
  var cnt = locData.length;
  for (var i=0; i < cnt; i++) {
    locData[i].location.lat = locData[i].location.lat + 0.1 * Math.random();
    locData[i].location.lon = locData[i].location.lon + 0.1 * Math.random();
  }
}

function getTimeAt(percentComplete) {
  var offset =  (endTime - beginTime) * (percentComplete / 100);
  return beginTime + offset;
}

function getPercentAt(time) {
  return 100 * (time - beginTime) / (endTime - beginTime);
}

function getTravelSpan(time) {
  //console.debug("getTravelLoc(" + time + ")");
  var lastLoc = 0;
  var nextLoc = 1;

  var cnt = locData.length;
  for (var i=0; i < cnt; i++) {
    var locVal = locData[i].location;
    if (time > locVal.time) {
      lastLoc = i;
    } else {
      nextLoc = i;
      break;
    }
  }

  var dbgmsg = "tofrom: " + lastLoc + " -> " + nextLoc;
  if (dbgmsg != lastdbgmsg) {
    console.debug(dbgmsg);
    lastdbgmsg = dbgmsg;
  }

  var span = new TravelSpan(new Location(locData[lastLoc].location),
                            new Location(locData[nextLoc].location));

  return span;
}
var lastdbgmsg = undefined;



// due to XSS security issues, we need this for local devel
var defaultLocationData = [
  {"location":{"id":2913,"lon":-122.29324161666666,"lat":37.841334333333336,"unc":150.0,"time":1302262620,"expiration":1303126620}},
  {"location":{"id":2914,"lon":-122.29279204,"lat":37.84161864,"unc":156.0,"time":1302269594,"expiration":1303133594}},
  {"location":{"id":2915,"lon":-122.29302671666666,"lat":37.8416964,"unc":169.0,"time":1302273059,"expiration":1303137059}},
  {"location":{"id":2917,"lon":-122.29396273000002,"lat":37.841997889999995,"unc":119.0,"time":1302288371,"expiration":1303152371}},
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
  {"location":{"id":3110,"lon":-122.29282814999999,"lat":37.841758049999996,"unc":63.0,"time":1302546407,"expiration":1303410407}},
  {"location":{"id":3243,"lon":-122.37029,"lat":37.802792,"unc":2345.0,"time":1302575254,"expiration":1303439254}},
  {"location":{"id":3244,"lon":-122.2915467,"lat":37.84156975,"unc":0.0,"time":1302575257,"expiration":1303439257}},
  {"location":{"id":3247,"lon":-122.2924743125,"lat":37.841843149999995,"unc":139.0,"time":1302609794,"expiration":1303473794}},
  {"location":{"id":3327,"lon":-122.296003,"lat":37.840202,"unc":992.0,"time":1302640339,"expiration":1303504339}}
];
