<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>SignUp</h2>
<form action="signupsaveuser" method="post">
	First Name:<input type="text" name="signupFirstName"> <br><br>
	Email :<input type="email" name="signupEmail"> <br><br>
	Password :<input type="password" name="sighupPassword"> <br><br>
	
	<input type="submit" value="Submit">

</form>

<a href="login">Login</a>

</body>
</html>