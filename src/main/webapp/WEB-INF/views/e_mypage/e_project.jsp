<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
<link rel="stylesheet" href="/resources/e_mypage_css/e_project.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/resources/e_mypage_css/e_leftmenu.css"
	type="text/css" media="screen" />

<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="/resources/e_mypage_js/tabs.js"></script>

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

	<div id="nav">
		<div class="nav_txt">
			<p>
				<a href="#">Home</a> <span class="padd">&gt;</span> <span>프로젝트
					상세</span>
			</p>
		</div>
	</div>

	<section>
	<ul id="tabs">
		<li><a href="#" title="tab1">모집 중</a></li>
		<li><a href="#" title="tab2">진행 중</a></li>
		<li><a href="#" title="tab3">완료</a></li>
	</ul>

	<div id="tcontent">
		<div id="tab1">
			<div class="tb_box">
				<table class="tb_st01 tb_st03">
					<colgroup>
						<col style="width: 9%">
						<col style="width: *">
						<col style="width: 8%">
						<col style="width: 8%">
						<col style="width: 11%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 10%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">프로젝트명</th>
							<th scope="col">모집인원</th>
							<th scope="col">희망연령</th>
							<th scope="col">평균예산</th>
							<th scope="col">등록일</th>
							<th scope="col">마감일</th>
							<th scope="col">승인여부</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="p" items="${readyList }">
							<tr>
								<td class="ac">${p.getE_pr_num()}</td>
								<td><a href="/e_mypage/e_projectInfo${pageMakerReady.makeSearch(pageMakerReady.cri.page) }&e_pr_num=${p.getE_pr_num()}">${p.getP_name()}</a></td>
								<td class="ac">${p.getP_requirenum()}</td>
								<td class="ac">${p.getP_lowerage()} ~ ${p.getP_upperage()}</td>
								<fmt:parseNumber var = "cost"  integerOnly = "true" value = "${(p.p_lowercost + p.p_uppercost) / 2}"/>
								<td class="ac">${cost }만원</td>
								<td class="ac">${p.getP_regdate()}</td>
								<td class="ac">${p.getP_exdate()}</td>
								<td class="ac">${p.getProject_check_state() }</td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
	
			
			
			
			<div class="num_box">
				<span class="btn_lef"> <a href="" class="first" alt="처음으로"></a>
				</span> 
							<c:if test="${pageMakerReady.prev}">
								<a
									href="/e_mypage/e_project${pageMakerReady.makeSearch(pageMakerReady.startPage - 1) }">&laquo;</a>
							</c:if>

							<c:forEach begin="${pageMakerReady.startPage }"
								end="${pageMakerReady.endPage }" var="idx">
								<span
								<c:out value="${pageMakerReady.cri.page == idx?'class=on':''}"/>>
									<a href="/e_mypage/e_project${pageMakerReady.makeSearch(idx)}">${idx}</a>
								</span>
							</c:forEach>

							<c:if test="${pageMakerReady.next && pageMakerReady.endPage > 0}">
								<li><a
									href="/e_mypage/e_project${pageMakerReady.makeSearch(pageMakerReady.endPage +1) }">&raquo;</a></li>
							</c:if>		
				<span class="btn_rit"> <a href="" class="last" alt="마지막으로"></a>
				</span>
			</div>
		</div>


		<div id="tab2">
			<div class="tb_box">
				<table class="tb_st01 tb_st03">
					<colgroup>
						<col style="width: 9%">
						<col style="width: *">
						<col style="width: 8%">
						<col style="width: 8%">
						<col style="width: 11%">
						<col style="width: 10%">
						<col style="width: 10%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">프로젝트명</th>
							<th scope="col">모집인원</th>
							<th scope="col">희망연령</th>
							<th scope="col">평균예산</th>
							<th scope="col">등록일</th>
							<th scope="col">마감일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${doingList }">
							<tr>
								<td class="ac">${p.getE_pr_num()}</td>
								<td><a href="/e_mypage/e_projectInfo${pageMakerReady.makeSearch(pageMakerReady.cri.page) }&e_pr_num=${p.getE_pr_num()}">${p.getP_name()}</a></td>
								<td class="ac">${p.getP_requirenum()}</td>
								<td class="ac">${p.getP_lowerage()} ~ ${p.getP_upperage()}</td>
								<td class="ac">${p.getP_lowercost()}</td>
								<td class="ac">${p.getP_regdate()}</td>
								<td class="ac">${p.getP_exdate()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="num_box">
				<span class="btn_lef"> <a href="" class="first" alt="처음으로"></a>
				</span> 
							<c:if test="${pageMakerDoing.prev}">
								<a
									href="/e_mypage/e_project${pageMakerDoing.makeSearch(pageMakerDoing.startPage - 1) }">&laquo;</a>
							</c:if>

							<c:forEach begin="${pageMakerDoing.startPage }"
								end="${pageMakerDoing.endPage }" var="idx">
								<span
								<c:out value="${pageMakerDoing.cri.page == idx?'class=on':''}"/>>
									<a href="/e_mypage/e_project${pageMakerDoing.makeSearch(idx)}">${idx}</a>
								</span>
							</c:forEach>

							<c:if test="${pageMakerDoing.next && pageMakerDoing.endPage > 0}">
								<li><a
									href="/e_mypage/e_project${pageMakerDoing.makeSearch(pageMakerDoing.endPage +1) }">&raquo;</a></li>
							</c:if>		
				<span class="btn_rit"> <a href="" class="last" alt="마지막으로"></a>
				</span>
			</div>
		</div>


		<div id="tab3">
			<div class="tb_box">
				<table class="tb_st01 tb_st03">
					<colgroup>
						<col style="width: 9%">
						<col style="width: *">
						<col style="width: 8%">
						<col style="width: 8%">
						<col style="width: 11%">
						<col style="width: 10%">
						<col style="width: 10%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">프로젝트명</th>
							<th scope="col">모집인원</th>
							<th scope="col">희망연령</th>
							<th scope="col">평균예산</th>
							<th scope="col">등록일</th>
							<th scope="col">마감일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${doneList }">
							<tr>
								<td class="ac">${p.getE_pr_num()}</td>
								<td><a href="/e_mypage/e_projectInfo${pageMakerReady.makeSearch(pageMakerReady.cri.page) }&e_pr_num=${p.getE_pr_num()}">${p.getP_name()}</a></td>
								<td class="ac">${p.getP_requirenum()}</td>
								<td class="ac">${p.getP_lowerage()} ~ ${p.getP_upperage()}</td>
								<td class="ac">${p.getP_lowercost()}</td>
								<td class="ac">${p.getP_regdate()}</td>
								<td class="ac">${p.getP_exdate()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="num_box">
				<span class="btn_lef"> <a href="" class="first" alt="처음으로"></a>
				</span> 
							<c:if test="${pageMakerDone.prev}">
								<a
									href="/e_mypage/e_project${pageMakerDone.makeSearch(pageMakerDone.startPage - 1) }">&laquo;</a>
							</c:if>

							<c:forEach begin="${pageMakerDone.startPage }"
								end="${pageMakerDone.endPage }" var="idx">
								<span
								<c:out value="${pageMakerDone.cri.page == idx?'class=on':''}"/>>
									<a href="/e_mypage/e_project${pageMakerDone.makeSearch(idx)}">${idx}</a>
								</span>
							</c:forEach>

							<c:if test="${pageMakerDone.next && pageMakerDone.endPage > 0}">
								<li><a
									href="/e_mypage/e_project${pageMakerDone.makeSearch(pageMakerDone.endPage +1) }">&raquo;</a></li>
							</c:if>		
				<span class="btn_rit"> <a href="" class="last" alt="마지막으로"></a>
				</span>
			</div>
		</div>
	</div>

	</section>

<%@include file="../c_common/footer.jsp"%>
</body>
</html>