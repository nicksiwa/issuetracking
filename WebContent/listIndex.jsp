<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<table class="table table-hover table-responsive table-striped">
			<thead>
				<tr>
					<th>Issue ID</th>
					<th>Project</th>
					<th>Assign To</th>
					<th>Title</th>
					<th>Description</th>
					<th>Severity</th>
					<th>Priority</th>
					<th>Due Date</th>
					<th>Update Date</th>

					<th>Status</th>
					<th>Reporter</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${indexs}" var="index">
					<tr>

						<td><c:out value="${index.assignName}"></c:out></td>
						<td><c:out value="${index.assignProject}"></c:out></td>
						<td><c:out value="${index.assignTitle}"></c:out></td>
				

					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>