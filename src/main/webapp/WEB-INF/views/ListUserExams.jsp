<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User Exams</title>
</head>
<body>
<h2>List User Exams</h2>


<table border="1">
<tr>
<th>Exam Id</th>
<th>Course Name</th>
<th>Duration</th>

<th>Instructions</th>
<th>Action</th>

</tr>

<c:forEach items="${exams }" var="e">		
<tr>

<td>${e.examId }</td>
<td><a>${e.courseName }</a></td>
<td>${e.duration }</td>

<td>${e.instructions }</td>

<td>
	<a href="showuserexamquestions?courseId=${e.courseId}">Start Exam</a>
</td>

</tr>


</c:forEach>


</table>



</body>
</html>