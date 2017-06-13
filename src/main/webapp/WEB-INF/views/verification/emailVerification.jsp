<%@page import="lancer.total.util.RandomCode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript"
	src="../../../resources/verification_js/countdown.js"></script>
<script type="text/javascript"
	src="../../../resources/verification_js/check.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 이메일 인증</title>
</head>
<body>
	<form name="form" action="/verification/verified" onsubmit="return check()">
	<span>인증번호가 발송되었습니다. 인증번호를 입력해주세요.</span><br>
	<% RandomCode code = new RandomCode();%>
	<%= code.start() %>
	<input id="num" name="num" type="text"> <span id="Timer"></span><br>
	<input type="submit" value="확인">
	</form>
</body>
</html>