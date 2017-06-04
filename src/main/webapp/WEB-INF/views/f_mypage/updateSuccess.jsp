<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/f_mypage/f_mypage_css/updateSuccess.css" type="text/css" media="screen" />

</head>
<body>
<%@include file="../c_common/header.jsp"%>

	<div class="left_menu">
		<div class="left_menu_title">
			<h2>마이 페이지</h2>
		</div>
		<div class="left_menu_content">
			<ul class="left_menu_contents">
				<li><a href="">일정 관리</a></li>
				<li><a href="">회계 관리</a></li>
				<li><a href="showFreelancerInfo.f_mypage?f_num=${client.f_num}">내 정보</a></li>
			</ul>
		</div>
	</div>
	<section id="firstsection">
	<br><br><br><br><br>
		<h3>회원 정보수정이 완료 되었습니다.</h3>
		<input type="button" id="button" value="내 정보로 이동" onclick="location.href='showFreelancerInfo.f_mypage?f_num=${client.f_num}'";>
	<br><br><br><br><br>
	</section>
	<%@include file="../c_common/footer.jsp"%>
</body>
</html>