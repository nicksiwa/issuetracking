<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body class="sansserif">
<p>
		<a href="CommentController.do?action=insert">Add Comment</a>
	</p>
	<table>
		<thead>
			<tr>
				<th>Comment ID</th>
				<th>Description</th>
				<th>Status</th>
				<th>Comment Time</th>

				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${comments}" var="comment">
				<tr>
					<td><c:out value="${comment.commentID}"></c:out></td>
					<td><c:out value="${comment.description}"></c:out></td>
					<td><c:out value="${comment.status}"></c:out></td>
					<td><c:out value="${comment.commentTime}"></c:out></td>
	
					<td><a
						href="CommentController.do?action=edit&commentID=<c:out value="${comment.commentID }"/>">Update</a></td>
					<td><a
						href="CommentController.do?action=delete&commentID=<c:out value="${comment.commentID }"/>">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>