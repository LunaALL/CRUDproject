<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title><spring:message code="change.pwd" /></title>
<jsp:include page="../layout.jsp" />
</head>




<body>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">

			<!-- 점보트론 -->
			<div class="jumbotron" style="padding-top: 20px;">
				<h3 style="text-align: center;">
					<spring:message code="change.pwd" />
				</h3>
				<form:form action="/wordpressme/member/change"
					modelAttribute="pwdcommand" method="post">


					<div class="form-group">
						<input type="password" class="form-control" placeholder="현재비밀번호"
							name="oldpassword" maxlength="20">
						<form:errors path="oldpassword" />
					</div>
					<br>
					<br>

					<div class="form-group">
						<input type="password" class="form-control" placeholder="새로운 비밀번호"
							name="newpassword" maxlength="20">
						<form:errors path="newpassword" />
					</div>

					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호재확인"
							name="confirmpassword" maxlength="20">
						<form:errors path="confirmpassword" />
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary form-control"
							value="비밀번호변경확인">
					</div>


				</form:form>
			</div>
		</div>

	</div>


</body>
</html>