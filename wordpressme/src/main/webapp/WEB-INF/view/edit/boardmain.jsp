<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드 게시판 메인</title>
<jsp:include page="../layout.jsp" />
</head>
<body>
	<div class="container">
	<p> <span class=".text-primary">멤버 수 </span><span class="badge badge-primary">${allmemcount}</span>
    <span class=".text-primary">게시글 수  </span><span class="badge badge-primary">${allpage}</span></p>
	
	</div>
        
 
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">게시글
							번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
				</thead>
				<tbody>
					<c:forEach items="${boards}" var="board">
						<tr>
							<td>${board.bdID}</td>
							<td><a href="editview?bdID=${board.bdID}">
									${board.bdTitle } </a></td>
							<td>${board.userID}</td>
							<td><tf:time value="${board.bdDate}"
									pattern="yyyy년 MM월 dd일  HH:mm" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<a href="/wordpressme/write" class="btn btn_primary pull-right">글쓰기</a>
			
		</div>
		
	</div>

	<div class="but" style="text-align: center;">
		<ul class="btn-group pagination">
			<c:if test="${pageMaker.prev }">
				<li><a
					href='<c:url value="/edit/main?page=${pageMaker.startPage-1 }"/>'><i
						class="fa fa-chevron-left"></i></a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="pageNum">
				<li><a href='<c:url value="/edit/main?page=${pageNum }"/>'><i
						class="fa">${pageNum }</i></a></li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
				<li><a
					href='<c:url value="/edit/main?page=${pageMaker.endPage+1 }"/>'><i
						class="fa fa-chevron-right"></i></a></li>
			</c:if>
		</ul>
	</div>
	
	
	
	
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>





</body>
</html>