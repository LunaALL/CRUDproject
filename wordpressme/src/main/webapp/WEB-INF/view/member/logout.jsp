<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃페이지</title>
<jsp:include page="../layout.jsp"/>

</head>
<body>

 <div class="container">
 	<div class="col-lg-4"></div>
  		<div class="col-lg-4">

  <!-- 점보트론 -->
   <div class="jumbotron" style="padding-top: 20px;">
 <%session.invalidate(); %>
    <p style="text-align: center ">로그아웃 완료~~~~~ </p> <br>
        <a href="/wordpressme/main">메인으로</a>
   
    
   
   </div>
  </div>
 </div>

</body>
</html>