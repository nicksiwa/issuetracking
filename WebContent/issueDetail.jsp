<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<form action="" class="form-horizontal">
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>View Issue Details</h3>
				</div>
				<div class="panel-body">
					Panel Content <br>


					<table class="table table-hover table-responsive table-striped">
						<thead>
							<tr>
								<th>Issue ID</th>
								<th>Project</th>
								<th>Title</th>
								<th>Due Date</th>
								<th>Update Date</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>a</td>
								<td>s</td>
								<td>s</td>
								<td>s</td>
								<td>s</td>
							</tr>
						</tbody>
					</table>
					<hr>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Title :</label>
					
					</div>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Title :</label>
					
					</div>

					<div class="form-group">
					
					</div>



				</div>
			</div>








		</div>
	</form>

	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>