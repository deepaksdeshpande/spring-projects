<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	HttpSession httpSession = request.getSession(false);
	if (httpSession.getAttribute("email") == null
			|| httpSession.getAttribute("email").toString() == null) {
%>
<jsp:forward page="/sessionexpired.htm" />
<%
	} else {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 maximum-scale=1">
<script type="text/javascript" src="./jsp/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="./jsp/js/html5shiv.js"></script>
<script type="text/javascript" src="./jsp/js/respond.js"></script>
<script type="text/javascript" src="./jsp/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="./jsp/jsp/js/script.js"></script>
<script type="text/javascript">
	function showManualPage() {
		$("#manualPage").load("byparameters.htm");
	}
	
	function showSearchPage() {
		$("#searchPage").load("bysearch.htm");
	}

</script>
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap.css">
</head>
<body">
	<jsp:include page="../includes/admin-menu.jsp" />
	<div class="container" style="padding-top: 20px;">
	<div id="upperDiv"></div>
		<div class="row">
			<div class="row col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Basic Tabs</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs">
							<li class="active"><a href="#byManual" data-toggle="tab" onclick="showManualPage()">Questions by Parameters</a></li>
							<li><a href="#bySearch" data-toggle="tab" onclick="showSearchPage()">Questions by Search</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<div class="tab-pane fade in active" id="byManual">
								<h4>Select Questions by Parameters</h4>
								<div id="manualPage"></div>
							</div>
							<div class="tab-pane fade" id="bySearch">
								<h4>Selected Questions by Search</h4>
								<div id="searchPage"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<jsp:include page="../includes/footer.jsp" />
	
<script type="text/javascript">
$(document).ready(function() {
	showManualPage();
})
</script>
</body>
</html>
<%
	}
%>