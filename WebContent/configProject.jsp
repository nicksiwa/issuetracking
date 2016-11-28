<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Project</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form class="form-inline" action="AssignController.do"  method="post">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Collaborators</strong><small><span
							class="pull-right">Push access to the project</span></small>
					</h4>
				</div>
				<div class="panel-body">


					<div class="form-group">
						<div class="form-group">
						
<input type="hidden" name="projectName"
								value="<c:out value="${project.projectName}" />" readonly="readonly"
								placeholder="Auto generate ID" />
								
							<input type="hidden" name="assignID"
								value="<c:out value="${assign.assignID}" />" readonly="readonly"
								placeholder="Auto generate ID" /> <label for="email">Name
								:</label> <select name="personName" class="form-control">
								<c:forEach var="person" items="${persons}">
									<option><c:out value="${person.personName}" /></option>
								</c:forEach>
							</select>

						</div>
						<button type="submit" class="btn btn-default">Add
							collaborator</button>

						<table class="table table-hover table-responsive table-striped">
							<thead>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Position</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cols}" var="person">
									<tr>
										<td><c:out value="${person.firstName}" /></td>
										<td><c:out value="${person.lastName}" /></td>
										<td><c:out value="${person.position}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</form>

		<form action="3.jsp" method="post" class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Project Configuration</strong>
					</h4>
				</div>
				<div class="panel-body">

					<div class="form-group">
						<label for="status" class="control-label col-sm-2">Project
							Status :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="status" class="form-control">
								<option value="Development">Development</option>

								<option value="Closed">Closed</option>
							</select>
						</div>

						<label for="viewStatus" class="control-label col-sm-2">View
							Status :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="viewStatus" class="form-control">
								<option value="Public">Public</option>
								<option value="Private">Private</option>
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
		</form>
	</div>


	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>