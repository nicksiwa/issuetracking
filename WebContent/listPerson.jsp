<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Persons</title>


<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th{ text-align: center;
    padding: 15px;}

 td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #ABABAB;
    color: white;
}

input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>

</head>
<body>
	<p>
		<a href="PersonController.do?action=insert">Add Person</a>
	</p>
	<table>
		<thead>
			<tr>
				<th>Person ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Birth Date</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Telephone Number</th>
				<th>Position</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td><c:out value="${person.personId}" /></td>
					<td><c:out value="${person.firstName}" /></td>
					<td><c:out value="${person.lastName}" /></td>
				
					<td><fmt:formatDate pattern="dd-MM-yyy" value="${person.birthDate}" /></td>
					<td><c:out value="${person.gender}" /></td>
					<td><c:out value="${person.address}" /></td>
					<td><c:out value="${person.tel}" /></td>
					<td><c:out value="${person.position}" /></td>
					<td><a
						href="PersonController.do?action=edit&personId=<c:out value="${person.personId }"/>">Update</a></td>
					<td><a
						href="PersonController.do?action=delete&personId=<c:out value="${person.personId }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>