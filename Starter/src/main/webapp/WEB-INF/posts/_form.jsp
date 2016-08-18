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
		
		<div class="form-group">
			<label for="field-alias" class="control-label col-sm-2">Alias</label>
			<div class="col-sm-10">
				<div class="input-group">
					<div class="input-group-addon" title="Required">
						<span class="glyphicon glyphicon-ok"></span>
					</div>
					<form:input path="alias" class="form-control" id="field-alias" placeholder="Alias..." />
				</div>
				<form:errors path="alias" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-content" class="control-label col-sm-2">Content</label>
			<div class="col-sm-10">
				<div class="input-group">
					<div class="input-group-addon" title="Required">
						<span class="glyphicon glyphicon-ok"></span>
					</div>
					<form:textarea path="content" class="form-control" id="field-content" placeholder="Content..." />
				</div>
				<form:errors path="content" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-publishedAt" class="control-label col-sm-2">Publish Date</label>
			<div class="col-sm-10">
				<form:input path="publishedAt" class="form-control" id="field-publishedAt" placeholder="Publish Date..." />
				<p class="help-block">Specify a date if you want this published in the future.</p>
				<form:errors path="publishedAt" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-authoredBy" class="control-label col-sm-2">Author</label>
			<div class="col-sm-10">
				<form:select path="authoredBy" class="form-control bind-select2" id="field-authoredBy">
					<option value="">Select an Author...</option>
					<form:options items="${users}" itemValue="id" itemLabel="fullName" />
				</form:select>
				<form:errors path="publishedAt" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-categories" class="control-label col-sm-2">Categories</label>
			<div class="col-sm-10">
				<form:select path="categories" class="form-control bind-select2" id="field-categories" placeholder="Select Categories...">
					<form:options items="${categories}" itemValue="id" itemLabel="name" />
				</form:select>
				<form:errors path="categories" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-tags" class="control-label col-sm-2">Tags</label>
			<div class="col-sm-10">
				<form:select path="tags" class="form-control bind-select2" id="field-tags" placeholder="Select Tags...">
					<form:options items="${tags}" itemValue="id" itemLabel="name" />
				</form:select>
				<form:errors path="tags" class="field-error-message" />
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
