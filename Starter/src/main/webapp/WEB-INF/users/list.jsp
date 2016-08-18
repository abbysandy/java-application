<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<h1>Users</h1>

<div class="tools">
	<a href="/users/new" class="btn btn-default">
		<span class="glyphicon glyphicon-plus"></span>
		Add User
	</a>
</div>

<table class="table table-bordered table-responsive" data-editable="users">
	<thead>
		<tr>
			<th class="sortable ${sortable.userName}">
				<a href="/users?size=${pagination.size}&sort=userName:asc">
					User Name
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.firstName}">
				<a href="/users?size=${pagination.size}&sort=firstName:asc">
					First Name
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.lastName}">
				<a href="/users?size=${pagination.size}&sort=lastName:asc">
					Last Name
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.emailAddress}">
				<a href="/users?size=${pagination.size}&sort=emailAddress:asc">
					Email Address
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.phone}">
				<a href="/users?size=${pagination.size}&sort=phone:asc">
					Phone
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.address}">
				<a href="/users?size=${pagination.size}&sort=address:asc">
					Address
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.city}">
				<a href="/users?size=${pagination.size}&sort=city:asc">
					City
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.state}" data-width="120">
				<a href="/users?size=${pagination.size}&sort=state:asc">
					State
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.zipCode}" data-width="120">
				<a href="/users?size=${pagination.size}&sort=zipCode:asc">
					Zip Code
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.country}">
				<a href="/users?size=${pagination.size}&sort=country:asc">
					Country
					<span class="dir"></span>
				</a>
			</th>
			<th data-width="209">Actions</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${users}" var="user">
			<tr data-editable-entity="user" data-editable-url="/api/users/${user.id}">
				<td data-editable-field="userName" data-label="User Name">${user.userName}</td>
				<td data-editable-field="firstName" data-label="First Name">${user.firstName}</td>
				<td data-editable-field="lastName" data-label="Last Name">${user.lastName}</td>
				<td data-editable-field="emailAddress" data-label="Email Address">${user.emailAddress}</td>
				<td data-editable-field="phone" data-label="Phone">${user.phone}</td>
				<td data-editable-field="address" data-label="Address">${user.address}</td>
				<td data-editable-field="city" data-label="City">${user.city}</td>
				<td data-editable-field="state" data-label="State">${user.state}</td>
				<td data-editable-field="zipCode" data-label="Zip Code">${user.zipCode}</td>
				<td data-editable-field="country" data-label="Country">${user.country}</td>
				<td>
					<div class="btn-group">
						<a href="/users/${user.id}" class="btn btn-sm btn-primary">
							<span class="glyphicon glyphicon-eye-open"></span>
							View
						</a>
						<a href="/users/${user.id}/edit" class="btn btn-sm btn-success">
							<span class="glyphicon glyphicon-edit"></span>
							Edit
						</a>
						<button class="btn btn-sm btn-danger" data-confirm="" data-toggle="modal" data-target=".delete-confirmation" data-action="/users/${user.id}">
							<span class="glyphicon glyphicon-trash"></span>
							Delete
						</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>
