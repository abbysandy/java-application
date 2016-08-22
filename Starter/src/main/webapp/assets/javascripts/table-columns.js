$(function(){
	
	$(".js-table-columns").on("change", function(){
		var form = $(this);
		
		form.find("input[type=checkbox]").each(function(){
			
			var source = $(this);
			
			$("[data-column=" + source.attr("name") + "]").toggleClass("hidden", !source.prop("checked"));
			
		});
		
		$.ajax({
			url: form.attr("action"),
			method: "PUT",
			dataType: "json",
			data: form.serialize()
		}).success(function(response){
			console.log("success");
		}).error(function(response){
			console.log("error");
		});
		
	});
	
});
