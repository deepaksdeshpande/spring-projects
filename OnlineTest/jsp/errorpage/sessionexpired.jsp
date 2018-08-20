<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]><html class="lt-ie10 ie8" lang="en data-scribe-reduced-action-queue="true""><![endif]-->
<!--[if IE 9]><html class="lt-ie10 ie9" lang="en data-scribe-reduced-action-queue="true""><![endif]-->
<!--[if gt IE 9]><!--><html lang="en" data-scribe-reduced-action-queue="true"><!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./jsp/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./jsp/js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="./jsp/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="./jsp/css/logo-nav.css">
</head>
<body><br /><br /><br /><br /><br />
	<div class="container">
    	<%@include file="../includes/header.jsp" %>
		<form class="form-horizontal" action="home.htm" method="post">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa fa-user fa-1x"></i> Session Expired</h3>
				</div>
				<div class="panel-body">
					<span><img src="./jsp/images/Exclamationred.png" alt="Error" class="img-circle" height="140" width="140"></span>
					<span>You have either timed out due to inactivity or you have already logged out and tried to come back. Please <i class="fa fa-hand-o-right fa-1x"></i> <a href="predisplayeditadvertisementpage.htm">click here to login</a> again.</span>
					
				</div>
			</div>
		</form>
	</div>		
	
</body>
</html>
<%@include file="../includes/footer.jsp" %>