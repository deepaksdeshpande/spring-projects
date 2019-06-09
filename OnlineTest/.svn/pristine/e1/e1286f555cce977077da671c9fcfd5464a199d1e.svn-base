<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HttpSession httpSession = request.getSession(false);
if(httpSession.getAttribute("email") == null || httpSession.getAttribute("email").toString() == null) { %>
		<jsp:forward page="/sessionexpired.htm" />
<%	} else { %>

<jsp:include page="../includes/admin-menu.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="onlinetest.displayquestion.title" /></title>
<script type="text/javascript" src="./jsp/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./jsp/js/bootstrap.js"></script>

<script type="text/javascript" src="./jsp/js/dataTables/jquery.dataTables.js"></script>
<script type="text/javascript" src="./jsp/js/dataTables/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="./jsp/css/dataTables.bootstrap.css" />
<script type="text/javascript">
$(document).ready(function() {
    $("#questionDisplayTable").dataTable({
		"sPaginationType" : "full_numbers"
    });
});
</script>

</head>
<body>

<form name="displayquestionform" id="displayquestionformid" method="post" action="">
	<div class="row">
		<div class="col-lg-11" style="padding-left: 10%;">
		<div class="panel panel-info">
			<div class="panel-heading">
				<i class="fa fa-table fa-fw"></i> Display All Questions from Question Bank
			</div>
			<div class="panel-body">
				 <div class="table-responsive">
				 <input type="hidden" name="qid" value='<c:out value="${questionBank.questionid }" />' />
					<table style="width: 100%;" class="table table-striped table-bordered table-hover tablesorter" 
						id="questionDisplayTable">
					<thead class="alert alert-warning">
						<tr>
							<th>Question Type</th>
							<th align="center">Question Text</th>
							<th>Level of Difficulty </th>
							<th>Question Category </th>
							<th>Question Archived </th>
							<th>Edit Question </th>
							<!-- <th>Delete Question </th> -->
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="questions" items="${questionBankList}">
						<tr>
							<td><c:out value = "${questions.questionType}" /></td>
							<td style="text-align: justify;"><c:out value = "${questions.questionText}" /></td>
							<td><c:out value = "${questions.levelOfDifficulty}" /></td>
							<td><c:out value = "${questions.questionCategory}" /></td>
							<td><c:out value = "${questions.archived}" /></td>
							<c:if test="${questions.questionType == '1'}" >
								<td><button class="btn btn-link" formaction='editsinglechoicequestion.htm?qid=<c:out value="${questions.questionid}" />'><i class="fa fa-pencil-square-o"></i> Edit</button></td>
							</c:if>
							<c:if test="${questions.questionType == '2'}" >
								<td><button class="btn btn-link" formaction='editmultiplechoicequestion.htm?qid=<c:out value="${questions.questionid}" />'><i class="fa fa-pencil-square-o"></i> Edit</button></td>
							</c:if>
							<c:if test="${questions.questionType == '3'}" >
								<td><button class="btn btn-link" formaction='editcomprehensionquestion.htm?qid=<c:out value="${questions.questionid}" />'><i class="fa fa-pencil-square-o"></i> Edit</button></td>
							</c:if>
							<c:if test="${questions.questionType == '4'}" >
								<td><button class="btn btn-link" formaction='editsequencequestion.htm?qid=<c:out value="${questions.questionid}" />'><i class="fa fa-pencil-square-o"></i> Edit</button></td>
							</c:if>
							<c:if test="${questions.questionType == '5'}" >
								<td><button class="btn btn-link" formaction='editcodingquestion.htm?qid=<c:out value="${questions.questionid}" />'><i class="fa fa-pencil-square-o"></i> Edit</button></td>
							</c:if>
							
							<%-- <td><button class="btn btn-link" formaction='editquestion.htm?qid=<c:out value="${questions.questionid}" />'><i class="fa fa-pencil-square-o"></i> Edit</button></td> --%>
							<!-- <td><button class="btn btn-danger"><i class="fa fa-times"></i> Delete</button></td> -->
						</tr>
						</c:forEach>
					</tbody>
					
					<tfoot class="alert alert-warning">
						<tr>
							<th><sub>Question Types : 1- Single Choice, 2 - Multiple Choice, 3 - Comprehension, 4 - Sequencing Question, 5 - Code Submission</sub></th>
							<th><sub>Note : The html elements appears along with the question text because of the additional styling done in the editor.</sub></th>
							<th><sub>Level of difficulty is on a scale of 1 to 5, 1 being the easiest and 5 being the toughest.</sub></th>
							<th><sub>The question category can be GK, C, C++, Java, Python, etc...</sub></th>
							<th><sub> 1 - Question Archived,   0 - Question Not archived</sub></th>
						</tr>
					</tfoot>
				</table>
				</div>
			</div>
			<div class="panel-footer"></div>
		</div>
	</div>
</div>
</form>



</body>
</html>
<jsp:include page="../includes/footer.jsp"></jsp:include>
<%}%>