// JavaScript Document

  dojo.require("dojo.fx");
  dojo.addOnLoad(function(){
  var logo = dojo.byId("logo");
  var mainButton = dojo.byId("mainButton");
  var activated = true;

  dojo.connect(mainButton, "onclick", function(){
    if(activated){
      dojo.attr(mainButton, "id", "pauseButton");
      var pausedButton = dojo.byId("pauseButton");
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
  var timeStringElem = document.getElementById('timeString');
  timeStringElem.innerHTML = dt.format("h:MMtt");

  var dateStringElem = document.getElementById('dateString');
  dateStringElem.innerHTML = dt.format("mmmm dS, yyyy");
}

function fmtDate(time) {
  var dt = new Date(time*1000);
  return dt.format("mmmm dS, yyyy h:MMtt");
}

