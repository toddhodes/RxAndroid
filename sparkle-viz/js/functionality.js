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
			}else {
				dojo.attr(dojo.byId("pauseButton"), "id", "mainButton");
				activated = true;
			}
		});
		
		
		dojo.connect(logo, "onclick", function() {
			//code for logo click through
		});
	});
