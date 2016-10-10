<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
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
	<form action="" class="form-horizontal">
		<div class="col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3><span class="glyphicon glyphicon-list-alt"></span> Assigned to Me<span class="pull-right"><h4><span class="badge">${fn:length(indexs)}</span> Issues</h4></span></h3>
						
					</div>
					<div class="panel-body">
					 <div class="list-group">
					 
					   
						<c:forEach items="${indexs}" var="index">
						  <a href="#" class="list-group-item">
							<p class="list-group-item-heading"><h4><c:out value="${index.title}"></c:out></h4><span class="pull-right"><c:out value="${index.updateDate}"></c:out></span></p>
							<p class="list-group-item-text">From Project : <c:out value="${index.project}"></c:out></p>
							
						</a>
						</c:forEach>
				
						</div>
						<button type="button" class="btn btn-default">Default</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3><span class="glyphicon glyphicon-edit"></span> Report by Me<span class="pull-right"><h4><span class="badge">${fn:length(reports)}</span> Issues</h4></span></h3>
						
					</div>
					<div class="panel-body">
					 <div class="list-group">
					 
					   
						<c:forEach items="${reports}" var="index">
						  <a href="#" class="list-group-item">
							<p class="list-group-item-heading"><h4><c:out value="${index.title}"></c:out></h4><span class="pull-right"><c:out value="${index.updateDate}"></c:out></span></p>
							<p class="list-group-item-text">From Project : <c:out value="${index.project}"></c:out></p>
							
						</a>
						</c:forEach>
				
						</div>
						<button type="button" class="btn btn-default">Default</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3><span class="glyphicon glyphicon-check"></span> Resolved<span class="pull-right"><h4><span class="badge">${fn:length(resolves)}</span> Issues</h4></span></h3>
						
					</div>
					<div class="panel-body">
					 <div class="list-group">
					 
					   
						<c:forEach items="${resolves}" var="index">
						  <a href="#" class="list-group-item">
							<p class="list-group-item-heading"><h4><c:out value="${index.title}"></c:out></h4><span class="pull-right"><c:out value="${index.updateDate}"></c:out></span></p>
							<p class="list-group-item-text">From Project : <c:out value="${index.project}"></c:out></p>
						</a>
						</c:forEach>
				
						</div>
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
	</form>
	</div>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>