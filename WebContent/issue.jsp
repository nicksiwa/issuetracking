<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Issue</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">

</head>
<body class="sansserif">
<form action="PersonController.do" method="post">
<div>
<input type="hidden"
					name="issueID" value="<c:out value="${issue.issueID}" />"
					readonly="readonly" placeholder="Auto generate ID" />
		<br><br>
		<label for="title">Title</label><br> <input type="text"
					name="title" value="<c:out value="${issue.title}" />"
					placeholder="Tiltle" />
		<br><br>
		<label for="description">Description</label><br> <input type="text"
					name="description" value="<c:out value="${issue.description}" />"
					placeholder="Description" />
		<br><br>
			<label for="severity">Severity</label><br> <input type="text"
					name="severity" value="<c:out value="${issue.severity}" />"
					placeholder="Severity" />
		<br><br>
			<label for="priority">Priority</label><br> <input type="text"
					name="priority" value="<c:out value="${issue.priority}" />"
					placeholder="Priority" />
		<br><br>
</div>
</form>

</body>
</html>