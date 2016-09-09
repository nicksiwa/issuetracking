<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Comment</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body class="sansserif">

<form action="CommentController.do" method="post">
<div>
<input type="hidden"
					name="commentID" value="<c:out value="${comment.commentID}" />"
					readonly="readonly" placeholder="Auto generate ID" />
		<br><br>
		<label for="description">Description</label><br> <input type="text"
					name="description" value="<c:out value="${comment.description}" />"
					placeholder="Description" />
		<br><br>
		<label for="status">Status</label><br> <input type="text"
					name="status" value="<c:out value="${comment.status}" />"
					placeholder="Status" />
	
		<input type="hidden" id="date"
					name="commentTime" value="<c:out value="${comment.commentTime}" />"
					placeholder="Comment Time" />
					<br><br>
<input type="submit" value="Submit" />

</div>
</form>

</body>
<script type="text/javascript">
var dateString=new Date();
dateString=new Date(dateString).toLocaleString()
dateString=dateString.split(' ').slice(0, 5).join(' ')
console.log(dateString);

document.getElementById('date').value = dateString;
</script>
</html>