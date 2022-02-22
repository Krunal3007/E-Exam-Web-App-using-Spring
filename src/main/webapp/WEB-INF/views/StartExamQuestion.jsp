<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Start Exam</title>
</head>
<body>
<h2>Start Exam</h2>

<form action="startexam" method="get">

Subject : <select name="courseId">

		<option>--Select--</option>
		<c:forEach items="${courses }" var="r">
		
			<option value="${r.courseId }">${r.courseName }</option>
		
		</c:forEach>

		</select> <br><br>
		
<input type="submit" value="Start">

</form>

</body>
</html>