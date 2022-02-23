<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Exam Question</title>
</head>
<body>
<h2>Edit Exam Question</h2>

<form action="updateexamquestion" method="post">

Question Id :<input type="number" name="questionId" readonly value="${question.questionId }"><br><br>
Question Name : <input type="text" name="questionName" value="${question.questionName }">  <br><br>
Question Marks : <input type="number" name="questionMarks" value="${question.questionMarks }"> <br><br>
Question Answer : <input type="text" name="questionAnswer" value="${question.questionAnswer }"> <br><br>

Course Name : <input type="text" name="courseName" value="${question.courseName }" readonly> <br><br>
<input type="hidden" name="courseId" value="${question.courseId }" readonly> <br><br>
			
Option 1 : <input type="text" name="option1" value="${question.option1 }"><br><br>
Option 2 : <input type="text" name="option2" value="${question.option2 }"> <br><br>
Option 3 : <input type="text" name="option3" value="${question.option3 }"><br><br>
Option 4 : <input type="text" name="option4" value="${question.option4 }"><br><br>

Is Active : <input type="number" name="isActive" value="${question.isActive }">

<input type="submit" value="Update Question">

</form>



</body>
</html>