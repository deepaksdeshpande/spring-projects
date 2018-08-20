<%@page import="org.iitb.exam.main.wrappers.ExamDetail"%>
<%@page import="org.iitb.exam.main.dto.Exam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<!--[if IE 8]><html class="lt-ie10 ie8" lang="en data-scribe-reduced-action-queue="true""><![endif]-->
<!--[if IE 9]><html class="lt-ie10 ie9" lang="en data-scribe-reduced-action-queue="true""><![endif]-->
<!--[if gt IE 9]><!-->
<html lang="en" data-scribe-reduced-action-queue="true">
<!--<![endif]-->
<%
	String examobject = session.getAttribute("ExamObject").toString();
	Exam exam = (Exam) session.getAttribute("examdetails");
%>
<head>
<meta charset="utf-8">
<title><spring:message code="home.title" /></title>
<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="./jsp/js/html5shiv.js"></script>
<script type="text/javascript" src="./jsp/js/respond.js"></script>
<link rel="stylesheet" href="../css/qunit-1.11.0.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<script src="../js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="../js/bootstrap.js" type="text/javascript"></script>

<script type="text/javascript">


	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, "");
		};
	function displayQuestion(questionIndex) {
		var question_div_id;
		if (initialQuestion != questionIndex) {
			question_div_id = "question_div" + initialQuestion;
			document.getElementById(question_div_id).style.display = "none";
		}
		question_div_id = "question_div" + questionIndex;
		document.getElementById(question_div_id).style.display = "block";
		initialQuestion = questionIndex;
	}

	
	
	var initialQuestion = 0;
	var response = new Array();
	function displayQuestions() {
		var questions_content = "";
		var question_list =<%=examobject%>;
		for (var i = 0; i < (question_list.QuestionList.length); i++) {
			response[i] = "Z";
			var questiontext = question_list.QuestionList[i].QuestionText;
			var qtype = question_list.QuestionList[i].QuestionType;
			
			questions_content += "<div id='question_div"+i+"' style='display:none;'>";
			if (qtype == "1" || qtype == "4") {

				questions_content += (i + 1) + ". " + questiontext + "</br>";

				for (var j = 0; j < (question_list.QuestionList[i].OptionList.length); j++) {
					var qname = "question" + i;
					questions_content += "<label style='margin-left: 25px;'><input type='radio' name="+ qname+ " onchange='isResponded("+ i+ ", "+ qtype+ ")'  value='"+ question_list.QuestionList[i].OptionList[j]
							+ "'/> "+ String.fromCharCode(65 + j)+ " . "+ question_list.QuestionList[i].OptionList[j].OptionValue+ "</label> <br/> <br/>";
				}
			} else if (qtype == "2") {
				questions_content += (i + 1) + ". " + questiontext + "</br></br>";
				questions_content += "ANSWER : <input type='text' name='numeric"
						+ i
						+ "' id='numeric"
						+ i
						+ "' onkeyup='isResponded("
						+ i + ", " + qtype + ")'> </br></br>";
			} else if (qtype == "3") {
				questions_content += (i + 1) + ". " + questiontext + "</br>";

				for (var j = 0; j < (question_list.QuestionList[i].OptionList.length); j++) {
					questions_content += "<label style='margin-left: 25px;'><input type='checkbox' name='question"
							+ i
							+ "' onchange='isResponded("
							+ i
							+ ", "
							+ qtype
							+ ")'  value='"
							+ question_list.QuestionList[i].OptionList[j]
							+ "'/>"
							+ String.fromCharCode(65 + j)
							+ " . "
							+ question_list.QuestionList[i].OptionList[j].OptionValue
							+ "</label> <br/> <br/>";
				}
			}
			questions_content += "</div>";
		}

		document.getElementById("questions").innerHTML = questions_content;
		displayQuestion(0);
	}

	

	function isResponded(qindex, qtype) {
		var flag = 0;
		if (qtype == 1) {
			var radio = document.getElementsByName("question" + qindex);
			for (var i = 0; i < radios.length; i++) {
				if (radio[i].checked) {
					response[qindex] = String.fromCharCode(65 + i);
					flag = 1;
				}
			}
		}
		if (qtype == 4) {
			var radio = document.getElementsByName("question" + qindex);
			for (var i = 0; i < radios.length; i++) {
				if (radio[i].checked) {
					response[qindex] = String.fromCharCode(65 + i);
					flag = 1;
				}
			}
		} else if (qtype == 2) {
			var text = document.getElementById("numeric" + qindex).value;
			if (text.trim().length >= 1) {
				response[qindex] = text.trim();
				flag = 1;
			}
		} else if (qtype == 3) {
			var checkvalues = document.getElementsByName("question" + qindex);
			response[qindex] = "";
			for (var i = 0; i < checkvalues.length; i++) {
				if (checkvalues[i].checked) {
					response[qindex] += String.fromCharCode(65 + i);
					flag = 1;
				}
			}
		}

	}

	
</script>
<script type="text/javascript">
	function init(minutes) {

		var timeInSeconds = (minutes * 60);
		var sec_num = parseInt(timeInSeconds, 10); // don't forget the second parm
		var hours = Math.floor(sec_num / 3600);
		var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
		var seconds = sec_num - (hours * 3600) - (minutes * 60);
		displayQuestions();
		timer.init(hours, minutes, seconds);
	}
	var timer = {
		minutes : 0,
		seconds : 0,
		elm : null,
		samay : null,
		sep : ':',
		init : function(h, m, s) {
			h = parseInt(h, 10);
			m = parseInt(m, 10);
			s = parseInt(s, 10);
			if (h < 0 || m < 0 || s < 0 || isNaN(h) || isNaN(m) || isNaN(s)) {
				alert('Invalid Values');
				return;
			}
			this.hours = h;
			this.minutes = m;
			this.seconds = s;
			timer.start();

		},
		start : function() {
			this.samay = setInterval((this.doCountDown), 1000);
		},
		doCountDown : function() {
			if (timer.seconds == 0) {
				if (timer.minutes == 0) {
					if (timer.hours == 0) {
						clearInterval(timer.samay);
						timerComplete();
						return;
					} else {
						timer.seconds = 60;
						timer.minutes = 59;
						timer.hours--;
					}
				} else {
					timer.seconds = 60;
					timer.minutes--;
				}
			}
			timer.seconds--;
			timer.updateTimer(timer.hours, timer.minutes, timer.seconds);
		},
		updateTimer : function(hr, min, secs) {
			hr = (hr < 10 ? '0' + hr : hr);
			min = (min < 10 ? '0' + min : min);
			secs = (secs < 10 ? '0' + secs : secs);
			if (hr <= 0 && min <= 0 && secs <= 0) {
				document.getElementById('clock').innerHTML = "";
				return;
			} else {
				document.getElementById('clock').innerHTML = '<i class="fa fa-clock-o fa-1g fa-spin"></i> '
						+ hr + " : " + min + " : " + secs;

			}
		}
	}
	function timerComplete() {
		alert('Time up ..!!');
		alert(response);
		var responsetext = "";
		for(var i=0;i<response.length;i++){
			responsetext += response[i] + "@@";
		}
alert("Response : "+responsetext);
	}
</script>



</head>

<body
	onload="paginationcalled('${examobject.examDuration}','<%=exam.getTotalQuestions()%>');">
	<jsp:include page="../includes/admin-menu.jsp" />
	<form:form id="startexam" name="startExamForm" method="POST" action="#">
		<div class="row">
			<div class="col-lg-10 " style="padding-left: 15%;">
				<div class="panel panel-info">
					<div class="panel-heading">Online Examination</div>
					<div class="panel-body">
						<div class="col-lg-4 text-center">
							<label>User Name : <%=session.getAttribute("email")%></label>
						</div>
						<div class="col-lg-4 text-center">
							<label>Designation : ${examobject.designationName}</label>

						</div>
						<div class="col-lg-4 text-center">
							<label>Exam Name : ${examobject.examName}</label>
						</div>

						<div class="col-lg-3 text-center well" style="float: right;">
							<div id="clock"
								style="font-size: 24px; font-weight: bolder; font-stretch: expanded; padding-right: 20px"></div>
							&nbsp;&nbsp;Hours &nbsp;&nbsp;Mins &nbsp; Secs
						</div>
						<div style="text-align: justify; padding-left: 40%">
							<ul id='pagination'></ul>
						</div>

						<div class="well" id="questions"
							style="float: left; margin-top: 20px; width: 100%; font-size: 18px; font-weight: bold; text-align: justify; padding-left: 20px">
						</div>


						<div id="panel-footer"></div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<footer>
		<%@include file="../includes/footer.jsp"%>
	</footer>


	<script src="./jsp/js/bootstrap-paginator.js"></script>
	<script src="./jsp/js/qunit-1.11.0.js"></script>
	<script type="text/javascript">
		function paginationcalled(duration, questionno) {
			init(duration);
			options = {
				size : "small",
				bootstrapMajorVersion : 3,
				currentPage : 1,
				numberOfPages : 10,
				totalPages : questionno,
				alignment : "center",
				onPageClicked : function(e, originalEvent, type, page) {
					displayQuestion(page - 1);
				}
			};

			var element = $('#pagination');

			element.bootstrapPaginator(options);

		}
	</script>

</body>
</html>