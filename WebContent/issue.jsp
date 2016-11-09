<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Issue</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<jsp:include page="navbar.jsp" />

	<form action="IssueController.do" method="post" class="form-horizontal">
		<div class="container">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<span class="glyphicon glyphicon-exclamation-sign"></span> <b>Create Issue : <span class="label label-success"><c:out value="${project.projectName}" /></span></b>
					</h4>
				</div>
				<div class="panel-body">

					<input type="hidden" name="issueID"
						value="<c:out value="${issue.issueID}" />" readonly="readonly"
						placeholder="Auto generate ID" /> <br> <br>

					<div class="form-group">
						<label for="description" class="control-label col-sm-2">Project
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
					
							<p class="form-control-static"><c:out value="${project.projectName}" /></p>
								<input type="hidden" name="project" class="form-control"
									value="<c:out value="${project.projectName}" />"
									placeholder="reporter" />
						</div>

						<label for="description" class="control-label col-sm-2">Assign
							To :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="assign" class="form-control">
								<c:forEach var="issue" items="${issuess}">
									<option><c:out value="${issue.assign}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="tile" class="control-label col-sm-2">Title :</label>
						<div class="col-sm-8 col-lg-6 col-md-6">
							<input type="text" name="title" class="form-control"
								value="<c:out value="${issue.title}" />" placeholder="Title" />
						</div>
					</div>


					<div class="form-group">
						<label for="description" class="control-label col-sm-2">Description
							:</label>
						<div class="col-sm-8 col-lg-6 col-md-6">
							<textarea name="description" class="form-control" rows="5"
								id="comment" placeholder="Description"><c:out
									value="${issue.description}" /></textarea>
						</div>
					</div>

					<br>

					<div class="form-group">
						<label for="severity" class="control-label col-sm-2">Severity
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="severity" class="form-control">
								<option value="Minor">Minor</option>
								<option value="Major">Major</option>
								<option value="Crash">Crash</option>
							</select>
						</div>

						<label for="priority" class="control-label col-sm-2">Priority
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="priority" class="form-control">
								<option value="Low">Low</option>
								<option value="Normal">Normal</option>
								<option value="High">High</option>
							</select>
						</div>
					</div>
					<fmt:setLocale value="en_US" />
					<div class="form-group">
						<label for="dueDate" class="control-label col-sm-2">Due
							Date :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<input type="date" name="dueDate" class="form-control"
								value="<fmt:formatDate pattern="yyyy-MM-dd" value="${issue.dueDate}" />" />
						</div>
					</div>
					<input type="hidden" id="date" name="updateDate"
						value="<c:out value="${issue.updateDate}" />"
						placeholder="Comment Time" />

					<div class="form-group">
						<label for="status" class="control-label col-sm-2">Status
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="status" class="form-control">
								<option value="Assign">Assign</option>
								<option value="Feedback">Feedback</option>
								<option value="Confirmed">Confirmed</option>
								<option value="Resolved">Resolved</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-default" value="Submit" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
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