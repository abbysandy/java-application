<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:errors path="*" class="form-errors" />

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
			<label for="field-middleName" class="control-label col-sm-2">Middle Name</label>
			<div class="col-sm-10">
				<form:input path="middleName" class="form-control" id="field-middleName" placeholder="Middle Name..." />
				<form:errors path="middleName" class="field-error-message" />
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
		
		<div class="form-group">
			<label for="field-phone" class="control-label col-sm-2">Phone Number</label>
			<div class="col-sm-10">
				<form:input path="phone" class="form-control" id="field-phone" placeholder="Phone Number..." />
				<form:errors path="phone" class="field-error-message" />
			</div>
		</div>
		
	</div>
		
	<div class="panel-heading">
    	<h3 class="panel-title">Address Information</h3>
  	</div>
  
	<div class="panel-body">
		
		<div class="form-group">
			<label for="field-address" class="control-label col-sm-2">Address</label>
			<div class="col-sm-10">
				<form:input path="address" class="form-control" id="field-address" placeholder="Address..." />
				<form:errors path="address" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-city" class="control-label col-sm-2">City</label>
			<div class="col-sm-10">
				<form:input path="city" class="form-control" id="field-city" placeholder="City..." />
				<form:errors path="city" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-state" class="control-label col-sm-2">State</label>
			<div class="col-sm-10">
				<form:input path="state" class="form-control" id="field-state" placeholder="State..." />
				<form:errors path="state" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-zipcode" class="control-label col-sm-2">Zip Code</label>
			<div class="col-sm-10">
				<form:input path="zipCode" class="form-control" id="field-zipcode" placeholder="Zip Code..." />
				<form:errors path="zipCode" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-country" class="control-label col-sm-2">Country</label>
			<div class="col-sm-10">
				<form:input path="country" class="form-control" id="field-country" placeholder="Country..." />
				<form:errors path="country" class="field-error-message" />
			</div>
		</div>

	</div>
		
	<div class="panel-body panel-border-top">
	
		<div class="form-group">
			<div class="col-xs-12">
				<button class="btn btn-block btn-primary">${action} User</button>
			</div>
		</div>

	</div>

</div>
