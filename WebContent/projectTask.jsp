<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project name</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>

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
			<h2>
				<span class="label label-primary">Project name</span><small>
					project owner</small>
			</h2>
			<br>
			<ul class="nav nav-tabs">
				<li><a href="ProjectController.do?action=main&projectID=<c:out value="${project.projectID }"/>">Project road
						map</a></li>
				<li><a href="MilestoneController.do?action=milestone&projectID=<c:out value="${project.projectID }"/>">Project
						milestone</a></li>
				<li><a href="ProjectController.do?action=graph">Graphs</a></li>
				<li class="active"><a href="TaskController.do?action=task">Project
						task</a></li>
				<li><a href="LabelController.do?action=label&projectID=<c:out value="${project.projectID }"/>">Issue
						labels</a></li>
			</ul>
			<br>
			<div class="col-md-4">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> To do <span
								class="badge">${fn:length(tasks)}</span> <a href="#"><span
								class="pull-right glyphicon glyphicon-plus" data-toggle="modal"
								data-target="#myModal"></span></a>
						</h4>

					</div>

					<div class="panel-body" id="div1" ondrop="drop(event)"
						ondragover="allowDrop(event)">

						<ul class="list-group">
						
						<c:choose>
							<c:when test="${fn:length(tasks)=='0'}">
								<li class="list-group-item">No have any task</li>
							</c:when>
							<c:otherwise>
						
							<c:forEach items="${tasks}" var="task">
							
							<li class="list-group-item" draggable="true"
								ondragstart="drag(event)" id="drag1">
								<p class="list-group-item-heading text-primary lead"><c:out value="${task.taskDetail}" /></p>
								Add by <c:out value="${task.createBy}" /> <span class="pull-right glyphicon glyphicon-time">
									<fmt:formatDate value="${task.createDate}" pattern="dd/MM/yyyy HH:mm:ss" /></span>
							</li>
							
								</c:forEach>
							</c:otherwise></c:choose>
						</ul>
					</div>

				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> Doing <span
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
							<span class="glyphicon glyphicon-th-list"></span> Done <span
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

		<form action="TaskController.do" method="post" class="form-horizontal">
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Add task</h4>
						</div>
						<div class="modal-body">
							<input type="hidden" name="taskID"
								value="<c:out value="${task.taskID}" />" readonly="readonly"
								placeholder="Auto generate ID" /> <input type="hidden"
								name="createDate" value="<c:out value="${task.createDate}" />"
								placeholder="Comment Time" />

							<textarea name="taskDetail" class="form-control" rows="5"
								id="comment" placeholder="Enter a task"></textarea>

						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-default" value="Add" />
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