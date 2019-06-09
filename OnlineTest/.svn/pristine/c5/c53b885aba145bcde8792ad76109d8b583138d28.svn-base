<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession httpSession = request.getSession(false);
if(httpSession.getAttribute("email") == null || httpSession.getAttribute("email").toString() == null) { %>
		<jsp:forward page="/sessionexpired.htm" />
<%	} else { %>

<%@include file="../includes/admin-menu.jsp" %>
<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 maximum-scale=1">
<title><spring:message code="onlinetest.addquestion.title" /></title>
<script type="text/javascript" src="./jsp/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="./jsp/js/html5shiv.js"></script>
<script type="text/javascript" src="./jsp/js/respond.js"></script>
<script type="text/javascript" src="./jsp/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<style type="text/css">
body {
	padding-left: 5%;
	padding-right: 5%;
}
</style>
<script type="text/javascript">
function addQuestionDiv() {
	try {
		var questionType = (document.getElementById("qtypeid").options[document
				.getElementById("qtypeid").selectedIndex].value);
		//alert("qtype: " + qtype);

		switch (questionType) {
		case '1':
			$('#addQuestion').load("addsinglechoicequestion.htm");
			//alert("single choice");
			break;
		case '2':
			$('#addQuestion').load("addmultiplechoicequestion.htm");						
			//alert("Multiple choice");
			break;
		case '3':
			$('#addQuestion').load("addcomprehensionquestion.htm");
			//alert("comprehension")
			break;
		case '4':
			$('#addQuestion').load("addsequencequestion.htm");
			//alert("sequence");
			break;
		case '5':
			$('#addQuestion').load("addcodingquestion.htm");
			//alert("sourcecode");
			break;
		}

	} catch (err) {
		alert("Error: " + err.message);
	}
}



$(document).ready(function(){
    $('select#qpoolforadvtid').on('change', function() {
         var value = this.value;
        var advtName = document.getElementById("qpoolforadvtid").options[document.getElementById("qpoolforadvtid").selectedIndex].text;
          if(value =="select") {
              $('#designation').html("");
              return false;
          }
          else if(advtName=="General") {
        	  $('#designation').html("");
              return false;
          }
          else {
              $('#designation').load("designationcontrol.htm?Value="+value);
                document.getElementById("designation").style.visibility="visible";
           
          }
         
    });

});

</script>
</head>
<body>
<form name="addquestionform" class="form-horizontal" action="addedsuccessfully.htm" method="post">
	<div class="row col-lg-12">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">Online Examination - Add Questions to Question Bank</h3>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="addQuestionTag" class="col-sm-4 control-label"><spring:message
					code="onlinetest.addquestion.category" /><br><span><sub>(For ex. Java, Python, C etc...)</sub></span></label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="addQuestionCategory"
							id="addQuestionCategoryId" list="categoryList" placeholder="Please enter the Question Category" required />
						<datalist id="categoryList">
							<option value="General Knowledge (GK)/ Current Affairs">
							<option value="Mathematical / Quantitative Aptitude">
							<option value="Verbal / Logical Reasoning">
							<option value="C - Programming">
							<option value="C++ - Programming">
							<option value="Java - Programming">
							<option value="Python - Programming">
							<option value="Scilab - Programming">
							<option value="PHP/MySQL - Programming">
							<option value="Database Management Systems (DBMS)">
							<option value="Others">
						</datalist>
					</div>
			</div>
					
			<div class="form-group">
				<label for="emailId" class="col-sm-4 control-label"><spring:message
					code="onlinetest.addquestion.advt" /><br><span><sub>(Select Advt. and designation for the question)</sub></span></label>
					<div class="col-sm-6">
						<select class="form-control" name="qpoolforadvt" id="qpoolforadvtid"  data-toggle="designation" required>
							<option value="select">-- Select --</option>
							<c:forEach var="advertisement" items="${advts}">
  								<option value='<c:out value="${advertisement.advertisementId}"/>'><c:out value="${advertisement.advertisementTitle}"/></option>
  							</c:forEach>
						</select>	
					</div>
			</div>
			
			<div class="form-group" id="designation" style="visibility: hidden">
			
			</div>
					
			<div class="form-group">
				<label for="lod" class="col-sm-4 control-label"><spring:message
					code="onlinetest.addquestion.lod" /><br><span><sub>(Select the level of difficulty based on 1-5)</sub></span></label>
					<div class="col-sm-6">
						<select class="form-control" name="lod" id="lodid" required>
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
					code="onlinetest.addquestion.qtype" /><br><span><sub>(Select Single choice, multiple choice etc...)</sub></span></label>
					<div class="col-sm-6">
						<select class="form-control" name="qtype" id="qtypeid" onchange="addQuestionDiv();" required>
							<option value="select">-- Select --</option>
						    <option value="1">Single Choice Questions</option>
							<option value="2">Multiple Choice Questions</option>
							<option value="3">Comprehension Questions</option>
							<option value="4">Sequencing Questions</option>
							<option value="5">Source Code Questions</option>
						</select>	
					</div>
			</div>
					
			<div class="page-header"></div>
					
			<div id="addQuestion" class="form-group">
					
			</div>
			
			<div class="page-header"></div>
					
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-10">
					<br /><button type="submit" class="btn btn-primary"><i class="fa fa-check"></i> Add to Question Bank</button>
					<button type="reset" class="btn btn-default"><i class="fa fa-eraser"></i> Reset</button>
					<button type="submit" class="btn btn-danger" formaction="examhome.htm"><i class="fa fa-times"></i> Cancel</button>
				</div>
			</div>
		</div>
		<div class="panel-footer"></div>
	</div>					
</div>
</form>	
</body>
</html>
<%@include file="../includes/footer.jsp" %>
<%}%>