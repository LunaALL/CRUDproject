<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>

<head>

<title><spring:message code="member.register"></spring:message></title>
<style>
</style>
<jsp:include page="../layout.jsp" />
</head>


<body>

	<!-- 네비게이션  "navbar navbar-expand-sm"-->


	<!-- 로긴폼 -->

	<div class="container">

		<div class="col-lg-8">

			<!-- 점보트론 -->

			<div class="jumbotron" style="padding-top: 20px;">

				<!-- 로그인 정보를 숨기면서 전송post -->
				<h2 style="text-align: center;">
					<spring:message code="term" />
				</h2>

				<br> <br>


				<h3>1. 개인정보의 처리 목적</h3>
				<br> <br>

				<p>
					<개발자>(‘없음’이하 ‘개발자’) 은(는) 다음의 목적을 위하여 개인정보를 처리하고 있으며, 다음의 목적
					이외의 용도로는 이용하지 않습니다. - 고객 가입의사 확인, 고객에 대한 서비스 제공에 따른 본인 식별.인증, 회원자격
					유지.관리, 물품 또는 서비스 공급에 따른 금액 결제, 물품 또는 서비스의 공급.배송 등 
				</p>
				<br> <br>

				<h3>2. 개인정보의 처리 및 보유 기간</h3>
				<br>
				<p>
					①
					<개발자>(‘없음’이하 ‘개발자’) 은(는) 정보주체로부터 개인정보를 수집할 때 동의 받은 개인정보
					보유․이용기간 또는 법령에 따른 개인정보 보유․이용기간 내에서 개인정보를 처리․보유합니다. 
				</p>
				<br>
				<p>
					② 구체적인 개인정보 처리 및 보유 기간은 다음과 같습니다. <br> ☞ 아래 예시를 참고하여 개인정보
					처리업무와 개인정보 처리업무에 대한 보유기간 및 관련 법령, 근거 등을 기재합니다.<br> (예시)- 고객 가입
					및 관리 : 서비스 이용계약 또는 회원가입 해지시까지, 다만 채권․채무관계 잔존시에는 해당 채권․채무관계 정산시까지 <br>
					- 전자상거래에서의 계약․청약철회, 대금결제, 재화 등 공급기록 : 5년
				</p>

				<br> <br>

				<h3>
					3. 정보주체와 법정대리인의 권리·의무 및 그 행사방법 <br> 이용자는 개인정보주체로써 다음과 같은 권리를
					행사할 수 있습니다.
				</h3>

				<br>

				<p>① 정보주체는 개발자(‘없음’이하 ‘개발자') 에 대해 언제든지 다음 각 호의 개인정보 보호 관련 권리를
					행사할 수 있습니다.</p>
				<br>
				<p>1.개인정보 열람요구</p>
				<p>2.오류 등이 있을 경우 정정 요구</p>
				<p>3.삭제요구</p>
				<p>4.처리정지 요구</p>

				<br> <br>
				<p>.................... 중략</p>
				<br>

				<h3>8. 개인정보 처리방침 변경</h3>
				<br>
				<p>①이 개인정보처리방침은 시행일로부터 적용되며, 법령 및 방침에 따른 변경내용의 추가, 삭제 및 정정이 있는
					경우에는 변경사항의 시행 7일 전부터 공지사항을 통하여 고지할 것입니다.</p>




				<div class="custom-control custom-checkbox"
					style="text-align: center;">
					<form action="registep2" method="post">
						<p>
							<label class="custom-control-label" for="jb-checkbox">약관을
								동의합니다</label> <input type="checkbox" name="agree"
								class="custom-control-input" style="width: 17px; height: 17px;">
						</p>


						<input type="submit" class="btn btn-primary form-control"
							value="확인" style="margin: 10px;">
					</form>
				</div>




			</div>

		</div>

	</div>


</body>

</html>





