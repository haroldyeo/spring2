<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome to Harold's company! Olייייייייי!!!</title>
</head>
<body>
	<h2>Home Page</h2>
	<hr/>
	<p>
		Welcome to Harold's company home page!
	</p>
	
	<!-- Display username and role -->
	<p>
		User: <sec:authentication property="principal.username" />
		<br/><br/>
		Role(s) : <sec:authentication property="principal.authorities"/>
	</p>
	
	<sec:authorize access="hasRole('MANAGERS')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		</p>
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT systems meeting</a>
		</p>
	</sec:authorize>
	
	<hr />
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
		
</body>
</html>