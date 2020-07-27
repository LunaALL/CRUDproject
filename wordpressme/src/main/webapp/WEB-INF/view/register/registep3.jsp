<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->

<meta name="viewport" content="width=device-width" initial-scale="1">

<!-- 스타일시트 참조  -->

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<jsp:include page="../layout.jsp"/>

<title>회원가입창3</title>
<style>

</style>

</head>

<body>

 <!-- 네비게이션  -->

 

 <!-- 로긴폼 -->

 <div class="container">
 <div class="col-lg-4"></div>
  <div class="col-lg-4">


  <!-- 점보트론 -->
   <div class="jumbotron" style="padding-top: 20px;">
   
    <p style="text-align: center ">${memberRegiService.name}님 회원가입을 진심으로 환영합니다.</p> <br>
        <a href="/wordpressme/main">메인으로</a>
   
    
   
   </div>
  </div>

 </div>
 

 <div class="col-lg-4">
 </div>
 
 

 <!-- 애니매이션 담당 JQUERY -->

 <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
 <!-- 부트스트랩 JS  -->
 <script src="<c:url value="/resources/js/bootstrap.js" />"> </script>

</body>

</html>





