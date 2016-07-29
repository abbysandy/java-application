<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layout/header.jsp" %>

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
				<td data-editable-field="username">${user.username}</td>
				<td data-editable-field="firstname">${user.firstname}</td>
				<td data-editable-field="lastname">${user.lastname}</td>
				<td data-editable-field="phone">${user.phone}</td>
				<td data-editable-field="address">${user.address}</td>
				<td data-editable-field="city">${user.city}</td>
				<td data-editable-field="state">${user.state}</td>
				<td data-editable-field="zipcode">${user.zipcode}</td>
				<td data-editable-field="country">${user.country}</td>
				<td>
					<a href="/users/${user.id}" class="btn btn-sm btn-primary">
						<span class="glyphicon glyphicon-eye-open"></span>
						View
					</a>
					<a href="/users/${user.id}/edit" class="btn btn-sm btn-success">
						<span class="glyphicon glyphicon-edit"></span>
						Edit
					</a>
					<form action="/users/${user.id}" method="POST" class="inline">
						<input type="hidden" name="_method" value="DELETE" />
						<button class="btn btn-sm btn-danger">
							<span class="glyphicon glyphicon-trash"></span>
							Delete
						</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>

<%@ include file="../layout/footer.jsp" %>
