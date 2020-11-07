<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Choose A/C Type</td>
				<td><select name="ac_type">
						<c:forEach var="t" items="${requestScope.ac_types}">
							<option value="${t}">${t}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter Opening Balance</td>
				<td><input type="number" name="balance" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create A/C" /></td>
			</tr>
		</table>
	</form>

</body>
</html>