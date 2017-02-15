<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/paper/bootstrap.min.css" rel="stylesheet" integrity="sha384-awusxf8AUojygHf2+joICySzB780jVvQaVCAt1clU3QsyAitLGul28Qxb2r1e5g+" crossorigin="anonymous">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>

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
			<a class="navbar-brand" href="#">IssueTracking</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">

	
	<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span
						class="glyphicon glyphicon-dashboard"></span> Dashboard
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="IndexController?action=index"><span
						class="glyphicon glyphicon-info-sign"></span> Opened issue	</a></li>
          <li><a href="issueClosed.jsp"><span
						class="glyphicon glyphicon-ok-sign"></span> Closed issue</a></li>
        </ul>
      </li>
						<li><a href="ProjectController?action=listProject"><span
						class="glyphicon glyphicon-tasks"></span> Project</a></li>
				
			</ul>
			
							<li><a href="IssueController.do?action=report"><span
						class="glyphicon glyphicon-tasks"></span> Report</a></li>
				
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
					String username = (String) session.getAttribute("username");
					if (username == null) {
				%>
				<li><a href="RegisterController"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="LoginController"><span
						class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
				<%
					} else {
				%>
				<li><a href="profile.jsp">Hi, <%=username%></a></li>
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