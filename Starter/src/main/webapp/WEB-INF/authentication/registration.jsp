<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:errors path="*" class="form-errors hidden" />

<form:form modelAttribute="userRegistrationForm" action="/users/registration" method="POST" class="form-horizontal">
	
	<div class="panel panel-default">

		<div class="panel-heading">
			<h3 class="panel-title">Login Information</h3>
		</div>
	
		<div class="panel-body">
			
			<div class="form-group">
				<label for="field-userName" class="control-label col-sm-2">User Name</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="input-group-addon" title="Required">
							<span class="glyphicon glyphicon-ok"></span>
						</div>
						<form:input path="userName" class="form-control" id="field-userName" placeholder="User Name..." autofocus="autofocus" />
					</div>
					<form:errors path="userName" class="field-error-message" />
				</div>
			</div>
			
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
		
		<div class="panel-heading">
	    	<h3 class="panel-title">Personal Information</h3>
	  	</div>
	  
		<div class="panel-body">
			
			<div class="form-group">
				<label for="field-firstName" class="control-label col-sm-2">First Name</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="input-group-addon" title="Required">
							<span class="glyphicon glyphicon-ok"></span>
						</div>
						<form:input path="firstName" class="form-control" id="field-firstName" placeholder="First Name..." />
					</div>
					<form:errors path="firstName" class="field-error-message" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="field-lastName" class="control-label col-sm-2">Last Name</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="input-group-addon" title="Required">
							<span class="glyphicon glyphicon-ok"></span>
						</div>
						<form:input path="lastName" class="form-control" id="field-lastName" placeholder="Last Name..." />
					</div>
					<form:errors path="lastName" class="field-error-message" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="field-emailAddress" class="control-label col-sm-2">Email Address</label>
				<div class="col-sm-10">
					<div class="input-group">
						<div class="input-group-addon" title="Required">
							<span class="glyphicon glyphicon-ok"></span>
						</div>
						<form:input path="emailAddress" class="form-control" id="field-emailAddress" placeholder="Email Address..." />
					</div>
					<form:errors path="emailAddress" class="field-error-message" />
				</div>
			</div>
			
		</div>
			
		<div class="panel-body panel-border-top">
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default">Register</button>
				</div>
			</div>
	
		</div>
	
	</div>
		
	
</form:form>