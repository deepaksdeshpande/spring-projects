<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="./jsp/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./jsp/js/bootstrap3.js"></script>

<!-- Bootstrap core CSS -->
<link href="./jsp/css/bootstrap3.css" rel="stylesheet"/>

<!-- Add custom CSS here -->
<link href="./jsp/css/font-awesome.css" rel="stylesheet" />

<script type="text/javascript">
	function redirect(path) {
		document.submitcontactform.action = path;
		document.submitcontactform.submit();
	}
</script>

</head>
<style>
#map_canvas {
	width: auto;
	height: 65.8%;
}
</style>
<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script>
	var myCenter = new google.maps.LatLng(19.130279, 72.915916);

	function initialize() {
		var mapProp = {
			center : myCenter,
			zoom : 18,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};

		var map = new google.maps.Map(document.getElementById("map_canvas"),
				mapProp);

		var marker = new google.maps.Marker({
			position : myCenter,
			title : "T10KT Lab",
			animation : google.maps.Animation.BOUNCE

		//   icon:'./jsp/images/error.png'
		});

		marker.setMap(map);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

<script type="text/javascript">
	function updateCountdown() {
		// 400 is the max message length
		var remaining = 400 - $('#message').val().length;
		$('.countdown').text(remaining + ' characters remaining.');
	}

	function updateCount() {
		var count = $('#message').val().length;
		var str = 'characters';
		if (count == 1)
			str = 'character';

		str += ' used';
		$('.countdown').text(count + ' ' + str);
	}

	$(document).ready(function($) {

		updateCountdown();
		//    updateCount();
		$('#message').change(updateCountdown);
		$('#message').keyup(updateCountdown);

		/*  if ($('.message').val().length === 0) 
		 {
		 } */
	});
</script>



<script type="text/javascript">
	// 	$(function() {
	// 		$("#drpcontact").load("jsp/contact/contactus.txt" + $(this).val());
	// 	});

	$(function() {

		$("#drpcontact").change(function() {
			//      	alert($(this).val());
		});

	});
</script>

<style type="text/css">
body {
	/* 	padding-left: 2%; */
	/* 	padding-right: 2%; */
	
}
</style>
<body>
	<jsp:include page="../includes/header.jsp" />
	<div class="wrapper">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="well well-sm">
							<h4>Contact us !</h4>
							<p>We appreciate any feedback about your overall experience on our site or how to make it even better. Please fill in the below form with any comments and we will get back to you.</p>
						</div>
					</div>
					<div class="col-md-8 ">
						<form name="submitcontactform" class="form-horizontal" id="submitcontactform" action="submitcontactusform.htm" method="post">
							<div class="well">
								<h4>

									Tell us what you think <i class="text-danger fa fa-comment-o"></i>
								</h4>

								<div class="row show-grid">
									<div class="col-md-6">

										<input type="text" class="form-control" placeholder="Full Name" id="name" name="fullname" required />

										<p class="help-block"></p>
										<input type="email" class="form-control" placeholder="Email" id="email" name="email" required data-validation-required-message="Please enter your email" />

										<p class="help-block"></p>
										<input type="number" class="form-control" placeholder="Phone no" id="phone" name="phone" required data-validation-required-message="Please enter your phone No" />
										<p class="help-block"></p>

										<select class="form-control" id="drpcontact" name="drpcontact">
											<option value="Suggestions">Suggestions</option>
											<option value="feedback">feedback</option>
											<option value="Complaint">Complaint</option>
											<option value="others">others</option>
										</select>
										<p class="help-block"></p>
										<textarea rows="5" cols="10" name="message" class="form-control" placeholder="Message" id="message" style="resize: none" maxlength="400"></textarea>
										<span class="countdown"></span>
										<p class="help-block"></p>
										<button type="submit" class="btn btn-success col-md-5">Send</button>
										<button type="submit" class="btn btn-danger col-md-5 pull-right">Reset</button>
										<br />
									</div>
									<div class="col-md-6">
										<div class="well">

											<div class="row show-grid">
												<div class="col-md-5">
													<h4 class="text-danger">Mailing Address</h4>
													<address>
														<strong>T10KT Lab,</strong> <br>Kresit Building, <br>IIT-Bombay-powai, <br>Mumbai, Maharashtra, <br>400076.
													</address>

												</div>
												<div class="col-md-7">
													<h4 class="text-danger">Ring Us at:</h4>
													<i class="fa fa-phone text-danger"></i> <strong> : (022) 25722545</strong><br> <i class="text-danger fa fa-envelope-o"></i> <strong> : t10kt@example.com</strong>
												</div>
											</div>
											<a class="pull-right" href="#" onclick="redirect('examhome.htm');">Click for home</a>
										</div>

									</div>

								</div>

							</div>
						</form>
					</div>
					<div class="col-md-4">
						<div id="map_canvas"></div>
					</div>
				</div>
			</div>
	</div>
	<jsp:include page="../includes/footer.jsp" />
</body>

<script type="text/javascript">
	$(document).ready(function() {

		updateCountdown();
		//   updateCount();
		$('#message').change(updateCountdown);
		$('#message').keyup(updateCountdown);

	});
</script>
</html>
