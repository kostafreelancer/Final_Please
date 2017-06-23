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
	window.opener.document.tempSchoolAdd.school_term.value = document.myform.term.value;
	window.opener.document.tempSchoolAdd.school_location.value = document.myform.location.value;
	window.opener.document.tempSchoolAdd.school_degree.value = document.myform.degree.value;
	window.opener.addSchoolSubmit();
	self.close();
}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/f_mypage_css/newWindow.css" type="text/css" media="screen" />

</head>
<body>
<form name="myform" onsubmit="return check();">
<fieldset>
<legend>학력추가</legend>
	<label>학교명</label>
	<input type="text" name="school_name" placeholder="ex) 하버드대학교" required><br>
	<label>전공</label>
	<input type="text" name="major" placeholder="ex) 컴퓨터공학" required><br>
	<label>기간</label>
	<input type="text" name="term" placeholder="ex) 10/03/02 ~ 17/02/28" required><br>
	<label>소재지</label>
	<input type="text" name="location" placeholder="ex) 미국" required><br>
	<label>학위</label>
	<input type="text" name="degree" placeholder="ex) 학사" required><br>
	<center>
	<input type="submit" value="저장">
	<input type="reset" value="초기화">
	</center>
	</fieldset>
</form>
</body>
</html>