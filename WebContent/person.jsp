<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="WebContent/js/jquery-1.7.1.min.js"></script>

<title>Add New Person</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">

</head>
<body class="sansserif">
	<script>
		$(function() {
			$('input[name=birthDate]').datepicker();

		});
	</script>

	<form action="PersonController.do" method="post">
	
			<div>
				<input type="hidden"
					name="personId" value="<c:out value="${person.personId}" />"
					readonly="readonly" placeholder="Auto generate ID" />
		<br><br>
				<label for="firstName">First Name</label><br> <input type="text"
					name="firstName" value="<c:out value="${person.firstName}" />"
					placeholder="First Name" />
		<br><br>
				<label for="lastName">Last Name</label><br> <input type="text"
					name="lastName" value="<c:out value="${person.lastName}" />"
					placeholder="Last Name" />
	<br><br>
				<label for="birthDate">Birth Date</label><br> <input type="date"
					name="birthDate" value="<fmt:formatDate pattern="dd-MM-yyy" value="${person.birthDate}" />" />
			<br><br>
				<label for="gender">Gender</label><br> Male<input type="radio"
					name="gender" value="Male" checked	/> Female <input type="radio"
					name="gender" value="Female" />
<br><br>
				<label for="address">Address</label><br> <input type="text"
					name="address" value="<c:out value="${person.address}" />"
					placeholder="Address" />
		<br><br>
				<label for="tel">Telephone Number</label><br> <input type="text"
					name="tel" value="<c:out value="${person.tel}" />"
					placeholder="Telephone Number" />
		<br><br>
				<label for="position">Position</label><br> <input type="text"
					name="position" value="<c:out value="${person.position}" />"
					placeholder="Position" />
		<br><br>
				<input type="submit" value="Submit" />
			</div>
	
	</form>
	
</body>
</html>