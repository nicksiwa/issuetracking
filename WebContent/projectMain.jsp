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

</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="" class="form-horizontal">
		<h2><span class="label label-primary">Project name</span><small> project owner</small></h2>
		<br>
			<ul class="nav nav-tabs">
				<li class="active"><a href="ProjectController.do?action=main">Project road map</a></li>
				<li><a href="ProjectController.do?action=milestone">Project milestone</a></li>
				<li><a href="ProjectController.do?action=graph">Graphs</a></li>
				<li><a href="ProjectController.do?action=task">Project task</a></li>
				<li><a href="ProjectController.do?action=label">Issue labels</a></li>
			</ul>
			<br>
			<div class="col-md-12">
				<table class="table table-hover table-responsive table-striped">
					<thead>
						<tr>
							<th>Milestone</th>
							<th>Progress</th>
							<th>Links</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i <= 10; i++) {
						%>
						<tr>
							<td>New feature</td>
							<td><div class="progress">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="50" aria-valuemin="0"
										aria-valuemax="100" style="width: 50%">50%</div>
								</div></td>
							<td><a href="">1</a> of <a href="">2</a> issue have been
								closed</td>

						</tr>

						<%
							}
						%>
					</tbody>
				</table>


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