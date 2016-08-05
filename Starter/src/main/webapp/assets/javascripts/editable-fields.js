$(function(){
	
	var enterPress = function(e){
		return e.keyCode == KEYCODES.ENTER;
	};
	
	var escPress = function(e){
		return e.keyCode == KEYCODES.ESC;
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
		error: function(response){
			var source = $(this);
			var group = source.find(".editable-form-group"); 
			group.addClass("has-error");
			
			for(var i in response.errors){
				var error = response.errors[i];
				group.append($("<p />").addClass("editable-help help-block").html(error.defaultMessage));
			}
		},
		submitEditable: function(){
			var source = $(this);
			var input = source.find(".editable-input");
			var display = source.find(".editable-display");
			
			input.on("keypress", function(e){
				
				if(escPress(e)){
					source.cancelEditable();
					
				} else if(enterPress(e)){
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
						source.error(response.responseJSON);
					});
					
				}
			});
		}
	});
	
	var textGroup = $("<span />").addClass("editable-form-group form-group");
	var textInput = $("<input />").attr("type", "text").addClass("form-control editable-input");
	var textDisplay = $("<span />").addClass("editable-display");
	
	$("[data-editable]").find("[data-editable-entity]").each(function(){
		var source = $(this);
		
		source.find("[data-editable-field]").each(function(){
			var field = $(this);
			var fieldSpan = textDisplay.clone().html(field.html());
			var fieldGroup = textGroup.clone();
			var fieldInput = textInput.clone();
			
			fieldInput.val(field.html());
			fieldInput.attr("name", field.data("editable-field"));
			
			field.html(fieldSpan);
			field.append(fieldGroup.append(fieldInput));
			field.data("editable-entity", source.data("editable-entity"));
			field.data("editable-url", source.data("editable-url"));
			field.enableEditable();
		});
	});
	
});

