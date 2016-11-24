<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
          $(document).ready(function(){
              $(".uname").change(function(){
                  var uname = $(this).val();
                  if(uname.length >= 3){
                      $(".status").html("<img src='images/loading.gif'><font color=gray> Checking availability...</font>");
                      
                  }
                  else{
                       
                      $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");
                  }
                  
              });
          });
          
          
        </script>
        
        
        

</head>

<body>


	<jsp:include page="navbar.jsp" />

		<div>
		<label class="flable">User Name :</label> <input type="text"
			class="uname" />&nbsp;<span class="status"></span>
			<%
			String str = "<script>document.writeln(uname)</script>";
		    out.println("value: " + str);
			
	 try {

        String connectionURL = "jdbc:mysql://localhost/projectdb";
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionURL, "root", "password");
        String uname = request.getParameter("uname");
	
        PreparedStatement ps = connection.prepareStatement("select username from user where username=?");
        ps.setString(1,uname);
        
        
        ResultSet rs = ps.executeQuery();
         
        if (!rs.next()) {
        	String msg = uname+" is avaliable";
        	System.out.println(msg);
        	out.println(msg);
        	request.setAttribute("m", msg);	               
   
        }
        else{
        out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
        System.out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
        }
        out.println();



    } catch (Exception ex) {

        out.println("Error ->" + ex.getMessage());

    } finally {
        out.close();
    } %>
    </div>
</body>
</html>