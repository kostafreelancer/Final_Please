<%-- <%@page import="lancer.f_main.model.member"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="../../../resources/f_main_css/main.css">
<!-- <script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script> -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script src="../../../resources/f_main_js/f_main.js"></script>
<!-- <script src="js/vendor/modernizr.custom.min.js"></script>
<script src="js/vendor/jquery-1.10.2.min.js"></script>
<script src="js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script> -->

<title>Insert title here</title>
<script type="text/javascript">
google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawMultSeries);
 
function drawMultSeries() {
      var data = google.visualization.arrayToDataTable([
        ['주제', '4월', ''],
        ['프리랜서', ${count}, 0],
        ['프로젝트', ${countP}, 0]/* ,
        ['3', 0, 0],
        ['4', 0, 0],
        ['5', 0, 0] */
      ]);
 
      var options = {
        title: '차트주제',
        chartArea: {width: '50%'},
        hAxis: {
          title: '5월 프리랜서, 프로젝트 등록 수',
          minValue: 0
        },
        vAxis: {
          title: ''
        }
      };
 
      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }  
    
/* 	window.location.href="f_main.fm" */
   </script>
</head>
<body>
	<%-- <jsp:forward page="f_main.fm"/> --%>
<%-- 	<%
		RequestDispatcher dispatcher = request.getRequestDispatcher("f_main.fm");
	%> --%>
	<%@ include file="../c_common/header.jsp"%>
	<section id="slides">
	<div class="main_slide">
		<div class="slideshow_images">
		
			<a href="#" class="slide"><img src="../../../resources/f_main_img/bg_visual01.jpg"
				alt="" width="1911" height="432"></a> <a href="#" class="slide"><img
				src="../../../resources/f_main_img/bg_visual02.jpg" alt="" width="1911" height="432"></a>
			<a href="#" class="slide"><img src="../../../resources/f_main_img/bg_visual03.jpg"
				alt="" width="1911" height="432"></a> <a href="#" class="slide"><img
				src="../../../resources/f_main_img/bg_visual04.jpg" alt="" width="1911" height="432"></a>
		</div>
	</div>

	<div class="main_news">
		<c:choose>
			<c:when test="${identity.identity == 'freelancer' }">
				<h1>${client.f_name }님을 위한 맞춤 프로젝트</h1>
			</c:when>
			<c:otherwise>
				<h1>드림랜서입니다!</h1>
			</c:otherwise>
		</c:choose>
		
		<%-- <h1>${recommend }raasdr</h1> --%>
		<div class="left_news">
			<%-- <c:when test="${identity.identity == 'freelancer' }"> --%>
				<ul>
				 <c:choose>
		<c:when test="${identity.identity == 'freelancer' }">
			<c:forEach items="${recommend }" var="recommendProject">
				
					<li>---------------------------------<br>
					
					${recommendProject.p_name }<br>
					${recommendProject.p_lowercost }만원 ~ ${recommendProject.p_uppercost }만원 <br>
					${recommendProject.p_startdate } 부터 시작<br>
					<a href="/c_projectlist/c_readpage?e_pr_num=${recommendProject.e_pr_num }&e_num=${recommendProject.e_num}">프로젝트 상세 확인하기</a><br>
					---------------------------------</li>
				
			</c:forEach>
		</c:when>
		<c:otherwise>
			<li>드림랜서입니다!</li>
		</c:otherwise>
	</c:choose>
			
				</ul>
			
		</div>
		<div id="chart_div"></div>
	</div>

	<div id="active_inf">
		<ul id="tabs">
			<li><a href="#" title="tab1">프리랜서</a></li>
			<li><a href="#" title="tab2">프로젝트</a></li>

		</ul>

		<div id="content">
			<div id="tab1">
				<h2>프리랜서 정보</h2>
				<h3>현재 활동중인 프리랜서는 ${count }명 입니다.</h3>
				<img alt="" src="../../../resources/f_main_img/icon01_off.png"> <img alt=""
					src="../../../resources/f_main_img/icon02_off.png"> <img alt=""
					src="../../../resources/f_main_img/icon03_off.png"> <img alt=""
					src="../../../resources/f_main_img/icon04_off.png">
				<form action="" method="post">
					<table class="active_p">
						<tr>
						
						<!-- 추후 삭제영역 -->
							<h1>--분야별 프리랜서 활동 명수, 현재는 프리랜서 회원 목록 출력--</h1><br>
							<!-- 삭제영역 끝 -->
							<th>							
							<td>&nbsp;&nbsp;${m }</td>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<td>${member1 }</td>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<td>${member2 }</td>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<td>${member3 }</td>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</tr>
					</table>
				</form>
			</div>
			<div id="tab2">
				<h2>프로젝트 정보</h2>
				<h3>현재 등록된 프로젝트 수</h3>
				<h3>현재 등록된 프로젝트 수는 ${countP }개 입니다.</h3>
				<img alt="" src="../../../resources/f_main_img/icon01_off.png"> <img alt=""
					src="../../../resources/f_main_img/icon02_off.png"> <img alt=""
					src="../../../resources/f_main_img/icon03_off.png"> <img alt=""
					src="../../../resources/f_main_img/icon04_off.png">
				<h3>--분야별 프로젝트 수 구현예정--</h3>
				<tr>
					<td>1 프로젝트DB</td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<td>2 프로젝트DB</td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<td>3 프로젝트DB</td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<td>4 프로젝트DB</td>
				</tr>
			</div>

		</div>

	</div>
	<div id="introduce_site">
		<h2>드림랜서 시스템 장점</h2>
		<br>
		<br>
		<div id="introduce_img">

			<img alt="" src="../../../resources/f_main_img/cont04_icon01.png"> <img alt=""
				src="../../../resources/f_main_img/cont04_icon02.png"> <img alt=""
				src="../../../resources/f_main_img/cont04_icon03.png"> <img alt=""
				src=../../../resources/f_main_img/cont04_icon04.png">

		</div>
	</div>
	
	</section>
	<%@ include file="../c_common/footer.jsp"%>

</body>
</html>