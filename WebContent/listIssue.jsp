<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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


	<div class="container">
	
		<form action="ReportController.do" method="post" class="form-inline">
	<div class="container">			
	<h2>
				<span class="label label-primary"><c:out value="${project.projectName }"/></span><small>
					<c:out value="${project.owner }"/></small>
			</h2>
			<br>
			<ul class="nav nav-tabs">
				<li><a
					href="MilestoneController.do?action=milestone&projectID=<c:out value="${project.projectID }"/>">Project
						milestone / Project road map</a></li>
				<li class="active"><a href="IssueController.do?action=report&projectID=<c:out value="${project.projectID }"/>">Project report</a></li>
				<li><a
					href="ReportController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Graph</a></li>
				<li><a href="TaskController.do?action=task&projectID=<c:out value="${project.projectID }"/>">Project task</a></li>
				<li><a
					href="LabelController.do?action=label&projectID=<c:out value="${project.projectID }"/>">Issue
						labels</a></li>
			</ul>
			<br>			
			<div class="card" >  	
			 <div class="container">
			 <div>
			 <h4><b>Please Select :</b></h4> 	
					   		
					    <span>Date: </span><input type="date"  name="firstDate" class="form-control" 
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.startDate}" />" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span>To</span>
									<input type="date" name="secondDate"  class="form-control" 
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.finishDate}" />" />   
						
					</div>
			     Please severity : <select name = "severity" class="form-control"   > 
					  <option selected >Select severity</option>
					  <option value="Minor">Minor</option>
					  <option value="Major">Major</option>
					  <option value="Crash">Crash</option>
					  
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;
					 	
				 Please Status : <select name = "status" class="form-control" > 
					  <option selected >Select Status</option>
					  <option value="Open">Open</option>
					  <option value="Assign">Assign</option>
					  <option value="Feedback">Feedback</option>
					  <option value="Confirmed">Confirmed</option>
					  <option value="Resolved">Resolved</option>
					  <option value="Closed">Closed</option>
					 
				</select> 
				&nbsp;&nbsp;&nbsp;&nbsp;
				 Please Priority : <select name = "priority" class="form-control" > 
					  <option selected >Select Priority</option>
					  <option value="High">High</option>
					  <option value="Normal">Normal</option>
					<option value="Low">Low</option>
					 
				</select> 
				
				<input type="hidden" name="projectID" value="<c:out value="${project.projectID }"/>">
				
				&nbsp;&nbsp;&nbsp; <button type="submit" class="btn btn-primary btn-lg right">Search </button>  
			 </div>
			    </div>				 
		</div>	 	
	</form>
	<br>

<div>
		<table class="table table-hover table-responsive table-striped">
			<thead>
				<tr>
					<th><a href="IssueController.do?action=issueId&projectID=<c:out value="${project.projectID }"/>">Issue ID</a></th>
					<th>Project</th>
					<th>Assign To</th>
					<th>Title</th>
					<th>Description</th>
					<th><a href="IssueController.do?action=SeveritySort&projectID=<c:out value="${project.projectID }"/>">Severity</a></th>
					<th>Priority</th>
					<th><a href="IssueController.do?action=DueDateSort&projectID=<c:out value="${project.projectID }"/>">Due Date</a></th>
					<th><a href="IssueController.do?action=UpdateDateSort&projectID=<c:out value="${project.projectID }"/>">Update Date</a></th>

					<th>Status</th>
					<th>Reporter</th>
					<th><a href="IssueController.do?action=CreateDateSort&projectID=<c:out value="${project.projectID }"/>">Create Date</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${issues}" var="issue">
					<tr>

						<td><c:out value="${issue.issueID}"></c:out></td>
						<td><c:out value="${issue.project}"></c:out></td>
						<td><c:out value="${issue.assign}"></c:out></td>
						<td><c:out value="${issue.title}"></c:out></td>
						<td><c:out value="${issue.description}"></c:out></td>
						<td><c:out value="${issue.severity}"></c:out></td>
						<td><c:out value="${issue.priority}"></c:out></td>
						<fmt:setLocale value="en_US" />
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${issue.dueDate}" /></td>
						<td><fmt:formatDate value="${issue.updateDate}"
								pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td><c:out value="${issue.status}"></c:out></td>
						<td><c:out value="${issue.reporter}"></c:out></td>
						<td><fmt:formatDate value="${issue.createDate}"
								pattern="dd/MM/yyyy HH:mm:ss" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
		<div align="center">
			<ul class="pagination">
				<c:forEach begin="1" end="${noOfPages}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
							<li class="active"><a>${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="IssueController.do?action=report&projectID=<c:out value="${project.projectID }"/>&page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
			<ul class="pager">
				<c:if test="${currentPage != 1}">
					<li><a href="IssueController.do?action=report&projectID=<c:out value="${project.projectID }"/>&page=${currentPage - 1}">Previous</a></li>
				</c:if>

				<c:if test="${currentPage lt noOfPages}">
					<li><a href="IssueController.do?action=report&projectID=<c:out value="${project.projectID }"/>&page=${currentPage + 1}">Next</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>