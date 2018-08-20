<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" href="./jsp/images/iitb.jpg" />
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<script type="text/javascript">
	function redirect(path) {
		document.menuForm.action = path;
		//document.menuForm.method="POST";
		document.menuForm.submit();
	}

	function showDefaultImage(img) {
		img.src="user_images/default.png";
	}
</script>

<!--[if lt IE 9]>
      <script src="./jsp/js/html5shiv.js"></script>
    <![endif]-->
<script src="./jsp/js/html5shiv.js"></script>
<script src="./jsp/js/respond.js" type="text/javascipt"> </script>

<!-- Bootstrap core CSS -->
<link href="./jsp/css/bootstrap3.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="./jsp/css/font-awesome.css" rel="stylesheet" />
<style type="text/css">
body {
	margin-top: 5%;
	width: 100%;
}

.dropdown-menu li>a:hover {
	color: #ffffff;
	text-decoration: none;
	background-color: #0077b3;
}

li ul .dropdown-menu {
	-webkit-transition: width 15s; /* For Safari 3.1 to 6.0 */
	transition: width 15s;
	background-color: #0077b3;
}

</style>
</head>
	<form method="post" name="menuForm">
		<div class="navbar-inverse navbar-fixed-top navbar-inner">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
				</div>
				<a href="#" class="brand navbar-right"> <img src="./jsp/images/iitb-logo.gif" style="" width=180px height=50px />
				</a> <a class="brand" href="http://mhrd.gov.in" target="_blank" style="float: left;"> <img src="./jsp/images/MHRDsvg_logo_01.svg" height=50px />
				</a>
				<div id="navbarCollapse" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li><a href="#" onclick="redirect('examhome.htm')"><i class="fa fa-home fa-1x"></i> Home</a></li>

						<li class="dropdown"><a data-toggle="dropdown" href="#"><i class="fa fa-tags fa-1x"></i> Advertisements <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#" onclick="#">Advt. 1</a></li>
								<li><a href="#" onclick="#">Advt. 2</a></li>
							</ul></li>

						<li class="dropdown"><a data-toggle="dropdown" href="#"><i class="fa fa-gears fa-1x"></i> Admin <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#" onclick="redirect('createexammanual.htm')"> <span>Create Exam</span>
								</a></li>
								<li><a href="#" onclick="redirect('addquestion.htm')"> <span>Add Questions</span>
								</a></li>
								<li><a href="#" onclick="redirect('displayallquestions.htm')"> <span>View Questions</span>
								</a></li>
							</ul></li>

						<li><a data-toggle="dropdown" href="#" onclick="#"><i class="fa fa-unlock fa-1x"></i> Current Openings</a></li>

						<li><a onclick="#"> <span><i class="fa fa-question fa-1x" style="font-size: 16px;"></i> Help</span>
						</a></li>

						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> <img src="user_images/<%=session.getAttribute("userid")%>.jpg" onerror="showDefaultImage(this)"
								width=20px /> <%=session.getAttribute("userName")%> <span class="caret"></span>
						</a>
							<ul class="dropdown-menu" style="width: auto;">
								<li><a href="#"><i class="fa fa-envelope"></i> <%=session.getAttribute("email")%></a></li>
								<li><a href="#" onclick="#"> <i class="fa fa-eye"></i> View Profile
								</a></li>
								<li><a href="#" onclick="#"> <i class="fa fa-edit fa-1g"></i> Edit Profile
								</a></li>
								<li><a href="#" onclick="redirect('examlogout.htm');"><i class="fa fa-sign-out fa-1x"></i> Sign out </a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</form>
	<!-- JavaScript -->