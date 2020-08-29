<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		<div class="col-lg-8">
			<div class="jumbotron" style="padding-top: 20px; text-align: center;">

				<p>
					<spring:message code="change.complete" />
				</p>
				<p>다시 로그인해주세요.</p>
				<%
					session.invalidate();
				%>
				<a href="/wordpressme/main">메인으로.</a>

			</div>


		</div>
	</div>


</body>
</html>