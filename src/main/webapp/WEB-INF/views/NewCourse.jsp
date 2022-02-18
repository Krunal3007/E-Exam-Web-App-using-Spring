<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Course</title>
</head>
<body>
<h2>New Course</h2>

<form action="savecourse" method="post">
 Course Name : <input type="text" name="courseName"> <br><br>
 Is Active : <input type="number" name="isActive"> <br><br>
 Description : <textarea rows="4" cols="50" name="description"></textarea> <br><br>
 <input type="submit" value="Submit">
</form>

</body>
</html>