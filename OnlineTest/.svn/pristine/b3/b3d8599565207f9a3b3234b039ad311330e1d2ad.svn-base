<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<%
		String emailId = session.getAttribute("emailId").toString();
	%>
<form:form id="registrationContactDetailsFormId"
		modelAttribute="registerContact" name="registrationContactDetails"
		method="POST" action="">
	<div class="panel-body">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="panel-title">Contact Details</h3>
				</div>
				<div class="modal-body">
					<fieldset>
						<div class="form-group">
							<label>Photo</label> <input readonly="readonly" name="photo"
								class="form-control" placeholder="Please Upload Your Photo"
								value="${user.userPhoto}">
						</div>

						<div class="form-group">
							<label>Resume</label> <input readonly="readonly" name="resume"
								class="form-control" placeholder="Please Upload Your Resume"
								value="${user.resume}">
						</div>
						<div class="form-group">
							<label>Alternate Email</label> <input readonly="readonly"
								name="altemail" class="form-control"
								placeholder="Please Enter Your Alternate Email"
								value="${user.altEmailId}">
						</div>
						<div class="form-group">
							<label>Address</label> <input readonly="readonly" name="address"
								class="form-control" placeholder="Please Enter Your Address"
								value="${user.presentAddress}">
						</div>
						<div class="form-group">
							<label>Mobile</label> <input readonly="readonly" name="mobile"
								class="form-control" placeholder="Please Enter Your Mobile"
								value="${user.mobileno}">
						</div>
						<%-- <div class="form-group">
							<label>Gender</label> <input readonly="readonly" name="gender"
								class="form-control" placeholder="Please Enter Your Gender"
								value="${user.gender}">
						</div> --%>
						<div class="form-group">
							<label>Landline No.</label> <input readonly="readonly"
								name="landlineno" class="form-control"
								placeholder="Please Enter Your Landline Number"
								value="${user.landLineNo}">
						</div>
					</fieldset>
				</div>
				<div class="modal-footer"></div>
			<button type="button" class="btn btn-default" data-dismiss="modal">Update</button>
			<button type="submit" class="btn btn-outline btn-success" formaction="qualification.htm?id=<%= emailId %>">Confirm</button>
			<input type="hidden" name="emailId" value="<%= emailId%>">
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- .panel-body -->
	</form:form>
</body>
</html>