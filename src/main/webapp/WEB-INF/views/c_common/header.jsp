<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/c_common_css/header.css" type="text/css" media="screen" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/resources/c_common_js/header.js"></script>
<script type="text/javascript" src="/resources/c_common_js/header_second.js"></script>

</head>
<body>
	<div class="header">
		<div class="header_top_menu">
			<div class="header_welcome_content">
				<span>${client.f_name}</span>
			</div>
			<ul class="header_top_menus">
				<li><img alt="center_img"
					src="/resources/c_common_img/header_center_icon.jpg"> <a
					href=${pageContext.request.contextPath}"/c_membercenter/member_centerMain">고객 센터</a></li>
				<li class="header_join"><img alt="join_img"
					src="/resources/c_common_img/header_join_icon.jpg"> <a
					href=${pageContext.request.contextPath}"/c_join/c_join_step1">회원가입</a></li>
				<li class="login_checking"><img alt="log_img"
					src="/resources/c_common_img/header_log_icon01.jpg"> <a
					href=${pageContext.request.contextPath}"/c_login/login">로그인</a></li>

				<li><img alt="home_img"
					src="/resources/c_common_img/header_home_icon01.jpg"> <a
					href=${pageContext.request.contextPath}"/f_main/f_main">홈</a></li>
			</ul>

		</div>
		<!--헤더 상단 메뉴 -->
		<div class="header_sns">
			<a href="https://www.facebook.com/produce101" target="_blank"
				class="header_btn_f">fa</a> <a href="https://www.twitter.com/mnetkr"
				target="_blank" class="header_btn_t">tw</a> <a
				href="https://www.instagram.com/taeyeon_ss/" target="_blank"
				class="header_btn_i">in</a>
		</div>
		<div class="clock">
			<div id="Date"></div>
			<ul>
				<li id="hours"></li>
				<li id="point">:</li>
				<li id="min"></li>
				<li id="point">:</li>
				<li id="sec"></li>
			</ul>
		</div>

		<div class="header_menu">
			<ul class="header_menus">
				<li><a href="/Matching_Project/c_projectlist/project_list.jsp">프로젝트
						목록</a></li>
				<!-- <li><a href="/Matching_Project/c_freelancerlist/f_list.jsp">프리랜서 목록</a></li> -->
				<li><a href="freelist.f_list">프리랜서 목록</a></li>

				<%-- 	<c:choose>
					<c:when test="${identity.identity == 'freelancer' }">
						<a href="showScheduleInfo.f_mypage?f_num=${client.f_num}">
					</c:when>
					<c:otherwise>
						<a href="remove_session.c_login">
					</c:otherwise>
				</c:choose> --%>

				<!-- <li><a href="/Matching_Project/f_mypage/myInfo.jsp">마이페이지</a> -->
				<li><c:choose>
						<c:when test="${identity.identity == 'freelancer' }">
							<a href="/f_mypage/myInfo">
						</c:when>
						<c:otherwise>s
							<a href=${pageContext.request.contextPath}"/f_mypage/myInfo">
						</c:otherwise>
					</c:choose>마이페이지</a></li>
				<li><a href="/Matching_Project/c_using/service.jsp">이용 방법</a></li>

			</ul>
		</div>
		<!--헤드 메뉴 -->
	</div>

</body>
</html>