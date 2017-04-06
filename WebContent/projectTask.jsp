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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

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
		var ss = ev.target.id;
		document.getElementById("taskID").value = data;
		document.getElementById("taskType").value = ss;

		$.ajax({
			type : "post",
			url : "AjaxTaskController",
			cache : false,
			data : $('#employeeForm').serialize(),

		});
	}
</script>

</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<form action="" class="form-horizontal">
			<h2>
				<span class="label label-primary"><c:out value="${project.projectName }"/></span><small>
					project owner</small>
			</h2>
			<br>
			<ul class="nav nav-tabs">
				<li><a
					href="MilestoneController.do?action=milestone&projectID=<c:out value="${project.projectID }"/>">Project
						milestone / Project road map</a></li>
				<li><a href="ProjectController.do?action=graph">Project report</a></li>
				<li class="active"><a
					href="TaskController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Project
						task</a></li>
				<li><a
					href="LabelController.do?action=label&projectID=<c:out value="${project.projectID }"/>">Issue
						labels</a></li>
			</ul>
			<br>

			<div class="col-md-4">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> To do <a href="#"><span
								class="pull-right glyphicon glyphicon-plus" data-toggle="modal"
								data-target="#myModal"></span></a>
						</h4>

					</div>

					<div class="panel-body" id="1" ondrop="drop(event)"
						ondragover="allowDrop(event)">
						<ul class="list-group">
							<c:forEach items="${tasks}" var="task">
								<c:choose>
									<c:when test="${task.taskType=='1'}">
										<li class="list-group-item" draggable="true"
											id="<c:out value="${task.taskID}" />"
											ondragstart="drag(event)" id="drag1">
											<p class="list-group-item-heading text-primary lead">
												<c:out value="${task.taskDetail}" />
											</p> Add by <c:out value="${task.createBy}" />
											
											<span class="pull-right">
													<fmt:parseDate
															value="${task.createDate}" pattern="yyyy-MM-dd HH:mm"
															var="myDate" /> <span class="glyphicon glyphicon-time"></span>
														<fmt:formatDate value="${myDate}"
															pattern="dd/MM/yyyy HH:mm" /></span>
										</li>
									</c:when>
								</c:choose>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> Doing <a href="#"><span
								class="pull-right glyphicon glyphicon-plus" data-toggle="modal"
								data-target="#myModal"></span></a>
						</h4>
					</div>
					<div class="panel-body" id="2" ondrop="drop(event)"
						ondragover="allowDrop(event)">
						<ul class="list-group">
							<c:forEach items="${tasks}" var="task">
								<c:choose>
									<c:when test="${task.taskType=='2'}">
										<li class="list-group-item" draggable="true"
											id="<c:out value="${task.taskID}" />"
											ondragstart="drag(event)" id="drag1">
											<p class="list-group-item-heading text-primary lead">
												<c:out value="${task.taskDetail}" />
											</p> Add by <c:out value="${task.createBy}" />
												<span class="pull-right">
													<fmt:parseDate
															value="${task.createDate}" pattern="yyyy-MM-dd HH:mm"
															var="myDate" /> <span class="glyphicon glyphicon-time"></span>
														<fmt:formatDate value="${myDate}"
															pattern="dd/MM/yyyy HH:mm" /></span>
										</li>
									</c:when>
								</c:choose>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> Done <a href="#"><span
								class="pull-right glyphicon glyphicon-plus" data-toggle="modal"
								data-target="#myModal"></span></a>
						</h4>
					</div>
					<div class="panel-body" id="3" ondrop="drop(event)"
						ondragover="allowDrop(event) ">
						<ul class="list-group">
							<c:forEach items="${tasks}" var="task">
								<c:choose>
									<c:when test="${task.taskType=='3'}">
										<li class="list-group-item" draggable="true"
											id="<c:out value="${task.taskID}" />"
											ondragstart="drag(event)" id="drag1">
											<p class="list-group-item-heading text-primary lead">
												<c:out value="${task.taskDetail}" />
											</p> Add by <c:out value="${task.createBy}" />
												<span class="pull-right">
													<fmt:parseDate
															value="${task.createDate}" pattern="yyyy-MM-dd HH:mm"
															var="myDate" /> <span class="glyphicon glyphicon-time"></span>
														<fmt:formatDate value="${myDate}"
															pattern="dd/MM/yyyy HH:mm" /></span>
										</li>
									</c:when>
								</c:choose>
							</c:forEach>
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

							<input id="i" type="hidden" name="projectID"
								value="<c:out value="${project.projectID}" />"> <input
								type="hidden" name="taskType" value="1">

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



		<form class="form-horizontal" role="form" method="post"
			name="employeeForm" id="employeeForm">


			<div class="form-group">

				<input type="hidden" name="taskID" id="taskID" placeholder="taskID" />

				<input type="hidden" class="form-control" name="taskType"
					id="taskType" placeholder="taskID" />
			</div>
		</form>
	</div>

	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>


</body>
</html>