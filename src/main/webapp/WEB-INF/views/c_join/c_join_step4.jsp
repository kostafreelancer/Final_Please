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
<!-- <body onload="member_check();"> -->

<%@include file="../c_common/header.jsp" %>
    <div  id="conainer">
    	<div id="nav">
        	<div class="nav_txt">
            	<p>
                	<a href="/index.php">Home</a>
                    <span class="padd">&gt;</span> 
                	<span>회원가입</span>
            	</p>
            </div>
        </div>
        <div id="content">
        	<div class="tit_box">
            	<h2>회원가입</h2>
                <p class="tit_txt">성공적인 프로젝트를 원하시나요?<span>검증된 IT 인재가 대기중입니다.</span></p>


			</div>
			<!-- //tit_box : e -->
			<ul class="step_cont04">
				<li class="step01"><span>Step01</span>회원안내</li>
				<li class="step02"><span>Step02</span>실명확인/약관동의</li>
				<li class="step03"><span>Step03</span>회원정보입력</li>
				<li class="step04"><span>Step04</span>가입완료</li>
			</ul>
			<div class="completion">
				<p class="comple01">드림랜서 회원이 되었습니다.</p>
				<p class="comple02">
					<span class="color_or">반갑습니다!</span> IT프로젝트 중계분야 <span
						class="color_or">으뜸</span>! 프로젝트 / 프리랜서 등록수 <span class="color_or">최고!</span>
				</p>
				<p class="comple03 color_or">회원이 되신것을 진심으로 환영합니다.</p>
			</div>
			<!-- //completion : e -->
			<div class="btn_box">
				<a href="../c_login/login" class="btn_check04"><span> Go Login</a>
			</div>
		</div>
		<!-- //content : e -->


<!-- //wrap : e -->
<%@include file="../c_common/footer.jsp" %>
</body>
</html>