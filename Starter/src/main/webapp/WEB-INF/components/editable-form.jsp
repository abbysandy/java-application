<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form id="editable-form" action="/" class="editable-form form-inline">

	<div class="form-group">
		
		<input type="text" class="form-control editable-input" />
		
		<button type="submit" class="btn btn-primary editable-save">
			<span class="glyphicon glyphicon-ok"></span>
		</button>
		
		<button type="button" class="btn btn-default editable-cancel">
			<span class="glyphicon glyphicon-remove"></span>
		</button>
		
	</div>
	
	<div id="editable-form-errors" class="editable-form-errors">
	
		<div id="editable-form-error" class="alert alert-danger">
		    <button title="close" aria-label="close" data-dismiss="alert" class="close">×</button>
		    <strong>Error:</strong>
		    <span class="message">This alert box indicates a dangerous or potentially negative action.</span>
		</div>
		
	</div>
		
</form:form>
