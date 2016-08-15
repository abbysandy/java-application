<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<c:if test="${not empty user.createdBy}">
		<dt>Created:</dt>
		<dd>
			<a href="/users/${user.createdBy.id}">
				${user.createdBy.firstName} ${user.createdBy.lastName}
			</a>
			 at ${user.createdAt}
		</dd>
	</c:if>
	
	<c:if test="${not empty user.updatedBy}">
		<dt>Last Updated:</dt>
		<dd>
			<a href="/users/${user.updatedBy.id}">
				${user.updatedBy.firstName} ${user.updatedBy.lastName}
			</a>
			at ${user.updatedAt}</dd>
	</c:if>
	
</dl>
