// JavaScript Document

  dojo.require("dojo.fx");
  dojo.require("dojo.dnd.Moveable");
  dojo.require("dojo.dnd.move");
  dojo.addOnLoad(function(){
    var logo = dojo.byId("logo");
    var mainButton = dojo.byId("mainButton");
    var f1 = function() {
      b = {};
      b["t"] = -5;
      b["l"] = TIMELINE_LEFT_EDGE;
      b["w"] = TIMELINE_IMG_WIDTH -26;
      b["h"] = 53;
      return b;
    };

    var moveableObj =
      new dojo.dnd.move.constrainedMoveable("mainButton",
                                            {handle: "mainController",
                                             constraints: f1,
                                             within: true});

    var playPauseToggle = function(){
      if (!playing) {
        dojo.attr(mainButton, "id", "pauseButton");
        var pauseButton = dojo.byId("pauseButton");
        playing = 1;
        doMove();
      } else {
        dojo.attr(dojo.byId("pauseButton"), "id", "mainButton");
        playing = 0;
      }
    };

    dojo.connect(mainButton, "onclick", playPauseToggle);

      // clear polygons if dragged much
    var prevNubLoc;
    dojo.connect(moveableObj, "onFirstMove", function(){
                   //console.log("onFirstMove");
                   prevNubLoc = parseInt(nub.style.left);
                 });
    dojo.connect(moveableObj, "onMoveStop", function() {
                   //console.log("oonMoveStop");
                   var newNubLoc = parseInt(nub.style.left);
                   if (Math.abs(newNubLoc - prevNubLoc) > 20) {
                     console.log("nub moved " + Math.abs(newNubLoc - prevNubLoc));
                     clearPolygons();
                   }
                 });

    dojo.connect(logo, "onclick", function() {
      //code for logo click through
    });
  });


function updateTime(time, progressPercent) {
  var dt = new Date(time*1000);
  var timeElem = document.getElementById('timeMsg');
  timeElem.innerHTML = dt.format("h:MMtt");
  if (progressPercent) {
    timeElem.innerHTML += "<p>(" +progressPercent.toFixed(1) +"%)</p>";
  }
  var dateElem = document.getElementById('dateMsg');
  dateElem.innerHTML = dt.format("mmmm dS, yyyy");
}

function fmtDate(time) {
  var dt = new Date(time*1000);
  return dt.format("mmmm dS, yyyy h:MMtt");
}

