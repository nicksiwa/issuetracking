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

	<form action="TestController.do" method="post"
		enctype="multipart/form-data">
		<c:forEach items="${tests}" var="test">
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div class="caption">
						<div class="thumbnail">
							<c:out value="${test.testID}"></c:out>
							<c:out value="${test.testProject}"></c:out>
							<c:out value="${test.testStatus}"></c:out>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</form>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>