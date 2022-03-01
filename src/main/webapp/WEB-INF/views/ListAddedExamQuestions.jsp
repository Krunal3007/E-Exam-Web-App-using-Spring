<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Added Exam Questions</title>
</head>
<body>
<h2>List Added Exam Questions</h2>


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
<td>${courseName}</td>
<td>${q.option1}</td>
<td>${q.option2}</td>
<td>${q.option3}</td>
<td>${q.option4}</td>
<td><a href="deletequestionfromexamquestion/${q.questionId}">Delete</a> 
	

	
</td> 

</tr>

</c:forEach>


</table>


</body>
</html>