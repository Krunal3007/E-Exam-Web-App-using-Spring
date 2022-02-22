<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Exam Questions</title>
</head>
<body>
<h2>List Exam Questions</h2>

<a href="newexamquestion">Add Question</a>
<table border="1">
<tr>
<th>Question Id</th>
<th>Question Name</th>
<th>Question Marks</th>
<th>Question Answer</th>
<th>Course Name</th>
<th>Option 1</th>
<th>Option 2</th>
<th>Option 3</th>
<th>Option 4</th>
<th>Action</th>

</tr>

<c:forEach items="${questions}" var="q"> 

<tr>
<td>${q.questionId}</td>
<td>${q.questionName}</td>
<td>${q.questionMarks}</td>
<td>${q.questionAnswer}</td>
<td>${q.courseName}</td>
<td>${q.option1}</td>
<td>${q.option2}</td>
<td>${q.option3}</td>
<td>${q.option4}</td>
<td><a href="deleteexamquestion/${q.questionId}">Delete</a> |
	<a href="editexamquestion?questionId=${q.questionId}">Edit</a>
</td> 

</tr>

</c:forEach>


</table>


</body>
</html>