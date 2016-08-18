<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>Posts</h1>

<div class="tools">
	<a href="/posts/new" class="btn btn-default">
		<span class="glyphicon glyphicon-plus"></span>
		Add Post
	</a>
</div>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>Name</th>
			<th>Published At</th>
			<th>Link</th>
			<th data-width="209">Actions</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${posts}" var="post">
			<tr>
				<td>${post.title}</td>
				<td>${post.publishedAt}</td>
				<td>${post.alias}</td>
				<td>
					<div class="btn-group">
						<a href="/posts/${post.id}" class="btn btn-sm btn-primary">
							<span class="glyphicon glyphicon-eye-open"></span>
							View
						</a>
						<a href="/posts/${post.id}/edit" class="btn btn-sm btn-success">
							<span class="glyphicon glyphicon-edit"></span>
							Edit
						</a>
						<button class="btn btn-sm btn-danger" data-confirm="" data-toggle="modal" data-target=".delete-confirmation" data-action="/posts/${post.id}">
							<span class="glyphicon glyphicon-trash"></span>
							Delete
						</button>
					</div>
				</td>
			</tr>
		</c:forEach>
		
		<c:if test="${fn:length(posts) == 0}">
			<tr>
				<td colspan="2">No posts found.</td>
			</tr>
		</c:if>
	
	</tbody>
</table>
