<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="../../../resources/e_main_css/slide.css">
<link rel="stylesheet" type="text/css" href="../../../resources/e_main_css/news.css">
<link rel="stylesheet" type="text/css" href="../../../resources/e_main_css/info.css">
<link rel="stylesheet" type="text/css" href="../../../resources/e_main_css/sponsor.css">

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js">
</script>

<script type="text/javascript" src="../../../resources/e_main_js/slide.js"></script>
<script type="text/javascript" src="../../../resources/e_main_js/news.js"></script>
<script type="text/javascript" src="../../../resources/e_main_js/info.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../c_common/header_enterprise.jsp"></jsp:include>

	<section id="slide">
	<div class="sp-slideshow">
		<div class="main_slide">
			<div class="slideshow_images">
				<a href="#" class="slide"><img src="../../../resources/e_main_img/company1.jpg"
					alt="" width="1911" height="432"></a> <a href="#" class="slide"><img
					src="../../../resources/e_main_img/company2.jpg" alt="" width="1911" height="432"></a>
				<a href="#" class="slide"><img src="../../../resources/e_main_img/company3.jpg"
					alt="" width="1911" height="432"></a>
			</div>
		</div>
	</section>

	<section class="news">
	<h3 class="e_main_h3">IT 뉴스</h3>
	<div class="news1tab">
		<div class="news1">
			<a
				href="http://news.naver.com/main/read.nhn?mode=LSD&amp;mid=shm&amp;sid1=105&amp;oid=293&amp;aid=0000019728">
				<img
				src="http://imgnews.naver.net/image/origin/293/2017/04/27/19728.jpg?type=nf136_90">
			</a> <a
				href="http://news.naver.com/main/read.nhn?mode=LSD&amp;mid=shm&amp;sid1=105&amp;oid=293&amp;aid=0000019728">
				<h4>"4차 산업혁명 시대, 일자리 줄고 빈부격차 심해질 것"</h4>
			</a> (사진=Pixabay)국민이 '4차 산업혁명'을 어떻게 받아들이고 있는지 조사한 결과가 나왔다. 사람들은 4차 산업혁명이
			가져올 일자리 문제와 부의 분배에 대해 부정적으로 평가했다. 국…
		</div>
	</div>

	<div class="news2tab">
		<div class="news2">
		<c:forEach var="a" items="${news_list }">
		
	 		<a href="${a.img }">
				<img src=${a.img }>
			 </a> 
			
			<a href="http://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=092&aid=0002115920">
				<h4>${a.getTitle() }</h4>
			</a> 
			
			${a.txt }
	
         </c:forEach>
			
			
					
			<!-- <a
				href="http://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=092&aid=0002115920">
				<img
				src="http://imgnews.naver.net/image/origin/092/2017/04/27/2115920.jpg?type=nf136_90">
			</a> <a
				href="http://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=092&aid=0002115920">
				<h4>삼성전자 "갤럭시S8 붉은 액정, 불량 아니다"</h4>
			</a> (지디넷코리아=이은정 기자)삼성전자는 27일 열린 1분기 실적 컨퍼런스 콜에서 갤럭시S8 시리즈의 붉은 액정 현상이 제품
			불량은 아니라고 밝혔다. 삼성전자는 “(갤럭시S8 시리즈의)… -->
		</div>
	</div>

	</section>

	<section id="info">
	<div class="tab">
		<button class="tablinks" onclick="openbtn(event, 'FreeLancer')">프리랜서</button>
		<button class="tablinks" onclick="openbtn(event, 'Project')">프로젝트</button>
	</div>

	<div id="FreeLancer" class="tabcontent">
		<div class="content">
			<h3>프리랜서</h3>
			<p>현재 활동 중인 프리랜서 : ${freelancerNum }명</p>

			<ul class="e_main_content_ul">

				<li class="icon1"><a href=''><img
						src="../../../resources/e_main_img/cont04_icon01.png"></a><br> <span
					class="txt01">개발</span><br> <span class="num01">000,000명</span></li>

				<li class="icon2"><a href=''><img
						src="../../../resources/e_main_img/cont04_icon01.png"></a><br> <span
					class="txt02">디자인</span><br> <span class="num02">000,000명</span></li>

			</ul>
		</div>
	</div>

	<div id="Project" class="tabcontent">
		<div class="content">
			<h3>프로젝트</h3>
			<p>현재 등록된 프로젝트 : ${projectNum }개</p>
			<ul class="e_main_content_ul">

				<li class="icon4"><a href=''><img
						src="../../../resources/e_main_img/icon01_off.png"></a><br> <span
					class="txt04">개발</span><br> <span class="num04">000,000명</span>
				</li>

				<li class="icon5"><a href=''><img
						src="../../../resources/e_main_img/icon02_off.png"></a><br> <span
					class="txt05">엔지니어링</span><br> <span class="num05">000,000명</span>
				</li>

				<li class="icon6"><a href=''><img
						src="../../../resources/e_main_img/icon03_off.png"></a><br> <span
					class="txt06">디자인</span><br> <span class="num06">000,000명</span>
				</li>

				<li class="icon7"><a href=''><img
						src="../../../resources/e_main_img/icon04_off.png"></a><br> <span
					class="txt07">모바일</span><br> <span class="num07">000,000명</span>
				</li>

				<li class="icon8"><a href=''><img
						src="../../../resources/e_main_img/icon05_off.png"></a><br> <span
					class="txt08">기획</span><br> <span class="num08">000,000명</span>
				</li>

			</ul>
		</div>
	</div>
	</section>
	<section id="sponsor">
	<h3>주요 고객사</h3>
	<img src="../../../resources/e_main_img/company_img.png"> </section>

	<jsp:include page="../c_common/footer.jsp"></jsp:include>
</body>
</html>