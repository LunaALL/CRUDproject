<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰 -->
<meta name="viewport" content="width=device-width" initial-scale="1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<!-- 스타일시트  -->

<title>회원가입창2</title>
<style>

</style>

</head>

<body>

 <!-- 네비게이션  -->

 <nav class="navbar navbar-defaults">
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
    <li><a href="/wordpressme/main">헬린이 메인</a></li>
    <li><a href="bbs.jsp">헬린이 게시판</a></li>
   </ul>

    

   <ul class="nav navbar-nav navbar-right">

    <li class="dropdown">

     <a href="#" class="dropdown-toggle"
      data-toggle="dropdown" role="button" aria-haspopup="true"
      aria-expanded="false">접속하기<span class="caret"></span></a>
     <ul class="dropdown-menu"><!--드랍다운 메뉴 선택 -->
      <li class="active"><a href="/wordpressme/login">로그인하기</a></li> <!-- 페이지 선택. -->
      <li><a href="/wordpressme/register/registep1">회원가입</a></li>

      

     </ul>

    </li>

   </ul>

  </div> 

 </nav>



 <div class="container">
 <div class="col-lg-4"></div>
  <div class="col-lg-4">

  <!-- 점보트론 -->
   <div class="jumbotron" style="padding-top: 20px;">
   <h3 style="text-align:center;"><spring:message code="member.register"/></h3>
   <form:form action="registep3" modelAttribute="memberRegiService" method="post">
   
   <div class="form-group">
   <input type="text" class="form-control" placeholder="이메일" name="email" maxlength="20">
   <form:errors path="email"/>
   </div>
   
   
   <div class="form-group">
   <input type="text" class="form-control" placeholder="닉네임" name="name" maxlength="20">
   <form:errors path="name"/>
   </div>
   
   <div class="form-group">
   <input type="password" class="form-control" placeholder="비밀번호" name="password" maxlength="20">
   <form:errors path="password"/>
   </div>
   
   <div class="form-group">
   <input type="password" class="form-control" placeholder="비밀번호확인" name="confirmpassword" maxlength="20">
   <form:errors path="confirmpassword"/>
   </div>
   <div class="form-group">
   <input type="submit" class="btn btn-primary form-control" value="회원가입">
   </div>
    	
   
   </form:form>
   </div>
  </div>

 </div>
 
 
 
 
 <div class="col-lg-4">
 </div>
 
 




 



 <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
 <!-- 부트스트랩 JS  -->
 <script src="<c:url value="/resources/js/bootstrap.js" />"> </script>
</body>
</html>





