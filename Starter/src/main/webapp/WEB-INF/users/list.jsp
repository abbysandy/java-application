<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Users</h1>

<div class="tools">
	<a href="/users/new" class="btn btn-default">
		<span class="glyphicon glyphicon-plus"></span>
		Add User
	</a>

	<div class="btn-group pull-right" role="group" aria-label="...">
		<a href="" type="button" class="btn btn-default" title="Refresh">
			<span class="glyphicon glyphicon-refresh"></span>
		</a>
		<button type="button" class="btn btn-default" title="Settings" data-toggle="modal" data-target=".users-table-columns">
			<span class="glyphicon glyphicon-cog"></span>
		</button>
		<a href="/help" class="btn btn-default" title="Help">
			<span class="glyphicon glyphicon-question-sign"></span>
		</a>
	</div>

</div>

<table class="table table-bordered table-responsive" data-editable="users">
	<thead>
		<tr>
			<th class="sortable ${sortable.userName} <c:if test="${not columns.userName}">hidden</c:if>" data-column="userName">
				<a href="/users?size=${pagination.size}&sort=userName:asc">
					User Name
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.firstName} <c:if test="${not columns.firstName}">hidden</c:if>" data-column="firstName">
				<a href="/users?size=${pagination.size}&sort=firstName:asc">
					First Name
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.middleName} <c:if test="${not columns.middleName}">hidden</c:if>" data-column="middleName">
				<a href="/users?size=${pagination.size}&sort=middleName:asc">
					Middle Name
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.lastName} <c:if test="${not columns.lastName}">hidden</c:if>" data-column="lastName">
				<a href="/users?size=${pagination.size}&sort=lastName:asc">
					Last Name
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.emailAddress} <c:if test="${not columns.emailAddress}">hidden</c:if>" data-column="emailAddress">
				<a href="/users?size=${pagination.size}&sort=emailAddress:asc">
					Email Address
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.phone} <c:if test="${not columns.phone}">hidden</c:if>" data-column="phone">
				<a href="/users?size=${pagination.size}&sort=phone:asc">
					Phone
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.address} <c:if test="${not columns.address}">hidden</c:if>" data-column="address">
				<a href="/users?size=${pagination.size}&sort=address:asc">
					Address
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.city} <c:if test="${not columns.city}">hidden</c:if>" data-column="city">
				<a href="/users?size=${pagination.size}&sort=city:asc">
					City
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.state} <c:if test="${not columns.state}">hidden</c:if>" data-width="120" data-column="state">
				<a href="/users?size=${pagination.size}&sort=state:asc">
					State
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.zipCode} <c:if test="${not columns.zipCode}">hidden</c:if>" data-width="120" data-column="zipCode">
				<a href="/users?size=${pagination.size}&sort=zipCode:asc">
					Zip Code
					<span class="dir"></span>
				</a>
			</th>
			<th class="sortable ${sortable.country} <c:if test="${not columns.country}">hidden</c:if>" data-column="country">
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
				<td data-editable-field="userName" data-label="User Name" data-column="userName" class="<c:if test="${not columns.userName}">hidden</c:if>">${user.userName}</td>
				<td data-editable-field="firstName" data-label="First Name" data-column="firstName" class="<c:if test="${not columns.firstName}">hidden</c:if>">${user.firstName}</td>
				<td data-editable-field="middleName" data-label="Middle Name" data-column="middleName" class="<c:if test="${not columns.middleName}">hidden</c:if>">${user.middleName}</td>
				<td data-editable-field="lastName" data-label="Last Name" data-column="lastName" class="<c:if test="${not columns.lastName}">hidden</c:if>">${user.lastName}</td>
				<td data-editable-field="emailAddress" data-label="Email Address" data-column="emailAddress" class="<c:if test="${not columns.emailAddress}">hidden</c:if>">${user.emailAddress}</td>
				<td data-editable-field="phone" data-label="Phone" data-column="phone" class="<c:if test="${not columns.phone}">hidden</c:if>">${user.phone}</td>
				<td data-editable-field="address" data-label="Address" data-column="address" class="<c:if test="${not columns.address}">hidden</c:if>">${user.address}</td>
				<td data-editable-field="city" data-label="City" data-column="city" class="<c:if test="${not columns.city}">hidden</c:if>">${user.city}</td>
				<td data-editable-field="state" data-label="State" data-column="state" class="<c:if test="${not columns.state}">hidden</c:if>">${user.state}</td>
				<td data-editable-field="zipCode" data-label="Zip Code" data-column="zipCode" class="<c:if test="${not columns.zipCode}">hidden</c:if>">${user.zipCode}</td>
				<td data-editable-field="country" data-label="Country" data-column="country" class="<c:if test="${not columns.country}">hidden</c:if>">${user.country}</td>
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
						<button class="btn btn-sm btn-danger" data-toggle="modal" data-target=".delete-confirmation" data-action="/users/${user.id}">
							<span class="glyphicon glyphicon-trash"></span>
							Delete
						</button>
					</div>
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>


<div class="modal fade users-table-columns" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">

		<div class="modal-content">

			<div class="modal-header">
				<button aria-label="Close" data-dismiss="modal" class="close" type="button">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">Show columns</h4>
			</div>

			<div class="modal-body">
				<p>Select which columns you would like to show/hide:</p>

				<form:form modelAttribute="columns" action="/api/users/user-table-columns" method="PUT" class="js-table-columns">
				
					<div class="checkbox">
						<label>
							<form:checkbox path="userName" />
							User Name
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="firstName" />
							First Name
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="middleName" />
							Middle Name
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="lastName" />
							Last Name
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="emailAddress" />
							Email Address
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="phone" />
							Phone
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="address" />
							Address
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="city" />
							City
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="state" />
							State
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="zipCode" />
							Zip Code
						</label>
					</div>
					<div class="checkbox">
						<label>
							<form:checkbox path="country" />
							Country
						</label>
					</div>

				</form:form>
			</div>

		</div>
	</div>
</div>
