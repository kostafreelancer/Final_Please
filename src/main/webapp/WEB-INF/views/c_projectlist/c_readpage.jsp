<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/c_projectlist_css/c_projectInfo.css"
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
	<c:choose>
		<c:when test="${identity.identity == 'freelancer' }">
			<%@include file="../c_common/header.jsp" %>
		</c:when>
		<c:when test="${identity.identity == 'enterprise' }">
			<%@include file="../c_common/header_enterprise.jsp" %>
		</c:when>
		<c:otherwise>
			<%@include file="../c_common/header.jsp" %>
		</c:otherwise>
</c:choose>

	
	<!-- //header_wrap : e -->
	<div id="conainer">
		<div id="nav">
			<div class="nav_txt">
				<p>
					<a href="/e_lan/index.php">Home</a>
					 <span class="padd">&gt;</span>
					<span>프로젝트 목록</span>
					 <span class="padd">&gt;</span>
					<span>프로젝트 상세보기</span>
				</p>
			</div>
		</div>

		<div id="content">
			<div class="tit_box">
				<h2>${E_Insert.p_name }</h2>
			</div>

			<div class="table_tit">
				<h3>프로젝트 상세내용</h3>
			</div>
			<!-- table_tit : e -->

			<div class="tb_box">
				<h4>담당자 정보</h4>
				<table class="tb_st01">
				<form method="post" name="ProjectWriteFm">
				<input type="hidden" name="e_pr_num" value="${e_pr_num }"></input>
					 
					<colgroup>
						<col style="width: 15%" />
						<col style="width: 35%" />
						<col style="width: 15%" />
						<col style="width: 35%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row"><span class="txt_or">*</span> <label
								for="fm_comname">회사명</label></th>
							<td colspan="3">${enterprise.e_ename }</td>
						</tr>
						<tr>
							<th scope="row"><span class="txt_or">*</span> <label
								for="fm_korname">담당자명</label></th>
							<td colspan="3">${enterprise.manager_name }</td>
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
											name="check" value="35"> 파워포인트</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="36"> 퍼블리싱</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="37"> 포토샵편집</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="38"> 플래시</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="39"> 3D</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
									</tr>
								</table> <!--img src="../img/sb_category.gif" width="87" height="18" align="absmiddle"-->
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
											name="check" value="Oracle컨설턴트">
											Oracle컨설턴트</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="PM"> PM</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="PMO"> PMO</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="SAP컨설턴트"> SAP컨설턴트</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="기획"> 기획</td>
									</tr>
									<tr class="che_list011">
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="모바일기획"> 모바일기획</td>
										<td class="td_bor_bott"><input type="checkbox"
											name="check" value="웹기획"> 웹기획</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
										<td class="td_bor_bott">&nbsp;</td>
									</tr>
								</table> <!--img src="../img/sb_category.gif" width="87" height="18" align="absmiddle"-->
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
							<td colspan="2">${project.p_lowerAge }<span>~</span>${project.p_upperAge }
							</td>
							<th scope="row" class="ac"><span class="txt_or"></span> 학력</th>
							<td colspan="2">${project.p_academic }</td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
								인원</th>
							<td colspan="2">${project.p_requireNum }명</td>
							<th scope="row" class="ac"><span class="txt_or">*</span>모집마감일자</th>
							<td colspan="2"><fmt:formatDate  value = "${project.p_regDate }"  pattern = "yyyy년 MM월 dd일"/></td>
						</tr>
						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>프로젝트
								금액(월단위)</th>
							<td colspan="5"><span>${project.p_lowerCost }만원 ~ </span> <span>${project.p_upperCost }만원
									&nbsp;</span> <span class="txt_red">* VAT별도 금액입니다.</span></td>
						</tr>

						<tr>
							<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>근무기간</th>
							<td colspan="5"><fmt:formatDate  value = "${project.p_startDate }"  pattern = "yyyy년 MM월 dd일"/><span> ~ </span><fmt:formatDate  value = "${project.p_endDate }"  pattern = "yyyy년 MM월 dd일"/>
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
			
			
			<!-- //tb_box : e -->
			<div class="btn_box">
					<input id="checkValue" class="btn btn-lg btn-client js-disable-on-click btn-submit" autocomplete="off" data-loading-text="제출 중" name="post_a_job"
						value="프로젝트 신청하기" type="submit"> <br>
					<br>
					<br>
					<br>
					<br>
				</div>
			</div>
			</div>
			
				
		</form>
			

		


	<%@include file="../c_common/footer.jsp"%>
</body>
</html>