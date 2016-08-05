<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Users</h1>

<div class="tools">
	<a href="/users/new" class="btn btn-default">
		<span class="glyphicon glyphicon-plus"></span>
		Add User
	</a>
</div>

<table class="table table-bordered" data-editable="users">
	<thead>
		<tr>
			<th>#</th>
			<th>User Name</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Address</th>
			<th>Phone</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Zip Code</th>
			<th>Country</th>
			<th width="219">Actions</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${users}" var="user">
			<tr data-editable-entity="user" data-editable-url="/api/users/${user.id}">
				<td>${user.id}</td>
				<td data-editable-field="userName">${user.userName}</td>
				<td data-editable-field="firstName">${user.firstName}</td>
				<td data-editable-field="lastName">${user.lastName}</td>
				<td data-editable-field="emailAddress">${user.emailAddress}</td>
				<td data-editable-field="phone">${user.phone}</td>
				<td data-editable-field="address">${user.address}</td>
				<td data-editable-field="city">${user.city}</td>
				<td data-editable-field="state">${user.state}</td>
				<td data-editable-field="zipcode">${user.zipCode}</td>
				<td data-editable-field="country">${user.country}</td>
				<td>
					<form:form action="/users/${user.id}" method="DELETE" class="inline">
						<div class="btn-group">
							<a href="/users/${user.id}" class="btn btn-sm btn-primary">
								<span class="glyphicon glyphicon-eye-open"></span>
								View
							</a>
							<a href="/users/${user.id}/edit" class="btn btn-sm btn-success">
								<span class="glyphicon glyphicon-edit"></span>
								Edit
							</a>
							<button class="btn btn-sm btn-danger">
								<span class="glyphicon glyphicon-trash"></span>
								Delete
							</button>
						</div>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>
