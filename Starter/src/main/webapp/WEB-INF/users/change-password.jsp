<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="userPasswordForm" action="/users/change-password" method="PATCH" class="form-horizontal">
	
	<div class="panel panel-default">
	
		<div class="panel-heading">
			<h3 class="panel-title">Change Password</h3>
		</div>
	
		<div class="panel-body">
			
			<div class="form-group">
				<label for="field-password" class="control-label col-sm-2">Password</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="input-group-addon" title="Required">
							<span class="glyphicon glyphicon-ok"></span>
						</div>
						<form:password path="password" class="form-control" id="field-password" placeholder="Password..." autofocus="autofocus" />
					</div>
					<form:errors path="password" class="field-error-message" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="field-confirmPassword" class="control-label col-sm-2">Confirm Password</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="input-group-addon" title="Required">
							<span class="glyphicon glyphicon-ok"></span>
						</div>
						<form:password path="confirmPassword" class="form-control" id="field-confirmPassword" placeholder="Confirm Password..." autofocus="autofocus" />
					</div>
					<form:errors path="confirmPassword" class="field-error-message" />
				</div>
			</div>
	
		</div>
		
		<div class="panel-body panel-border-top">
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default">Change</button>
				</div>
			</div>
	
		</div>
		
	</div>

</form:form>
