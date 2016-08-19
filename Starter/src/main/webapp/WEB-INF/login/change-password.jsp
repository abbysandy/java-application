<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Change Password</h2>

<form:form modelAttribute="userPasswordForm" action="/login/change-password/${key}" method="POST">
	<form:errors path="*" class="form-errors" />
	
	<div class="form-group">
		<label for="field-password">Password</label>
		<form:password path="password" class="form-control" id="field-password" placeholder="Password..." autofocus="autofocus" />
		<form:errors path="password" class="field-error-message" />
	</div>
	
	<div class="form-group">
		<label for="field-confirmPassword">Confirm Password</label>
		<form:password path="confirmPassword" class="form-control" id="field-confirmPassword" placeholder="Confirm Password..." />
		<form:errors path="confirmPassword" class="field-error-message" />
	</div>
	
	<button type="submit" class="btn btn-primary btn-block">
		Change Password
	</button>
	
</form:form>
