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
		
		
		
		<div class="col-md-12">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3>
								<span class="glyphicon glyphicon-list-alt"></span>Test Show 3 Recent<span class="pull-right"><h4>
										<span class="badge">${fn:length(recents)}</span> Issues
									</h4></span>
							</h3>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach begin="0" end="2" items="${recents}" var="index1">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index1.issueID}"/>"
										class="list-group-item">
										<p class="list-group-item-heading">
										<h4>
											<c:out value="${index1.title}"></c:out>
										</h4> <span class="pull-right"><c:out
												value="${index1.updateDate}"></c:out></span>
										</p>
										<p class="list-group-item-text">
											From Project :
											<c:out value="${index1.project}"></c:out>s
										</p>

									</a>
								</c:forEach>

							</div>
							<button type="button" class="btn btn-default">Default</button>
						</div>
					</div>
				</div>
			</div>
		
		
		
			<div class="col-md-12">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3>
								<span class="glyphicon glyphicon-list-alt"></span> Assigned to
								Me<span class="pull-right"><h4>
										<span class="badge">${fn:length(indexs)}</span> Issues
									</h4></span>
							</h3>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach items="${indexs}" var="index">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
										class="list-group-item">
										<p class="list-group-item-heading">
										<h4>
											<c:out value="${index.title}"></c:out>
										</h4> <span class="pull-right"><c:out
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
			<div class="col-md-12">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3>
								<span class="glyphicon glyphicon-edit"></span> Report by Me<span
									class="pull-right"><h4>
										<span class="badge">${fn:length(reports)}</span> Issues
									</h4></span>
							</h3>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach items="${reports}" var="index">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
										class="list-group-item">
										<p class="list-group-item-heading">
										<h4>
											<c:out value="${index.title}"></c:out>
										</h4> <span class="pull-right"><c:out
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
			<div class="col-md-12">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3>
								<span class="glyphicon glyphicon-check"></span> Resolved<span
									class="pull-right"><h4>
										<span class="badge">${fn:length(resolves)}</span> Issues
									</h4></span>
							</h3>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach items="${resolves}" var="index">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
										class="list-group-item">
										<p class="list-group-item-heading">
										<h4>
											<c:out value="${index.title}"></c:out>
										</h4> <span class="pull-right"><c:out
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
			<div class="col-md-12">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3>
								<span class="glyphicon glyphicon-time"></span> Recently Modified<span
									class="pull-right"><h4>
										<span class="badge">${fn:length(recents)}</span> Issues
									</h4></span>
							</h3>

						</div>
						<div class="panel-body">
							<div class="list-group">


								<c:forEach items="${recents}" var="index">
									<a
										href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>	"
										class="list-group-item">
										<p class="list-group-item-heading">
										<h4>
											<c:out value="${index.title}"></c:out>
										</h4> <span class="pull-right"><c:out
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