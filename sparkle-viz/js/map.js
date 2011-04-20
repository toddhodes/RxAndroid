
var TIMELINE_LEFT_EDGE = 0;
var TIMELINE_IMG_WIDTH = 892;
var TIMELINE_RIGHT_EDGE = TIMELINE_IMG_WIDTH - 82 - 68;
var TIMELINE_WIDTH = TIMELINE_RIGHT_EDGE - TIMELINE_LEFT_EDGE;

var data;

var nub;
var mapdiv;
var map;
var polyline;
var accuracyCircles = [];
var accuracyCircleMarkers = [];

var playing = 0;


function createMap() {
  // create the map
  var latlng = new google.maps.LatLng(37.828,-122.3);
  var myOptions = {
    zoom: 14,
    center: latlng,
    panControl: false,
    zoomControl: true,
    zoomControlOptions: {
      position: google.maps.ControlPosition.LEFT_CENTER
    },
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  map = new google.maps.Map(document.getElementById("map_canvas"),
                            myOptions);
  addBasePolygons();
}

function addBasePolygons() {
  var polyOptions = {
    strokeColor: '#9C09CD',
    strokeOpacity: 0.7,
    strokeWeight: 2
  };
  polyline = new google.maps.Polyline(polyOptions);
  polyline.setMap(map);

  accuracyCircles = [];
  accuracyCircleMarkers = [];
}

function clearPolygons() {
  polyline.setMap(null);
  clearCircles();
  addBasePolygons();
}

function clearCircles() {
  console.debug("clear #circs: ",
                accuracyCircles.length,
                accuracyCircleMarkers.length);
  for (var c in accuracyCircles) {
    accuracyCircles[c].setMap(null);
  }
  for (var cm in accuracyCircleMarkers) {
    accuracyCircleMarkers[cm].setMap(null);
  }
  accuracyCircles = [];
  accuracyCircleMarkers = [];
}



function doMove() {
  if (!playing) return;

  var lpos = parseInt(nub.style.left);
  lpos += 1;
  if (lpos > TIMELINE_RIGHT_EDGE) {
    lpos = TIMELINE_LEFT_EDGE;
    clearPolygons();
      // tmp fix for map refresh bug
    nub.style.left = lpos + 'px';
    dojo.attr(dojo.byId("pauseButton"), "id", "mainButton");
    playing = 0;
    return;
  }
  nub.style.left = lpos + 'px';

  updatePath();

  setTimeout(doMove,200); // animation loop
}

function updatePath() {
  var lpos = parseInt(nub.style.left);
  var progressPercent = 100 * ((lpos-TIMELINE_LEFT_EDGE)/TIMELINE_WIDTH);
  var curTime = data.getTimeAt(progressPercent);
  updateTime(curTime);

    // get latest path
  var locs = data.getPathAtTime(curTime);

  var path = new google.maps.MVCArray();

    // line
  locs.forEach(function(element) {
                 path.push(element.latLng());
               });
  polyline.setPath(path);

  console.debug("# locs, circs=",
                locs.getLength(),
                accuracyCircles.length);

  var c, llen = locs.getLength(), clen = accuracyCircles.length;
  for (c = clen; c < llen; c++) {
    var element = locs.getAt(c);
    if (element.id) {
      createCircle(element);
    }
  }
  if (llen < clen) {
    for (c = llen; c < clen; c++) {
      accuracyCircles.pop().setMap(null);
    }
    clen = accuracyCircleMarkers.length;
    for (c = llen; c < clen; c++) {
      accuracyCircleMarkers.pop().setMap(null);
    }
  }

  // center map
  var endpt = path.getAt(path.getLength()-1);
  map.setCenter(endpt);
}



function createCircle(location) {
  var locCirOptions = {
    strokeColor: '#9C09CD',
    strokeOpacity: 0.8,
    strokeWeight: 1,
    fillColor: '#9C09CD',
    fillOpacity: 0.35,
    map: map,
    center: location.latLng(),
    radius: location.unc
  };
  var circ = new google.maps.Circle(locCirOptions);
  accuracyCircles.push(circ);

    // add address info to accuracy circle
    var geocoder = new google.maps.Geocoder();
    var ll = location.latLng();
    geocoder.geocode({'latLng': ll}, function(results, status) {
      var text = fmtDate(location.time) + ": ";

      if (status == google.maps.GeocoderStatus.OK && results[0]) {
        console.debug(results[0].formatted_address);
        text += results[0].formatted_address;
      } else {
        text += ll;
      }

      var marker = new google.maps.Marker({
        position: location.latLng(),
        map: map,
        icon: 'images/circle_transparent.png',
        title: text
      });
      accuracyCircleMarkers.push(marker);
    });

}

function init() {
  nub.style.left = TIMELINE_LEFT_EDGE + 'px'; // set its initial position

  createMap();

  var msgElem = document.getElementById('mainMsg');
  msgElem.innerHTML = data.locData.length + " location updates";

  doMove(); // start animating
}


window.onload = function() {
  nub = document.getElementById('sliderNub');

  // load location data, which in turn calls init
  data = new DataContainer();
  data.load();
};
