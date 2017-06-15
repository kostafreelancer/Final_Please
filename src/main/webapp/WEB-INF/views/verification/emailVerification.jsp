<%@page import="lancer.total.util.RandomCode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="../../../resources/verification_css/EmailVeri.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript"
	src="../../../resources/verification_js/check2.js"></script>
<script type="text/javascript"
	src="../../../resources/verification_js/countdown.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 이메일 인증</title>
</head>
<body>
	<div class="tabmenu">
	<form name="form" action="/verification/emailVerification" method="POST" onsubmit="return check2()">
	<span class="txt">이메일로 인증번호가 발송되었습니다. 인증번호를 입력해주세요.</span><br>
	<input id="num" name="num" type="text"> <span id="Timer"></span>
	<input id="refresh" name="email_agian" type="button" onclick="window.location.reload(true);" value="재전송"><br>
	<input type="hidden" name="id" value="${id }">
	<input type="hidden" name="name" value="${name }">
	<input type="hidden" name="emailAddr" value="${emailAddr }">
	<input id="codeNum" type="hidden" name="codeNum" value="${codeNum }">${codeNum }
	<input class="verify" type="submit" value="확인">
	
	</form>
	</div>
</body>
</html>