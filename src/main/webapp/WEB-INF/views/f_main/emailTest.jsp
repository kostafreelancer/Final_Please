<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "testEmail" method="POST">
<input type="text" name="email" value="vionicterran@naver.com">
<input type="submit" value="인증">
<a href="/f_main/testEmail" onclick="window.open(this.href, '', 'width=1000, height=1000'); return false;">인증하기</a>

</form>
</body>
</html>