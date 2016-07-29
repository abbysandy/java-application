$(function(){
	
	var enterPress = function(e){
		return e.which == 13;
	};
	
	jQuery.fn.extend({
		makeEditable: function() {
//			console.info("makeEditable");
			
			var source = $(this);
			source.find(".editable-display").hide();
			source.find(".editable-input").show().focus();
		},
		submitEditable: function(){
//			console.info("submitted");
			
		},
		cancelEditable: function() {
//			console.info("canceled");
			
			var source = $(this);
			source.find(".editable-display").show();
			source.find(".editable-input").hide();
		},
		enableEditable: function(){
//			console.info("enableEditable");
			
			var source = $(this);
			source.on("click", function(){
				var field = $(this);
				$("[data-editable-field]").cancelEditable();
				field.off("click").makeEditable();
			});
			source.submitEditable();
		},
		submitEditable: function(){
			var source = $(this);
			
			source.find(".editable-input").on("keypress", function(e){
				var input = $(this);
				
				if(enterPress(e)){
					var data = {
						name: input.attr("name"),
						value: input.val()
					};
					
					$.ajax({
						url: source.data("editable-entity"),
						method: "PATCH",
						data: data
					}).success(function(response){
						console.log("success", response);
						
					}).error(function(response){
						console.log("error", response);
					});
					
					source.cancelEditable();
				}
			});
		}
	});
	
	
	var textInput = $("<input />").attr("type", "text").addClass("form-control editable-input");
	var textSpan = $("<span />").addClass("editable-display");
	
	$("[data-editable]").find("[data-editable-entity]").each(function(){
		var source = $(this);
		
		source.find("[data-editable-field]").each(function(){
			var field = $(this);
			var fieldSpan = textSpan.clone().html(field.html());
			var fieldInput = textInput.clone();
			
			fieldInput.val(field.html());
			fieldInput.attr("name", field.data("editable-field"));
			
			field.html(fieldSpan);
			field.append(fieldInput);
			field.data("editable-entity", source.data("editable-entity"));
			field.enableEditable();
			
		});
	});
	
	
});

