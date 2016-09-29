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

<body>
	<script>
		$(function() {
			$('input[name=birthDate]').datepicker();

		});
	</script>
	<div class="container">
		<form action="PersonController.do" method="post" class="form-inline">

			<input type="hidden" name="personId"
				value="<c:out value="${person.personId}" />" readonly="readonly"
				placeholder="Auto generate ID" /> <br> <br>

			<div class="form-group">
				<label for="firstName">First Name</label><br> <input
					type="text" name="firstName" class="form-control"
					value="<c:out value="${person.firstName}" />"
					placeholder="First Name" />
			</div>
			<br> <br>
			<div class="form-group">
				<label for="lastName">Last Name</label><br> <input type="text"
					name="lastName" class="form-control"
					value="<c:out value="${person.lastName}" />"
					placeholder="Last Name" />
			</div>
			<br> <br>
			<div class="form-group">
				<label for="birthDate">Birth Date</label><br> <input
					type="date" name="birthDate" class="form-control"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${person.birthDate}" />" />
			</div>
			<br> <br>
			<div class="form-group,radio">
				<label for="gender">Gender</label> <br> Male <input
					type="radio" name="gender" value="Male" checked /> Female <input
					type="radio" name="gender" value="Female" />
			</div>
			<br>
			<div class="form-group">
				<label for="address">Address</label><br> <input type="text"
					name="address" class="form-control"
					value="<c:out value="${person.address}" />" placeholder="Address" />
			</div>
			<br> <br>
			<div class="form-group">
				<label for="tel">Telephone Number</label><br> <input
					type="text" name="tel" class="form-control"
					value="<c:out value="${person.tel}" />"
					placeholder="Telephone Number" />
			</div>
			<br> <br>
			<div class="form-group">
				<label for="position">Position</label><br> <input type="text"
					name="position" class="form-control"
					value="<c:out value="${person.position}" />" placeholder="Position" />
			</div>
			<br> <br> <input type="submit" class="btn btn-default"
				value="Submit" />
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