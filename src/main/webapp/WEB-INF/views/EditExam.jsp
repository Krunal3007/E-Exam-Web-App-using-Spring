<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Exam</title>
</head>
<body>
<h2>Edit Exam</h2>

<form action="updateexam" method="post">
Exam Id :<input type="number" name="examId" value="${exam.examId }" readonly> <br><br>
Duration : <input type="text" name="duration" value="${exam.duration }"> <br><br>
Instructions : <input type="text" name="instructions" value="${exam.instructions }"> <br><br>

<input type="submit" value="Update Exam">

</form>

</body>
</html>