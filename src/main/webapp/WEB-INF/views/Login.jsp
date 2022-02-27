<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login</h2>

	<form action="login"  method="post">
	
	Email :<input type="email" name="loginEmail"> <br><br>
	Password :<input type="password" name="loginPassword"> <br><br>
	<input type="submit" value="Login">
	</form>

	${error} ${msg}
	<br>
	
	<a href="signup">New User?</a>
	<a href="forgetpassword">ForgetPassword</a>

</body>
</html>