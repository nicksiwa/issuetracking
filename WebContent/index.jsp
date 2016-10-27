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
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="" class="form-horizontal">



<div class="col-md-8">
			
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>
								<span class="glyphicon glyphicon-list-alt"></span> <b>Assigned to
								Me</b><span class="pull-right"><h5>
										<span class="badge">${fn:length(indexs)}</span> Issues
									</h5></span>
							</h4>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach begin="0" end="2" items="${indexs}" var="index">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
										class="list-group-item">
										<p class="list-group-item-heading">
										<b>
											<c:out value="${index.title}"></c:out>
										</b> <span class="pull-right"><c:out
												value="${index.updateDate}"></c:out></span>
										</p>
										<p class="list-group-item-text">
											From Project :
											<c:out value="${index.project}"></c:out>
										</p>

									</a>
								</c:forEach>

							</div>
							<button type="button" class="btn btn-default">Default</button>
						</div>
					</div>
				</div>
			
			
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>
								<span class="glyphicon glyphicon-edit"></span> <b>Report by Me</b><span
									class="pull-right"><h5>
										<span class="badge">${fn:length(reports)}</span> Issues
									</h5></span>
							</h4>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach begin="0" end="2" items="${reports}" var="index">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
										class="list-group-item">
										<p class="list-group-item-heading">
										<b>
											<c:out value="${index.title}"></c:out>
										</b> <span class="pull-right"><c:out
												value="${index.updateDate}"></c:out></span>
										</p>
										<p class="list-group-item-text">
											From Project :
											<c:out value="${index.project}"></c:out>
										</p>

									</a>
								</c:forEach>

							</div>
							<button type="button" class="btn btn-default">Default</button>
						</div>
					</div>
				</div>
			
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>
								<span class="glyphicon glyphicon-check"></span> <b>Resolved</b><span
									class="pull-right"><h5>
										<span class="badge">${fn:length(resolves)}</span> Issues
									</h5></span>
							</h4>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach begin="0" end="2" items="${resolves}" var="index">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
										class="list-group-item">
										<p class="list-group-item-heading">
										<b>
											<c:out value="${index.title}"></c:out>
										</b> <span class="pull-right"><c:out
												value="${index.updateDate}"></c:out></span>
										</p>
										<p class="list-group-item-text">
											From Project :
											<c:out value="${index.project}"></c:out>
										</p>
									</a>
								</c:forEach>

							</div>
							<button type="button" class="btn btn-default">Default</button>
						</div>
					</div>
				</div>
			
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>
								<span class="glyphicon glyphicon-time"></span> <b>Recently Modified</b><span
									class="pull-right"><h5>
										<span class="badge">${fn:length(recents)}</span> Issues
									</h5></span>
							</h4>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach begin="0" end="2" items="${recents}" var="index">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>	"
										class="list-group-item">
										<p class="list-group-item-heading">
										<b>
											<c:out value="${index.title}"></c:out>
										</b> <span class="pull-right"><c:out
												value="${index.updateDate}"></c:out></span>
										</p>
										<p class="list-group-item-text">
											From Project :
											<c:out value="${index.project}"></c:out>
										</p>
									</a>
								</c:forEach>

							</div>
							<button type="button" class="btn btn-default">Default</button>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
			
					<div class="panel panel-default">
						<div class="panel-heading">	
							Project you contribute to <span class="badge">999+</span><span class="pull-right"><a class="btn btn-success btn-xs" role="button">New Issue</a></span>
							</div>
						<div class="panel-body">
						<div class="list-group">
							<a href="#" class="list-group-item">First item</a>
							<a href="#" class="list-group-item">First item</a>
							<a href="#" class="list-group-item">First item</a>
						</div>
					</div>
					</div>
			
					<div class="panel panel-default">
						<div class="panel-heading">	
							Your feed <span class="badge">999+</span>
							</div>
						<div class="panel-body"><a>New Issue</a></div>
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