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
					<li class="active"><a href="#">Home</a></li>
					<li><a href="index1.jsp">Person</a></li>
					<li><a href="index2.jsp">Project</a></li>
					<li><a href="index3.jsp">Comment</a></li>
					<li><a href="index4.jsp">Test</a></li>
					<li><a href="index5.jsp">Assign</a></li>
					<li><a href="index6.jsp">Issue</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<div class="container">
		<br>
		<p>
			<a href="AssignController.do?action=insert">Add Assign</a>
		</p>
		<table class="table table-hover table-responsive table-striped">
			<thead>
				<tr>
					<th>Assign ID</th>
					<th>Person ID</th>
					<th>Project ID</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${assigns}" var="assign">
					<tr>
						<td><c:out value="${assign.assignID}"></c:out></td>
						<td><c:out value="${assign.personID}"></c:out></td>
						<td><c:out value="${assign.projectID}"></c:out></td>
						<td><a
							href="AssignController.do?action=edit&assignID=<c:out value="${assign.assignID }"/>">Update</a></td>
						<td><a
							href="AssignController.do?action=delete&assignID=<c:out value="${assign.assignID }"/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>