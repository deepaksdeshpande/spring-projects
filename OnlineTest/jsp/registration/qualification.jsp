<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registration : Qualification</title>

<link rel="stylesheet" type="text/css" href="./jsp/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="./jsp/css/bootstrap.css" media="all"/>
<link rel="stylesheet" type="text/css" href="./jsp/css/slider.css" media="all"/>
<link href="./jsp/css/dataTables.bootstrap.css" rel="stylesheet" />
<script src="./jsp/js/jquery-1.10.2.js"></script>
<script src="./jsp/js/bootstrap.js"></script>
<script src="./jsp/js/jqBootstrapValidation.js"></script>
<script src="./jsp/js/jquery.dataTables.min.js"></script>
<script src="./jsp/js/jquery.dataTables.js"></script>

<script>
function submitQualification(email)
	{
		var totalrows=document.getElementById('example').getElementsByTagName('tbody')[0].getElementsByTagName('tr').length;
		var content=document.getElementsByTagName('td');
		var contentElement = [];
		var coln = 0;
		for(var i = 1 ; i <= totalrows ; i++)
		{	
			coln = 7 * (i-1);
			for(c=coln;c<content.length;c++) 
			{
				coln = 7 * i;
				if((c+2) != coln && (c+1) != coln)
				{
					contentElement.push(content[c].innerHTML);
				}
				else
					break;
			}		
		}
		openNewPage("addqualification.htm",contentElement,email);
	}
	
	function openNewPage(urls,urlPara,email)
	{
		$.ajax({
			type : "GET",
			cache : false,
			url : urls,
 			data : "qualificationdetails="+urlPara+"&emailId="+email,
 			complete: function (response) {
 				location.replace("experience.htm?id="+email);
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

		jqTds[0].innerHTML = '<input type="text" value="'+aData[0]+'">';
		jqTds[1].innerHTML = null;
		var r = '<select class="form-control">';
		for (var i = 1960; i <= 2014; i++) {
			if (aData[1] == i) {
				r = r + '<option value='+ i +' selected>' + i + '</option>';
			} else {
				r = r + '	<option value='+i+'>' + i + '</option>';
			}
		}
		r = r + '</select>';
		jqTds[1].innerHTML = r;
		jqTds[2].innerHTML = '<input type="text" value="'+aData[2]+'">';
		jqTds[3].innerHTML = '<input type="text" value="'+aData[3]+'">';
		jqTds[4].innerHTML = '<select class="form-control"><option>Full Time</option><option>Part Time</option></select>';
		jqTds[5].innerHTML = '<a class="edit" href=""><i class="fa fa-floppy-o fa-lg"></i></a>';
	}

	function saveRow(oTable, nRow) {
		var jqInputs = $('input', nRow);
		var jqSelects = $('select', nRow);
		oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
		oTable.fnUpdate(jqSelects[0].value, nRow, 1, false);
		oTable.fnUpdate(jqInputs[1].value, nRow, 2, false);
		oTable.fnUpdate(jqInputs[2].value, nRow, 3, false);
		oTable.fnUpdate(jqSelects[1].value, nRow, 4, false);
		oTable.fnUpdate('<a class="edit" href=""><i class="fa fa-pencil-square-o fa-lg"></i></a>', nRow, 5, false);
		oTable.fnDraw();
	}

	$(document).ready(function() {

						var oTable = $('#example').dataTable({"sPaginationType": "full_numbers"});
						var nEditing = null;
						
						
						
						//For Adding new Record
						$('#new').click(function(e) {
											e.preventDefault();
											var aiNew = oTable.fnAddData(['','','','','',
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
	<form:form id="qualificationDetailsFormId"
		modelAttribute="qualificationDetails" class="form-horizontal"
		name="qualificationDetails" method="POST">
		<div class="row col-lg-12">
			<div style="padding-left: 10%" class="col-lg-11">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Professional Details</h3>
					</div>
					<div class="panel-body">
						<p>
							<a id="new" href=""><i class="fa fa-plus-square">Add New Qualification</i></a>
						</p>
						<table class="table table-bordered table-hover tablesorter table-striped" id="example">
							<thead>
								<tr>
									<th>Qualification Name</th>
									<th>Passing Year</th>
									<th>University Name</th>
									<th>Percentage</th>
									<th>Qualification Type</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
						<div class="page-header"></div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<br />
								<a class="btn btn-primary" onclick="submitQualification('<%= emailId %>')" href="">
									<i class="fa fa-check"></i>Proceed
								</a>
							</div>
						</div>
						<input type="hidden" name="emailId" values="<%= emailId %>">
					</div>
					<div class="panel-footer"></div>
				</div>
			</div>
		</div>
	</form:form>
<%@include file="../includes/footer.jsp"%>
</body>
</html>