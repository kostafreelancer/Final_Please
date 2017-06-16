<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회계관리</title>
<!-- <link rel="stylesheet" href="../common/header.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../common/footer.css" type="text/css" media="screen" /> -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/f_mypage_css/accountingManager.css"
	type="text/css" media="screen" />
<script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/jquery-1.3.2.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/accountingManager.js"></script>
<!-- <script src="js/comma.js"></script> -->
<script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/add.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/superfish.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/comment.js"></script>
<%-- <script src="${pageContext.request.contextPath}/resources/f_mypage_js/calendar.js"></script>  --%>

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
			</ul>
		</div>
	</div>

	<section id="firstsection">

	<ul id="tabs">
		<li><a href="#" title="tab1">내 회계내역</a></li>
		<li><a href="#" title="tab2">세금 계산</a></li>
	</ul>

	<div id="content">
		<div id="tab1">

			<button>1월</button>
			<button>2월</button>
			<button>3월</button>
			<button>4월</button>
			<button>5월</button>
			<br> <br>
			<br>
			<form id="searchDate" name="searchDate" method="post"
				action="/f_mypage/accountingManager">
				<input type="text" id="startDate" name="startDate">
				&nbsp;&nbsp;~ <input type="text" id="endDate" name="endDate">
				<input type="submit" value="검색">
			</form>
			<div class="tb_box">
				<div class="ct overf">
					<br>

					<h4 class="fl myfl">지출</h4>
					<br>
					<br>
					<br>

				</div>
				<table class="tb_st01 tb_st03 spend">
					<caption></caption>
					<colgroup>
						<col style="width: 25%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 10%">
						<col style="width: 20%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="ac">사용내역</th>
							<th scope="col" class="ac">사용금액</th>
							<th scope="col" class="ac">사용날짜</th>
							<th scope="col" class="ac">프로젝트 관련여부</th>
							<th scope="col" class="ac">첨부파일</th>
							<th scope="col" class="last ac">관리</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${spendListCheck == 0}">
							<tr>
								<td colspan="6">등록된 내역이 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="myspendList" items="${spendList}">
							<form id="spendListForm${myspendList.a_num}"
								name="myspendListModify${myspendList.a_num}">
								<input type="text" hidden name="a_num" value="${myspendList.a_num}">
								<input type="text" hidden name="detail_usage" value="${myspendList.detail_usage}">
								<input type="text" hidden name="a_money"
									value="${myspendList.a_money}">
								<input type="text" hidden name="a_using_date" value="${myspendList.a_using_date}">
								<input type="text" hidden name="project_relation_check"
									value="${myspendList.project_relation_check}"> 
								<input
									type="text" hidden name="a_addfile"
									value="${myspendList.a_addfile}">
								<input type="text" hidden name="accfile_iden" value="${myspendList.accfile_iden}">
								<tr>

									<td>${myspendList.detail_usage}</td>
									<td>${myspendList.a_money}</td>
									<td>${myspendList.a_using_date}</td>
									<td>${myspendList.project_relation_check}</td>
									<td><a href="/c_file/downloadFile?identy=${myspendList.accfile_iden}&f_num=${client.f_num}&fileType=accfile">${myspendList.a_addfile}</a></td>
									<td class="last"><input type="button" value="수정"
										onclick="modifySpendList(${myspendList.a_num});">&nbsp;&nbsp;<input
										type="button" value="삭제"
										onclick="deleteSpendList(${myspendList.a_num});"></td>

								</tr>
							</form>

						</c:forEach>

					</tbody>
				</table>
				<form name="tempSpendListAdd" action="/f_mypage/spendListAdd" method="post" enctype="multipart/form-data">
					<input type="text" hidden name="f_num" value="${client.f_num}">
					<input type="text" hidden name="monet_state" value="지출"> 
					<input type="text" hidden name="a_num" value="0"> 
					<input type="text" hidden name="accfile_iden" value="0">
					<fieldset>
					<legend>지출내역 입력</legend>
					사용내역 : <input type="text" name="detail_usage"><br> 
					사용금액 : <input type="text"	name="a_money"> <br>
					사용날짜 : <input type="text"	name="a_using_date"><br> 
					프로젝트 관련여부 : <input type="text" name="project_relation_check"><br>
					첨부파일 : <input type="file" name="a_addfile"> <br>
					<center><input type="submit" value="저장"></center>
					</fieldset>
				</form>
				<form name="tempSpendListDelete" action="/f_mypage/deleteSpendList" method="get">
					<input type="text" hidden name="deleteSpendList_num">
				</form>
			</div>

			<div class="tb_box">
				<div class="ct overf">
					<br>

					<h4 class="fl myfl">수입</h4>
					<br>
					<br>
					<br>

				</div>
				<table class="tb_st01 tb_st03 spend">
					<caption></caption>
					<colgroup>
						<col style="width: 25%">
						<col style="width: 15%">
						<col style="width: 15%">
						<col style="width: 10%">
						<col style="width: 20%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="ac">사용내역</th>
							<th scope="col" class="ac">사용금액</th>
							<th scope="col" class="ac">사용날짜</th>
							<th scope="col" class="ac">프로젝트 관련여부</th>
							<th scope="col" class="ac">첨부파일</th>
							<th scope="col" class="last ac">관리</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${incomeListCheck == 0}">
							<tr>
								<td colspan="6">등록된 내역이 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="myincomeList" items="${incomeList}">
							<form id="incomeListForm${myincomeList.a_num}" 
							name="myincomeListModify${myincomeList.a_num}" method="post"
								action="/f_mypage/spendListModify" target='popup_window'>
								<input type="text" hidden name="a_num" value="${myincomeList.a_num}"> 
								<input type="text" hidden name="detail_usage" value="${myincomeList.detail_usage}">
								<input type="text" hidden name="a_money" value="${myincomeList.a_money}">
								<input type="text" hidden name="a_using_date" value="${myincomeList.a_using_date}">
								<input type="text" hidden name="project_relation_check" value="${myincomeList.project_relation_check}"> 
								<input type="text" hidden name="a_addfile" value="${myincomeList.a_addfile}">
								<input type="text" hidden name="accfile_iden" value="${myincomeList.accfile_iden}">
								<tr>
									<td>${myincomeList.detail_usage}</td>
									<td>${myincomeList.a_money}</td>
									<td>${myincomeList.a_using_date}</td>
									<td>${myincomeList.project_relation_check}</td>
									<td><a href="/c_file/downloadFile?identy=${myincomeList.accfile_iden}&f_num=${client.f_num}&fileType=accfile">${myincomeList.a_addfile}</a></td>
									<td class="last">
									<input type="button" value="수정"
										onclick="modifyIncomeList(${myincomeList.a_num});">&nbsp;&nbsp;
									<input type="button" value="삭제"
										onclick="deleteIncomeList(${myincomeList.a_num});"></td>
								</tr>
							</form>
						</c:forEach>

					</tbody>
				</table>
				<form name="tempIncomeListAdd" action="/f_mypage/spendListAdd"
					method="post" enctype="multipart/form-data">
					<input type="text" hidden name="f_num" value="${client.f_num}">
					<input type="text" hidden name="monet_state" value="수입"> 
					<input type="text" hidden name="a_num" value="0">
					<input type="text" hidden name="accfile_iden" value="0">
					<fieldset>
					<legend>수입내역 입력</legend> 
					사용내역 : <input type="text" name="detail_usage"><br>
					사용금액 : <input type="text" name="a_money"><br>
					사용날짜 : <input type="text" name="a_using_date"><br> 
					프로젝트 관련여부 : <input type="text" name="project_relation_check"><br> 
					첨부파일 : <input type="file" name="a_addfile"> <br>
					<center><input type="submit" value="저장"></center>
					</fieldset>
				</form>
				<form name="tempIncomeListDelete" action="/f_mypage/deleteSpendList">
					<input type="text" hidden name="deleteSpendList_num">
				</form>
			</div> 
		</div>

		<div id="tab2">
			<div class="sum">
				<h5>1) 소득공제액</h5>
				<table class="chart2" border="0" cellspacing="0" cellpadding="0">
					<colgroup>
						<col width="2%">
						<col width="15%">
						<col width="25%">
						<col width="25%">
					</colgroup>
					<tbody>
						<tr>
							<th rowspan="6">기본공제</th>
							<th colspan="2">표준공제</th>
							<td class="right_text cal">600,000</td>
							<td id="bigo">사업자에 대한 기본공제</td>
						</tr>
						<tr>
							<th colspan="2">본인</th>
							<td class="right_text cal">1,500,000</td>
							<td id="bigo">본인에 대한 기본공제</td>
						</tr>
						<tr>
							<th>배우자</th>
							<td><input onclick="g_chk(this,'lbl_g1',1500000);"
								type="checkbox" name="g1"></td>
							<td class="right_text"><span class="cal" id="lbl_g1">0</span></td>
							<td id="bigo">년소득 100만원 미만 자</td>
						</tr>
						<tr>
							<th>부모,조부모<br>장인,장모
							</th>
							<td><input class="int input_text2" id="g2"
								onkeyup="g_inp(this,'lbl_g2',1500000);" type="text"
								maxlength="1" name="g2"> 명</td>
							<td class="right_text"><span class="cal" id="lbl_g2">0</span></td>
							<td id="bigo">만60세 이상 &amp; 년소득 100만원 미만자</td>
						</tr>
						<tr>
							<th>자녀,입양자<br>위탁아동
							</th>
							<td><input class="int input_text2" id="g3"
								onkeyup="g_inp(this,'lbl_g3',1500000);g_sam(this,'c6');"
								type="text" maxlength="1" name="g3"> 명</td>
							<td class="right_text"><span class="cal" id="lbl_g3">0</span></td>
							<td rowspan="2" id="bigo">만20세 미만 &amp; 년소득 100만원 미만자</td>
						</tr>
						<tr>
							<th>형제,자매</th>
							<td><input class="int input_text2" id="g4"
								onkeyup="g_inp(this,'lbl_g4',1500000);" type="text"
								maxlength="1" name="g4"> 명</td>
							<td class="right_text"><span class="cal" id="lbl_g4">0</span></td>
						</tr>
						<tr>
							<th rowspan="7">추가공제</th>
							<th>만 70세 이상<br>부양가족
							</th>
							<td><input class="int input_text2" id="c1"
								onkeyup="g_inp(this,'lbl_c1',1000000);" type="text"
								maxlength="1" name="c1"> 명</td>
							<td class="right_text"><span class="cal" id="lbl_c1">0</span></td>
							<td id="bigo">기본공제 대상자 중 경로자 우대 공제</td>
						</tr>
						<tr>
							<th>만 6세 이하<br>자녀
							</th>
							<td><input class="int input_text2" id="c2"
								onkeyup="g_inp(this,'lbl_c2',1000000);" type="text"
								maxlength="1" name="c2"> 명</td>
							<td class="right_text"><span class="cal" id="lbl_c2">0</span></td>
							<td id="bigo">입양자, 위탁아동 포함</td>
						</tr>
						<tr>
							<th>장애인 부양가족</th>
							<td><input class="int input_text2" id="c3"
								onkeyup="g_inp(this,'lbl_c3',2000000);" type="text"
								maxlength="1" name="c3"> 명</td>
							<td class="right_text"><span class="cal" id="lbl_c3">0</span></td>
							<td id="bigo">년소득 100만원 미만 자</td>
						</tr>
						<tr>
							<th>출생자,입양자</th>
							<td><input class="int input_text2" id="c4"
								onkeyup="g_inp(this,'lbl_c4',2000000);" type="text"
								maxlength="1" name="c4"> 명</td>
							<td class="right_text"><span class="cal" id="lbl_c4">0</span></td>
							<td id="bigo">해당 과세기간 출생신고, 입양신고 한 자</td>
						</tr>
						<tr>
							<th>부녀자 추가공제</th>
							<td><input onclick="g_chk(this,'lbl_c5',500000);"
								type="checkbox" name="c5" value="Y"></td>
							<td class="right_text"><span class="cal" id="lbl_c5">0</span></td>
							<td id="bigo">부양가족 또는 배우자가 있는 여성</td>
						</tr>
						<tr>
							<th>다자녀 추가공제</th>
							<td><input id="c6" type="text" maxlength="1" name="c6"
								readonly="readonly"> 명</td>
							<td class="right_text"><span class="cal" id="lbl_c6">0</span></td>
							<td id="bigo">자녀 2명 이상 시 추가 공제</td>
						</tr>
						<tr>
							<th>기타 공제</th>
							<td></td>
							<td class="right_text"><input class="int input_text2"
								id="lbl_c7" onkeyup="insert_comma(this);g_hop();" type="text"
								name="lbl_c7" value="0">원</td>
							<td id="bigo">기부금, 국민연금, 개인연금 등</td>
						</tr>
					</tbody>
				</table>
				<h5>2) 국세청 안내에 따른 신고시 환급액 또는 추가 납부세액 계산</h5>
				<p>
					<!--th rowspan="6">&nbsp;</th-->
				</p>
				<table class="chart1" border="0" cellspacing="0" cellpadding="0">
					<colgroup>
						<col width="17%">
						<col width="25%">
						<col width="25%">
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th>수입금액</th>
							<td style="padding-right: 15px;" align="right"><input
								id="lbl_a1" onkeyup="insert_comma(this);h1_inp(this,'lbl_a2');"
								type="text" name="lbl_a1">원</td>
							<th rowspan="7">국세청안내</th>
							<td id="bigo">1년간 총 수입금액을 입력합니다</td>
						</tr>
						<tr>
							<th>기준경비</th>
							<td style="padding-right: 15px;" align="right"><input
								id="lbl_a2" type="text" name="lbl_a2" readonly="readonly">원</td>
							<td id="bigo">적정 경비율로 자동 계산</td>
						</tr>
						<tr>
							<th>소득금액</th>
							<td style="padding-right: 15px;" align="right"><input
								id="lbl_a3" type="text" name="lbl_a3" readonly="readonly">원</td>
							<td id="bigo">수입금액대비 소득율</td>
						</tr>
						<tr>
							<th>소득공제금액</th>
							<td style="padding-right: 15px;" align="right"><input
								id="lbl_a4" type="text" name="lbl_a4" readonly="readonly">원</td>
							<td id="bigo">(1)소득공제액의 합계</td>
						</tr>
						<tr>
							<th>과세표준</th>
							<td style="padding-right: 15px;" align="right"><input
								id="lbl_a5" type="text" name="lbl_a5" readonly="readonly">원</td>
							<td id="bigo">소득금액 – 소득공제금액</td>
						</tr>
						<tr>
							<th>결정세액금액</th>
							<td style="padding-right: 15px;" align="right"><input
								id="lbl_a6" type="text" name="lbl_a6" readonly="readonly">원</td>
							<td id="bigo">지방소득세 포함</td>
						</tr>
						<tr>
							<th>원천징수액(3.3%)</th>
							<td style="padding-right: 15px;" align="right"><input
								id="lbl_a7" type="text" name="lbl_a7" readonly="readonly">원</td>
							<td id="bigo">수입금액기준 3.3%를 계산합니다</td>
						</tr>
						<tr>
							<th rowspan="2">환급세액금액</th>
							<td style="padding-right: 15px;" align="right"><input
								id="lbl_a8" type="text" name="lbl_a8" readonly="readonly">원</td>
							<td><input id="lbl_a9" type="text" name="lbl_a9"
								readonly="readonly"> %</td>
							<td id="bigo">원천징수금액 대비 환급 납부율</td>
						</tr>
						<tr>
							<td style="padding-left: 15px; text-align: center;" colspan="3"
								align="left">마이너스 금액은 추가 납부세액</td>
						</tr>
					</tbody>
				</table>
				<div class="tableStrong" hidden>
					<h5 style="color: blue;">(4) 참진세무회계에 의뢰시 결정세액 및 환급세액 예상</h5>
					<p>
						<!--td rowspan="6">&nbsp;</td-->
					</p>
					<table border="0" cellspacing="0" cellpadding="0">
						<colgroup>
							<col width="17%">
							<col width="25%">
							<col width="25%">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>수입금액</th>
								<td style="padding-right: 15px;" align="right"><input
									id="lbl_b1" type="text" name="lbl_b1" readonly="readonly">원</td>
								<th rowspan="7">국세청안내</th>
								<td id="bigo">1년간 총 수입금액을 입력합니다</td>
							</tr>
							<tr>
								<th>지출비용금액</th>
								<td style="padding-right: 15px;" align="right"><input
									id="lbl_b2" type="text" name="lbl_b2" readonly="readonly">원</td>
								<td id="bigo">적정 경비율로 자동 계산</td>
							</tr>
							<tr>
								<th>소득금액</th>
								<td style="padding-right: 15px;" align="right"><input
									id="lbl_b3" type="text" name="lbl_b3" readonly="readonly">원</td>
								<td id="bigo">수입금액대비 소득율</td>
							</tr>
							<tr>
								<th>소득공제금액</th>
								<td style="padding-right: 15px;" align="right"><input
									id="lbl_b4" type="text" name="lbl_b4" readonly="readonly">원</td>
								<td id="bigo">(1)소득공제액의 합계</td>
							</tr>
							<tr>
								<th>과세표준</th>
								<td style="padding-right: 15px;" align="right"><input
									id="lbl_b5" type="text" name="lbl_b5" readonly="readonly">원</td>
								<td id="bigo">소득금액 – 소득공제금액</td>
							</tr>
							<tr>
								<th>결정세액금액</th>
								<td style="padding-right: 15px;" align="right"><input
									id="lbl_b6" type="text" name="lbl_b6" readonly="readonly">원</td>
								<td id="bigo">지방소득세 포함</td>
							</tr>
							<tr>
								<th>원천징수액(3.3%)</th>
								<td style="padding-right: 15px;" align="right"><input
									id="lbl_b7" type="text" name="lbl_b7" readonly="readonly">원</td>
								<td id="bigo">수입금액기준 3.3%를 계산합니다</td>
							</tr>
							<tr>
								<th>환급세액금액</th>
								<td style="padding-right: 15px;" align="right"><input
									id="lbl_b8" type="text" name="lbl_b8" readonly="readonly">원</td>
								<td><input id="lbl_b9" type="text" name="lbl_b9"
									readonly="readonly"> %</td>
								<td id="bigo">원천징수금액 대비 환급율</td>
							</tr>
						</tbody>
					</table>
				</div>

				<table class="chart2" border="0" cellspacing="0" cellpadding="0">
					<colgroup>
						<col width="40">
					</colgroup>
					<tbody>
						<tr>
							<th rowspan="6" id="ps">안내</th>
							<td class="right_text cal">개략적인 계산이므로 정확한 환급액은 반드시 세무사와
								상의하시기 바랍니다.
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</section>

	<%@include file="../c_common/footer.jsp"%>

</body>
<script type="text/javascript">


</script>
</html>