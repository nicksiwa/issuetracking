<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Project</title>
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
	<p>
		<a href="ProjectController.do?action=insert">Add Project</a>
	</p>


	<table class="table">
		<thead>
			<tr>
				<th>Project ID</th>
				<th>Project Name</th>
				<th>Status</th>
				<th>Description</th>
				<th>Start Date</th>
				<th>Finish Date</th>

				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${projects}" var="project">
				<tr>
					<td><c:out value="${project.projectID}"></c:out></td>
					<td><c:out value="${project.projectName}"></c:out></td>
					<td><c:out value="${project.status}"></c:out></td>
					<td><c:out value="${project.description}"></c:out></td>
					<td><fmt:formatDate pattern="dd-MM-yyy" value="${project.startDate}" /></td>
					<td><fmt:formatDate pattern="dd-MM-yyy" value="${project.finishDate}" /></td>

					
					<td><a
						href="ProjectController.do?action=edit&projectID=<c:out value="${project.projectID }"/>">Update</a></td>
					<td><a
						href="ProjectController.do?action=delete&projectID=<c:out value="${project.projectID }"/>">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script src="js/bootstrap.min.js"></script>
</body>
</html>