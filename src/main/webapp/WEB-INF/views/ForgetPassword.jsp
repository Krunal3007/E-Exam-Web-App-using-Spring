<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>ForgetPassword</h2>

<form action="forgetpassword" method="post">
	Email : <input type="email" name="emailForPass" > <br><br>
	
	<input type="submit" value="Submit">
</form>

${error}

</body>
</html>