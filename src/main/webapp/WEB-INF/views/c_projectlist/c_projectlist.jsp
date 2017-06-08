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
				<form style="padding:0px;padding-top:0" action="/c_projectlist/c_projectlist" method="post" name="esearch">
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
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="1" > .NET</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="2" > ABAP</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="3" > ANDROID</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="4" > ASP</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="5" > ASP.NET</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="6" > C</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="7" > C#</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="8" > C++</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="9" > COBOL</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="10" > CSS</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="11" > DB</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="12" > DELPHI</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="13" > HTML</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="14" > IOS</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="15" > JAVA</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="16" > JS</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="17" > JSP</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="18" > LINUX</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="19" > NETWORK</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="20" > PHP</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="21"> 파워빌더</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="22" > PYTHON</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="23" > QA</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="24" > RUBY</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="25" > SERVER개발</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="26" > VB</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="27" > VC++</li>
												
													
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="28" > WINDOWS</li>
						                                        <li><input type="checkbox" name="fm_new_keyword[]" value="29" > 임베디드</li>
													
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
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="30" > HTML5</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="31" > 그래픽디자인</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="32" > 모바일</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="33" > 액션스크립트</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="34" > 웹디자인</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="35" > 웹표준</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="36" > 파워포인트</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="37" > 퍼블리싱</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="38" > 포토샵편집</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="39" > 플래시</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="40" > 3D</li>
													
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
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="41" >DB컨설턴트</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="42" > PM</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="43" > PMO</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="44"  >SAP컨설턴트</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="45" > 기획</li>
													<li><input type="checkbox" name="fm_new_keyword[]" value="46" > 모바일기획</li>
												
													
													<li><input type="checkbox" name="fm_new_keyword[]" value="47" > 웹기획</li>
													
													
						                                </ul>
                            </div>
                            </td>
                        </tr> 
                    </tbody>
                </table>
                <div class="ac">
				<input id="checkValue" class="btn_check03" id="searchBtn" value="검색하기" type="submit">
            	<a href="/c_projectlist/c_projectlist" class="btn_check02">&nbsp;&nbsp;&nbsp;&nbsp;초기화</a>
            </div>
				</form>
            </div>
            <!-- //tb_box : e -->
        
	</div>
			</form>
			<div class="tb_box tb_top" style="float: left; width: 770px;">
				<table class="tb_st01 tb_st03 tb_box_font">
					<caption>전체 : 전문분야, 등급, 프로젝트정보, 근무조건, 마감일자, 상태로 구성된 표</caption>
					<colgroup>
						<col style="width: *" />
						<col style="width: 10%" />
						<col style="width: 10%" />
						<col style="width: 10%" />
						<col style="width: 10%" />
						<col style="width: 12%" />
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
						
							
								<div  
								<c:out value="${E_Insert.p_field eq '개발'? 'class=tb_ball04':' '}"/><c:out value="${E_Insert.p_field eq '디자인'? 'class=tb_ball02':' '}"/><c:out value="${E_Insert.p_field eq '기획'? 'class=tb_ball06':' '}"/><c:out value="${E_Insert.p_field eq '공통'? 'class=tb_ball03':' '}"/>>
								${E_Insert.p_field }
								</div>
								
								
							</td>
							<td>
							<fmt:formatDate  value = "${E_Insert.p_startDate }"  pattern = "yyyy 년 MM월dd일"/>
						 </td>
							<td><fmt:formatDate  value = "${E_Insert.p_endDate }"  pattern = "yyyy 년 MM월dd일"/><br>
							</td>
							<td>${E_Insert.p_requireNum }명</td>
							<td class="last finish"><strong><fmt:formatDate  value = "${E_Insert.p_exDate }"  pattern = "yyyy 년 MM월dd일"/></strong></td>
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
			




<%@include file="../c_common/footer.jsp" %>
</body>
</html>