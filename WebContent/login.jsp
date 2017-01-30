<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>

</head>
<body>

	<jsp:include page="navbar.jsp" />




	<div class="container">
		<form class="form-horizontal" action="LoginController" method="post">

			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading text-center">
						<h3>Sign In</h3>
					</div>

					<div class="panel-body">
						<div class="col-md-12">

							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										name="username" class="form-control" placeholder="Username" required/>
								</div>
							</div>

							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										name="password" class="form-control" placeholder="Password" />
								</div>
							</div>
							<div class="form-group pull-right">
								<input type="submit" class="btn btn-success" value="Login" /> <a
									href="RegisterController" class="btn btn-default">Register</a>
							</div>

							<div>
								<p class="text-danger"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></p>
							</div>

						</div>
					</div>
				</div>
			</div>

		</form>
	</div>

</body>
</html>