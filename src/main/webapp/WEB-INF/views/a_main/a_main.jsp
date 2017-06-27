<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/a_main_js/a_main.js"></script>
<script type="text/javascript" src="/resources/a_main_js/tabs.js"></script>
	


<link rel="stylesheet" href="/resources/a_main_css/a_project.css" type="text/css"
	media="screen" />
	


</head>
<body>

<%@include file="../c_common/header.jsp"%>

	<div id="nav">
		<div class="nav_txt">
			<p>
				<a href="/e_lan/index.php">Home</a> <span class="padd">&gt;</span> <span>프로젝트
					상세</span>
			</p>
		</div>
	</div>

	<section>
		<form action="/c_file/downloadFile" id="fileForm" name="fileForm" method="post">
			<input id="file_num" type="hidden" name="file_num" value="59">
		</form>
		
	<span id="tabnum" style="display:none;">${tabnum }</span>
	<ul id="tabs">
		<li><a href="#" title="tab1">프리랜서</a></li>
		<li><a href="#" title="tab2">기업</a></li>
		<li><a href="#" title="tab3">기업가입승인</a></li>
		<li><a href="#" title="tab4">프로젝트승인</a></li>
		<li><a href="#" title="tab5">문의답변하기</a>
		<li><a href="#" title="tab6">완료된답변</a>
	</ul>
	
<div id="tcontent">
		<div class="tab" id="tab1">
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
								
								<th colspan="2"><a href="/a_main/a_mailsender?f_num=${f.f_num }" onClick="window.open(this.href, '', 'width=1000, height=1000'); return false;">메일 발송</a><!-- <input type="button" onclick="javascript:postPopUp()" value="메일 발송" class="mailSend"> -->&nbsp;&nbsp;&nbsp;&nbsp;<button class="deleteAccountF">계정 삭제</button></th>
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
							<c:choose>
								<c:when test="${pageMakerFreelancer.prev}">
									<a href="/a_main/a_main${pageMakerpageMakerFreelancerEnterprise.makeSearch(pageMakerFreelancer.startPage - 1) }" class="first"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="first"></a>
								</c:otherwise>
							</c:choose>	
							
							<c:forEach begin="${pageMakerFreelancer.startPage }"
								end="${pageMakerFreelancer.endPage }" var="idx">
								<span
								<c:out value="${pageMakerFreelancer.cri.page == idx?'class=on':''}"/>>
									<a href="/a_main/a_main${pageMakerFreelancer.makeSearch(idx)}&tabnum=1">${idx}</a>
								</span>
							</c:forEach>

							<c:choose>
								<c:when test="${pageMakerFreelancer.next && pageMakerFreelancer.endPage > 0}">
									<a href="/a_main/a_main${pageMakerFreelancer.makeSearch(pageMakerFreelancer.endPage +1) }" class="last"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="last"></a>
								</c:otherwise>
							</c:choose>
			</div>
		</div>


		<div class="tab" id="tab2">
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
								<td><a href="${e.e_licensefilenum}" class="license">다운로드</a></td>
								<th>승인여부</th>
								<td>${e.e_check}</td>
								<th  colspan="2"><a href="/a_main/a_mailsender_e?e_num=${e.e_num }" onClick="window.open(this.href, '', 'width=1000, height=1000'); return false;">메일 발송</a>&nbsp;&nbsp;&nbsp;&nbsp;<button class="deleteAccountE">계정 삭제</button></th>
							</tr>
							<tr>
								<td colspan="8"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="num_box">
							<c:choose>
								<c:when test="${pageMakerEnterprise.prev}">
									<a href="/a_main/a_main${pageMakerEnterprise.makeSearch(pageMakerEnterprise.startPage - 1) }" class="first"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="first"></a>
								</c:otherwise>
							</c:choose>								

							<c:forEach begin="${pageMakerEnterprise.startPage }"
								end="${pageMakerEnterprise.endPage }" var="idx">
								<span
								<c:out value="${pageMakerEnterprise.cri.page == idx?'class=on':''}"/>>
									<a href="/a_main/a_main${pageMakerEnterprise.makeSearch(idx)}&tabnum=2">${idx}</a>
								</span>
							</c:forEach>

							<c:choose>
								<c:when test="${pageMakerEnterprise.next && pageMakerEnterprise.endPage > 0}">
									<a href="/a_main/a_main${pageMakerEnterprise.makeSearch(pageMakerEnterprise.endPage +1) }" class="last"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="last"></a>
								</c:otherwise>
							</c:choose>				
			</div>
		</div>


		<div class="tab" id="tab3">
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
								<td><a href="${ep.e_licensefilenum}" class="license">다운로드</a></td>
								<th>승인여부</th>
								<td>${ep.e_check}</td>
								<th  colspan="2"><button class="permitJoin">가입 승인</button></th>
							</tr>
							<tr>
								<td colspan="8"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="num_box">
							<c:choose>
								<c:when test="${pageMakerEnterprisePermit.prev}">
									<a href="/a_main/a_main${pageMakerEnterprisePermit.makeSearch(pageMakerEnterprisePermit.startPage - 1) }" class="first"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="first"></a>
								</c:otherwise>
							</c:choose>
							
							<c:forEach begin="${pageMakerEnterprisePermit.startPage }"
								end="${pageMakerEnterprisePermit.endPage }" var="idx">
								<span
								<c:out value="${pageMakerEnterprisePermit.cri.page == idx?'class=on':''}"/>>
									<a href="/a_main/a_main${pageMakerEnterprisePermit.makeSearch(idx)}&tabnum=3">${idx}</a>
								</span>
							</c:forEach>

							<c:choose>
								<c:when test="${pageMakerEnterprisePermit.next && pageMakerEnterprisePermit.endPage > 0}">
									<a href="/a_main/a_main${pageMakerEnterprisePermit.makeSearch(pageMakerEnterprisePermit.endPage +1) }" class="last"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="last"></a>
								</c:otherwise>
							</c:choose>						
			</div>
		</div>		
		
		<div class="tab" id="tab4">
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
						<c:forEach var="pp" items="${listProjectPermit }">
							<tr>
								<th>등록번호</th>
								<td>${pp.e_pr_num }</td>
								<td style="display:none">${pp.e_num }</td>
								<th>프로젝트명</th>
								<td><a href="/c_projectlist/c_readpage?e_pr_num=${pp.e_pr_num }&e_num=${pp.e_num }&from=list"><b>${pp.p_name}</b></a></td>
								<th>회사명</th>
								<td>${pp.e_ename}</td>
								<th>매니저 연락처</th>
								<td>${pp.manager_hphone}</td>
							</tr>
							<tr>
								<th>평균예산</th>
								<fmt:parseNumber var = "cost"  integerOnly = "true" value = "${(pp.p_lowercost + pp.p_uppercost) / 2}"/>
								<td>${cost }만원</td>
								<th>등록일</th>
								<td>${pp.p_regdate }</td>
								<th>마감일</th>
								<td>${pp.p_exdate }</td>
								<th  colspan="2"><button class="permitRegedit">등록 승인</button></th>
							</tr>
							<tr>
								<td colspan="8"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="num_box">
							<c:choose>
								<c:when test="${pageMakerProjectPermit.prev}">
									<a href="/a_main/a_main${pageMakerProjectPermit.makeSearch(pageMakerProjectPermit.startPage - 1) }" class="first"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="first"></a>
								</c:otherwise>
							</c:choose>
							
							<c:forEach begin="${pageMakerProjectPermit.startPage }"
								end="${pageMakerProjectPermit.endPage }" var="idx">
								<span
								<c:out value="${pageMakerProjectPermit.cri.page == idx?'class=on':''}"/>>
									<a href="/a_main/a_main${pageMakerProjectPermit.makeSearch(idx)}&tabnum=4">${idx}</a>
								</span>
							</c:forEach>

							<c:choose>
								<c:when test="${pageMakerProjectPermit.next && pageMakerProjectPermit.endPage > 0}">
									<a href="/a_main/a_main${pageMakerProjectPermit.makeSearch(pageMakerProjectPermit.endPage +1) }" class="last"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="last"></a>
								</c:otherwise>
							</c:choose>						
			</div>
		</div>		
		
		
		      <div class="tab" id="tab5">
         <div class="tb_box">
         	<form action="doAnswer">
            <table class="tb_st01 tb_st03">
               <tr>
                  <th width="5%">글쓴이</th>
                  <th width="30%">글제목</th>
                  <th width="10%">등록일자</th>
               </tr>
                  
                     <c:forEach var="askList" items="${askList }">
                        <tr>                        
                        <td>${askList.writer }</td>                     
                        <td><a href="/a_main/a_read?asknum=${askList.asknum }" onClick="window.open(this.href, '', 'width=1000, height=1000'); return false;">${askList.asktitle}</a>
                        	
                        </td>                        
                        <td>${askList.askdate }</td>
                        
                     </tr>
                     </c:forEach>
                  
            </table>
            </form>
         </div>
         <div class="num_box">
							<c:choose>
								<c:when test="${pageMakerAskList.prev}">
									<a href="/a_main/a_main${pageMakerAskList.makeSearch(pageMakerAskList.startPage - 1) }" class="first"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="first"></a>
								</c:otherwise>
							</c:choose>

							<c:forEach begin="${pageMakerAskList.startPage }"
								end="${pageMakerAskList.endPage }" var="idx">
								<span
								<c:out value="${pageMakerAskList.cri.page == idx?'class=on':''}"/>>
									<a href="/a_main/a_main${pageMakerAskList.makeSearch(idx)}&tabnum=5">${idx}</a>
								</span>
							</c:forEach>

							<c:choose>
								<c:when test="${pageMakerAskList.next && pageMakerAskList.endPage > 0}">
									<a href="/a_main/a_main${pageMakerAskList.makeSearch(pageMakerAskList.endPage +1) }" class="last"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="last"></a>
								</c:otherwise>
							</c:choose>						
         </div>
      </div>
      
      <div class="tab" id="tab6">
       <div class="tb_box">
         	<form action="doAnswer">
            <table class="tb_st01 tb_st03">
               <tr>
                  <th width="5%">글쓴이</th>
                  <th width="30%">글제목</th>
                  <th width="10%">등록일자</th>
               </tr>
                  
                     <c:forEach var="askList" items="${answerOK }">
                        <tr>                        
                        <td>${askList.writer }</td>                     
                        <td>${askList.asktitle}
                        	
                        </td>                        
                        <td>${askList.askdate }</td>
                        
                     </tr>
                     </c:forEach>
                  
            </table>
            </form>
         </div>
         <div class="num_box">
							<c:choose>
								<c:when test="${pageMakerAnswerOK.prev}">
									<a href="/a_main/a_main${pageMakerAnswerOK.makeSearch(pageMakerAnswerOK.startPage - 1) }" class="first"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="first"></a>
								</c:otherwise>
							</c:choose>

							<c:forEach begin="${pageMakerAnswerOK.startPage }"
								end="${pageMakerAnswerOK.endPage }" var="idx">
								<span
								<c:out value="${pageMakerAnswerOK.cri.page == idx?'class=on':''}"/>>
									<a href="/a_main/a_main${pageMakerAnswerOK.makeSearch(idx)}&tabnum=6">${idx}</a>
								</span>
							</c:forEach>

							<c:choose>
								<c:when test="${pageMakerAnswerOK.next && pageMakerAnswerOK.endPage > 0}">
									<a href="/a_main/a_main${pageMakerAnswerOK.makeSearch(pageMakerAnswerOK.endPage +1) }" class="last"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="last"></a>
								</c:otherwise>
							</c:choose>
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
	<form action="/a_main/a_permitProject" method="post" name="permitProjectForm">
		<input type="hidden" name="permitE_pr_num">
		<input type="hidden" name="permitE_num">
	</form>
	
	</section>

<%@include file="../c_common/footer.jsp"%>
</body>
</html>