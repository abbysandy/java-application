$(function(){
	
	$("select.bind-select2").each(function(){
		var source = $(this);
		
		source.select2({
			placeholder: source.attr("placeholder")
		});
	});
	
});
