<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<style>
</style>
</head>
<body>


	<nav class="navbar  navbar-expand-sm  bg-dark  navbar-dark">
		<div class="navbar-header">

			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expaned="false">


				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>


			</button>

			<a class="navbar-brand" href="/wordpressme/main"><spring:message
					code="bar1"></spring:message></a>

		</div>

		<div class="collapse navbar-collapse"
			id="#bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">
				<li><a href="/wordpressme/main">코드데이터 메인</a></li>
				<li><a href="/wordpressme/edit/main">코드 게시판</a></li>
				<%
					if (session.getAttribute("Admin") != null) {
				%>
				<li><a href="/wordpressme/admin">관리자 페이지</a></li>
				<%
					}
				%>
			</ul>


			<%
				if (session.getAttribute("authinfo") == null) {
			%>

			<ul class="nav navbar-nav navbar-right navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="/wordpressme/login">로그인</a></li>
						<!--  선택된 페이지를 의미함. -->
						<li><a href="/wordpressme/register/registep1">회원가입</a></li>




					</ul></li>
			</ul>
			<%
				} else {
			%>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">내 정보 관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/wordpressme/logout">로그아웃</a></li>
						<li><a href="/wordpressme/member/change">비밀번호변경</a></li>
						<li><a href="/wordpressme/member/nickch">닉네임변경</a></li>
						<li><a href="/wordpressme/deletemem">회원 탈퇴</a></li>
					</ul></li>
			</ul>

			<%
				}
			%>
		</div>
	</nav>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />">
		
	</script>

</body>

</html>





