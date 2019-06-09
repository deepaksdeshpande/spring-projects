<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Create Exam</title>

<!-- SB Admin CSS - Include with every page -->

<script type="text/javascript" src="./jsp/js/ToggleAccordianImage.js"></script>
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<script src="./jsp/js/jqBootstrapValidation.js"></script>
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap3.css">
<!-- <script>
	$(function() {
		$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
	});
</script> -->
<script>
	function confirmcontactdetails() {
		var photo = $('#photo').val();
		var resume = $('#resume').val();
		var address = $('#address').val();
		var mobile = $('#mobile').val();
		var altemail = $('#altemail').val();
		var landlineno = $('#landlineno').val();
// 		var gender = $('#gender').val();
		$.ajax({
					type : "POST",
					cache : false,
					url : "confirmcontactdetails.htm",
					data : "photo=" + photo + "&resume=" + resume + "&address="
							+ address + "&mobile=" + mobile + "&altemail="
							+ altemail + "&landlineno=" + landlineno,
					success : function(response) {
						document.getElementById("confirmcontactdetails").innerHTML = response;
					}
				});
	}
</script>
</head>
<body>
<%@include file="../includes/header.jsp"%>
	<%
		String emailId = request.getParameter("id");
		session.setAttribute("emailId", emailId);
	%>
	<form:form class="form-horizontal" id="registrationContactDetailsFormId"
		modelAttribute="registerContact" name="registrationContactDetails"
		method="POST" action="">
		<div class="container">
		<div class="row col-lg-12">
			<div style="padding-left: 10%" class="col-lg-11">
				<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Contact Details</h3>
						</div>
						<div class="panel-body">
								<div class="form-group">
									<label class="col-sm-4 control-label">Photo</label>
									<div class="col-sm-6">
										<input type="file" id="photo" name="photo"
											class="form-control" placeholder="Please Upload Your Photo"
										required>
									</div>	
								</div>

								<div class="form-group">
									<label class="col-sm-4 control-label">Resume</label>
									<div class="col-sm-6">
										<input type="file" id="resume"
											name="resume" class="form-control"
											placeholder="Please Upload Your Resume" required>
									</div>		
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">Alternate Email</label> 
									<div class="col-sm-6">
										<input id="altemail"
											name="altemail" class="form-control"
											placeholder="Please Enter Your Alternate Email">
									</div>		
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">Address</label> 
									<div class="col-sm-6">
										<textarea id="address" name="address"
										class="form-control" placeholder="Please Enter Your Address"
										required></textarea>
									</div>	
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">Mobile</label> 
									<div class="col-sm-6">
										<input id="mobile" name="mobile"
										class="form-control" placeholder="Please Enter Your Mobile"
										required>
									</div>	
								</div>
								<!-- <div class="form-group">
									<label class="col-sm-4 control-label">Gender</label> 
									<div class="col-sm-6">
										<input id="gender" name="gender"
										class="form-control" placeholder="Please Enter Your Gender"
										required>
									</div>	
								</div> -->
								<div class="form-group">
									<label class="col-sm-4 control-label">Landline No.</label>
									<div class="col-sm-6">
										 <input id="landlineno"
										name="landlineno" class="form-control"
										placeholder="Please Enter Your Landline Number" required>
									</div>	
								</div>
								<div class="page-header"></div>
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-10">
										<button type="submit" class="btn btn-outline btn-success"
										onclick="confirmcontactdetails()" data-toggle="modal"
										data-target="#confirmcontactdetails" href="#">
											Proceed
										</button>
										<button type="reset" class="btn btn-outline btn-primary">
											Reset
										</button>
									</div>	
								</div>	
								<div id="confirmcontactdetails" class="modal fade" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</form:form>
	<%@include file="../includes/footer.jsp"%>
	
	<!-- Core Scripts - Include with every page -->
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

	<!-- SB Admin Scripts - Include with every page -->
	<script src="js/sb-admin.js"></script>

</body>
</html>