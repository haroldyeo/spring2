<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>Access denied!!!</title>
</head>
<body>
	<h2>Access denied - You are not authorized to access this page!</h2>
	<hr/>
	<a href="${pageContext.request.contextPath}">Back to home page</a>
		
</body>
</html>