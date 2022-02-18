<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Courses</title>
</head>
<body>
<h2>List Courses</h2>

<a href="newcourse">Add Course</a>
<table border=1>
<tr>
<th>Course Id</th>
<th>Course Name</th>
<th>Is Active</th>
<th>Description</th>
<th>Action</th>
</tr>

<c:forEach items="${courses}" var="course">
<tr>
<td>${course.courseId}</td>
<td>${course.courseName}</td>
<td>${course.isActive}</td>
<td>${course.description}</td>
<td><a href="deletecourse/${course.courseId}">Delete</a> |
	<a href="editcourse?courseId=${course.courseId}">Edit</a>
</td>

</tr>

</c:forEach>

</table>

</body>
</html>