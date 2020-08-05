<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>

<head>

<!-- 스타일시트 참조  -->
<title>로그인</title>
<jsp:include page="../layout.jsp"/>
</head>

<body>


 <!-- 로긴폼 -->

 <div class="container">
  <div class="col-lg-4"></div>
  <div class="col-lg-4">

  <!-- 점보트론 -->

   <div class="jumbotron" style="padding-top: 20px;">

   <!-- 로그인 정보를 숨기면서 전송post -->

   
    <h3 style="text-align: center;"> 로그인화면 </h3>
    <form:form action="/wordpressme/login" modelAttribute="loginCommand" method="post">
    <div class="form-group">
     <input type="text" class="form-control" placeholder="이메일" name="email" maxlength="20">
     <form:errors path="email"></form:errors>
    </div>

       
    <div class="form-group">
     <input type="password" class="form-control" placeholder="비밀번호" name="password" maxlength="20">
     <form:errors path="password"></form:errors>
    </div>
    <input type="submit" class="btn btn-primary form-control" value="로그인">
   
    </form:form>
  </div>

 </div>

</div>

 

</body>

</html>





