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
<body><br /><br /><br /><br /><br />
	<div class="container">
		<form class="form-horizontal" action="home.htm" method="post">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa fa-user fa-1x"></i> Method Not Allowed</h3>
				</div>
				<div class="panel-body">
					<span><i class="fa fa-cog fa-3x"></i></span>
					<span>Either of the GET / POST request not supported. Please <i class="fa fa-hand-o-right fa-1x"></i> <a href="examhome.htm">click here</a>to go to home.</span>
					
				</div>
				<div class="panel-footer"></div>
			</div>
		</form>
	</div>		
</body>
</html>
<%@include file="../includes/footer.jsp" %>
<%}%>