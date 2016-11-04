<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet">


</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="" class="form-horizontal">



			<div class="col-md-7">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-list-alt"></span> <b>Assigned
								to Me</b><small><span class="pull-right"> <span
									class="badge">${fn:length(indexs)}</span> Issues
							</span></small>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">


							<c:forEach begin="0" end="2" items="${indexs}" var="index">
								<a
									href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
									class="list-group-item" data-toggle="tooltip"
									data-placement="top"
									title="Click to change status or view issue detail">
									<p class="list-group-item-heading ">
										<b> <c:out value="${index.title}"></c:out>
										</b> <small><span class="pull-right"><font
												color="gray"><c:out value="${index.updateDate}"></c:out></font></span></small>
									</p>
									<p class="list-group-item-text">
										From Project :
										<c:out value="${index.project}"></c:out>
									</p>


								</a>
							</c:forEach>

						</div>
						<a href="IndexController.do?action=allassign" class="btn btn-default" role="button">View all
							issues</a>
					</div>
				</div>




				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-edit"></span> <b>Report by
								Me</b><span class="pull-right"><small> <span
									class="badge">${fn:length(reports)}</span> Issues
							</small></span>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">


							<c:forEach begin="0" end="2" items="${reports}" var="index">
								<a
									href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
									class="list-group-item">
									<p class="list-group-item-heading">
										<b> <c:out value="${index.title}"></c:out>
										</b> <small><span class="pull-right"><font
												color="gray"><c:out value="${index.updateDate}"></c:out></font></span></small>
									</p>
									<p class="list-group-item-text">
										From Project :
										<c:out value="${index.project}"></c:out>
									</p>

								</a>
							</c:forEach>

						</div>
						<a href="IndexController.do?action=allreport" class="btn btn-default" role="button">View all
							issues</a>
					</div>
				</div>



				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-check"></span> <b>Resolved</b><span
								class="pull-right"><small> <span class="badge">${fn:length(resolves)}</span>
									Issues
							</small></span>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">


							<c:forEach begin="0" end="2" items="${resolves}" var="index">
								<a
									href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
									class="list-group-item">
									<p class="list-group-item-heading">
										<b> <c:out value="${index.title}"></c:out>
										</b> <small><span class="pull-right"><font
												color="gray"><c:out value="${index.updateDate}"></c:out></font></span></small>
									</p>
									<p class="list-group-item-text">
										From Project :
										<c:out value="${index.project}"></c:out>
									</p>
								</a>
							</c:forEach>

						</div>
						<a href="#" class="btn btn-default" role="button">View all
							issues</a>
					</div>
				</div>



				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-time"></span> <b>Recently
								Modified</b><span class="pull-right"><small> <span
									class="badge">${fn:length(recents)}</span> Issues
							</small></span>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">


							<c:forEach begin="0" end="2" items="${recents}" var="index">
								<a
									href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>	"
									class="list-group-item">
									<p class="list-group-item-heading">
										<b> <c:out value="${index.title}"></c:out>
										</b> <small><span class="pull-right"><font
												color="gray"><c:out value="${index.updateDate}"></c:out></font></span></small>
									</p>
									<p class="list-group-item-text">
										From Project :
										<c:out value="${index.project}"></c:out>
									</p>
								</a>
							</c:forEach>

						</div>
						<a href="#" class="btn btn-default" role="button">View all
							issues</a>
					</div>
				</div>

			</div>

			<div class="col-md-4 col-md-offset-1">

				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Project you contribute to</b> <span class="badge">${fn:length(projects)}</span>
					</div>



					<ul class="list-group">
						<c:forEach items="${projects}" var="index">
							<li class="list-group-item text-primary"><c:out
									value="${index.project}"></c:out><a
							href="IssueController.do?action=insert&project=<c:out value="${index.projectID}"/>"
							class="btn btn-success btn-xs pull-right" role="button">New
							Issue</a></li>
						</c:forEach>
					</ul>


				</div>


				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Your feed</b> <span class="badge">999+</span><a href="#"><span
							class="pull-right"><small>View all</small></span></a>
					</div>
					<ul class="list-group">
						<li class="list-group-item text-primary"><a href="#"
							data-toggle="tooltip" data-placement="top" title="Hooray!">Edit
								Front-end </a><span class="pull-right"><small><font
									color="gray">27/10/2016 13:44:45</font></small></span></li>
						<li class="list-group-item text-primary">Onii-Chan!!! <span
							class="pull-right"><small><font color="gray">27/10/2016
										13:44:45</font></small></span></li>
						<li class="list-group-item text-primary">Oh Ahh <span
							class="pull-right"><small><font color="gray">27/10/2016
										13:44:45</font></small></span></li>
						<li class="list-group-item text-primary"><a href="#"
							data-toggle="tooltip" data-placement="top" title="Hooray!">Edit
								Front-end </a><span class="pull-right"><small><font
									color="gray">27/10/2016 13:44:45</font></small></span></li>
						<li class="list-group-item text-primary">Onii-Chan!!! <span
							class="pull-right"><small><font color="gray">27/10/2016
										13:44:45</font></small></span></li>
						<li class="list-group-item text-primary">Oh Ahh <span
							class="pull-right"><small><font color="gray">27/10/2016
										13:44:45</font></small></span></li>
					</ul>

				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Some stat</b>
					</div>
					<div class="panel-body">Some stat</div>
				</div>

			</div>
		</form>

	</div>

	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>