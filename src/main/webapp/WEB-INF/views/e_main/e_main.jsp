<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
	<jsp:include page="../c_common/header_enterprise.jsp"></jsp:include>

	<section id="slide">
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
	</section>

	<section class="news">
	<h3 class="e_main_h3">IT 뉴스</h3>
	<div class="news1tab">
		<div class="news1">
			<c:forEach var="a" items="${news_pack }">
				<br><span>${a }<br></span>
			</c:forEach>
		</div>
	</div>

	<div class="news2tab">
		<div class="news2">
			<c:forEach var="b" items="${news_pack2 }">
				<br><span>${b }<br></span>
			</c:forEach>
		</div>
	</div>
	</section>
	<br>
	<br>
	<br>
	<br>
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
						src="../../../resources/e_main_img/cont04_icon01.png"></a><br>
					<span class="txt01">개발</span><br> <span class="num01">000,000명</span></li>

				<li class="icon2"><a href=''><img
						src="../../../resources/e_main_img/cont04_icon01.png"></a><br>
					<span class="txt02">디자인</span><br> <span class="num02">000,000명</span></li>

			</ul>
		</div>
	</div>

	<div id="Project" class="tabcontent">
		<div class="content">
			<h3>프로젝트</h3>
			<p>현재 등록된 프로젝트 : ${projectNum }개</p>
			<ul class="e_main_content_ul">

				<li class="icon4"><a href=''><img
						src="../../../resources/e_main_img/icon01_off.png"></a><br>
					<span class="txt04">개발</span><br> <span class="num04">000,000명</span>
				</li>

				<li class="icon5"><a href=''><img
						src="../../../resources/e_main_img/icon02_off.png"></a><br>
					<span class="txt05">엔지니어링</span><br> <span class="num05">000,000명</span>
				</li>

				<li class="icon6"><a href=''><img
						src="../../../resources/e_main_img/icon03_off.png"></a><br>
					<span class="txt06">디자인</span><br> <span class="num06">000,000명</span>
				</li>

				<li class="icon7"><a href=''><img
						src="../../../resources/e_main_img/icon04_off.png"></a><br>
					<span class="txt07">모바일</span><br> <span class="num07">000,000명</span>
				</li>

				<li class="icon8"><a href=''><img
						src="../../../resources/e_main_img/icon05_off.png"></a><br>
					<span class="txt08">기획</span><br> <span class="num08">000,000명</span>
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