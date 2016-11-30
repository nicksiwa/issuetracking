<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<style>
</style>
</head>
<body>

	<jsp:include page="navbar.jsp" />
	<div class="container">
	
	
		<form action="" class="form-horizontal">
		

			<div class="col-md-12">
			<a href="ProjectController.do?action=insert" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> &nbsp;New Project</a>
			<hr>
				<table class="table table-bordered table-striped">
					<tbody>
						<c:forEach items="${projects}" var="project">
						<input id="i" type="hidden" value="<c:out value="${project.projectID}" />">
						<tr>
							<th style="padding: 30px;"><a><c:out value="${project.projectName}"></c:out></a> <span
								class="pull-right"><a class="text-muted" href="ProjectController.do?action=config&projectID=<c:out value="${project.projectID }"/>"><span
										class="glyphicon glyphicon-cog"></span></a>&nbsp;&nbsp;&nbsp;<a
									class="text-info" href="ProjectController.do?action=edit&projectID=<c:out value="${project.projectID }"/>"><span class="glyphicon glyphicon-edit"></span></a>&nbsp;&nbsp;&nbsp;
									<a href="ProjectController.do?action=delete&projectID=<c:out value="${project.projectID }"/>" class="text-danger" ><span class="glyphicon glyphicon-trash"></span></a></span></th>
							<td style="padding: 30px;">
								<div class="col-md-4">&nbsp;&nbsp;&nbsp;
								<span class="label label-success">5</span>
								<span class="label label-default">10</span> <a href="#">Assigned to Me</a></div>
								<div class="col-md-4">&nbsp;&nbsp;&nbsp;
								<span class="label label-success">5</span>
								<span class="label label-default">10</span> <a href="#">Unassigned</a></div>
								<div class="col-md-4">
								&nbsp;&nbsp;&nbsp;
								<span class="label label-success">5</span>
								<span class="label label-default">10</span> <a href="#">All Issue</a></div>
								</td>

						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
		</div>
	
<script>
function myFunction() {
	var id = $('#i').html();
	var link = "http://localhost:8080/Project/ProjectController.do?action=delete&projectID=";
	var result = link + id;
	  var ask = window.confirm("Are you sure you want to delete this post?");
	    if (ask) {
	        window.alert("This post was successfully deleted.");
	        document.location.href = result;
	    }else{
	    	
	    }
}

</script>
</body>
</html>