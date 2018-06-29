<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form modelAttribute="getsetclass" method ="post" action="LoginProcess">
		<table>
			<tr>
				<td>Email</td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
				<tr>
				<td></td>
				<td><form:button id="login" name="login">Login</form:button>
				</td>
			</tr>

		</table>
	</form:form>
</body>
</html>
