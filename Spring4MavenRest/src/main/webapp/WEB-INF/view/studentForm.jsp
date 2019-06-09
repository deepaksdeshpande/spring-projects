<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
function forgotPassword() {
	alert("called");
	$.ajax({
		type : "POST",
		cache : false,
		url : "addStudent",
		success : function(response) {
			alert(response);
		}
	});
}
</script>
<title>Spring MVC Form Handling</title>
</head>
<h2>Student Data Form</h2>
<form:form action="addStudent" method="POST">
	<table>
		<tbody>
			<tr>
				<td><form:label path="studId">Student ID:</form:label></td>
				<td><form:input path="studId"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="name">StudentName :</form:label></td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="age">Student Age:</form:label></td>
				<td><form:input path="age"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"  />
				</td>
			</tr>
		</tbody>
	</table>
</form:form>
</body>
</html>