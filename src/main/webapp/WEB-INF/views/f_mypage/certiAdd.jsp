<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	window.opener.document.tempCertiAdd.certificate_name.value = document.myform.certi_name.value;
	window.opener.document.tempCertiAdd.organization.value = document.myform.organization.value;
	window.opener.document.tempCertiAdd.accept_date.value = document.myform.accept_date.value;
	window.opener.addCertiSubmit();
	self.close();
}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/f_mypage_css/newWindow.css" type="text/css" media="screen" />
</head>
<body>
<form name="myform" onsubmit="return check();">
<fieldset>
<legend>자격증 추가</legend>
	<label>자격증명</label>
	<input type="text" name="certi_name" placeholder="ex) 정보처리기사" required><br>
	<label>발행처</label>
	<input type="text" name="organization" placeholder="ex) 한국산업인력공단" required><br>
	<label>취득일자</label>
	<input type="text" name="accept_date" placeholder="ex) 17/06/20" required><br>

	<input type="submit" value="저장">
	<input type="reset" value="초기화">
	</fieldset>
</form>
</body>
</html>