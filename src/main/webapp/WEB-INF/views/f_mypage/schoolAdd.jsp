<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	window.opener.document.tempSchoolAdd.school_name.value = document.myform.school_name.value;
	window.opener.document.tempSchoolAdd.major.value = document.myform.major.value;
	window.opener.document.tempSchoolAdd.term.value = document.myform.term.value;
	window.opener.document.tempSchoolAdd.location.value = document.myform.location.value;
	window.opener.addSchoolSubmit();
	self.close();
}
</script>
</head>
<body>
<form name="myform">
	<label>학교명</label>
	<input type="text" name="school_name"><br>
	<label>전공</label>
	<input type="text" name="major"><br>
	<label>기간</label>
	<input type="text" name="term"><br>
	<label>소재지</label>
	<input type="text" name="location"><br>
	<input type="button" value="저장" onclick="check();">
	<input type="reset" value="초기화">
</form>
</body>
</html>