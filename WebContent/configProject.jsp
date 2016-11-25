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
		<form class="form-inline">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>Collaborators<small><span class="pull-right">Push access to the project</span></small></h4>
				</div>
				<div class="panel-body">


					<div class="form-group">
						<div class="form-group">
							<label for="email">Email:</label> <input type="email"
								class="form-control" id="email" placeholder="Enter email">
						</div>
						<button type="submit" class="btn btn-default">Add collaborator</button>

					</div>
				</div>
			</div>
		</form>

		<form action="#" method="post" class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Assign</h3>
				</div>
				<div class="panel-body">
					<input type="hidden" name="assignID"
						value="<c:out value="${assign.assignID}" />" readonly="readonly"
						placeholder="Auto generate ID" /> <br> <br>

					<div class="form-group">
						<label for="personName" class="control-label col-sm-2">Person
							Name : </label>

						<div class="col-sm-3 col-lg-3 col-md-3">
							<select name="personName" class="form-control">
								<c:forEach var="person" items="${persons}">
									<option><c:out value="${person.personName}" /></option>
								</c:forEach>
							</select>
						</div>

						<label for="projectName" class="control-label col-sm-2">Project
							ID : </label>

						<div class="col-sm-3 col-lg-3 col-md-3">
							<select name="projectName" class="form-control">
								<c:forEach var="project" items="${projects}">
									<option><c:out value="${project.projectName}" /></option>
								</c:forEach>
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