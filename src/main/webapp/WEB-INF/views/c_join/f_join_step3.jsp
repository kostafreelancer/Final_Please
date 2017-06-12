<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<link rel="stylesheet" href="../../../resources/c_join_css/join.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../../../resources/c_join_css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../c_common/header.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../c_common/footer.css" type="text/css" media="screen" />
<title>회원가입</title>
<style type="text/css">
#duplicateResult{
	color: red;
	font-size: 12px;
	font-weight: bold;
}
</style>


<script type="text/javascript" src="../../../resources/c_join_js/c_join_step3.js"></script>
<script type="text/javascript" src="../../../resources/c_join_js/f_zipAddress.js"></script>
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
 <script type="text/javascript">
 




 
 
 
  function checkcheck(){

 var pattern = /[A-Za-z0-9_]{3,15}$/;

		$.ajax({
			url : "duplicationCheck",
			type : "get",
			data : "id="+$("#f_id").val(),
		
			success : function(data) {
 				
				 
				if (data== true) {
					if(!pattern.test($("#f_id").val() )) {
						$("#duplicateResult").html("3~15자의 영문, 숫자만 가능합니다.");
					}else{
						$("#duplicateResult").html("사용 가능한 아이디입니다.");
						$("#idDuplication").val("idCheck");
					}
				} else {
					$("#duplicateResult").html("중복된 아이디입니다.");
				}
			},
			error : function(error) {
				alert(error.statusText);
				
			}
		});

 } 

//이메일인증

 var checkEmail = function(index) {
	
      if(index == 1){
    	  
    	 var url="/testEmail";
  	    var newWin = window.open(url,"new", "width=400,height=400,");
  	    var f = document.f_userInfo;
  	    f.action="/c_join/testEmail";
  	    f.target="new";
  	    f.method="post";
  	    f.submit();  
      }
      if(index ==2){
    	  var f = document.f_userInfo;
    	  f.action="f_join_step3";
    	  f.target="";
    	  f.method="post";
    	  f.submit();
      }
      
}


  

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

				<div class="content">

			<ul class="step_cont03">
            	<li class="step01"><span>Step01</span>회원안내</li>
                <li class="step02"><span>Step02</span>실명확인/약관동의</li>
                <li class="step03"><span>Step03</span>회원정보입력</li>
                <li class="step04"><span>Step04</span>가입완료</li>
            </ul>
       		 <div class="tb_box">
             	<div class="ct overf">
                    <h4 class="fl">아이디 및 비밀번호</h4>
                    <p class="star_txt"><span class="color_or">(*)</span>표시는 필수 입력사항입니다</p>
                </div>
                <table class="tb_st01">
				<form name="f_userInfo" method="post">
					<input type="hidden" name="fm_type" value="이랜서">
					<input type="hidden" name="fm_format" value="개인">
					<input type="hidden" name="fm_str" value="Zm1fbmFtZT0mZm1fanVtaW49LTk5OTk5OSZzdHJWbm89">
					<input type="hidden" name="fm_keyword" value="">
					<input type="hidden" name="strPageCode1" value="ZU1MMDhkekg5NFEybTBWc0ZRa3B2RDRMSWU=">
					<input type="hidden" name="fm_join" value="">
                    <colgroup>
                        <col style="width:16%" />
                        <col style="width:34%" />
                        <col style="width:16%" />
                        <col style="width:34%" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th scope="row" class="ac"><label for="f_id"><span class="txt_or">*</span> 회원아이디</label></th>
                            <td colspan="3">
                               <input type="text" id="f_id" name="f_id" />
                               <input type="button" value="중복확인" class="btn_overlap"  onClick="checkcheck()">    
            				   <input type="hidden" id="idDuplication" name="idDuplication" value="idUncheck"/>
            				   <span id="duplicateResult"></span>
                                * 3~15자의 영문, 영문+숫자, 일부 특수문자( _ )만 사용 가능합니다.
                             
                            </td>
                        </tr>
                        <tr>
                             <th scope="row" class="ac"><label for="f_pwd"><span class="txt_or">*</span> 비밀번호</label></th>
                            <td>
                                <input type="password" id="f_pwd" name="f_pwd"  class="wid02"/>
                            </td>
                             <th scope="row" class="ac"><label for="f_pwdcheck"><span class="txt_or">*</span> 비밀번호 확인</label></th>
                            <td>
                                <input type="password" id="f_pwdcheck" name="f_pwdcheck"  class="wid02"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- //tb_box01 : e -->
            <div class="tb_box">
             	<h4 class="fl">개인정보</h4>
                <table class="tb_st01">
                     <colgroup>
                        <col style="width:16%" />
                        <col style="width:17%" />
                        <col style="width:*" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <td rowspan="5">
                              	<img src="c_join_img/join_photo.jpg" alt="사진" />
								<input type="file" name="f_fname" onchange="PreView(this.value, 'IMG1', '132', '176');" style="width:130px;" />
                                <span class="pho_txt">최적 해상도:132x176 pixel</span>
                            </td>
                            <th scope="row"><label for="f_name"><span class="txt_or">*</span> 성명</label></th>
                            <td colspan="4">
                            	<input type="text" id="f_name" name="f_name"  class="wid04" value=""/>
                            </td>
                        </tr>
                         <tr>
                            <th scope="row"><label for="f_birth"><span class="txt_or">*</span> 생년월일</label></th>
                            <td colspan="4">
                            	<input type="text" id="f_birth" name="f_birth"  class="wid04" maxlength="6"/>
                                <select name="f_sex">
                                	<option value="1" selected>남자</option>
                                    <option value="2">여자</option>
                                </select>
                                <span class="mail_ma"> * 주민번호 앞 6자리를 입력해주세요.</span>
                            </td>
                        </tr>
                         <tr>
                            <th scope="row"><label for="f_hphone1"><span class="txt_or">*</span> 연락처(휴대폰)</label></th>
                            <td colspan="4">
								<select name="f_hphone1">
									<option value="" selected>----</option>
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
								</select>
                                    <span>-</span>
                                    <label for="f_hphone2"></label>
                                    <input type="text" id="f_hphone2" name="f_hphone2" class="wid03" maxlength="4">
                                    <span>-</span>
                                    <label for="f_hphone3"></label>
                                    <input type="text" id="f_hphone3" name="f_hphone3" class="wid03" maxlength="4">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="f_phone1">연락처(전화)</label></th>
                            <td colspan="4">
                            	  <label for="f_phone1"></label>
                                    <select class="wid03" name="f_phone1">
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
										<option value="0502">0502</option>
										<option value="0504">0504</option>
										<option value="0505">0505</option>
										<option value="0506">0506</option>
										<option value="0130">0130</option>
                                    </select>
                                    <span>-</span>
                                    <label for="f_phone2"></label>
                                    <input type="text" id="f_phone2" name="f_phone2" class="wid03"  maxlength="4">
                                    <span>-</span>
                                    <label for="fm_tel3"></label>
                                    <input type="text" id="f_phone3" name="f_phone3" class="wid03"  maxlength="4">
                            </td>
                        </tr>
                        <tr>
                        	<th><span class="txt_or">*</span> 이메일</th>
                            <td colspan="4">
                           
                                <label for="f_email1"></label>                                
                                <input type="text" id="f_email1" name="f_email1" class="wid04" value="">
                                <span>@</span>
                                <label for="f_email2"></label>
                                <input type="text" id="f_email2" name="f_email2" class="wid04" value="">
                                <label for="f_email2"></label>
                                <select class="wid04" name="f_email3" id="f_email3">
									<option value="">선택해주세요.</option>
									<option value="etc">직접입력</option>
									<option value="gmail.com">gmail.com</option>
             						<option value="naver.com">naver.com</option>
	             					<option value="nate.com">nate.com</option>
					                <option value="daum.net">daum.net</option>
					                <option value="dreamwiz.com">dreamwiz.com</option>
					                <option value="yahoo.co.kr">yahoo.co.kr</option>
					                <option value="chol.com">chol.com</option>
					                <option value="korea.com">korea.com</option>
					                <option value="hanmail.net">hanmail.net</option>
                                </select>                                
                                 <a id="event_bubble" href="javascript:checkEmail(1);">인증하기</a>
                               <!--  <button id="checkEmail" onclick="checkEmail(event); return false;">인증하기</button> -->
                                <span id="checkEmailConfirm"></span>
                                
                             
                            </td>
                        </tr>
                        <tr>
							<th><span class="txt_or">*</span> 주소</th>
							<td colspan="5">
								<div class="mb10">
									<label for="f_address1"></label><input type="text" id="f_address1" 
									name="f_address1" class="wid60" title="주소검색 새창" readonly=""> 
									<input type = "button" onClick = "openDaumZipAddress()" value = "주소 찾기" class="btn_add"/>
								</div>
								<div class="mb10">
									<label for="f_address2"></label> 
										<input type="text" id="f_address2" name="f_address2" class="wid06">
								</div>
								<div class="mb10">
									<label for="f_address3"></label> 
										<input type="text" id="f_address3" name="f_address3" class="wid06">
								</div>
							</td>
						</tr>
                    </tbody>
                </table>
            </div>
            
					
					<div class="tb_box">
						<h4 class="fl">전문분야</h4>
						<table class="tb_st01">
							<colgroup>
								<col style="width: 14%" />
								<col style="width: *" />
								<col style="width: 15%" />
								<col style="width: 15%" />
								<col style="width: 15%" />
								<col style="width: 15%" />
								<col style="width: 14%" />
							</colgroup>
							<tbody>
								<tr>
									<th scope="row" colspan="2" class="ac"><span
										class="txt_or">*</span>주 분야</th>
									<td><input type="checkbox" class="f_major" name="f_major" value="개발">
										개발</td>
									<td><input type="checkbox" class="f_major" name="f_major" value="디자인">
										디자인</td>
									<td><input type="checkbox" class="f_major" name="f_major" value="기획">
										기획</td>
									<td colspan="2"></td>

								</tr>
							<tr class="line_bottom">
									<th scope="row" rowspan="3" class="ac"><span
										class="txt_or"></span>기본분야</th>
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
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="1"> .NET</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="2"> ABAP</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="3"> ANDROID</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="4"> ASP</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="5"> ASP.NET</td>
											</tr>
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="6"> C</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="7"> C#</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="8"> C++</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="9"> COBOL</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="10"> CSS</td>
											</tr>
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="11"> DB</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="12"> DELPHI</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="13"> HTML</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="14"> IOS</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="15"> JAVA</td>
											</tr>
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="16"> JS</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="17"> JSP</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="18"> LINUX</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="19"> NETWORK</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="20"> PHP</td>
											</tr>
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="21">
													파워빌더</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="22"> PYTHON</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="23"> QA</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="24"> RUBY</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="25"> SERVER개발</td>
											</tr>
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="26"> VB</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="27"> VC++</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="28"> WINDOWS</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="29"> 임베디드</td>
												<td class="td_bor_bott">&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr class="line_bottom">
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
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="30"> HTML5</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="31"> 그래픽디자인</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="32"> 모바일</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="33"> 액션스크립트</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="34"> 웹디자인</td>
											</tr>
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="35"> 웹표준</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="36"> 파워포인트</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="37"> 퍼블리싱</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="38"> 포토샵편집</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="39"> 플래시</td>
											</tr>
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="40"> 3D</td>
												<td class="td_bor_bott">&nbsp;</td>
												<td class="td_bor_bott">&nbsp;</td>
												<td class="td_bor_bott">&nbsp;</td>
												<td class="td_bor_bott">&nbsp;</td>
											</tr>
										</table> 
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
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="41"> DB컨설턴트</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="42"> PM</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="43"> PMO</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="44"> SAP컨설턴트</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="45"> 기획</td>
											</tr>
											<tr>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="46"> 모바일기획</td>
												<td class="td_bor_bott"><input type="checkbox"
													name="fm_new_keyword" value="47"> 웹기획</td>
												<td class="td_bor_bott">&nbsp;</td>
												<td class="td_bor_bott">&nbsp;</td>
												<td class="td_bor_bott">&nbsp;</td>
											</tr>
										</table> 
									</td>
								</tr>

							</tbody>
						</table>
					</div> 

					<!-- //tb_box01 : e -->
					<div class="btn_box">
						<input type="submit" class="btn_check04" id="f_checkValue" value="회원가입" >
						<a href="javascript:MemberWriteFm.reset();" class="btn_check02">초기화</a>
					</div>
		</div>
					</div>


		</form>
		</div>

<%@include file="../c_common/footer.jsp" %> 
</body>
</html>
