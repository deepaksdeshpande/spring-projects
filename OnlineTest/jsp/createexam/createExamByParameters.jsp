<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Create Exam</title>
<link href="./jsp/js/datepicker/css/datepicker.css" rel="stylesheet">
<link href="./jsp/css/dataTables.bootstrap.css" rel="stylesheet">

<script type="text/javascript">
	function logout() {
		document.createexamForm.action = "examlogout.htm";
		document.createexamForm.submit();
	}

	function adminHome() {
		document.createexamForm.action = "examhome.htm";
		document.createexamForm.submit();
	}
</script>
</head>
<body>
	<form:form id="createexamForm" class="form-horizontal" method="POST" action="examcreated.htm">
		<div class="container">
			<div class="row">
				<div class="col-lg-11 panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Create Exam - By Paramaters</h3>
					</div>
					<input type="hidden" id="desgId" name="desgId" value="${postId}" />
					<div class="panel panel-default">
						<div class="panel-body">

							<div class="control-group">
								<label class="control-label" for="examName">Exam Name</label>
								<div class="controls">
									<input type="text" id="examName" name="examname" value="${examname}" readonly class="form-control" placeholder="Name of the Exam">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="date">Exam Date</label>
								<div class="controls">
									<input type="date" class="form-control" name="examdate" id="examdate" placeholder="Enter date">
									<script type="text/javascript">
										$("#examdate").datepicker({});
									</script>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="examName">Exam Duration</label>
								<div class="controls">
									<input type="number" name="examduration" class="form-control" placeholder="Duration of the Exam only in minutes" required>
								</div>
							</div>
							<hr>
							<div class="panel panel-default">
								<div class="panel-heading">Select Questions</div>
								<!-- /.panel-heading -->
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-bordered table-hover table-striped tablesorter" id="questions-table">
											<thead>
												<th>Select</th>
												<th>Question</th>
												<th>Difficuilty Level (1 - 5)</th>
												<th>Question Category</th>
												<th>Question Type</th>
											</thead>
											<tbody>
												<c:forEach var="questions" items="${questionBank}" varStatus="status">
													<tr class="odd gradeX">
														<td><input type="checkbox" id="${questions.questionid}" name="questionsSelected" value="${questions.questionid}" /></td>
														<td>${questions.questionText}</td>
														<td>${questions.levelOfDifficulty}</td>
														<td>${categoryType[questions.questionid]}</td>
														<td>${questionType[questions.questionid]}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<hr>
							<div class="form-actions">
								<div class="tooltip-demo">
									<button type="submit" class="btn btn-outline btn-success">Create Exam</button>
									<button type="reset" class="btn btn-outline btn-primary">Reset</button>
									<button type="reset" class="btn btn-danger" title="Return to Home Page" onclick="adminHome()">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>

	<!-- Validate plugin -->
	<script src="./jsp/js/jquery.validate.min.js"></script>
	<!-- Scripts specific to this page -->
	<script src="./jsp/js/dataTables/jquery.dataTables.js"></script>
	<script src="./jsp/js/dataTables/dataTables.bootstrap.js"></script>
	<script src="./jsp/js/datepicker/js/datepicker.js"></script>

	<script>
		$(document).ready(function() {
			$('#questions-table').dataTable({
				"sPaginationType" : "full_numbers"
			});
		})
	</script>

	<script>
		// tooltip demo
		$('.tooltip-demo').tooltip({
			selector : "[data-toggle=tooltip]",
			container : "body"
		})
	</script>

</body>
</html>