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
