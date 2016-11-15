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
</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="ProjectController.do" method="post"
			class="form-horizontal">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<span class="glyphicon glyphicon-tasks"></span> Project
					</h3>
				</div>
				<div class="panel-body">

					<input type="hidden" name="projectID"
						value="<c:out value="${project.projectID}" />" readonly="readonly"
						placeholder="Auto generate ID" /> <br> <br>

					<div class="form-group">
						<label for="projectName" class="control-label col-sm-2">Project
							Name :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<input type="text" name="projectName" class="form-control"
								value="<c:out value="${project.projectName}" />"
								placeholder="Project Name" />
						</div>

						<label for="status" class="control-label col-sm-2">Project
							Status :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select name="status" class="form-control">
								<option value="Development">Development</option>
								
								<option value="Closed">Closed</option>							
							</select>
						</div>
					</div>
					<fmt:setLocale value="en_US" />
					<div class="form-group">
						<label for="startDate" class="control-label col-sm-2">Start
							Date :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<input type="date" name="startDate" class="form-control"
								value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.startDate}" />" />
						</div>

						<label for="finishDate" class="control-label col-sm-2">Finish
							Date :</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<input type="date" name="finishDate" class="form-control"
								value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.finishDate}" />" />
						</div>
					</div>

					<div class="form-group">

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
						<label for="description" class="control-label col-sm-2">Description
							:</label>
						<div class="col-sm-8 col-lg-6 col-md-6">
							<textarea rows="5" id="comment" name="description"
								class="form-control" placeholder="Description"><c:out
									value="${project.description}" /></textarea>
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