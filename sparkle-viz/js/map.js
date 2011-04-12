
var TIMELINE_LEFT_EDGE = 10;
var TIMELINE_WIDTH = 906;

var nub = null;
var mapdiv = null;
var map;
var polyline;
var locationCircle;

var home;

var playing = 1;
var prevLatLng;
var currLatLng;
var destLatLng;


function createMap() {
  // create the map
  var latlng = new google.maps.LatLng(37.828,-122.3);
  home = latlng;
  var myOptions = {
    zoom: 10,
    center: latlng,
    mapTypeControlOptions: {
      position: google.maps.ControlPosition.BOTTOM_RIGHT
    },
    panControlOptions: {
      position: google.maps.ControlPosition.LEFT_CENTER
    },
    zoomControlOptions: {
      position: google.maps.ControlPosition.LEFT_CENTER
    },

    mapTypeId: google.maps.MapTypeId.TERRAIN
  };
  map = new google.maps.Map(document.getElementById("map_canvas"),
                                myOptions);

  var polyOptions = {
    strokeColor: '#9C09CD', //'#540975',
    strokeOpacity: 0.7,
    strokeWeight: 2
  }
  polyline = new google.maps.Polyline(polyOptions);
  polyline.setMap(map);
}

function doMove() {
  if (!playing) return;

  var lpos = parseInt(nub.style.left);

  //var timelinediv = document.getElementById('timelineBackground');
  //var rightEdge = parseInt(timelinediv.style.width) - 70;
  var rightEdge = TIMELINE_WIDTH - 70;

  if (lpos > rightEdge) lpos = TIMELINE_LEFT_EDGE;
  nub.style.left = lpos+1 + 'px';

  // random center updates
  if (lpos % 130 == 0) {
    var location = new google.maps.LatLng(
                     home.lat() + 0.1 * Math.random(),
                     home.lng() + 0.1 * Math.random());

    var locCirOptions = {
      strokeColor: '#9C09CD', // '#540975',
      strokeOpacity: 0.8,
      strokeWeight: 1,
      fillColor: '#9C09CD', //'#540975',
      fillOpacity: 0.35,
      map: map,
      center: location,
      radius: Math.random()*1000
    };
    locationCircle = new google.maps.Circle(locCirOptions);

    var path = polyline.getPath();
    path.push(location);

    map.setCenter(location);
  }

  setTimeout(doMove,20); // call doMove in 20msec
}

function init() {
  nub = document.getElementById('mainButton');
  nub.style.left = TIMELINE_LEFT_EDGE + 'px'; // set its initial position

  createMap();
  doMove(); // start animating
}

window.onload = init;
