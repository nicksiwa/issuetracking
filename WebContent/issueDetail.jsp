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
	<form action="" class="form-horizontal">
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3><span class="glyphicon glyphicon-search"></span> View Issue Details</h3>
				</div>
				<div class="panel-body">
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
								<td><c:out value="${issue.issueID}" /></td>
								<td><c:out value="${issue.project}" /></td>
								<td><c:out value="${issue.title}" /></td>
								<fmt:setLocale value="en_US" />
								<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${issue.dueDate}" /></td>
								<td><c:out value="${issue.updateDate}" /></td>
							</tr>
						</tbody>
					</table>
					<hr>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Reporter
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static"><c:out value="${issue.reporter}"></c:out></p>
						</div>

						<label for="tile" class="control-label col-sm-3">Assigned
							To :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static"><c:out value="${issue.assign}" /></p>
						</div>
					</div>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Severity
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static"><c:out value="${issue.severity}"></c:out></p>
						</div>

						<label for="tile" class="control-label col-sm-3">Priority
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static"><c:out value="${issue.priority}"></c:out></p>
						</div>
					</div>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Status :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static"><c:out value="${issue.status}"></c:out></p>
						</div>
					</div>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Description
							:</label>
						<div class="col-sm-8 col-lg-6 col-md-6">
							<textarea name="description" class="form-control" rows="5"
								id="comment" placeholder="Description"><c:out value="${issue.description}"></c:out></textarea>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2"><a>Change
								Status To :</a></label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="severity" class="form-control">
								<option value="Minor">Minor</option>
								<option value="Major">Major</option>
								<option value="Crash">Crash</option>
							</select>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2"><a>Assign
								To :</a></label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="severity" class="form-control">
								<option value="Minor">Minor</option>
								<option value="Major">Major</option>
								<option value="Crash">Crash</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<c:forEach items="${comments}" var="comment">
			<div class="panel panel-default">
				<div class="panel-heading">
					<b><c:out value="${comment.userComment}"></c:out><span>&nbsp&nbsp&nbsp</span><c:out value="${comment.commentTime}"></c:out></b>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Assign to :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static">niksf203</p>
						</div>
						<label for="tile" class="control-label col-sm-2">Status :</label>
						<div class="col-sm-3 col-lg-3 col-md-3">
							<p class="form-control-static">Response "I can't find bug"</p>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
				
		</div>
	</form>

	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>