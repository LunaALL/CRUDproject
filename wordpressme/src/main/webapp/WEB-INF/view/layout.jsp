<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->

<meta name="viewport" content="width=device-width" initial-scale="1">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<!-- 스타일시트 참조  -->

<title><spring:message code= "member.register" ></spring:message></title>
<style>


</style>
</head>
<body>


 <nav class="navbar navbar-default" >
  <div class="navbar-header">
  
   <button type="button" class="navbar-toggle collapsed" 
    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
    aria-expaned="false">
    
    
     <span class="icon-bar"></span>
     
     <span class="icon-bar"></span>	
     
     <span class="icon-bar"></span>
     

    </button>

    <a class="navbar-brand" href="main"><spring:message code="bar1" ></spring:message></a>

  </div>

  <div class="collapse navbar-collapse" id="#bs-example-navbar-collapse-1">

   <ul class="nav navbar-nav">
    <li><a href="/wordpressme/main">헬린이 메인</a></li>
    <li><a href="/wordpressme/edit/main">헬린이 게시판</a></li>
   </ul>

    
    <%
    
    if(session.getAttribute("authinfo")==null){
    	
    %>
   <ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
     <a href="#" class="dropdown-toggle"
      data-toggle="dropdown" role="button" aria-haspopup="true"
      aria-expanded="false">접속하기<span class="caret"></span></a>
     <ul class="dropdown-menu">
      <li class="active"><a href="/wordpressme/login">로그인</a></li> <!--  선택된 페이지를 의미함. -->
      <li><a href="/wordpressme/register/registep1">회원가입</a></li>

     

     </ul>
    </li>
   </ul>
    <% } else {  %>
    
    <ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
     <a href="#" class="dropdown-toggle"
      data-toggle="dropdown" role="button" aria-haspopup="true"
      aria-expanded="false">접속하기<span class="caret"></span></a>
     <ul class="dropdown-menu">
      <li> <a href="/wordpressme/logout">로그아웃</a></li>
      <li> <a href="/wordpressme/member/change">비밀번호변경</a></li>
     

     </ul>
    </li>
   </ul>
   
   <% } %>
  </div> 
 </nav>

 <!-- 로긴폼 -->



 

 

 <!-- 애니매이션 담당 JQUERY -->

 <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
 <!-- 부트스트랩 JS  -->
 <script src="<c:url value="/resources/js/bootstrap.js" />"> </script>

</body>

</html>





