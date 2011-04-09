
var foo = null; // object
var mapdiv = null;
var map;
var home;

var playing = 1;


function createMap() {
  // create the map
  var latlng = new google.maps.LatLng(37.828,-122.3);
  home = latlng;
  var myOptions = {
    zoom: 10,
    center: latlng,
    mapTypeId: google.maps.MapTypeId.TERRAIN
  };
  map = new google.maps.Map(document.getElementById("map_canvas"),
                                myOptions);
}

function togglePlayPause() {
  var btn = document.getElementById('playButtonInput');
  if (playing) {
    btn.value = 'play';
    playing = 0;
  } else {
    playing = 1;
    btn.value = 'pause';
    doMove();
  }
}

function doMove() {
  if (!playing) return;

  var lpos = parseInt(foo.style.left);

  var mapdiv = document.getElementById('map_canvas');
  var mapRight = parseInt(mapdiv.style.width) - 70;

  if (lpos > mapRight) lpos = 30;
  foo.style.left = lpos+1 + 'px';

  // random center updates
  if (lpos % 80 == 0) {
    var location = new google.maps.LatLng(
                     home.lat() + 0.3 * Math.random(),
                     home.lng() + 0.3 * Math.random());

    map.setCenter(location);
  }

  setTimeout(doMove,20); // call doMove in 20msec
}

function init() {
  foo = document.getElementById('fooObject'); // get the "foo" object
  foo.style.left = '30px'; // set its initial position

  createMap();
  doMove(); // start animating
}

window.onload = init;
