<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../layout.jsp"/>

<title><spring:message code="edit.com"/></title>
</head>
<body>
<div class="container">
			<div class="row">
			<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color:#eeeeee; text-align:center;">게시글 번호</th>
						<th style="background-color:#eeeeee; text-align:center;">제목</th>
						<th style="background-color:#eeeeee; text-align:center;">작성자</th>
						<th style="background-color:#eeeeee; text-align:center;">작성일</th>
				</thead>
			<tbody>
				<c:forEach var="board" items="${boards}">
				<tr>
					<td>${board.bdID}</td>
					<td><a href="editview?bdID=${board.bdID-1}">${board.bdTitle} </a></td>
					<td>${board.userID}</td>
					<td><tf:time value="${board.bdDate}" pattern="yyyy년 MM월 dd일  HH:mm"/></td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
			
			<a href="/wordpressme/write" class="btn btn_primary pull-right">글쓰기</a>
			
				

		</div>		
	</div>	


</body>
</html>