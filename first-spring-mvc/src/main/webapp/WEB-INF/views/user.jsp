<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>User Home Page</h2>
	<a href="adduserform">Add User</a>
	<table>
		<tr>
			<th>Userid</th>
			<th>Username</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td><a href="deleteuser/${user.id}">Delete User</a></td>
				<td><a href="edituser/${user.id}">Update User</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>