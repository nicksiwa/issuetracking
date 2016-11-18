<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<br>
		<p>
			<a href="TestController.do?action=insert">Add Test</a>
		</p>
		<p>
			<a href="TestController.do?action=status&status=resolved">Status</a>
		</p>

		<c:forEach items="${tests}" var="test">
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div class="caption">
						<div class="thumbnail">
							<c:out value="${test.testID}"></c:out>
							<c:out value="${test.testName}"></c:out>
							<c:out value="${test.testProject}"></c:out>

						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>