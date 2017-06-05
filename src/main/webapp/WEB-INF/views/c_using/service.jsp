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
					<span>이용방법</span> <span class="padd">&gt;</span> <span>서비스
						소개</span>
				</p>
			</div>
		</div>
		<div id="content">
			<div class="tit_box">
				<h2>서비스 소개</h2>
				<p class="tit_txt">
					기업 & 프리랜서가 함께하는 드림랜서<span>최적화된 매칭을 이뤄주는 드림랜서입니다.</span>
				</p>

				<br>
				<br>
				<br>
				<br>
				<br>


				<section class="p5-serviceIntroduction-partition">
				<h5
					class="p5-serviceIntroduction-title service-Introduction-first-title">
					<img class="p5-serviceIntroduction-title-img"
						src="c_using_img/bookmark.png">드림랜서이란?
				</h5>
				<div class="p5-serviceIntroduction-breif-info">
					<div class="p5-serviceIntroduction-breif-img">
						<img src="c_using_img/intro_service.PNG">
					</div>
					<div class="p5-serviceIntroduction-breif-text">
						<p>
							<b>드림랜서(DreamLancer)</b>은<br>기업의 프로젝트와 개발회사 & 프리랜서를<br>이어주는<b>온라인
								아웃소싱 플랫폼</b>입니다.
						</p>
					</div>
				</div>
				</section>

				<section class="p5-serviceIntroduction-partition">
				<h5 class="p5-serviceIntroduction-title">
					<img class="p5-serviceIntroduction-title-img"
						src="c_using_img/bookmark.png">왜 드림랜서인가?
				</h5>
				<div class="p5-serviceIntroduction-list">
					<div class="p5-serviceIntroduction-list-component">
						<div class="p5-serviceIntroduction-list-text">
							<h5 class="p5-serviceIntroduction-list-title">
								빠르다<img class="p5-slash" src="c_using_img/slash_blue.png">
							</h5>
							<p>
								크라우딩 방식의 비공개 지원 시스템을 통해 빠른 지원자 모집이 가능합니다.<br>2시간내에 첫 지원자를
								만나볼 수 있고, 24시간 내에 평균 5명의 지원자가<br>발생합니다.
							</p>
						</div>
						<div class="p5-serviceIntroduction-list-img">
							<img src="c_using_img/intro_good_one.png">
						</div>
					</div>
					<div class="p5-serviceIntroduction-list-component">
						<div class="p5-serviceIntroduction-list-text">
							<h5 class="p5-serviceIntroduction-list-title">
								믿을 수 있다<img class="p5-slash" src="c_using_img/slash_blue.png">
							</h5>
							<p>
								지원자들의 견적, 프로필과 포트폴리오를 한 눈에 비교할 수 있습니다<br>지원자들이 실제로 진행했던
								프로젝트 기록과 다른 클라이언트들이 남긴<br>평가를 확인 할 수 있습니다.
							</p>
						</div>
						<div class="p5-serviceIntroduction-list-img">
							<img src="c_using_img/intro_good_two.png">
						</div>
					</div>
					<div class="p5-serviceIntroduction-list-component">
						<div class="p5-serviceIntroduction-list-text">
							<h5 class="p5-serviceIntroduction-list-title">
								안전하다<img class="p5-slash" src="c_using_img/slash_blue.png">
							</h5>
							<p>
								에스크로 형태의 대금보호 시스템을 통해 프로젝트 대금을 안전하게<br>보호합니다. 프로젝트 진행 중
								작업자와의 커뮤니케이션을 도우며,<br>대한상사중재원을 통해 분쟁을 해결해 드립니다.
							</p>
						</div>
						<div class="p5-serviceIntroduction-list-img">
							<img src="c_using_img/intro_good_three.png">
						</div>
					</div>
				</div>
				</section>

				<section class="p5-serviceIntroduction-partition">
				<h5 class="p5-serviceIntroduction-title">
					<img class="p5-serviceIntroduction-title-img"
						src="c_using_img/bookmark.png">드림랜서 이용사례
				</h5>
				<div class="p5-serviceIntroduction-list">
					<div class="p5-serviceIntroduction-list-component-right">
						<div class="p5-serviceIntroduction-list-img">
							<img src="c_using_img/intro_usecase_one.PNG">
						</div>
						<div class="p5-serviceIntroduction-list-text">
							<div class="p5-serviceIntroduction-list-text-wrapper">
								<h5 class="p5-serviceIntroduction-list-title">"프로젝트 등록 후
									6시간만에 11명의 지원자가! 그 속도에 놀랐다."</h5>
								<p>
									- 스타트업 전문 미디어<b> beSUCCESS </b>남광식 에디터
								</p>
							</div>
						</div>
					</div>
					<div class="p5-serviceIntroduction-list-component-right">
						<div class="p5-serviceIntroduction-list-img">
							<img src="c_using_img/intro_usecase_two.PNG">
						</div>
						<div class="p5-serviceIntroduction-list-text">
							<div class="p5-serviceIntroduction-list-text-wrapper">
								<h5 class="p5-serviceIntroduction-list-title">
									"드림랜서의 회계관리 서비스가 정말 만족스러웠다.<br>미팅주선도 큰 도움이 되었다."
								</h5>
								<p>
									- 컨텐츠 크리에이터 그룹<b> 써클커넥션 </b>전해강 대표
								</p>
							</div>
						</div>
					</div>
					<div class="p5-serviceIntroduction-list-component-right">
						<div class="p5-serviceIntroduction-list-img">
							<img src="c_using_img/intro_usecase_three.PNG">
						</div>
						<div class="p5-serviceIntroduction-list-text">
							<div class="p5-serviceIntroduction-list-text-wrapper">
								<h5 class="p5-serviceIntroduction-list-title">
									"지원자들을 한 눈에 비교할 수 있어 선택이 용이했다.<br>일정 조율 및 서류작업을 대행해줘 프로젝트가
									수월하게 진행됐다."
								</h5>
								<p>
									- 신개념 맞춤 여행사<b> 마이이리얼트립 </b>박성준 대표
								</p>
							</div>
						</div>
					</div>
				</div>
				</section>


			</div>
		</div>
	</div>



	<%@include file="../c_common/footer.jsp"%>
</body>
</html>