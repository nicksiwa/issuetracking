<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
</head>
<body>
<%
String form1;
form1=request.getParameter("form1");
%>
<%=form1%>
<%
String form2;
form2=request.getParameter("status");
%>
<%=form2%>
<% 
String form3;
form3=request.getParameter("viewStatus");
%>
<%=form3%>
</body>
</html>