<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../../resources/c_join_css/join.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../../../resources/c_join_css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../c_common/header.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../c_common/footer.css" type="text/css" media="screen" />
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="../../../resources/c_join_js/c_join_step3.js"></script>
<script type="text/javascript" src="../../../resources/c_join_js/zipAddress.js"></script>
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
/* function inputIdChk(){
    document.userInfo.idDuplication.value ="idUncheck";
}

	
	if(document.getElementById("check").value != null){
		if(check == "1"){
			alert('그거쓰지마');
		}else{
			alert('중복확인 성공');
		}	
	}
 */


</script>

</head>
<body>
<%@include file="../c_common/header.jsp" %>

	<div id="container">
		<div id="nav">
			<div class="nav_txt">
				<p>
					<a href="/index.php">Home</a> <span class="padd">&gt;</span> <span>회원가입</span>
				</p>
			</div>
		</div>
		<div id="content">
			<div class="tit_box">
				<h2>회원가입</h2>
				<p class="tit_txt">
					성공적인 프로젝트를 원하시나요?<span>검증된 IT 인재가 대기중입니다.</span>
				</p>


			</div>
			<!-- //tit_box : e -->
			<ul class="step_cont03">
				<li class="step01"><span>Step01</span>회원안내</li>
				<li class="step02"><span>Step02</span>실명확인/약관동의</li>
				<li class="step03"><span>Step03</span>회원정보입력</li>
				<li class="step04"><span>Step04</span>가입완료</li>
			</ul>
			<div class="tb_box">
				<div class="ct overf">
					<h4 class="fl">아이디 및 비밀번호</h4>
					<p class="star_txt">
						<span class="color_or">(*)</span>표시는 필수 입력사항입니다
					</p>
				</div>
				<table class="tb_st01">
					<form name="userInfo" method="post" action="e_join_step3">
						<input type="hidden" name="fm_type" value="바이어"> 
						<input type="hidden" name="fm_format" value="기업"> 
						<input type="hidden" name="fm_str"
							value="Zm1fbmFtZT0mZm1fanVtaW49LTk5OTk5OSZzdHJWbm89"> 
						<input type="hidden" name="fm_keyword" value=""> 
						<input type="hidden" name="strPageCode1"
							value="ZXdMZjhRelA5Z1FXbTJWZ0Zpa0R2SzRMSWU="> 
						<input type="hidden" name="fm_join" value="">
						<caption></caption>
						<colgroup>
							<col style="width: 16%" />
							<col style="width: 34%" />
							<col style="width: 16%" />
							<col style="width: 34%" />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row" class="ac"><label for="e_id"><span
										class="txt_or">*</span> 회원아이디</label></th>
								<td colspan="3">
								<!-- <form id="checkForm" name="checkForm" action="e_memberIdCheck.e_join" method="post"> -->
								<input type="text" id="e_id" name="e_id"> 
								<input type="button"  id="idCheckbox" value="중복확인" class="btn_overlap" >	
								<input type="hidden" name="idDuplication" value="idUncheck" >				
									* 6~15자의 영문, 영문+숫자, 일부 특수문자( _ - )만 사용 가능합니다.</td>
								<!-- </form> -->
								<input type="text" hidden id="check" value="${check}">
							</tr>
							<tr>
								<th scope="row" class="ac"><label for="e_pwd"><span
										class="txt_or">*</span> 비밀번호</label></th>
								<td><input type="password" id="e_pwd"
									name="e_pwd" class="wid02" /></td>
								<th scope="row" class="ac"><label for="e_pwdcheck"><span
										class="txt_or">*</span> 비밀번호 확인</label></th>
								<td><input type="password" id="e_pwdcheck"
									name="e_pwdcheck" class="wid02" /></td>
							</tr>
						</tbody>
						
				</table>
			</div>
			<!-- //tb_box01 : e -->
			<div class="tb_box">
				<h4 class="fl">기업정보</h4>
				<table class="tb_st01">
					<caption></caption>
					<colgroup>
						<col style="width: 16%" />
						<col style="width: 17%" />
						<col style="width: *" />
						
					</colgroup>
					<tbody>
					   <tr>
							<td rowspan="5">
                              	<img src="c_join_img/join_photo.jpg" alt="사진" id="img_box"/>
								<input type="file" name="e_ownerfile"  id="e_ownerfile" style="width:130px;" onchange="fileInfo(this)"/>
                            </td>
							<th scope="row"><label for="e_name"><span class="txt_or">*</span> 가입자명</label></th>
							<td colspan="4">
								<input type="text" id="e_name" name="e_name" class="wid04" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="e_ename"><span class="txt_or">*</span> 회사명</label></th>
							<td colspan="4"><input type="text" id="e_ename" name="e_ename" class="wid06" /></td>
						</tr>
						<tr>
							<th scope="row"><label for="e_owner"><span
									class="txt_or">*</span> 대표자명</label></th>
							<td colspan="4"><input type="text" id="e_owner" name="e_owner"
								class="wid04" /></td>
						</tr>
						<tr>
							<th><span class="txt_or">*</span> 회사 이메일</th>
							<td colspan="4"><label for="e_mail1"></label> <input
								type="text" id="e_mail1" name="e_mail1" class="wid02">
								<span>@</span> <label for="e_mail2"></label> <input
								type="text" id="e_mail2" name="e_mail2" class="wid02">
								<label for="e_mail3"></label> <select class="wid02"
								name="e_mail3" id="e_mail3">
									<option value="선택해주세요.">선택해주세요.</option>
									<option value="">직접입력</option>
									<option value="gmail.com"> gmail.com</option>
									<option value="naver.com"> naver.com</option>
									<option value="nate.com"> nate.com</option>
									<option value="daum.net"> daum.net</option>
									<option value="dreamwiz.com"> dreamwiz.com</option>
									<option value="lycos.co.kr"> lycos.co.kr</option>
									<option value="empal.com"> empal.com</option>
									<option value="yahoo.co.kr"> yahoo.co.kr</option>
									<option value="chol.com"> chol.com</option>
									<option value="korea.com"> korea.com</option>										
									<option value="paran.com"> paran.com</option>
									<option value="hanafos.com"> hanafos.com</option>
									<option value="hanmir.com"> hanmir.com</option>								
									<option value="hotmail.com"> hotmail.com</option>
									<option value="hanmail.net"> hanmail.net</option>
							</select></td>
						</tr>
						<tr>
							<th scope="row"><span class="txt_or">*</span> 사업자 등록번호</th>
							<td colspan="4"><label for="e_regno1"></label> <input type="text"
								id="e_regno1" name="e_regno1" class="wid03" maxlength="3" />
								- <label for="e_regno2"></label> <input type="text"
								id="e_regno2" name="e_regno2" class="wid03" maxlength="2" />
								- <label for="e_regno3"></label> <input type="text" id="e_regno3"
								name="e_regno3" class="wid03" maxlength="5" /></td>
						</tr>
						
						<tr>
							<th scope="row"><label for="e_bf"><span
									class="txt_or">*</span> 주요사업내용</label></th>
							<td colspan="5"><input type="text" id="e_bf"
								name="e_bf" class="wid06" /></td>
						</tr>
						<tr>
							<th scope="row"><label for="manager_name"><span
									class="txt_or">*</span> 담당자명</label></th>
							<td colspan="5"><input type="text" id="manager_name"
								name="manager_name" class="wid02" /></td>
						</tr>
						<tr>
							<th scope="row"><label for="manager_hphone1"><span
									class="txt_or">*</span> 담당자 연락처</label></th>
							<td colspan="5"><label for="manager_hphone1"></label> <select class="wid03"
								name="manager_hphone1" id="manager_hphone1">
									<option value="">----</option>
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
							</select> <span>-</span> <label for=""></label> <input type="text"
								id="manager_hphone2" name="manager_hphone2" class="wid03" maxlength="4">
								<span>-</span> <label for=""></label> <input type="text"
								id="manager_hphone3" name="manager_hphone3" class="wid03" maxlength="4">
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="e_phone1"><span
									class="txt_or">*</span> 연락처(대표전화)</label></th>
							<td colspan="5"><label for="e_phone1"></label> <select
								class="wid03" name="e_phone1" id="e_phone1">
									<option value="">----</option>
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
									<option value="070">070</option>
							</select> <span>-</span> <label for="e_phone2"></label> <input type="text"
								id="e_phone2" name="e_phone2" class="wid03" maxlength="4">
								<span>-</span> <label for="e_phone3"></label> <input type="text"
								id="e_phone3" name="e_phone3" class="wid03" maxlength="4">
							</td>
						</tr>
						<tr>
							<th><span class="txt_or"></span>담당자 이메일</th>
							<td colspan="5"><label for="manager_mail1"></label> <input
								type="text" id="manager_mail1" name="manager_mail1" class="wid04">
								<span>@</span> <label for="manager_mail2"></label> <input
								type="text" id="manager_mail2" name="manager_mail2" class="wid04">
								<label for="manager_mail3"></label> <select class="wid04"
								name="manager_mail3" id="manager_mail3" >
									<option value="선택해주세요.">선택해주세요.</option>
									<option value="">직접입력</option>
									<option value="gmail.com"> gmail.com</option>
									<option value="naver.com"> naver.com</option>
									<option value="nate.com"> nate.com</option>
									<option value="daum.net"> daum.net</option>
									<option value="dreamwiz.com"> dreamwiz.com</option>
									<option value="lycos.co.kr"> lycos.co.kr</option>
									<option value="empal.com"> empal.com</option>
									<option value="yahoo.co.kr"> yahoo.co.kr</option>
									<option value="chol.com"> chol.com</option>
									<option value="korea.com"> korea.com</option>										
									<option value="paran.com"> paran.com</option>
									<option value="hanafos.com"> hanafos.com</option>
									<option value="hanmir.com"> hanmir.com</option>								
									<option value="hotmail.com"> hotmail.com</option>
									<option value="hanmail.net"> hanmail.net</option>
							</select></td>
						</tr>
						<tr>
							<th><span class="txt_or">*</span> 회사주소</th>
							<td colspan="5">
								<div class="mb10">
									<label for="e_address1"></label><input type="text" id="e_address1" 
									name="e_address1" class="wid60" title="주소검색 새창" readonly=""> 
									<input type = "button" onClick = "openDaumZipAddress()" value = "주소 찾기" class="btn_add"/>
								</div>
								<div class="mb10">
									<label for="e_address2"></label> 
										<input type="text" id="e_address2" name="e_address2" class="wid06">
								</div>
								<div class="mb10">
									<label for="e_address3"></label> 
										<input type="text" id="e_address3" name="e_address3" class="wid06">
								</div>
							</td>
						</tr>

						<tr>
							<th><label for="e_homepage">회사 홈페이지</label></th>
							<td colspan="5">
								<div>
									<span>http://</span> <input type="text" id="e_homepage"
										name="e_homepage" class="wid06">
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row" rowspan="2">기업정보</th>
							<th scope="col" class="ac">설립년도</th>
							<th scope="col" class="ac">사원수</th>
							<th scope="col" class="ac">상장여부</th>
							<th scope="col" class="ac">자본금</th>
							<th scope="col" class="ac">매출액</th>
					</tr>
					<tr >
						<td><input type="text" id="start_year" name="start_year"
							class="wid03" maxlength="4" value=""><label
							for="start_year"> 년</label></td>
						<td><input type="text" id="e_enum" name="e_enum"
							class="wid03" value=""><label for="e_enum"> 명</label>
						</td>
						<td><select class="wid07" name="e_listing" id="e_listing">
							<option value="비상장" selected="">비상장</option>
							<option value="코스피">코스피상장</option>
							<option value="코스닥">코스닥상장</option>
							<option value="나스닥">해외(나스닥)</option>
							<option value="자스닥">해외(자스닥)</option>
							<option value="해외기타">해외(기타)</option>
						</select></td>
						<td><input type="text" id="e_capital"
								name="e_capital" class="wid03" value=""><label
								for="e_capital"> 만원</label></td>
						<td><input type="text" id="e_sales"
								name="e_sales" class="wid03" value=""> 만원</td>
					</tr>
					<tr>
						<th><label for="e_scale">기업 형태</label></th>
						<td colspan="5"><select class="wid07" name="e_scale"
								id="e_scale">
							<option value="">--기업형태--</option>
							<option value="M040100">일반기업</option>
							<option value="M040200">대기업</option>
							<option value="M040300">중소기업</option>
							<option value="M040400">외국기업</option>
							<option value="M040500">벤처기업</option>
							<option value="M040600">정부기관</option>
							<option value="M040700">공사/공기업</option>
							<option value="M040800">공공기관</option>
							<option value="M040900">교육기업</option>
							<option value="M041000">협회</option>
							<option value="M041100">개인</option>
							<option value="M049900">기타</option>
						</select></td>
					</tr>
					<tr>
						<th><span class="txt_or">*</span> 사업자등록증</th>
						<td colspan="5">
							<div>
								<input type="file" id="e_licensefile" name="e_licensefile" class="wid06">
							</div>
						</td>
					</tr>

					</tbody>
				</table>
			</div>


			<div class="btn_box">
			<input type="submit" class="btn_check04" id="checkValue" value="회원가입">
				<a href="javascript:MemberWriteFm.reset();" class="btn_check02">초기화</a>
			</div>
		</div>
</form>


<%@include file="../c_common/footer.jsp" %>
</body>
</html>