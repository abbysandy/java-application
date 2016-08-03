$(function(){
	
	if($(".form-errors").length > 0){
		$(".form-group").addClass("has-success");
		$(".field-error-message").parents(".form-group").addClass("has-error");
	}
	
});
