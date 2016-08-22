$(function(){
	
	var form = $("#editable-form");
	var formErrors = $("#editable-form-errors");
	var formError = $("#editable-form-error").removeAttr("id").remove();
	
	form.find(".editable-cancel").on("click", function(){
		$(".editable-field").removeClass("editing");
		form.hide();
		formErrors.empty();
	});
	
	form.on("submit", function(){
		
		var input = $(this).find(".editable-input");
		var csrf = $(this).find("input[name=_csrf]");
		
		var data = {
			"name": input.attr("name"),
			"value": input.val(),
			"_csrf": csrf.val()
		};
		
		$.ajax({
			url: form.attr("action"),
			method: "PATCH",
			dataType: "json",
			data: data
		}).success(function(response){
			var editing = $("[data-editable]").find(".editing");
			editing.data("editable-value", data.value);
			editing.find(".editable-display").html(data.value);
			$("[data-editable]").find(".editable-field").removeClass("editing");
			form.hide();
		}).error(function(response){
			var errors = response.responseJSON.errors;
			formErrors.empty();
			
			for(var i in errors){
				var error = errors[i];
				var newFormError = formError.clone();
				newFormError.find(".message").html(error.defaultMessage);
				formErrors.append(newFormError);
			}
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
		
});

