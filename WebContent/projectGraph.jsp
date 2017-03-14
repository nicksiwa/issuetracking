<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project name</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js"></script>

</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="" class="form-horizontal">
		<h2><span class="label label-primary">Project name</span><small> project owner</small></h2>
		<br>
			<ul class="nav nav-tabs">
				<li><a href="ProjectController.do?action=milestone">Project milestone / Project road map</a></li>
				<li class="active"><a href="ProjectController.do?action=graph">Project report</a></li>
				<li><a href="ProjectController.do?action=task">Project task</a></li>
				<li><a href="ProjectController.do?action=label">Issue labels</a></li>
			</ul>
			<br>
			<div class="col-md-12">
			<canvas id="myChart" width="400" height="150"></canvas>
			</div>
			
		</form>
		</div>
<script>
		var ctx = document.getElementById('myChart').getContext('2d');
		var myChart = new Chart(ctx, {
			type : 'line',
			data : {
				labels : [ 'M', 'T', 'W', 'T', 'F', 'S', 'S' ],
				datasets : [ {
					label : 'Closed',
					data : [ 12, 19, 3, 17, 6, 3, 7 ],
					backgroundColor : "rgba(153,255,51,0.4)"
				}, {
					label : 'Opened',
					data : [ 2, 22, 5, 5, 2, 3, 10 ],
					backgroundColor : "rgba(255,153,0,0.4)"
				}, {
					label : 'Assigned',
					data : [ 1, 2, 4, 0, 0, 1, 3 ],
					backgroundColor : "rgba(204,153,255,0.4)"
				}, {
					label : 'Feedback',
					data : [ 5, 9, 7, 11, 20, 6, 0 ],
					backgroundColor : "rgba(255,255,0,0.4)"
				}, {
					label : 'Confirmed',
					data : [ 1, 0, 0, 7, 0, 0, 0 ],
					backgroundColor : "rgba(255,0,0,0.4)"
				}, {
					label : 'Resolved',
					data : [ 6, 7, 3, 10, 1, 7, 21 ],
					backgroundColor : "rgba(0,0,255,0.4)"
				}

				]
			},
			options : {
				title : {
					display : true,
					text : 'Issue status by week'
				},
				responsive : true
			}

		});
	</script>
</body>
</html>