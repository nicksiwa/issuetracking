<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js"></script>

</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="" class="form-horizontal">






			<div class="col-md-7">


				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-th-list"></span> <b>Assigned
								to me</b><small><span class="pull-right"> <span
									class="badge">${fn:length(indexs)}</span> Issues
							</span></small>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">

							<c:choose>
								<c:when test="${fn:length(indexs)=='0'}">
      								  No have any issues 
   								</c:when>
								<c:otherwise>

									<c:forEach begin="0" end="2" items="${indexs}" var="index">
										<a
											href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
											class="list-group-item" data-toggle="tooltip"
											data-placement="top"
											title="Click to change status or view issue detail">
											<p class="list-group-item-heading ">
												<b> <c:out value="${index.title}"></c:out>
												</b> <small><span class="pull-right"><font
														color="gray"> <fmt:parseDate
																value="${index.updateDate}" pattern="yyyy-MM-dd HH:mm"
																var="myDate" /> <span class="glyphicon glyphicon-time"></span> <fmt:formatDate value="${myDate}"
																pattern="dd/MM/yyyy HH:mm" />
													</font></span></small>

											</p>
											<p class="list-group-item-text">
												From Project :
												<c:out value="${index.project}"></c:out>
											</p>

										</a>
									</c:forEach>
									<br>
									<a href="IndexController.do?action=allassign"
										class="btn btn-default" role="button">View all issues</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>



				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-globe"></span> <b>Unassigned</b><small><span
								class="pull-right"> <span class="badge">${fn:length(unassign)}</span>
									Issues
							</span></small>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">

							<c:choose>
								<c:when test="${fn:length(unassign)=='0'}">
      								  No have any issues 
   								</c:when>
								<c:otherwise>

									<c:forEach begin="0" end="2" items="${unassign}" var="index">
										<a
											href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
											class="list-group-item" data-toggle="tooltip"
											data-placement="top"
											title="Click to change status or view issue detail">
											<p class="list-group-item-heading ">
												<b> <c:out value="${index.title}"></c:out>
												</b> <small><span class="pull-right"><font
														color="gray"> <fmt:parseDate
																value="${index.updateDate}" pattern="yyyy-MM-dd HH:mm"
																var="myDate" /> <span class="glyphicon glyphicon-time"></span> <fmt:formatDate value="${myDate}"
																pattern="dd/MM/yyyy HH:mm" />
													</font></span></small>

											</p>
											<p class="list-group-item-text">
												From Project :
												<c:out value="${index.project}"></c:out>
											</p>
										</a>

									</c:forEach>
									<br>
									<a href="IndexController.do?action=allunassign"
										class="btn btn-default" role="button">View all issues</a>

								</c:otherwise>
							</c:choose>

						</div>

					</div>
				</div>



				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-edit"></span> <b>Report by
								me</b><span class="pull-right"><small> <span
									class="badge">${fn:length(reports)}</span> Issues
							</small></span>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">

							<c:choose>
								<c:when test="${fn:length(reports)=='0'}">
      								  No have any issues 
   								</c:when>
								<c:otherwise>

									<c:forEach begin="0" end="2" items="${reports}" var="index">
										<a
											href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
											class="list-group-item">
											<p class="list-group-item-heading">
												<b> <c:out value="${index.title}"></c:out>
												</b> <small><span class="pull-right"><font
														color="gray"> <fmt:parseDate
																value="${index.updateDate}" pattern="yyyy-MM-dd HH:mm"
																var="myDate" /> <span class="glyphicon glyphicon-time"></span> <fmt:formatDate value="${myDate}"
																pattern="dd/MM/yyyy HH:mm" />
													</font></span></small>
											</p>
											<p class="list-group-item-text">
												From Project :
												<c:out value="${index.project}"></c:out>
											</p>

										</a>
									</c:forEach>
									<br>
									<a href="IndexController.do?action=allreport"
										class="btn btn-default" role="button">View all issues</a>
								</c:otherwise>
							</c:choose>
						</div>

					</div>
				</div>



				<div class="panel panel-success">
					<div class="panel-heading">
						<h4>
							<span class="glyphicon glyphicon-check"></span> <b>Resolved</b><span
								class="pull-right"><small> <span class="badge">${fn:length(resolves)}</span>
									Issues
							</small></span>
						</h4>

					</div>
					<div class="panel-body">
						<div class="list-group">

							<c:choose>
								<c:when test="${fn:length(resolves)=='0'}">
      								  No have any issues
   								</c:when>
								<c:otherwise>

									<c:forEach begin="0" end="2" items="${resolves}" var="index">
										<a
											href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}"/>"
											class="list-group-item">
											<p class="list-group-item-heading">
												<b> <c:out value="${index.title}"></c:out>
												</b> <small><span class="pull-right"><font
														color="gray"> <fmt:parseDate
																value="${index.updateDate}" pattern="yyyy-MM-dd HH:mm"
																var="myDate" /> <span class="glyphicon glyphicon-time"></span> <fmt:formatDate value="${myDate}"
																pattern="dd/MM/yyyy HH:mm" />
													</font></span></small>
											</p>
											<p class="list-group-item-text">
												From Project :
												<c:out value="${index.project}"></c:out>
											</p>
										</a>
									</c:forEach>
									<br>
									<a href="IndexController.do?action=allresolved"
										class="btn btn-default" role="button">View all issues</a>
								</c:otherwise>
							</c:choose>

						</div>

					</div>
				</div>
			
			</div>

			<div class="col-md-4 col-md-offset-1">

				<div id="ghapidata" class="clearfix"></div>
				<input type="hidden" value="niksf203" id="user"> <input
					type="hidden" id="a">

				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Project you contribute to</b> <span class="badge">${fn:length(projects)}</span>
					</div>

					<ul class="list-group">
					
					<c:choose>
								<c:when test="${fn:length(projects)=='0'}">
      								<li class="list-group-item">No have any projects</li>
      								  
   								</c:when>
								<c:otherwise>
					
						<c:forEach items="${projects}" var="index">
							<li class="list-group-item text-primary"><a
								href="IssueController.do?action=project&projectID=<c:out value="${index.projectID}"/>"><c:out
										value="${index.project}"></c:out></a><a
								href="IssueController.do?action=insert&project=<c:out value="${index.projectID}"/>"
								class="btn btn-success btn-xs pull-right" role="button">New
									issue</a></li>
						</c:forEach>
						
						</c:otherwise></c:choose>
						
					</ul>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Public project</b> <span class="badge">${fn:length(publics)}</span>
					</div>

					<ul class="list-group">
					
					<c:choose>
							<c:when test="${fn:length(publics)=='0'}">
								<li class="list-group-item">No have any projects</li>
							</c:when>
							<c:otherwise>
						<c:forEach items="${publics}" var="index">
							<li class="list-group-item text-primary"><a
								href="IssueController.do?action=project&projectID=<c:out value="${index.projectID}"/>"><c:out
										value="${index.project}"></c:out></a>
										<span class="pull-right"><a href="IssueController.do?action=insert&project=<c:out value="${index.projectID}"/>" class="btn btn-success btn-xs" role="button">New issue</a></span></li>
						</c:forEach>
						</c:otherwise></c:choose>
						
					</ul>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Your feed</b> <span class="badge">${fn:length(feedback)}</span><a
							href="#"><span class="pull-right"><small>View
									all</small></span></a>
					</div>
					<ul class="list-group">
			
							<c:choose>
								<c:when test="${fn:length(feedback)=='0'}">
      								<li class="list-group-item">No have any feedbacks</li> 
   								</c:when>
								<c:otherwise>

						<c:forEach items="${feedback}" var="index">
							<li class="list-group-item"><c:out
									value="${index.userComment}" /> <a
								href="IssueController.do?action=detail&issueID=<c:out value="${index.issueID}" />"
								data-toggle="tooltip" data-placement="top" title="Hooray!">
									<c:out value="${index.commentDetail}" />
							</a> <span class="pull-right"><small><font
										color="gray"> <fmt:parseDate
												value="${index.commentTime}" pattern="yyyy-MM-dd HH:mm"
												var="myDate" /> <span class="glyphicon glyphicon-time"></span> <fmt:formatDate value="${myDate}"
												pattern="dd/MM/yyyy HH:mm" /></font></small></span></li>
						</c:forEach>
						</c:otherwise></c:choose>
					
					</ul>

				</div>
			</div>
		</form>

	</div>

	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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

						var outhtml = '<div class="panel panel-default" style="display: none;"><div class="panel-heading"><b>GitHub Repositories</b></div><div class="panel-body"><h3>'
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
										+ '<p><strong>Repositories List : </strong></p> <ul>';
								$
										.each(
												repositories,
												function(index) {
													outhtml = outhtml
															+ '<li><a href="'+repositories[index].html_url+'" target="_blank">'
															+ repositories[index].name
															+ '</a></li>';
												});
								outhtml = outhtml + '</ul></div></div></div>';
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
		var ctx = document.getElementById('myChart').getContext('2d');
		var myChart = new Chart(ctx, {
			type : 'line',
			data : {
				labels : [ 'M', 'T', 'W', 'T', 'F', 'S', 'S' ],
				datasets : [ {
					label : 'BugTracking',
					data : [ 12, 19, 3, 17, 6, 3, 7 ],
					backgroundColor : "rgba(153,255,51,0.4)"
				}, {
					label : 'Hai to Gensou',
					data : [ 2, 29, 5, 5, 2, 3, 10 ],
					backgroundColor : "rgba(255,153,0,0.4)"
				}, {
					label : 'Project 1',
					data : [ 14, 12, 2, 3, 17, 20, 9 ],
					backgroundColor : "rgba(130,35,35,0.4)"
				}

				]
			},
			options : {
				title : {
					display : true,
					text : 'Custom Chart Title'
				},
				responsive : true
			}

		});
	</script>


</body>
</html>