<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, org.iitb.exam.main.dto.OptionBank" %>
<%
HttpSession httpSession = request.getSession(false);
if(httpSession.getAttribute("email") == null || httpSession.getAttribute("email").toString() == null) { %>
		<jsp:forward page="/sessionexpired.htm" />
<%	} else { %>

<jsp:include page="../includes/admin-menu.jsp"></jsp:include>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ckeditor" uri="http://ckeditor.com" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="onlinetest.editquestion.title" /></title>
<script type="text/javascript" src="./jsp/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./jsp/js/bootsrap.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css" />
<script type="text/javascript">

var ctr = 4;

function addOption()
{
	//alert(ctr);
	if(ctr<6)
		{
		try
		{
			ctr++;
			var div = document.createElement("div");
			var label = document.createElement("span");
			var radioButton = document.createElement("input");
			var textbox = document.createElement("input");
			var removeButton = document.createElement("a");
			

			div.setAttribute("class", "radio")
			div.setAttribute("id", "div"+ctr)
			label.setAttribute("id", "span"+ctr)
			radioButton.setAttribute("type", "radio");
			radioButton.setAttribute("name", "option");
			radioButton.setAttribute("value", ctr);
			radioButton.setAttribute("id", "radio"+ctr);
			
			textbox.setAttribute("name", ""+ctr);
			textbox.setAttribute("type", "text");
			textbox.setAttribute("id","txt"+ctr);
			textbox.setAttribute("class", "form-control");
			textbox.setAttribute("placeholder", "Enter option "+ctr)
			
			
			
			
		}
		catch(err)
		{
			alert(err.message);
		}
		try
		{
	
			removeButton.setAttribute("href", "javascript:removeOption("+(ctr)+")");
			removeButton.setAttribute("id","remove"+(ctr));
			removeButton.setAttribute("class","glyphicon glyphicon-minus-sign");
			removeButton.setAttribute("style","width:20px;");
		}
		catch(err)
		{
			alert(err.message);
		}
		
		try
		{
			var before=document.getElementById("singleadd");
			var par=before.parentNode;
			div.appendChild(label);
			div.appendChild(radioButton);
			div.appendChild(textbox);
			div.appendChild(removeButton);
			par.insertBefore(div,before);
			label.innerHTML=(String.fromCharCode(64+ctr));
			document.getElementById("count").value=ctr;
		}
		catch(err)
		{
			alert(err.message);
		}
	}
	else
	{
		alert("Options not more than 6!");
	}
}
function removeOption(opt)
{
	var i=0;
	if(ctr>4)
	{
		for(i=opt;i<ctr;i++)
		{	
			document.getElementById("txt"+i).value=document.getElementById("txt"+(i+1)).value;
			document.getElementById("radio"+i).checked = document.getElementById("radio"+(i+1)).checked;
		}
		try
		{
		//	alert("Assigning!");
			var child1=document.getElementById("div"+ctr);
			var parent=document.getElementById("parent");
			parent.removeChild(child1);
			
				
		}
		catch(err)
		{
			alert("here---"+err.message);
		}

		ctr--;
		
		document.getElementById("count").value=ctr;
	}
	else
	{
		alert("Options must be more than 4!");
	}
}

function getCKEditorContents() {
	var editor = CKEDITOR.instances.qText;
	document.getElementById("qTextId").innerHTML='${questionBank.questionText}';

	if('${questionBank.shuffle}'==1) {
		alert('Shuffle is ${questionBank.shuffle}');
		document.getElementById("shufflecheckid").checked=true;
		document.getElementById("shufflecheckid").value=1;
	}
	else {
		alert('Shuffle is ${questionBank.shuffle}');
		document.getElementById("shufflecheckid").checked=false;
		document.getElementById("shufflecheckid").value=0;
	}

	if('${questionBank.archived}'==1) {
		alert('Archived is ${questionBank.archived}');
		document.getElementById("archivedcheckid").checked=true;
		document.getElementById("archivedcheckid").value=1;
	}
	else {
		alert('Archived is ${questionBank.archived}');
		document.getElementById("archivedcheckid").checked=false;
		document.getElementById("archivedcheckid").value=0;
	}
}
</script>
</head>
<body onload="getCKEditorContents();">
	<form method="post" class="form-horizontal" name="editquestionform" id="editquestionformid" action="updatedsuccessfully.htm">
		<div class="row">
			<div class="col-lg-11" style="padding-left: 10%;">
				<div class="panel panel-info">
					<div class="panel-heading">
						<i class="fa fa-pencil-square-o"></i> Update Single Choice Question <c:out value="${questionBank.questionid}" />,<c:out value="${advtisement.advertisementTitle}" />,<c:out value="${questionBank.levelOfDifficulty}" />
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="addQuestionTag" class="col-sm-4 control-label"><spring:message
									code="onlinetest.editquestion.category" /><br> <span><sub>(For
										ex. Java, Python, C etc...)</sub></span></label>
										
							<div class="col-sm-6">
								<input type="hidden" class="form-control"
									name="questionId" id="questionId"
									value="${questionBank.questionid}" />
								
							</div>
										
							<div class="col-sm-6">
								<input type="text" class="form-control"
									name="addQuestionCategory" id="addQuestionCategoryId"
									value='<c:out value="${questionBank.questionCategory}" />'
									placeholder="Please enter the Question Category" readonly="readonly" />
								
							</div>
						</div>

						<div class="form-group">
							<label for="emailId" class="col-sm-4 control-label"><spring:message
									code="onlinetest.editquestion.advt" /><br> <span><sub>(Select
										Advt. and designation for the question)</sub></span></label>
							<div class="col-sm-6">
								<select class="form-control" name="qpoolforadvt"
									id="qpoolforadvtid" data-toggle="designation" disabled="disabled">
									<option selected="selected" value='<c:out value="${advertisement.advertisementId}" />'><c:out value="${advertisement.advertisementTitle}" /></option>
								
								</select>
							</div>
						</div>

						<div class="form-group" id="designation"
							style="visibility: hidden"></div>

						<div class="form-group">
							<label for="lod" class="col-sm-4 control-label"><spring:message
									code="onlinetest.editquestion.lod" /><br> <span><sub>(Select
										the level of difficulty based on 1-5)</sub></span></label>
							<div class="col-sm-6">
								<select class="form-control" name="lod" id="lodid" required>
									<option selected="selected" value='<c:out value="${questionBank.levelOfDifficulty}" />'><c:out value="${questionBank.levelOfDifficulty}" /></option>
									<option value="select">-- Select --</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</div>
						</div>

						<div id="questiontype" class="form-group">
							<label for="qtype" class="col-sm-4 control-label"><spring:message
									code="onlinetest.editquestion.qtype" /><br> <span><sub>(1-Single choice, 2-Multiple choice, 3-Comprehension, 4-Sequencing, 5-Code Submission etc...)</sub></span></label>
							<div class="col-sm-6">
								<select class="form-control" name="qtype" id="qtypeid"
									  disabled="disabled">
									<option selected="selected" value='<c:out value="${questionBank.questionType}" />'><c:out value="${questionBank.questionType}" /></option>
									
								</select>
							</div>
						</div>

						<div class="page-header"></div>
						
						<!-- <div id="addQuestion" class="form-group"></div> -->

						<div class="form-group">
							<label for="qtype" class="col-sm-4 control-label"><spring:message
									code="onlinetest.addquestion.qtext" /></label>
							<div class="col-sm-6">
								<textarea name="qText" id="qTextId" class="form-control"
									rows="4" cols="50" draggable="false"
									placeholder="Enter your Single Choice question here..."></textarea>
							</div>

							<ckeditor:replace replace="qText" basePath="./ckeditor/"></ckeditor:replace>

						</div>

						<div class="form-group">
							<label for="options" class="col-sm-4 control-label"><spring:message
									code="onlinetest.addquestion.qoption" /> </label><br />
							<div id="parent" class="col-sm-6">
							
								<c:set var="ctr" value="${optListSize}"></c:set>
								<%char label='A';%>
								<c:forEach var="i" begin="1" end="${ctr}">
								<div id='div<c:out value="${i}" />' class="radio">
									<span id='span<cout value="${i}" />'>
										<%=(label++) %>
									</span>
										<input type="radio" name="option" id='radio<c:out value="${i}" />' 
										value='<c:out value="${i}" />'
											<c:if test="${optList[i-1].optionCorrectness eq 1}">
												checked="checked"
											</c:if>
										>
									
									<input type="hidden" name="optionId" id="optionId" value="${optList[i-1].optionId}" />	
									
									<script type="text/javascript">
										alert('Option Id for update is : ${optList[i-1].optionId} Option Text for update is : ${optList[i-1].optionText} Option Correctness for update is : ${optList[i-1].optionCorrectness}');
									</script>
										
									<input type="text" class="form-control" name='<c:out value="${i}" />' id='txt<c:out value="${i}" />'
									placeholder='Enter option <c:out value="${i}" />' value="${optList[i-1].optionText}" />
									<a style="width: 20px" class="glyphicon glyphicon-minus-sign"
										id="remove1" href="javascript:removeOption(${i})"></a>
								</div>
								</c:forEach>
								
								<script type="text/javascript">ctr = ${ctr}</script>
							
								<input type="hidden" id="count" name="count" value="${optListSize}" />

								<div id="singleadd" class="form-group">
									<button class="btn btn-success" type="button"
										onclick="addOption( );">
										<i class="fa fa-plus-circle"></i> Add Option
									</button>

								</div>
							</div>
						</div>

						<div class="page-header"></div>
						
						<div class="checkbox col-sm-2">
							<input type="checkbox" name="shufflecheck" id="shufflecheckid" value="${questionBank.shuffle}"> Shuffle Options
						</div>
						<div class="checkbox col-sm-2">
							<input type="checkbox" name="archivedcheck" id="archivedcheckid" value="${questionBank.archived}"> Archive this Question
						</div>

						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<br />
								<button type="submit" class="btn btn-primary">
									<i class="fa fa-check"></i> Add to Question Bank
								</button>
								<button type="reset" class="btn btn-default">
									<i class="fa fa-eraser"></i> Reset
								</button>
								<button type="submit" class="btn btn-danger"
									formaction="examhome.htm">
									<i class="fa fa-times"></i> Cancel
								</button>
							</div>
						</div>
					</div>
					<div class="panel-footer"></div>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
	
	</script>
</body>
</html>
<jsp:include page="../includes/footer.jsp"></jsp:include>
<% } %>