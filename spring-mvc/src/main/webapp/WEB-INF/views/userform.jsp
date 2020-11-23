<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome : ${un }
	<h1>add user</h1>
	<form:form method="post" action="/adduser" modelAttribute="user">
	Userid: <form:input path="id" />
		<br>
	Username: <form:input path="name" />
	<form:errors path="name"></form:errors>
		<br>
		<input type="submit" value="Add user">
	</form:form>
</body>
</html>