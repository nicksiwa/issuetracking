<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Issues</title>
<link href="css/bootstrap.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<form action="" class="form-horizontal">

			<c:forEach items="${reports}" var="index">
				<a
					href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
					class="list-group-item" data-toggle="tooltip" data-placement="top"
					title="Click to change status or view issue detail">
					<p class="list-group-item-heading ">
						<b> <c:out value="${index.title}"></c:out>
						</b> <small><span class="pull-right"><font color="gray"><c:out
										value="${index.updateDate}"></c:out></font></span></small>
					</p>
					<p class="list-group-item-text">
						From Project :
						<c:out value="${index.project}"></c:out>
					</p>


				</a>
			</c:forEach>

		</form>
	</div>


	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>