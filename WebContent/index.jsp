<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Person</title>
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
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="PersonController?action=listPerson">Person</a></li>
					<li><a href="ProjectController?action=listProject">Project</a></li>
					<li><a href="CommentController?action=listComment">Comment</a></li>
					<li><a href="TestController?action=listTest">Test</a></li>
					<li><a href="AssignController?action=listAssign">Assign</a></li>
					<li><a href="IssueController?action=listIssue">Issue</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<%
						String username = (String) session.getAttribute("username");
						if (username == null) {
					%>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a href="LoginController"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<%
						} else {
					%>
					<li><a>Hi, <%=username%></a></li>
					<li><a href="LoginController?action=logout"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">

		<div class="col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Assigned to Me</h3>
					</div>
					<div class="panel-body">

						<div class="form-group">
							<label for="assign">First Name</label><br> <input
								type="text" name="assign" class="form-control"
								value="<c:out value="${test.testName}" />"
								placeholder="First Name" />
						</div>
						<br>
						<div class="form-group">
							<label for="project">Project Name</label><br> <input
								type="text" name="project" class="form-control"
								value="<c:out value="${test.testProject}" />"
								placeholder="First Name" />
						</div>
						<br>
						<div class="form-group">
							<label for="issusID">issusID</label><br> <input
								type="text" name="issusID" class="form-control"
								value="<c:out value="${test.testID}" />"
								placeholder="First Name" />
						</div>
						<br>
						<button type="button" class="btn btn-default">Default</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Report by Me</h3>
					</div>
					<div class="panel-body">
						Panel Content <br>
						<button type="button" class="btn btn-default">Default</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Resolved</h3>
					</div>
					<div class="panel-body">
						Panel Content <br>
						<button type="button" class="btn btn-default">Default</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Recently Modified</h3>
					</div>
					<div class="panel-body">
						Panel Content <br>
						<button type="button" class="btn btn-default">Default</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>