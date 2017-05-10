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
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/dropzone.js"></script>

<script>
	function myFunction(value) {
		var x = document.getElementById("mySelect").value;

		$.ajax({
			type : "post",
			dataType : "json",
			url : "AjaxTestController",
			data : {
				email_id : x
			},
			success : function(data) {
				document.getElementById('e1').value = data.email_id;
				document.getElementById('e2').value = data.email_password;
			}
		});
	}
</script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<span class="glyphicon glyphicon-exclamation-sign"></span> <b>Create
							Issue : <span class="label label-success"><c:out
									value="${project.projectName}" /></span>
						</b>
					</h4>
				</div>
				<div class="panel-body">
					<form action="IssueController.do" method="post"
						class="form-horizontal" id="form1" enctype="multipart/form-data">
						<input type="hidden" name="issueID" value="" readonly="readonly"
							placeholder="Auto generate ID" /> <br> <br>

						<div class="form-group">
							<label for="description" class="control-label col-sm-2">Project
								:</label>
							<div class="col-sm-3 col-md-4">

								<p class="form-control-static">
									<c:out value="${project.projectName}" />
								</p>
								<input type="hidden" name="project" class="form-control"
									value="<c:out value="${project.projectName}" />"
									placeholder="reporter" />
							</div>

							<label for="description" class="control-label col-sm-2">Assign
								to :</label>
							<div class="col-sm-3 col-md-4">
								<select name="assign" class="form-control" id="mySelect"
									onchange="myFunction(value)">
									<option>-</option>
									<c:forEach var="issue" items="${issuess}">

										<option><c:out value="${issue.assign}" /></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2">Title :</label>
							<div class="col-sm-8 col-md-10">
								<input type="text" name="title" class="form-control" required
									value="<c:out value="${issue.title}" />" placeholder="Title" />
							</div>
						</div>


						<div class="form-group">
							<label for="description" class="control-label col-sm-2">Description
								:</label>
							<div class="col-sm-8 col-md-10">
								<textarea name="description" class="form-control" rows="10"
									cols="80" required id="description" placeholder="Description"><c:out
										value="${issue.description}" /></textarea>
								<script>
									CKEDITOR.replace('description');
								</script>
							</div>
						</div>
						<div class="form-group">
							<label for="severity" class="control-label col-sm-2">Severity
								:</label>
							<div class="col-sm-3 col-md-4">
								<select name="severity" class="form-control">
									<option value="Minor">Minor</option>
									<option value="Major">Major</option>
									<option value="Crash">Crash</option>
								</select>
							</div>

							<label for="priority" class="control-label col-sm-2">Priority
								:</label>
							<div class="col-sm-3 col-md-4">
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
							<div class="col-sm-3 col-md-4">
								<input type="date" name="dueDate" class="form-control" required
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${issue.dueDate}" />" />
							</div>
						</div>
						<input type="hidden" name="updateDate"
							value="<c:out value="${issue.updateDate}" />"
							placeholder="Comment Time" />

						<div class="form-group">
							<label for="status" class="control-label col-sm-2">Status
								:</label>
							<div class="col-sm-3 col-md-4">
								<select name="status" class="form-control">
									<option value="Assign">Open</option>
									<option value="Assign">Assign</option>
									<option value="Feedback">Feedback</option>
									<option value="Confirmed">Confirmed</option>
									<option value="Resolved">Resolved</option>
									<option value="Resolved">Closed</option>
								</select>
							</div>
						</div>

						<input type="hidden" name="to" id="e1" /><br />
						<input type="hidden" name="subject"
							value="New issue assign to you" /><br />
						<input type="hidden" name="message" /><br /> <input type="hidden"
							name="user" value="<c:out value="${issue.email_id}" />"><br />
						<input type="hidden" name="pass"
							value="<c:out value="${issue.email_password}" />" /><br />
							
							<input type="file" name="file" size="10" required="required" />

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" class="btn btn-default" value="Submit" />
							</div>
						</div>
					</form>


				</div>
			</div>
		</div>
	</div>




	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>