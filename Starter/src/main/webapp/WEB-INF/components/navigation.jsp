<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="navId"><tiles:getAsString name="navId" /></c:set>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
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
				
				<li class="dropdown <c:if test="${navId eq 'posts'}">active</c:if>">
				
					<a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="#">
						Posts
						<span class="caret"></span>
					</a>
					
					<ul class="dropdown-menu">
						<li><a href="/posts">Posts</a></li>
						<li><a href="/categories">Categories</a></li>
						<li><a href="/tags">Tags</a></li>
					</ul>
					
				</li>
				
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
			
				<li class="dropdown">
				
					<a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="#">
						My Account
						<span class="caret"></span>
					</a>
					
					<ul class="dropdown-menu">
						<li class="dropdown-header">Brett Meyer</li>
						<li><a href="/users/profile">My Profile</a></li>
						<li><a href="/users/change-password">Change Password</a></li>
						<li class="divider" role="separator"></li>
						<li class="dropdown-header">Authentication</li>
						<li>
							<form:form id="" action="/logout">
								<button class="btn btn-link">Logout</button>
							</form:form>
						</li>
						
					</ul>
					
				</li>
				
			</ul>
			
		</div>
	</div>
</nav>
