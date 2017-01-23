<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<div class="col-md-7">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-ok"></span> <b>Closed
								issue</b><small><span class="pull-right"> <span
									class="badge">10</span> Issues
							</span></small>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">

							<%
								for (int i = 0; i <= 10; i++) {
							%>
							<a href="reopen.jsp" class="list-group-item">
								<p class="list-group-item-heading ">
									<b>Have bug <span class="label label-danger">Bug</span> <span
										class="label label-info">Feature</span></b><small><span
										class="pull-right"><span
											class="glyphicon glyphicon-time"></span> 26/12/2016 15:30</span></small>
								</p>
								<p class="list-group-item-text">From Project : Issue
									Tracking</p>
							</a>
							<%
								}
							%>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-md-offset-1">
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
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>