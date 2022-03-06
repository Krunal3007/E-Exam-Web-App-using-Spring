<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Given Exams</title>
</head>
<body>
<h2>User Given Exams</h2>
${msg }
<table border="1">
<tr>
<th>ExamId</th>
<th>Exam Name</th>
<th>Action</th>
</tr>


<c:forEach items="${examId }"  var="e" varStatus="status" >

<tr>

<td>${e}</td>
<td>${courseName[status.index] }</td>


<td>
	<a href="viewuserresult?examId=${e}">View Result</a>
</td>

</tr>

</c:forEach>

</table>

</body>
</html>