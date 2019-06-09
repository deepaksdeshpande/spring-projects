<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Submitted Student Information</h2>
	<table border="1">
		<tbody>
			<tr>
				<td>Student ID</td>
				<td>${studId}</td>
			</tr>
			<tr>
				<td>Student Name</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>Student Age</td>
				<td>${age}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>