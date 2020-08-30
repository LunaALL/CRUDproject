<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

<jsp:include page="../layout.jsp" />


<title>회원가입창3</title>
<style>
</style>
</head>

<body>



	<div class="container">
		<div class="col-lg-4">
			<!-- 점보트론 -->
			<div class="jumbotron" style="padding-top: 20px;">

				<p style="text-align: center">${memberRegiService.name}님회원가입을
					진심으로 환영합니다.</p>
				<br> <a href="/wordpressme/main">메인으로</a>



			</div>
		</div>
	</div>


	<div class="col-lg-4"></div>


</body>

</html>





