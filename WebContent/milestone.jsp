<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.text.NumberFormat" %>
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
			<h2>
				<span class="label label-primary"><c:out value="${project.projectName }"/></span><small>
					<c:out value="${project.owner }"/></small>
			</h2>
			<br>
			<ul class="nav nav-tabs">
				<li class="active"><a
					href="MilestoneController.do?action=milestone&projectID=<c:out value="${project.projectID }"/>">Project
						milestone / Project road map</a></li>
				<li><a href="IssueController.do?action=report&projectID=<c:out value="${project.projectID }"/>">Project report</a></li>
				<li><a
					href="ReportController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Graph</a></li>
				<li><a href="TaskController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Project task</a></li>
				<li><a
					href="LabelController.do?action=label&projectID=<c:out value="${project.projectID }"/>">Issue
						labels</a></li>
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
									
									<input type="hidden" name="milestoneID" value="<c:out value="${milestone.milestoneID}" />">

										<div class="col-md-6">
											<h5>
												<c:out value="${milestone.milestoneName}" />
											</h5>
											<p>
												<c:out value="${milestone.milestoneDescription}" />
											</p>
										</div> 
										
										
										
									<c:set var="count" value="0" scope="page" />
										<c:forEach items="${percent}" var="percents">
											<c:choose>
												<c:when
													test="${milestone.milestoneID==percents.milestoneID}">
														<c:set var="count" value="${count + 1}" scope="page"/>
												</c:when>
													
											</c:choose>
											
										</c:forEach>
										
									<c:set var="count2" value="0" scope="page" />
										<c:forEach items="${percentClosed}" var="per">
											<c:choose>
												<c:when
													test="${milestone.milestoneID==per.milestoneID}">
														<c:set var="count2" value="${count2 + 1}" scope="page"/>
												</c:when>
											</c:choose>
										</c:forEach>
										

								
								
									
									<c:set var="count3" value="${(count2/count)*100}" scope="page"/>
									<c:set var="count4" value="${(count-count2)}" scope="page"/>
									
									
						

										<div class="col-md-6">
											<div class="progress">
												<div class="progress-bar progress-bar-success"
													role="progressbar" style="width: <c:out value="${count3}"/>%">50%</div>
											</div><span class="pull-right"><a class="confirmation" href="MilestoneController.do?action=delete&milestoneID=<c:out value="${milestone.milestoneID}" />&projectID=<c:out value="${project.projectID }"/>"><span class="glyphicon glyphicon-remove" style="color:red"></span></a></span>
											
											<c:choose>
												<c:when test="${count3=='NaN'}">
												<fmt:formatNumber value="0" maxFractionDigits="2" minFractionDigits="2"/> % complete&nbsp;&nbsp;<c:out value="${count4}"/> opened&nbsp;&nbsp;<c:out value="${count2}"/> closed
												</c:when>
												<c:otherwise>
												<fmt:formatNumber value="${count3}" maxFractionDigits="2" minFractionDigits="2"/> % complete&nbsp;&nbsp;<c:out value="${count4}"/> opened&nbsp;&nbsp;<c:out value="${count2}"/> closed
												</c:otherwise>
											</c:choose>
											
										</div> <br> <br> <br>
									</li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>

				</div>


			</div>
		</form>
		<form action="MilestoneController.do" method="post"
			class="form-horizontal">
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">New milestone</h4>
						</div>
						<div class="modal-body">


							<label for="comment">Title :</label> <input type="text"
								name="milestoneName" class="form-control"> <br> <label
								for="comment">Description :</label>
							<textarea class="form-control" name="milestoneDescription"
								rows="5" id="comment"></textarea>
							<input id="i" type="hidden" name="projectID"
								value="<c:out value="${project.projectID}" />">
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


<script type="text/javascript">
    $('.confirmation').on('click', function () {
        return confirm('Are you sure?');
    });
	</script>

	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>