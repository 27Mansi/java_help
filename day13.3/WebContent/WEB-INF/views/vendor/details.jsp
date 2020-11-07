<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${requestScope.mesg}</h4>
	<h5>Vendor details : ${sessionScope.user_dtls}</h5>
	<table style="background-color: cyan; margin: auto;" border="1">
		<caption>A/C Summary</caption>
		<c:forEach var="ac" items="${sessionScope.user_dtls.accounts}">
			<tr>
				<td>${ac.acctId}</td>
				<td>${ac.type}</td>
				<td>${ac.balance}</td>
			</tr>
		</c:forEach>
	</table>
	<h5>
		<a href="<spring:url value='/acct/create'/>">Create New A/C</a>
	</h5>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Me Out</a>
	</h5>
</body>
</html>