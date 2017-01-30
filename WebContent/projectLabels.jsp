<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Issue labels</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<form action="" class="form-horizontal">
			<h2><span class="label label-primary">Project name</span><small> project owner</small></h2>
			<br>
			<ul class="nav nav-tabs">
				<li><a href="ProjectController.do?action=main">Project road
						map</a></li>
				<li><a href="ProjectController.do?action=milestone">Project
						milestone</a></li>
				<li><a href="ProjectController.do?action=graph">Graphs</a></li>
				<li><a href="ProjectController.do?action=task">Project task</a></li>
				<li class="active"><a href="ProjectController.do?action=label">Issue
						labels</a></li>
			</ul>
			<br>
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-tag"></span> Issue labels<span
								class="pull-right"><button type="button"
									class="btn btn-success btn-sm" data-toggle="modal"
									data-target="#myModal">New labels</button></span>
						</h4>

					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<h4>
								<span class="label label-danger"><span
									class="glyphicon glyphicon-tag"></span> Bug</span> <small><span
									class="pull-right"><a href=""><span
										class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=""><span
										class="glyphicon glyphicon-remove"></span></a></span></small>
							</h4>

						</li>
						<li class="list-group-item">
							<h4>
								<span class="label label-success"><span
									class="glyphicon glyphicon-tag"></span> Help wanted</span> <small><span
									class="pull-right"><a href=""><span
										class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=""><span
										class="glyphicon glyphicon-remove"></span></a></span></small>
							</h4>
						</li>
						<li class="list-group-item">
							<h4>
								<span class="label label-warning"><span
									class="glyphicon glyphicon-tag"></span> Question</span> <small><span
									class="pull-right"><a href=""><span
										class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=""><span
										class="glyphicon glyphicon-remove"></span></a></span></small>
							</h4>
						</li>
						<li class="list-group-item">
							<h4>
								<span class="label label-info"><span
									class="glyphicon glyphicon-tag"></span> Feature</span> <small><span
									class="pull-right"><a href=""><span
										class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=""><span
										class="glyphicon glyphicon-remove"></span></a></span></small>
							</h4>
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
							<h4 class="modal-title">New labels</h4>
						</div>
						<div class="modal-body">
							<label for="comment">Title :</label> <input type="text"
								class="form-control"> <br> 
								<label for="comment">Select type :</label>
								<a href=""><span
								class="label label-default">Default Label</span></a> <a href=""><span
								class="label label-primary">Primary Label</span></a> <a href=""><span
								class="label label-success">Success Label</span></a> <a href=""><span
								class="label label-info">Info Label</span></a> <a href=""><span
								class="label label-warning">Warning Label</span></a> <a href=""><span
								class="label label-danger">Danger Label</span></a>

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

	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>