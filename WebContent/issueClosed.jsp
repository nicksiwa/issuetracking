<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Closed issue</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/dropzone.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<form action="IssueController.do" method="post" class="form-horizontal">
		<div class="container">
			<div class="col-md-8">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h4>
							<font color="white"> <span class="glyphicon glyphicon-ok"></span>
								<b>Closed issue</b><small><span class="pull-right">
										<span class="badge">${fn:length(issues)} issue</span>

								</span></small>
							</font>
						</h4>

					</div>
					<div class="panel-body">
						
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>Issue name</th>
										<th>Project name</th>
										<th>Update date</th>
										<th> <label><input type="checkbox" value="" onchange="checkAll(this)" name="chk[]"><b>Select all</b></label></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${issues}" var="issue">

									<tr>
										<td><a href="IssueController.do?action=closed&issueID=<c:out value="${issue.issueID}"/>"><c:out value="${issue.title}"></c:out>	</a>
										&nbsp;&nbsp;
											<c:forEach items="${label}" var="label">
											<c:choose>
													<c:when test="${issue.issueID==label.issueID }">
														<span class="label <c:out value="${label.labelType}"/>">
															<c:out value="${label.labelName}" />
														</span>&nbsp;
													</c:when>
												</c:choose>
											</c:forEach>
										</td>
										<td><c:out value="${issue.project}"></c:out> </td>
										<fmt:parseDate
																value="${issue.updateDate}" pattern="yyyy-MM-dd HH:mm"
																var="myDate" />
										<td><fmt:formatDate value="${myDate}"
																pattern="dd/MM/yyyy HH:mm" /></td>
										<td><label><input type="checkbox" value=""></label></td>
									</tr>
</c:forEach>
								</tbody>
							</table>
							<div class="col-md-offset-5">
						<button type="button" class="btn btn-danger">Delete select</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div id="ghapidata" class="clearfix"></div>
				<input type="hidden" value="niksf203" id="user"> <input
					type="hidden" id="a">
			</div>

		</div>
	</form>
	<script type="text/javascript">
		var username = document.getElementById('user').value;
		var requri = 'https://api.github.com/users/' + username;
		var repouri = 'https://api.github.com/users/' + username + '/repos';

		requestJSON(
				requri,
				function(json) {
					if (json.message == "Not Found" || username == '') {
						$('#ghapidata').html("<h2>No User Info Found</h2>");
					}

					else {
						// else we have a user and we display their info
						var fullname = json.name;
						var username = json.login;
						var aviurl = json.avatar_url;
						var profileurl = json.html_url;
						var location = json.location;
						var followersnum = json.followers;
						var followingnum = json.following;
						var reposnum = json.public_repos;

						document.getElementById("a").value = fullname;

						if (fullname == undefined) {
							fullname = username;
						}

						var outhtml = '<div class="panel panel-default"><div class="panel-heading"><b>GitHub Repositories</b></div><div class="panel-body"><h3>'
								+ fullname
								+ ' <span class="smallname">(@<a href="'+profileurl+'" target="_blank">'
								+ username + '</a>)</span></h3>';
						outhtml = outhtml
								+ '<div class="ghcontent"><div class="avi"><a href="'+profileurl+'" target="_blank"><img src="'+aviurl+'" width="80" height="80" alt="'+username+'"></a></div>';
						outhtml = outhtml
								+ '<p>Followers : <span class="badge">'
								+ followersnum
								+ '</span> | Following : <span class="badge">'
								+ followingnum
								+ '</span><br>Repositories : <span class="badge">'
								+ reposnum + '</span></p></div>';
						outhtml = outhtml + '<div class="repolist clearfix">';

						var repositories;
						$.getJSON(repouri, function(json) {
							repositories = json;
							outputPageContent();
						});

						function outputPageContent() {
							if (repositories.length == 0) {
								outhtml = outhtml + '<p>No repos!</p></div>';
							} else {
								outhtml = outhtml
										+ '<p><strong>Repositories List : </strong></p></div></div> <ul class="list-group">';
								$
										.each(
												repositories,
												function(index) {
													outhtml = outhtml
															+ '<li class="list-group-item"><a href="'+repositories[index].html_url+'" target="_blank">'
															+ repositories[index].name
															+ '</a><span class="pull-right"><a href="" class="btn btn-success btn-xs" role="button">New issue</a></span></li>';
												});
								outhtml = outhtml + '</ul></div>';
							}
							$('#ghapidata').html(outhtml);
						} // end outputPageContent()
					} // end else statement
				}); // end requestJSON Ajax call

		function requestJSON(url, callback) {
			$.ajax({
				url : url,
				complete : function(xhr) {
					callback.call(null, xhr.responseJSON);
				}
			});
		}
	</script>
	<script>
	 function checkAll(ele) {
	     var checkboxes = document.getElementsByTagName('input');
	     if (ele.checked) {
	         for (var i = 0; i < checkboxes.length; i++) {
	             if (checkboxes[i].type == 'checkbox') {
	                 checkboxes[i].checked = true;
	             }
	         }
	     } else {
	         for (var i = 0; i < checkboxes.length; i++) {
	             console.log(i)
	             if (checkboxes[i].type == 'checkbox') {
	                 checkboxes[i].checked = false;
	             }
	         }
	     }
	 }
	</script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>