<%@ include file="../layout/header.jsp" %>

<h1>Users</h1>

<h2>${user.firstname} ${user.lastname}</h2>

<dl class="dl-horizontal">

	<dt>Username:</dt>
	<dd>${user.username}</dd>
	
	<dt>First Name:</dt>
	<dd>${user.firstname}</dd>
	
	<dt>Middle Name:</dt>
	<dd>${user.middlename}</dd>
	
	<dt>Last Name:</dt>
	<dd>${user.lastname}</dd>
	
	<dt>Email:</dt>
	<dd>${user.email}</dd>
	
	<dt>Phone:</dt>
	<dd>${user.phone}</dd>
	
	<dt>Address:</dt>
	<dd>${user.address}</dd>
	
	<dt>city:</dt>
	<dd>${user.city}</dd>
	
	<dt>State:</dt>
	<dd>${user.state}</dd>
	
	<dt>Zip Code:</dt>
	<dd>${user.zipcode}</dd>
	
	<dt>Country:</dt>
	<dd>${user.country}</dd>
	
</dl>



<%@ include file="../layout/footer.jsp" %>