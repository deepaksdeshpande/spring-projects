<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%
HttpSession httpSession = request.getSession(false);
if(httpSession.getAttribute("email") == null || httpSession.getAttribute("email").toString() == null) { %>
		<jsp:forward page="/sessionexpired.htm" />
<%	} else { %>
<%@include file="../includes/admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body><br /><br /><br /><br /><br /><br /><br /><br />
	<div class="container">
		<form class="form-horizontal" action="examhome.htm" method="post">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa fa-user fa-1x"></i> Internal Server Error</h3>
				</div>
				<div class="panel-body">
					<span><img src="./jsp/images/crossmark.png" alt="Error" class="img-circle" height="140" width="140"></span>
					<span>This is soo embarassing for us! There is a problem with the requested resource. Please perform the operation after some time.<i class="fa fa-hand-o-right fa-1x"></i><button class="btn btn-link" formaction="examhome.htm">Home.</button></span>
					
				</div>
				<div class="panel-footer"></div>
			</div>
		</form>
	</div>		
<%@include file="../includes/footer.jsp" %>
</body>
</html>
<%}%>