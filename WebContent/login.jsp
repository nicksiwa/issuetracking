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

</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form class="form-horizontal" action="LoginController" method="post">
			<div class="col-md-12">
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3>Sign In</h3>
						</div>

						<div class="panel-body">
							<div>
								<p class="text-danger"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></p>
							</div>

							<div class="form-group col-lg-12">
								<input type="text" name="username" class="form-control"
									placeholder="Username" />
							</div>

							<div class="form-group col-lg-12">
								<input type="password" name="password" class="form-control"
									placeholder="Password" />
							</div>
							<input type="submit" class="btn btn-default" value="Login" />
						</div>

					</div>
				</div>
			</div>
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