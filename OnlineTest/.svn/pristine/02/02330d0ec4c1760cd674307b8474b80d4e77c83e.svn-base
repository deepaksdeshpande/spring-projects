<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./jsp/css/dataTables.bootstrap.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../includes/admin-menu.jsp" />
	<p style="padding-left: 5%"><img alt="Done" src="./jsp/images/valid.png"> indicates that a user's photo is being already uploaded.</p>
	<hr>
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="fileUpload.htm">
		<table>
			<c:forEach var="userDetails" items="${userDetailsList}">
				<tr>
					<td>Upload Image for <b>${userDetails.name}</b>&nbsp;</td>
					<td><input id="userImage" type="file" name="userImage" /></td>
					<td><input type="submit" class="btn btn-info" value="Upload" /></td>
					<td style="color: red; font-style: italic;"><form:errors path="file" /></td>
					<c:choose>
						<c:when test="${not empty userDetails.userPhoto}">
							<td><img alt="Done" src="./jsp/images/valid.png"></td>
						</c:when>
					</c:choose>
				</tr>
				<input id="imageName" name="imageName" type="hidden" value="${userDetails.userDetailsId}" />
			</c:forEach>
		</table>
	</form:form>
	<footer>
		<%@include file="../includes/footer.jsp"%>
	</footer>
	<script src="./jsp/js/jquery-1.10.2.js"></script>
	<script src="./jsp/js/bootstrap.js"></script>
</body>
</html>