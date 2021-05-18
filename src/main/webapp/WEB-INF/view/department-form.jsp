<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Department</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-employee-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Employee Management</h2>
		</div>
	</div>

	<div id="container">

			
	

	
		<h3>Add Department</h3>
	
	<c:if test="${not empty error}">
   			Error: ${error}
	</c:if>
	
		<form:form action="saveDepartment" modelAttribute="department" method="POST">

			
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>EmployeeId:</label></td>
						<td><form:input path="employee.id" /></td>
					</tr>

				

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

	
				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/employee/list">Back to Main</a>
		</p>
	
	
	</div>

</body>

</html>










