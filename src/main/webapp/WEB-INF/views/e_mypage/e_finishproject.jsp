<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../common/header.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../common/footer.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/resources/c_projectlist_css/complete.css"
	type="text/css" media="screen" />
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>

</head>
<body>
	<%@include file="../c_common/header.jsp" %>
	<!-- //header_wrap : e -->
	<div id="conainer">
		<div id="nav">   
			<div class="nav_txt">
				<p>
					<a href="/e_lan/index.php">Home</a> <span class="padd">&gt;</span>
					<span>프로젝트 등록</span>
				</p>
			</div>
		</div>
		<div id="content">
			<div class="tit_box">
				<h2>프로젝트 등록</h2>
				<p class="tit_txt">
					성공적인 프로젝트를 원하시나요?<span>검증된 IT 인재가 대기중입니다.</span>
				</p>



				<div class="market">
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<p class="market_txt01">프로젝트 수정이 완료되었습니다!</p>
					<br>
					<p class="market_txt02">마이페이지에서 수정, 확인 가능합니다.</p>
					<p class="market_txt03">
						최적화된 인재검색 시스템을 통한 서비스로 귀사에 맞춤형 인재를 추천함으로써<br /> 성공적인 프로젝트를 약속합니다.
					</p>
				</div>
				<!-- //market : e -->
				<div class="btn_box">
				<a href="/c_projectlist/c_projectlist" class="btn btn-lg btn-default js-disable-on-click"
						autocomplete="off" data-loading-text="저장 중" name="save_for_later"
						 type="submit">프로젝트 목록</a>
				<a href="/e_mypage/e_info" class="btn btn-lg btn-client js-disable-on-click btn-submit"
						autocomplete="off" data-loading-text="제출 중" name="post_a_job"
						 type="submit">마이페이지</a><br>
					<br>
					<br>
					<br>
					<br>
				</div>

				<%@include file="../c_common/footer.jsp"%>
</body>
</html>