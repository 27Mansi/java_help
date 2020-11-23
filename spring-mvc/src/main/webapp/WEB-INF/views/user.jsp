<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	welcome user: ${un }
	<a href="showuserform">add user</a>
	<table border="1">
		<tr>
			<td>Userid</td>
			<td>username</td>
		</tr>		
	<c:forEach var="user" items="${users}">
	<tr>
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td><a href="user/${user.id }">delete</a></td>
			<td><a href="edituser/${user.id }">update</a></td>
		</tr>
	</c:forEach>
		
	</table>
</body>
</html>