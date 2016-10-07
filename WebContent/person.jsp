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
					<li class="active"><a href="IndexController?action=index">Home</a></li>
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
		<form action="PersonController.do" method="post" class="form-horizontal">

			<input type="hidden" name="personId"
				value="<c:out value="${person.personId}" />" readonly="readonly"
				placeholder="Auto generate ID" /> <br> <br>

			<div class="form-group">
				<label for="firstName" class="control-label col-sm-2">First Name :</label>
				<div class="col-sm-3 col-lg-3 col-md-3"><input
					type="text" name="firstName" class="form-control"
					value="<c:out value="${person.firstName}" />"
					placeholder="First Name" />
					</div>
			
				<label for="lastName" class="control-label col-sm-2">Last Name :</label>
				<div class="col-sm-3 col-lg-3 col-md-3"><input type="text"
					name="lastName" class="form-control"
					value="<c:out value="${person.lastName}" />"
					placeholder="Last Name" />
					</div>
			</div>
		<br><fmt:setLocale value="en_US" />
			<div class="form-group">
				<label for="birthDate" class="control-label col-sm-2">Birth Date :</label>
				<div class="col-sm-3 col-lg-3 col-md-3"><input
					type="date" name="birthDate" class="form-control"
					value="<fmt:formatDate pattern="yyyy-MM-dd" value="${person.birthDate}" />" />
					</div>
			</div>
			<br>
			<div class="form-group">
				<label for="gender" class="control-label col-sm-2">Gender :</label><div class="col-sm-3 col-lg-3 col-md-3">Male <input
					type="radio" name="gender" value="Male" checked /> Female <input
					type="radio" name="gender" value="Female" />
					</div>
			</div>
			<br>
			<div class="form-group">
				<label for="address" class="control-label col-sm-2">Address :</label>
				<div class="col-sm-8 col-lg-6 col-md-6"><textarea name="address" class="form-control" rows="5" id="comment" placeholder="Address"><c:out value="${person.address}" /></textarea>
					</div>
			</div>
			
			<div class="form-group">
				<label for="tel" class="control-label col-sm-2">Telephone Number :</label>
				<div class="col-sm-3 col-lg-3 col-md-3"><input type="text" name="tel" class="form-control"
					value="<c:out value="${person.tel}" />"
					placeholder="Telephone Number" />
					</div>
			</div>
		
			<div class="form-group">
				<label for="position" class="control-label col-sm-2">Position :</label>
				<div class="col-sm-3 col-lg-3 col-md-3"><input type="text"
					name="position" class="form-control"
					value="<c:out value="${person.position}" />" placeholder="Position" />
					</div>
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