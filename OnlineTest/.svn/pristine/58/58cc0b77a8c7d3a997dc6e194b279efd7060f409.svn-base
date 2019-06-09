<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 maximum-scale=1">
<!-- <meta charset = "UTF-8"> -->
<!-- <meta name = "viewport" content = "width=device-width , initail-scale=1.0"/> -->
<!-- <meta name = "description" content="" /> -->
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap.css" media="all">

<script type="text/javascript">
	function redirect(path) {
		document.menuForm.action = path;
		document.menuForm.submit();
	}
</script>
</head>
<body>
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" style="padding-bottom: 5px; top: 0px; right: 0px" data-dismiss="modal" aria-hidden="true">
					<img src="./jsp/images/close.png" alt="&times;" />
				</button>
				<div class="panel-heading ">
					<h5 class="modal-title" id="myModalLabel">
						<b> Forgot Password</b>
					</h5>
				</div>
			</div>
			<div class="modal-body">
				<form:form id="forgotPasswordForm" name="forgotPasswordForm" action="forgotPasswordFormAction.htm" method="POST" onsubmit="return validateForgotPassForm()">
					<div class="panel tooltip-demo">
						<div class="panel-body">
							<div class="form-group">
								<div class="input-group col-sm-offset-2 col-sm-6">
									<span class="input-group-addon" style="color: rgb(50, 118, 177)"><i class="fa fa-envelope-o fa-fw"></i></span> 
									<input type="email" class="form-control" name="emailId" id="emailId"
										placeholder="Enter Your Email..." data-toggle="tooltip" title="Please enter the Email ID you used to register with us." data-placement="right"/>
								</div>
<!-- 								<button type="submit" class="btn btn-outline btn-primary" data-toggle="tooltip" title="Submit" data-placement="bottom">Submit</button> -->
								<button type="button" class="btn btn-outline btn-primary" data-toggle="tooltip" title="Submit" data-placement="bottom" onclick="validateForgotPassForm()">Submit</button>
								<br /> <br />
								<div id="error" style="display: none;">
									<div class="alert alert-danger alert-dismissable col-sm-offset-2 col-sm-6">
										<button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="addErrorMsgForForgotPass()">&times;</button>
										<p>Enter valid email.</p>
									</div>
								</div>
								<br />
								<div id="errorReg" style="display: none;">
									<div class="alert alert-danger alert-dismissable col-sm-offset-2 col-sm-6">
										<button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="addErrorMsgForForgotPass()">&times;</button>
										<p>Email is not registered with us.</p>
									</div>
								</div>
							</div>

							<!-- 							<div class="form-group"> -->
							<!-- 								<div class="col-sm-offset-2 col-sm-3"> -->
							<!-- 									<button type="submit" class="btn btn-primary btn-block form-control" data-toggle="tooltip" title="Submit" data-placement="bottom">Submit</button> -->
							<!-- 								</div> -->
							<!-- 							</div> -->
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- 	<div class="col-lg-12"> -->
	<!-- 		<div class="container"> -->
	<!-- 			<div class="row"> -->
	<!-- 				<div class="col-lg-8 panel-info" style="float: left;"> -->
	<%-- 					<form:form id="forgotPasswordForm" name="forgotPasswordForm" method="POST"> --%>
	<!-- 						<div class="panel panel-default tooltip-demo"> -->
	<!-- 							<div class="panel-body"> -->
	<!-- 								<span style="padding-left: 40%; color: #3a87ad;"> <i class="fa fa-user fa-4x"></i> -->
	<!-- 								</span> -->
	<!-- 								<hr> -->
	<!-- 								<div class="form-group"> -->
	<!-- 									<div class="input-group col-sm-offset-2 col-sm-8"> -->
	<!-- 										<span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span> <input type="email" class="form-control" name="email" id="emailId" placeholder="Enter Your Email..." -->
	<!-- 											data-toggle="tooltip" title="Please enter the Email ID you used to register with us." data-placement="right" style="width: 50%" /> -->
	<!-- 									</div> -->
	<!-- 								</div> -->

	<!-- 								<div class="form-group"> -->
	<!-- 									<div class="col-sm-offset-2 col-sm-2"> -->
	<!-- 										<button type="submit" class="btn btn-primary btn-block form-control" data-toggle="tooltip" title="Submit" data-placement="bottom">Submit</button> -->

	<!-- 										<button type="submit" class="btn btn-primary btn-block form-control pull-right" data-toggle="tooltip" title="Reset Email Field" data-placement="bottom">Reset</button> -->
	<!-- 									</div> -->
	<!-- 								</div> -->
	<!-- 							</div> -->
	<!-- 						</div> -->
	<%-- 					</form:form> --%>
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<script src="./jsp/js/jquery-1.10.2.js"></script>
	<script src="./jsp/js/bootstrap.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".form-control").tooltip();
		});
	</script>
</body>
</html>