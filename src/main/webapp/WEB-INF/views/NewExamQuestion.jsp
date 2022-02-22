<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Exam Questions</title>
</head>
<body>
<h2>New Exam Questions</h2>

<form action="saveexamquestion" method="post">

Question Name : <input type="text" name="questionName">  <br><br>
Question Marks : <input type="number" name="questionMarks"> <br><br>
Question Answer : <input type="text" name="questionAnswer"> <br><br>

Course Name : <select name="courseId">

				<option>---Select Course---</option>
				<c:forEach items="${courses}" var="c">
				
				<option value="${c.courseId }">${c.courseName}</option>
				
				</c:forEach>
				

			</select> <br><br>
			
Option 1 : <input type="text" name="option1"><br><br>
Option 2 : <input type="text" name="option2"> <br><br>
Option 3 : <input type="text" name="option3"><br><br>
Option 4 : <input type="text" name="option4"><br><br>

<input type="submit" value="Add Question">



</form>

</body>
</html>