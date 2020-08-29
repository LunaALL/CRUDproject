<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../layout.jsp" />
<meta charset="UTF-8">
<c:url value="/img/main1.jpg" var="main1" />
<title>메인페이지</title>
</head>
<body>
	<div class="jumbotron" style="padding-top: 20px;">

		<div class="container">
			<h2 style="font-family: verdana;">
				<spring:message code="member.welcome" />
			</h2>
			<br>
			<p style="font-family: courier;">프론트는 디자인 템플릿인 부트스트랩 + jsp +
				Jstl을 이용해 작성하였으며, 서버는 스프링 프레임워크를 이용해 자바로 구성하였습니다.</p>

			<c:if test="${empty authinfo}">
				<div class="form-group">
					<p>글 쓰기를 하려면 로그인 해주세요.</p>
				</div>
			</c:if>

			<c:if test="${!empty authinfo }">
				<div class="form-group">
					<p>
						<strong>${authinfo.name}</strong> 님. 환영합니다
					</p>
				</div>
			</c:if>

			<img src="<spring:url value='/resources/img/main1.jpg'/>"
				width="1000" height="500" border="0">


		</div>

	</div>




</body>
</html>