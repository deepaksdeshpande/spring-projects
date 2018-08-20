<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" href="./jsp/images/HRMSlogo.png" />
<!-- Add custom CSS here -->
<link href="./jsp/css/logo-nav.css" rel="stylesheet">
</head>
<nav class="navbar-inverse navbar-fixed-top" role="navigation" style="position: absolute;">
	<div class="container">
	<div class="navbar-header" style="padding-left: 5%">

		<!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->
		<a class="navbar-nav" href="http://mhrd.gov.in" target="_blank"><img src="./jsp/images/MHRDsvg_logo_01.svg" height=80px></a>
	</div>

	<a class="navbar-brand navbar-right" href="http://www.iitb.ac.in" target="_blank" style="padding-right: 5%;"><img src="./jsp/images/iitb-logo.gif"></a>
	<ul class="nav navbar-nav navbar-left" style="margin-top: 0;">
		<li>
			<%if(session.getAttribute("advtName") != null) { %>
				<a><h3><%=session.getAttribute("advtName")%> Recruitment</h3></a>
			<%}%>
		</li>
	</ul>
	</div>
</nav>
