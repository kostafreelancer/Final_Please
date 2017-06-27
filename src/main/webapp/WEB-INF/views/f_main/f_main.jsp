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
        ['주제', '5월', '6월'],
        ['프리랜서', ${count}, 50],
        ['프로젝트', ${countP}, 78]/* ,
        ['3', 0, 0],
        ['4', 0, 0],
        ['5', 0, 0] */
      ]);
 
      var options = {
        title: '5월,6월 신규 프리랜서 회원 및 프로젝트 현황',
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
	<%-- <div class="read" style="position: relative; z-index: 9999">
				<c:choose>
					<c:when test="${identity.identity == 'freelancer' }">
					
					<div class="readCount">${f_read }</div>개의 새로운 알림이 있습니다.				
					</c:when>
					
					<c:otherwise>
					
					</c:otherwise>
				</c:choose>
				
				<div class="read_2" style="position : relative; z-index: 2;">
				<c:choose>
					<c:when test="${identity.identity == 'freelancer' }">
					<ul>
					<c:forEach items="${alram }" var="alram">
				
					
						<li><a href="/c_membercenter/member_centerMain" style="text-decoration: none; color: #2257ad;">${alram.asktitle }</a> 문의에 대한 답변글이 달렸습니다.</li>
			
				
					</c:forEach>
					</ul>
					</c:when>
				</c:choose>
				</div>
		</div> --%>
			<!--  -->
	 	<div class="inbox">
			<div class="oneTop-middle">
				<dl class="title">
					<dt>
						<span>신속한</span>
						맞춤 매칭
					</dt>
				<dd>웹/앱,프로그램,개발,디자인</dd>
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
						<div class="data">${countP }</div>
					</div>
				</li>
				<li class="sort-item">
					<div class="sort_itemd">
						<div class="tit">등록된 기업</div>
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
		</video>
	</div> 
		
			
			<!--  -->
<!-- 	<div class="main_slide" style="position: relative; z-index: 1;">
		<div class="slideshow_images">
			<h2>당신의 프리랜서는 여기에!</h2>
				<div class="slideshow_detail">
					<a href="#" class="slide"><img src="../../../resources/f_main_img/test/151.png"
				alt="" width="150px" height="300px" align="middle"></a>
				</div>
			<a href="#" class="slide"><img src="../../../resources/f_main_img/bg_visual01.jpg"
				alt="" width="1911" height="432"></a> <a href="#" class="slide"><img
				src="../../../resources/f_main_img/bg_visual02.jpg" alt="" width="1911" height="432"></a>
			<a href="#" class="slide"><img src="../../../resources/f_main_img/bg_visual03.jpg"
				alt="" width="1911" height="432"></a> <a href="#" class="slide"><img
				src="../../../resources/f_main_img/bg_visual04.jpg" alt="" width="1911" height="432"></a>
		</div>
	</div> -->

	<div class="main_news">
		 <c:choose>
			<c:when test="${identity.identity == 'freelancer' }">
				<h3>${client.f_name }님을 위한 추천 프로젝트</h3>
			</c:when>
			<c:otherwise>
				<h3>드림랜서 현황</h3>
			</c:otherwise>
		</c:choose> 
		
		<%-- <h1>${recommend }raasdr</h1> --%>
		<div class="left_news">
			
			
			<%-- <c:when test="${identity.identity == 'freelancer' }"> --%>
				<ul class="recommend" >
				 <c:choose>
		<c:when test="${identity.identity == 'freelancer' }">
			<c:forEach items="${recommend }" var="recommendProject">
					<li>
					<h4>${recommendProject.e_name }</h4>
					<a style = "text-decoration: none" href="/c_projectlist/c_readpage?e_pr_num=${recommendProject.e_pr_num }&e_num=${recommendProject.e_num}&from=list&f_num=0">${recommendProject.p_name }</a>
					<h5>
					<br>
					<p class="test"><img alt="" src="../../../resources/f_main_img/money.PNG"> ${recommendProject.p_lowercost }만원 ~ ${recommendProject.p_uppercost }만원</p>
					<p  class="test"><img alt="" src="../../../resources/f_main_img/clock.PNG">  ${recommendProject.p_startdate } 부터 시작</p>
					<p class="test_content">${recommendProject.p_content }</p>
					</h5>
					</li>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p class="hello">반갑습니다! 드림랜서입니다!</p><br><br><br><p class="hello2"> IT프로젝트 중계분야 으뜸!<br> 
			프로젝트 / 프리랜서 등록수 최고!
			<br>맞춤형 프로젝트가 회원님을 기다리고 있습니다!
			<br>전 세계 실력 최고 프리랜서들이 프로젝트를 기다리고 있습니다!
			<br>회원가입 후 더 다양한 혜택을 이용해보세요.
			</p>
		</c:otherwise>
	</c:choose>
			
				</ul>
		
		</div>
		<div id="chart_div"></div>
	</div>
	<c:choose>
		<c:when test="${identity.identity == 'freelancer' }">
			
		</c:when>
		<c:otherwise>
		<div class="main_join">
		<div class="text_join">
			프로젝트를 찾고 계신 프리랜서인가요? <a class="btn_join" href="../c_join/c_join_step1">회원가입하기</a>
		</div>
	</div>
		</c:otherwise>
	</c:choose>
	
	
	
	<div id="active_inf">
<!-- 		<ul id="tabs">
			<li><a href="#" title="tab1">프리랜서</a></li>
			<li><a href="#" title="tab2">프로젝트</a></li>

		</ul> -->

	<div id="content_test"> 

				<!-- <h2>프리랜서 정보</h2> -->
				<div class="section_title">${count }명의 프리랜서 활동중</div>
				<p class="section_img"><img alt="" src="../../../resources/f_main_img/icon01_off.png"></p> 
				<p class="section_img"><img alt="" src="../../../resources/f_main_img/icon02_off.png"></p>
				<p class="section_img"><img alt="" src="../../../resources/f_main_img/icon03_off.png"> </p>
				<form action="" method="post">
					<table class="active_p">
						<tr>
							
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							개발 : </td>							
							<th>${f_create } 명</th>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							디자인 : </td>
							<th>${f_design } 명</th>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							기획</td>
							<th>${f_planner } 명</th>
							
						</tr>
					
					</table>
				</form>
				<br><br>
				
				<!-- 성준햄이해준대여~~~~~ -->

				<!-- <h2>프로젝트 정보</h2>
				<h3>현재 모집중인 프로젝트 수</h3> -->
				<div class="section_title">${countP }개의 프로젝트 모집 중</div>

				<p class="section_img"><img alt="" src="../../../resources/f_main_img/icon01_off.png"></p>
				<p class="section_img"><img alt="" src="../../../resources/f_main_img/icon02_off.png"></p>
				<p class="section_img"><img alt="" src="../../../resources/f_main_img/icon03_off.png"></p>
				<table>
				<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							개발 : </td>							
							<th>${f_create } 개</th>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							디자인 : </td>
							<th>${f_design } 개</th>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							기획</td>
							<th>${f_planner } 개</th>
				</tr>
				</table>
		 	</div>



	</div>
	<div id="introduce_site">
		<h2>드림랜서 시스템 장점</h2>
		<br>
		<br>
		<div id="introduce_img">

			<img alt="" src="../../../resources/f_main_img/cont04_icon01.png"> <img alt=""
				src="../../../resources/f_main_img/cont04_icon02.png"> <img alt=""
				src="../../../resources/f_main_img/cont04_icon03.png"> <!-- <img alt=""
				src=../../../resources/f_main_img/cont04_icon04.png"> -->
			<table class="introduce_text">
				<tr>
					<td>
					무료로 더 쉽게 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<br>프로젝트를 등록&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>			
					<td>
					실력있는 지원자를&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<br> 한눈에 비교 선택&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>
					좋은 기업들의&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<br> 다양한 프로젝트&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				</table>
		</div>
	</div>
	
	</section>
	<%@ include file="../c_common/footer.jsp"%>

</body>
</html>