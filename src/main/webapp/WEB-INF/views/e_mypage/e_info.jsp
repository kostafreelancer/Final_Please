<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



	

<link rel="stylesheet" href="/resources/e_mypage_css/e_info.css" type="text/css"
	media="screen" />
	<link rel="stylesheet" href="/resources/e_mypage_css/e_leftmenu.css"
	type="text/css" media="screen" />
	<link rel="stylesheet" href="/resources/e_mypage_css/star.css" type="text/css"
	media="screen" />
	
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript" src="/resources/e_mypage_js/e_info_star.js"></script>
<script type="text/javascript" src="/resources/e_mypage_js/e_info.js"></script>
<script type="text/javascript" src="/resources/e_mypage_js/e_info2.js"></script>
<script type="text/javascript" src="/resources/e_mypage_js/e_info3.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>



</head>
<body>

<%@include file="../c_common/header_enterprise.jsp"%>

	<nav class="left_menu">
	<div class="left_menu_title">
		<h2>마이 페이지</h2>
	</div>
	<div class="left_menu_content">
		<ul class="left_menu_contents">
			<li><a href="/e_mypage/e_info">기업 정보</a></li>
			<li><a href="/e_mypage/e_project">프로젝트 관리</a></li>
		</ul>
	</div>
	</nav>

	<div id="nav">
		<div class="nav_txt">
			<p>
				<a href="/e_lan/index.php">Home</a> <span class="padd">&gt;</span> <span>프로젝트
					상세</span>
			</p>
		</div>
	</div>

	<section>
	<div class="e_info_top">
		<h3>회원정보 입력</h3>
	</div>

	<div class="e_info_table1">
		<h4>사업자등록증</h4>
		<form action="/c_file/downloadFile" id="fileForm" name="fileForm" method="post">
			<input type="hidden" name="file_num" value="${e_licenseFileNum}">
		</form>
		<table class="tb_st01">
				 <tr>
	                <th>첨부파일</th>
	                <td colspan="5">
	                        <a href="#" id="e_licenseDown">${e_licenseFileName}</a>
	                        (${e_licenseFileSize}kb)
	                </td>
	            </tr>	
		</table>
	</div>

<form action="/e_mypage/e_info" method="post" name="EnterpriseWriteFm" enctype="multipart/form-data">
	<div class="e_info_table1">
		<h4>아이디 및 비밀번호</h4>
		
			<table class="tb_st01">
				<colgroup>
					<col style="width: 16%">
					<col style="width: 34%">
					<col style="width: 16%">
					<col style="width: 34%">
				</colgroup>
				<tr>
					<th scope="row" class="ac">회원아이디</th>
					<td colspan="3">${client.e_id }</td>
				</tr>
				<tr>
					<th scope="row" class="ac">비밀번호</th>
					<td><input type="password" id="e_pwd_1" name="e_pwd_1" class="wid02">
					</td>
					<th scope="row" class="ac">비밀번호 확인</th>
					<td><input type="password" id="e_pwd_2" name="e_pwd_2" class="wid02">
					</td>
				</tr>
				<tr>
					<th scope="row" class="ac">이메일</th>
					<td colspan="3"><input type="text" id="e_mail_1" name="e_mail_1" class="wid04"
						value="${e_mail_1 }"> <span>@</span> <input type="text"
						id="e_mail_2" name="e_mail_2" class="wid04" value="${e_mail_2 }"  readonly="readonly"> <select
						id="e_mail_select" class="wid04" name="">
							<option value="" selected="">선택해주세요.</option>
							<option value="">직접입력</option>
							<option value="chollian.net">chollian.net</option>
							<option value="daum.net">daum.net</option>
							<option value="dreamwiz.com">dreamwiz.com</option>
							<option value="empal.com">empal.com</option>
							<option value="freechal.com">freechal.com</option>
							<option value="hanafos.com">hanafos.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="hanmir.com">hanmir.com</option>
							<option value="hitel.net">hitel.net</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="korea.com">korea.com</option>
							<option value="kornet.net">kornet.net</option>
							<option value="lycos.co.kr">lycos.co.kr</option>
							<option value="nate.com">nate.com</option>
							<option value="naver.com">naver.com</option>
							<option value="nownuri.net">nownuri.net</option>
							<option value="paran.com">paran.com</option>
							<option value="unitel.co.kr">unitel.co.kr</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
					</select></td>
				</tr>
				<tr>
					<th>평점</th>
					<td colspan="3"><span class="star_rating"> 
					<a href="">★</a>
					<a href="">★</a>
					<a href="">★</a>
					<a href="">★</a>
					<a href="">★</a>
					<span id="e_score"> ${client.e_score }</span> 
					</span></td>
				</tr>
			</table>
		
	</div>



	<div class="e_info_table2">
		<h4>기업정보</h4>
		<table class="tb_st01">
			<colgroup>
				<col style="width: 16%">
				<col style="width: 17%">
				<col style="width: 17%">
				<col style="width: 15%">
				<col style="width: 13%">
				<col style="width: *">
			</colgroup>
			<tr>
				<td rowspan="5"><img name="IMG1" id="e_ownerimage"
					src="${client.e_ownerfile }">
					<div class="filebutton">
						<span>사진업로드</span>  <!--  <input type="file" name="e_ownerfile" id="e_ownerfile" value="${client.e_ownerfile }"
							class="searchfile" title="파일 찾기"
							style="width: 820px;"> -->
					</div></td>
				<th scope="row">가입자 명</th>
				<td colspan="4"><input type="text" id="e_name"
					name="e_name" class="wid02" value="${client.e_name }"></td>
			</tr>
			<tr>
				<th scope="row">회사명</th>
				<td colspan="4"><input type="text" id="e_ename"
					name="e_ename" class="wid" value="${client.e_ename }"></td>
			</tr>
			<tr>
				<th scope="row"><label for="fm_ceoname">대표자명</label></th>
				<td><input type="text" id="e_owner" name="e_owner"
					class="wid" value="${client.e_owner }"></td>
				<th scope="row">사업자등록번호</th>
				<td colspan="2"><input type="text" id="e_regno_1"
					name="e_regno_1" class="wid03" value="${regno_1 }" maxlength="3"> <span>-</span>
					<input type="text" id="e_regno_2" name="e_regno_2" class="wid03"
					maxlength="2" value="${regno_2 }"> <span>-</span> <input type="text"
					id="e_regno_3" name="e_regno_3" class="wid03" maxlength="5"
					value="${regno_3 }"></td>
			</tr>
			<tr>
				<th scope="row">연락처(전화)</th>
				<td colspan="4"><select class="wid03" name="e_phone_1"
					id="e_phone_1">
						<option value="">--------</option>
						<option value="02" <c:if test="${e_phone_1 == '02'}">selected</c:if>>02 서울</option>
						<option value="031" <c:if test="${e_phone_1 == '031'}">selected</c:if>>031 경기</option>
						<option value="032" <c:if test="${e_phone_1 == '032'}">selected</c:if>>032 인천</option>
						<option value="033" <c:if test="${e_phone_1 == '033'}">selected</c:if>>033 강원</option>
						<option value="041" <c:if test="${e_phone_1 == '041'}">selected</c:if>>041 충남</option>
						<option value="042" <c:if test="${e_phone_1 == '042'}">selected</c:if>>042 대전</option>
						<option value="043" <c:if test="${e_phone_1 == '043'}">selected</c:if>>043 충북</option>
						<option value="051" <c:if test="${e_phone_1 == '051'}">selected</c:if>>051 부산</option>
						<option value="052" <c:if test="${e_phone_1 == '052'}">selected</c:if>>052 울산</option>
						<option value="053" <c:if test="${e_phone_1 == '053'}">selected</c:if>>053 대구</option>
						<option value="054" <c:if test="${e_phone_1 == '054'}">selected</c:if>>054 경북</option>
						<option value="055" <c:if test="${e_phone_1 == '055'}">selected</c:if>>055 경남</option>
						<option value="061" <c:if test="${e_phone_1 == '061'}">selected</c:if>>061 전남</option>
						<option value="062" <c:if test="${e_phone_1 == '062'}">selected</c:if>>062 광주</option>
						<option value="063" <c:if test="${e_phone_1 == '063'}">selected</c:if>>063 전북</option>
						<option value="064" <c:if test="${e_phone_1 == '064'}">selected</c:if>>064 제주</option>
						<option value="070" <c:if test="${e_phone_1 == '070'}">selected</c:if>>070</option>
						<option value="0502" <c:if test="${e_phone_1 == '0502'}">selected</c:if>>0502</option>
						<option value="0504" <c:if test="${e_phone_1 == '0504'}">selected</c:if>>0504</option>
						<option value="0505" <c:if test="${e_phone_1 == '0505'}">selected</c:if>>0505</option>
						<option value="0506" <c:if test="${e_phone_1 == '0506'}">selected</c:if>>0506</option>
						<option value="0130" <c:if test="${e_phone_1 == '0130'}">selected</c:if>>0130</option>
				</select> <span>-</span> <input type="text" id="e_phone_2" name="e_phone_2"
					class="wid03" maxlength="4" value="${e_phone_2 }"> <span>-</span> <input
					type="text" id="e_phone_3" name="e_phone_3" class="wid03" maxlength="4"
					value="${e_phone_3 }"></td>
			</tr>
			<tr>
				<th scope="row"><label for="fm_bizcontents">주요사업내용</label></th>
				<td colspan="4"><input type="text" id="e_bf"
					name="e_bf" class="wid" value="${client.e_bf }"></td>
			</tr>
			<tr>
				<th scope="row"><label for="fm_managername">담당자명</label></th>
				<td><input type="text" id="manager_name"
					name="manager_name" class="wid07" value="${client.manager_name }"></td>
				<th scope="row"><label for="fm_phone1">담당자 핸드폰</label></th>
				<td colspan="3"><select class="wid03" name="manager_hphone_1"
					id="manager_hphone_1">
						<option value="">---</option>
						<option value="010" <c:if test="${manager_hphone_1 == '010'}">selected</c:if>>010</option>
						<option value="011" <c:if test="${manager_hphone_1 == '011'}">selected</c:if>>011</option>
						<option value="016" <c:if test="${manager_hphone_1 == '016'}">selected</c:if>>016</option>
						<option value="017" <c:if test="${manager_hphone_1 == '017'}">selected</c:if>>017</option>
						<option value="018" <c:if test="${manager_hphone_1 == '018'}">selected</c:if>>018</option>
						<option value="019" <c:if test="${manager_hphone_1 == '019'}">selected</c:if>>019</option>
				</select> <span>-</span> <input type="text" id="manager_hphone_2" name="manager_hphone_2"
					class="wid03" maxlength="4" value="${manager_hphone_2 }"> <span>-</span> <input
					type="text" id="manager_hphone_3" name="manager_hphone_3" class="wid03"
					maxlength="4" value="${manager_hphone_3 }"></td>
			</tr>
			<tr>
				<th>담당자 이메일</th>
				<td colspan="5"><input type="text" id="manager_mail_1"
					name="manager_mail_1" class="wid04" value="${manager_mail_1 }"> <span>@</span> <input
					type="text" id="manager_mail_2" name="manager_mail_2" class="wid04"
					value="${manager_mail_2 }" readonly="readonly"> <select class="wid04"
					name="manager_mail_select" id="manager_mail_select">
						<option value="" selected="">선택해주세요.</option>
						<option value="">직접입력</option>
						<option value="chollian.net">chollian.net</option>
						<option value="daum.net">daum.net</option>
						<option value="dreamwiz.com">dreamwiz.com</option>
						<option value="empal.com">empal.com</option>
						<option value="freechal.com">freechal.com</option>
						<option value="hanafos.com">hanafos.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="hanmir.com">hanmir.com</option>
						<option value="hitel.net">hitel.net</option>
						<option value="hotmail.com">hotmail.com</option>
						<option value="korea.com">korea.com</option>
						<option value="kornet.net">kornet.net</option>
						<option value="lycos.co.kr">lycos.co.kr</option>
						<option value="nate.com">nate.com</option>
						<option value="naver.com">naver.com</option>
						<option value="nownuri.net">nownuri.net</option>
						<option value="paran.com">paran.com</option>
						<option value="unitel.co.kr">unitel.co.kr</option>
						<option value="yahoo.co.kr">yahoo.co.kr</option>
				</select></td>
			</tr>
			
			<tr>
				<th>회사 주소</th>
				<td colspan="4">
				<div class="mb10">
					<label for="fm_zip"></label> 
					<input type="text" id="fm_zip" name="e_address_1" class="wid60"
						title="주소검색 새창" value="${e_address_1}" readonly=""> 
					<input type = "button" class="btn_add" onClick = "openDaumZipAddress()" value = "주소 찾기" />
			 
				</div>
				<div>
					<label for="fm_address"></label> <input type="text"
						id="fm_address" name="e_address_2" class="wid"
						value="${e_address_2}"><input type="text"
						id="fm_address_etc" name="e_address_3" class="wid"
						value="${e_address_3}">
				</div>
				</td>
			</tr>
			
		
			<tr>
				<th>회사 홈페이지</th>
				<td colspan="5">
					<div>
						<span>http://</span> <input type="text" id="e_homepage"
							name="e_homepage" class="wid06" value="${client.e_homepage }">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" rowspan="2">기업정보</th>
				<th scope="col" class="ac">설립년도</th>
				<th scope="col" class="ac">사원수</th>
				<th scope="col" class="ac">상장여부</th>
				<th scope="col" class="ac">자본금</th>
				<th scope="col" class="ac">매출액</th>
			</tr>
			<tr>
				<td><input type="text" id="start_year" name="start_year"
					class="wid03" maxlength="4" value="${client.start_year }"><label
					for="fm_foundyear"> 년</label></td>
				<td><input type="text" id="e_enum" name="e_enum"
					class="wid03" value="${client.e_enum }"><label for="fm_employnum"> 명</label>
				</td>
				<td><select class="wid07" name="e_listing" id="e_listing">
						<option value="비상장" <c:if test="${client.e_listing == '비상장'}">selected</c:if>>비상장</option>
						<option value="코스피" <c:if test="${client.e_listing == '코스피'}">selected</c:if>>코스피상장</option>
						<option value="코스닥" <c:if test="${client.e_listing == '코스닥'}">selected</c:if>>코스닥상장</option>
						<option value="나스닥" <c:if test="${client.e_listing == '나스닥'}">selected</c:if>>해외(나스닥)</option>
						<option value="자스닥" <c:if test="${client.e_listing == '자스닥'}">selected</c:if>>해외(자스닥)</option>
						<option value="해외기타" <c:if test="${client.e_listing == '해외기타'}">selected</c:if>>해외(기타)</option>
				</select></td>
				<td><input type="text" id="e_capital"
					name="e_capital" class="wid05" value="${client.e_capital }"><label
					for="fm_capitalmoney"> 만원</label></td>
				<td><input type="text" id="e_sales"
					name="e_sales" class="wid05" value="${client.e_sales }"> 만원</td>
			</tr>
			<tr>
				<th><label for="fm_comtype">기업 형태</label></th>
				<td colspan="5"><select class="wid07" name="e_scale"
					id="e_scale">
						<option value="">--기업형태--</option>
						<option value="일반기업" <c:if test="${client.e_scale == '일반기업'}">selected</c:if>>일반기업</option>
						<option value="대기업" <c:if test="${client.e_scale == '대기업'}">selected</c:if>>대기업</option>
						<option value="중소기업" <c:if test="${client.e_scale == '중소기업'}">selected</c:if>>중소기업</option>
						<option value="외국기업" <c:if test="${client.e_scale == '외국기업'}">selected</c:if>>외국기업</option>
						<option value="벤처기업" <c:if test="${client.e_scale == '벤처기업'}">selected</c:if>>벤처기업</option>
						<option value="정부기관" <c:if test="${client.e_scale == '정부기관'}">selected</c:if>>정부기관</option>
						<option value="공기업" <c:if test="${client.e_scale == '공기업'}">selected</c:if>>공사/공기업</option>
						<option value="공공기관" <c:if test="${client.e_scale == '공공기관'}">selected</c:if>>공공기관</option>
						<option value="교육기업" <c:if test="${client.e_scale == '교육기업'}">selected</c:if>>교육기업</option>
						<option value="협회" <c:if test="${client.e_scale == '협회'}">selected</c:if>>협회</option>
						<option value="개인" <c:if test="${client.e_scale == '개인'}">selected</c:if>>개인</option>
						<option value="기타" <c:if test="${client.e_scale == '기타'}">selected</c:if>>기타</option>
				</select></td>
			</tr>
			<tr>
				<th>사업자등록증</th>
				<input type="hidden" id="fileExist" name="fileExist" value="false">
				<td colspan="5"><input type="file" id="e_licensefile" name="e_licensefile" class="wid"></td>
			</tr>
		</table>
	</div>

	<div class="btn_box mb30 mb02">
		<button class="btn_check06" id="checkValue">수정하기</button>
	</div>
	</form>
	
	</section>
	


			    
<%@include file="../c_common/footer.jsp"%>
</body>
</html>