<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registration</title>
<!-- SB Admin CSS - Include with every page -->
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/jqBootstrapValidation.js"></script>
<script src="./jsp/js/jquery.validate.min.js"></script>
<!--<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> -->
<script src="./jsp/js/jquery.validate.min.js"></script>
<script src="./jsp/js/registrationformvalidation.js"></script>
<script src="./jsp/js/app.js"></script>
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap3.css">
<link rel="stylesheet" type="text/css" href="./jsp/css/style.css">
<script type="text/javascript">
	function checkUsernameAvailability() {
		var username = $('#username').val();
		if (username.length > 2) {
			$
					.ajax({
						type : "POST",
						cache : false,
						url : "checkusername.htm",
						data : "username=" + username,
						success : function(response) {
							if (response == 'Username Available') {
								$('#username').closest('.form-group')
										.removeClass('has-error');
								$('#username').closest('.form-group').addClass(
										'has-success');
							} else {
								$('#username').closest('.form-group')
										.removeClass('has-success');
								$('#username').closest('.form-group').addClass(
										'has-error');
							}
							document.getElementById("usernameavailable").innerHTML = response;
						},
						error : function(e) {
							alert('Error: ' + e);
						}
					});
		}
	}
</script>
</head>
<body>
	<%@include file="../includes/header.jsp"%>
	<div class="container">
		<div class="row col-lg-12">
			<div style="padding-left: 10%" class="col-lg-12">
				<div class="panel panel-info">
					<form class="form-horizontal" id="registrationFormId" modelAttribute="registerUser" name="registrationForm" method="POST" action="usercreated.htm">
						<div class="panel-body">
							<div class="panel-heading">
								<h3 class="panel-title">Registration Form</h3>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Name</label>
								<div class="col-sm-6">
									<input id="name" name="name" type="text" class="form-control" placeholder="Please Enter Your Name" required>
								</div>
								<!--  <p ng-show="registrationForm.name.$invalid && !registrationForm.name.$pristine" class="help-block">Enter your valid name.</p> -->
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Age</label>
								<div class="col-sm-6">
									<input id="age" name="age" class="form-control" placeholder="Age" type="number" min="1" pattern="\d*" required>
								</div>
								<!--<p ng-show="registrationForm.age.$invalid && !registrationForm.age.$pristine" class="help-block">Enter your valid age. Two Digits are required</p>-->
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label">Email</label>
								<div class="col-sm-6">
									<input id="email" name="email" type="email" class="form-control" placeholder="Please Enter Your Email" required>
									<!--	<span ng-show="registrationForm.email.$invalid && !registrationForm.email.$pristine" class="help-block">Enter a valid email.</span>-->
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label">Username</label>
								<div class="col-sm-6">
									<input name="username" id="username" type="text" class="form-control" placeholder="Please Enter Username of Your choice" onblur="checkUsernameAvailability()" required> <span
										id="usernameavailable"></span>
									<!--	<span ng-show="registrationForm.username.$invalid && !registrationForm.username.$pristine" class="help-block">Enter a valid username. Max 15 characters are accepted</span>-->
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-4 control-label">Password</label>
								<div class="col-sm-6">
									<input name="password" id="password" type="password" class="form-control" placeholder="Please Enter Password of Your choice" required>
									<!--		<span ng-show="registrationForm.password.$invalid && !registrationForm.password.$pristine" class="help-block">Enter a valid password</span> -->
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-4 control-label">Confirm Password</label>
								<div class="col-sm-6">
									<input name="confirmpassword" id="confirmpassword" type="password" class="form-control" placeholder="Please Enter Password Again" required>
									<!--		<span ng-show="registrationForm.confirmpassword.$invalid && !registrationForm.confirmpassword.$pristine" class="help-block">Enter the same password as above</span>
								 <span class="help-block" ng-show="registrationForm.confirmpassword.$error.match">Passwords do not match.</span> -->
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-4 control-label">Gender</label>
								<div class="col-sm-6">
									<label class="radio-inline"> <input name="gender" id="gender" type="radio" value="1" checked> Male
									</label> <label class="radio-inline"> <input name="gender" id="gender" type="radio" value="0"> Female
									</label>
									<!--		<span ng-show="registrationForm.confirmpassword.$invalid && !registrationForm.confirmpassword.$pristine" class="help-block">Enter the same password as above</span>
								 <span class="help-block" ng-show="registrationForm.confirmpassword.$error.match">Passwords do not match.</span> -->
								</div>
							</div>

							<div class="page-header"></div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-10">
									<button type="submit" class="btn btn-outline btn-success">Register Me</button>
									<button type="reset" class="btn btn-outline btn-primary">Reset</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../includes/footer.jsp"%>
</body>

<!-- Core Scripts - Include with every page -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

<!-- SB Admin Scripts - Include with every page -->
<script src="js/sb-admin.js"></script>
</html>