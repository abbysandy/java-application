<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:errors path="*" class="form-errors" />

<div class="panel panel-default">

	<div class="panel-heading">
		<h3 class="panel-title">Post Information</h3>
	</div>

	<div class="panel-body">
		
		<div class="form-group">
			<label for="field-title" class="control-label col-sm-2">Title</label>
			<div class="col-sm-10">
				<div class="input-group">
					<div class="input-group-addon" title="Required">
						<span class="glyphicon glyphicon-ok"></span>
					</div>
					<form:input path="title" class="form-control" id="field-title" placeholder="Title..." autofocus="autofocus" />
				</div>
				<form:errors path="title" class="field-error-message" />
			</div>
		</div>

	</div>
		
	<div class="panel-body panel-border-top">
	
		<div class="form-group">
			<div class="col-xs-12">
				<button class="btn btn-block btn-primary">${action} Post</button>
			</div>
		</div>

	</div>

</div>
