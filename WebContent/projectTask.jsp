<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project name</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>

<script>
	function allowDrop(ev) {
		ev.preventDefault();
	}

	function drag(ev) {
		ev.dataTransfer.setData("text", ev.target.id);
	}

	function drop(ev) {
		ev.preventDefault();
		var data = ev.dataTransfer.getData("text");
		ev.target.appendChild(document.getElementById(data));
	}
</script>

</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="" class="form-horizontal">
			<h3>Project name</h3>
			<ul class="nav nav-tabs">
				<li><a href="ProjectController.do?action=main">Project road
						map</a></li>
				<li><a href="ProjectController.do?action=milestone">Project
						milestone</a></li>
				<li><a href="ProjectController.do?action=graph">Graphs</a></li>
				<li class="active"><a href="ProjectController.do?action=task">Project
						task</a></li>
			</ul>
			<br>
			<div class="col-md-4">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> <b>To do </b><span
								class="badge">1</span> <a href="#"><span
								class="pull-right glyphicon glyphicon-plus" data-toggle="modal"
								data-target="#myModal"></span></a>
						</h4>

					</div>

					<div class="panel-body" id="div1" ondrop="drop(event)"
						ondragover="allowDrop(event)">

						<ul class="list-group">
							<li class="list-group-item" draggable="true"
								ondragstart="drag(event)" id="drag1">
								<p class="list-group-item-heading text-primary lead">Task 1</p>
								<p class="list-group-item-text ">Add by Siwa <span class="pull-right glyphicon glyphicon-time"> 20/01/2017 20:13</span></p>
							</li>
						</ul>

						<ul class="list-group">
							<li class="list-group-item" draggable="true"
								ondragstart="drag(event)" id="drag2">
								<p class="list-group-item-heading text-primary lead">Task 2</p>
								<p class="list-group-item-text ">Add by Siwa <span class="pull-right glyphicon glyphicon-time"> 20/01/2017 20:13</span></p>
							</li>
						</ul>
					</div>

				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> <b>Doing </b><span
								class="badge">1</span> <a href="#"><span
								class="pull-right glyphicon glyphicon-plus" data-toggle="modal"
								data-target="#myModal"></span></a>
						</h4>

					</div>

					<div class="panel-body" id="div2" ondrop="drop(event)"
						ondragover="allowDrop(event)">
						<ul class="list-group">

						</ul>
					</div>

				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> <b>Done </b><span
								class="badge">1</span> <a href="#"><span
								class="pull-right glyphicon glyphicon-plus" data-toggle="modal"
								data-target="#myModal"></span></a>
						</h4>

					</div>

					<div class="panel-body" id="div3" ondrop="drop(event)"
						ondragover="allowDrop(event)">
						<ul class="list-group">

						</ul>
					</div>
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
							<h4 class="modal-title">Add task</h4>
						</div>
						<div class="modal-body">

							<textarea class="form-control" rows="5" id="comment" placeholder="Enter a task"></textarea>

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