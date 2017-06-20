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

<link rel="stylesheet" href="/resources/c_freelancerlist_css/myInfo.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/c_freelancerlist_css/join.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/c_freelancerlist_css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/c_projectlist_css/c_projectInfo.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/c_freelancerlist_css/complete.css" type="text/css" media="screen" />
<title>프리랜서 정보</title>

<!-- <script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script> -->
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>

<!-- <script type="text/javascript" src="f_mypage_js/myInfo.js"></script>
<script type="text/javascript" src="f_mypage_js/my.js"></script> -->
<script src="${pageContext.request.contextPath}/c_common/c_common_js/header.js"></script>
<script src="${pageContext.request.contextPath}/resources/f_mypage_js/myInfo.js"></script> 
<script src="${pageContext.request.contextPath}/resources/f_mypage_js/my.js"></script>

<script type="text/javascript" src="/resources/e_mypage_js/e_projectInfo.js"></script>
<script type="text/javascript" src="/resources/c_freelancerlist_js/freelancerlist.js"></script>

 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
$(function(){
	var checks = document.getElementsByName("fm_new_keyword[]");

	var arr = new Array();

	<c:forEach var="item" items="${f_job}">
		arr.push("${item}");
	</c:forEach>
	console.log(arr[0]);
	for(var i=0; i<arr.length; i++){
			checks[arr[i]-1].checked = true;
	}
	
});
/* 
var message = '${msg}';
var returnUrl = '${url}';
alert("이미 제안한 프로젝트입니다.");
document.location.href = url; */


</script>
</head>
<body>

	<%@include file="../c_common/header.jsp"%>
	
	<div id="conainer">
		<div id="nav">
			<div class="nav_txt">
				<p>
					<a href="/e_lan/index.php">Home</a>
					 <span class="padd">&gt;</span>
					<span>프리랜서 목록</span>
					 <span class="padd">&gt;</span>
					<span>프리랜서 상세보기</span>
				</p>
			</div>
		</div>
		
	<section id="firstsection">
	<form method="get" action="/c_freelancerlist/f_complete" name="ProjectWriteFm">
				 <input type="hidden" class="sub_f_num" name="f_num" value="${freelancer.f_num }"></input> 
					 

	<ul id="tabs">
		<li><a href="#" title="tab1">프리랜서 정보</a></li>
		<li><a href="#" title="tab2">이력 정보</a></li>
		<li><a href="#" title="tab3">포트폴리오</a></li>
		<li><a href="#" title="tab4">히스토리</a></li>
	</ul>

	<div id="content">
		
		<div id="tab1">
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
							<td colspan="3">${freelancer.f_name }</td>
						</tr>
						<tr>
							<th scope="row"><label for=""><span class="txt_or">*</span>
									생년월일</label></th>
							<td colspan="3">${freelancer.f_birth }</td>
						</tr>
						<tr>
							<th scope="row"><label for="fm_tel1"><span
									class="txt_or">*</span> 연락처(전화)</label></th>
							<td colspan="3"><label for="fm_tel1"></label> 
							${ph1}
							<span>-</span> 
							<label for="fm_tel2"></label> 
							${ph2}
							<span>-</span> 
							<label for="fm_tel3"></label> 
							${ph3}
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="fm_phone1"><span
									class="txt_or">*</span> 연락처(핸드폰)</label></th>
							<td colspan="3"><label for="fm_phone1"></label>
						${hph1}
							 <span>-</span> <label for="fm_phone2"></label>${hph2}
								 <span>-</span> <label
								for="fm_phone3"></label> ${hph3}
							</td>
						</tr>
						<tr>
							<th><span class="txt_or">*</span> 이메일</th>
							<td colspan="4"><label for="fm_email11"></label> ${email1}<span>@</span><label
								for="fm_email12"></label>${email2}</td>
						</tr>
						<tr>
							<th><span class="txt_or">*</span> 주소</th>
							<td colspan="4">
								<div>
									<label for="fm_address"></label> ${address2} ${address3}
								</div>
							</td>
						</tr>
						<%-- <tr>
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
						</tr> --%>
					</tbody>
				</table>
			</div> 

			 <div class="tb_box">
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
			</div> 

		</div>

			
		<div id="tab2">
			<div class="tb_box">
				<div class="ct overf">
					<h4 class="fl myfl">경력사항</h4>
				</div>
				<table class="tb_st01 tb_st03">
					<caption></caption>
					<colgroup>
						<col style="width: 15%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 25%">
						<col style="width: 15%">
						<col style="width: 10%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="ac">회사명</th>
							<th scope="col" class="ac">근무부서</th>
							<th scope="col" class="ac">직위</th>
							<th scope="col" class="ac">근무기간</th>
							<th scope="col" class="ac">소재지</th>
							<th scope="col" class="last ac">근속년수</th>
						</tr>
						
					</thead>
					<tbody>
					<c:if test="${careercheck == 0}">
							<tr><td colspan="5">등록된 경력사항이 없습니다.</td></tr>
					</c:if>
				
						<c:forEach var="mycareer" items="${career}">
						<input type="text" hidden name="career_num" value="${mycareer.career_num}">
						<input type="text" hidden name="company" value="${mycareer.company}">
						<input type="text" hidden name="dept" value="${mycareer.dept}">
						<input type="text" hidden name="rank" value="${mycareer.rank}">
						<input type="text" hidden name="career_term" value="${mycareer.career_term}">
						<input type="text" hidden name="career_location" value="${mycareer.career_location}">
						<input type="text" hidden name="career_year" value="${mycareer.career_year}">
						<tr>							
							<td>${mycareer.company}</td>
							<td>${mycareer.dept}</td>
							<td>${mycareer.rank}</td>
							<td>${mycareer.career_term}</td>
							<td>${mycareer.career_location}</td>
							<td class="last">${mycareer.career_year}</td>
							
						</tr>
					
					</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="tb_box">
				<div class="ct overf">
					<h4 class="fl myfl">학력사항</h4>
				</div>
				<table class="tb_st01 tb_st03">
					<caption></caption>
					<colgroup>
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 25%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="ac">학교명</th>
							<th scope="col" class="ac">전공</th>
							<th scope="col" class="ac">기간</th>
							<th scope="col" class="ac">소재지</th>
							<th scope="col" class="last ac">학위</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${schoolcheck == 0}">
							<tr><td colspan="5">등록된 학력사항이 없습니다.</td></tr>
					</c:if>
						<c:forEach var="myschool" items="${school}">
						<input type="text" hidden name="myschool_school_num" value="${myschool.school_num}">
						<input type="text" hidden name="myschool_school_name" value="${myschool.school_name}">
						<input type="text" hidden name="myschool_major" value="${myschool.major}">
						<input type="text" hidden name="myschool_school_term" value="${myschool.school_term}">
						<input type="text" hidden name="myschool_school_location" value="${myschool.school_location}">
						<input type="text" hidden name="myschool_school_degree" value="${myschool.school_degree}">
						<tr>							
							<td>${myschool.school_name}</td>
							<td>${myschool.major}</td>
							<td>${myschool.school_term}</td>
							<td>${myschool.school_location}</td>
							<td class="last">${myschool.school_degree}</td>
						</tr>
						
					</c:forEach>

					</tbody>
				</table>
				
			</div>

			<div class="tb_box">
				<div class="ct overf">
					<h4 class="fl myfl">자격증</h4>
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
							<th scope="col" class="last ac">취득일자</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${certificatecheck == 0}">
							<tr><td colspan="5">등록된 자격사항이 없습니다.</td></tr>
					</c:if>
					<c:forEach var="mycerti" items="${certificate}">
						<input type="text" hidden name="mycerti_certi_num" value="${mycerti.certificate_num}">
						<input type="text" hidden name="mycerti_certi_name" value="${mycerti.certificate_name}">
						<input type="text" hidden name="mycerti_organization" value="${mycerti.organization}">
						<input type="text" hidden name="mycerti_accept_date" value="${mycerti.accept_date}">
						<tr>							
			
							<td>${mycerti.certificate_name}</td>
							<td>${mycerti.organization}</td>
							<td class="last">${mycerti.accept_date}</td>
						</tr>
						
					</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

		<div id="tab3">
		
		<div class="tb_box">
					<div class="ct overf">
						<h4 class="fl myfl">포트폴리오</h4>
					</div>
					<table class="tb_st01 tb_st03">
						<colgroup>
							<col style="width: 60%">
							<col style="width: 25%">
							<col style="width: 15%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col" class="ac">포트폴리오 내용</th>
								<th scope="col" class="last ac">첨부파일</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${portfoliocheck == 0}">
								<tr><td colspan="5">등록된 포트폴리오가 없습니다.</td></tr>
							</c:if>
							
							<c:forEach var="myport" items="${portfolio}">
							<form id="portForm${myport.portfolio_num}" name="myportModify${myport.portfolio_num}">
							<input type="text" hidden name="portfolio_num" value="${myport.portfolio_num}">
							<input type="text" hidden name="contents" value="${myport.contents}">
							<input type="text" hidden name="portfile" value="${myport.portfile}">
							<input type="text" hidden name="portfile_iden" value="${myport.portfile_iden}">							
							<tr>
								<td>${myport.contents}</td>
								<td><a href="/c_file/downloadFile?identy=${myport.portfile_iden}&f_num=${freelancer.f_num }&fileType=portfile">${myport.portfile}</a></td>
							</tr>
							</form>
							</c:forEach>
						</tbody>
					</table>
					</div>

		</div>


		
		<div id="tab4">
		<div class="tb_box">
			<h4>프리랜서가 완료한 프로젝트</h4>
			<table class="tb_st01 tb_st03">
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
						<th scope="col" class="last ac">관련기술</th>
					</tr>
				</thead>
				<tbody>

						<c:if test="${finishprojectcheck == 0}">
							<tr><td colspan="5">완료한 내역이 없습니다.</td></tr>
					</c:if>
					
					<c:forEach var="myFinishProject" items="${finishproject}">
						
						 <tr>							
							<td>${myFinishProject.proName}</td>
							<td>${myFinishProject.proTerm}</td>
							<td>${myFinishProject.cost}</td>
							<td class="last">${myFinishProject.p_job}</td>
						</tr>
						
					</c:forEach>

				</tbody>
			</table>
			</div>


		</div>


	</div>
	
	<div id="project">
		<input id="checkValue"  class="btn btn-lg btn-client js-disable-on-click btn-submit" autocomplete="off" data-loading-text="제출 중" name="post_a_job"
					 value="제안할 프로젝트 선택 ▼" type="button">
		</div>
		<!-- //tb_box : e -->
			<div class="btn_box">
					 <br>
						
						
					<br>
					<br>
					<br>
					<br>
				</div>
			</div>
			</div>
			
				
		</form>

	</section>

	<%@include file="../c_common/footer.jsp"%>

</body>
</html>