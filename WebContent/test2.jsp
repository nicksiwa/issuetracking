
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
<script>
	function myFunction(value) {
		var x = document.getElementById("mySelect").value;

		$.ajax({
			type : "post",
			dataType : "json",
			url : "AjaxTestController",
			data : {
				email_id : x
			},
			success : function(data) {
				document.getElementById('e1').value = data.email_id;
				document.getElementById('e2').value = data.email_password;
			}
		});
	}
	
</script>

<script type="text/javascript">
function myFunction() {
    var str1 = "Hello ";
    var str2 = "world!";
    var str3 = " Have a nice day!";
    var res = str1.concat(str2, str3);
    document.getElementById("demo").innerHTML = res;
}
</script>

</head>
<body>
<table width='600px' align='center' cellpadding='10' cellspacing='5' >
<tr align='left'>
<td bgcolor="#41e097"  align='right'>
ererer
</td>
<td bgcolor="#e8e8e8" >
ererer
</td>
</tr>
<tr align='left'>
<td bgcolor="#41e097" align='right'>
ererer
</td>
<td bgcolor="#e8e8e8">
erererssssssssssssssssssssssssssss
</td>
</tr>
</table>
	<select id="mySelect" onchange="myFunction(value)">
		<option value="Siwa Khongsuphap">Audi
		<option value="Pamon Intason">BMW
		<option value="Mercedes">Mercedes
		<option value="Volvo">Volvo
	</select>
	
	<input type="text" name="e1" id="e1" />
	<input type="text" name="e2" id="e2" />
	<input type="submit" class="btn btn-default" value="Submit"/>

<p id="demo"></p><button onclick="myFunction()">Try it</button>
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
</body>
</html>