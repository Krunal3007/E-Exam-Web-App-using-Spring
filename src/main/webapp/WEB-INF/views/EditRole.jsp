<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Role</title>
</head>
<body>
<h2>Edit Role</h2>

<form action="updaterole" method="post">

Role Id :<input type="number" name="roleId" value="${role.roleId}" readonly><br><br>
RoleName :<input type="text" name="roleName" value="${role.roleName}"><br> <br>
<input type="submit" value="Update Role">

</form>

</body>
</html>