<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Your Result</h2>

<table border="1">
<tr>
<th>Total Marks</th>
<th>Obtain Marks</th>
<th>Status</th>
</tr>




<tr>

<td>${userExamAnswer.totalMarks}</td>
<td>${userExamAnswer.obtainMarks}</td>
<td>
<c:if test="${userExamAnswer.isPass == 1 }">Pass</c:if>
<c:if test="${userExamAnswer.isPass == 0}">Fail</c:if>
</td>

</tr>



</table>


</body>
</html>