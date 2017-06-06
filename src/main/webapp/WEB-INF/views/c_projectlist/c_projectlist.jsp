<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="/resources/c_projectlist_css/join.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/resources/c_projectlist_css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../common/header.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../common/footer.css" type="text/css"
	media="screen" />

<title>프로젝트 목록</title>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="../common/header.js"></script>
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

	<div  id="conainer">
    	<div id="nav">
        	<div class="nav_txt">
            	<p>
                	<a href="/index.php">Home</a>
                    <span class="padd">&gt;</span>
                	<span>프로젝트 목록</span>
            	</p>
            </div>
        </div>
        <!-- //nav : e -->
        <div id="content">
        	<div class="tit_box">
            	<h2>프로젝트 목록</h2>
                <p class="tit_txt">프로젝트를 찾고 계신가요?<span>드림랜서가 엄선한 다양한 프로젝트를 만나보세요!</span></p>
            </div>
            <!-- //tit_box : e -->
	<div class="project_list_filter" style="float:left">
            <div class="tb_box">
				<form style="padding:0px;padding-top:0" action="list.php#Member_list" method="post" name="esearch">
					<input type="hidden" name="page" value="1" />
					<input type="hidden" name="fm_str" value="" />
            	<table class="tb_st02">
                	<caption>프리랜서 검색 : 개발분야, 디자인/퍼블리싱 분야, 기획/ 컨설턴트 분야, 전문분야/특별경험, 근무희망지역, 등급, 학력, 근무형태, 나이로 구성된 표</caption>
                  
                    <tbody>
                    	<tr>
                        	<th scope="row"></span><label for="">개발분야</label></th>
                        </tr>
                        <tr>
                            <td class="ct ">
                            <div  class="che_top_pa">
                                <ul class="che_list03">
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value=".NET" > .NET</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="ABAP" > ABAP</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="ANDROID" > ANDROID</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="ASP" > ASP</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="ASP.NET" > ASP.NET</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="C" > C</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="C#" > C#</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="C++" > C++</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="COBOL" > COBOL</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="CSS" > CSS</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="DB" > DB</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="DELPHI" > DELPHI</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="HTML" > HTML</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="IOS" > IOS</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="JAVA" > JAVA</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="JS" > JS</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="JSP" > JSP</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="LINUX" > LINUX</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="NETWORK" > NETWORK</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="PHP" > PHP</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="POWER BUILDER"> 파워빌더</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="PYTHON" > PYTHON</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="QA" > QA</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="RUBY" > RUBY</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="SERVER개발" > SERVER개발</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="VB" > VB</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="VC++" > VC++</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="WINDOWS" > WINDOWS</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="임베디드" > 임베디드</li>
													
						                                </ul>
                            </div>

                            </td>
                            </tr>
                    
						<tr>
                        	<th scope="row" class="bg_ye">디자인/퍼블리싱 분야</th>
                        	</tr>
                        <tr>
                            <td class="ct">
                            <div  class="che_top_pa">
                                <ul class="che_list03">
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="HTML5" > HTML5</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="그래픽디자인" > 그래픽디자인</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="모바일" > 모바일</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="액션스크립트" > 액션스크립트</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="웹디자인" > 웹디자인</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="웹표준" > 웹표준</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="파워포인트" > 파워포인트</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="퍼블리싱" > 퍼블리싱</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="포토샵편집" > 포토샵편집</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="플래시" > 플래시</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="3D" > 3D</li>
													
						                                </ul>
                            </div>
                            </td>
                        </tr>
                        <tr>
                        	<th scope="row" class="bg_gy">기획/컨설턴트 분야</th>
                        	</tr>
                        <tr>
                            <td  class="ct">
                            <div  class="che_top_pa">
                                <ul class="che_list03">
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="Oracle컨설턴트" > <a id="small" >DB컨설턴트</a></li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="PM" > PM</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="PMO" > PMO</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="SAP컨설턴트"  > <a id="small" >SAP컨설턴트</a></li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="기획" > 기획</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="모바일기획" > 모바일기획</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="웹기획" > 웹기획</li>
													
													
						                                </ul>
                            </div>
                            </td>
                        </tr> 
                    </tbody>
                </table>
				</form>
            </div>
            <!-- //tb_box : e -->
            <div class="ac">
				<input type="hidden" name="page" value="1" />
            	<a href="javascript:page_submit('/19_ESERCH/page/list.php#Member_list');" class="btn_check03">검색하기</a>
                <a href="/19_ESERCH/page/list.php" class="btn_check02">초기화</a>
            </div>
	</div>
			</form>
			<div class="tb_box tb_top" style="float: left; width: 770px;">
				<table class="tb_st01 tb_st03 tb_box_font">
					<caption>전체 : 전문분야, 등급, 프로젝트정보, 근무조건, 마감일자, 상태로 구성된 표</caption>
					<colgroup>
						<col style="width: *" />
						<col style="width: 10%" />
						<col style="width: 10%" />
						<col style="width: 11%" />
						<col style="width: 10%" />
						<col style="width: 11%" />
					</colgroup>
					<thead>
						<th scope="col">프로젝트</th>
						<th scope="col">모집분야</th>
						<th scope="col">근무시작일</th>
						<th scope="col">근무종료일</th>
						<th scope="col">모집인원</th>
						<th scope="col" class="last">모집마감일</th>
					</thead>
					<tbody>
					
					<c:forEach items="${list}" var="E_Insert">

						<tr>
							<td class="al">
								<p class="infor_txt"
									style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
									<a
									href='/c_projectlist/c_readpage${pageMaker.makeSearch(pageMaker.cri.page) }&e_pr_num=${E_Insert.e_pr_num}&e_num=${E_Insert.e_num}'>
									[${E_Insert.p_state }/${E_Insert.p_location }/${E_Insert.p_academic }] <br> ${E_Insert.p_name }
									</a>
								</p>

								<p class="ell_hidd">
									<a
									href='/c_projectlist/c_readpage${pageMaker.makeSearch(pageMaker.cri.page) }&e_pr_num=${E_Insert.e_pr_num}&e_num=${E_Insert.e_num}'>
										${E_Insert.p_content }</a>
								</p>
							</td>
							<td class="ac">
								<div class="tb_ball04">UNITY</div>
							</td>
							<td>${E_Insert.p_startDate }<%-- <fmt:formatDate value="${E_Insert.p_startDate }" pattern="yyyy-MM-dd"/> --%></td>
							<td>${E_Insert.p_endDate }<br>
							</td>
							<td>${E_Insert.p_requireNum }명</td>
							<td class="last finish"><strong>${E_Insert.p_exDate }</strong></td>
						</tr>
						</c:forEach>
							
				
					</tbody>
				</table>
			</div>
			
			<div class="num_box">
			<span class="btn_lef"> <a href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0xJmluY3JlbWVudD0w#Member_list');"
					class="first" alt="처음으로"></a></span>
					
							<c:if test="${pageMaker.prev}">
								<a
									href="c_projectlist${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<span
								<c:out value="${pageMaker.cri.page == idx?'class=on':''}"/>>
									<a href="c_projectlist${pageMaker.makeSearch(idx)}">${idx}</a>
								</span>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="c_projectlist${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>
							
							<span class='btn_rit'><a href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0xMSZpbmNyZW1lbnQ9MQ==#Member_list');"
					class="next" alt="다음 페이지"></a><a href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0zMjMmaW5jcmVtZW50PTMy#Member_list');"
					class="last" alt="마지막으로"></a> </span>
			</div>
			<!-- //tb_box : e -->
			<!-- <div class="num_box">
				<span class="btn_lef"> 
				<a href="#" onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0xJmluY3JlbWVudD0w#Member_list');" class="first" alt="처음으로"></a></span>
				<a class="on">1</a><a href="#" onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0yJmluY3JlbWVudD0w#Member_list');">2</a>
				<a href="#" onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0zJmluY3JlbWVudD0w#Member_list');">3</a>
				<a href="#" onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT00JmluY3JlbWVudD0w#Member_list');">4</a>
				<a
					href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT01JmluY3JlbWVudD0w#Member_list');">5</a><a
					href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT02JmluY3JlbWVudD0w#Member_list');">6</a><a
					href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT03JmluY3JlbWVudD0w#Member_list');">7</a><a
					href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT04JmluY3JlbWVudD0w#Member_list');">8</a><a
					href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT05JmluY3JlbWVudD0w#Member_list');">9</a><a
					href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0xMCZpbmNyZW1lbnQ9MA==#Member_list');">10</a><span
					class='btn_rit'><a href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0xMSZpbmNyZW1lbnQ9MQ==#Member_list');"
					class="next" alt="다음 페이지"></a><a href="#"
					onclick="javascript:page_submit('/19_ESERCH/page/list.php?fm_str=cGFnZT0zMjMmaW5jcmVtZW50PTMy#Member_list');"
					class="last" alt="마지막으로"></a> </span>
			</div> -->
		</div>
		<!-- //content : e  -->




<%@include file="../c_common/footer.jsp" %>
</body>
</html>