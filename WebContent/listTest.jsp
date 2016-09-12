<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body class="sansserif">

<p>
		<a href="TestController.do?action=insert">Add Test</a>
	</p>

<table>
		<thead>
			<tr>
				<th>Test ID</th>
				<th>File</th>

				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tests}" var="test">
				<tr>
					<td><c:out value="${test.testID}"></c:out></td>
					<td><c:out value="${test.file}"></c:out></td>
	
					<td><a
						href="TestController.do?action=edit&testID=<c:out value="${test.testID }"/>">Update</a></td>
					<td><a
						href="TestController.do?action=delete&testID=<c:out value="${test.testID }"/>">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>