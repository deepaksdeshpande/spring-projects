<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<%-- <title>Information ${nameWithId}</title> --%>
<link href="./jsp/css/dataTables.bootstrap.css" rel="stylesheet">
<link href="./jsp/css/logo-nav.css" rel="stylesheet">
<link href="./jsp/css/sb-admin.css" rel="stylesheet">
<link href="./jsp/css/font-awesome.css" rel="stylesheet" />
</head>
<body>
	<form:form id="homeFormId" name="homeForm" method="POST">
		<div class="modal-dialog modal-lg" style="width: 80%">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<div class=" panel-info panel-heading ">
						<h4 class="modal-title" id="myModalLabel">
							<i class="fa fa-list-alt"></i><b> ${nameWithId} | ${emailWithId} | ${ageWithId}</b>
						</h4>
					</div>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped tablesorter" id="user_details-table">
							<tr>
								<th style="background-color: #D9EDF7">Name</th>
								<td>${nameWithId}</td>
							</tr>
							<tr>
								<th style="background-color: #D9EDF7">Email</th>
								<td>${emailWithId}</td>
							</tr>
							<tr>
								<th style="background-color: #D9EDF7">Qualification</th>
								<td>
									<table class="table table-bordered table-hover">
										<thead style="background-color: #D9EDF7">
											<th>Name</th>
											<th>Type</th>
											<th>%</th>
											<th>Year of Passing</th>
											<th>University</th>
										</thead>
										<tbody>
											<c:forEach var="userDetails" items="${qualification}">
												<tr>
													<td>${userDetails.qualificationName}</td>
													<td>${userDetails.qualificationType}</td>
													<td>${userDetails.percentage}</td>
													<td>${userDetails.passYear}</td>
													<td>${userDetails.university}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<th style="background-color: #D9EDF7">Experience</th>
								<td>
									<table class="table table-bordered table-hover">
										<thead style="background-color: #D9EDF7">
											<th>Company Name</th>
											<th>Position</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Experience(in Years)</th>
											<th>Curent CTC</th>
											<!-- 											<th>Curent Company</th> -->
										</thead>
										<tbody>
											<c:forEach var="userDetails" items="${experience}" varStatus="count">
												<tr>
													<td>${userDetails.companyName}</td>
													<td>${userDetails.position}</td>
													<td>${userDetails.startDate}</td>
													<td>${userDetails.endDate}</td>
													<td>${userDetails.yearOfExperience}</td>
													<td>${userDetails.currentCTC}</td>
													<%-- 														<td>${userDetails.currentCompany == true ? "YES" : "NO"}</td> --%>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</td>
							</tbody>
							<tfoot>
								<tr>
									<td><h4 class="pull-right">Total Experience</h4></td>
									<td><h4 class="text-center">${tExp}</h4></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary pull-right" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</form:form>
	<script src="./jsp/js/jquery-1.10.2.js"></script>
	<script src="./jsp/js/bootstrap.js"></script>
	<script src="./jsp/js/dataTables/jquery.dataTables.js"></script>
	<script src="./jsp/js/dataTables/dataTables.bootstrap.js"></script>

	<script>
		$(document).ready(function() {
			$('#user_details-table').dataTable({
				"sPaginationType" : "full_numbers"
			});
		})
	</script>
</body>
</html>