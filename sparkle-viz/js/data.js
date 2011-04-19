

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


function DataContainer() {
  this.locData = [];
  this.travelSpans = [];
  this.beginTime = 0;
  this.endTime = 0;

  this.load = function() {
    locData = [];
    var mdn = urlArg("mdn");
    if (mdn == "") mdn = "5105551212";

    // due to XSS security issues, generally can't access
    // sparkledemo; thus we need this for local devel
    var url = 'data/' + mdn + '.json';

    console.debug("hostname=" + window.location.hostname);
    if (window.location.hostname == "sparkledemo.locationlabs.com") {
      url = 'http://sparkledemo.locationlabs.com/'
              + 'finder-att-family/location_feed/' + mdn + '/playback.svc';
    }

    var xhrArgs = {
      url: url,
      handleAs: 'json',
      container: this,
      postLoad: function() {
        this.container.computeTimeline();
        // now we have data; init the map
        setTimeout(init,1000);
      },
      load: function(data) {
        for (var b in data) {
          this.container.locData.push(data[b]);
        }
        this.postLoad();
      },
      error: function(error) {
        console.warn("An unexpected error occurred: " + error);
        //console.warn("using default data");
        //locData = defaultLocationData;
        this.postLoad();
      }
    };
    var deferred = dojo.xhrGet(xhrArgs);
  };

  this.computeTimeline = function() {
    this.travelSpans = [];

    var cnt = this.locData.length;
    if (cnt < 2) {
      alert("Need at least two locations to animate anything");
      return;
    }

    this.beginTime = this.locData[0].location.time;
    this.endTime = this.locData[this.locData.length-1].location.time;

    for (var i=0; i < cnt-1; i++) {
      var travelSpan = new TravelSpan(this.locData[i].location,
                                      this.locData[i+1].location);
      this.travelSpans.push(travelSpan);
    }
    //console.debug("travelspans: ", this.travelSpans);

    var ticks = this.getTickPercentages();
    console.log("ticks: " , ticks);
    var tickHolder = dojo.byId("timelineBackground");
    for (var tick in ticks) {
      var left = 20 + ticks[tick]/100 * TIMELINE_WIDTH;
      dojo.create("span", { 'class': "tick",
                            style: { left: left.toFixed(0)+"px" }
                          }, tickHolder);
    }

  };

  this.getTickPercentages = function() {
    var ticks = [];
    var cnt = this.locData.length;
    for (var i=0; i < cnt; i++) {
      ticks.push(this.getPercentAt(this.locData[i].location.time).toFixed(2));
    }
    return ticks;
  };

  this.getTimeAt = function(percentComplete) {
    var offset =  (this.endTime - this.beginTime) * (percentComplete / 100);
    return this.beginTime + offset;
  };

  this.getPercentAt = function(time) {
    return 100 * (time - this.beginTime) / (this.endTime - this.beginTime);
  };

  this.getTravelSpan = function(time) {
    //console.debug("getTravelLoc(" + time + ")");
    var lastLoc = 0;
    var nextLoc = 1;

    var cnt = this.locData.length;
    for (var i=0; i < cnt; i++) {
      var locVal = this.locData[i].location;
      if (time > locVal.time) {
        lastLoc = i;
      } else {
        nextLoc = i;
        break;
      }
    }

    var dbgmsg = "tofrom: " + lastLoc + " -> " + nextLoc;
    if (dbgmsg != this.lastdbgmsg) {
      console.debug(dbgmsg);
      this.lastdbgmsg = dbgmsg;
    }

    var span = new TravelSpan(new Location(this.locData[lastLoc].location),
                              new Location(this.locData[nextLoc].location));

    return span;
  };
  this.lastdbgmsg = undefined;

};







