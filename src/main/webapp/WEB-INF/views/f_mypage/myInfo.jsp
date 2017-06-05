<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="f_mypage_css/myInfo.css" type="text/css" media="screen" /> -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/f_mypage_css/myInfo.css" type="text/css" media="screen" />

<title>내 정보</title>

<!-- <script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script> -->
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>

<!-- <script type="text/javascript" src="f_mypage_js/myInfo.js"></script>
<script type="text/javascript" src="f_mypage_js/my.js"></script> -->
<script src="${pageContext.request.contextPath}/c_common/c_common_js/header.js"></script>
<script src="${pageContext.request.contextPath}/resources/f_mypage_js/myInfo.js"></script> 
<script src="${pageContext.request.contextPath}/resources/f_mypage_js/my.js"></script>
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
$(function(){
	var checks = document.getElementsByName("fm_new_keyword[]");

	var arr = new Array();

	<c:forEach var="item" items="${joblist}">
		arr.push("${item}");
	</c:forEach>
	console.log(arr[0]);
	for(var i=0; i<arr.length; i++){
			checks[arr[i]-1].checked = true;
	}
	
	var errorcheck = document.getElementById("pwd_error");
	<c:if test="${pwd_error=='error'}">
		alert("비밀번호가 틀립니다.");
	</c:if>
	
});


</script>
</head>
<body>

	<%@include file="../c_common/header.jsp"%>

	<div class="left_menu">
		<div class="left_menu_title">
			<h2>마이 페이지</h2>
		</div>
		<div class="left_menu_content">
			<ul class="left_menu_contents">
				<li><a href="showScheduleInfo.f_mypage?f_num=${client.f_num}">일정 관리</a></li>
				<li><a href="/Matching_Project/f_mypage/accountingManager.jsp?f_num=${client.f_num}">회계 관리</a></li>
				<li><a href="showFreelancerInfo.f_mypage?f_num=${client.f_num}">내 정보</a></li>
			</ul>
		</div>
	</div>

	<section id="firstsection">

	<ul id="tabs">
		<li><a href="#" title="tab1">내 정보</a></li>
		<li><a href="#" title="tab2">이력 정보</a></li>
		<li><a href="#" title="tab3">지원내역</a></li>
		<li><a href="#" title="tab4">히스토리</a></li>
	</ul>

	<div id="content">
		
		<div id="tab1">
			<form name="updateForm" method="post" action="updateInfo" onsubmit="return check();">
			<input type="text" name="f_num" value="${client.f_num}">
		 	<input type="text" id="pwd_error" name="pwd_error" value="${pwd_error}"> 
		<div class="tb_box">
				<h4>아이디 및 비밀번호</h4>
				<table class="tb_st01">
					
					<input type="hidden" name="EventUno" value="">
					<input type="hidden" name="fm_keyword" value="">
					<caption></caption>
					<colgroup>
						<col style="width: 16%">
						<col style="width: 34%">
						<col style="width: 16%">
						<col style="width: 34%">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row" class="ac"><span class="txt_or">*</span>
								회원아이디</th>
							<td colspan="3">${freelancer.f_id} </td>
						</tr>
						<tr>
							<th scope="row" class="ac"><label for="fm_passwd1"><span
									class="txt_or">*</span> 비밀번호</label></th>
							<td><input type="password" id="f_pwd" name="f_pwd"
								class="wid02"></td>
							<th scope="row" class="ac"><label for="fm_passwd2"><span
									class="txt_or">*</span> 비밀번호 확인</label></th>
							<td><input type="password" id="f_pwd2" name="f_pwd2"
								class="wid02"></td>
						</tr>
					</tbody>
				</table>
			</div>

			 <div class="tb_box">
				<div class="ct overf">
					<h4 class="fl">개인정보</h4>
				</div>
				<table class="tb_st01">
					<caption></caption>
					<colgroup>
						<col style="width: 16%">
						<col style="width: 17%">
						<col style="width: 20%">
						<col style="width: 16%">
						<col style="width: *">
					</colgroup>
					<tbody>
						<tr>
							<td rowspan="4">
							
								<img name="IMG1" id="IMG1" >
								<!-- <p>
								<input type="file" name="f_fname"> -->
									<!-- <div class="filebox"></div>
									<div class="filebutton"><span>사진업로드</span><input type="file" name="fm_file1" onchange="PreView(this.value, 'IMG1', '132', '176');" class="searchfile" title="파일 찾기" style="width:820px;"></div>
									<div class="filebutton"><span>사진업로드</span><input type="file" name="fm_file1" onchange="readURL(this);" class="searchfile" title="파일 찾기" style="width:820px;"></div>
								 -->
                                <!-- <span class="pho_txt">최적 해상도:132x176 pixel</span> --> 
								<!-- 사진업로드</p> -->
							</td>
							<th scope="row"><label for="fm_korname"><span
									class="txt_or">*</span> 성명</label></th>
							<td colspan="3"><input type="text" id="f_name"
								name="f_name" class="wid04" value="${freelancer.f_name}"></td>
						</tr>
						<tr>
							<th scope="row"><label for=""><span class="txt_or">*</span>
									생년월일</label></th>
							<td colspan="3"><input type="text" id="f_birth"
								name="f_birth" class="wid04" maxlength="6" value="${freelancer.f_birth}">
								<span> - </span> 
								
								<select name="f_sex" id="f_sex">
								<c:choose>
									<c:when test="${freelancer.f_sex == '남'}">
									<option value="1" selected="">남자</option>
									<option value="2">여자</option>
									</c:when>
									
									<c:when test="${freelancer.f_sex == '여'}">
									<option value="1" >남자</option>
									<option value="2" selected="">여자</option>
									</c:when>
								</c:choose>
									
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="fm_tel1"><span
									class="txt_or">*</span> 연락처(전화)</label></th>
							<td colspan="3"><label for="fm_tel1"></label> 
							<select class="wid03" name="fm_tel1" id="fm_tel1">
									<option value="">--------</option>
									<option value="02" <c:if test="${ph1 == '02'}">selected</c:if>>02</option>
									<option value="031" <c:if test="${ph1 == '031'}">selected</c:if>>031</option>
									<option value="032" <c:if test="${ph1 == '032'}">selected</c:if>>032</option>
									<option value="033" <c:if test="${ph1 == '033'}">selected</c:if>>033</option>
									<option value="041" <c:if test="${ph1 == '041'}">selected</c:if>>041</option>
									<option value="042" <c:if test="${ph1 == '042'}">selected</c:if>>042</option>
									<option value="043" <c:if test="${ph1 == '043'}">selected</c:if>>043</option>
									<option value="051" <c:if test="${ph1 == '051'}">selected</c:if>>051</option>
									<option value="052" <c:if test="${ph1 == '052'}">selected</c:if>>052</option>
									<option value="053" <c:if test="${ph1 == '053'}">selected</c:if>>053</option>
									<option value="054" <c:if test="${ph1 == '054'}">selected</c:if>>054</option>
									<option value="055" <c:if test="${ph1 == '055'}">selected</c:if>>055</option>
									<option value="061" <c:if test="${ph1 == '061'}">selected</c:if>>061</option>
									<option value="062" <c:if test="${ph1 == '062'}">selected</c:if>>062</option>
									<option value="063" <c:if test="${ph1 == '063'}">selected</c:if>>063</option>
									<option value="064" <c:if test="${ph1 == '064'}">selected</c:if>>064</option>
									<option value="070" <c:if test="${ph1 == '070'}">selected</c:if>>070</option>
									<option value="">--------</option>
									<option value="0502" <c:if test="${ph1 == '0502'}">selected</c:if>>0502</option>
									<option value="0504" <c:if test="${ph1 == '0504'}">selected</c:if>>0504</option>
									<option value="0505" <c:if test="${ph1 == '0505'}">selected</c:if>>0505</option>
									<option value="0506" <c:if test="${ph1 == '0506'}">selected</c:if>>0506</option>
									<option value="0130" <c:if test="${ph1 == '0130'}">selected</c:if>>0130</option>
							</select>
							<span>-</span> 
							<label for="fm_tel2"></label> 
							<input type="text" id="fm_tel2" name="fm_tel2" maxlength="4" class="wid03" value="${ph2}">
							<span>-</span> 
							<label for="fm_tel3"></label> 
							<input type="text" id="fm_tel3" name="fm_tel3" maxlength="4" class="wid03" value="${ph3}">
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="fm_phone1"><span
									class="txt_or">*</span> 연락처(핸드폰)</label></th>
							<td colspan="3"><label for="fm_phone1"></label> <select
								class="wid03" name="fm_phone1" id="fm_phone1">
									<option value="">--------</option>
									<option value="010" <c:if test="${hph1 == '010'}">selected</c:if>>010</option>
									<option value="011" <c:if test="${hph1 == '011'}">selected</c:if>>011</option>
									<option value="016" <c:if test="${hph1 == '016'}">selected</c:if>>016</option>
									<option value="017" <c:if test="${hph1 == '017'}">selected</c:if>>017</option>
									<option value="018" <c:if test="${hph1 == '018'}">selected</c:if>>018</option>
									<option value="019" <c:if test="${hph1 == '019'}">selected</c:if>>019</option>
							</select> <span>-</span> <label for="fm_phone2"></label> <input
								type="text" id="fm_phone2" name="fm_phone2" maxlength="4"
								class="wid03" value="${hph2}">
								 <span>-</span> <label
								for="fm_phone3"></label> <input type="text" id="fm_phone3"
								name="fm_phone3" maxlength="4" class="wid03" value="${hph3}">
							</td>
						</tr>
						<tr>
							<th><span class="txt_or">*</span> 이메일</th>
							<td colspan="4"><label for="fm_email11"></label> <input
								type="text" id="fm_email11" name="fm_email11" class="wid04"
								value="${email1}"> <span>@</span> <label
								for="fm_email12"></label> 
								<input type="text" id="fm_email12" name="fm_email12" class="wid04" value="${email2}" readonly="">
								<label for="fm_emailSel1"></label> 
								<select class="wid04" name="fm_emailSel1" id="fm_emailSel1">
									<option value="선택해주세요">선택해주세요.</option>
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
							<th><span class="txt_or">*</span> 주소</th>
							<td colspan="4">
								<div class="mb10">
									<label for="fm_zip"></label> 
									<input type="text" id="fm_zip" name="fm_zip" class="wid60"
										title="주소검색 새창" value="${address1}" readonly=""> 
									<input type = "button" onClick = "openDaumZipAddress()" value = "주소 찾기" />
 
								</div>
								<div>
									<label for="fm_address"></label> <input type="text"
										id="fm_address" name="fm_address" class="wid"
										value="${address2}"><input type="text"
										id="fm_address_etc" name="fm_address_etc" class="wid"
										value="${address3}">
								</div>
							</td>
						</tr>
						<tr>
							<th><span class="txt_or">*</span> 내가 받은 평가</th>
							<td colspan="4">
								<p class="star_rating">
									<input type="hidden" id="hiddenscore" value="${freelancer.f_score}">
									<a id="first">★ </a>
									<a id="second">★ </a>
									<a id="third">★ </a>
									<a id="fourth">★ </a>
									<a id="fifth">★</a>
								</p>
							</td>
						</tr>
					</tbody>
				</table>
			</div> 

			<%-- <div class="tb_box">
				<h4>현황정보</h4>
				<table class="tb_st01">
					<caption></caption>
					<colgroup>
						<col style="width: 14%">
						<col style="width: *">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 15%">
					</colgroup>
					<tbody>
						<tr class="line_bottom">
							<th scope="row" rowspan="3" class="ac"><span class="txt_or">*</span>기본분야</th>
							<th scope="row" class="ac"><span class="txt_or">*</span>개발</th>
							<td colspan="5" style="border-bottom: solid 1px #dadada"
								bgcolor="#ffffff">

								<table width="100%">
									<colgroup>
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="20%">
									</colgroup>
									<tbody>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="1"> .NET</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="2"> ABAP</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="3"> ANDROID</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="4"> ASP</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="5"> ASP.NET</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="6"> C</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="7"> C#</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="8"> C++</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="9"> COBOL</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="10"> CSS</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="11"> DB</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="12"> DELPHI</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="13"> HTML</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="14"> IOS</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="15">	JAVA</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="16"> JS</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="17"> JSP</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="18"> LINUX</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="19"> NETWORK</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="20"> PHP</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="21"> POWER
												BUILDER</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="22"> PYTHON</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="23"> QA</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="24"> RUBY</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="25"> SERVER개발</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="26"> VB</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="27"> VC++</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="28"> WINDOWS</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="29"> 임베디드</td>
											<td class="td_bor_bott">&nbsp;</td>
										</tr>
									</tbody>
								</table> <!--img src="../img/sb_category.gif" width="87" height="18" align="absmiddle"-->
							</td>
						</tr>
						<tr class="line_bottom">
							<th scope="row" class="ac"><span class="txt_or">*</span>디자인/퍼블리싱</th>
							<td colspan="5" style="border-bottom: solid 1px #dadada"
								bgcolor="#ffffff">

								<table width="100%">
									<colgroup>
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="20%">
									</colgroup>
									<tbody>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="30"> HTML5</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="31"> 그래픽디자인</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="32"> 모바일</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="33"> 액션스크립트</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="34"> 웹디자인</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="35"> 웹표준</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="36"> 파워포인트</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="37"> 퍼블리싱</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="38"> 포토샵편집</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="39"> 플래시</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="40"> 3D</td>
											<td class="td_bor_bott">&nbsp;</td>
											<td class="td_bor_bott">&nbsp;</td>
											<td class="td_bor_bott">&nbsp;</td>
											<td class="td_bor_bott">&nbsp;</td>
										</tr>
									</tbody>
								</table> <!--img src="../img/sb_category.gif" width="87" height="18" align="absmiddle"-->
							</td>
						</tr>
						<tr class="line_bottom" id="last_table">
							<th scope="row" class="ac"><span class="txt_or">*</span>기획/컨설턴트</th>
							<td colspan="5" style="border-bottom: solid 1px #dadada"
								bgcolor="#ffffff">

								<table width="100%">
									<colgroup>
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="20%">
									</colgroup>
									<tbody>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="41">
												Oracle컨설턴트</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="42"> PM</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="43"> PMO</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="44"> SAP컨설턴트</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="45"> 기획</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="46"> 모바일기획</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="47"> 웹기획</td>
											<td class="td_bor_bott">&nbsp;</td>
											<td class="td_bor_bott">&nbsp;</td>
											<td class="td_bor_bott">&nbsp;</td>
										</tr>
									</tbody>
								</table> <!--img src="../img/sb_category.gif" width="87" height="18" align="absmiddle"-->
							</td>
						</tr>

					</tbody>
				</table>
			</div> --%>
			<div class="btn_box mb30 mb02">
				<input type="submit" value="수정하기">
				<input type="reset" value="초기화">
			</div>
			</form>
		</div>

			
		<div id="tab2">
			<div class="tb_box">
				<div class="ct overf">
					<h4 class="fl myfl">경력사항</h4>
						<button id="add" class="career_add" onclick="addCareer();">추가하기</button>
				</div>
				<table class="tb_st01 tb_st03">
					<caption></caption>
					<colgroup>
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 25%">
						<col style="width: 15%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="ac">회사명</th>
							<th scope="col" class="ac">근무부서</th>
							<th scope="col" class="ac">직위</th>
							<th scope="col" class="ac">근무기간</th>
							<th scope="col" class="ac">소재지</th>
							<th scope="col" class="last ac">관리</th>
						</tr>
						
					</thead>
					<tbody>
					<c:if test="${careercheck == 0}">
							<tr><td colspan="5">등록된 경력사항이 없습니다.</td></tr>
					</c:if>
				
						<c:forEach var="mycareer" items="${career}">
						<form id="careerForm${mycareer.career_num}" name="mycareerModify${mycareer.career_num}" method="post" action="/Matching_Project/f_mypage/careerModify.jsp" target='popup_window'>
						<input type="text" hidden name="mycareer_career_num" value="${mycareer.career_num}">
						<input type="text" hidden name="mycareer_company" value="${mycareer.company}">
						<input type="text" hidden name="mycareer_dept" value="${mycareer.dept}">
						<input type="text" hidden name="mycareer_rank" value="${mycareer.rank}">
						<input type="text" hidden name="mycareer_career_term" value="${mycareer.career_term}">
						<input type="text" hidden name="mycareer_career_location" value="${mycareer.career_location}">
						<tr>							
							<td>${mycareer.company}</td>
							<td>${mycareer.dept}</td>
							<td>${mycareer.rank}</td>
							<td>${mycareer.career_term}</td>
							<td>${mycareer.career_location}</td>
							<td class="last"><input type="button" value="수정" onclick="modifyCareer(${mycareer.career_num});">&nbsp;&nbsp;<input
								type="button" value="삭제" onclick="deleteCareer(${mycareer.career_num});"></td>

						</tr>
						</form>
					</c:forEach>
					</tbody>
				</table>
				<form name="tempCareerAdd"  action="insertCareer.f_mypage">
					<input type="text" hidden name="tempf_num" value="${client.f_num}">
					<input type="text" hidden name="company">
					<input type="text" hidden name="dept">
					<input type="text" hidden name="rank">
					<input type="text" hidden name="term">
					<input type="text" hidden name="location">
				</form>
				<form name="tempCareerModify"  action="updateCareer.f_mypage">
					<input type="text" hidden name="career_num">
					<input type="text" hidden name="company">
					<input type="text" hidden name="dept">
					<input type="text" hidden name="rank">
					<input type="text" hidden name="term">
					<input type="text" hidden name="location">
				</form>
				<form name="tempCareerDelete" action="deleteCareer.f_mypage">
					<input type="text" hidden name="deleteCareer_num">
				</form>

				<div id="ResumePANNEL3"
					style="position: fixed; top: 0; left: 0; width: 100%; height: 100%; z-index: 999; background: url(../../images/popup/bg_popup.png) repeat; text-align: center; z-index: 5; display: none;">
					<form method="post" name="ResumeFrame3" style="display: inline;"
						onsubmit="return false;">
						<input type="hidden" name="seluno" value="">
						<iframe id="ResumeiFrame3" name="ResumeiFrame3" frameborder="0"
							scrolling="no"
							style="height: 631px; width: 804px; position: absolute; top: 20%; left: 50%; margin: 0 -420px"></iframe>
					</form>
				</div>
			</div>
			<div class="tb_box">
				<div class="ct overf">
					<h4 class="fl myfl">학력사항</h4>
					<button id="add" class="school_add" onclick="addSchool();">추가하기</button>
				</div>
				<table class="tb_st01 tb_st03">
					<caption></caption>
					<colgroup>
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 25%">
						<col style="width: 15%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="ac">학교명</th>
							<th scope="col" class="ac">전공</th>
							<th scope="col" class="ac">기간</th>
							<th scope="col" class="ac">소재지</th>
							<th scope="col" class="last ac">관리</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${schoolcheck == 0}">
							<tr><td colspan="5">등록된 학력사항이 없습니다.</td></tr>
					</c:if>
						<c:forEach var="myschool" items="${school}">
						<form id="schoolForm${myschool.school_num}" name="myschoolModify${myschool.school_num}" method="post" action="/Matching_Project/f_mypage/schoolModify.jsp" target='popup_window'>
						<input type="text" hidden name="myschool_school_num" value="${myschool.school_num}">
						<input type="text" hidden name="myschool_school_name" value="${myschool.school_name}">
						<input type="text" hidden name="myschool_major" value="${myschool.major}">
						<input type="text" hidden name="myschool_school_term" value="${myschool.school_term}">
						<input type="text" hidden name="myschool_school_location" value="${myschool.school_location}">
						<tr>							
							<td>${myschool.school_name}</td>
							<td>${myschool.major}</td>
							<td>${myschool.school_term}</td>
							<td>${myschool.school_location}</td>
							<td class="last">
							<input type="button" value="수정" onclick="modifySchool(${myschool.school_num});">&nbsp;&nbsp;
							<input type="button" value="삭제" onclick="deleteSchool(${myschool.school_num});"></td>
						</tr>
						</form>
					</c:forEach>

					</tbody>
				</table>
				<form name="tempSchoolAdd"  action="insertSchool.f_mypage">
					<input type="text" hidden name="tempf_num" value="${client.f_num}">
					<input type="text" hidden name="school_name">
					<input type="text" hidden name="major">
					<input type="text" hidden name="term">
					<input type="text" hidden name="location">
				</form>
				<form name="tempSchoolModify"  action="updateSchool.f_mypage">
					<input type="text" hidden name="school_num">
					<input type="text" hidden name="school_name">
					<input type="text" hidden name="major">
					<input type="text" hidden name="term">
					<input type="text" hidden name="location">
				</form>
				<form name="tempSchoolDelete" action="deleteSchool.f_mypage">
					<input type="text" hidden name="deleteSchool_num">
				</form>

				<div id="ResumePANNEL1"
					style="position: fixed; top: 0; left: 0; width: 100%; height: 100%; z-index: 999; background: url(../../images/popup/bg_popup.png) repeat; text-align: center; z-index: 5; display: none;">
					<form method="post" name="ResumeFrame1" onsubmit="return false;">
						<input type="hidden" name="seluno" value="">
						<iframe id="ResumeiFrame1" name="ResumeiFrame1" frameborder="0"
							scrolling="no"
							style="height: 498px; width: 804px; position: absolute; top: 20%; left: 50%; margin: 0 -420px"></iframe>
					</form>
				</div>
			</div>

			<div class="tb_box">
				<div class="ct overf">
					<h4 class="fl myfl">자격증</h4>
					<button id="add" class="right_add" onclick="addCerti();">추가하기</button>
				</div>
				<table class="tb_st01 tb_st03">
					<caption></caption>
					<colgroup>
						<col style="width: 40%">
						<col style="width: 20%">
						<col style="width: 25%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="ac">자격증명</th>
							<th scope="col" class="ac">발행처</th>
							<th scope="col" class="ac">취득일자</th>
							<th scope="col" class="last ac">관리</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${certificatecheck == 0}">
							<tr><td colspan="5">등록된 자격사항이 없습니다.</td></tr>
					</c:if>
					<c:forEach var="mycerti" items="${certificate}">
						<form id="certiForm${mycerti.certificate_num}" name="mycertiModify${mycerti.certificate_num}" method="post" action="/Matching_Project/f_mypage/certiModify.jsp" target='popup_window'>
						<input type="text" hidden name="mycerti_certi_num" value="${mycerti.certificate_num}">
						<input type="text" hidden name="mycerti_certi_name" value="${mycerti.certificate_name}">
						<input type="text" hidden name="mycerti_organization" value="${mycerti.organization}">
						<input type="text" hidden name="mycerti_accept_date" value="${mycerti.accept_date}">
						<tr>							
			
							<td>${mycerti.certificate_name}</td>
							<td>${mycerti.organization}</td>
							<td>${mycerti.accept_date}</td>
							<td class="last"><input type="button" value="수정" onclick="modifyCerti(${mycerti.certificate_num});">&nbsp;&nbsp;<input
								type="button" value="삭제" onclick="deleteCerti(${mycerti.certificate_num});"></td>

						</tr>
						</form>
					</c:forEach>

					</tbody>
				</table>
				<form name="tempCertiAdd"  action="insertCerti.f_mypage">
					<input type="text" hidden name="tempf_num" value="${client.f_num}">
					<input type="text" hidden name="certi_name">
					<input type="text" hidden name="organization">
					<input type="text" hidden name="accept_date">
				</form>
				<form name="tempCertiModify"  action="updateCerti.f_mypage">
					<input type="text" hidden name="certi_num">
					<input type="text" hidden name="certi_name">
					<input type="text" hidden name="organization">
					<input type="text" hidden name="accept_date">
					
				</form>
				<form name="tempCertiDelete" action="deleteCerti.f_mypage">
					<input type="text" hidden name="deleteCerti_num">
				</form>

				<div id="ResumePANNEL5"
					style="position: fixed; top: 0; left: 0; width: 100%; height: 100%; z-index: 999; background: url(../../images/popup/bg_popup.png) repeat; text-align: center; z-index: 5; display: none;">
					<form method="post" name="ResumeFrame5" style="display: inline;"
						onsubmit="return false;">
						<input type="hidden" name="seluno" value="">
						<iframe id="ResumeiFrame5" name="ResumeiFrame5" frameborder="0"
							scrolling="no"
							style="height: 602px; width: 804px; position: absolute; top: 20%; left: 50%; margin: 0 -420px"></iframe>
					</form>
				</div>
				<div>
					<div class="ct overf">
						<h4 class="fl myfl">포트폴리오</h4>
						<button id="add" class="portFolio_add">추가하기</button>
					</div>
					<table class="tb_st01 tb_st03">
						<caption></caption>
						<colgroup>
							<col style="width: 60%">
							<col style="width: 25%">
							<col style="width: 15%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col" class="ac">포트폴리오 내용</th>
								<th scope="col" class="ac">첨부파일</th>
								<th scope="col" class="ac">관리</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td>어쩌구저쩌구</td>
								<td>file.zip</td>
								<td class="last".><input type="button" value="수정">&nbsp;&nbsp;<input
									type="button" value="삭제"></td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div id="tab3">
			<h4>내가 지원한 프로젝트</h4>
			<table class="tb_st01 tb_st03">
				<caption></caption>
				<colgroup>
					<col style="width: 40%">
					<col style="width: 15%">
					<col style="width: 15%">
					<col style="width: 15%">
					<col style="width: 15%">
				</colgroup>
				<thead>
					<tr>
						<th scope="col" class="ac">프로젝트 이름</th>
						<th scope="col" class="ac">담당자 연락처</th>
						<th scope="col" class="ac">신청일자</th>
						<th scope="col" class="ac">기업 수락여부</th>
						<th scope="col" class="ac">관리</th>
					</tr>
				</thead>

				<tbody>
					<c:if test="${applyprojectcheck == 0}">
							<tr><td colspan="5">지원한 내역이 없습니다.</td></tr>
					</c:if>
					
					<c:forEach var="myApplyProject" items="${applyproject}">
						
						 <form method="post" action="deleteApplyProject.f_mypage">
						 <input type="text" hidden name="f_pr_num" value="${myApplyProject.f_pr_num}">
						 <tr>							
							<td>${myApplyProject.p_name}</td>
							<td>${myApplyProject.manager_hphone}</td>
							<td>${myApplyProject.f_pr_date}</td>
							<td>${myApplyProject.state}</td>
							<td class="last"><input type="submit" value="지원 취소"></td>
						</tr>
						</form>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div id="tab4">
			<h4>내가 완료한 프로젝트</h4>
			<table class="tb_st01 tb_st03">
				<caption></caption>
				<!-- 	<colgroup>
				<col style="width: 20%">
				<col style="width: 14%">
				<col style="width: 14%">
				<col style="width: *">
				<col style="width: 15%">
				<col style="width: 15%">
			</colgroup> -->
				<thead>
					<tr>
						<th scope="col" class="ac">프로젝트명</th>
						<th scope="col" class="ac">프로젝트 기간</th>
						<th scope="col" class="ac">예산</th>
						<th scope="col" class="ac">관련기술</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td class="ac" colspan="6">등록된 히스토리 정보가 없습니다.</td>
					</tr>

				</tbody>
			</table>


		</div>

	</div>


	</section>

	<%@include file="../c_common/footer.jsp"%>

</body>
</html>