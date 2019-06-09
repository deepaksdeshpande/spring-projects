<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Create Exam</title>

<link rel="stylesheet" type="text/css" href="./jsp/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap.css" media="all"/>
<link rel="stylesheet" type="text/css" href="./jsp/css/slider.css" media="all"/>
<link href="./jsp/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="./jsp/css/datepicker.css" rel="stylesheet" />
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<script src="./jsp/js/jqBootstrapValidation.js"></script>
<script src="./jsp/js/jquery.dataTables.min.js"></script>
<script src="./jsp/js/jquery.dataTables.js"></script>
<script src="./jsp/js/bootstrap-datepicker.js"></script>
<script src="./jsp/js/qualification.js"></script>
<!-- <script>
	$(function() {
		$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
	});
</script> -->

<script type="text/javascript">
			function dateStartPick() {
				$('#strtdate').datepicker({
                	format: "dd/mm/yyyy"
                 });
			}
			
            function dateEndPick() {
                $('#enddate').datepicker({
                    format: "dd/mm/yyyy"
                });  
            }
</script>
<script type="text/javascript">

	function submitExperience(email)
	{
			var totalrows=document.getElementById('example').getElementsByTagName('tbody')[0].getElementsByTagName('tr').length;
			var content=document.getElementsByTagName('td');
			var contentElement = [];
			var coln = 0;
			for(var i = 1 ; i <= totalrows ; i++)
			{	
				coln = 9 * (i-1);
				for(c=coln;c<content.length;c++) 
				{
					coln = 9 * i;
					if((c+2) != coln && (c+1) != coln)
					{
						contentElement.push(content[c].innerHTML);
					}
					else
						break;
				}		
			}
			openNewPage("addexperience.htm",contentElement,email);
		}
		
		function openNewPage(urls,urlPara,email)
		{
			$.ajax({
				type : "GET",
				cache : false,
				url : urls,
	 			data : "experiencedetails="+urlPara+"&emailId="+email,
	 			complete: function (response) {
	 				location.replace("registrationsuccess.htm");
	            }
			}); 
		}
</script>
<script type="text/javascript">
	function restoreRow(oTable, nRow) {
		var aData = oTable.fnGetData(nRow);
		var jqTds = $('>td', nRow);

		for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
			oTable.fnUpdate(aData[i], nRow, i, false);
		}

		oTable.fnDraw();
	}

	function editRow(oTable, nRow) {
		var aData = oTable.fnGetData(nRow);
		var jqTds = $('>td', nRow);
		
		jqTds[0].innerHTML = '<input size="15%" type="text" value="'+aData[0]+'">';
		jqTds[1].innerHTML = '<input size="8%" type="text" value="'+aData[1]+'">';
		jqTds[2].innerHTML = '<select class="form-control"><option>YES</option><option>NO</option></select>';
		jqTds[3].innerHTML = '<div class="input-group date"><input id="strtdate" onclick="dateStartPick()" class="form-control" type="text" ><span class="input-group-addon"><i class="fa fa-calendar"></i></span></div>'
		jqTds[4].innerHTML = '<div class="input-group date"><input id="enddate" onclick="dateEndPick()" class="form-control" type="text" readonly ><span class="input-group-addon"><i class="fa fa-calendar"></i></span></div>';
		jqTds[5].innerHTML = '<input size="10%" type="text" value="'+aData[5]+'">';
		jqTds[6].innerHTML = '<select class="form-control">'
							+'<option>1</option>'
							+'<option>2</option>'
							+'<option>3</option>'
							+'<option>4</option>'
							+'<option>5</option>'
							+'<option>6</option>'
							+'<option>7</option>'
							+'<option>8</option>'
							+'<option>9</option>'
							+'<option>10</option>'
							+'</select>';
		jqTds[7].innerHTML = '<a class="edit" href=""><i class="fa fa-floppy-o fa-lg"></i></a>';
	}

	function saveRow(oTable, nRow) {
		var jqInputs = $('input', nRow);
		var jqSelects = $('select', nRow);
		oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
		oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
		oTable.fnUpdate(jqSelects[0].value, nRow, 2, false);
		oTable.fnUpdate(jqInputs[2].value, nRow, 3, false);
		oTable.fnUpdate(jqInputs[3].value, nRow, 4, false);
		oTable.fnUpdate(jqInputs[4].value, nRow, 5, false);
		oTable.fnUpdate(jqSelects[1].value, nRow, 6, false);
		oTable.fnUpdate('<a class="edit" href=""><i class="fa fa-pencil-square-o fa-lg"></i></a>', nRow, 7, false);
		oTable.fnDraw();
	}

	$(document).ready(function() {

						var oTable = $('#example').dataTable({"sPaginationType": "full_numbers"});
						var nEditing = null;
						
						
						
						//For Adding new Record
						$('#new').click(function(e) {
											e.preventDefault();
											var aiNew = oTable.fnAddData(['','','','','','','',
															'<a class="edit" href=""><i class="fa fa-pencil-square-o fa-lg"></i></a>',
															'<a class="delete" href=""><i class="fa fa-trash-o fa-lg"></i></a>' ]);
											var nRow = oTable.fnGetNodes(aiNew[0]);
											editRow(oTable, nRow);
											nEditing = nRow;
										});

						//For Deleting Record
						$('#example').on('click', 'a.delete', function(e) {
							e.preventDefault();

							var nRow = $(this).parents('tr')[0];
							oTable.fnDeleteRow(nRow);
						});

						//For Editing Record
						$('#example').on('click','a.edit',function(e) {
									e.preventDefault();

									/* Get the row as a parent of the link that was clicked on */
									var nRow = $(this).parents('tr')[0];

									if (nEditing !== null && nEditing != nRow) {
										/* Currently editing - but not this row - restore the old before continuing to edit mode */
										restoreRow(oTable, nEditing);
										editRow(oTable, nRow);
										nEditing = nRow;
									} else if (nEditing == nRow	&& this.innerHTML == '<i class="fa fa-floppy-o fa-lg"></i>') {
										/* Editing this row and want to save it */
										saveRow(oTable, nEditing);
										nEditing = null;
									} else {
										/* No edit in progress - let's start one */
										editRow(oTable, nRow);
										nEditing = nRow;
									}
								});
					});

</script>
</head>
<body>
	<jsp:include page="../includes/header.jsp" />
	<%
		String emailId = request.getParameter("id");
		session.setAttribute("emailId", emailId);
	%>
	<form:form id="registrationContactDetailsFormId"
		modelAttribute="registerContact" class="form-horizontal"
		name="registrationContactDetails" method="POST" action="addexperience.htm">
		<div class="row col-lg-12">
			<div style="padding-left: 10%" class="col-lg-11">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Experience Details</h3>
					</div>
					<div class="panel-body">
						<p>
							<a id="new" href=""><i class="fa fa-plus-square">Add New Experience</i></a>
						</p>
						<table class="table table-bordered table-hover tablesorter table-striped" id="example">
							<thead>
								<tr>
									<th>Company Name</th>
									<th>CTC</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>Position</th>
									<th>Experience</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
						</table>
						<div class="page-header"></div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<br />
								<a class="btn btn-primary" onclick="submitExperience('<%= emailId %>')" href="">
									<i class="fa fa-check"></i>Proceed
								</a>
							</div>
						</div>
					</div>
					<div class="panel-footer"></div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>
<%@include file="../includes/footer.jsp"%>