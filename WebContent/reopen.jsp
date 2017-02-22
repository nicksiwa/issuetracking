<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Closed issue</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<form action="" class="form-horizontal">
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-search"></span> <b>View
								Issue Details : <span class="label label-success"><c:out
										value="${issue.title}" /></span>
							</b>
						</h4>
					</div>
					<div class="panel-body">
						<table class="table table-hover table-responsive table-striped">
							<thead>
								<tr>
									<th>Issue id</th>
									<th>Project</th>
									<th>Title</th>
									<th>Due date</th>
									<th>Update date</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td id="i"><c:out value="${issue.issueID}" /></td>

									<td><c:out value="${issue.project}" /><input
										type="hidden" name="project" class="form-control"
										value="<c:out value="${issue.project}" />"
										placeholder="project" /></td>
									<td><c:out value="${issue.title}" /><input type="hidden"
										name="title" class="form-control"
										value="<c:out value="${issue.title}" />" placeholder="title" /></td>
									<fmt:setLocale value="en_US" />
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${issue.dueDate}" /></td>
									<td><fmt:parseDate value="${issue.updateDate}"
											pattern="yyyy-MM-dd HH:mm:ss" var="myDate" /> <fmt:formatDate
											value="${myDate}" pattern="dd/MM/yyyy HH:mm:ss" /><input
										type="hidden" id="date" name="updateDate" class="form-control"
										value="<c:out value="${issue.updateDate}" />"
										placeholder="updateDate" /></td>
								</tr>
							</tbody>
						</table>
						<hr>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2">Reporter
								:</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">
									<c:out value="${issue.reporter}"></c:out>
									<input type="hidden" name="reporter" class="form-control"
										value="<c:out value="${issue.reporter}" />"
										placeholder="reporter" />
								</p>
							</div>

							<label for="tile" class="control-label col-sm-3">Assigned
								to :</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">
									<c:out value="${issue.assign}" />
									<input type="hidden" name="assign" class="form-control"
										value="<c:out value="${issue.assign}" />" placeholder="assign" />
								</p>
							</div>
						</div>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2">Severity
								:</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">
									<c:out value="${issue.severity}"></c:out>
									<input type="hidden" name="severity" class="form-control"
										value="<c:out value="${issue.severity}" />"
										placeholder="severity" />
								</p>
							</div>

							<label for="tile" class="control-label col-sm-3">Priority
								:</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">
									<c:out value="${issue.priority}"></c:out>
									<input type="hidden" name="priority" class="form-control"
										value="<c:out value="${issue.priority}" />"
										placeholder="priority" />
								</p>
							</div>
						</div>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2">Status :</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<p class="form-control-static">
									<c:out value="${issue.status}"></c:out>
								</p>
							</div>
						</div>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2">Description
								:</label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<textarea readonly name="description" class="form-control"
									rows="5" id="description" placeholder="Description"><c:out
										value="${issue.description}"></c:out></textarea>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="tile" class="control-label col-sm-2"></label>
							<div class="col-sm-3 col-lg-2 col-md-2">
								<a
									href="CommentController.do?action=reopenissue&issueID=<c:out value="${issue.issueID}"/>"
									class="btn btn-success" role="button">Reopen issue</a>

							</div>
						</div>

					</div>
				</div>
			</div>


			<div class="col-md-3">
				<div class="panel panel-default">

					<ul class="list-group">
						<c:choose>
							<c:when test="${fn:length(milestoneAssigns)=='0'}">
								<li class="list-group-item">No have any milestone</li>
							</c:when>
							<c:otherwise>
								<c:forEach items="${milestoneAssigns}" var="milestone">
									<li class="list-group-item"><c:out
											value="${milestone.milestoneName}" /> <small><span
											class="pull-right"><a href=""><span
													class="glyphicon glyphicon-remove"></span></a></span></small> <input id="i"
										type="hidden" name="projectID"
										value="<c:out value="${milestone.milestoneProject}" />">
									</li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>

			<div class="col-md-3">
				<div class="panel panel-default">
					<ul class="list-group">
						<c:choose>
							<c:when test="${fn:length(labelAssigns)=='0'}">
								<li class="list-group-item">No have any label</li>
							</c:when>
							<c:otherwise>

								<c:forEach items="${labelAssigns}" var="label">
									<li class="list-group-item"><span
										class="label <c:out value="${label.labelType}" />"><span
											class="glyphicon glyphicon-tag"></span> <c:out
												value="${label.labelName}" /></span> <small><span
											class="pull-right"><a href=""><span
													class="glyphicon glyphicon-remove"></span></a></span></small> <input id="i"
										type="hidden" name="projectID"
										value="<c:out value="${label.labelProject}" />"></li>
								</c:forEach>

							</c:otherwise>
						</c:choose>


					</ul>
				</div>
			</div>

		</form>
		
		
		
		<form action="" method="post" class="form-horizontal">
		<div class="container">
			<div class="col-md-8">

				<c:forEach items="${comments}" var="comment">
					<c:choose>
						<c:when test="${comment.commentDetail=='closed issue on'||comment.commentDetail=='re-opened issue on'}">
						<br>
					<div>
						<span class="glyphicon <c:out value="${comment.commentIcon}"/>" style="color:<c:out value="${comment.commentIconColor}"/>; font-size:1.5em;"></span>
						&nbsp;
							<b><c:out value="${comment.userComment}"></c:out></b>
							<c:out value="${comment.commentDetail}"></c:out>
							<fmt:parseDate value="${comment.commentTime}"
								pattern="yyyy-MM-dd HH:mm:ss" var="myDate" />
							<fmt:formatDate value="${myDate}" pattern="dd/MM/yyyy HH:mm:ss" /></div>
							<br>
						</c:when>
						<c:otherwise>
						<br>
							<div class="panel panel-default">
								<div class="panel-heading">
									<b><c:out value="${comment.userComment}"></c:out><span>&nbsp&nbsp&nbsp</span>
										<fmt:parseDate value="${comment.commentTime}"
											pattern="yyyy-MM-dd HH:mm:ss" var="myDate" /> <span
										class="glyphicon glyphicon-time"></span> <fmt:formatDate
											value="${myDate}" pattern="dd/MM/yyyy HH:mm:ss" /> </b>
								</div>
								<div class="panel-body">
									<div class="form-group">
										<label for="tile" class="control-label col-sm-2">Description
											:</label>
										<div class="col-sm-6 col-lg-4 col-md-4">
											<p class="form-control-static">
												<c:out value="${comment.commentDetail}"></c:out>
											</p>
										</div>

										<label for="tile" class="control-label col-sm-2">Status
											:</label>
										<div class="col-sm-3 col-lg-2 col-md-2">
											<p class="form-control-static">
												<c:out value="${comment.commentStatus}"></c:out>
											</p>
										</div>

									</div>
								</div>
							</div>

						</c:otherwise>
					</c:choose>
				</c:forEach>

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