<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../layout.jsp"/>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<div class="container">
			<div class="row">
			<form:form action="write/update" method="post" modelAttribute="updatecommand">
				<table class="table table-striped" style="text-align: center; border:1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color:#eeeeee; text-align:center;"> 게시판 수정 양식 </th>
						</tr>
					</thead>
					<tbody>
						<tr>	
							<td><input type="text" class="form-control" placeholder="글 제목" name="bdTitle" maxlength="50" value="${board.bdTitle}"></td>
						</tr>
						<tr>
							<td><textarea type="text" class="form-control" placeholder="글 내용" name="bdContent" maxlength="2048"  style="height:350px;" >
							
							${board.bdContent}</textarea></td>
						</tr>
					</tbody>
					<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
				</table>
				</form:form>

			</div>		
		</div>	

</body>
</html>