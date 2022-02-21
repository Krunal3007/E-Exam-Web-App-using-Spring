<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>

<form action="saveuser" method="post">
FirstName :<input type="text" name="firstName"> <br><br>
Email : <input type="email" name="email"> <br><br>
Password : <input type="password" name="password"> <br><br>
Phone No : <input type="text" name="phoneNo"> <br><br>
Address : <input type="text" name="address"> <br><br>
City : <input type="text" name="city"> <br><br>
State : <input type="text" name="state"> <br><br>
Pincode : <input type="number" name="pincode"> <br><br>
Role : <select name="roleId">

	<option>---Select Role---</option>
	<c:forEach items="${roles}" var="r">
	
	<option value="${r.roleId}">${r.roleName}</option>
	
	</c:forEach>

</select> <br><br>

<input type="submit" value="Add Role">


</form>

</body>
</html>