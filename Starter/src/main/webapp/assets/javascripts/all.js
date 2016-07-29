$(function(){
	
	var enterPress = function(e){
		return e.which == 13;
	};
	
	jQuery.fn.extend({
		enableEditable: function(){
			var source = $(this);
			source.on("click", function(){
				var field = $(this);
				$("[data-editable-field]").cancelEditable();
				field.editEditable();
			});
			source.submitEditable();
		},
		editEditable: function() {
			var source = $(this);
			source.find(".editable-display").hide();
			source.find(".editable-input").show().focus();
		},
		cancelEditable: function() {
			var source = $(this);
			source.find(".editable-display").show();
			source.find(".editable-input").hide();
		},
		submitEditable: function(){
			var source = $(this);
			var input = source.find(".editable-input");
			var display = source.find(".editable-display");
			
			input.on("keypress", function(e){
				
				if(enterPress(e)){
					var data = {
						name: input.attr("name"),
						value: input.val()
					};
					
					$.ajax({
						url: source.data("editable-url"),
						method: "PATCH",
						data: data
					}).success(function(response){
						var entity = response[source.data("editable-entity")];
						var value = entity[input.attr("name")];
						input.val(value);
						display.html(value);
						source.cancelEditable();
					}).error(function(response){
						console.log("error", response);
					});
					
				}
			});
		}
	});
	
	
	var textInput = $("<input />").attr("type", "text").addClass("form-control editable-input");
	var textDisplay = $("<span />").addClass("editable-display");
	
	$("[data-editable]").find("[data-editable-entity]").each(function(){
		var source = $(this);
		
		source.find("[data-editable-field]").each(function(){
			var field = $(this);
			var fieldSpan = textDisplay.clone().html(field.html());
			var fieldInput = textInput.clone();
			
			fieldInput.val(field.html());
			fieldInput.attr("name", field.data("editable-field"));
			
			field.html(fieldSpan);
			field.append(fieldInput);
			field.data("editable-entity", source.data("editable-entity"));
			field.data("editable-url", source.data("editable-url"));
			field.enableEditable();
			
		});
	});
	
	
});

