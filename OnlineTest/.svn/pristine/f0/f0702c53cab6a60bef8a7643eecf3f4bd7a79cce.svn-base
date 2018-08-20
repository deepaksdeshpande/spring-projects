<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@include file="../includes/header.jsp"%> --%>
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

	function createExam(designationId) {
		document.homeForm.action = "createexam.htm?post=" + designationId;
		document.homeForm.submit();

	}

	function redirect(designationId) {
		document.createexamForm.action = "createexam.htm?post=" + designationId;
		document.createexamForm.submit();

	}

	function showCandidatesList(designationId) {
		document.getElementById("hiddenpostname").value = document.getElementById("postname"+designationId).innerHTML;
		document.homeForm.action = "showCandidatesList.htm?post=" + designationId;
		document.homeForm.submit();

	}

	function uploadImage(designationId) {
		document.homeForm.action = "showuploadpage.htm?post=" + designationId;
		document.homeForm.submit();
	}

	function redirect(designationId) {
		document.createexamForm.action = "createexam.htm?post=" + designationId;
		document.createexamForm.submit();
	}
</script>
<!--[if lt IE 9]>
      <script src="./jsp/js/html5shiv.js"></script>
    <![endif]-->
<script src="./jsp/js/html5shiv.js"></script>
<script type="text/javascript" src="./jsp/js/ToggleAccordianImage.js"></script>
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	 $('#top').append('<div id="toTop"><i class="fa fa-angle-double-up fa-3x"></i></div><br/><div id="toTop" style="bottom: 90px">Top</div>');
		$(window).scroll(function () {
			if ($(this).scrollTop() != 0) {
				$('#toTop').fadeIn();
			} else {
				$('#toTop').fadeOut();
			}
		});
		$('#toTop').click(function(){
		$("html, body").animate({ scrollTop: 0 }, 600);
		return false;
		});
});
</script>
<style type="text/css">
.fa-compress {
	color: #3a87ad;
}
</style>
<style type="text/css">
#toTop {
 	border: 2px solid #f7f7f7; 
/* 	background: black; */
	text-align: center;
	position: fixed;
	bottom: 100px;
	right: 50px;
	cursor: pointer;
	display: none;
	color: #333;
	font-family: verdana;
	font-size: 14px;
	opacity: 0.5;
	filter: alpha(opacity = 40);
/* 	padding: 5px; */
}

#toTop:hover {
	background: #f7f7f7;
	opacity: 1;
 	border: 2px solid #b3b3b3; 
}
​
</style>
</head>
<body>
	<jsp:include page="../includes/admin-menu.jsp" />
	<div class="container">
	<form:form id="homeFormId" name="homeForm" method="POST" action="#">
		<p style="padding-left: 2%;">
			Welcome
			<%=session.getAttribute("userName")%></p>
		<input type="hidden" id="hiddenpostname" name="hiddenpostname">
		<div class="row">
			<div class="col-lg-12 panel-info">
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
											<a data-toggle="collapse" data-parent="#accordion" href="#collapse${post.designationId}" onclick="changeAccordionImage('${post.designationId}')"> <span
												id="postname${post.designationId}" name="postname${post.designationId}">${post.designationName}</span> <i id="accordionImage${post.designationId}" class="fa fa-expand pull-right"></i></a>
										</h4>
									</div>
									<div id="collapse${post.designationId}" class="panel-collapse collapse">
										<div class="panel-body" style="background-color: #fffefa">
											<p>${post.designationDescription}</p>
<%-- 											<button class="btn btn-primary btn" onclick="createExam(${post.designationId})">CREATE EXAM</button> --%>
											<button class="btn btn-primary btn" onclick="showCandidatesList(${post.designationId})">Open Candidates List</button>
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
		<div id="top"></div>
	</form:form>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>