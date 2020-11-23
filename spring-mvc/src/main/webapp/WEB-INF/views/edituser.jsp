<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome user: ${un }
<h1>edit user</h1>
<form:form method="post" action="/updateuser" modelAttribute="user">
	Userid: <form:input path="id"/>
	<br>
	Username: <form:input path="name"/>
	<br>
	<input type="submit" value="update user">
</form:form>

</body>
</html>