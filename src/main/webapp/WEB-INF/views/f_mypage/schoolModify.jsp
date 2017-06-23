<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%
	String school_num = request.getParameter("myschool_school_num");
	String school_name = request.getParameter("myschool_school_name");
	String major = request.getParameter("myschool_major");
	String term = request.getParameter("myschool_school_term");
	String location = request.getParameter("myschool_school_location");
	String degree = request.getParameter("myschool_school_degree");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	window.opener.document.tempSchoolModify.school_num.value = document.myform.school_num.value;
	window.opener.document.tempSchoolModify.school_name.value = document.myform.school_name.value;
	window.opener.document.tempSchoolModify.major.value = document.myform.major.value;
	window.opener.document.tempSchoolModify.school_term.value = document.myform.term.value;
	window.opener.document.tempSchoolModify.school_location.value = document.myform.location.value;
	window.opener.document.tempSchoolModify.school_degree.value = document.myform.degree.value;
	window.opener.modifySchoolSubmit();
	self.close();
}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/f_mypage_css/newWindow.css" type="text/css" media="screen" />
</head>
<body>
<form name="myform" onsubmit="return check();">
<fieldset>
<legend>학력 수정</legend>
	<input type="text" hidden name="school_num" value="${school.school_num}">
	<label>학교명</label>
	<input type="text" name="school_name" value="${school.school_name}" required><br>
	<label>전공</label>
	<input type="text" name="major" value="${school.major}" required><br>
	<label>근무기간</label>
	<input type="text" name="term" value="${school.school_term}" required><br>
	<label>소재지</label>
	<input type="text" name="location" value="${school.school_location}" required><br>
	<label>학위</label>
	<input type="text" name="degree" value="${school.school_degree}" required><br>
	<input type="submit" value="저장" >
	<input type="reset" value="초기화">
	</fieldset>
</form>
</body>
</html>