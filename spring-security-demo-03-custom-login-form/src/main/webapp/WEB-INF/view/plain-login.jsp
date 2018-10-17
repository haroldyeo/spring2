<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>Custom login page</title>
</head>
<body>
	<h3>My custom login page</h3>
	
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">  
	
		<!-- Check for error -->
		
		<c:if test="${param.error != null}">
			<i style="color: red; font-weight: bold">Sorry, invalid username / password</i>
		</c:if>
	
		<p>
			Username: <input type="text" name="username">
		</p>
		
		<p>
			Password: <input type="password" name="password">
		</p>
		<p>
			<input type="submit" value="Login">
		</p>
	
	</form:form>
	
</body>
</html>