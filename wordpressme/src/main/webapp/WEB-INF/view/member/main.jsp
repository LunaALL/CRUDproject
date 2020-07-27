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
<c:if test="${empty authinfo}">
<p> 환영합니다 . 글 쓰기를 하려면 로그인 해주세요.</p>
<p>

</p>


</c:if>


<c:if test="${!empty authinfo }">
<p> ${authinfo.name}님. 환영합니다</p>
<p>

</p>


</c:if>



</body>
</html>