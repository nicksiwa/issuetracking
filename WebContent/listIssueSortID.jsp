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
	
		<form action="ReportController.do" method="post">
	<div class="container">						
			<div class="card" >  	
			 <div class="container">
			 <div>
			 <h4><b>Please Select :</b></h4> 	
					   		
					    <span>Date: </span><input type="date"  name="firstDate" class="select" 
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.startDate}" />" />
						<span>Between</span>
									<input type="date" name="secondDate"  
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${project.finishDate}" />" />   
						
					</div>
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
				 Please Priority : <select name = "priority" class="select" > 
					  <option selected >----- Select Priority -----</option>
					  <option value="High">High</option>
					  <option value="Normal">Normal</option>
					<option value="Low">Low</option>
					 
				</select> 
				
				&nbsp;&nbsp;&nbsp; <button type="submit" class="btn btn-primary btn-lg right">Search </button>  
			 </div>
			    </div>				 
		</div>	 	
	</form>

		<table class="table table-hover table-responsive table-striped">
			<thead>
				<tr>
					<th><a href="IssueController.do?action=issueId">Issue ID</a></th>
					<th>Project</th>
					<th>Assign To</th>
					<th>Title</th>
					<th>Description</th>
					<th><a href="IssueController.do?action=SeveritySort">Severity</a></th>
					<th>Priority</th>
					<th><a href="IssueController.do?action=DueDateSort">Due Date</a></th>
					<th><a href="IssueController.do?action=UpdateDateSort">Update Date</a></th>

					<th>Status</th>
					<th>Reporter</th>
					<th><a href="IssueController.do?action=CreateDateSort">Create Date</a></th>
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

		<div align="center">
			<ul class="pagination">
				<c:forEach begin="1" end="${noOfPages}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
							<li class="active"><a>${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="IssueController.do?action=issueId?page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
			<ul class="pager">
				<c:if test="${currentPage != 1}">
					<li><a href="IssueController.do?action=issueId?page=${currentPage - 1}">Previous</a></li>
				</c:if>

				<c:if test="${currentPage lt noOfPages}">
					<li><a href="IssueController.do?action=issueId?page=${currentPage + 1}">Next</a></li>
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