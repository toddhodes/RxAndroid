
var foo = null; // object
var mapdiv = null;

var playing = 1;


function createMap() {
  if (GBrowserIsCompatible()) {
        // create the map
        var map = new GMap2(document.getElementById("map"));
        map.addControl(new GLargeMapControl());
        map.setCenter(new GLatLng(37.828,-122.3), 14);
    }
    else {
      alert("Sorry, the Google Maps API is not compatible with this browser");
    }
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

  var mapdiv = document.getElementById('map');
  var mapRight = parseInt(mapdiv.style.width) - 70;

  if (lpos > mapRight) lpos = 30;
  foo.style.left = lpos+1 + 'px';
  setTimeout(doMove,20); // call doMove in 20msec
}

function init() {
  foo = document.getElementById('fooObject'); // get the "foo" object
  foo.style.left = '30px'; // set its initial position

  doMove(); // start animating
}


window.onload = init;
window.onunload = GUnload;
