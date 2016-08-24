$(function(){
	
	$(".js-table-columns").on("change", function(){
		var form = $(this);
		
		var fields = [];
		
		form.find("input[type=checkbox]").each(function(){
			
			var source = $(this);
			
			$("[data-column=" + source.attr("name") + "]").toggleClass("hidden", !source.prop("checked"));
			
			fields.push({
				"name": source.attr("name"),
				"visible": source.prop("checked") 
			});
			
		});
		
		var csrf = form.find("input[name=_csrf]");
		
		var data = {
			"fields": fields,
			"_csrf": csrf.val()
		};
		
		$.ajax({
			url: form.attr("action"),
			method: "PUT",
			dataType: "json",
			data: data
		}).success(function(response){
		}).error(function(response){
		});
		
	});
	
});
