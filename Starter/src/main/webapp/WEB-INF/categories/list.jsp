<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>Categories</h1>

<div class="tools">
	<a href="/categories/new" class="btn btn-default">
		<span class="glyphicon glyphicon-plus"></span>
		Add Category
	</a>
</div>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>Name</th>
			<th data-width="209">Actions</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${categories}" var="category">
			<tr>
				<td>${category.name}</td>
				<td>
					<div class="btn-group">
						<a href="/categories/${category.id}" class="btn btn-sm btn-primary">
							<span class="glyphicon glyphicon-eye-open"></span>
							View
						</a>
						<a href="/categories/${category.id}/edit" class="btn btn-sm btn-success">
							<span class="glyphicon glyphicon-edit"></span>
							Edit
						</a>
						<button class="btn btn-sm btn-danger" data-confirm="" data-toggle="modal" data-target=".delete-confirmation" data-action="/categories/${category.id}">
							<span class="glyphicon glyphicon-trash"></span>
							Delete
						</button>
					</div>
				</td>
			</tr>
		</c:forEach>
		
		<c:if test="${fn:length(categories) == 0}">
			<tr>
				<td colspan="2">No categories found.</td>
			</tr>
		</c:if>
	
	</tbody>
</table>
