<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:set var="navId"><tiles:getAsString name="navId" /></c:set>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">Starter Project</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li <c:if test="${navId eq 'main'}">class="active"</c:if>>
					<a href="/">Home</a>
				</li>
				<li <c:if test="${navId eq 'users'}">class="active"</c:if>>
					<a href="/users">Users</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
