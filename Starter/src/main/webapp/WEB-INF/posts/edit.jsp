<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="action" scope="page" value="Update"/>

<h1>Edit Post ${post.title}</h1>

<form:form modelAttribute="postForm" action="/posts/${post.id}" method="PUT" class="form-horizontal">
	<%@ include file="_form.jsp" %>
</form:form>
