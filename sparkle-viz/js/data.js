
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
  var url = 'data/' + mdn + '.json';

  var xhrArgs = {
    url: url,
    handleAs: 'json',
    postLoad: function() {
      //addRandomnessToLocData();
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
  {"data":"playback #0","location":{"id":0,"lon":-122.26870437999999,"lat":37.874003689999995,"unc":459,"time":1302712138,"expiration":1389135926}},
  {"data":"playback #1","location":{"id":1,"lon":-122.26854132,"lat":37.87323758,"unc":19,"time":1302712141,"expiration":1389135926}},
  {"data":"playback #2","location":{"id":2,"lon":-122.26823449,"lat":37.87043088,"unc":20,"time":1302712280,"expiration":1389135926}},
  {"data":"playback #3","location":{"id":3,"lon":-122.2676758,"lat":37.8346881,"unc":37,"time":1302713131,"expiration":1389135926}},
  {"data":"playback #4","location":{"id":4,"lon":-122.26668631,"lat":37.83122326,"unc":17,"time":1302713140,"expiration":1389135926}},
  {"data":"playback #5","location":{"id":5,"lon":-122.26972872,"lat":37.81928345,"unc":15,"time":1302713282,"expiration":1389135926}},
  {"data":"playback #6","location":{"id":6,"lon":-122.403708,"lat":37.7874072,"unc":30,"time":1302714319,"expiration":1389135926}},
  {"data":"playback #7","location":{"id":7,"lon":-122.40658090000002,"lat":37.78459181000001,"unc":60,"time":1302715693,"expiration":1389135926}},
  {"data":"playback #8","location":{"id":8,"lon":-122.40587631,"lat":37.7842126,"unc":29,"time":1302716443,"expiration":1389135926}},
  {"data":"playback #9","location":{"id":9,"lon":-122.40644524999999,"lat":37.7845637,"unc":284,"time":1302716636,"expiration":1389135926}},
  {"data":"playback #10","location":{"id":10,"lon":-122.40677823,"lat":37.78388827,"unc":39,"time":1302716823,"expiration":1389135926}},
  {"data":"playback #11","location":{"id":11,"lon":-122.40744476,"lat":37.784319419999996,"unc":65,"time":1302717557,"expiration":1389135926}},
  {"data":"playback #12","location":{"id":12,"lon":-122.40743619999999,"lat":37.78430185,"unc":65,"time":1302717831,"expiration":1389135926}},
  {"data":"playback #13","location":{"id":13,"lon":-122.4063513,"lat":37.785255250000006,"unc":326,"time":1302718710,"expiration":1389135926}},
  {"data":"playback #14","location":{"id":14,"lon":-122.40510098,"lat":37.786047339999996,"unc":211,"time":1302719433,"expiration":1389135926}},
  {"data":"playback #15","location":{"id":15,"lon":-122.40538724,"lat":37.78593505,"unc":93,"time":1302719594,"expiration":1389135926}},
  {"data":"playback #16","location":{"id":16,"lon":-122.40337322,"lat":37.78714146,"unc":62,"time":1302719855,"expiration":1389135926}},
  {"data":"playback #17","location":{"id":17,"lon":-122.40315773,"lat":37.78849383,"unc":37,"time":1302720004,"expiration":1389135926}},
  {"data":"playback #18","location":{"id":18,"lon":-122.40347137,"lat":37.78865114,"unc":38,"time":1302720263,"expiration":1389135926}},
  {"data":"playback #19","location":{"id":19,"lon":-122.40150202,"lat":37.78802421,"unc":42,"time":1302720787,"expiration":1389135926}},
  {"data":"playback #20","location":{"id":20,"lon":-122.40152966,"lat":37.78802185,"unc":64,"time":1302720988,"expiration":1389135926}},
  {"data":"playback #21","location":{"id":21,"lon":-122.403252,"lat":37.787232,"unc":596,"time":1302721285,"expiration":1389135926}},
  {"data":"playback #22","location":{"id":22,"lon":-122.39991041,"lat":37.79410156,"unc":50,"time":1302721393,"expiration":1389135926}},
  {"data":"playback #23","location":{"id":23,"lon":-122.4001139,"lat":37.79116889,"unc":27,"time":1302721603,"expiration":1389135926}},
  {"data":"playback #24","location":{"id":24,"lon":-122.40034284,"lat":37.79012729,"unc":35,"time":1302721958,"expiration":1389135926}},
  {"data":"playback #25","location":{"id":25,"lon":-122.39945947500001,"lat":37.79146885,"unc":376,"time":1302723874,"expiration":1389135926}},
  {"data":"playback #26","location":{"id":26,"lon":-122.39888540000001,"lat":37.791278950000006,"unc":387,"time":1302724383,"expiration":1389135926}},
  {"data":"playback #27","location":{"id":27,"lon":-122.40407787,"lat":37.78754481,"unc":83,"time":1302724944,"expiration":1389135926}},
  {"data":"playback #28","location":{"id":28,"lon":-122.4057426,"lat":37.78562169,"unc":23,"time":1302725061,"expiration":1389135926}},
  {"data":"playback #29","location":{"id":29,"lon":-122.4066211,"lat":37.7835933,"unc":60,"time":1302725326,"expiration":1389135926}},
  {"data":"playback #30","location":{"id":30,"lon":-122.40640508000001,"lat":37.78447966,"unc":60,"time":1302726723,"expiration":1389135926}},
  {"data":"playback #31","location":{"id":31,"lon":-122.40741103333333,"lat":37.784351799999996,"unc":65,"time":1302727310,"expiration":1389135926}},
  {"data":"playback #32","location":{"id":32,"lon":-122.40672367142858,"lat":37.784581,"unc":324,"time":1302727670,"expiration":1389135926}},
  {"data":"playback #33","location":{"id":33,"lon":-122.2869557,"lat":37.8019956,"unc":34,"time":1302729548,"expiration":1389135926}},
  {"data":"playback #34","location":{"id":34,"lon":-122.26649284,"lat":37.82845954,"unc":9,"time":1302730318,"expiration":1389135926}},
  {"data":"playback #35","location":{"id":35,"lon":-122.26636722,"lat":37.82840327,"unc":11,"time":1302730539,"expiration":1389135926}},
  {"data":"playback #36","location":{"id":36,"lon":-122.26982195,"lat":37.82750392,"unc":19,"time":1302730773,"expiration":1389135926}},
  {"data":"playback #37","location":{"id":37,"lon":-122.2796369,"lat":37.83094468,"unc":19,"time":1302730938,"expiration":1389135926}},
  {"data":"playback #38","location":{"id":38,"lon":-122.28891152,"lat":37.83320015,"unc":26,"time":1302731076,"expiration":1389135926}},
  {"data":"playback #39","location":{"id":39,"lon":-122.29132883,"lat":37.8404844,"unc":19,"time":1302731370,"expiration":1389135926}},
  {"data":"playback #40","location":{"id":40,"lon":-122.2910134,"lat":37.8419074,"unc":178,"time":1302732404,"expiration":1389135926}}
];
