<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Home <%=session.getAttribute("roleName")%></title>

<script type="text/javascript">
	function logout() {
		document.createexamForm.action = "examlogout.htm";
		document.createexamForm.submit();
	}

	function uploadImage(designationId) {
		document.homeForm.action = "showuploadpage.htm?post=" + designationId;
		document.homeForm.submit();
	}
</script>
<!--[if lt IE 9]>
      <script src="./jsp/js/html5shiv.js"></script>
    <![endif]-->
<script src="./jsp/js/html5shiv.js"></script>
<script type="text/javascript" src="./jsp/js/ToggleAccordianImage.js"></script>
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<style type="text/css">
.fa-compress {
	color: #3a87ad;
}
</style>

</head>
<body>
	<jsp:include page="../includes/admin-menu.jsp" />
	<form:form id="homeFormId" name="homeForm" method="POST" action="#">
		Welcome <%=session.getAttribute("email")%> &nbsp;&nbsp;
		<input type="hidden" id="hiddenpostname" name="hiddenpostname">
		<div class="container" style="padding-top: 20px; margin-left: 5px">
			<div class="row">
				<div class="col-lg-11 panel-info">
					<div class="panel-heading ">
						<h3 class="panel-title">
							<i class="fa fa-list-alt"></i> Click on posts for Creating Exam
						</h3>
					</div>
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="panel-group" id="accordion">
								<c:forEach var="post" items="${posts}">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion" href="#collapse${post.designationId}" onclick="changeAccordionImage('${post.designationId}')"><span
													id="postname${post.designationId}" name="postname${post.designationId}">${post.designationName}</span><i id="accordionImage${post.designationId}" class="fa fa-expand pull-right"></i></a>
											</h4>
										</div>
										<div id="collapse${post.designationId}" class="panel-collapse collapse">
											<div class="panel-body" style="background-color: #fffefa">
												<p>${post.designationDescription}</p>
												<button class="btn btn-primary btn" onclick="uploadImage(${post.designationId})">Upload Images of Candidates</button>
											</div>
											<div class="panel-footer"></div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<footer>
		<%@include file="../includes/footer.jsp"%>
	</footer>
</body>
</html>