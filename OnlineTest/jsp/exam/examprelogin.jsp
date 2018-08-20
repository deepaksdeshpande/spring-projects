<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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



<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap.css" media="all">
<!-- Respond.js redirect location on local server -->
<script src="./jsp/js/respond.js" type="text/javascipt"></script>
<script src="./jsp/js/html5shiv.js" type="text/javascipt"></script>
<script type="text/javascript" src="./jsp/js/ToggleAccordianImage.js"></script>
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<script src="./jsp/sb-admin.js"></script>

<title><spring:message code="login.title" /></title>

<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" media="all">
<link href="./jsp/css/font-awesome.css" rel="stylesheet" />
<style type="text/css">
.fa-compress {
	color: #3a87ad;
}
</style>

<script type="text/javascript">
	function selectad(id) {
		document.getElementById("advtName").value = (document
				.getElementById(id).innerHTML).trim();
	}
</script>
</head>
<body>
	<jsp:include page="../includes/header.jsp" />
	<div class="col-lg-12">
		<div class="container">
			<form class="form-horizontal" name="selectAdvtform" method="POST" action="examlogin.htm">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-8 panel-info">
							<div class="col-lg-10">
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
									<div class="modal-dialog" style="top: 5em;">
										<div class="modal-content">
											<div class="modal-header">
												<h4 class="modal-title" id="myModalLabel">Select Advertisement</h4>
											</div>
											<div class="modal-body">
												<c:forEach var="advertisement" items="${advts}">
													<input type="hidden" id="advtName" name="advtName" value=<c:out value="${advertisement.advertisementTitle}"/>>
													<button type="submit" id="advtid${advertisement.advertisementId}" name="advtid" class="btn btn-outline btn-link" value=<c:out value="${advertisement.advertisementId}"/>
														onclick="selectad(this.id)">
														<c:out value="${advertisement.advertisementTitle}" />
													</button>
													<span class="pull-right text-muted small"><em><c:out value="${advertisement.startDate}" /> - <c:out value="${advertisement.endDate}" /> </em> </span>
													<br />
												</c:forEach>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
							</div>
						</div>
						<!-- /.col-lg-12 -->
						<!-- /.row -->
					</div>
				</div>
			</form>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {

		$("#myModal").modal('show');
	});
</script>
</html>