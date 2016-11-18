<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmed</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="CommentController.do" method="post"
			class="form-horizontal">


			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<span class="glyphicon glyphicon-search"></span> Change Status to
						Confirmed
					</h3>
				</div>
				<div class="panel-body">

					<input type="hidden" name="commentID"
						value="<c:out value="${comment.commentID}" />" readonly="readonly"
						placeholder="Auto generate ID" /> <input type="hidden"
						name="issueID" value="<c:out value="${issue.issueID}" />" /><br>

					<div class="form-group">
						<label for="description" class="control-label col-sm-2">Description
							:</label>
						<div class="col-sm-8 col-lg-5 col-md-6">
							<textarea name="commentDetail" class="form-control" rows="5"
								placeholder="Description"><c:out
									value="${comment.commentDetail}" /></textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="status" class="control-label col-sm-2">Status
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<p class="form-control-static">
								<c:out value="${issue.status}" />
								<input type="hidden" name="status"
									value="<c:out value="${issue.status}" />" />
							</p>
						</div>
					</div>

					<div class="form-group" style="display: none;">
						<label for="status" class="control-label col-sm-2">To User
							:</label>
						<div class="col-sm-3 col-lg-2 col-md-2">
							<select class="form-control" name="commentAssign">
								<option value="-">-</option>
								<c:forEach var="person" items="${persons}">
									<option><c:out value="${person.firstName}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>

					<input type="hidden" id="date" name="commentTime"
						value="<c:out value="${comment.commentTime}" />"
						placeholder="Comment Time" />

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-default" value="Submit" />
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