<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${issue.title}" /> : <c:out
		value="${issue.project}" /></title>
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
					<li class="active"><a href="IndexController?action=index"><span
							class="glyphicon glyphicon-home"></span> Home</a></li>
					<li><a href="PersonController?action=listPerson"><span
							class="glyphicon glyphicon-user"></span> Person</a></li>
					<li><a href="ProjectController?action=listProject"><span
							class="glyphicon glyphicon-tasks"></span> Project</a></li>
					<li><a href="CommentController?action=listComment"><span
							class="glyphicon glyphicon-comment"></span> Comment</a></li>
					<li><a href="TestController?action=listTest">Test</a></li>
					<li><a href="AssignController?action=listAssign">Assign</a></li>
					<li><a href="IssueController?action=listIssue"><span
							class="glyphicon glyphicon-exclamation-sign"></span> Issue</a></li>
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
	<form action="EditStatusController.do" method="post"
		class="form-horizontal">
		<div class="container">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<span class="glyphicon glyphicon-search"></span> View Issue
						Details
					</h3>
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
								<td><c:out value="${issue.project}" /><input type="hidden"
									name="project" class="form-control"
									value="<c:out value="${issue.project}" />"
									placeholder="project" /></td>
								<td><c:out value="${issue.title}" /><input type="hidden"
									name="title" class="form-control"
									value="<c:out value="${issue.title}" />" placeholder="title" /></td>
								<fmt:setLocale value="en_US" />
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${issue.dueDate}" /></td>
								<td><c:out value="${issue.updateDate}" /><input
									type="hidden" id="date" name="updateDate" class="form-control"
									value="<c:out value="${issue.updateDate}" />"
									placeholder="updateDate" /></td>
							</tr>
						</tbody>
					</table>
					<hr>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Reporter
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static">
								<c:out value="${issue.reporter}"></c:out>
								<input type="hidden" name="reporter" class="form-control"
									value="<c:out value="${issue.reporter}" />"
									placeholder="reporter" />
							</p>
						</div>

						<label for="tile" class="control-label col-sm-3">Assigned
							To :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static">
								<c:out value="${issue.assign}" />
								<input type="hidden" name="assign" class="form-control"
									value="<c:out value="${issue.assign}" />" placeholder="assign" />
							</p>
						</div>
					</div>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Severity
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static">
								<c:out value="${issue.severity}"></c:out>
								<input type="hidden" name="severity" class="form-control"
									value="<c:out value="${issue.severity}" />"
									placeholder="severity" />
							</p>
						</div>

						<label for="tile" class="control-label col-sm-3">Priority
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static">
								<c:out value="${issue.priority}"></c:out>
								<input type="hidden" name="priority" class="form-control"
									value="<c:out value="${issue.priority}" />"
									placeholder="priority" />
							</p>
						</div>
					</div>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Status :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static">
								<c:out value="${issue.status}"></c:out>
							</p>
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="control-label col-sm-2">Description
							:</label>
						<div class="col-sm-8 col-lg-6 col-md-6">
							<textarea name="description" class="form-control" rows="5"
								id="comment" placeholder="Description"><c:out
									value="${issue.description}"></c:out></textarea>
							<input type="hidden" name="description" class="form-control"
								value="<c:out value="${issue.description}" />"
								placeholder="description" />
						</div>
					</div>
					<hr>
					<div class="form-group">
						<label for="status" class="control-label col-sm-2"><a
							type="submit">Change Status To : </a></label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="status" class="form-control">
								<option value="Assign">Assign</option>
								<option value="Feedback">Feedback</option>
								<option value="Acknowledged">Acknowledged</option>
								<option value="Confirmed">Confirmed</option>
								<option value="Resolved">Resolved</option>
							</select>
						</div>
					</div>

					<fmt:setLocale value="en_US" />

					<div class="col-sm-8 col-lg-6 col-md-6">
						<input type="hidden" name="dueDate" class="form-control"
							value="<fmt:formatDate pattern="yyyy-MM-dd" value="${issue.dueDate}" />" />
					</div>
					<input type="hidden" name="issueID" class="form-control"
						value="<c:out value="${issue.issueID}" />" placeholder="issueID" />



					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-default" value="Submit" />
						</div>
					</div>
				</div>

			</div>
		</div>
	</form>


	<form action="" method="post" class="form-horizontal">
		<div class="container">
			<div class="col-md-8">
				<c:forEach items="${comments}" var="comment">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b><c:out value="${comment.userComment}"></c:out><span>&nbsp&nbsp&nbsp</span>
								<c:out value="${comment.commentTime}"></c:out></b>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label for="tile" class="control-label col-sm-2">Description
									:</label>
								<div class="col-sm-3 col-lg-2 col-md-2">
									<p class="form-control-static">
										<c:out value="${comment.commentDetail}"></c:out>
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</form>


	<form action="CommentController.do" method="post"
		class="form-horizontal">
		<div class="container">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b><%=username%></b>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<input type="hidden" name="commentID"
								value="<c:out value="${comment.commentID}" />"
								readonly="readonly" placeholder="Auto generate ID" />

							<div class="col-sm-12 col-lg-12 col-md-12">
								<textarea name="description" class="form-control" rows="6"
									id="comment" placeholder="Leave a comment"></textarea>
								<input type="hidden" name="commentDetail" class="form-control"
									value="<c:out value="${comment.commentDetail}" />"
									placeholder="description" />
							</div>
						</div>

						<input type="hidden" id="date" name="commentTime"
							value="<c:out value="${comment.commentTime}" />"
							placeholder="Comment Time" />

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" class="btn btn-default" value="Submit" />
							</div>
						</div>
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
	<script>
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //January is 0!

		var yyyy = today.getFullYear();
		var hh = today.getHours();
		var mn = today.getMinutes();
		var ss = today.getSeconds();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}
		if (ss < 10) {
			ss = '0' + ss
		}
		if (mn < 10) {
			mn = '0' + mn
		}
		if (hh < 10) {
			hh = '0' + hh
		}
		var today = dd + '/' + mm + '/' + yyyy + " " + hh + ":" + mn + ":" + ss;
		document.getElementById('date').value = today;
		console.log(today);
	</script>
</body>
</html>