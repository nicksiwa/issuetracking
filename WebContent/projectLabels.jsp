<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			<h2>
				<span class="label label-primary"><c:out value="${project.projectName }"/></span><small>
					project owner</small>
			</h2>
			<br>
			<ul class="nav nav-tabs">
				<li><a href="MilestoneController.do?action=milestone&projectID=<c:out value="${project.projectID }"/>">Project
						milestone / Project road map</a></li>
				<li><a href="IssueController.do?action=report&projectID=<c:out value="${project.projectID }"/>">Project report</a></li>
				<li><a
					href="ReportController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Graph</a></li>
				<li><a href="TaskController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Project task</a></li>
				<li class="active"><a href="LabelController.do?action=label&projectID=<c:out value="${project.projectID }"/>">Issue
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

						<c:choose>
							<c:when test="${fn:length(labels)=='0'}">
								<li class="list-group-item">No have any label</li>
							</c:when>
							<c:otherwise>

								<c:forEach items="${labels}" var="label">

									<li class="list-group-item">
										<h4>
											<span class="label <c:out value="${label.labelType}" />"><span
												class="glyphicon glyphicon-tag"></span> <c:out
													value="${label.labelName}" /></span> <small><span
												class="pull-right"><a href=""><span
														class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
													href="LabelController.do?action=delete&labelID=<c:out value="${label.labelID}" />&projectID=<c:out value="${label.labelProject}" />"><span class="glyphicon glyphicon-remove"></span></a></span></small>
										</h4>
										
										<input id="i" type="hidden" name="projectID" value="<c:out value="${label.labelProject}" />">

									</li>


								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</form>
		<form action="LabelController.do" method="post"
			class="form-horizontal">
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
								name="labelName" class="form-control"> <br> <label
								for="comment">Select type :</label>

							<div class="radio-inline">
								<label><input type="radio" name="labelType" value="label-default"><span class="label label-default">Default Label</span></label>
								<label><input type="radio" name="labelType" value="label-primary"><span class="label label-primary">Primary Label</span></label>
								<label><input type="radio" name="labelType" value="label-success"><span class="label label-success">Success Label</span></label>
								<label><input type="radio" name="labelType" value="label-info"><span class="label label-info">Info Label</span></label>
								<label><input type="radio" name="labelType" value="label-warning"><span class="label label-warning">Warning Label</span></label>
								<label><input type="radio" name="labelType" value="label-danger"><span class="label label-danger">Danger Label</span></label>
							</div>

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