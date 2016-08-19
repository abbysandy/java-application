<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="userForgotPasswordForm" action="/login/forgot-password" method="POST">
	<form:errors path="*" class="form-errors" />
	
	<div class="form-group">
		<label for="field-userName">User Name</label>
		<form:input path="userName" class="form-control" id="field-userName" placeholder="User Name..." autofocus="autofocus" />
		<form:errors path="userName" class="field-error-message" />
	</div>
	
	<p class="help-block">We will send you an email with instructions on how to reset your password.</p>
	
	<button type="submit" class="btn btn-primary btn-block">
		Email Me
	</button>
	
</form:form>
