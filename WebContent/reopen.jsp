<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Closed issue</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<form action="" class="form-horizontal">
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-search"></span> <b>View
								Issue Details : <span class="label label-success">Project
									name</span>
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
									<td id="i">10</td>

									<td>Project name</td>
									<td>Issue title</td>

									<td>17/12/2016</td>
									<td>22/01/2017 22:13:29</td>
								</tr>
							</tbody>
						</table>
						<hr>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2">Reporter
								:</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">Siwa Khongsuphap</p>
							</div>

							<label for="tile" class="control-label col-sm-3">Assigned
								to :</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">Siwa Khongsuphap</p>
							</div>
						</div>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2">Severity
								:</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">Minor</p>
							</div>

							<label for="tile" class="control-label col-sm-3">Priority
								:</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">Low</p>
							</div>
						</div>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2">Status :</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">Closed</p>
							</div>
						</div>
<div class="form-group">
<label for="tile" class="control-label col-sm-2">Description :</label>
<div class="col-sm-3 col-lg-2 col-md-2">
						<textarea readonly name="description" class="form-control"
							rows="5" id="description" placeholder="Description">Issue detail</textarea>
						</div></div>
						<br>
						<div class="form-group">
						<label for="tile" class="control-label col-sm-2"></label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<input type="submit" class="btn btn-success"
									value="Reopen issue" />
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="panel panel-default">

					<div class="panel-body">
						Project Issue Tracking
						<div class="progress">
							<div class="progress-bar progress-bar-success" role="progressbar"
								aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"
								style="width: 50%">50%</div>
						</div>
					</div>
					<ul class="list-group">
						<li class="list-group-item text-primary">Issue 1<span
							class="pull-right"><span class="label label-success">Resolved</span></span>
						</li>
						<li class="list-group-item text-primary">Issue 2<span
							class="pull-right"><span class="label label-danger">Feedback</span></span>
						</li>
						<li class="list-group-item text-primary">Issue 3<span
							class="pull-right"><span class="label label-danger">Feedback</span></span>
						</li>
						<li class="list-group-item text-primary">Issue 4<span
							class="pull-right"><span class="label label-success">Resolved</span></span>
						</li>
					</ul>
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