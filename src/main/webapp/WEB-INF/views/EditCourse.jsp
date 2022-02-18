<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Course</title>
</head>
<body>
<h2>Edit Course</h2>
<form action="updatecourse" method="post">
Course Id :<input type="number" name="courseId" value="${course.courseId}" readonly> <br><br>
Course Name :<input type="text" name="courseName" value="${course.courseName}"> <br><br>
Description :<textarea name="description" rows="4" cols="50" >${course.description}</textarea > <br><br>
Is Active : <input type="number" name="isActive" value="${course.isActive}"><br><br>
<input type="submit" value="Update Course">


</form>

</body>
</html>