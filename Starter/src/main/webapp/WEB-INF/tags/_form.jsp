<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:errors path="*" class="form-errors" />

<div class="panel panel-default">

	<div class="panel-heading">
		<h3 class="panel-title">Tag Information</h3>
	</div>

	<div class="panel-body">
		
		<div class="form-group">
			<label for="field-name" class="control-label col-sm-2">Name</label>
			<div class="col-sm-10">
				<div class="input-group">
					<div class="input-group-addon" title="Required">
						<span class="glyphicon glyphicon-ok"></span>
					</div>
					<form:input path="name" class="form-control" id="field-name" placeholder="Name..." autofocus="autofocus" />
				</div>
				<form:errors path="name" class="field-error-message" />
			</div>
		</div>

	</div>
		
	<div class="panel-body panel-border-top">
	
		<div class="form-group">
			<div class="col-xs-12">
				<button class="btn btn-block btn-primary">${action} Tag</button>
			</div>
		</div>

	</div>

</div>
