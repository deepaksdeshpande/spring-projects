<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 maximum-scale=1">
<!-- <meta charset = "UTF-8"> -->
<!-- <meta name = "viewport" content = "width=device-width , initail-scale=1.0"/> -->
<!-- <meta name = "description" content="" /> -->


<!-- Respond.js redirect location on local server -->
<script src="./jsp/js/respond.js" type="text/javascipt"></script>
<script src="./jsp/js/html5shiv.js" type="text/javascipt"></script>
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {
		$(".form-control").tooltip();
	});
</script>

<title><spring:message code="login.passwordrecovery" /></title>
<link href="./jsp/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap.css" media="all">

</head>
<body>
	<jsp:include page="../includes/header.jsp" />
	<div class="col-lg-12">
		<div class="container">
			<form:form class="form-horizontal" action="changePassword.htm" method="post">
				<input type="hidden" id="userId" name="userId" value="${userid}" />
				<div class="col-lg-11 panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-user fa-1x"></i> New Password Generation
						</h3>
					</div>
					<div class="panel panel-default">
						<div class="col-sm-offset-1 panel-body ">
							<c:choose>
								<c:when test="${wrong == 'wrong'}">
									<img alt="WRONG" src="./jsp/images/crossmark.png" width=100px height="100px"> Enter valid Password
						</c:when>
								<c:when test="${fail == 'fail'}">
									<img alt="FAIL" src="./jsp/images/Exclamationred.png" width=100px height="100px"> Password Updation Failed! Kindly retry after sometime.
						</c:when>
							</c:choose>
							<br /> <span style="padding-left: 40%; color: #3a87ad;"> <i class="fa fa-user fa-4x"></i>
							</span>
							<div class="form-group">
								<label for="addQuestionTag" class="col-sm-4 control-label"><spring:message code="forgotPassword.Email" /><br> <span><sub>(For which the password has to be changed)</sub></span></label>
								<div class="input-group col-sm-8">
									<span class="input-group-addon" style="color: rgb(50, 118, 177)"><i class="fa fa-envelope-o fa-fw"></i></span> <input type="email" class="form-control" name="email" id="email"
										value="${email}" readonly data-toggle="tooltip" data-placement="right" title="Your registered Email ID." style="width: 52%" />
								</div>
							</div>
							<div class="form-group">
								<label for="addQuestionTag" class="col-sm-4 control-label"><spring:message code="forgotPassword.newPassword" /><br> </label>
								<div class="input-group col-sm-8">
									<span class="input-group-addon" style="color: rgb(50, 118, 177)"><i class="fa fa-key fa-fw"></i></span> <input type="password" class="form-control" id="newPassword" name="newPassword"
										placeholder="Enter Your Password..." data-toggle="tooltip" data-placement="right" title="Enter New password" style="width: 52%">
								</div>
							</div>

							<div class="form-group">
								<label for="addQuestionTag" class="col-sm-4 control-label"><spring:message code="forgotPassword.confirmPassword" /><br> </label>
								<div class="input-group col-sm-8">
									<span class="input-group-addon" style="color: rgb(50, 118, 177)"><i class="fa fa-key fa-fw"></i></span> <input type="password" class="form-control" id="cnewPassword" name="cnewPassword"
										placeholder="Confirm Your Password" data-toggle="tooltip" data-placement="right" title="Enter Your Password again for confirmation" style="width: 52%">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" class="btn btn-outline btn-primary form-control" data-toggle="tooltip" data-placement="bottom" title="Submit to change your Password." style="width: 55%">
										<i class="fa fa-save"></i> Change Password
									</button>
								</div>
							</div>
						</div>
						<div class="panel-footer"></div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>