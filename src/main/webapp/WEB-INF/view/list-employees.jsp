<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Employees</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employees Management</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			
		
			<input type="submit" value="Add Employee"
				   onclick="window.location.href='showFormForAdd'; return false;"
				  
			/>
			
			<input type="submit" value="Add Department"
				   onclick="window.location.href='department/showFormForAddDep'; return false;"
				 
			/>
			
			<input type="submit" value="See All Departments"
				   onclick="window.location.href='department/list'; return false;"
				  
			/>
			
			<p>
		
			<table>
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Last Name</th>
					<th>Position</th>
					<th>Salary</th>
					<th>Id</th>
					<th></th>
				</tr>
				
				
				<c:forEach var="tempEmployee" varStatus="loop" items="${employees}">
				
				
					<c:url var="updateLink" value="/employee/showFormForUpdate">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>					

					
					<c:url var="deleteLink" value="/employee/delete">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>
					
					<c:url var="departmentLink" value="department/listById" >
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>
										
					
			
					
					<tr>
						
						<td> ${loop.count} </td>
						<td> ${tempEmployee.name} </td>
						<td> ${tempEmployee.lastName} </td>
						<td> ${tempEmployee.position} </td>
						<td> ${tempEmployee.salary} </td>
						<td> ${tempEmployee.id} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">Delete</a>
							|
							<a href="${departmentLink}">Departments</a>
						
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









