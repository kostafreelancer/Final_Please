<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	window.opener.document.tempCareerAdd.company.value = document.myform.company.value;
	window.opener.document.tempCareerAdd.dept.value = document.myform.dept.value;
	window.opener.document.tempCareerAdd.rank.value = document.myform.rank.value;
	window.opener.document.tempCareerAdd.term.value = document.myform.term.value;
	window.opener.document.tempCareerAdd.location.value = document.myform.location.value;
	window.opener.addCareerSubmit();
	self.close();
	
}
</script>
</head>
<body>
<form name="myform">
	<label>회사명</label>
	<input type="text" name="company"><br>
	<label>근무부서</label>
	<input type="text" name="dept"><br>
	<label>직위</label>
	<input type="text" name="rank"><br>
	<label>근무기간</label>
	<input type="text" name="term"><br>
	<label>소재지</label>
	<input type="text" name="location"><br>
	<input type="button" value="저장" onclick="check();">
	<input type="reset" value="초기화">
</form>
</body>
</html>