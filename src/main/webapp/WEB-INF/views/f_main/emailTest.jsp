<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function nwindow(){
    var url="/testEmail";
    var newWin = window.open(url,"new", "width=400,height=400,");
    var form = document.test;
    form.action="/f_main/testEmail";
    form.target="new";
    form.method="post";
    form.submit();
}
</script>
<body>
<form name="test" action = "/f_main/testEmail" method="POST">
<input type="text" name="email" value="">
<input type="submit" value="인증">
 <input type="button" value="인증2"  onclick="nwindow()"/>
<a href="/f_main/testEmail" onclick="window.open(this.href, '', 'width=500, height=500'); return false;">인증하기</a>
</form>
<input type="text" id="answerOK1" name="ok" style="hidden">
<div id="answerOk">

</div>
</body>
</html>