<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form-group">
	<label for="designations" class="col-sm-4 control-label"><spring:message
			code="onlinetest.addquestion.desg" /></label>
	<div class="col-sm-6">
		<select class="form-control" name="desgnames" id="designations"
			multiple="multiple">
			<c:forEach var="posts" items="${posts}">
				<option value='<c:out value="${posts.designationName}"/>'><c:out
						value="${posts.designationName}" /></option>
			</c:forEach>
		</select>
	</div>
</div>
