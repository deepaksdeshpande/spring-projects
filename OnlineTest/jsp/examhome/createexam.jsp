<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<%@include file="../includes/header.jsp"%>
<head>
<meta charset="utf-8">
<title>Create Exam</title>

<!-- SB Admin CSS - Include with every page -->
<script src="./jsp/js/jqBootstrapValidation.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<!-- or use local jquery -->
<script>
	$(function() {
		$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
	});
</script>
<script type="text/javascript">
	function logout() {
		document.createexamForm.action = "examlogout.htm";
		document.createexamForm.submit();
	}
</script>
</head>
<body>
	<form:form id="createexamFormId" name="createexamForm" method="POST" action="examcreated.htm">
		Welcome <%=session.getAttribute("email")%> &nbsp;&nbsp;
		<% 
			int postId = Integer.parseInt(request.getParameter("post"));
			session.setAttribute("postId",postId);
		%>
		<button class="btn btn-link" style="float: right;" onclick="logout()">Logout</button>
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Create Exam</h3>
						</div>
						<div class="panel-body">
							<fieldset>
								<div class="form-group">
									<label>Exam Id</label> <input name="examid" disabled="disabled" class="form-control"
										placeholder="Id of the Exam" >
								</div>
								<div class="form-group">
									<label>Exam Name</label> <input name="examname" class="form-control"
										placeholder="Name of the Exam" required>
								</div>

								<div class="form-group">
									<label>Exam Date</label> <input name="examdate" class="form-control"
										placeholder="Date of the Exam" required>
								</div>

								<div class="form-group">
									<label>Exam Duration</label> <input name="examduration" class="form-control"
										placeholder="Duration of the Exam" required>
								</div>
								
								<div class="form-group">
									<label>Total Question</label> <input name="totalquest" class="form-control"
										placeholder="Total Question" required>
								</div>
								
								<input type="hidden" value="<%=session.getAttribute("userid") %>">

								<button type="submit" class="btn btn-outline btn-success">Submit
									Button</button>
								<button type="reset" class="btn btn-outline btn-primary">Reset
									Button</button>


								<!-- <div class="form-group">
                                    <input class="form-control" data-validation-matches-match="email" data-validation-matches-message= "Must match email address entered above"  placeholder="E-mail" name="email" type="email" autofocus>
                                </div> -->

							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<footer> <%@include file="../includes/footer.jsp"%>
	</footer>

	<!-- Core Scripts - Include with every page -->
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

	<!-- SB Admin Scripts - Include with every page -->
	<script src="js/sb-admin.js"></script>

</body>
</html>