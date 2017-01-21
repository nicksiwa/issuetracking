<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.siwa.model.Issue"%>
<!DOCTYPE HTML>

<jsp:useBean id="demo" class="com.siwa.model.Issue" scope="session" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${issue.title}" /> : <c:out
		value="${issue.project}" /></title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>

</head>
<body>

	<jsp:include page="navbar.jsp" />

	<form action="EditStatusController.do" method="post"
		class="form-horizontal">
		<div class="container">
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-search"></span> <b>View
								Issue Details : <span class="label label-success"><c:out
										value="${issue.title}" /></span>
							</b>
						</h4>
					</div>
					<div class="panel-body">
						<table class="table table-hover table-responsive table-striped">
							<thead>
								<tr>
									<th>Issue id</th>
									<th>Project</th>
									<th>Title</th>
									<th>Due date</th>
									<th>Update date</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td id="i"><c:out value="${issue.issueID}" /></td>

									<td><c:out value="${issue.project}" /><input
										type="hidden" name="project" class="form-control"
										value="<c:out value="${issue.project}" />"
										placeholder="project" /></td>
									<td><c:out value="${issue.title}" /><input type="hidden"
										name="title" class="form-control"
										value="<c:out value="${issue.title}" />" placeholder="title" /></td>
									<fmt:setLocale value="en_US" />
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${issue.dueDate}" /></td>
									<td><fmt:parseDate value="${issue.updateDate}"
											pattern="yyyy-MM-dd HH:mm:ss" var="myDate" /> <fmt:formatDate
											value="${myDate}" pattern="dd/MM/yyyy HH:mm:ss" /><input
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
								to :</label>
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

						<textarea readonly name="description" class="form-control"
									rows="5" id="description" placeholder="Description"><c:out
										value="${issue.description}"></c:out></textarea>
						
					<script>
					
						CKEDITOR.replace('description', {toolbarStartupExpanded : false});
						
						
					</script>


						<hr>
						<div class="form-group">
							<label for="description" class="control-label col-sm-2"></label>
							<div class="col-sm-5 col-lg-6 col-md-5">
								<div class="input-group">
									<span class="input-group-addon">Change status to</span><select
										name="status" class="form-control" id="comboA"
										onchange="getComboA(this)" data-toggle="tooltip"
										data-placement="top"
										title="Select issue status then go to comment page">
										<option value="assign">Assign</option>
										<option value="feedback">Feedback</option>
										<option value="confirmed">Confirmed</option>
										<option value="resolved">Resolved</option>
									</select>
								</div>
							</div>
						</div>

						<fmt:setLocale value="en_US" />

						<div class="col-sm-8 col-lg-6 col-md-6">
							<input type="hidden" name="dueDate" class="form-control"
								value="<fmt:formatDate pattern="yyyy-MM-dd" value="${issue.dueDate}" />" />
						</div>
						<input type="hidden" name="issueID" class="form-control"
							value="<c:out value="${issue.issueID}" />" placeholder="issueID" />


					</div>

				</div>
			</div>
			<div class="col-md-3">
				<div class="panel panel-default">

					<div class="panel-body">
						Project Issue Tracking
						<div class="progress">	
							<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="50"
								aria-valuemin="0" aria-valuemax="100" style="width: 50%">
								50%</div>
						</div>
					</div>
						<ul class="list-group">
						<li class="list-group-item text-primary">
						Issue 1<span class="pull-right"><span class="label label-success">Resolved</span></span>
						</li>
						<li class="list-group-item text-primary">
						Issue 2<span class="pull-right"><span class="label label-danger">Feedback</span></span>
						</li>
						<li class="list-group-item text-primary">
						Issue 3<span class="pull-right"><span class="label label-danger">Feedback</span></span>
						</li>
						<li class="list-group-item text-primary">
						Issue 4<span class="pull-right"><span class="label label-success">Resolved</span></span>
						</li>
						</ul>
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
								<fmt:parseDate value="${comment.commentTime}"
									pattern="yyyy-MM-dd HH:mm:ss" var="myDate" /> <span
								class="glyphicon glyphicon-time"></span> <fmt:formatDate
									value="${myDate}" pattern="dd/MM/yyyy HH:mm:ss" /> </b>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label for="tile" class="control-label col-sm-2">Description
									:</label>
								<div class="col-sm-6 col-lg-4 col-md-4">
									<p class="form-control-static">
										<c:out value="${comment.commentDetail}"></c:out>
									</p>
								</div>

								<label for="tile" class="control-label col-sm-2">Status
									:</label>
								<div class="col-sm-3 col-lg-2 col-md-2">
									<p class="form-control-static">
										<c:out value="${comment.commentStatus}"></c:out>
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
						<%
							String username = (String) session.getAttribute("username");
						%>
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

		function getComboA(sel) {
			var value = sel.value;
			var issue = "&issueID=";
			var id = $('#i').html();

			var google = "http://localhost:8080/Project/CommentController?action=";
			var result = google + value + issue + id;

			if (window.confirm("Change status to " + value)) {
				window.location = result
			} else {

			}

		}
	</script>
</body>
</html>