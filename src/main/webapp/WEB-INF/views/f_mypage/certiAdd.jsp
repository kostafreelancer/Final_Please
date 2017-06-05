<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	window.opener.document.tempCertiAdd.certi_name.value = document.myform.certi_name.value;
	window.opener.document.tempCertiAdd.organization.value = document.myform.organization.value;
	window.opener.document.tempCertiAdd.accept_date.value = document.myform.accept_date.value;
	window.opener.addCertiSubmit();
	self.close();
}
</script>
</head>
<body>
<form name="myform">
	<label>자격증명</label>
	<input type="text" name="certi_name"><br>
	<label>발행처</label>
	<input type="text" name="organization"><br>
	<label>취득일자</label>
	<input type="text" name="accept_date"><br>

	<input type="button" value="저장" onclick="check();">
	<input type="reset" value="초기화">
</form>
</body>
</html>