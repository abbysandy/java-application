<%@ include file="../layout/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Edit User</h1>

<form:form modelAttribute="userForm" action="/users" method="POST" class="form-horizontal">
	<%@ include file="_form.jsp" %>
</form:form>

<%@ include file="../layout/footer.jsp" %>