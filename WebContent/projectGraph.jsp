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
	  		$('#sel1').change(()=>{
	  			var c = $( "select option:selected" ).val();
	  			if(c==0){
	  				google.charts.setOnLoadCallback(draw);
	  			}else if(c==1){
	  				google.charts.setOnLoadCallback(draw1);
	  			}else if (c==2){
	  				google.charts.setOnLoadCallback(draw2);
	  			}else if(c==3){
	  				google.charts.setOnLoadCallback(draw3);
	  			}else{
	  				google.charts.setOnLoadCallback(draw4);
	  			}
	  			
	  		})
	  	    
	  	    function draw() {
	  	      var data1 = new google.visualization.DataTable();
	  	      data1.addColumn('string','Month ');
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
	  		
	  		function draw1() {
		  	      var data1 = new google.visualization.DataTable();
		  	      data1.addColumn('string','Month ');
		  	      data1.addColumn('number','Total By Month ');
		  	     for(var ix=0;ix<3;ix++){
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
	  		
	  		function draw2() {
		  	      var data1 = new google.visualization.DataTable();
		  	      data1.addColumn('string','Month ');
		  	      data1.addColumn('number','Total By Month ');
		  	     for(var ix=3;ix<6;ix++){
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
	  		
	  		function draw3() {
		  	      var data1 = new google.visualization.DataTable();
		  	      data1.addColumn('string','Month ');
		  	      data1.addColumn('number','Total By Month ');
		  	     for(var ix=6;ix<9;ix++){
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
	  		
	  		function draw4() {
		  	      var data1 = new google.visualization.DataTable();
		  	      data1.addColumn('string','Month ');
		  	      data1.addColumn('number','Total By Month ');
		  	     for(var ix=9;ix<12;ix++){
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
		<h2><span class="label label-primary"><c:out value="${project.projectName }"/></span><small> <c:out value="${project.owner }"/></small></h2>
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
			<div class="col-md-6">
	<label for="sel1">Select Month:</label>
      <select class="form-control" id="sel1">
      	<option value="0">All Month </option>
        <option value="1">January-March</option>
        <option value="2">April-June</option>
        <option value="3">July-September</option>
        <option value="4">October-December</option>
      </select>
			</div>
			</div>
				<br><br><br><br>
			<div class="col-md-12">
			<div class="panel panel-default col-md-6">
			<div class="panel-body">
			<div class="col-md-6" id="bar" style="width: 500px; height: 350px;"></div>
			</div>
			</div>
			
			<div class="panel panel-default col-md-6">
			<div class="panel-body">
			<div class="col-md-6" id="piechart_3d" style="width: 500px; height: 350px;"></div>
			</div>
			</div>
			
			</div>
			
		</form>
		</div>
<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>
</html>