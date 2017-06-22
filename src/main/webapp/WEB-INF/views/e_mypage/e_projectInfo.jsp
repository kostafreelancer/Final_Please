<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/e_mypage_css/e_projectInfo.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/e_mypage_css/e_leftmenu.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/e_mypage_css/memberlist.css"
	type="text/css" media="screen" />

<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="/resources/e_mypage_js/tabs.js"></script>
<script type="text/javascript" src="/resources/e_mypage_js/e_projectInfo.js"></script>

<title>Insert title here</title>
<script type="text/javascript">
$(function(){
   var check = document.getElementsByName("check");

   var arr = new Array();

   <c:forEach var="item" items="${p_job}">
      arr.push("${item}");
   </c:forEach>

   for(var i=0; i<arr.length; i++){
         check[arr[i]-1].checked = true;
   }
});
</script>
</head>

<body>
<%@include file="../c_common/header.jsp"%>

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

	<!-- //header_wrap : e -->
	<div id="conainer">
		<div id="nav">
			<div class="nav_txt">
				<p>
					<a href="#">Home</a> <span class="padd">&gt;</span>
					<span>프로젝트 상세</span>
				</p>
			</div>
		</div>


		<div id="content">
			<div class="tit_box">
				<h2>${project.p_name }</h2>
			</div>

			<div class="table_tit">
				<h3>프로젝트 상세내용</h3>
			</div>
			<!-- table_tit : e -->

			<div class="tb_box">
				<h4>담당자 정보</h4>
				<table class="tb_st01">
					<colgroup>
						<col style="width: 15%" />
						<col style="width: 35%" />
						<col style="width: 15%" />
						<col style="width: 35%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row"><span class="txt_or">*</span><label
								for="fm_comname">회사명</label></th>
							<td colspan="3">${client.e_ename }</td>
						</tr>
						<tr>
							<th scope="row"><span class="txt_or">*</span> <label
								for="fm_korname">담당자명</label></th>
							<td colspan="3">${client.manager_name }</td>
						</tr>
						<tr>
							<th scope="row"><span class="txt_or">*</span> 담당자 휴대폰</th>
							<td>${manager_hphone_1 } <span>-</span>${manager_hphone_2 }<span>-</span> ${manager_hphone_3 }</td>
						</tr>
						<tr>
							<th scope="row"><span class="txt_or">*</span> 담당자 이메일</th>
							<td colspan="3">${manager_mail_1 }@${manager_mail_2 }</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- //tb_box : e -->

			<div class="tb_box">
				<h4>프로젝트 키워드</h4>
				<table class="tb_st01">
					<caption></caption>
					<colgroup>
						<col style="width: 13%" />
						<col style="width: 16%" />
						<col style="width: 17%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 16%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span><label
								for="fm_name">프로젝트 명</label></th>
							<td colspan="5">${project.p_name }</td>
						</tr>
						<tr>
							<th scope="row" rowspan="3" class="ac"><span class="txt_or">*</span>기본분야</th>
							<th scope="row" class="ac"><span class="txt_or"></span>개발</th>
							<td colspan="5" style="border-bottom: solid 0px #dadada"
								bgcolor="#ffffff">

								<table width="100%">
									<colgroup>
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
									</colgroup>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="1"> .NET</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="2"> ABAP</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="3"> ANDROID</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="4"> ASP</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="5"> ASP.NET</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="6"> C</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="7"> C#</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="8"> C++</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="9"> COBOL</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="10"> CSS</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="11"> DB</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="12"> DELPHI</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="13"> HTML</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="14"> IOS</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="15"> JAVA</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="16"> JS</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="17"> JSP</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="18"> LINUX</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="19"> NETWORK</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="20"> PHP</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="21"> POWER
											BUILDER</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="22"> PYTHON</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="23"> QA</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="24"> RUBY</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="25"> SERVER개발</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="26"> VB</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="27"> VC++</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="28"> WINDOWS</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="29"> 임베디드</td>
										<td class="td_bor_bott">&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr class="line_bottom" style="border-top: solid 1px #d6d6d6">
							<th scope="row" class="ac"><span class="txt_or"></span>디자인/퍼블리싱</th>
							<td colspan="5" style="border-bottom: solid 0px #dadada"
								bgcolor="#ffffff">

								<table width="100%">
									<colgroup>
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
									</colgroup>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="30"> HTML5</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="31"> 그래픽디자인</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="32"> 모바일</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="33"> 액션스크립트</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="34"> 웹디자인</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="35"> 웹표준</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="36"> 파워포인트</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="37"> 퍼블리싱</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="38"> 포토샵편집</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="39"> 플래시</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="40"> 3D</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr class="line_bottom">
							<th scope="row" class="ac"><span class="txt_or"></span>기획/컨설턴트</th>
							<td colspan="5" style="border-bottom: solid 0px #dadada"
								bgcolor="#ffffff">

								<table width="100%">
									<colgroup>
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
									</colgroup>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="41">
											Oracle컨설턴트</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="42"> PM</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="43"> PMO</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="44"> SAP컨설턴트</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="45"> 기획</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="46"> 모바일기획</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="47"> 웹기획</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>


						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span><label
								for="fm_content">상세내용</label></th>
							<td colspan="5">
							<textarea id="fm_content" name="fm_content" class="txt_area" disabled="disabled">
								${project.p_content }
							</textarea></td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
								연령</th>
							<td colspan="2">${project.p_lowerage }<span>~</span>${project.p_upperage }
							</td>
							<th scope="row" class="ac"><span class="txt_or"></span> 학력</th>
							<td colspan="2">${project.p_academic }</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
								인원</th>
							<td colspan="2">${project.p_requirenum }명</td>
							<th scope="row" class="ac"><span class="txt_or">*</span>모집마감일자</th>
							<td colspan="2">${project.p_regdate }</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>프로젝트
								금액(월단위)</th>
							<td colspan="5"><span>${project.p_lowercost }만원 ~ </span> <span>${project.p_uppercost }만원
									&nbsp;</span> <span class="txt_red">* VAT별도 금액입니다.</span></td>
						</tr>

						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>근무기간</th>
							<td colspan="5">${project.p_startdate }<span> ~ </span>${project.p_enddate }
							</td>
						</tr>

						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
								근무지</th>
							<td colspan="5">${project.p_location }
						</tr>
						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
								희망 경력년수</th>
							<td colspan="5">${project.p_experience } 년차
							</td>
						</tr>

					</tbody>
				</table>
			</div>
<c:choose>
	<c:when test="${project.project_check_state eq '승인' }">
	

			<div class="btn_box">
							
								<c:choose>
										<c:when test="${project.p_state eq '모집중' || project.p_state eq '추가모집'}">
											<span>
												<span id="contractAllExist" style="display:none;"></span>
												<input type="button" id="startProject" class="btn btn-lg btn-default2 js-disable-on-click"
													autocomplete="off" value="프로젝트 시작">
												<input type="button" id="deleteProject" class="btn btn-lg btn-default js-disable-on-click"
													autocomplete="off" value="프로젝트 삭제">
												<input class="btn btn-lg btn-default js-disable-on-click"
													autocomplete="off"  name="save_for_later"
													value="수정하기" type="submit">
											 </span>											
										</c:when>
									
										<c:when test="${project.p_state eq '진행중'}">
											<span>
												<input type="button" id="endProject" class="btn btn-lg btn-default2 js-disable-on-click"
													autocomplete="off" value="프로젝트 종료">
												<input class="btn btn-lg btn-default js-disable-on-click"
													autocomplete="off" name="save_for_later"
													value="수정하기" type="submit">
											 </span>									
										</c:when>								
								</c:choose>	

				
				<form name="startProject" action="/e_mypage/e_startProject" method="post">
					<input type="hidden" name="e_pr_numStart" value="${project.e_pr_num }">
				</form>	
				<form name="endProject" action="/e_mypage/e_endProject" method="post">
					<input type="hidden" name="e_pr_numEnd" value="${project.e_pr_num }">
				</form>
				<form name="deleteProject" action="/e_mypage/e_deleteProject" method="post">
					<input type="hidden" name="e_pr_numDelete" value="${project.e_pr_num }">
				</form>
				<form name="additionalRecruit" action="/e_mypage/e_additionalRecruit" method="post">
					<input type="hidden" name="e_pr_numAddition" value="${project.e_pr_num }">
				</form>	
			</div>


<!-- ------------------------------------------------------------------------------------------------------ -->

			<div class="table_tit">
				<h3>프리랜서 목록</h3>
			</div>

			<!-- 프리랜서 목록 -->
			<section>
			<ul id="tabs">
				<li><a href="#" title="tab1">멤버 목록</a></li>
				<li><a href="#" title="tab2">신청자 목록</a></li>
				<li><a href="#" title="tab3">참여 제안 목록</a></li>
			</ul>

			<div id="tcontent">
				<div id="tab1">
					<div class="tb_box">
						<table class="tb_st01 tb_st03">
							<colgroup>
								<col style="width: 12%">
								<col style="width: 10%">
								<col style="width: 8%">
								<col style="width: 10%">
								<col style="width: 15%">
								<col style="width: 10%">
								<col style="width: 10%">
								<col style="width: 10%">
								<col style="width: 15%">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">아이디</th>
									<th scope="col">이름</th>
									<th scope="col">성별</th>
									<th scope="col">분야</th>
									<th scope="col">연락처</th>
									<th scope="col">평점</th>
									<th scope="col" colspan="2">계약서</th>
									<th scope="col">멤버 관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="m" items="${memberList }">
										<tr>
											<td class="hidden">${m.f_num }</td>
											<td class="ac">${m.f_id}</td>
											<td class="ac">${m.f_name }</td>
											<td class="ac">${m.f_sex }</td>
											<td class="ac">${m.f_major }</td>
											<td class="ac">${m.f_hphone }</td>
											<td class="ac">${m.f_score }</td>
											<td class="ac">
												<span style="display:none;">${m.file_num }</span>
												<a href="#" class="contractFileDown">${m.original_file_name}</a>
											</td>
											<td class="ac">
												<form action="/e_mypage/e_projectInfo?e_pr_num=${project.e_pr_num }" method="post" name="contract${m.f_num }" enctype="multipart/form-data">
													<div class="filebutton">
														<span>파일찾기</span>
														<input type="file" name="contractFile" style="width: 820px;">
														<input type="hidden" name="f_num" value="${m.f_num }">
													</div>
													<div>
														<input type="submit" value="업로드">
													</div>
												</form>
											</td>
											<td class="ac"><a href="#" class="accept btn btn-lg btn-default2 js-disable-on-click">계약해지</a></td>
										</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
								<c:choose>
									<c:when test="${project.p_state eq '진행중' }">
										<div>
											<a href="" class="additional btn btn-lg btn-default2 js-disable-on-click">추가모집</a>

										</div>
									</c:when>
								</c:choose>
					<div class="num_box">
				<span class="btn_lef"> <a href="" class="first"></a>
				</span> 
							<c:if test="${pageMakerMember.prev}">
								<a
									href="/e_mypage/e_projectInfo${pageMakerMember.makeSearch(pageMakerMember.startPage - 1) }&e_pr_num=${project.e_pr_num}">&laquo;</a>
							</c:if>

							<c:forEach begin="${pageMakerMember.startPage }"
								end="${pageMakerMember.endPage }" var="idx">
								<span
								<c:out value="${pageMakerMember.cri.page == idx?'class=on':''}"/>>
									<a href="/e_mypage/e_projectInfo${pageMakerMember.makeSearch(idx)}&e_pr_num=${project.e_pr_num}">${idx}</a>
								</span>
							</c:forEach>

							<c:if test="${pageMakerMember.next && pageMakerMember.endPage > 0}">
								<li><a
									href="/e_mypage/e_projectInfo${pageMakerMember.makeSearch(pageMakerMember.endPage +1) }&e_pr_num=${project.e_pr_num}">&raquo;</a></li>
							</c:if>		
				<span class="btn_rit"> <a href="" class="last"></a>
				</span>
					</div>
				</div>



				<div id="tab2">
					<div class="tb_box">
						<table class="tb_st01 tb_st03">
							<colgroup>
								<col style="width: 15%">
								<col style="width: 10%">
								<col style="width: 10%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 10%">
								<col style="width: 25%">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">아이디</th>
									<th scope="col">이름</th>
									<th scope="col">성별</th>
									<th scope="col">분야</th>
									<th scope="col">연락처</th>
									<th scope="col">평점</th>
									<th scope="col">멤버 관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="a" items="${applicantList }">
								<c:choose>
									<c:when test="${a.c_state eq '신청거절' }">
										<tr class="rejected">
									</c:when>
									<c:otherwise>
										<tr>
									</c:otherwise>
								</c:choose>
											<td class="hidden">${a.f_num }</td>
											<td class="ac">${a.f_id}</td>
											<td class="ac">${a.f_name }</td>
											<td class="ac">${a.f_sex }</td>
											<td class="ac">${a.f_major }</td>
											<td class="ac">${a.f_hphone }</td>
											<td class="ac">${a.f_score }</td>
											<td class="ac">
								<c:choose>
									<c:when test="${a.c_state eq '신청거절' }">
										거절됨
									</c:when>
									<c:otherwise>
								<c:choose>
									<c:when test="${project.p_state eq '모집중' || project.p_state eq '추가모집'}">								
										<a href="#" class="accept btn btn-lg btn-default2 js-disable-on-click">수락</a>&nbsp;&nbsp;<a href="#" class="reject btn btn-lg btn-default2 js-disable-on-click">거절</a>
									</c:when>
								</c:choose>
									</c:otherwise>
								</c:choose>											
											
											</td>
										</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div class="num_box">
				<span class="btn_lef"> <a href="" class="first"></a>
				</span> 
							<c:if test="${pageMakerApplicant.prev}">
								<a
									href="/e_mypage/e_projectInfo${pageMakerApplicant.makeSearch(pageMakerApplicant.startPage - 1) }&e_pr_num=${project.e_pr_num}">&laquo;</a>
							</c:if>

							<c:forEach begin="${pageMakerApplicant.startPage }"
								end="${pageMakerApplicant.endPage }" var="idx">
								<span
								<c:out value="${pageMakerApplicant.cri.page == idx?'class=on':''}"/>>
									<a href="/e_mypage/e_projectInfo${pageMakerApplicant.makeSearch(idx)}&e_pr_num=${project.e_pr_num}">${idx}</a>
								</span>
							</c:forEach>

							<c:if test="${pageMakerApplicant.next && pageMakerApplicant.endPage > 0}">
								<li><a
									href="/e_mypage/e_projectInfo${pageMakerApplicant.makeSearch(pageMakerApplicant.endPage +1) }&e_pr_num=${project.e_pr_num}">&raquo;</a></li>
							</c:if>		
				<span class="btn_rit"> <a href="" class="last"></a>
				</span>
					</div>
				</div>


				<div id="tab3">
					<div class="tb_box">
						<table class="tb_st01 tb_st03">
							<colgroup>
								<col style="width: 15%">
								<col style="width: 10%">
								<col style="width: 10%">
								<col style="width: 15%">
								<col style="width: 15%">
								<col style="width: 10%">
								<col style="width: 25%">
							</colgroup>
							<thead>
								<tr>
									<th scope="col">아이디</th>
									<th scope="col">이름</th>
									<th scope="col">성별</th>
									<th scope="col">분야</th>
									<th scope="col">연락처</th>
									<th scope="col">평점</th>
									<th scope="col">멤버 관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="s" items="${scoutList }">
								<c:choose>
									<c:when test="${s.c_state eq '제안거절' }">
										<tr class="rejected">
									</c:when>
									<c:otherwise>
										<tr>
									</c:otherwise>
								</c:choose>
											<td class="hidden">${s.f_num }</td>
											<td class="ac">${s.f_id}</td>
											<td class="ac">${s.f_name }</td>
											<td class="ac">${s.f_sex }</td>
											<td class="ac">${s.f_major }</td>
											<td class="ac">${s.f_hphone }</td>
											<td class="ac">${s.f_score }</td>
											<td class="ac">
								<c:choose>
									<c:when test="${s.c_state eq '제안거절' }">
										거절함
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${project.p_state eq '모집중' || project.p_state eq '추가모집'}">									
												<a href="#" class="cancel btn btn-lg btn-default2 js-disable-on-click">취소</a>
											</c:when>
										</c:choose>		
									</c:otherwise>
								</c:choose>											
											
											</td>
										</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div class="num_box">
				<span class="btn_lef"> <a href="" class="first"></a>
				</span> 
							<c:if test="${pageMakerScout.prev}">
								<a
									href="/e_mypage/e_projectInfo${pageMakerScout.makeSearch(pageMakerScout.startPage - 1) }&e_pr_num=${project.e_pr_num}">&laquo;</a>
							</c:if>

							<c:forEach begin="${pageMakerScout.startPage }"
								end="${pageMakerScout.endPage }" var="idx">
								<span
								<c:out value="${pageMakerScout.cri.page == idx?'class=on':''}"/>>
									<a href="/e_mypage/e_projectInfo${pageMakerScout.makeSearch(idx)}&e_pr_num=${project.e_pr_num}">${idx}</a>
								</span>
							</c:forEach>

							<c:if test="${pageMakerScout.next && pageMakerScout.endPage > 0}">
								<li><a
									href="/e_mypage/e_projectInfo${pageMakerScout.makeSearch(pageMakerScout.endPage +1) }&e_pr_num=${project.e_pr_num}">&raquo;</a></li>
							</c:if>		
				<span class="btn_rit"> <a href="" class="last"></a>
				</span>
					</div>
				</div>
			</div>

			<form action="/e_mypage/e_acceptApplicant" name="acceptApplicant" method="post">
				<input type="hidden" name="f_numAccept" value="">
				<input type="hidden" name="e_pr_numAccept" value="${project.e_pr_num }">
			</form>
			<form action="/e_mypage/e_rejectApplicant" name="rejectApplicant" method="post">
				<input type="hidden" name="f_numReject" value="">
				<input type="hidden" name="e_pr_numReject" value="${project.e_pr_num }">
			</form>
			<form action="/e_mypage/e_cancelScout" name="cancelScout" method="post">
				<input type="hidden" name="f_numCancel" value="">
				<input type="hidden" name="e_pr_numCancel" value="${project.e_pr_num }">
			</form>
			<form action="/c_file/downloadFile" name="fileDownForm" method="post">
				<input type="hidden" name="file_num" value="">
			</form>
	</c:when>
	
	<c:otherwise>
			<div class="btn_box">
				<span>
					<input type="button" id="deleteProject" class="btn btn-lg btn-default js-disable-on-click"
											value="프로젝트 삭제">
				</span>
				<form name="deleteProject" action="/e_mypage/e_deleteProject" method="post">
					<input type="hidden" name="e_pr_numDelete" value="${project.e_pr_num }">
				</form>
			</div>		
	</c:otherwise>
</c:choose>


			</section>
			<!-- 프리랜서 목록 끝 -->
		</div>
	</div>

<%@include file="../c_common/footer.jsp"%>
</body>
</html>