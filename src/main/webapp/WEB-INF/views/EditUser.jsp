<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<h2>Edit User</h2>

<form action="updateuser" method="post">

User Id : <input type="number" name="userId" value="${user.userId}" readonly> <br><br>
FirstName :<input type="text" name="firstName" value="${user.firstName}"> <br><br>
Email : <input type="email" name="email" value="${user.email}"> <br><br>
Password : <input type="password" name="password" value="${user.password}"> <br><br>
Phone No : <input type="text" name="phoneNo" value="${user.phoneNo}"> <br><br>
Address : <input type="text" name="address" value="${user.address}"> <br><br>
City : <input type="text" name="city" value="${user.city}"> <br><br>
State : <input type="text" name="state" value="${user.state}"> <br><br>
Pincode : <input type="number" name="pincode" value="${user.pincode}"> <br><br>
Is Active : <input type="number" name="isActive" value="${user.isActive}"><br><br>
Role : <input type="text" name="roleName" value="${user.roleName}" readonly><br><br>

<input type="submit" value="Update User">



</form>

</body>
</html>