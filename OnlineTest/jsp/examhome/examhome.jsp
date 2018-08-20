<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en" data-scribe-reduced-action-queue="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="home.title" /></title>
<script src="./jsp/js/respond.min.js"></script>
<script src="./jsp/js/html5shiv.js"></script>
<script type="text/javascript" src="./jsp/js/ToggleAccordianImage.js"></script>
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<script type="text/javascript">
	function call(designationId) {

		$.ajax({
			type : "POST",
			cache : false,
			url : "examdetails.htm",
			data : "designationId=" + designationId,
			success : function(response) {
				document.getElementById("myModal").innerHTML = response;
			}
		});
	}

	function disableBackButton() {
		setTimeout("preventPageLoad()", 1);
	}

	function preventPageLoad() {
		try {
			history.forward();
		} catch (e) {
		}
		// Try again every 200 milisecs.
		setTimeout("preventPageLoad()", 200);
	}
</script>
</head>
<body onload="disableBackButton();">
	<jsp:include page="../includes/admin-menu.jsp" />
	<form:form id="homeFormId" name="homeForm" method="POST" action="#">
		<div class="container">
			Welcome
			<%=session.getAttribute("email")%>
			&nbsp;&nbsp;
			<div class="row" style="padding-left: 10%;">
				<div class="col-lg-11 panel-info">
					<div class="panel-heading ">
						<h3 class="panel-title">Click on posts for further details</h3>
					</div>
					<div class="panel panel-default">
						<div class="panel-body">
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
												<div class="panel-body">${post.designationDescription}</div>
												<button id="TakeExam" class="btn btn-primary btn" data-toggle="modal" data-target="#myModal" onclick="call('${post.designationId}')">Take Exam</button>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<!-- Modal -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
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