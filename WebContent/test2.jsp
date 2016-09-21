<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<script src="https://www.gstatic.com/firebasejs/3.4.0/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyBOue71UXOQh5aT1cVVCaXhbeAzuP4pUcM",
    authDomain: "dfproject-3984f.firebaseapp.com",
    databaseURL: "https://dfproject-3984f.firebaseio.com",
    storageBucket: "dfproject-3984f.appspot.com",
    messagingSenderId: "423694763898"
  };
  firebase.initializeApp(config);
  
  var database = firebase.database();
  var starCountRef = firebase.database().ref('user/ju');
  starCountRef.on('value', function(snapshot) {
	  writeUserData();
	  console.log(snapshot.val());
  });
 
  
  
  function writeUserData() {
	  firebase.database().ref('user/').set({
				hhh:'jjjj',
				name:'aaaaa'
	  });
	}
  
  
</script>
</body>
</html>