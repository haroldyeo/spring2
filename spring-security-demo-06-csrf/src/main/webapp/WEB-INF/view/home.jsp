<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
		
</body>
</html>