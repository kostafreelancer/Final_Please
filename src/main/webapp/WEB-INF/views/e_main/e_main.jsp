<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico">

<link rel="stylesheet" type="text/css"
	href="../../../resources/e_main_css/slide.css">
<link rel="stylesheet" type="text/css"
	href="../../../resources/e_main_css/news.css">
<link rel="stylesheet" type="text/css"
	href="../../../resources/e_main_css/info.css">
<link rel="stylesheet" type="text/css"
	href="../../../resources/e_main_css/sponsor.css">

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js">
	
</script>

<script type="text/javascript"
	src="../../../resources/e_main_js/slide.js"></script>
<script type="text/javascript"
	src="../../../resources/e_main_js/news.js"></script>
<script type="text/javascript"
	src="../../../resources/e_main_js/info.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../c_common/header.jsp" %>

	
	<!-- <section id="slide">
	<div class="sp-slideshow">
		 <div class="main_slide">
			<div class="slideshow_images">
				<a href="#" class="slide"><img
					src="../../../resources/e_main_img/company1.jpg" alt=""
					width="1911" height="432"></a> <a href="#" class="slide"><img
					src="../../../resources/e_main_img/company2.jpg" alt=""
					width="1911" height="432"></a> <a href="#" class="slide"><img
					src="../../../resources/e_main_img/company3.jpg" alt=""
					width="1911" height="432"></a>
			</div>
		</div> 
	</section> -->
	<div class="inbox">
		<div class="oneTop-middle">
			<dl class="title">
				<dt>
					<span>신속한</span>
				맞춤 매칭
				</dt>
				<dd>웹/앱,프로그램,개발,디자인(끄앙)</dd>
			</dl>
			<div class="projregist">
				<a href="/e_insertproject/e_insertproject" class="btn">프로젝트 등록하기</a>
			</div>
		</div>
		<div class="onesTop-bottom">
			<ul class="sort-item-wrap">
				<li class="sort-item">
					<div class="sort_itemd1">
						<div class="tit">등록된 프로젝트</div>
						<div class="data">${allproject}</div>
					</div>
				</li>
				<li class="sort-item">
					<div class="sort_itemd">
						<div class="tit">등록된 프리렌서</div>
						<div class="data">${allfreelancer}</div>
					</div>
				</li>
			</ul>
		</div>
	</div>	
	<div class="onesbg"></div>

	
	<div class="video">
		<video id="landingVideo" class="videobcg" loop="loop" autoplay="autoplay" poster="http://freemoa.smilecast.co.kr/Image/main-view.png" style="width:100%">
			<source src="/resources/e_main_img/main_bg.mp4" type="video/mp4">
<!-- 			<source src="http://freemoa.smilecast.co.kr/145740747649209.mp4" type="video/mp4"> -->
			<!-- <source src="/public/images/movie/main-view.webm" type="video/webm">
			<source src="/public/images/movie/main-view.ogg" type="video/ogg"> -->
			<!--[if lte IE 9]>											
				<img src="/public/images/movie/main-view.jpg" width="100%" height="684" alt="이미지" />						
			<![endif]-->					
		</video>
	</div>
	<section class="news">
	<div class="newstabs">
		<div class="news1tab">
			<div class="news1">
			<div class="landing-inner">
			<h3 class="e_main_h3">IT 뉴스</h3>
				<c:forEach var="a" items="${news_pack }">
					<span class="newscon">${a }<br></span>
				</c:forEach>
				<c:forEach var="b" items="${news_pack2 }">
					<span class="newscon">${b }<br></span>
				</c:forEach>
			</div> 
				</div>
			</div>
		</div>
	
		<%-- <div class="news2tab">
			<div class="news2">
				<c:forEach var="b" items="${news_pack2 }">
					<br><span class="newscon">${b }<br></span>
				</c:forEach>
			</div>
		</div>
	</div>  --%>
	
	</section>
	
	
	
	<section id="info">
	<div class="tab">
		<button class="tablinks active" onclick="openbtn(event, 'FreeLancer')">프리랜서</button>
		<button class="tablinks" onclick="openbtn(event, 'Project')">프로젝트</button>
	</div>

	<div id="FreeLancer" class="tabcontent">
		<div class="content">
			<h3 class="now">현재 활동 중인 프리랜서 : ${freelancerNum }명</h3>

			<div class="card">
				<ul class="e_main_content_ul">
	
					<li class="icon1"><a href=''><img
							class="img22" src="../../../resources/e_main_img/cont04_icon01.png"></a><br>
						<p class="txt01">개발</span><p class="num01">${e_developer }명</span></li>
	
					<li class="icon2"><a href=''><img
							class="img22" src="../../../resources/e_main_img/cont04_icon01.png"></a><br>
						<p class="txt01">디자인</span><p class="num01">${e_designer }명</p></li>
					<li class="icon2"><a href=''><img
							class="img22" src="../../../resources/e_main_img/cont04_icon01.png"></a><br>
						<p class="txt01">기획</span><p class="num01">${e_planner }명</p></li>
					
				</ul>
			</div>
		</div>
	</div>

	<div id="Project" class="tabcontent">
		<div class="content">
			<h3 class="now">현재 등록된 프로젝트 : ${projectNum }개</h3>
			
				<div class="card">
				
					<ul class="e_main_content_ul">
		
						<li class="icon1"><a href=''><img
								class="img22" src="../../../resources/e_main_img/icon01_off.png"></a><br>
							<p class="txt01">개발</p> <p class="num01">${development }개</p>
						</li>
						<li class="icon1"><a href=''><img
								class="img22" src="../../../resources/e_main_img/icon03_off.png"></a><br>
							<p class="txt01">디자인</p><p class="num01">${design }개</p>
						</li>
		
						<li class="icon1"><a href=''><img
								class="img22" src="../../../resources/e_main_img/icon05_off.png"></a><br>
							<p class="txt01">기획</p><p class="num01">${planning }개</p>
						</li>
						
					</ul>
				</div>
			
		</div>
	</div>
	</section>
	
	<section class="landing-process">
	<div class="landing-process-inner">
	<h4>드림랜서 프로세스</h4>
	<img src="/resources/e_main_img/process.png"/>
	<div class="process">
	<span class="step">프로젝트 등록</span> 
	<span class="step">지원자 비교,선택</span>
	 <span class="step">미팅 및 계약</span> 
	 <span class="step">프로젝트 진행</span> 
	 <span class="step">프로젝트 완료</span>
	 </div>
	 </div>
	 </section>
	 
	 <section class="landing-popped">
	 <div class="text-center">지금 당신의 프로젝트를 등록해보세요. 
	 <a class="btn btn-md btn-wishket" href="/e_insertproject/e_insertproject">프로젝트 등록하기</a>
	 </div>
	 </section>
	
	<section id="sponsor">
	<h3>드림랜서 고객사</h3>
	<img src="../../../resources/e_main_img/company_img.png"> </section>

	<%@include file="../c_common/footer.jsp" %>
</body>
</html>