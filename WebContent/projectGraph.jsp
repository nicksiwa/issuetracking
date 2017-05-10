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
<title>Project name</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load("current", {packages:["corechart",'bar']});
$(document).ready(function(){
	var monthNames = ["January", "February", "March", "April", "May", "June",
		  "July", "August", "September", "October", "November", "December"
		];
	$.ajax({
	      type:"GET",
	  		url:'ReportController?action=severity',
	  		headers:{
	  			Accept:"application/json; charset=utf-8",
	  			"Content-Type" : "application/json; charset=utf-8"
	  		},
	  		success: function(issues){
	  			 var report = $.parseJSON(issues);
	  			 var s = '';
	  			 for(var i=0;i<report.length;i++){
	  				s += report[i].createDate+' '+report[i].assign;
	  			 }
	  		google.charts.load('current',{'packages':['bar']});
	  	    google.charts.setOnLoadCallback(draw);
	  	    function draw() {
	  	      var data1 = new google.visualization.DataTable();
	  	      data1.addColumn('string','month ');
	  	      data1.addColumn('number','Total By Month ');
	  	     for(var ix=0;ix<report.length;ix++){
	  	    	 data1.addRow([monthNames[parseInt(report[ix].project)-1],Number(report[ix].assign)]);    	
	  	     }
	  	      var option1 = {
	  	    		  chart:{
	  	    			  title:'Count of Issue',
	  	    			 	
	  	    		  },
	  	    		  bars:'vertical',
	  	      };
	  	      var chart = new google.charts.Bar(document.getElementById('bar'));
	  	      chart.draw(data1, option1);
	  	    }
	  			
	  		}
	    });
	});	
$.ajax({
    type:"GET",
		url:'ReportController?action=status',
		headers:{
			Accept:"application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success: function(issues){
			 var report2 = $.parseJSON(issues);
			 var s = '';
			 for(var i=0;i<report2.length;i++){
				s += report2[i].status+' '+report2[i].assign;
			 }
			 console.log(s);
			 google.charts.setOnLoadCallback(drawChart);
			 var dataArray = [];
			 dataArray.push(['Status','issue']);
			 for(var i=0;i<report2.length;i++){
				 dataArray.push([report2[i].status,parseInt(report2[i].assign)]);
			 }
			 console.log(dataArray)
		      function drawChart() {
		        var data = google.visualization.arrayToDataTable(dataArray);

		        var options = {
		          title: 'Total Issue Status',
		          is3D: true,
		        };

		        var chart2 = new google.visualization.PieChart(document.getElementById('piechart_3d'));
		        chart2.draw(data, options);
		      }
			
		}
  });
	</script>
</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<form action="" class="form-horizontal">
		<h2><span class="label label-primary">Project name</span><small> project owner</small></h2>
		<br>
			<ul class="nav nav-tabs">
				<li><a
					href="MilestoneController.do?action=milestone&projectID=<c:out value="${project.projectID }"/>">Project
						milestone / Project road map</a></li>
				<li><a href="IssueController.do?action=report&projectID=<c:out value="${project.projectID }"/>">Project report</a></li>
				<li class="active"><a
					href="ReportController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Graph</a></li>
				<li><a
					href="TaskController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Project
						task</a></li>
				<li><a
					href="LabelController.do?action=label&projectID=<c:out value="${project.projectID }"/>">Issue
						labels</a></li>
			</ul>
			<br>
			<div class="col-md-12">
			
			<div class="col-md-6" id="bar" style="width: 550px; height: 350px;"></div>
			<div class="col-md-6" id="piechart_3d" style="width: 550px; height: 500px;"></div>
			
			</div>
			
		</form>
		</div>
<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>
</html>