<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Candidates List <%=session.getAttribute("roleName")%></title>
<link href="./jsp/css/dataTables.bootstrap.css" rel="stylesheet">

<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<script src="./jsp/js/dataTables/jquery.dataTables.js"></script>
<script src="./jsp/js/dataTables/dataTables.bootstrap.js"></script>
<script src="./jsp/js/dataTables/FixedHeader.js"></script>

<script type="text/javascript">
	function displayList(userId) {
		$('#loading').show();
		document.getElementById("userDetailsModal").innerHTML = "";
		var name = document.getElementById("name" + userId).innerHTML;
		var email = document.getElementById("email" + userId).innerHTML;
		var age = document.getElementById("age" + userId).innerHTML;

		$
				.ajax({
					type : "POST",
					cache : false,
					url : "displayUserInfo.htm",
					data : "userId=" + userId + "&nameWithId=" + name
							+ "&emailWithId=" + email + "&ageWithId=" + age,
					success : function(response) {
						document.getElementById("userDetailsModal").innerHTML = response;
						$('#loading').hide();
					}
				});
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var oTable = $('#user_details-table').dataTable();
		new FixedHeader(oTable, {
			"left" : true,
			"right" : true,
			"bottom" : true
		});
	});
</script>

<script type="text/javascript">
	function displayImage(userPhoto) {
		$('#loading').show();
		document.getElementById("userImageModal").innerHTML = "";
		var name = document.getElementById("name" + userPhoto.split(".")[0]).innerHTML;
		$.ajax({
			type : "POST",
			cache : false,
			url : "showImage.htm",
			data : "photo=" + userPhoto + "&name=" + name,
			success : function(response) {
				document.getElementById("userImageModal").innerHTML = response;
				$('#loading').hide();
			}
		});
	}
</script>
</head>

<body>
	<jsp:include page="../includes/admin-menu.jsp" />
	<form:form id="homeFormId" name="homeForm" method="POST">
		<div class="container">
			<div class="row">
				Welcome
				<%=session.getAttribute("userName")%>
				&nbsp;&nbsp;
				<div class="col-lg-12 col-md-6 panel-info">
					<div id="loading" style="position: fixed; top: 25%; left: 50%; margin-top: 5px; margin-left: -25px; display: none;">
<!-- 						<div class="progress progress-striped active"> -->
<!-- 							<div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div> -->
<!-- 						</div> -->
						<i class="fa fa-spinner fa-spin fa-4x"></i>
					</div>
					<div class="panel-heading ">
						<h3 class="panel-title">
							<i class="fa fa-list-alt"></i> People Applied for Post <b>${postName} [${advtName} Recruitment]</b>
						</h3>
					</div>
					<div class="panel panel-default">
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped tablesorter" id="user_details-table">
									<thead class="text-center">
										<th>Name</th>
										<th>Email Id</th>
										<th>Age(in Years)</th>
										<th>Mobile</th>
										<!-- 										<th>Resume</th> -->
										<th>User Photo</th>
									</thead>
									<tbody>
										<c:forEach var="userDetails" items="${userDetailsList}">
											<tr class="odd gradeX">
												<td><a id="name${userDetails.userDetailsId}" name="name${userDetails.userDetailsId}" data-toggle="modal" data-target="#userDetailsModal" href="#"
													onclick="displayList('${userDetails.userDetailsId}')">${userDetails.name}</a></td>
												<td id="email${userDetails.userDetailsId}" name="email${userDetails.userDetailsId}">${userDetails.emailid}</td>
												<td id="age${userDetails.userDetailsId}" name="age${userDetails.userDetailsId}">${userDetails.age}</td>
												<td>${userDetails.mobileno}</td>
												<%-- 												<td><a data-toggle="modal" data-target="#resumeModal" href="/OnlineTest/resumes/" ${userDetails.resume}>${userDetails.resume}</a></td> --%>
												<td><a id="photo${userDetails.userDetailsId}" name="photo${userDetails.userDetailsId}" data-target="#userImageModal" href="#" data-toggle="modal"
													onclick="displayImage('${userDetails.userPhoto}')"><img src="user_images/${userDetails.userPhoto}" alt="Not Avaliable" width="60px" height="60px" /></a></td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<td colspan="4"><h4 class="pull-right">Total</h4></td>
											<td><h4 class="text-center">${userDetailsList.size()}</h4></td>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
								<div id="userDetailsModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>

								<div id="userImageModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
		</div>
	</form:form>
	<%@include file="../includes/footer.jsp"%>
</body>
</html>