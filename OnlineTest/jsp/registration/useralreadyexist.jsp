<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<jsp:include page="../includes/header.jsp" />
	<form:form id="createexamFormId" name="createexamForm" method="POST" action="/examhome.htm">
		<b>This email id is already registered with us. Please login with your username and password<br />
		In case you have forgotten your password please click on forgot password button.</b>
			<button type="button" class="btn btn-default" >Go Back</button>
	</form:form>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>