<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager,java.util.Date,java.text.SimpleDateFormat" %>



<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Issue</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    padding: 0px;
	margin: 20px;
	margin-left: 0px;
	margin-right: 50px;
	padding-left: 50px;
	padding-right: 50px;
}
td {
    border: 1px solid #aaaaaa;
    text-align: left;
    padding: 20px;
    margin: 20 px;   
}
th {
    background-color: #4CAF50;
    color: white;
    text-align: center;
    }
    tr:nth-child(even) {
    background-color: #dddddd;
}
select{
padding: 4px;
margin: 6px;
width: 16%;
}

.card {
    box-shadow: 0 4px 6px 0 rgba(0,0,0,0.2);
    transition: 0.1s;
    width: 100%;
    padding: 0px;
	margin: 0px;
	padding-top: 5px;
    padding-bottom: 10px;
}

.card:hover {
    box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2);
}

.container {
    padding: 20px 20px;
    padding-top: 0px;
    padding-bottom: 0px;
}

</style>
	<div class="container">
		<div class="panel-heading">
			<h3>
				<span class="glyphicon glyphicon-file"></span> Report	
			</h3>	
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    	<script type="text/javascript">
    	
			google.charts.load("current", {packages:["corechart"]});
      		google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],					
          [' January',11],
          ['February',20],
          ['March',  2],
          ['April ', 2],
          ['May',    7],
          ['June',     11],
          ['July',      2],
          ['August',  10],
          ['September', 2],
          ['October',    7],
          ['November',  6],
          ['December', 2],  		
        ]);
        var options = {
          title: 'Conclusion of percentage each year',
          
          is3D: true,
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
      </script>
      </head>
      <body>
        <div id="piechart_3d" style="width: 900px; height: 450px;"></div>
      </body>
			</div>
		</div>
		
	<form action="ReportController.do" method="post">
	<div class="container">						
			<div class="card" >  	
			 <div class="container">
			 <h4><b>Please Select :</b></h4> 	
					   		
					    <input type="date"  name="firstDate" class="select" 
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.startDate}" />" />
						<span>Between</span>
									<input type="date" name="secondDate"  
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.finishDate}" />" />   
			     Please severity : <select name = "severity" class="select"   > 
					  <option selected >----- Select severity -----</option>
					  <option value="Minor">Minor</option>
					  <option value="Major">Major</option>
					  <option value="Crash">Crash</option>
					  
				</select>
				
					 	
				 Please Status : <select name = "status" class="select" > 
					  <option selected >----- Select Status -----</option>
					  <option value="Open">Open</option>
					  <option value="Assign">Assign</option>
					  <option value="Feedback">Feedback</option>
					  <option value="Confirmed">Confirmed</option>
					  <option value="Resolved">Resolved</option>
					  <option value="Closed">Closed</option>
					 
				</select> 
				
				&nbsp;&nbsp;&nbsp; <button type="submit" class="btn btn-primary btn-lg right">Search </button>  
			 </div>
			    </div>				 
		</div>	 	
	</form>
	

	
	<div class="container">
		<table class="table table-hover table-responsive table-striped">
			<thead>
				<tr>
					<th>Issue ID</th>
					<th>Project</th>
					<th>Assign To</th>
					<th>Title</th>
					<th>Severity</th>
					<th>Description</th>
					<th>Status</th>
					<th>Create Date</th>
					<th>Priority</th>
					<th>Due Date</th>
					<th>UpdateDate</th>
					<th>Reporter</th>
													
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${issues}" var="issue">
					<tr>
						<td><c:out value="${issue.issueID}"></c:out></td>
						<td><c:out value="${issue.project}"></c:out></td>
						<td><c:out value="${issue.assign}"></c:out></td>
						<td><c:out value="${issue.title}"></c:out></td>
						<td><c:out value="${issue.severity}"></c:out></td>
						<td><c:out value="${issue.description}"></c:out></td>
						<fmt:setLocale value="en_US" />
						<td><c:out value="${issue.status}"></c:out></td>
						<td><fmt:formatDate value="${issue.createDate}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td><c:out value="${issue.priority}"></c:out></td>
						<td><fmt:formatDate value="${issue.dueDate}" pattern="dd/MM/yyyy " /></td>
						<td><fmt:formatDate value="${issue.updateDate}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td><c:out value="${issue.reporter}"></c:out></td>				
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>