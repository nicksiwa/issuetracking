<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Project</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body class="sansserif">
	<p>
		<a href="ProjectController.do?action=insert">Add Project</a>
	</p>

	<table>
		<thead>
			<tr>
				<th>Project ID</th>
				<th>Project Name</th>
				<th>Project Status</th>
				<th>Description</th>
				<th>Start Date</th>
				<th>Finish Date</th>
			
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${projects}" var="project">
				<tr>
					<td><c:out value="${project.projectID}"></c:out></td>
					<td><c:out value="${project.projectName}"></c:out></td>
					<td><c:out value="${project.status}"></c:out></td>
					<td><c:out value="${project.description}"></c:out></td>
					<td><fmt:formatDate pattern="dd-MM-yyy" value="${project.startDate}" /></td>
					<td><fmt:formatDate pattern="dd-MM-yyy" value="${project.finishDate}" /></td>

					
					<td><a
						href="ProjectController.do?action=edit&projectID=<c:out value="${project.projectID }"/>">Update</a></td>
					<td><a
						href="ProjectController.do?action=delete&projectID=<c:out value="${project.projectID }"/>">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>