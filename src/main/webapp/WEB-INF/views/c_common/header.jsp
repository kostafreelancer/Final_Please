<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/c_common_css/header.css"
	type="text/css" media="screen" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/c_common_js/header.js"></script>
<script type="text/javascript"
	src="/resources/c_common_js/header_second.js"></script>

</head>
<body>
	<div class="header">
		<div class="header_top_menu">
		
		<c:if test="${identity.identity ne null}">
			<img class="alram_icon" alt="alram" src="/resources/c_common_img/images_b.png">
			
			<c:if test="${chang_num > 0 }">
				<div class="red"></div>
				<div class="header_check">
				<div class='ee'>${chang_num}
					<ul>
						<c:forEach var="item" items="${a_list }" >
								<c:if test="${identity.identity eq 'freelancer' }">
									<li><a href="/f_mypage/myInfo2?where=4">${item.p_name}에서 ${item.p_content }</a></li>
								</c:if>
								<c:if test="${identity.identity eq 'enterprise' }">
									<li><a href="/e_mypage/e_project">${item.p_name}에서 ${item.p_content }</a></li>
								</c:if>
						</c:forEach>
					</ul>					
				</div>
			</div>
			</c:if>
		</c:if>
			<%-- <div class="header_check">
				<div class='ee'>${chang_num}
					<ul>
						<c:forEach var="item" items="${a_list }" >
							<li><a href="/f_mypage/myInfo2">프로젝트 ${item.p_content } 1건</a></li>
						</c:forEach>
					</ul>					
				</div>
			</div> --%>
			<div class="header_welcome_content">
				<c:choose>
					<c:when test="${identity.identity == 'freelancer' }">
						<span id="c_freelancer">${client.f_name}</span>
					</c:when>
					<c:when test="${identity.identity == 'enterprise' }">
						<span id="enterprise">${client.e_name}</span>
					</c:when>
					<c:when test="${identity.identity == 'admin' }">
						<span id="admin">${client.ad_id}</span>
					</c:when>
					<c:otherwise>
						<span id="c_freelancer">${client.f_name}</span>
					</c:otherwise>
				</c:choose>
			</div>
			<ul class="header_top_menus">
				<li><img alt="center_img"
					src="/resources/c_common_img/member_icon.png" width="18px" > <a
					href=${pageContext.request.contextPath}"/c_membercenter/member_centerMain">고객
						센터</a></li>
				<li class="header_join"><img alt="join_img"
					src="/resources/c_common_img/join_icon .png" width="24px" > <a
					href=${pageContext.request.contextPath}"/c_join/c_join_step1">회원가입</a></li>
				<li class="login_checking"><img alt="log_img"
					src="/resources/c_common_img/login_icon.png" width="22px" class="change_menus"> <a
					href=${pageContext.request.contextPath}"/c_login/login">로그인</a></li>

				<li><img alt="home_img"
					src="/resources/c_common_img/Home-blueberry-256 (1).png" width="25px" class="change_menus"> <a class="c_home"
					href=${pageContext.request.contextPath}"/f_main/f_main">HOME</a></li>
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
				<li><a class="menus_one" href="#">
				<c:choose>
					<c:when test="${identity.identity == 'freelancer' }">자유 게시판</c:when>
					<c:when test="${identity.identity == 'enterprise' }">프로젝트 등록</c:when>
					<c:when test="${identity.identity == 'admin' }"> </c:when>
					<c:otherwise>자유 게시판</c:otherwise> 
				</c:choose>
				</a></li>
				<li><a class="menus_two" href="#">
				<c:choose>
					<c:when test="${identity.identity == 'admin' }"> </c:when> 
					<c:otherwise>프로젝트 목록</c:otherwise>
				</c:choose>
				</a></li>
				
				<li><a class="menus_three" href="#">
				<c:choose>
					<c:when test="${identity.identity == 'admin' }"> </c:when> 
					<c:otherwise>프리랜서 목록</c:otherwise>
				</c:choose>
				</a></li>

				
				<li><a class="menus_four" href="#">
				<c:choose>
					<c:when test="${identity.identity == 'admin' }"> </c:when> 
					<c:otherwise>마이페이지</c:otherwise>
				</c:choose>
				</a></li>
				<li class="menus_five"><a href=${pageContext.request.contextPath}"/c_using/service">이용 방법</a></li>

			</ul>
			
			<form class="c_f_main" action="/f_main/f_main" method="get">
			</form>
			<form class="c_e_main" action="/e_main/e_main" method="get"></form>
			<form class="c_a_main" action="/a_main/a_main" method="get"></form>
			<form class="c_f_menus_one" action="/e_insertproject/e_insertproject" method="get"></form>
			<form class="c_f_menus_one2" action="/f_board/f_list" method="get"></form> <!--여기 자유게시판 url -->
			<form class="c_f_menus_two" action="/c_projectlist/c_projectlist" method="get"></form>
			<form class="c_f_menus_two2" action="#" method="get"></form>  <!--여기 메일함 주소-->
			<form class="c_f_menus_three" action="/c_freelancerlist/f_list" method="get"></form>
			<form class="c_f_menus_three2" action="#" method="get"></form> <!--여기 프로젝트 관리 url -->
			<form class="c_f_menus_four" action="/f_mypage/myInfo" method="get">
				<input type="hidden" name="where" value="1">
			</form>
			<form class="c_f_menus_four3" action="/e_mypage/e_info" method="get"></form>
			<form class="c_f_menus_four2" action="/a_main/a_main" method="get"></form> 
		</div>
		<!--헤드 메뉴 -->
	</div>

</body>
</html>