
var TIMELINE_LEFT_EDGE = 7;
var TIMELINE_IMG_WIDTH = 906;
var TIMELINE_RIGHT_EDGE = TIMELINE_IMG_WIDTH - 70;
var TIMELINE_WIDTH = TIMELINE_RIGHT_EDGE - TIMELINE_LEFT_EDGE;

var nub = null;
var mapdiv = null;
var map;
var polyline;
var accuracyCircles;
var accuracyCircleMarkers;
var lastSpanSrcId;

var playing = 0;


function createMap() {
  // create the map
  var latlng = new google.maps.LatLng(37.828,-122.3);
  var myOptions = {
    zoom: 14,
    center: latlng,
    mapTypeControlOptions: {
      position: google.maps.ControlPosition.LEFT_CENTER
    },
    panControl: false,
    zoomControlOptions: {
      position: google.maps.ControlPosition.LEFT_CENTER
    },
    mapTypeId: google.maps.MapTypeId.TERRAIN
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
  for (var circ in accuracyCircles) {
    accuracyCircles[circ].setMap(null);
    accuracyCircleMarkers[circ].setMap(null);
  }
  addBasePolygons();
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

  var progressPercent = 100 * ((lpos-TIMELINE_LEFT_EDGE)/TIMELINE_WIDTH);
  var curTime = getTimeAt(progressPercent);
  updateTime(curTime, progressPercent);

  var curSpan = getTravelSpan(curTime);
  checkForNewSpan(curSpan);

  var center = curSpan.getPosAtTime(curTime);
  //console.debug(fmtDate(curTime) + ': ' + center);
  map.setCenter(center);

  var path = polyline.getPath();
  path.push(center);

  setTimeout(doMove,200); // animation loop
}


function checkForNewSpan(curSpan) {
  if (curSpan.src.id != lastSpanSrcId) {
    var locCirOptions = {
      strokeColor: '#9C09CD',
      strokeOpacity: 0.8,
      strokeWeight: 1,
      fillColor: '#9C09CD',
      fillOpacity: 0.35,
      map: map,
      center: curSpan.src.latLng(),
      radius: curSpan.src.unc
    };
    var circ = new google.maps.Circle(locCirOptions);
    accuracyCircles.push(circ);

      // add address info to accuracy circle
    var geocoder = new google.maps.Geocoder();
    var ll = curSpan.src.latLng();
    geocoder.geocode({'latLng': ll}, function(results, status) {
      var text = fmtDate(curSpan.src.time) + ": ";

      if (status == google.maps.GeocoderStatus.OK && results[0]) {
        console.debug(results[0].formatted_address);
        text += results[0].formatted_address;
      } else {
        text += ll;
      }

      var marker = new google.maps.Marker({
        position: curSpan.src.latLng(),
        map: map,
        icon: 'images/circle_transparent.png',
        title: text
      });
      accuracyCircleMarkers.push(marker);
    });

    polyline.getPath().push(curSpan.src.latLng());
    lastSpanSrcId = curSpan.src.id;
  }
}

function init() {
  nub = document.getElementById('mainButton');
  nub.style.left = TIMELINE_LEFT_EDGE + 'px'; // set its initial position

  createMap();

  var msgElem = document.getElementById('mainMsg');
  msgElem.innerHTML = locData.length + " location updates";

  doMove(); // start animating
}


window.onload = loadLocData;  // load location data,
                              //   which in turn calls init
