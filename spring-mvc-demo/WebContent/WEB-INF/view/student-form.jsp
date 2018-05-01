<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Student registration</title>
	</head>
	
	<body>
	
		<form:form action="showStudentProcessForm" modelAttribute="student">
		
			First name: <form:input path="firstName" />
			
			<br /><br />			
			
			Last name: <form:input path="lastName" />
			
			<br /><br />	
			
			Country: <form:select path="country">
						<form:options items="${theCountryOptions}" />
					</form:select>
					
			<br /><br />	
			
			Favourite language: 
			<form:radiobutton path="favouriteLang" value="Java" label="Java" />
			<form:radiobutton path="favouriteLang" value="C#" label="C#" />
			<form:radiobutton path="favouriteLang" value="Python" label="Python" />
			<form:radiobutton path="favouriteLang" value="Ruby" label="Ruby" />
			
			<br /><br />	
			
			Operating systems: <br>
			Linux:  <form:checkbox path="favouriteOS" value="Linux"  />
			Windows:  <form:checkbox path="favouriteOS" value="Windows" />
			MacOS:  <form:checkbox path="favouriteOS" value="MacOS"  />
			
			<br /><br />	
			
			<input  type="submit" value="Submit" />
		</form:form>
		
	</body>
	
</html>