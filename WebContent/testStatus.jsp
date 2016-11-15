<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div id="w">
    <h1>Simple Github API Webapp</h1>
    <p>Enter a single Github username below and click the button to display profile info via JSON.</p>
    
    <input type="text" name="ghusername" id="ghusername" placeholder="Github username...">

    <a href="#" id="ghsubmitbtn">Pull User Data</a> 
    
    <p id="demo"></p>
    <p id="demo2"></p>
    
    
  </div>
<script type="text/javascript">

$(function(){
  $('#ghsubmitbtn').on('click', function(e){
    e.preventDefault();
  
    var username = $('#ghusername').val();
    var requri   = 'https://api.github.com/users/'+username;
    var repouri  = 'https://api.github.com/users/'+username+'/repos';
    
    requestJSON(requri, function(json) {
      if(json.message == "Not Found" || username == '') {
        $('#ghapidata').html("<h2>No User Info Found</h2>");
      }
      
      else {
        // else we have a user and we display their info
        var fullname   = json.name;
        var username   = json.login;
        var aviurl     = json.avatar_url;
        var profileurl = json.html_url;
        var location   = json.location;
        var followersnum = json.followers;
        var followingnum = json.following;
        var reposnum     = json.public_repos;
        
        document.getElementById("demo").innerHTML = fullname;
        document.getElementById("demo2").innerHTML = reposnum
        
        if(fullname == undefined) { fullname = username; }
        

      } // end else statement
    }); // end requestJSON Ajax call
  }); // end click event handler
  
  function requestJSON(url, callback) {
    $.ajax({
      url: url,
      complete: function(xhr) {
        callback.call(null, xhr.responseJSON);
      }
    });
  }
});
</script>
</body>
</body>
</html>