$(function(){

	var table = $(".table");
	table.find("[data-min]").each(tableMin);
	table.find("[data-max]").each(tableMax);
	table.find("[data-width]").each(tableWidth);
	
	function tableMin(){
		var source = $(this);
		source.css("min-width", source.data("min"));
	}
	
	function tableMax(){
		var source = $(this);
		source.css("max-width", source.data("max"));
	}
	
	function tableWidth(){
		var source = $(this);
		source.css("width", source.data("width"));
	}
	
});
