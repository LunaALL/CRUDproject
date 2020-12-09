<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록하기</title>
<jsp:include page="../layout.jsp" />

</head>
<body>
	<div class="container">
		<div class="row">
			<form:form action="write" method="post" modelAttribute="writecommand">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판
								글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="bdTitle" maxlength="50"> <form:errors
									path="bdTitle" /></td>
						</tr>
						<tr>
							<td><textarea type="text" class="form-control"
									placeholder="글 내용" name="bdContent" maxlength="2048"
									style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
					<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
				</table>
			</form:form>

		</div>
	</div>
</body>
</html>