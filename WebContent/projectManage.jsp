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
			<a href="" class="btn btn-default"><span class="glyphicon glyphicon-folder-open"></span> New Project</a>
			<br>
				<table class="table table-bordered table-striped">
					<tbody>
						<%
							for (int i = 0; i < 10; i++) {
						%>

						<tr>
							<th style="padding: 30px;"><a>First Name</a> <span
								class="pull-right"><a class="text-muted" href="#"><span
										class="glyphicon glyphicon-cog"></span></a>&nbsp;&nbsp;&nbsp;<a
									class="text-info" href="#"><span class="glyphicon glyphicon-edit"></span></a>&nbsp;&nbsp;&nbsp;<a
									class="text-danger" href="#"><span class="glyphicon glyphicon-trash"></span></a></span></th>
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
						<%
							}
						%>
					</tbody>
				</table>
			</div>

		</form>
	</div>

</body>
</html>