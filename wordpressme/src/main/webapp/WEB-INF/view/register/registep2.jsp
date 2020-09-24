<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="../layout.jsp"%>

<!DOCTYPE html>
<html>

<head>
<title>회원가입창2</title>
<style>
</style>
</head>

<body>

	<!-- 네비게이션  -->




	<div class="container">
		<div class="col-lg-6">

			<!-- 점보트론 -->
			<div class="jumbotron" style="padding-top: 20px;">
				<h3 style="text-align: center;">
					<spring:message code="member.register" />
				</h3>
				<form:form action="registep3" modelAttribute="memberRegiService"
					method="post">

					<div class="form-group">
						<input type="text" class="form-control" placeholder="이메일"
							name="email" maxlength="20">
						<form:errors path="email" />
					</div>


					<div class="form-group">
						<input type="text" class="form-control" placeholder="닉네임"
							name="name" maxlength="20"> <span class="text-primary"><form:errors
								path="name" /> </span>
					</div>



					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="password" maxlength="20"> <span
							class="text-primary"><form:errors path="password" /> </span>
					</div>

					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호확인"
							name="confirmpassword" maxlength="20">
					</div>

					<div class="form-group">
						<span class="text-primary"><form:errors
								path="confirmpassword" /> </span>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary form-control"
							value="회원가입">
					</div>


				</form:form>
			</div>
		</div>

	</div>




	<div class="col-lg-4"></div>


</body>
</html>





