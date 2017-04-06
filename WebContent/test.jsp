<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project name</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css"
	media="screen" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<c:forEach items="${dates}" var="date">
		<c:choose>
			<c:when test="${date.dueDateChecker<='0'}">
      			Not yet due date <c:out value="${date.dueDateChecker}" /><br>
   								</c:when>
			<c:otherwise>
			Pass due date by <c:out value="${date.dueDateChecker}" /><br>
			</c:otherwise>
		</c:choose>


	</c:forEach>



	<form class="form-horizontal" role="form" method="post"
		name="employeeForm" id="employeeForm">
		<div class="row">
			<div class="alert center-text" role="alert" id="alert"></div>
		</div>
		<div class="form-group">
			<label for="description" class="col-lg-3 control-label">Description</label>
			<div class="col-lg-9">
				<input type="text" name="taskID" id="taskID" placeholder="taskID" />
				<input id="projectID" type="text" name="projectID"
					placeholder="projectID" />
				<textarea class="form-control" name="taskDetail" id="taskDetail"
					placeholder="Description" cols="10" rows="5"></textarea>
			</div>
			<input type="hidden" name="createDate"
				value="<c:out value="${task.createDate}" />"
				placeholder="Comment Time" />
		</div>
	</form>



	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			function getItems(exampleNr) {
				var columns = [];

				$(exampleNr + ' ul.sortable-list').each(function() {
					columns.push($(this).sortable('toArray').join(','));
				});

				return columns.join('|');
			}

			$('#btn-get').click(function() {
				alert(getItems('#example-1-2'));
			});

			$('#example-1-2 .sortable-list').sortable({
				connectWith : '#example-1-2 .sortable-list'
			});

		});

		$(document).ready($('.form-control').change(function() {
			$.ajax({
				type : "post",
				url : "TaskController",
				cache : false,
				data : $('#employeeForm').serialize(),
				success : function(response) {
					alert('SS');
				},
				error : function() {
					alert('Error while request..');
				}
			});
		}));
	</script>
	<script type="text/javascript">
	$.ajax({
		type : "get",
		url : "AjaxTaskController",
		cache : false,
		data : $('#employeeForm').serialize(),
		success : function(response) {
			alert();
		},
		error : function() {
			alert('Error while request..');
		}

	});
	</script>
</body>
</html>