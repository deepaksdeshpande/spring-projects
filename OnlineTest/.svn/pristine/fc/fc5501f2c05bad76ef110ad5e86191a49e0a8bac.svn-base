<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession httpSession = request.getSession(false);
	if(httpSession.getAttribute("email") == null || httpSession.getAttribute("email").toString() == null) { %>
		<jsp:forward page="/sessionexpired.htm" />
<% } else { %>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/admin-menu.jsp" %>
<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--[if IE 8]><html class="lt-ie10 ie8" lang="en data-scribe-reduced-action-queue="true""><![endif]-->
<!--[if IE 9]><html class="lt-ie10 ie9" lang="en data-scribe-reduced-action-queue="true""><![endif]-->
<!--[if gt IE 9]><!--><html lang="en" data-scribe-reduced-action-queue="true"><!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 maximum-scale=1">
<title><spring:message code="onlinetest.addquestion.title" /></title>
<script type="text/javascript" src="./jsp/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="./jsp/js/css3-mediaqueries.js"></script>
<script type="text/javascript" src="./jsp/js/html5shiv.js"></script>
<script type="text/javascript" src="./jsp/js/IESupport.js"></script>
<script type="text/javascript" src="./jsp/js/respond.js"></script>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Insert title here</title>
</head>
<body><br /><br /><br /><br /><br /><br /><br /><br />
	<div class="container">
		<form class="form-horizontal" action="home.htm" method="post">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa fa-user fa-1x"></i> Question Added Successfully</h3>
				</div>
				<div class="panel-body">
					<span><img src="./jsp/images/tickmark.png" alt="Error" class="img-circle" height="140" width="140"></span>
					<span>You have added the Question Successfully to the Question Bank. To add another question to the Question Bank please <i class="fa fa-hand-o-right fa-1x"></i><button class="btn btn-link" formaction="addquestion.htm">click here</button>.</span>
					
				</div>
				<div class="panel-footer"></div>
			</div>
		</form>
	</div>
</body>
</html>
<%@include file="../includes/footer.jsp" %>
<%}%>