<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertAttribute name="navigation" />

<div class="container-fluid page-wrap">

	<tiles:insertAttribute name="body" />
	
	<tilesx:useAttribute id="items" name="components" classname="java.util.List" />
	<c:forEach var="component" items="${items}">
		<tiles:insertAttribute value="${component}" flush="true" />
	</c:forEach>

</div>
