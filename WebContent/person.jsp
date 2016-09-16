<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Add New Person</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<script>
		$(function() {
			$('input[name=birthDate]').datepicker();

		});
	</script>
	<div class="container">
<ul class="nav nav-tabs" role="tablist">
<li class="active"><a href="#">Home</a></li>
<li><a href="index1.jsp">Person</a></li>
<li><a href="index2.jsp">Project</a></li>
<li><a href="index3.jsp">Comment</a></li>
<li><a href="index4.jsp">Test</a></li>
</ul>
		<form action="PersonController.do" method="post" class="form-inline">


			<input type="hidden" name="personId"
				value="<c:out value="${person.personId}" />" readonly="readonly"
				placeholder="Auto generate ID" /> <br>
			<br>

			<div class="form-group">
				<label for="firstName">First Name</label><br> <input
					type="text" name="firstName" class="form-control"
					value="<c:out value="${person.firstName}" />"
					placeholder="First Name" />

			</div>

			<div class="form-group">
				<label for="lastName">Last Name</label><br> <input type="text"
					name="lastName" class="form-control"
					value="<c:out value="${person.lastName}" />"
					placeholder="Last Name" />
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="birthDate">Birth Date</label><br> <input
					type="date" name="birthDate" class="form-control"
					value="<fmt:formatDate pattern="dd-MM-yyy" value="${person.birthDate}" />" />
			</div>
			<br>
			<br> 
			<div class="form-group,radio">
			<label for="gender">Gender</label>
		
			<br> Male<input
				type="radio" name="gender" value="Male" checked /> Female <input
				type="radio" name="gender" value="Female" />
				</div>
				<br>
		
			
			<div class="form-group">
			<label for="address">Address</label><br> <input
				type="text" name="address" class="form-control"
				value="<c:out value="${person.address}" />" placeholder="Address" />
				</div>
			<br>
			<br> 
			<div class="form-group">
			<label for="tel">Telephone Number</label><br> <input
				type="text" name="tel" class="form-control" value="<c:out value="${person.tel}" />"
				placeholder="Telephone Number" /> 
				</div>
				<br>
			<br> 
			<div class="form-group">
			<label for="position">Position</label><br> <input
				type="text" name="position" class="form-control"
				value="<c:out value="${person.position}" />" placeholder="Position" />
					</div>
			<br>
			<br> <input type="submit" class="btn btn-default" value="Submit" />


		</form>
	</div>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>