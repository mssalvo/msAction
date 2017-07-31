<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 			<c:if test="${not empty persons}">
 			<table>  
 			<c:forEach items="${persons}" var="person">
 			<tr>
 			<td>${person.nome}</td>
 			<td>${person.cognome}</td>
 			<td>${person.eta}</td>
 			<td>${person.telefono}</td>
 			<td>${person.email}</td>
			</tr>
 			</c:forEach>
 			</table>
 			</c:if>
</body>
</html>