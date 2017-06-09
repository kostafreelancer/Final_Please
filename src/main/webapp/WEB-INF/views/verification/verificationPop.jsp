<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="../../../resources/verification_css/verificationPop.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript"
	src="../../../resources/verification_js/verificationPop.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="verification">
	<div class="tab">
		<button class="tablinks active" onclick="openbtn(event, 'find_id')">아이디
			찾기</button>
		<button class="tablinks" onclick="openbtn(event, 'find_pwd')">비밀번호
			찾기</button>
	</div>

	<div id="find_id" class="tabcontent">
		<div class="tabmenu">
			<form action="/verification/verificationPop" method="POST">
			<span class="txt">이름 &nbsp; &nbsp;:</span> <input class="space" type="text"><br> 
			<span class="txt">이메일 :</span> <input id="e_mail_1_1" class="space" type="text">@<input id="e_mail_2_1" class="space" type="text" name="EmailDomain" style="color:gray" value="선택해주세요." readonly="readonly"> 
				
				<select id="e_mail_select1">
					<option value="선택해주세요.">선택해주세요.</option>
					<option value="">직접입력</option>
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
			<br>
			<span style="color:red;font-size:12px;">*가입 시 입력한 이메일을 입력해주세요.</span>
			<br>
			<input type="radio" name="sort">프리랜서<input type="radio" name="sort">기업
			<br>
			<input class="verify" type="submit" value="조회">
			<br>
			</form>
		</div>
	</div>

	<div id="find_pwd" class="tabcontent">
		<div class="tabmenu">
			<form name="form" action="/verification/verificationPop" method="POST">
			<span class="txt">아이디 :</span> <input class="space" type="text"><br>
			<span class="txt">이름 &nbsp; &nbsp;:</span> <input class="space" type="text"><br> 
			<span class="txt">이메일 :</span> <input id="e_mail_1_2" class="space" type="text">@<input id="e_mail_2_2" class="space" type="text" name="EmailDomain" style="color:gray" value="선택해주세요." readonly="readonly"> 
				
				<select id="e_mail_select2">
					<option value="선택해주세요.">선택해주세요.</option>
					<option value="">직접입력</option>
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
			<br>
			<span style="color:red;font-size:12px;">*가입 시 입력한 이메일을 입력해주세요.</span>
			<br>
			<input type="radio" name="sort">프리랜서<input type="radio" name="sort">기업
			<br>
			<input class="verify" type="submit" value="조회">
			<br>
			</form>
		</div>
	</div>

</body>

</html>