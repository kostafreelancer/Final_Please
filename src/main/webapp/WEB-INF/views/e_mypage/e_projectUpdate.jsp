<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC"-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="/resources/e_mypage_css/e_projectUpdate.css"
	type="text/css" media="screen" />

	
	
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>

<script type="text/javascript" src="/resources/e_mypage_js/e_projectUpdate.js"></script>
<script type="text/javascript" src="/resources/e_mypage_js/e_projectUpdate2.js"></script>
<script type="text/javascript" src="/resources/e_mypage_js/calendar.js"></script>
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
	<%@include file="../c_common/header.jsp" %>
	<!-- //header_wrap : e -->
	<div id="conainer">
		<div id="nav">
			<div class="nav_txt">
				<p>
					<a href="/e_lan/index.php">Home</a> <span class="padd">&gt;</span>
					<span>프로젝트 수정</span>
				</p>
			</div>
		</div>
		<div id="content">
			<div class="tit_box">
				<h2>프로젝트 수정</h2>




				<div class="market">
					<br>
					<br>
					<br>
					<br>
					<br>

				</div>
				<!-- //market : e -->
				<div class="table_tit">
					<h3>프로젝트 수정의뢰</h3>
					<div class="fr">
						<p>
							<span class="txt_or">(*) </span>표시는 필수 입력사항입니다.
						</p>
					</div>
				</div>
				<!-- table_tit : e -->
				<div class="tb_box">
					<h4>담당자 정보</h4>
					<table class="tb_st01">
						<form method="post" name="ProjectWriteFm">
						<input type="hidden" name="e_num" value="${client.e_num }"></input>
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
									<td colspan="3">${manager_hphone_1 }
									<span>-</span>${manager_hphone_2 } 
									<span>-</span> ${manager_hphone_3 } 
										</td>
								</tr>
								<tr>
									<th scope="row"><span class="txt_or">*</span> 담당자 이메일</th>
									<td colspan="3">${manager_mail_1 }<span>@</span>
									${manager_mail_2 }
									 
									</td>
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
								<td colspan="5"><input type="text" id="p_name"
									name="p_name" class="wid" value="${project.p_name }"/></td>
							</tr>
							<tr>
								<th scope="row" rowspan="3" class="ac"><span class="txt_or">*</span>기본분야</th>
								<th scope="row" class="ac"><span class="txt_or"></span>개발</th>
								<td colspan="5" style="border-bottom: solid 0px #dadada" bgcolor="#ffffff">

									<table width="100%">
										<colgroup>
											<col width="20%" />
											<col width="20%" />
											<col width="20%" />
											<col width="20%" />
											<col width="20%" />
										</colgroup>
										<tr class="che_list011">
											<td class="td_bor_bott">
											<input type="checkbox"
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
												name="check" value="21">
												POWER BUILDER</td>
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
									</table> <!--img src="../img/sb_category.gif" width="87" height="18" align="absmiddle"-->
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
									</table> <!--img src="../img/sb_category.gif" width="87" height="18" align="absmiddle"-->
								</td>
							</tr>


							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or"></span><label
									for="p_content">상세내용</label></th>
								<td colspan="5"><textarea id="p_content" name="p_content"
										class="txt_area">
										${project.p_content }
                                </textarea></td>
							</tr>
							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
									연령</th>
								<td colspan="2"><select class="wid03" name="p_lowerage"
									id="p_lowerage">
										<option value=''>선택</option>
										<option value='0000'>연령무관</option>
										<option value='20'>20세(1998년생)</option>
										<option value='21'>21세(1997년생)</option>
										<option value='22'>22세(1996년생)</option>
										<option value='23'>23세(1995년생)</option>
										<option value='24'>24세(1994년생)</option>
										<option value='25'>25세(1993년생)</option>
										<option value='26'>26세(1992년생)</option>
										<option value='27'>27세(1991년생)</option>
										<option value='28'>28세(1990년생)</option>
										<option value='29'>29세(1989년생)</option>
										<option value='30'>30세(1988년생)</option>
										<option value='31'>31세(1987년생)</option>
										<option value='32'>32세(1986년생)</option>
										<option value='33'>33세(1985년생)</option>
										<option value='34'>34세(1984년생)</option>
										<option value='35'>35세(1983년생)</option>
										<option value='36'>36세(1982년생)</option>
										<option value='37'>37세(1981년생)</option>
										<option value='38'>38세(1980년생)</option>
										<option value='39'>39세(1979년생)</option>
										<option value='40'>40세(1978년생)</option>
										<option value='41'>41세(1977년생)</option>
										<option value='42'>42세(1976년생)</option>
										<option value='43'>43세(1975년생)</option>
										<option value='44'>44세(1974년생)</option>
										<option value='45'>45세(1973년생)</option>
										<option value='46'>46세(1972년생)</option>
										<option value='47'>47세(1971년생)</option>
										<option value='48'>48세(1970년생)</option>
										<option value='49'>49세(1969년생)</option>
										<option value='50'>50세(1968년생)</option>

								</select> <span>~</span> <select class="wid03" name="p_upperage"
									id="p_upperage">
										<option value=''>선택</option>
										<option value='0000'>연령무관</option>
										<option value='20'>20세(1998년생)</option>
										<option value='21'>21세(1997년생)</option>
										<option value='22'>22세(1996년생)</option>
										<option value='23'>23세(1995년생)</option>
										<option value='24'>24세(1994년생)</option>
										<option value='25'>25세(1993년생)</option>
										<option value='26'>26세(1992년생)</option>
										<option value='27'>27세(1991년생)</option>
										<option value='28'>28세(1990년생)</option>
										<option value='29'>29세(1989년생)</option>
										<option value='30'>30세(1988년생)</option>
										<option value='31'>31세(1987년생)</option>
										<option value='32'>32세(1986년생)</option>
										<option value='33'>33세(1985년생)</option>
										<option value='34'>34세(1984년생)</option>
										<option value='35'>35세(1983년생)</option>
										<option value='36'>36세(1982년생)</option>
										<option value='37'>37세(1981년생)</option>
										<option value='38'>38세(1980년생)</option>
										<option value='39'>39세(1979년생)</option>
										<option value='40'>40세(1978년생)</option>
										<option value='41'>41세(1977년생)</option>
										<option value='42'>42세(1976년생)</option>
										<option value='43'>43세(1975년생)</option>
										<option value='44'>44세(1974년생)</option>
										<option value='45'>45세(1973년생)</option>
										<option value='46'>46세(1972년생)</option>
										<option value='47'>47세(1971년생)</option>
										<option value='48'>48세(1970년생)</option>
										<option value='49'>49세(1969년생)</option>
										<option value='50'>50세(1968년생)</option>

								</select></td>
								<th scope="row" class="ac"><span class="txt_or"></span> 학력</th>
								<td colspan="2"><select class="wid04" name="p_academic"
									id="p_academic">
										<option value=''>선택</option>
										<option value='학력무관'>학력무관</option>
										<option value='고등학교'>고등학교</option>
										<option value='대학(2,3년)'>대학(2,3년)</option>
										<option value='대학교(4년)'>대학교(4년)</option>
										<option value='대학원(석사)'>대학원(석사)</option>
										<option value='대학원(박사)'>대학원(박사)</option>
								</select></td>
							</tr>
							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
									모집인원</th>
								<td colspan="2"><input type="text" id="p_requirenum"
									name="p_requirenum" class="wid05" value=""/> 
									<label for="p_requirenum">명</label>
									</td>
								<th scope="row" class="ac"><span class="txt_or">*</span> <label
									for="fm_bidedate">모집마감일자</label></th>
								<td colspan="2"><input type="text"  id="txtDate3" name="p_exdate" onClick="fnPopUpCalendar(txtDate3,txtDate3,'yyyy/mm/dd')"  class="day_inp" />
								
							</td>
							</tr>
							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>프로젝트
									금액(월단위)</th>
								<td colspan="5"><label for="fm_minmoney"></label> 
								<input type="text" id="p_lowercost" name="p_lowercost" class="wid03" value="" onKeyPress="javascript:CheckMoney('ProjectWriteFm','fm_minmoney');" onKeyUp="javascript:CheckMoney('ProjectWriteFm','fm_minmoney');" />
								<span>만원 ~ </span>
								<label for="fm_maxmoney"></label>
								<input type="text" id="p_uppercost" name="p_uppercost" class="wid03" value="" onKeyPress="javascript:CheckMoney('ProjectWriteFm','fm_maxmoney');" onKeyUp="javascript:CheckMoney('ProjectWriteFm','fm_maxmoney');" />
								<span>만원 &nbsp;</span> 
							
								<span class="txt_red">* VAT별도 금액입니다.</span> <br />
							
							</tr>

							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>근무기간</th>
								<td colspan="5">
								<input type="text"  id="txtDate" name="p_startdate" onClick="fnPopUpCalendar(txtDate,txtDate,'yyyy/mm/dd')"  class="day_inp" />
								<span> ~ </span>
								<input type="text" id="txtDate2" name="p_enddate" onClick="fnPopUpCalendar(txtDate2,txtDate2,'yyyy/mm/dd')"  class="day_inp" />
								</td>
							</tr>

							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
									근무지</th>
								<td colspan="5">
								<select id="select1" name="p_location1" style="width: 80px; margin-top: 10px;" onchange="javscript:fnSelect(this);"> 
								<option value="">시, 도</option>
								<option value="서울특별시">서울특별시</option>
								<option value="부산광역시">부산광역시</option>
								<option value="대구광역시">대구광역시</option>
								<option value="인천광역시">인천광역시</option>
								<option value="광주광역시">광주광역시</option>
								<option value="대전광역시">대전광역시</option>
								<option value="울산광역시">울산광역시</option>
								<option value="경기도">경기도</option>
								<option value="강원도">강원도</option>
								<option value="충청북도">충청북도</option>
								<option value="충청남도">충청남도</option>
								<option value="전라북도">전라북도</option>
								<option value="전라남도">전라남도</option>
								<option value="경상북도">경상북도</option>
								<option value="경상남도">경상남도</option>
								<option value="제주특별자치도">제주특별자치도</option>
								</select> 
								
								<select id="select2" name="p_location2" style="width: 80px; margin-top: 10px;" onchange="javscript:fnSelect(this);"> 
								<option value="">시, 군, 구</option> 
							
							
							
							
							
								</select>



							</tr>
							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
									희망 경력년수</th>
								<td colspan="5"><select class="wid03" name="p_experience"
									id="p_experience">
										<option value="">상관없음</option>
										<option value="01">1 년차</option>
										<option value="02">2 년차</option>
										<option value="03">3 년차</option>
										<option value="04">4 년차</option>
										<option value="05">5 년차</option>
										<option value="06">6 년차</option>
										<option value="07">7 년차</option>
										<option value="08">8 년차</option>
										<option value="09">9 년차</option>
										<option value="10">10 년차</option>
										<option value="11">11 년차</option>
										<option value="12">12 년차</option>
										<option value="13">13 년차</option>
										<option value="14">14 년차</option>
										<option value="15">15 년차</option>
										<option value="16">16 년차</option>
										<option value="17">17 년차</option>
										<option value="18">18 년차</option>
										<option value="19">19 년차</option>
										<option value="20">20 년차</option>
								</select></td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="btn_box">
					<input id="checkValue" class="btn btn-lg btn-client js-disable-on-click btn-submit" autocomplete="off" data-loading-text="제출 중" name="post_a_job"
						value="프로젝트 정보 수정완료" type="submit">
						</div>
						</div>
						</div>
		</form>
	</div>
	<%@include file="../c_common/footer.jsp"%>
</body>
</html>