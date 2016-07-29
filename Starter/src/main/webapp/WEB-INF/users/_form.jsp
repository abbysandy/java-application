<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:errors path="*" class="form-errors hidden" />

<div class="panel panel-default">

	<div class="panel-heading">
		<h3 class="panel-title">Login Information</h3>
	</div>

	<div class="panel-body">
		
		<div class="form-group">
			<label for="field-username" class="control-label col-sm-2">User Name</label>
			<div class="col-sm-10">
				<div class="input-group">
					<div class="input-group-addon" title="Required">
						<span class="glyphicon glyphicon-ok"></span>
					</div>
					<form:input path="username" class="form-control" id="field-username" placeholder="User Name..." autofocus="autofocus" />
				</div>
				<p class="help-block">User name must be unique.</p>
				<form:errors path="username" class="field-error-message" />
			</div>
		</div>

	</div>
	
	<div class="panel-heading">
    	<h3 class="panel-title">Personal Information</h3>
  	</div>
  
	<div class="panel-body">
		
		<div class="form-group">
			<label for="field-firstname" class="control-label col-sm-2">First Name</label>
			<div class="col-sm-10">
				<div class="input-group">
					<div class="input-group-addon" title="Required">
						<span class="glyphicon glyphicon-ok"></span>
					</div>
					<form:input path="firstname" class="form-control" id="field-firstname" placeholder="First Name..." />
				</div>
				<form:errors path="firstname" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-middlename" class="control-label col-sm-2">Middle Name</label>
			<div class="col-sm-10">
				<form:input path="middlename" class="form-control" id="field-middlename" placeholder="Middle Name..." />
				<form:errors path="middlename" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-lastname" class="control-label col-sm-2">Last Name</label>
			<div class="col-sm-10">
				<div class="input-group">
					<div class="input-group-addon" title="Required">
						<span class="glyphicon glyphicon-ok"></span>
					</div>
					<form:input path="lastname" class="form-control" id="field-lastname" placeholder="Last Name..." />
				</div>
				<form:errors path="lastname" class="field-error-message" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="field-email" class="control-label col-sm-2">Email Address</label>
			<div class="col-sm-10">
				<form:input path="email" class="form-control" id="field-email" placeholder="Email Address..." />
				<form:errors path="email" class="field-error-message" />
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
				<form:input path="zipcode" class="form-control" id="field-zipcode" placeholder="Zip Code..." />
				<form:errors path="zipcode" class="field-error-message" />
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
			<div class="col-sm-offset-2 col-sm-10">
				<button class="btn btn-default">Create User</button>
			</div>
		</div>

	</div>

</div>

