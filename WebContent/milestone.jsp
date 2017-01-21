<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Milestone</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<form action="" class="form-horizontal">
			<h3>Project name</h3>
			<ul class="nav nav-tabs">
				<li><a href="ProjectController.do?action=main">Project road
						map</a></li>
				<li class="active"><a
					href="ProjectController.do?action=milestone">Project milestone</a></li>
				<li><a href="ProjectController.do?action=graph">Graphs</a></li>
				<li><a href="ProjectController.do?action=task">Project task</a></li>
			</ul>
			<br>
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> Project
							Milestone <span class="pull-right"><button type="button"
									class="btn btn-success btn-sm" data-toggle="modal"
								data-target="#myModal">New milestone</button></span>
						</h4>

					</div>

					<ul class="list-group">
						<li class="list-group-item">

							<div class="col-md-6">Milestone 1</div>

							<div class="col-md-6">
								<div class="progress">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="50" aria-valuemin="0"
										aria-valuemax="100" style="width: 50%">50%</div>
								</div>
								50 % complete&nbsp;&nbsp;1 open&nbsp;&nbsp;1 close
							</div> <br> <br> <br>
						</li>

						<li class="list-group-item">

							<div class="col-md-6">Milestone 2</div>

							<div class="col-md-6">
								<div class="progress">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="50" aria-valuemin="0"
										aria-valuemax="100" style="width: 50%">50%</div>
								</div>
								50 % complete&nbsp;&nbsp;1 open&nbsp;&nbsp;1 close
							</div> <br> <br> <br>
						</li>
					</ul>

				</div>


			</div>
		</form>
		<form action="" class="form-horizontal">
		<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">New milestone</h4>
						</div>
						<div class="modal-body">
						<label for="comment">Title :</label>
							<input type="text" class="form-control">
							<br>
							<label for="comment">Description :</label>
							<textarea class="form-control" rows="5" id="comment"></textarea>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Add</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>
		</form>
	</div>


	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>