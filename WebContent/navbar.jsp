<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>

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
				<li class="active"><a href="IndexController?action=index"><span
						class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
				<li><a href="PersonController?action=listPerson"><span
						class="glyphicon glyphicon-user"></span> Person</a></li>
				<li><a href="ProjectController?action=listProject"><span
						class="glyphicon glyphicon-tasks"></span> Project</a></li>
				<li><a href="CommentController?action=listComment"><span
						class="glyphicon glyphicon-comment"></span> Comment</a></li>
				
				<li><a href="AssignController?action=listAssign"><span
						class="glyphicon glyphicon-info-sign"></span> Assign</a></li>
				<li><a href="IssueController?action=listIssue"><span
						class="glyphicon glyphicon-exclamation-sign"></span> Issue</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
					String username = (String) session.getAttribute("username");
					if (username == null) {
				%>
				<li><a href="LoginController?action=signup"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="LoginController"><span
						class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
				<%
					} else {
				%>
				<li><a>Hi, <%=username%></a></li>
				<li><a href="LoginController?action=logout"><span
						class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</nav>
</body>
</html>