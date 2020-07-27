<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<jsp:include page="../layout.jsp"/>

</head>
	<body>
		<div class="container">
			<div class="row">
				<table class="table table-striped" style="text-align: center; border:1px solid #dddddd">
					<thead>
						<tr>
							<th style="background-color: #eeeeee; text-align: center;">번호 </th>
							<th style="background-color: #eeeeee; text-align: center;">제목 </th>
							<th style="background-color: #eeeeee; text-align: center;">작성자 </th>
							<th style="background-color: #eeeeee; text-align: center;">작성일 </th>
						</tr>
					</thead>
					<tbody>
						<tr>	
							<td>1</td>
							<td>안녕하세요</td>
							<td>홍길동</td>
							<td>2017-05-04</td>
					</tbody>
				</table>
				<div class="align-self-end ml-auto">
    			<a href="write" class="btn btn-primary">글쓰기</a>
   				</div>

		</div>		
	</div>	
	</body>
</html>