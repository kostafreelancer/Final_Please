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
	window.opener.document.tempCareerAdd.career_term.value = document.myform.term.value;
	window.opener.document.tempCareerAdd.career_location.value = document.myform.location.value;
	window.opener.document.tempCareerAdd.career_year.value = document.myform.year.value;
	window.opener.addCareerSubmit();
	self.close();
	
}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/f_mypage_css/newWindow.css" type="text/css" media="screen" />

</head>
<body>
<form name="myform" onsubmit="return check();">
<fieldset>
<legend>경력추가</legend>
	<label>회사명</label>
	<input type="text" name="company" placeholder="ex) 코스타주식회사" required><br>
	<label >근무부서</label>
	<input type="text" name="dept" placeholder="ex) 사무국" required><br>
	<label>직위</label>
	<input type="text" name="rank" placeholder="ex) 사원" required><br>
	<label>근무기간</label>
	<input type="text" name="term" placeholder="ex) 14/06/30 ~ 17/06/30" required><br>
	<label>소재지</label>
	<input type="text" name="location" placeholder="ex) 서울" required><br>
	<label>연차</label>
	<input type="text" name="year" placeholder="ex) 3" required><br><br>
	<center><input type="submit" value="저장">
	<input type="reset" value="초기화" ></center>
	</fieldset>
</form>
</body>
</html>