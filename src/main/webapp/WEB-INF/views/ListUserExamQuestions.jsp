<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User Exam Questions</title>
</head>
<body>
<h2>List User Exam Questions</h2>


Subject : ${course.courseName }

<form action="saveuserexam" method="post">


<ol type="1">
<c:forEach items="${questions}" var="q" >
	
	Marks : ${q.questionMarks }
	
<li>
	${q.questionName } 
	<input type="hidden" name="userExamQuestionId" value="${q.questionId }">
	
		<br>
		
		<input type="radio"  name="answer[${q.questionId }]"  value="${q.option1 }">
		${q.option1 }
		<br>
			
		
	
		<input type="radio"  name="answer[${q.questionId }]" value="${q.option2 }">
		${q.option2 }
		<br>
			
		
			
		<input type="radio" name="answer[${q.questionId }]" value="${q.option3 }">
		${q.option3 }
		<br>
			
		
		
		<input type="radio"  name="answer[${q.questionId }]" value="${q.option4 }">
		${q.option4 }
		
		
		<br><br>
		
	
</li>

</c:forEach>
</ol>


 


<input type="submit" value="Submit">

</form>

</body>
</html>