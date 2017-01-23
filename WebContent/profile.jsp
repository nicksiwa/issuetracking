<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<form action="" class="form-horizontal" method="post">
		<div class="col-md-6 col-md-offset-3">

				<div class="panel panel-default">
					<div class="panel-heading text-center">
						<h3>
							Siwa profile <small>edit your profile</small>
						</h3>
						

					</div>
					<div class="panel-body">
					<div class="col-md-12">
							<div class="form-group">
								<input type="hidden" name="userID" class="form-control"
									value="<c:out value="${register.userID}"></c:out>" /> <label
									for="description" class="control-label col-md-4">First
									Name : </label>
								<div class="col-md-8">
									<input type="text" name="firstname" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="description" class="control-label col-md-4">Last
									Name : </label>
								<div class="col-md-8">
									<input type="text" name="lastname" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="description" class="control-label col-md-4">Birth
									Date : </label>
								<div class="col-md-8">
									<input type="date" name="birthdate" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="description" class="control-label col-md-4">Gender
									: </label>
								<div class="col-md-8">
									Male <input type="radio" name="gender" value="Male" checked />
									Female <input type="radio" name="gender" value="Female" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="description" class="control-label col-md-4">Address
									: </label>
								<div class="col-md-8">
									<textarea name="address" class="form-control" rows="5"></textarea>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="description" class="control-label col-md-4">Telephone
									Number : </label>
								<div class="col-md-8">
									<input type="text" name="tel" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="description" class="control-label col-md-4">Position
									: </label>
								<div class="col-md-8">
									<input type="text" name="position" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="description" class="control-label col-md-4">GitHub username
									: </label>
								<div class="col-md-8">
									<input type="text" name="position" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-6"></div>
							<div class="form-group">
								<input type="submit" class="btn btn-default" value="Submit" />
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