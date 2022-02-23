<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Exams</title>
</head>
<body>
<h2>List Exams</h2>


<a href="newexam">Add Exam</a>
<table border="1">
<tr>
<th>Exam Id</th>
<th>Course Name</th>
<th>Duration</th>
<th>No Of Question</th>
<th>Instructions</th>
<th>Total Marks</th>
<th>Action</th>
</tr>

<c:forEach items="${exams }" var="e">
<tr>

<td>${e.examId }</td>
<td><a>${e.courseName }</a></td>
<td>${e.duration }</td>
<td>${e.noOfQuestion }</td>
<td>${e.instructions }</td>
<td>${e.totalMarks }</td>
<td><a href="deleteexam/${e.examId }">Delete</a> |
	<a href="editexam?examId=${e.examId }">Edit</a>
</td>

</tr>


</c:forEach>


</table>

</body>
</html>