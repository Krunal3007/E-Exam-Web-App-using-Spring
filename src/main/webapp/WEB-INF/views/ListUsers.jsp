<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
</head>
<body>
<h2>List Users</h2>


<a href="newuser">Add User</a>
<table border="1">
<tr>
<th>User Id</th>
<th>First Name</th>
<th>Email</th>
<th>Password</th>
<th>Xender</th>
<th>Phone No</th>
<th>Address</th>
<th>City</th>
<th>State</th>
<th>Pincode</th>
<th>RoleName</th>
<th>Action</th>



</tr>

 <c:forEach items="${users}" var="u">
 
 <tr>
 <td>${u.userId}</td>
 <td>${u.firstName }</td>
 <td>${u.email }</td>
 <td>${u.password }</td>
 <td>${u.xender }</td>
 <td>${u.phoneNo }</td>
 <td>${u.address }</td>
 <td>${u.city }</td>
 <td>${u.state }</td>
 <td>${u.pincode }</td>
 <td>${u.roleName }</td>
 <td><a href="deleteuser/${u.userId}">Delete</a> | 
 	<a href="edituser?userId=${u.userId }">Edit</a>
 </td>
 
 </tr>
 
 </c:forEach>

</table>

</body>
</html>