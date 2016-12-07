<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Register</title>
<link href="css/bootstrap.css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>

</head>
<body>
	<jsp:include page="navbar.jsp" />


	<div class="container">


		<form action="RegisterController" class="form-horizontal"
			method="post">
			<div class="col-md-6 col-md-offset-3">

				<div class="panel panel-default">
					<div class="panel-heading text-center">
						<h3>
							Registration <small>Create your account</small>
						</h3>
						Already have an account? <a href="LoginController">Sign In</a>



					</div>
					<div class="panel-body">
						<div class="col-md-12">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										name="username" class="form-control" placeholder="Username" />


								</div>
								<p class="text-danger"><%=(request.getAttribute("Message") == null) ? "" : request.getAttribute("Message")%></p>
							</div>
						</div>


						<div class="col-md-12">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										name="password" class="form-control" id="password"
										placeholder="Password" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										class="form-control" id="confirmpassword"
										onChange="checkPasswordMatch();"
										placeholder="Confirm password" />

								</div>

								<p class="text-danger" id="divCheckPasswordMatch"></p>
								<p class="text-success" id="divCheckPasswordMatcha"></p>
								<p class="text-danger" id="divCheckPasswordCount"></p>


							</div>
							<div class="form-group pull-right">
								<input type="submit" class="btn btn-default" value="Next"
									id="myBtn" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>








	<script>
		function checkPasswordMatch() {
			var password = $("#password").val();
			var confirmPassword = $("#confirmpassword").val();

			if (password != confirmPassword) {
				$("#divCheckPasswordMatch").html("Passwords do not match!");
				$("#divCheckPasswordMatcha").html("");
				document.getElementById("myBtn").disabled = true;

			} else if (password.length < 8) {
				$("#divCheckPasswordCount")
						.html(
								"You have entered less than 8 characters for password!");
			}

			else {
				$("#divCheckPasswordMatcha").html("Passwords match.");
				$("#divCheckPasswordMatch").html("");
				$("#divCheckPasswordCount").html("");
				document.getElementById("myBtn").disabled = false;
			}
		}

		$(document).ready(function() {
			$("#password, #confirmpassword").keyup(checkPasswordMatch);
		});
	</script>



</body>
</html>