<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@include file="../includes/header.jsp"%> --%>
<!DOCTYPE html>
<html lang="en" data-scribe-reduced-action-queue="true">
<!--<![endif]-->
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 maximum-scale=1">
<!-- <meta charset = "UTF-8"> -->
<!-- <meta name = "viewport" content = "width=device-width , initail-scale=1.0"/> -->
<!-- <meta name = "description" content="" /> -->


<title><spring:message code="login.title" /></title>
<!-- Respond.js redirect location on local server -->
<script src="./jsp/js/respond.js" type="text/javascipt"></script>
<script src="./jsp/js/html5shiv.js" type="text/javascipt"></script>
<script type="text/javascript" src="./jsp/js/ToggleAccordianImage.js"></script>
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="./jsp/js/newsticker/jquery.easing.min.js"></script>
<script type="text/javascript" src="./jsp/js/newsticker/jquery.easy-ticker.js"></script>
<script type="text/javascript" src="./jsp/js/slidepanel/jquery.slidePanel.js"></script>
<!-- <script src="./jsp/js/validation/validator.js"></script> -->

<script src="./jsp/js/angular.min.js"></script>
<script src="./jsp/js/app.js"></script>

<script type="text/javascript">
	$(function() {
		$(".form-control").tooltip();
	});
</script>

<script type="text/javascript">
	function redirect(path) {
		document.menuForm.action = path;
		document.menuForm.submit();
	}

	function forgotPassword() {
		$.ajax({
			type : "POST",
			cache : false,
			url : "forgot.htm",
			success : function(response) {
				document.getElementById("forgotPassword").innerHTML = response;
			}
		});
	}

	function validateForgotPassForm() {
		var result = true;
		var email = document.getElementById('emailId').value;
		var emailRegX = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		if (!email.match(emailRegX)) {
			result = false;
			$('#emailId').addClass('has-error');
			document.getElementById('error').style.display = "block";
		} else {
			document.getElementById('error').style.display = "none";
			$.ajax({
				type : "POST",
				cache : false,
				url : "forgotPasswordFormAction.htm",
				data : "emailId=" + email,
				success : function(response) {
					if(response.trim() == "notReg") {
						$('#errorReg').show();
					}
					if(response.trim() == 'reg') {
						location.replace("forgotPasswordLinkSend.htm");
					}
				}
			});
		}
		return result;
	}

	function addErrorMsgForForgotPass() {
		$('#error').html('<div class="alert alert-danger alert-dismissable col-sm-offset-2 col-sm-6">'+
				'<button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="addErrorMsgForForgotPass()">&times;</button>'+
				'<p>Enter valid email.</p></div>');
		$('#error').hide();
	}
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var pageTitle = document.title; //HTML page title
						var pageUrl = location.href; //Location of the page

						//user hovers on the share button	
						$('#share-wrapper li').hover(function() {
							var hoverEl = $(this); //get element

							//browsers with width > 699 get button slide effect
							if ($(window).width() > 699) {
								if (hoverEl.hasClass('visible')) {
									hoverEl.animate({
										"margin-left" : "-120px"
									}, "fast").removeClass('visible');
								} else {
									hoverEl.animate({
										"margin-left" : "0px"
									}, "fast").addClass('visible');
								}
							}
						});

						//user clicks on a share button
						$('.button-wrap')
								.click(
										function(event) {
											var shareName = $(this).attr(
													'class').split(' ')[0]; //get the first class name of clicked element

											switch (shareName) //switch to different links based on different social name
											{
											case 'facebook':
												var openLink = 'https://www.facebook.com/sharer/sharer.php?u='
														+ encodeURIComponent(pageUrl)
														+ '&amp;title='
														+ encodeURIComponent(pageTitle);
												break;
											case 'twitter':
												var openLink = 'http://twitter.com/home?status='
														+ encodeURIComponent(pageTitle
																+ ' ' + pageUrl);
												break;
											case 'digg':
												var openLink = 'http://www.digg.com/submit?phase=2&amp;url='
														+ encodeURIComponent(pageUrl)
														+ '&amp;title='
														+ encodeURIComponent(pageTitle);
												break;
											case 'stumbleupon':
												var openLink = 'http://www.stumbleupon.com/submit?url='
														+ encodeURIComponent(pageUrl)
														+ '&amp;title='
														+ encodeURIComponent(pageTitle);
												break;
											case 'delicious':
												var openLink = 'http://del.icio.us/post?url='
														+ encodeURIComponent(pageUrl)
														+ '&amp;title='
														+ encodeURIComponent(pageTitle);
												break;
											case 'google':
												var openLink = 'https://plus.google.com/share?url='
														+ encodeURIComponent(pageUrl)
														+ '&amp;title='
														+ encodeURIComponent(pageTitle);
												break;
											case 'email':
												var openLink = 'mailto:?subject='
														+ pageTitle
														+ '&body=Found this useful link for you : '
														+ pageUrl;
												break;
											}

											//Parameters for the Popup window
											winWidth = 650;
											winHeight = 450;
													winLeft = ($(window)
															.width() - winWidth) / 2,
													winTop = ($(window)
															.height() - winHeight) / 2,
													winOptions = 'width='
															+ winWidth
															+ ',height='
															+ winHeight
															+ ',top=' + winTop
															+ ',left='
															+ winLeft;

											//open Popup window and redirect user to share website.
											window.open(openLink,
													'Share This Link',
													winOptions);
											return false;
										});
					});
</script>

<link href="./jsp/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="./jsp/css/slider.css" media="all">

<style type="text/css">
.fa-compress {
	color: #3a87ad;
}

input.ng-valid {
	border: 1px solid green;
}
</style>

</head>
<body ng-app="validationApp" ng-controller="mainController">
	<div class="row">
		<div class="panel-body">
			<div id="forgotPassword" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
		</div>
	</div>
	<jsp:include page="../includes/header.jsp" />
	<div class="col-md-1">
		<div id="share-wrapper">
			<ul class="share-inner-wrp">
				<!-- Facebook -->
				<li class="facebook button-wrap"><a href="#">Share</a></li>

				<!-- Twitter -->
				<li class="twitter button-wrap"><a href="#">Tweet it</a></li>

				<!-- LinkedIn -->
				<li class="linked button-wrap"><a href="#">Linked In</a></li>

				<!-- Google -->
				<li class="google button-wrap"><a href="#"><b>g<sup>+</sup></b> Share</a></li>
			</ul>
		</div>
	</div>
	<%
		String error = null;
		try {
			error = (String) session.getAttribute("error");
		} catch (Exception e) {
			error = null;
		} finally {
			session.removeAttribute("error");
		}
	%>
	<div class="wrapper">
		<div class="col-lg-12">
			<div class="container">
				<form:form name="loginForm" class="form-horizontal" ng-submit="submitForm(loginForm.$valid)" data-toggle="validator" action="examhome.htm" method="post">
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-8 panel-info" style="float: left;">
								<div class="panel-heading ">
									<h3 class="panel-title">
										<i class="fa fa-list-alt"></i> Click on posts for further details
									</h3>
								</div>
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="panel-body">
											<div class="panel-group" id="accordion">
												<c:forEach var="post" items="${posts}">
													<div class="panel panel-default">
														<div class="panel-heading">
															<h4 class="panel-title">
																<a data-toggle="collapse" data-parent="#accordion" href="#collapse${post.designationId}" onclick="changeAccordionImage('${post.designationId}')">${post.designationName} <i
																	id="accordionImage${post.designationId}" class="fa fa-expand pull-right"></i></a>
															</h4>
														</div>
														<div id="collapse${post.designationId}" class="panel-collapse collapse">
															<div class="panel-body" style="background-color: #fffefa">${post.designationDescription}</div>
															<div class="panel-footer"></div>
														</div>
													</div>
												</c:forEach>
											</div>
										</div>
									</div>
									<div class="panel-footer"></div>
								</div>
							</div>
							<!-- 						/.col-lg-12 -->
							<div class="col-lg-4 panel-info" style="float: right;">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-user fa-1x"></i> Online Examination - Login
									</h3>
								</div>
								<div class="panel panel-default">
									<div class="panel-body ">
										<span style="padding-left: 40%; color: #3a87ad;"> <i class="fa fa-user fa-4x"></i>
										</span>
										<div class="form-group" ng-class="{ 'has-error' : loginForm.email.$invalid && loginForm.email.$dirty }">
											<label for="emailId" class="col-sm-2 control-label"><spring:message code="login.label.email" /></label>
											<div class="input-group col-sm-8">
												<span class="input-group-addon" style="color: rgb(50, 118, 177)"><i class="fa fa-envelope-o fa-fw"></i></span> <input type="email" class="form-control" name="email" id="emailId"
													placeholder="Enter Your Email..." data-toggle="tooltip" data-placement="left" title="Please enter the Email ID your registered with us." ng-model="email" maxlength="60" required />
											</div>
											<p class="help-block"></p>
											<div class="clearfix"></div>
											<div class="help-block with-errors col-sm-offset-2 col-sm-8">
												<!-- 												<span class="has-error help-block" ng-show="loginForm.email.$error.required && !loginForm.email.$pristine">Required!</span> -->
												<!-- 												<span class="has-error help-block" ng-show="loginForm.email.$invalid && !loginForm.email.$pristine">Not valid Email!</span>	 -->
												<p ng-show="loginForm.email.$invalid && loginForm.email.$dirty" class="help-block">Enter a valid email.</p>
												
												<%
													if (error != null && error.equalsIgnoreCase("errorEmail")) {
												%>
												<div id="notRegistered" class="alert alert-danger alert-dismissable col-sm-12">
													<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
													<p>
														Entered Email is <i>not registered</i> with us.
													</p>
												</div>
												<%
													}
												%>
											</div>
										</div>
										<div class="form-group" ng-class="{ 'has-error' : loginForm.password.$invalid && !loginForm.password.$pristine }">
											<label for="password" class="col-sm-2 control-label"><spring:message code="login.label.password" /></label>
											<div class="input-group col-sm-8">
												<span class="input-group-addon" style="color: rgb(50, 118, 177)"><i class="fa fa-key fa-fw"></i></span> <input type="password" class="form-control" id="password" name="password" required
													placeholder="Enter Your Password..." required data-toggle="tooltip" data-placement="left" title="Enter Your password." ng-model="password" required>
											</div>
											<p class="help-block"></p>
											<div class="clearfix"></div>
											<div class=" col-sm-offset-4 col-sm-8">
												<span class="has-error help-block" ng-show="loginForm.password.$error.required && !loginForm.password.$pristine">Required!</span>
											</div>
											<div class="help-block with-errors col-sm-offset-2 col-sm-8">
												<%
													if (error != null && error.equalsIgnoreCase("errorPassword")) {
												%>
												<div id="notRegistered" class="alert alert-danger alert-dismissable col-sm-12">
													<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
													<p>
														Entered password does not match with the given email.
													</p>
												</div>
												<%
													}
												%>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-8">
												<button type="submit" class="btn btn-primary btn-block">
													<i class="fa fa-sign-in"></i> Sign in
												</button>
												<div class="clearfix"></div>

												<%
													if (error != null && error.equalsIgnoreCase("error")) {
												%>
												<div id="notRegistered" class="alert alert-danger alert-dismissable col-sm-12">
													<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
													<p>
														Error during login! <br />Check credentials or use forgot password.
													</p>
												</div>
												<%
													}
												%>
												<%-- 												<c:choose> --%>
												<%-- 													<c:when test="${error el 'loginerror'}"> --%>
												<!-- 														<div id="notRegistered" class="help-block with-errors col-sm-12"> -->
												<!-- 															<p>Error during login! <br/>Check credentials or use forgot password.</p> -->
												<!-- 														</div> -->
												<%-- 													</c:when> --%>
												<%-- 												</c:choose> --%>
											</div>
										</div>

										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-8">
												<a onclick="forgotPassword()" data-toggle="modal" data-target="#forgotPassword" href="#">Forgot Password?</a> &nbsp;&nbsp;<span>|</span> &nbsp; <a href="registration.htm"
													class="pull-right" onclick="redirect('registration.htm')">Sign Up!</a>
											</div>
											<div class="col-sm-offset-2 col-sm-8"></div>
										</div>
									</div>
									<div class="panel-footer"></div>
								</div>
							</div>
							<!-- 						/.row -->
							<div class="col-lg-4 panel-info" style="float: right;">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-globe fa-spin"></i> News and Announcements
									</h3>
								</div>
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="vticker">
											<ul class="list-unstyled">
												<li>
													<div class="alert alert-info">
														New Recruitment Portal for MHRD-Project job openings at IIT Bombay is up. <a href="#" class="alert-link"></a>
													</div>
												</li>
												<li>
													<div class="alert alert-info">
														Recruitment for Spoken Tutorial Advertisement started on January 2014. <a href="#" class="alert-link">Spoken Tutorial Advertisement Started</a>.
													</div>
												</li>
												<li>
													<div class="alert alert-info">
														Recruitment for Spoken Tutorial Advertisement ended on January 2014. <a href="#" class="alert-link">Spoken Tutorial Advertisement Ended</a>.
													</div>
												</li>
												<li>
													<div class="alert alert-info">
														Registered candidates can login in the new Recruitment interface and check their profile and Applied positions <a href="#" class="alert-link">Click for details</a>.
													</div>
												</li>
											</ul>
										</div>
									</div>
									<div class="panel-footer"></div>
								</div>
							</div>
						</div>
					</div>
					<div id="social"></div>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>

<script type="text/javascript">
	$(document).ready(function() {

		var dd = $('.vticker').easyTicker({
			direction : 'up',
			easing : 'swing',
			speed : 'slow',
			interval : 2000,
			height : 'auto',
			visible : 3,
			mousePause : 1,
			controls : {
				up : '.up',
				down : '.down',
				toggle : '',
				stopText : 'Stop !!!'
			}
		}).data('easyTicker');
	});
</script>

</html>