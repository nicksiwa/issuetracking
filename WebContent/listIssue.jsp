<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Issue</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body class="sansserif">
	<p>
		<a href="IssueController.do?action=insert">Add Issue</a>
	</p>
	<table>
		<thead>
			<tr>
				<th>Issue ID</th>
				<th>Title</th>
				<th>Description</th>
				<th>Severity</th>
				<th>Priority</th>
				<th>Due Date</th>
				<th>Update Date</th>
				<th>Attach File</th>
				<th>Status</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${issues}" var="issue">
				<tr>
			
					<td><c:out value="${issue.issueID}"></c:out></td>
					<td><c:out value="${issue.title}"></c:out></td>
					<td><c:out value="${issue.description}"></c:out></td>
					<td><c:out value="${issue.severity}"></c:out></td>
					<td><c:out value="${issue.priority}"></c:out></td>
					<td><fmt:formatDate pattern="dd-MM-yyy" value="${issue.dueDate}" /></td>
					<td><c:out value="${issue.attachFile}"></c:out></td>
					<td><c:out value="${issue.status}"></c:out></td>
					<td><a
						href="IssueController.do?action=edit&issueID=<c:out value="${issue.issueID }"/>">Update</a></td>
					<td><a
						href="IssueController.do?action=delete&issueID=<c:out value="${issue.issueID }"/>">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>