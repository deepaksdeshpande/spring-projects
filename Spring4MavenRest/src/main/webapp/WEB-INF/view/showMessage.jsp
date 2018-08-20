
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>${message}</h2>
		<br>
		<form:form method="get" action="studentForm"> <h2>Redirect Form</h2>
		<input type="submit" value="Redirect"  />
		</form:form>
	</body>
</html>
