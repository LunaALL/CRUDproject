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


<title>회원가입창3</title>
<style>

</style>

</head>

<body>

 <!-- 네비게이션  -->

 <nav class="navbar navbar-default">
  <div class="navbar-header">
   <button type="button" class="navbar-toggle collapsed" 
    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
    aria-expaned="false">

     <span class="icon-bar"></span>

     <span class="icon-bar"></span>

     <span class="icon-bar"></span>

    </button>

    <a class="navbar-brand" href="main.jsp">헬린이 커뮤니티</a>

  </div>

  <div class="collapse navbar-collapse" id="#bs-example-navbar-collapse-1">

   <ul class="nav navbar-nav">
    <li><a href="main.jsp">헬린이 메인</a></li>
    <li><a href="bbs.jsp">헬린이 게시판</a></li>
   </ul>

    

   <ul class="nav navbar-nav navbar-right">

    <li class="dropdown">

     <a href="#" class="dropdown-toggle"
      data-toggle="dropdown" role="button" aria-haspopup="true"
      aria-expanded="false">접속하기<span class="caret"></span></a>
     <ul class="dropdown-menu"><!--드랍다운 메뉴 선택 -->
      <li class="active"><a href="/wordpressme/member/login">로그인하기</a></li> <!-- 페이지 선택. -->
      <li><a href="join.jsp">회원가입</a></li>

      

     </ul>

    </li>

   </ul>

  </div> 

 </nav>

 <!-- 로긴폼 -->

 <div class="container">
 <div class="col-lg-4"></div>
  <div class="col-lg-4">

  <!-- 점보트론 -->
   <div class="jumbotron" style="padding-top: 20px;">
   
    회원가입을 진심으로 환영합니다. 메인으로 가시겠습니까? 
    
   
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





