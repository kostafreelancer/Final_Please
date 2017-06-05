<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../common/header.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../common/footer.css" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="/resources/e_insertproject_css/e_insertproject.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/c_using_css/service.css" type="text/css"
	media="screen" />
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="../common/header.js"></script>

</head>
<body>
	<c:choose>
		<c:when test="${identity.identity == 'freelancer' }">
			<%@include file="../c_common/header.jsp" %>
		</c:when>
		<c:when test="${identity.identity == 'enterprise' }">
			<%@include file="../c_common/header_enterprise.jsp" %>
		</c:when>
		<c:otherwise>
			<%@include file="../c_common/header.jsp" %>
		</c:otherwise>
	</c:choose>
	<div class="left_menu">
		<div class="left_menu_title">
			<h2>이용방법</h2>
		</div>
		<div class="left_menu_content">
			<ul class="left_menu_contents">
				<li><a href="service.jsp">서비스 소개</a></li>
				<li><a href="e_service.jsp">기업 이용방법</a></li>
				<li><a href="f_service.jsp">프리랜서 이용방법</a></li>
			</ul>
		</div>
	</div>


	<div id="conainer">
		<div id="nav">
			<div class="nav_txt">
				<p>
					<a href="/e_lan/index.php">Home</a> <span class="padd">&gt;</span>
					<span>이용방법</span> <span class="padd">&gt;</span> <span>프리랜서
						이용방법</span>
				</p>
			</div>
		</div>
		<div id="content">
			<div class="tit_box">
				<h2>프리랜서 이용방법</h2>
				<p class="tit_txt">
					기업 & 프리랜서가 함께하는 드림랜서<span>최적화된 매칭을 이뤄주는 드림랜서입니다.</span>
				</p>

				<br>
				<br>
				<br>
				<br>
				<br>



				<section style="background-color: #f7f7f7">
				<div class="p5-clientUsage-nav">
					<a href="#p5-clientUsage-step-1">
						<div class="p5-clientUsage-hover-one"></div>
					</a>
					<div>
						<img src="c_using_img/partners_process_one_none.png"> <img
							src="c_using_img/partners_intro_arrow.png">
					</div>
					<a href="#p5-clientUsage-step-2">
						<div class="p5-clientUsage-hover-two"></div>
					</a>
					<div>
						<img src="c_using_img/partners_process_two_none.png"> <img
							src="c_using_img/partners_intro_arrow.png">
					</div>
					<a href="#p5-clientUsage-step-3">
						<div class="p5-clientUsage-hover-three"></div>
					</a>
					<div>
						<img src="c_using_img/partners_process_three_none.png"> <img
							src="c_using_img/partners_intro_arrow.png">
					</div>
					
					<a href="#p5-clientUsage-step-4">
						<div class="p5-clientUsage-hover-four"></div>
					</a>
					
					<div>
						<img src="c_using_img/partners_process_four_none.png"> <img
							src="c_using_img/partners_intro_arrow.png">
					</div>
				
					
					<a href="#p5-clientUsage-step-5">
						<div class="p5-clientUsage-hover-five"></div>
					</a>
					<div>
						<img src="c_using_img/partners_process_five_none.png">
						<img src="c_using_img/partners_intro_arrow.png">
					</div>
					
					
					 
				
				</div>
				</section>

				<section class="p5-clientUsage-partition">
				<div id="p5-clientUsage-step-1" class="p5-clientUsage-step">
					<h5 class="p5-clientUsage-step-title">
						<img src="c_using_img/intro_one.png"> <span
							class="p5-clientUsage-step-title-text" style="margin-left: 23px;">프로필
							작성</span> <img src="c_using_img/slash_blue.png">
					</h5>

					<div class="p5-clientUsage-step-content">
						<div class="p5-clientUsage-step-mainText">
							자기소개, 포트폴리오, 보유 기술 등을 입력하여,<br>당신의 매력을 어필할 수 있는 프로필을 만들어주세요.
						</div>
						<div class="p5-clientUsage-step-subText">
							· 프로필이 매력적일수록 프로젝트를 진행할 기회가 많아집니다. <br> · 프로필 사진, 신원 인증, 연락처
							등록 등을 통해 프로필 완성도를 높일 수 있습니다.
						</div>
						<div class="p5-clientUsage-step-img">
							<!-- 여기에 우리 사진 들어가야함! -->
							<img src="c_using_img/intro_usecase_one.PNG">
						</div>
						<div class="p5-clientUsage-step-info">
							<div class="p5-clientUsage-step-info-line">- [프로필 정보 관리] >
								[파트너스 정보] 메뉴에서 프로필 관련 정보를 입력할 수 있습니다.</div>
							<div class="p5-clientUsage-step-info-line">- 대표 포트폴리오와 대표
								보유 기술을 활용하여 장점을 부각시킬 수 있습니다.</div>
							<div class="p5-clientUsage-step-info-line">- 연락처나 이메일 등을
								게재할 시 이용약관에 따라 서비스 이용에 제재를 받을 수 있습니다.</div>
						</div>
					</div>
				</div>
				</section>

				<section class="p5-clientUsage-partition">
				<div id="p5-clientUsage-step-2" class="p5-clientUsage-step">
					<h5 class="p5-clientUsage-step-title">
						<img src="c_using_img/intro_two.png"> <span
							class="p5-clientUsage-step-title-text" style="margin-left: 10px;">프로젝트
							비공개 지원</span> <img src="c_using_img/slash_blue.png">
					</h5>
					<div class="p5-clientUsage-step-content">
						<div class="p5-clientUsage-step-mainText">간단한 지원서 작성을 통해서,
							원하는 프로젝트에 지원할 수 있습니다.</div>
						<div class="p5-clientUsage-step-subText">
							· 합리적인 비용과 기간을 산정하여 지원해주세요. <br> · 모든 지원 정보는 관련 클라이언트 외에는 볼
							수 없습니다.
						</div>
						<div class="p5-clientUsage-step-img">
							<!-- 여기에 우리 사진 들어가야함! -->
							<img src="c_using_img/intro_usecase_one.PNG">
						</div>
						<div class="p5-clientUsage-step-info">
							<div class="p5-clientUsage-step-info-line">- 프로젝트의 상세페이지 우측
								상단의 [프로젝트 지원하기] 버튼을 통해, 프로젝트에 지원할 수 있습니다.</div>
							<div class="p5-clientUsage-step-info-line">- 프로젝트 견적은 미팅 시에
								변경될 수 있습니다.</div>
							<div class="p5-clientUsage-step-info-line">- 관련 프로젝트 경험을
								구체적으로 언급하면, 클라이언트의 선택을 받을 확률이 높아집니다.</div>
						</div>
					</div>
				</div>
				</section>

				<section class="p5-clientUsage-partition">
				<div id="p5-clientUsage-step-3" class="p5-clientUsage-step">
					<h5 class="p5-clientUsage-step-title">
						<img src="c_using_img/intro_three.png"> <span
							class="p5-clientUsage-step-title-text" style="margin-left: 10px;">미팅
							및 계약</span> <img src="c_using_img/slash_blue.png">
					</h5>
					<div class="p5-clientUsage-step-content">
						<div class="p5-clientUsage-step-mainText">
							클라이언트가 미팅을 신청한 지원자에게는, 위시켓 팀이 개별적으로 연락을 드립니다. <br> 위시켓 팀에서
							미팅 주선에서 계약까지 전 과정을 도와드립니다.
						</div>
						<div class="p5-clientUsage-step-subText">
							· 미팅을 통해 프로젝트 내용을 파악하고, 본인의 장점을 어필할 수 있습니다. <br> · 에스크로 형태의
							대금 보호 시스템을 통한 안전한 계약
						</div>
						<div class="p5-clientUsage-step-img">
							<!-- 여기에 우리 사진 들어가야함! -->
							<img src="c_using_img/intro_usecase_one.PNG">
						</div>
						<div class="p5-clientUsage-step-info">
							<div class="p5-clientUsage-step-info-line">- 미팅은 온라인
								미팅(skype, 카카오톡 등) / 오프라인 대면 미팅이 가능합니다.</div>
							<div class="p5-clientUsage-step-info-line">- 계약서 작성, 비용처리 등
								부가적인 작업은 위시켓 팀에서 진행합니다.</div>
							<div class="p5-clientUsage-step-info-line">- 에스크로 형태로 계약하게
								되며, 단위에 따라 대금 분할 지급도 가능합니다.</div>
						</div>
					</div>
				</div>
				</section>

				<section class="p5-clientUsage-partition">
				<div id="p5-clientUsage-step-4" class="p5-clientUsage-step">
					<h5 class="p5-clientUsage-step-title">
						<img src="c_using_img/intro_four.png"> <span
							class="p5-clientUsage-step-title-text" style="margin-left: 10px;">프로젝트
							진행</span> <img src="c_using_img/slash_blue.png">
					</h5>
					<div class="p5-clientUsage-step-content">
						<div class="p5-clientUsage-step-mainText">프로젝트 진행 중에도 위시켓이
							함께 합니다.</div>
						<div class="p5-clientUsage-step-subText">
							·
							<대금 보호 시스템>을 통해서 프로젝트 기간 동안 프로젝트 대금이 안전하게 보호됩니다. <br>
							· 프로젝트 진행 중에도 위시켓 팀이 커뮤니케이션을 함께합니다. <br>
							· 분쟁 발생 시, 1억 원 이하 내용에 대하여 중재비용을 전액 지원합니다. 
						</div>
						<div class="p5-clientUsage-step-img">
							<!-- 여기에 우리 사진 들어가야함! -->
							<img src="c_using_img/intro_usecase_one.PNG">
						</div>
						<div class="p5-clientUsage-step-info">
							<div class="p5-clientUsage-step-info-line">- 클라이언트의 선입금이
								확인되는 순간, 프로젝트를 시작하시면 됩니다.</div>
							<div class="p5-clientUsage-step-info-line">- 보호 중인 프로젝트 대금은
								프로젝트의 완료 시점에 클라이언트의 승인 후에 파트너에게 지급됩니다.</div>
							<div class="p5-clientUsage-step-info-line">
								- 위시켓 팀이 프로젝트 진행상에서 발생하는 어려움들을 도와드리며, 분쟁 발생 시, 대한상사중재원을 <br>
								<span style="margin-left: 9px;"></span> 통해 분쟁을 해결해드립니다.
							</div>
						</div>
					</div>
				</div>
				</section>

				<section class="p5-clientUsage-partition last-child-ie7">
				<div id="p5-clientUsage-step-5" class="p5-clientUsage-step">
					<h5 class="p5-clientUsage-step-title">
						<img src="c_using_img/intro_five.png"> <span
							class="p5-clientUsage-step-title-text" style="margin-left: 11px;">프로젝트
							완료</span> <img src="c_using_img/slash_blue.png">
					</h5>
					<div class="p5-clientUsage-step-content">
						<div class="p5-clientUsage-step-mainText">클라이언트와 파트너의 승인 후에
							프로젝트가 완료되며, 상호 간의 만족도 평가를 합니다.</div>
						<div class="p5-clientUsage-step-subText">
							· 프로젝트 완료 승인 후, 24시간 내에 대금을 입금 받을 수 있습니다. <br> · 클라이언트에게 받은
							좋은 평가는 다음 프로젝트 수주에 큰 도움이 됩니다.
						</div>
						<div class="p5-clientUsage-step-img">
							<!-- 여기에 우리 사진 들어가야함! -->
							<img src="c_using_img/intro_usecase_one.PNG">
						</div>
						<div class="p5-clientUsage-step-info">
							<div class="p5-clientUsage-step-info-line">- 프로젝트 완료 후에,
								위시켓 이용요금을 제외한 프로젝트 대금을 지급받습니다.</div>
							<div class="p5-clientUsage-step-info-line">- 계좌 등록은 [계정 설정]
								> [계좌 관리]에서 가능합니다.</div>
							<div class="p5-clientUsage-step-info-line">
								- 진행했던 프로젝트에 대해 5가지 항목으로 상호 평가를 진행할 수 있습니다. <br> <span
									style="margin-left: 9px;"></span> 평가는 <strong>[프로필 정보
									관리] > [프로젝트 히스토리]</strong> 에서 확인할 수 있습니다.
							</div>
						</div>
					</div>
				</div>
				</section>
			</div>
		</div>


		<%@include file="../c_common/footer.jsp"%>
</body>
</html>