<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"></link>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List customers</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
		
	<div id="container">
		<div id="content">
		
		<div>
			<input type="button" value="Add customer" onclick="window.location.href='showFormForAdd';return false" class="addButton">
		</div>
			
		
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach items="${customers}" var="cust">
				
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${cust.id}"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${cust.id}"></c:param>
					</c:url>
				
					<tr>
						<td>${cust.firstName}</td>
						<td>${cust.lastName}</td>
						<td>${cust.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if(!confirm('Are you sure?')) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>	
	</div>
	
	

</body>
</html>