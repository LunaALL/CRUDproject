<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../layout.jsp"/>

<meta charset="UTF-8">

<title></title>
</head>
<body>
 <div class="jumbotron" style="padding-top: 20px;">
   <h3 style="text-align:center;"><spring:message code="member.welcome"/></h3>
   
   
   
   	<c:if test="${empty authinfo}">
   	
   	<div class="form-group" style="text-align: center;">   
   	<p> 글 쓰기를 하려면 로그인 해주세요.</p>
    </div>
	</c:if>
	
	
	<c:if test="${!empty authinfo }">
	<div class="form-group" style="text-align: center;">   
   	<p> <strong>${authinfo.name}</strong> 님. 환영합니다</p>
    </div>
	</c:if>
   
   
   
   
   
   </div>




</body>
</html>