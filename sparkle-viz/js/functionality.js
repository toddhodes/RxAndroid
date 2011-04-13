// JavaScript Document

  dojo.require("dojo.fx");
  dojo.require("dojo.dnd.Moveable");
  dojo.require("dojo.dnd.move");
  dojo.addOnLoad(function(){
  var logo = dojo.byId("logo");
  var mainButton = dojo.byId("mainButton");
  var activated = true;
  var f1 = function() {
		b = {};
		b["t"] = -5;
		b["l"] = 10;
		b["w"] = 906;
		b["h"] = 53;
		return b;	
  }
  
  var moveableObj = new dojo.dnd.move.constrainedMoveable("mainButton",{handle: "mainController", constraints: f1, within: true});
  
  dojo.connect(mainButton, "onclick", function(){
    if(activated){
      dojo.attr(mainButton, "id", "pauseButton");
      var pauseButton = dojo.byId("pauseButton");
      activated = false;
      playing = 0;
      doMove();
    } else {
      dojo.attr(dojo.byId("pauseButton"), "id", "mainButton");
      activated = true;
      playing = 1;
      doMove();
    }
  });


  dojo.connect(logo, "onclick", function() {
      //code for logo click through
    });
  });


function updateTime(time) {
  var dt = new Date(time*1000);
  var timeElem = document.getElementById('timeMsg');
  timeElem.innerHTML = dt.format("h:MMtt");
  var dateElem = document.getElementById('dateMsg');
  dateElem.innerHTML = dt.format("mmmm dS, yyyy");
}

function fmtDate(time) {
  var dt = new Date(time*1000);
  return dt.format("mmmm dS, yyyy h:MMtt");
}

