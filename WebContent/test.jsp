<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

	<jsp:include page="navbar.jsp" />

	<form action="TestController.do" method="post">
		<div>
			<input type="hidden" name="testID"
				value="<c:out value="${test.testID}" />" readonly="readonly"
				placeholder="Auto generate ID" /> <br> <br>
			<div class="form-group">


				<select name="testName" class="form-control">
					<c:forEach var="test" items="${testss}">
						<option><c:out value="${test.testName}" /></option>
					</c:forEach>
				</select> <select name="testProject" class="form-control">
					<c:forEach var="test" items="${testss}">
						<option><c:out value="${test.testProject}" /></option>
					</c:forEach>
				</select>


			</div>
			<br> <input type="submit" class="btn btn-default" value="Submit" />
		</div>

	</form>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>