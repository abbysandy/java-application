<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="pagination-container" aria-label="Page navigation">

	<ul class="pagination">
		<li>
			<a href="${pagination.first}" aria-label="First" class="text">
				<span aria-hidden="true">&laquo; First</span>
			</a>
		</li>
		<li>
			<a href="${pagination.previous}" aria-label="Previous" class="text">
				<span aria-hidden="true">&lsaquo; Previous</span>
			</a>
		</li>
		
		<c:forEach  var="page" items="${pagination.pages}">
			<li <c:if test="${page.current}">class="active"</c:if>>
				<a href="${page.url}" class="number">${page.index}</a>
			</li>
		</c:forEach>
		
		<li>
			<a href="${pagination.next}" aria-label="Next" class="text">
				<span aria-hidden="true">Next &rsaquo;</span>
			</a>
		</li>
		<li>
			<a href="${pagination.last}" aria-label="Last" class="text">
				<span aria-hidden="true">Last &raquo;</span>
			</a>
		</li>
	</ul>
	
	<div class="controls">
	
		<span class="input-group page-number">
			<span title="Page Number" class="input-group-addon">
				<span class="glyphicon glyphicon-arrow-right"></span>
			</span>
			
			<input type="text" class="form-control small-input" />
		</span>
	
	</div>
	
	<div class="controls">
	
		<span class="input-group rows-per-page">
			<span title="Rows per page" class="input-group-addon">
				<span class="glyphicon glyphicon-th-list"></span>
			</span>
	
			<select class="form-control">
				<option value="10">10</option>
				<option value="25">25</option>
				<option value="50">50</option>
				<option value="100">100</option>
			</select>
		</span>
	
	</div>
	
	<div class="info">
		Showing rows 1 - 10 of 1008
	</div>
	
</nav>
