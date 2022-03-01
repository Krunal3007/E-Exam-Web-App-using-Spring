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
<th>Instructions</th>


<th>Exams</th>
<th>Action</th>

<th>Information</th>

</tr>

<c:forEach items="${exams }" var="e">
<tr>

<td>${e.examId }</td>
<td><a>${e.courseName }</a></td>
<td>${e.duration }</td>
<td>${e.instructions }</td>


<td><a href="showexamquestions?courseId=${e.courseId }">Exam Questions</a></td>
<td><a href="deleteexam/${e.examId }">Delete</a> |
	<a href="editexam?examId=${e.examId }">Edit</a> |
	
	
</td>

<td><a href="showallexamquestions?courseId=${e.courseId}">All Questions</a>  |
	Total Questions : ${e.noOfQuestion } |
	Total Marks : ${e.totalMarks }
</td>
</tr>


</c:forEach>




</table>

</body>
</html>