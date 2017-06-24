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
<!-- <script  src="http://code.jquery.com/jquery-latest.min.js"></script> -->
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
//$(function(){
	/* var checks = document.getElementsByName("fm_new_keyword[]");
	
	var arr = new Array();

	<c:forEach var="item" items="${joblist}">
		arr.push("${item}");
	</c:forEach>
	console.log(arr[0]);
	for(var i=0; i<arr.length; i++){
			checks[arr[i]-1].checked = true;
	} */
	
/* 	var errorcheck = document.getElementById("pwd_error");
	<c:if test="${pwd_error=='error'}">
		alert("비밀번호가 틀립니다.");
	</c:if> */
	
/* 	var errorcheck = '${pwd_error}';
	if(errorcheck =='error'){
		alert("비밀번호가 틀립니다.");
	} */
//});


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
				<li><a href="/f_mypage/scheduleManager">일정 관리</a></li>
				<li><a href="/f_mypage/accountingManager">회계 관리</a></li>
				<li><a href="/f_mypage/myInfo">내 정보</a></li>
				<li><a href="/f_mypage/myInfo2">프로젝트</a></li>
			</ul>
		</div>
	</div>

	<section id="firstsection">

	<ul id="tabs">
		<li><a href="#" title="tab1">진행중인 프로젝트</a></li>
		<li><a href="#" title="tab2">매칭중인 프로젝트</a></li>
		<li><a href="#" title="tab3">신청 및 제안내역</a></li>
		<li><a href="#" title="tab4">히스토리</a></li>
	</ul>

	<div id="content">
		<div id="tab1">
			<h4>진행중인 프로젝트</h4>
			<table class="tb_st01 tb_st03">
				<caption></caption>
				 	<colgroup>
				<col style="width: 40%">
				<col style="width: 15%">
				<col style="width: 20%">
				<col style="width: 10%">
				<col style="width: 15%">
			</colgroup> 
				<thead>
					<tr>
						<th scope="col" class="ac">프로젝트명</th>
						<th scope="col" class="ac">담당자 연락처</th>
						<th scope="col" class="ac">프로젝트 기간</th>
						<th scope="col" class="ac">예산</th>
						<th scope="col" class="ac">계약서</th>
						
					</tr>
				</thead>
				<tbody>
						<c:choose>
						<c:when test="${nowProjectcheck == 0}">
							<tr><td colspan="5">진행중인 프로젝트가 없습니다.</td></tr>
						</c:when>
						<c:otherwise>
					
						 <tr>							
							<td>${nowProject.p_name}&nbsp;&nbsp;<input type="button" name="gotoList" value="상세보기" onclick="location.href='/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num=${nowProject.e_pr_num}&e_num=${nowProject.e_num}&from=mypage'"> </td>
							<td>${nowProject.manager_hphone}</td>
							<td>${nowProject.term}</td>
							<td>${nowProject.p_uppercost}원</td>
							<td><a href="/c_file/downloadFile?identy=0&f_num=${nowProject.c_num}&fileType=contractfile">계약서</a></td>
						</tr>
						</c:otherwise>
						</c:choose>
					

				</tbody>
			</table>

		</div>
	
	
		<div id="tab2">
			<h4>매칭중인 프로젝트</h4>
			<table class="tb_st01 tb_st03">
				<caption></caption>
				 	<colgroup>
				<col style="width: 40%">
				<col style="width: 15%">
				<col style="width: 20%">
				<col style="width: 10%">
				<col style="width: 15%">
			</colgroup> 
				<thead>
					<tr>
						<th scope="col" class="ac">프로젝트명</th>
						<th scope="col" class="ac">담당자 연락처</th>
						<th scope="col" class="ac">프로젝트 기간</th>
						<th scope="col" class="ac">예산</th>
						<th scope="col" class="ac">계약서</th>
						
					</tr>
				</thead>
				<tbody>
						<c:choose>
						<c:when test="${matchingProjectcheck == 0}">
							<tr><td colspan="5">매칭중인 프로젝트가 없습니다.</td></tr>
						</c:when>
						<c:otherwise>
						 <tr>							
							<td>${matchingProject.p_name}&nbsp;&nbsp;<input type="button" name="gotoList" value="상세보기" onclick="location.href='/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num=${matchingProject.e_pr_num}&e_num=${matchingProject.e_num}&from=mypage'"> </td>
							<td>${matchingProject.manager_hphone}</td>
							<td>${matchingProject.term}</td>
							<td>${matchingProject.p_uppercost}만원</td>
							<td><a href="/c_file/downloadFile?identy=0&f_num=${matchingProject.c_num}&fileType=contractfile">계약서</a></td>
						</tr>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>

		</div>
	
	
		<div id="tab3">
			<h4>내가 신청한 프로젝트</h4>
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
							<tr><td colspan="5">신청한 내역이 없습니다.</td></tr>
					</c:if>
					
					<c:forEach var="myApplyProject" items="${applyproject}">
						<c:if test="${myApplyProject.c_state eq '신청중'}">				
						<form id="applyForm" action="applyCancel" method="post">
							<input type="text" hidden name="c_num" value="${myApplyProject.c_num}">
							<input type="text" hidden name="p_name" value="${myApplyProject.p_name}">
							<input type="text" hidden name="manager_hphone" value="${myApplyProject.manager_hphone}">
							<input type="text" hidden name="c_request_date" value="${myApplyProject.c_request_date}">	
							<input type="text" hidden name="c_state" value="${myApplyProject.c_state}">	
							<input type="text" hidden name="e_pr_num" value="${myApplyProject.e_pr_num}">	
							<input type="text" hidden name="e_num" value="${myApplyProject.e_num}">	
						 <tr>
							<td>${myApplyProject.p_name}&nbsp;&nbsp;<input type="button" name="gotoList" value="상세보기" onclick="location.href='/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num=${myApplyProject.e_pr_num}&e_num=${myApplyProject.e_num}&from=mypage'"></td>
							<td>${myApplyProject.manager_hphone}</td>
							<td>${myApplyProject.c_request_date}</td>
							<td>${myApplyProject.c_state}</td>
							<td class="last"><input type="submit" value="지원 취소" onclick="return confirm('진짜 취소?');"></td>
						</tr>
						</form>
						 </c:if>
						 
						 <c:if test="${myApplyProject.c_state eq '신청거절'}">				
						<form id="applyForm"  action="applyCancel" method="post">	
						 <tr bgcolor="#b3b3b3">
							<td >${myApplyProject.p_name}&nbsp;&nbsp;<input type="button" name="gotoList" value="상세보기" onclick="location.href='/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num=${myApplyProject.e_pr_num}&e_num=${myApplyProject.e_num}&from=mypage'"></td>
							<td>${myApplyProject.manager_hphone}</td>
							<td>${myApplyProject.c_request_date}</td>
							<td>${myApplyProject.c_state}</td>
							<td class="last"></td>
						</tr>
						</form>
						 </c:if>
					</c:forEach>

				</tbody>
			</table>
			
			<h4>내게 제안 온 프로젝트</h4>
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
					<c:if test="${suggestprojectcheck == 0}">
							<tr><td colspan="5">제안 온 내역이 없습니다.</td></tr>
					</c:if>
					
					<c:forEach var="mySuggestproject" items="${suggestproject}">
					<c:if test="${mySuggestproject.c_state eq '제안중'}">
						<form id="suggestForm" action="suggestCancel" method="post">
							<input type="text" hidden name="c_num" value="${mySuggestproject.c_num}">
							<input type="text" hidden name="p_name" value="${mySuggestproject.p_name}">
							<input type="text" hidden name="manager_hphone" value="${mySuggestproject.manager_hphone}">
							<input type="text" hidden name="c_request_date" value="${mySuggestproject.c_request_date}">	
							<input type="text" hidden name="c_state" value="${mySuggestproject.c_state}">	
							<input type="text" hidden name="e_pr_num" value="${mySuggestproject.e_pr_num}">	
							<input type="text" hidden name="e_num" value="${mySuggestproject.e_num}">	
						 <tr>							
							<td>${mySuggestproject.p_name}&nbsp;&nbsp;<input type="button" name="gotoList" value="상세보기" onclick="location.href='/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num=${mySuggestproject.e_pr_num}&e_num=${mySuggestproject.e_num}&from=mypage'"></td>
							<td>${mySuggestproject.manager_hphone}</td>
							<td>${mySuggestproject.c_request_date}</td>
							<td>${mySuggestproject.c_state}</td>
							<td class="last"><input type="submit" value="제안 거절" onclick="return confirm('진짜 거절?');"></td>
						</tr>
						</form>
						</c:if>
						<c:if test="${mySuggestproject.c_state eq '제안거절'}">
						<form id="suggestForm"  action="suggestCancel" method="post">	
						 <tr bgcolor="#b3b3b3">
							<td >${mySuggestproject.p_name}&nbsp;&nbsp;<input type="button" name="gotoList" value="상세보기" onclick="location.href='/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num=${mySuggestproject.e_pr_num}&e_num=${mySuggestproject.e_num}&from=mypage'"></td>
							<td>${mySuggestproject.manager_hphone}</td>
							<td>${mySuggestproject.c_request_date}</td>
							<td>${mySuggestproject.c_state}</td>
							<td class="last"></td>
						</tr>
						</form>
						</c:if>
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
						<th scope="col" class="ac">계약서</th>
					</tr>
				</thead>
				<tbody>

						<c:if test="${finishprojectcheck == 0}">
							<tr><td colspan="5">완료한 내역이 없습니다.</td></tr>
					</c:if>
					
					<c:forEach var="myFinishProject" items="${finishproject}">
						 <tr>							
							<td>${myFinishProject.proName}&nbsp;&nbsp;
							<c:if test="${myFinishProject.evaluate == 1}">
							<input type="button" name="gotoList" value="상세보기" onclick="location.href='/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num=${myFinishProject.e_pr_num}&e_num=${myFinishProject.e_num}&from=mypage'"> 
							</c:if>
							<c:if test="${myFinishProject.evaluate == 0}">
							<input type="button" name="gotoList" value="평가하기" onclick="location.href='/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num=${myFinishProject.e_pr_num}&e_num=${myFinishProject.e_num}&from=evaluate'"> 
							</c:if>
							</td>
							<td>${myFinishProject.proTerm}</td>
							<td>${myFinishProject.cost}</td>
							<td>${myFinishProject.p_job}</td>
							<td><a href="/c_file/downloadFile?identy=0&f_num=${myFinishProject.c_num}&fileType=contractfile">계약서</a></td>
						</tr>
						
					</c:forEach>

				</tbody>
			</table>

		</div>

	</div>


	</section>

	<%@include file="../c_common/footer.jsp"%>

</body>
</html>