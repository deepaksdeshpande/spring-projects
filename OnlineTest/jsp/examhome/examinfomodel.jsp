<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exam Detail</title>
</head>
<script type="text/javascript">
	function redirect(path) {
		document.exammodalform.action = path;
		//document.menuForm.method="POST";
		document.exammodalform.submit();
	}
</script>
<body>

<form name="exammodalform">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Read Instruction
					Carefully</h4>
			</div>
			<div class="modal-body">
				<h4 class="modal-title" style="font-weight: bold;">Test Details</h4>
				<br>
				<table id="ExamDetail" style="border: 3px;">
					<tr style="padding-bottom: 10px;">
						<td>Total No. of Questions for this test are&nbsp;&nbsp;</td>
						<td> :&nbsp;&nbsp; ${examdetails.totalQuestions}</td>
					</tr>
					<tr style="padding-bottom: 10px;">
						<td>Test Duration&nbsp;&nbsp;</td>
						<td> : &nbsp;&nbsp;${examdetails.examDuration} &nbsp;&nbsp;Minutes</td>
					</tr>
				</table>
				<br>
				<h4 class="modal-title" style="font-weight: bold;">General
					Instruction before taking test</h4>
				<br> 1.This test can be taken only <label
					style="color: red; font-weight: bold;">"ONCE"</label> for
				particular post applied. <br> 2. Once you click on 'Start Test'
				button, Test will start automatically.
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">No,Thanks</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-primary" onclick="redirect('startexam.htm')">Start
					Test</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	</form>
</body>
</html>	