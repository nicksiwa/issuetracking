<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Project</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
	<ul class="nav nav-tabs" role="tablist">
<li class="active"><a href="#">Home</a></li>
<li><a href="index1.jsp">Person</a></li>
<li><a href="index2.jsp">Project</a></li>
<li><a href="index3.jsp">Comment</a></li>
<li><a href="index4.jsp">Test</a></li>
</ul>
	<form action="ProjectController.do" method="post" class="form-inline">
	
	
	
			<input type="hidden"
					name="projectID" value="<c:out value="${project.projectID}" />"
					readonly="readonly" placeholder="Auto generate ID" />
		<br><br>
		<div class="form-group">
				<label for="projectName">Project Name</label><br> <input type="text"
					name="projectName" class="form-control" value="<c:out value="${project.projectName}" />"
					placeholder="Project Name" />
					</div>
		<br><br>
		
		<div class="form-group">
				<label for="status">Project Status</label><br> <input type="text"
					name="status" class="form-control" value="<c:out value="${project.status}" />"
					placeholder="Project Status" />
					</div>
	<br><br>
	<div class="form-group">
				<label for="description">Description</label><br> <input type="text"
					name="description" class="form-control" value="<c:out value="${project.description}" />"
					placeholder="Description" />
					</div>
	<br><br>
	<div class="form-group">
				<label for="startDate">Start Date</label><br> <input type="date"
					name="startDate" class="form-control" value="<fmt:formatDate pattern="dd-MM-yyy" value="${project.startDate}" />" />
					</div>
					<br><br>
					<div class="form-group">
				<label for="finishDate">Finish Date</label><br> <input type="date"
					name="finishDate" class="form-control" value="<fmt:formatDate pattern="dd-MM-yyy" value="${project.finishDate}" />" />
	</div>
	
		<br><br>
		
				<input type="submit" class="btn btn-default" value="Submit" />
			
	</form>
</div>
<script src="js/bootstrap.min.js"></script>

</body>
</html>