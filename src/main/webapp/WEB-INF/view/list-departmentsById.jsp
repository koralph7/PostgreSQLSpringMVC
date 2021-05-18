<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Employee Departments</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Departments List</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			
		
			<input type="submit" value="Add Department"
				   onclick="window.location.href='showFormForAddDep'; return false;"
				  
			/>
			
			
			<input type="submit" value="Employee List" 
    onclick="window.location='${pageContext.request.contextPath}/employee/list';" /> 
		
		<p>
		<p>
			<table>
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>EmployeeId</th>
					<th></th>
				</tr>
				
				
				<c:forEach var="tempDepartment" varStatus="loop" items="${departments}">
				
				
					<c:url var="updateLink" value="showFormForUpdateDep">
						<c:param name="departmentId" value="${tempDepartment.id}" />
					</c:url>					

					
					<c:url var="deleteLink" value="delete">
						<c:param name="departmentId" value="${tempDepartment.id}" />
					</c:url>					
					
					<tr>
						<td> ${loop.count} </td>
						<td> ${tempDepartment.name} </td>
						<td> ${tempDepartment.employee.id} </td>
						
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this Department?'))) return false">Delete</a>
						
						
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









