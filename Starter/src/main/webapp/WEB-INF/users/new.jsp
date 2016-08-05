<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="action" scope="page" value="Create"/>

<h1>Add User</h1>

<form:form modelAttribute="userForm" action="/users" method="POST" class="form-horizontal">
	<%@ include file="_form.jsp" %>
</form:form>
