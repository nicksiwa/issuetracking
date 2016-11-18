<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="register2.jsp" class="form-horizontal">
			<div class="col-md-6 col-md-offset-3">

				<div class="panel panel-default">
					<div class="panel-heading text-center">
						<h3>
							Registration <small>Create your account</small>
						</h3>
						Already have an account? <a href="#">Sign In</a>

					</div>
					<div class="panel-body">
						<div class="col-md-12">
						<div class="form-group">
						<label for="description" class="control-label col-md-4">Username : </label>
								<div class="col-md-8">
									<input type="text" name="username" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
						<div class="form-group">
						<label for="description" class="control-label col-md-4">Password : </label>
								<div class="col-md-8">
									<input type="text" name="username" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
						<div class="form-group">
						<label for="description" class="control-label col-md-4">Confirm Password : </label>
								<div class="col-md-8">
									<input type="text" name="username" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
						<div class="col-md-6"></div>
						<div class="form-group">
								<input type="submit" class="btn btn-default" value="Next" />
							</div>
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