<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Exam</title>
</head>
<body>
<h2>New Exam</h2>

<form action="saveexam" method="post">

Subject : <select name="courseId">

			<option>--Select--</option>
			<c:forEach items="${courses }" var="c">
			
			<option value="${c.courseId }">${c.courseName }</option>
			
			</c:forEach>

		</select> <br><br>
		
Duration : <input type="text" name="duration"> <br><br>

Instructions : <textarea rows="4" cols="50" name="instructions"></textarea>

<input type="submit" value="Add Exam">

</form>

</body>
</html>