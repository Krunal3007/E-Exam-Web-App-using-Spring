<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="updatepassword" method="post">

Email : <input type="email" name="loginEmail">
Otp : <input type="text" name="otp">
Password : <input type="password" name="loginPassword">
Confirm Password : <input type="password" name="confirmPassword">

<input type="submit" value="Update Password">

</form>

${error} ${msg}

</body>
</html>