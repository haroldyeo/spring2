<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"></link>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"></link>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Save customer</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
		
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="theCustomer" method="POST">
		
			<form:hidden path="id"/>
			<table>
				<tr>
					<td><label>First name</label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				
				<tr>
					<td><label>Last name</label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" /></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="Save"></td>
				</tr>
				
			</table>
		</form:form>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
			
	</div>
	
	

</body>
</html>