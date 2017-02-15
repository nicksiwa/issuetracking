<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<jsp:include page="navbar.jsp" />
<body>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 90%;
}
td {
    border: 1px solid #aaaaaa;
    text-align: left;
    padding: 15px;
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
padding: 8px;
margin: 8px;
width: 18%;
}
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 13px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
	<script>
		// $(function() {
		//	$('input[name=birthDate]').datepicker();
	// 	});
	</script>
	
	<div class="container">			
			<div class="panel-heading">
					<h3>
						<span class="glyphicon glyphicon-file"></span> Report	
					</h3>	
		<form action="PersonController.do" method="post" class="form-horizontal">
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
	<div class="col-md-12">
	    <h5 class="select">Please Select : &nbsp;  &nbsp; &nbsp;  	
	     <select> 
			  <option selected >------Select Month------</option>
			  <option value="01">January</option>
			  <option value="02">February</option>
			  <option value="3">March</option>
			  <option value="4">April</option>
			  <option value="5">May</option>
			  <option value="3">June</option>
			  <option value="4">July</option>
			  <option value="5">August</option>
			  <option value="3">September</option>
			  <option value="4">October</option>
			  <option value="5">November</option>
			  <option value="5">December</option>  
		</select>
		 &nbsp;  &nbsp; &nbsp;
		<button class="button">Submit</button>
		</h5> 	 
	</div>
	<div class="panel-body" >
		<table>
			  <tr>
			    <th>Project Name</th>
			    <th>Name</th>
			    <th>Date</th>
			    <th>Severity</th>
			    <th>Discripsion</th>
			    <th>Status</th>
			    
			  </tr>
			  <tr>
			    <td>Issue </td>
			    <td>Santipong Kimseng  </td>
			    <td>12 December 2015</td>
			    <td>50%</td>
			    <td>Bug issue</td>
			    <td>Edited</td>
			  </tr>
			  <tr>
			    <td>Bug Error</td>
			    <td>Siwa Khongsuphap</td>
			    <td>24 September 2015</td>
			    <td>60%</td>
			     <td>Bug issue</td>
			    <td>Non Edited</td>
			  </tr>
			  <tr>
			    <td>Bug Error</td>
			    <td>Pamon Intason</td>
			    <td>20 May 2016</td>
			    <td>80%</td>
			     <td>Bug issue</td>
			    <td>Edited</td>
			  </tr>
			  <tr>
			    <td>Issue</td>
			    <td>Santipong Kimseng </td>
			    <td>21 September 2014</td>
			    <td>20%</td>
			     <td>Bug issue</td>
			    <td>Edited</td>
			  </tr>
			  <tr>
			    <td>Bug Error</td>
			    <td>Siwa Khongsuphap</td>
			    <td>6 April 2016</td>
			    <td>63%</td>
			     <td>Bug issue</td>
			    <td>Non Edit</td>
			  </tr>
			  <tr>
			    <td>Bug Error</td>
			    <td>Santipong Kimseng</td>
			    <td>10 August 2017</td>
			    <td>44%</td>
			     <td>Bug issue</td>
			    <td>Non Edit</td>
			  </tr>
			</table>
			</div>
		</body>
	</html>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/jquery-3.1.0.min.js"></script>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
			<script
				src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>