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

		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="IndexController?action=index"><span class="glyphicon glyphicon-home"></span> Home</a></li>
					<li><a href="PersonController?action=listPerson"><span class="glyphicon glyphicon-user"></span> Person</a></li>
					<li><a href="ProjectController?action=listProject"><span class="glyphicon glyphicon-tasks"></span> Project</a></li>
					<li><a href="CommentController?action=listComment"><span class="glyphicon glyphicon-comment"></span> Comment</a></li>
					<li><a href="TestController?action=listTest">Test</a></li>
					<li><a href="AssignController?action=listAssign">Assign</a></li>
					<li><a href="IssueController?action=listIssue"><span class="glyphicon glyphicon-exclamation-sign"></span> Issue</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<%
						String username = (String) session.getAttribute("username");
						if (username == null) {
					%>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a href="LoginController"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
					<%
						} else {
					%>
					<li><a>Hi, <%=username%></a></li>
					<li>
					<a href="LoginController?action=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
					</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>


	<div class="container">
		<br>
		<p>
			<a href="ProjectController.do?action=insert">Add Project</a>
		</p>
		<table class="table table-hover table-responsive table-striped">
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
						<fmt:setLocale value="en_US" />
						<td><fmt:formatDate pattern="dd/MM/yyy"
								value="${project.startDate}" /></td>
						<td><fmt:formatDate pattern="dd/MM/yyy"
								value="${project.finishDate}" /></td>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>