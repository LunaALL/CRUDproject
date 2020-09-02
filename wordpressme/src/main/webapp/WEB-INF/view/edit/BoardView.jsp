<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<style>
pre {
background-color: #FFFFFF;
font-size:14px;
}

</style>
<meta charset="UTF-8">
<title>게시판 보기</title>
</head>
<body>
<jsp:include page="../layout.jsp"/>
</head>
	<body>
		<div class="container">
			<div class="row">
				<table class="table table-striped" style="text-align: center; border:1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="3" style="background-color:#eeeeee; text-align:center;">게시판 글 보기 </th>
						</tr>
					</thead>
					<tbody>
						<tr>	
							<td style="width:20%;">글 제목</td>
							<td colspan="2">${board.bdTitle}</td>
						</tr>
						
						<tr>	
							<td>닉네임</td>
							<td colspan="2">${board.userID}</td>
						</tr>
						
						
						<tr>	
							<td>작성일</td>
							<td colspan="2"><tf:time value="${board.bdDate}" pattern="yyyy년 MM월 dd일  HH:mm"/></td>
						</tr>
						
									
						<tr>	
							<td>내용</td>
							<td colspan="2" style="min-height:200px; text-align:left;">
							<pre>${board.bdContent} </pre>
							</td>
						</tr>			
					</tbody>
					
				</table>
				<a href="/wordpressme/edit/main" class="btn btn-primary">목록</a>
				<a href="update?bdID=${board.bdID}" class="btn btn-primary">수정</a>
				<a href="delete?bdID=${board.bdID}&name=${board.userID}" class="btn btn-primary">삭제</a>

			</div>		
		</div>	
	</body>
</html>
