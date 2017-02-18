<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Milestone</title>
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
				<li class="active"><a
					href="MilestoneController.do?action=milestone&projectID=<c:out value="${project.projectID }"/>">Project milestone</a></li>
				<li><a href="ProjectController.do?action=graph">Graphs</a></li>
				<li><a href="ProjectController.do?action=task">Project task</a></li>
				<li><a href="ProjectController.do?action=label">Issue labels</a></li>
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
					
					<c:choose>
							<c:when test="${fn:length(milestones)=='0'}">
								<li class="list-group-item">No have any milestone</li>
							</c:when>
							<c:otherwise>
						
							<c:forEach items="${milestones}" var="milestone">
					
						<li class="list-group-item">

							<div class="col-md-6"><h5><c:out value="${milestone.milestoneName}" /></h5>
							<p><c:out value="${milestone.milestoneDescription}" /></p>
							</div>

							<div class="col-md-6">
								<div class="progress">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="50" aria-valuemin="0"
										aria-valuemax="100" style="width: 50%">50%</div>
								</div>
								50 % complete&nbsp;&nbsp;1 open&nbsp;&nbsp;1 close
							</div> <br> <br> <br>
						</li>
						</c:forEach>
							</c:otherwise></c:choose>
					</ul>

				</div>


			</div>
		</form>
		<form action="MilestoneController.do" method="post" class="form-horizontal">
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
							<input type="text" name="milestoneName" class="form-control">
							<br>
							<label for="comment">Description :</label>
							<textarea class="form-control" name="milestoneDescription" rows="5" id="comment"></textarea>
		<input id="i" type="hidden" name="projectID" value="<c:out value="${project.projectID}" />">
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