<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>

<body class="sansserif">
	<form action="TestController.do" method="post">
		<div>
			<input type="hidden" name="testID"
				value="<c:out value="${test.testID}" />" readonly="readonly"
				placeholder="Auto generate ID" /> <br>
			<br> <label for="file">File</label><br> <input type="file"
				name="file" value="<c:out value="${test.file}" />" /> <input
				type="submit" value="Submit" />
		</div>
	</form>
</body>
</html>