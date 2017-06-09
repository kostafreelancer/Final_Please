<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



	


<link rel="stylesheet" href="/resources/a_main_css/a_project.css" type="text/css"
	media="screen" />
	
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript" src="/resources/a_main_js/a_main.js"></script>
<script type="text/javascript" src="/resources/a_main_js/tabs.js"></script>

</head>
<body>

<%@include file="../c_common/header_enterprise.jsp"%>

	<div id="nav">
		<div class="nav_txt">
			<p>
				<a href="/e_lan/index.php">Home</a> <span class="padd">&gt;</span> <span>프로젝트
					상세</span>
			</p>
		</div>
	</div>

	<section>
	<ul id="tabs">
		<li><a href="#" title="tab1">프리랜서</a></li>
		<li><a href="#" title="tab2">기업</a></li>
		<li><a href="#" title="tab3">기업가입승인</a></li>
	</ul>
	
	<div id="tcontent">
		<div id="tab1">
			<div class="tb_box">
			<form action="/a_main/a_send" class="f_info" name="f_info" method="post">
				<table class="tb_st01 tb_st03">
					<colgroup>
						<col style="width: 9%">
						<col style="width: 13%">
						<col style="width: 9%">
						<col style="width: 10%">
						<col style="width: 12%">
						<col style="width: *">
						<col style="width: 11%">
						<col style="width: 14%">
					</colgroup>
					<thead></thead>
					<tbody>
					
						<c:forEach var="f" items="${listFreelancer }">
							<tr>
								<td class="hidden">${f.f_num }</td>
								<th>아이디</th>
								<td>${f.f_id }</td>
								<th>이름</th>
								<td>${f.f_name }</td>
								<th>핸드폰</th>
								<td>${f.f_hphone }</td>
								<th>생년월일</th>
								<td>${f.f_birth }</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td colspan="3" id="f_email">${f.f_email }</td>
								<th>주소</th>
								<td colspan="3">${f.f_address }</td>
							</tr>
							<tr>
								<th>분야</th>
								<td>${f.f_major }</td>
								<th>상태</th>
								<td>${f.f_nowstate }</td>
								<th>최근접속일</th>
								<td>${f.f_recentlogin }</td>
								
								<th colspan="2"><a href="/a_main/a_mailsender?f.f_num=${f.f_num }" onClick="window.open(this.href, '', 'width=1000, height=1000'); return false;">메일 발송</a><!-- <input type="button" onclick="javascript:postPopUp()" value="메일 발송" class="mailSend"> -->&nbsp;&nbsp;&nbsp;&nbsp;<button class="deleteAccountF">계정 삭제</button></th>
							</tr>
							<tr>
								<td colspan="8"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
			</div>
			<div class="num_box">
				<span class="btn_lef"> <a href="" class="first" alt="처음으로"></a>
				</span> <span class="btn_rit"> <a href="" class="last" alt="마지막으로"></a>
				</span>
			</div>
		</div>


		<div id="tab2">
			<div class="tb_box">
				<table class="tb_st01 tb_st03">
					<colgroup>
						<col style="width: 10%">
						<col style="width: 13%">
						<col style="width: 9%">
						<col style="width: *">
						<col style="width: 9%">
						<col style="width: *">
						<col style="width: 10%">
						<col style="width: 13%">
					</colgroup>
					<tbody>
						<c:forEach var="e" items="${listEnterprise }">
							<tr>
								<td class="hidden">${e.e_num }</td>
								<th>아이디</th>
								<td>${e.e_id}</td>
								<th>가입자명</th>
								<td>${e.e_name}</td>
								<th>기업명</th>
								<td>${e.e_ename}</td>
								<th>전화번호</th>
								<td>${e.e_phone}</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>${e.e_mail}</td>
								<th>주소</th>
								<td colspan="3">${e.e_address}</td>
								<th>규모</th>
								<td>${e.e_scale}</td>
							</tr>
							<tr>
								<th>사업자등록번호</th>
								<td>${e.e_regno}</td>
								<th>사업자등록증</th>
								<td>${e.e_licensefile}</td>
								<th>승인여부</th>
								<td>${e.e_check}</td>
								<th  colspan="2"><button class="mailSend">메일 발송</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="deleteAccountE">계정 삭제</button></th>
							</tr>
							<tr>
								<td colspan="8"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="num_box">
				<span class="btn_lef"> <a href="" class="first" alt="처음으로"></a>
				</span> <span class="btn_rit"> <a href="" class="last" alt="마지막으로"></a>
				</span>
			</div>
		</div>


		<div id="tab3">
			<div class="tb_box">
				<table class="tb_st01 tb_st03">
					<colgroup>
						<col style="width: 10%">
						<col style="width: 13%">
						<col style="width: 9%">
						<col style="width: *">
						<col style="width: 9%">
						<col style="width: *">
						<col style="width: 10%">
						<col style="width: 13%">
					</colgroup>
					<tbody>
						<c:forEach var="ep" items="${listEnterprisePermit }">
							<tr>
								<td class="hidden">${ep.e_num }</td>
								<th>아이디</th>
								<td>${ep.e_id}</td>
								<th>가입자명</th>
								<td>${ep.e_name}</td>
								<th>기업명</th>
								<td>${ep.e_ename}</td>
								<th>전화번호</th>
								<td>${ep.e_phone}</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>${ep.e_mail}</td>
								<th>주소</th>
								<td colspan="3">${ep.e_address}</td>
								<th>규모</th>
								<td>${ep.e_scale}</td>
							</tr>
							<tr>
								<th>사업자등록번호</th>
								<td>${ep.e_regno}</td>
								<th>사업자등록증</th>
								<td>${ep.e_licensefile}</td>
								<th>승인여부</th>
								<td>${ep.e_check}</td>
								<th  colspan="2"><button id="mailSend">메일 발송</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="permitJoin">가입 승인</button></th>
							</tr>
							<tr>
								<td colspan="8"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="num_box">
				<span class="btn_lef"> <a href="" class="first" alt="처음으로"></a>
				</span> <span class="btn_rit"> <a href="" class="last" alt="마지막으로"></a>
				</span>
			</div>
		</div>
	</div>
	
	<form action="/a_main/a_deleteF" method="post" name="deleteFormF">
		<input type="hidden" name="deleteF_num">
	</form>
	<form action="/a_main/a_deleteE" method="post" name="deleteFormE">
		<input type="hidden" name="deleteE_num">
	</form>
	<form action="/a_main/a_permit" method="post" name="permitForm">
		<input type="hidden" name="permitE_num">
	</form>
	
	</section>

<%@include file="../c_common/footer.jsp"%>
</body>
</html>