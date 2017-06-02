<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 	프로젝트인포 css 사용함    -->
	
<link rel="stylesheet" href="/resources/e_mypage_css/e_projectInfo.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/e_mypage_css/e_leftmenu.css"
	type="text/css" media="screen" />


<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>


<title>Insert title here</title>

</head>
<body>
<%@include file="../c_common/header_enterprise.jsp"%>

	<nav class="left_menu">
	<div class="left_menu_title">
		<h2>마이 페이지</h2>
	</div>
	<div class="left_menu_content">
		<ul class="left_menu_contents">
			<li><a href="e_info">기업 정보</a></li>
			<li><a href="e_project">프로젝트 관리</a></li>
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

		<form action="" method="post" name="ProjectWriteFm">
			<div id="content">
				<div class="tit_box">
					<h2>디비에서가져올프로젝트이름</h2>
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
								<td colspan="3"><input type="text" id="fm_comname"
									name="fm_comname" class="wid" value="" /></td>
							</tr>
							<tr>
								<th scope="row"><span class="txt_or">*</span> <label
									for="fm_korname">담당자명</label></th>
								<td colspan="3"><input type="text" id="fm_korname"
									name="fm_korname" class="wid01" value="" /></td>
							</tr>
							<tr>
								<th scope="row"><span class="txt_or">*</span> 담당자 연락처</th>
								<td><label for="fm_tel1"></label> <select class="wid03"
									name="fm_tel1" id="fm_tel1">
										<option value="02">02</option>
										<option value="031">031</option>
										<option value="032">032</option>
										<option value="033">033</option>
										<option value="041">041</option>
										<option value="042">042</option>
										<option value="043">043</option>
										<option value="051">051</option>
										<option value="052">052</option>
										<option value="053">053</option>
										<option value="054">054</option>
										<option value="055">055</option>
										<option value="061">061</option>
										<option value="062">062</option>
										<option value="063">063</option>
										<option value="064">064</option>
										<option value="0502">0502</option>
										<option value="0504">0504</option>
										<option value="0505">0505</option>
										<option value="0506">0506</option>
										<option value="0130">0130</option>
								</select> <span>-</span> <input type="text" id="fm_tel2" name="fm_tel2"
									class="wid03" value="" maxlength="4" /> <span>-</span> <input
									type="text" id="fm_tel3" name="fm_tel3" class="wid03" value=""
									maxlength="4" /></td>
								<th scope="row"><span class="txt_or">*</span> 담당자 휴대폰</th>
								<td><select class="wid03" name="fm_phone1" id="fm_phone1">
										<option value="">----</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
								</select> <span>-</span> <input type="text" id="fm_phone2"
									name="fm_phone2" class="wid03" value="" maxlength="4" /> <span>-</span>
									<input type="text" id="fm_phone3" name="fm_phone3"
									class="wid03" value="" maxlength="4" /></td>
							</tr>
							<tr>
								<th scope="row"><span class="txt_or">*</span> 담당자 이메일</th>
								<td colspan="3"><input type="text" id="fm_email11"
									name="fm_email11" class="wid04" value="" /> <span>@</span> <input
									type="text" id="fm_email12" name="fm_email12" class="wid04"
									value="" /> <select class="wid04" name="fm_emailSel1"
									id="fm_emailSel1" onChange="javascript:ChangeEMailIt('1');">
										<option value="">선택해주세요</option>
										<option value="etc">직접입력</option>
										<option value="gmail.com">gmail.com</option>
										<option value="naver.com">naver.com</option>
										<option value="nate.com">nate.com</option>
										<option value="daum.net">daum.net</option>
										<option value="dreamwiz.com">dreamwiz.com</option>
										<option value="lycos.co.kr">lycos.co.kr</option>
										<option value="empal.com">empal.com</option>
										<option value="yahoo.co.kr">yahoo.co.kr</option>
										<option value="chol.com">chol.com</option>
										<option value="korea.com">korea.com</option>
										<option value="paran.com">paran.com</option>
										<option value="hanafos.com">hanafos.com</option>
										<option value="hanmir.com">hanmir.com</option>
										<option value="hotmail.com">hotmail.com</option>
										<option value="hanmail.net">hanmail.net</option>
								</select></td>
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
								<td colspan="5"><input type="text" id="fm_name"
									name="fm_name" class="wid" /></td>
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
												name="fm_new_keyword[]" value=".NET"> .NET</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="ABAP"> ABAP</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="ANDROID"> ANDROID</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="ASP"> ASP</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="ASP.NET"> ASP.NET</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="C"> C</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="C#"> C#</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="C++"> C++</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="COBOL"> COBOL</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="CSS"> CSS</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="DB"> DB</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="DELPHI"> DELPHI</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="HTML"> HTML</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="IOS"> IOS</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="JAVA"> JAVA</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="JS"> JS</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="JSP"> JSP</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="LINUX"> LINUX</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="NETWORK"> NETWORK</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="PHP"> PHP</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="POWER BUILDER">
												POWER BUILDER</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="PYTHON"> PYTHON</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="QA"> QA</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="RUBY"> RUBY</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="SERVER개발"> SERVER개발</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="VB"> VB</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="VC++"> VC++</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="WINDOWS"> WINDOWS</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="임베디드"> 임베디드</td>
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
												name="fm_new_keyword[]" value="HTML5"> HTML5</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="그래픽디자인"> 그래픽디자인</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="모바일"> 모바일</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="액션스크립트"> 액션스크립트</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="웹디자인"> 웹디자인</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="웹표준"> 웹표준</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="파워포인트"> 파워포인트</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="퍼블리싱"> 퍼블리싱</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="포토샵편집"> 포토샵편집</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="플래시"> 플래시</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="3D"> 3D</td>
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
												name="fm_new_keyword[]" value="Oracle컨설턴트">
												Oracle컨설턴트</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="PM"> PM</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="PMO"> PMO</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="SAP컨설턴트"> SAP컨설턴트</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="기획"> 기획</td>
										</tr>
										<tr class="che_list011">
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="모바일기획"> 모바일기획</td>
											<td class="td_bor_bott"><input type="checkbox"
												name="fm_new_keyword[]" value="웹기획"> 웹기획</td>
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
								<td colspan="5"><textarea id="fm_content" name="fm_content"
										class="txt_area">
1.프로젝트명:

2.현재개발진행사항
1)총투입인력:
2)현재설계개발상태:

3.담당업무
1)

4.업무범위:

5.전달사항또는(개발)우대사항:
1)

6.필요인력:명

7.개발자필요Spec
1)
2)

8.근무지:

9.개발기간:

10.월단가:제시바람

11.장비지참여부:


                                </textarea></td>
							</tr>
							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
									연령</th>
								<td colspan="2"><select class="wid03" name="fm_fromAge"
									id="fm_fromAge">
										<option value=''>선택</option>
										<option value='0000'>연령무관</option>
										<option value='1998'>20세(1998년생)</option>
										<option value='1997'>21세(1997년생)</option>
										<option value='1996'>22세(1996년생)</option>
										<option value='1995'>23세(1995년생)</option>
										<option value='1994'>24세(1994년생)</option>
										<option value='1993'>25세(1993년생)</option>
										<option value='1992'>26세(1992년생)</option>
										<option value='1991'>27세(1991년생)</option>
										<option value='1990'>28세(1990년생)</option>
										<option value='1989'>29세(1989년생)</option>
										<option value='1988'>30세(1988년생)</option>
										<option value='1987'>31세(1987년생)</option>
										<option value='1986'>32세(1986년생)</option>
										<option value='1985'>33세(1985년생)</option>
										<option value='1984'>34세(1984년생)</option>
										<option value='1983'>35세(1983년생)</option>
										<option value='1982'>36세(1982년생)</option>
										<option value='1981'>37세(1981년생)</option>
										<option value='1980'>38세(1980년생)</option>
										<option value='1979'>39세(1979년생)</option>
										<option value='1978'>40세(1978년생)</option>
										<option value='1977'>41세(1977년생)</option>
										<option value='1976'>42세(1976년생)</option>
										<option value='1975'>43세(1975년생)</option>
										<option value='1974'>44세(1974년생)</option>
										<option value='1973'>45세(1973년생)</option>
										<option value='1972'>46세(1972년생)</option>
										<option value='1971'>47세(1971년생)</option>
										<option value='1970'>48세(1970년생)</option>
										<option value='1969'>49세(1969년생)</option>
										<option value='1968'>50세(1968년생)</option>

								</select> <span>~</span> <select class="wid03" name="fm_toAge"
									id="fm_toAge">
										<option value=''>선택</option>
										<option value='0000'>연령무관</option>
										<option value='1998'>20세(1998년생)</option>
										<option value='1997'>21세(1997년생)</option>
										<option value='1996'>22세(1996년생)</option>
										<option value='1995'>23세(1995년생)</option>
										<option value='1994'>24세(1994년생)</option>
										<option value='1993'>25세(1993년생)</option>
										<option value='1992'>26세(1992년생)</option>
										<option value='1991'>27세(1991년생)</option>
										<option value='1990'>28세(1990년생)</option>
										<option value='1989'>29세(1989년생)</option>
										<option value='1988'>30세(1988년생)</option>
										<option value='1987'>31세(1987년생)</option>
										<option value='1986'>32세(1986년생)</option>
										<option value='1985'>33세(1985년생)</option>
										<option value='1984'>34세(1984년생)</option>
										<option value='1983'>35세(1983년생)</option>
										<option value='1982'>36세(1982년생)</option>
										<option value='1981'>37세(1981년생)</option>
										<option value='1980'>38세(1980년생)</option>
										<option value='1979'>39세(1979년생)</option>
										<option value='1978'>40세(1978년생)</option>
										<option value='1977'>41세(1977년생)</option>
										<option value='1976'>42세(1976년생)</option>
										<option value='1975'>43세(1975년생)</option>
										<option value='1974'>44세(1974년생)</option>
										<option value='1973'>45세(1973년생)</option>
										<option value='1972'>46세(1972년생)</option>
										<option value='1971'>47세(1971년생)</option>
										<option value='1970'>48세(1970년생)</option>
										<option value='1969'>49세(1969년생)</option>
										<option value='1968'>50세(1968년생)</option>

								</select></td>
								<th scope="row" class="ac"><span class="txt_or"></span> 학력</th>
								<td colspan="2"><select class="wid04" name="fm_school"
									id="fm_school">
										<option value=''>선택</option>
										<option value='0000000'>학력무관</option>
										<option value='M060100'>고등학교</option>
										<option value='M060200'>대학(2,3년)</option>
										<option value='M060300'>대학교(4년)</option>
										<option value='M060400'>대학원(석사)</option>
										<option value='M060500'>대학원(박사)</option>
								</select></td>
							</tr>
							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
									인원</th>
								<td colspan="2"><input type="text" id="fm_number"
									name="fm_number" class="wid05" /> <label for="fm_number">명</label>
									(전체 참여인원 : <input type="text" id="fm_totalnumber"
									name="fm_totalnumber" class="wid05" /> <label
									for="fm_totalnumber">명)</label></td>
								<th scope="row" class="ac"><span class="txt_or">*</span>모집마감일자</th>
								<td colspan="2"><input type="text" id="fm_bidedate"
									name="fm_bidedate" class="day_inp"
									onClick="CalenderIt('ProjectWriteFm', 'fm_bidedate');" readonly />
									<input type="hidden" name="fm_bidsdate" value="2017-04-25">
								</td>
							</tr>
							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>프로젝트
									금액(월단위)</th>
								<td colspan="5"><input type="radio" name="fm_moneytype"
									value="A" checked> <label for="fm_minmoney"></label> <input
									type="text" id="fm_minmoney" name="fm_minmoney" class="wid03"
									onKeyPress="javascript:CheckMoney('ProjectWriteFm','fm_minmoney');"
									onKeyUp="javascript:CheckMoney('ProjectWriteFm','fm_minmoney');" />
									<span>원 ~ </span> <label for="fm_maxmoney"></label> <input
									type="text" id="fm_maxmoney" name="fm_maxmoney" class="wid03"
									onKeyPress="javascript:CheckMoney('ProjectWriteFm','fm_maxmoney');"
									onKeyUp="javascript:CheckMoney('ProjectWriteFm','fm_maxmoney');" />
									<span>원 &nbsp;</span> <input type="radio" name="fm_moneychk"
									value="Y" checked> 협의가능&nbsp; <input type="radio"
									name="fm_moneychk" value="N"> 협의불가 <span
									class="txt_red">* VAT별도 금액입니다.</span> <br />
								<input type="radio" name="fm_moneytype" value="B"> <span
									class="txt_red" style="float: none;">가격제안 요청</span></td>
							</tr>

							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>근무기간</th>
								<td colspan="5"><input type="text" id="fm_worksdate"
									name="fm_worksdate" class="day_inp"
									onClick="CalenderIt('ProjectWriteFm', 'fm_worksdate');"
									readonly /> <span> ~ </span> <input type="text"
									id="fm_workedate" name="fm_workedate" class="day_inp"
									onClick="CalenderIt('ProjectWriteFm', 'fm_workedate');"
									readonly /></td>
							</tr>

							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
									근무지</th>
								<td colspan="5"><select class="JobPlace" name="JobPlace1"
									id="JobPlace1">
										<option value="">시, 도</option>
										<option value="1">서울특별시</option>
										<option value="2">부산광역시</option>
										<option value="3">대구광역시</option>
										<option value="4">인천광역시</option>
										<option value="5">광주광역시</option>
										<option value="6">대전광역시</option>
										<option value="7">울산광역시</option>
										<option value="8">세종특별자치시</option>
										<option value="9">경기도</option>
										<option value="10">강원도</option>
										<option value="11">충청북도</option>
										<option value="12">충청남도</option>
										<option value="13">전라북도</option>
										<option value="14">전라남도</option>
										<option value="15">경상북도</option>
										<option value="16">경상남도</option>
										<option value="17">제주특별자치도</option>
										<option value="18">해외</option>
								</select> <select id="sigungu" class="selecter-element" name="sigungu"
									onclick="progress_check()" required="required" tabindex="-1">
										<option value="">시, 군, 구</option>
										<!-- 시, 도 선택후 나옴  -->
								</select>
							</tr>
							<tr>
								<th scope="row" colspan="2" class="ac"><span class="txt_or">*</span>
									희망 경력년수</th>
								<td colspan="5"><select class="wid03" name="fm_career1"
									id="fm_career1">
										<option value="99" selected>상관없음</option>
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
								</select> 
								</select></td>
							</tr>

						</tbody>
					</table>
				</div>
				<!-- //tb_box : e -->
				<div class="btn_box">
					<input class="btn btn-lg btn-default js-disable-on-click"
						autocomplete="off" data-loading-text="저장 중" name="save_for_later"
						value="수정 요청" type="submit">
				</div>
			</div>
		</form>
	</div>


<%@include file="../c_common/footer.jsp"%>
</body>
</html>