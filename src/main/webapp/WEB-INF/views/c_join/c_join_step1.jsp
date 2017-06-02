<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../../resources/c_join_css/join.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../../../resources/c_join_css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../c_common/header.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../c_common/footer.css" type="text/css" media="screen" />
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
</head>
<body>
<%-- <%@include file="../c_common/header.jsp" %> --%>



	<div id="conainer">
		<div id="nav">
			<div class="nav_txt">
				<p>
					<a href="/index.php">Home</a> <span class="padd">&gt;</span> <span>회원가입</span>
				</p>
			</div>
		</div>
		<div id="content">
			<div class="tit_box">
				<h2>회원가입</h2>
				<p class="tit_txt">
					성공적인 프로젝트를 원하시나요?<span>검증된 IT 인재가 대기중입니다.</span>
				</p>


			</div>
			<!-- //tit_box : e -->
			<ul class="step_cont01">
				<li class="step01"><span>Step01</span>회원안내</li>
				<li class="step02"><span>Step02</span>실명확인/약관동의</li>
				<li class="step03"><span>Step03</span>회원정보입력</li>
				<li class="step04"><span>Step04</span>가입완료</li>
			</ul>
			<div class="market">
				<p class="market_txt01">
					<span class="txt_or02">DreamLancer 1TO1</span>이 열어가는 IT전문가 세상!
				</p>
				<p class="market_txt03">
					<span class="txt_bu">가입</span>하실 회원종류를 <span class="txt_gr">선택</span>해주세요.
				</p>
			</div>
			<!-- market : e -->
			<div class="ct overf">
				<div class="elan_box01">
					<h3>DreamLancer 1TO1</h3>
					<p class="ac">
						재택/상주를 희망하는 프리랜서,<br /> 헤드헌팅을 희망하는 정규직 구직자
					</p>
					<ul>
						<li>
							<h4>일반회원 서비스</h4>
							<p>
								상주 프로젝트 참여<br /> 맞춤 추천 서비스<br /> 맞춤형 정규직 채용 지원<br /> IT 전문 정보
								제공<br /> 프로필 및 기술 홍보 공간 제공
							</p>
						</li>
						<li>
							<h4>정회원 서비스</h4>
							<p class="mb10">
								상주 프로젝트 무제한 참여<br /> 맞춤 추천 서비스<br /> 맞춤형 정규직 채용 지원<br /> IT
								전문 정보 제공 <br /> 프로필 및 기술 홍보 공간 제공<br /> 메인 배너 공간에 홍보할 기회 제공<br />
							</p>
							<p>
								<strong>* 재택 프로젝트 무한 입찰</strong><br /> <strong>* 1:1
									세무/노무 상담</strong>
							</p>
						</li>
					</ul>
					<div class="btn_box02">
						<a href="f_join_step2" class="btn_join01">개인회원</a>
					</div>
				</div>
				<!-- //elan_box : e -->
				<div class="elan_box01 elan_box02 elan_box_lef">
					<h3>바이어</h3>
					<p class="ac">프로젝트를 의뢰하실 개인, 팀, 기업</p>
					<ul>
						<li>
							<h4>바이어 서비스</h4>
							<p class="ac">
								인재검색 및 인재찜 서비스<br /> 맞춤형 구인/개발 의뢰<br /> 맞춤형 정규직 채용 의뢰<br />
								다양한 솔루션 정보 서비스<br /> 직원 재교육 지원 서비스<br /> IT 전문 정보 서비스<br />
							</p>
						</li>
					</ul>
					<div class="btn_box02 btn_box02_lef">
						<a href="e_join_step2" class="btn_join02">기업</a>
					</div>
				</div>
				<!-- //elan_box : e -->
			</div>
		</div>
		<!-- //content : e -->


		<form method="post" name="HiddenFrame" style="display: inline;">
			<!--form method="post" name="HiddenFrame" style="display:inline;" onSubmit="return false;"-->
			<input type="hidden" name="fm_type" value=""> <input
				type="hidden" name="fm_format" value=""> <input
				type="hidden" name="fm_join" value="">
		</form>
		<!-- footer02 : e -->
	</div>
	<!-- footer_wrap : e  -->
	</div>

<!-- //wrap : e -->
<%-- <%@include file="../c_common/footer.jsp" %> --%>
</body>
</html>