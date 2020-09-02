<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재확인</title>
</head>
<jsp:include page="../layout.jsp" />

<body>

<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">

			<!-- 점보트론 -->

			<div class="jumbotron" style="padding-top: 20px;">

				<!-- 로그인 정보를 숨기면서 전송post -->


				<h3 style="text-align: center;">회원 탈퇴 신청 화면</h3>
				
				<form action="/wordpressme/deletemem" method="post">
					<div class="form-group">
					<p>비밀번호를 다시 입력해주세요. </p>
					</div>
					
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호 확인 "
							name="repwd" maxlength="20">
					</div>
					
					<p><input type="submit" class="btn btn-primary form-control"
						value="확인"> </p>

				
				</form>
				
			</div>

		</div>

	</div>


</body>
</html>