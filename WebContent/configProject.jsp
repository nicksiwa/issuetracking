<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<div class="col-md-12">
			<div class="col-md-4">
				<div >
					
					<h4>BugTracking</h4>
					<div class="col-md-12">
								<span class="label label-success">${fn:length(assignResolved)}</span>
								<span class="label label-default">${fn:length(assignNo)}</span>&nbsp;&nbsp;&nbsp;<a href="#">Assigned to Me</a></div>
								<div class="col-md-12">
								<span class="label label-success">${fn:length(unassignResolved)}</span>
								<span class="label label-default">${fn:length(unassign)}</span>&nbsp;&nbsp;&nbsp;<a href="#">Unassigned</a></div>
								<div class="col-md-12">
								<span class="label label-success">${fn:length(issueResolved)}</span>
								<span class="label label-default">${fn:length(issueUn)}</span>&nbsp;&nbsp;&nbsp;<a href="#">All Issue</a></div>
				</div>
			</div>
			<div class="col-md-8">
				<form class="form-inline" action="AssignController.do" method="post">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>
								<strong>Collaborators</strong><small><span
									class="pull-right">Push access to the project</span></small>
							</h4>
						</div>
						<ul class="list-group">
							<c:forEach items="${cols}" var="person">
								<li class="list-group-item">
									<h5 class="list-group-item-heading">
									<strong>
										<c:out value="${person.firstName}" />
										<c:out value="${person.lastName}" /></strong>

										<a
											href="AssignController.do?action=delete&assignID=<c:out value="${person.assignID}"/>&projectID=<c:out value="${person.projectID}"/>"><span
											class="pull-right glyphicon glyphicon-remove text-danger"
											data-toggle="tooltip" data-placement="top"
											title="Remove <c:out value="${person.firstName}" /> <c:out value="${person.lastName}" /> as a collaborator"></span></a>
									</h5>
									<p class="list-group-item-text">
										<small><c:out value="${person.position}" /></small>
									</p>
								</li>
							</c:forEach>
						</ul>

						<div class="panel-body">
							<div class="form-group col-md-offset-1">
								<input type="hidden" name="projectName"
									value="<c:out value="${project.projectName}" />"
									readonly="readonly" placeholder="Auto generate ID" /> <input
									type="hidden" name="projectID"
									value="<c:out value="${project.projectID}" />"
									readonly="readonly" placeholder="Auto generate ID" /> <input
									type="hidden" name="assignID"
									value="<c:out value="${assign.assignID}" />"
									readonly="readonly" placeholder="Auto generate ID" />
								<div class="input-group">
									<span class="input-group-addon">Name</span> <select
										name="personName" class="form-control">
										<c:forEach var="person" items="${persons}">
											<option><c:out value="${person.personName}" /></option>
										</c:forEach>
									</select>
								</div>

								<button type="submit" class="btn btn-default">Add
									collaborator</button>
							</div>
						</div>
					</div>
				</form>

				<form action="ConfigProject.do" method="post"
					class="form-horizontal">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>
								<strong>Project Configuration</strong>
							</h4>
						</div>
						<div class="panel-body">



							<div class="form-group">
								<div>

									<c:set var="status" value="${project2.status}" />

									<div class="radio col-md-offset-1">
										<label><input type="radio" name="status"
											value="Development"
											<c:if test="${status=='Development'}">checked</c:if>><span
											class="glyphicon glyphicon-wrench"></span> Development <br>&nbsp;&nbsp;&nbsp;&nbsp;<small>This
												project can create issue.</small></label>
									</div>
									<div class="radio col-md-offset-1">
										<label><input type="radio" name="status"
											value="Closed"
											<c:if test="${status=='Closed'}">checked</c:if>><span
											class="glyphicon glyphicon-folder-close"></span> Closed <br>&nbsp;&nbsp;&nbsp;&nbsp;<small>This
												project can't create issue.</small></label>
									</div>
								</div>

								<hr>

								<div>

									<c:set var="viewStatus" value="${project2.viewStatus}" />

									<div class="radio col-md-offset-1">
										<label><input type="radio" name="viewStatus"
											value="Public"
											<c:if test="${viewStatus=='Public'}">checked</c:if>><span
											class="glyphicon glyphicon-globe"></span> Public <br>&nbsp;&nbsp;&nbsp;&nbsp;<small>Anyone
												can see this project.</small></label>
									</div>
									<div class="radio col-md-offset-1">
										<label> <input type="radio" name="viewStatus"
											value="Private"
											<c:if test="${viewStatus=='Private'}">checked</c:if>><span
											class="glyphicon glyphicon-lock"></span> Private <br>&nbsp;&nbsp;&nbsp;&nbsp;<small>You
												choose who can see this project.</small></label>
									</div>

								</div>
							</div>

							<input type="hidden" name="projectID"
								value="<c:out value="${project2.projectID}" />">



							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<input type="submit" class="btn btn-default" value="Submit" />
								</div>
							</div>



						</div>
					</div>

				</form>
			</div>
		</div>
	</div>


	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>