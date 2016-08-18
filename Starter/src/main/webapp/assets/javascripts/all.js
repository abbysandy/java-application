
var KEYCODES = {
	ENTER: 13,
	ESC: 27
};

$(function(){
	
	$(".delete-confirmation").on("show.bs.modal", function(e) {
		console.log($(e.relatedTarget).data("action"));
		
	//    $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
	//    $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
	});
	
});
