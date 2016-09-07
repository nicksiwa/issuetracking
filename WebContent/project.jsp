<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Project</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body class="sansserif">
<script>
		$(function() {
			$('input[type=date]').datepicker();

		});
	</script>
	
	<form action="ProjectController.do" method="post">
	
	<div>
				<label for="projectID">Project ID</label><br> <input type="text"
					name="projectID" value="<c:out value="${project.projectID}" />"
					readonly="readonly" placeholder="Auto generate ID" />
		<br><br>
				<label for="projectName">Project Name</label><br> <input type="text"
					name="projectName" value="<c:out value="${project.projectName}" />"
					placeholder="Project Name" />
		<br><br>
				<label for="status">Project Status</label><br> <input type="text"
					name="status" value="<c:out value="${project.status}" />"
					placeholder="Project Status" />
	<br><br>
	<label for="description">Description</label><br> <input type="text"
					name="description" value="<c:out value="${project.description}" />"
					placeholder="Description" />
	<br><br>
				<label for="startDate">Start Date</label><br> <input type="date"
					name="startDate" value="<fmt:formatDate pattern="dd-MM-yyy" value="${project.startDate}" />" />
	
		<br><br>
						<label for="finishDate">Finish Date</label><br> <input type="date"
					name="finishDate" value="<fmt:formatDate pattern="dd-MM-yyy" value="${project.finishDate}" />" />
	
		<br><br>
		
				<input type="submit" value="Submit" />
			</div>
	</form>

</body>
</html>