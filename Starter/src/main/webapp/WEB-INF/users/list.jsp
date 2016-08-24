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
			<c:forEach items="${columns}" var="column">
				<c:set var="classes">
					<c:if test="${column.sortable}">sortable ${column.direction}</c:if>
					<c:if test="${column.hideable and not column.visible}">hidden</c:if>
				</c:set>
					
				<th class="${classes}" <c:if test="${column.hideable}">data-column="${column.name}"</c:if>>
					<c:if test="${column.sortable}"><a href="/users?${column.url}"></c:if>
						${column.label}
						<c:if test="${column.sortable}"><span class="dir"></span></c:if>
					<c:if test="${column.sortable}"></a></c:if>
				</th>
			</c:forEach>
			<th data-width="209">Actions</th>
		</tr>

	</thead>

	<tbody>
		<c:forEach items="${users}" var="user">
			<tr data-editable-entity="user" data-editable-url="/api/users/${user.id}">
				
				<c:forEach items="${columns}" var="column">
					<td class="<c:if test="${column.hideable and not column.visible}">hidden</c:if>"
						<c:if test="${column.editable}">
							data-editable-field="${column.name}"
						</c:if>
						data-label="${column.label}"
						data-column="${column.name}">${user[column.name]}</td>
				</c:forEach>
				
				<td data-label="Actions">
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

				<form:form action="/api/users/user-table-columns" method="PUT" class="js-table-columns">
				
					<c:forEach items="${columns}" var="column">
						<div class="checkbox">
							<label>
								<input type="checkbox" name="${column.name}" <c:if test="${column.visible}">checked="checked"</c:if> />
								${column.label}
							</label>
						</div>
					</c:forEach>

				</form:form>
			</div>

		</div>
	</div>
</div>
