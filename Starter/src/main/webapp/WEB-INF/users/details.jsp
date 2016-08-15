
<h1>Users</h1>

<h2>
	${user.firstName} ${user.lastName}
	<a href="/users/${user.id}/edit" class="btn btn-success btn-xs">
		<span class="glyphicon glyphicon-edit"></span>
		Edit
	</a>
</h2>
<dl class="dl-horizontal">

	<dt>Username:</dt>
	<dd>${user.userName}</dd>
	
	<dt>First Name:</dt>
	<dd>${user.firstName}</dd>
	
	<dt>Middle Name:</dt>
	<dd>${user.middleName}</dd>
	
	<dt>Last Name:</dt>
	<dd>${user.lastName}</dd>
	
	<dt>Email Address:</dt>
	<dd>${user.emailAddress}</dd>
	
	<dt>Phone:</dt>
	<dd>${user.phone}</dd>
	
	<dt>Address:</dt>
	<dd>${user.address}</dd>
	
	<dt>city:</dt>
	<dd>${user.city}</dd>
	
	<dt>State:</dt>
	<dd>${user.state}</dd>
	
	<dt>Zip Code:</dt>
	<dd>${user.zipCode}</dd>
	
	<dt>Country:</dt>
	<dd>${user.country}</dd>
	
	<dt>Created:</dt>
	<dd>${user.createdBy.firstName} ${user.createdBy.lastName} at ${user.createdAt}</dd>
	
	<dt>Last Updated:</dt>
	<dd>${user.updatedBy.firstName} ${user.updatedBy.lastName} at ${user.updatedAt}</dd>
	
</dl>
