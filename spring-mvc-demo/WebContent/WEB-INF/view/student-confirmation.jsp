<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Student confirmation</title>
	</head>
	
	<body>
	
		<p>The student is confirmed: ${student.firstName} ${student.lastName} from ${student.country}.</p>
		<p>His favourite language is ${student.favouriteLang}</p>
		<p> The OSs he worked with:  </p>
		<ul>
			<c:forEach items="${student.favouriteOS}" var="item">
					<li>${item}</li>
			</c:forEach>
		</ul>	
		
	</body>
	
</html>