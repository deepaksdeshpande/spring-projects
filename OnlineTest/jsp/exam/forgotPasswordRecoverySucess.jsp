<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Respond.js redirect location on local server -->
<script src="./jsp/js/respond.js" type="text/javascipt"></script>
<script src="./jsp/js/html5shiv.js" type="text/javascipt"></script>
<link href="./jsp/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap.css" media="all">
<title>Success</title>
<script type="text/javascript">
	function redirect(path) {
		document.forgotPasswordChangeSuccessForm.action = path;
		document.forgotPasswordChangeSuccessForm.method = "POST";
		document.forgotPasswordChangeSuccessForm.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../includes/header.jsp" />
	<div class="col-lg-12">
		<div class="container" style="padding-top: 4%">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h1 class="panel-title">
						<i class="fa fa-check-square fa-1x"></i> Success
					</h1>
				</div>
				<div class="col-sm-offset-1 panel-body ">
					<form method="post" name="forgotPasswordChangeSuccessForm">
						<h4>
							<img alt="SUCCESS" src="./jsp/images/tickmark.png" width=100px height="100px"> Password for <u><b><em>${email}</em></b></u> has been changed successfully. Login <a href="#" onclick="redirect('examlogin.htm')">Here</a>
						</h4>
					</form>
				</div>
				<div class="panel-footer"></div>
			</div>
		</div>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>
</html>