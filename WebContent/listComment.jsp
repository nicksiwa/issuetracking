<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Comments</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<br>
		<p>
			<a href="CommentController.do?action=insert">Add Comment</a>
		</p>
		<table class="table table-hover table-responsive table-striped">
			<thead>
				<tr>
					<th>Comment ID</th>
					<th>Comment Detail</th>
					<th>Comment Status</th>
					<th>Comment Time</th>
					<th>Username</th>
					<th>Issue ID</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${comments}" var="comment">
					<tr>
						<td><c:out value="${comment.commentID}"></c:out></td>
						<td><c:out value="${comment.commentDetail}"></c:out></td>
						<td><c:out value="${comment.commentStatus}"></c:out></td>
						<td><fmt:parseDate value="${comment.commentTime}"
										pattern="yyyy-MM-dd HH:mm:ss" var="myDate" /> <fmt:formatDate
										value="${myDate}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td><c:out value="${comment.userComment}"></c:out></td>
						<td><c:out value="${comment.issueID}"></c:out></td>
						<td><a
							href="CommentController.do?action=edit&commentID=<c:out value="${comment.commentID }"/>">Update</a></td>
						<td><a
							href="CommentController.do?action=delete&commentID=<c:out value="${comment.commentID }"/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>