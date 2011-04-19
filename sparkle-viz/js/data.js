
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

  //var url = 'http://sparkledemo.locationlabs.com/'
  //    + 'finder-att-family/location_feed/' + mdn + '/playback.svc';

  // due to XSS security issues, we need this for local devel
  var url = 'data/' + mdn + '.json';

  var xhrArgs = {
    url: url,
    handleAs: 'json',
    postLoad: function() {
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




