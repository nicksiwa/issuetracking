<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projects</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<style>
</style>
</head>
<body>

	<jsp:include page="navbar.jsp" />
	<div class="container">


		<form action="" class="form-horizontal">


			<div class="col-md-12">

				<ul class="nav nav-tabs">
					<li><a href="ProjectController.do?action=listProject">Issue
							tracking system project</a></li>
					<li class="active"><a href="ProjectController.do?action=github">GitHub
							project</a></li>
				</ul>
				<br>
						<a href="ProjectController.do?action=insert"
							class="btn btn-success"><span
							class="glyphicon glyphicon-plus"></span> New project</a>
						<hr>
						
						<div class="panel panel-default">
							<ul class="list-group">

								

									<li class="list-group-item"><input id="i" type="hidden"
										value="<c:out value="${project.projectID}" />">

										<p class="list-group-item-heading text-primary lead">
											<a href="ProjectController.do?action=main"><strong>BookStoreJavaConsole</strong></a> <span
												class="pull-right"><small><a
													class="text-muted" data-toggle="tooltip"
													title="Project configuration"
													href="ProjectController.do?action=config&projectID=17"><span
														class="glyphicon glyphicon-cog"></span></a></small>&nbsp;&nbsp;&nbsp;<small><a
													class="text-info" data-toggle="tooltip"
													title="Edit project"
													href="ProjectController.do?action=edit&projectID=17"><span
														class="glyphicon glyphicon-edit"></span></a></small>&nbsp;&nbsp; <small><a
													href="ProjectController.do?action=delete&projectID=17/>"
													class="text-danger" data-toggle="tooltip"
													title="Delete this project"><span
														class="glyphicon glyphicon-trash"></span></a></small></span>

										</p>
										<p class="list-group-item-text ">

											<c:out value="-"></c:out>

										</p></li>
							
									<li class="list-group-item"><input id="i" type="hidden"
										value="<c:out value="${project.projectID}" />">

										<p class="list-group-item-heading text-primary lead">
											<a href="ProjectController.do?action=main"><strong>BugTracking</strong></a> <span
												class="pull-right"><small><a
													class="text-muted" data-toggle="tooltip"
													title="Project configuration"
													href="ProjectController.do?action=config&projectID=17"><span
														class="glyphicon glyphicon-cog"></span></a></small>&nbsp;&nbsp;&nbsp;<small><a
													class="text-info" data-toggle="tooltip"
													title="Edit project"
													href="ProjectController.do?action=edit&projectID=17"><span
														class="glyphicon glyphicon-edit"></span></a></small>&nbsp;&nbsp; <small><a
													href="ProjectController.do?action=delete&projectID=17/>"
													class="text-danger" data-toggle="tooltip"
													title="Delete this project"><span
														class="glyphicon glyphicon-trash"></span></a></small></span>

										</p>
										<p class="list-group-item-text ">

											<c:out value="-"></c:out>

										</p></li>
										
										
										
										<li class="list-group-item"><input id="i" type="hidden"
										value="<c:out value="${project.projectID}" />">

										<p class="list-group-item-heading text-primary lead">
											<a href="ProjectController.do?action=main"><strong>git101</strong></a> <span
												class="pull-right"><small><a
													class="text-muted" data-toggle="tooltip"
													title="Project configuration"
													href="ProjectController.do?action=config&projectID=17"><span
														class="glyphicon glyphicon-cog"></span></a></small>&nbsp;&nbsp;&nbsp;<small><a
													class="text-info" data-toggle="tooltip"
													title="Edit project"
													href="ProjectController.do?action=edit&projectID=17"><span
														class="glyphicon glyphicon-edit"></span></a></small>&nbsp;&nbsp; <small><a
													href="ProjectController.do?action=delete&projectID=17/>"
													class="text-danger" data-toggle="tooltip"
													title="Delete this project"><span
														class="glyphicon glyphicon-trash"></span></a></small></span>

										</p>
										<p class="list-group-item-text ">

											<c:out value="-"></c:out>

										</p></li>
										
										
										
										<li class="list-group-item"><input id="i" type="hidden"
										value="<c:out value="${project.projectID}" />">

										<p class="list-group-item-heading text-primary lead">
											<a href="ProjectController.do?action=main"><strong>jdbc-java-crud-operations</strong></a> <span
												class="pull-right"><small><a
													class="text-muted" data-toggle="tooltip"
													title="Project configuration"
													href="ProjectController.do?action=config&projectID=17"><span
														class="glyphicon glyphicon-cog"></span></a></small>&nbsp;&nbsp;&nbsp;<small><a
													class="text-info" data-toggle="tooltip"
													title="Edit project"
													href="ProjectController.do?action=edit&projectID=17"><span
														class="glyphicon glyphicon-edit"></span></a></small>&nbsp;&nbsp; <small><a
													href="ProjectController.do?action=delete&projectID=17/>"
													class="text-danger" data-toggle="tooltip"
													title="Delete this project"><span
														class="glyphicon glyphicon-trash"></span></a></small></span>

										</p>
										<p class="list-group-item-text ">

											<c:out value="-"></c:out>

										</p></li>
										
										
										
										<li class="list-group-item"><input id="i" type="hidden"
										value="<c:out value="${project.projectID}" />">

										<p class="list-group-item-heading text-primary lead">
											<a href="ProjectController.do?action=main"><strong>PrimeFactor5630213013</strong></a> <span
												class="pull-right"><small><a
													class="text-muted" data-toggle="tooltip"
													title="Project configuration"
													href="ProjectController.do?action=config&projectID=17"><span
														class="glyphicon glyphicon-cog"></span></a></small>&nbsp;&nbsp;&nbsp;<small><a
													class="text-info" data-toggle="tooltip"
													title="Edit project"
													href="ProjectController.do?action=edit&projectID=17"><span
														class="glyphicon glyphicon-edit"></span></a></small>&nbsp;&nbsp; <small><a
													href="ProjectController.do?action=delete&projectID=17/>"
													class="text-danger" data-toggle="tooltip"
													title="Delete this project"><span
														class="glyphicon glyphicon-trash"></span></a></small></span>

										</p>
										<p class="list-group-item-text ">

											<c:out value="-"></c:out>

										</p></li>
										
										
										
										
										
										<li class="list-group-item"><input id="i" type="hidden"
										value="<c:out value="${project.projectID}" />">

										<p class="list-group-item-heading text-primary lead">
											<a href="ProjectController.do?action=main"><strong>Project1</strong></a> <span
												class="pull-right"><small><a
													class="text-muted" data-toggle="tooltip"
													title="Project configuration"
													href="ProjectController.do?action=config&projectID=17"><span
														class="glyphicon glyphicon-cog"></span></a></small>&nbsp;&nbsp;&nbsp;<small><a
													class="text-info" data-toggle="tooltip"
													title="Edit project"
													href="ProjectController.do?action=edit&projectID=17"><span
														class="glyphicon glyphicon-edit"></span></a></small>&nbsp;&nbsp; <small><a
													href="ProjectController.do?action=delete&projectID=17/>"
													class="text-danger" data-toggle="tooltip"
													title="Delete this project"><span
														class="glyphicon glyphicon-trash"></span></a></small></span>

										</p>
										<p class="list-group-item-text ">

											<c:out value="-"></c:out>

										</p></li>
										
										
										
										
										<li class="list-group-item"><input id="i" type="hidden"
										value="<c:out value="${project.projectID}" />">

										<p class="list-group-item-heading text-primary lead">
											<a href="ProjectController.do?action=main"><strong>readthedocs.org</strong></a> <span
												class="pull-right"><small><a
													class="text-muted" data-toggle="tooltip"
													title="Project configuration"
													href="ProjectController.do?action=config&projectID=17"><span
														class="glyphicon glyphicon-cog"></span></a></small>&nbsp;&nbsp;&nbsp;<small><a
													class="text-info" data-toggle="tooltip"
													title="Edit project"
													href="ProjectController.do?action=edit&projectID=17"><span
														class="glyphicon glyphicon-edit"></span></a></small>&nbsp;&nbsp; <small><a
													href="ProjectController.do?action=delete&projectID=17/>"
													class="text-danger" data-toggle="tooltip"
													title="Delete this project"><span
														class="glyphicon glyphicon-trash"></span></a></small></span>

										</p>
										<p class="list-group-item-text ">

											<c:out value="-"></c:out>

										</p></li>
										
										
							</ul>
						</div>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
	<script>
		function myFunction() {
			var id = $('#i').html();
			var link = "http://localhost:8080/Project/ProjectController.do?action=delete&projectID=";
			var result = link + id;
			var ask = window
					.confirm("Are you sure you want to delete this post?");
			if (ask) {
				window.alert("This post was successfully deleted.");
				document.location.href = result;
			} else {

			}
		}
	</script>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>