$(function(){
	
	var form = '<form class="editable-form form-inline">';
		form += '<div class="form-group">';
			form += '<input type="text" class="form-control editable-input" />';
			form += '<button type="submit" class="btn btn-primary editable-save">';
				form += '<span class="glyphicon glyphicon-ok"></span>';
			form += '</button>';
			form += '<button type="button" class="btn btn-default editable-cancel">';
				form += '<span class="glyphicon glyphicon-remove"></span>';
			form += '</button>';
		form += '</div>';
	form += '</form>';

	var form = $(form);
	$("body").append(form);
	
	form.find(".editable-cancel").on("click", function(){
		$(".editable-field").removeClass("editing");
		form.hide();
	});
	
	form.on("submit", function(){
		
		var input = $(this).find(".editable-input");
		
		var data = {
			name: input.attr("name"),
			value: input.val()
		};
		
		$.ajax({
			url: form.attr("action"),
			method: "PATCH",
			data: data
		}).success(function(response){
			$(".editable-field").removeClass("editing");
			form.hide();
		}).error(function(response){
			console.log(response.responseJSON);
		});
		
		return false;
	});
	
	jQuery.fn.extend({
		edit: function(){
			
			var source = $(this).addClass("editing");
			
			form.show();
			
			form.css({
				"top": source.position().top + 24,
				"left": source.position().left + 32
			});
			
			form.attr("action", source.data("editable-url"));
			
			var input = form.find(".editable-input");
			input.attr("name", source.data("editable-field"));
			input.val(source.data("editable-value")).focus();
		}
	});
	
	var display = $("<span />").addClass("editable-display");
	
	$("[data-editable]").find("[data-editable-entity]").each(function(){
		
		var entity = $(this);
		
		entity.find("[data-editable-field]").each(function(){
			var field = $(this);
			var value = field.html();
			
			field.addClass("editable-field");
			field.html(display.clone().html(value));
			field.attr("data-editable-entity", entity.data("editable-entity"));
			field.attr("data-editable-url", entity.data("editable-url"));
			field.attr("data-editable-value", value);
			field.on("click", field.edit);
		});
	});
		
	
	var enterPress = function(e){
		return e.keyCode == KEYCODES.ENTER;
	};
	
	var escPress = function(e){
		return e.keyCode == KEYCODES.ESC;
	};
	
	/*
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
	*/
	
});

