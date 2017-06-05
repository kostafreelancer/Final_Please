<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%
	String school_num = request.getParameter("myschool_school_num");
	String school_name = request.getParameter("myschool_school_name");
	String major = request.getParameter("myschool_major");
	String term = request.getParameter("myschool_school_term");
	String location = request.getParameter("myschool_school_location");
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
	window.opener.document.tempSchoolModify.term.value = document.myform.term.value;
	window.opener.document.tempSchoolModify.location.value = document.myform.location.value;
	window.opener.modifySchoolSubmit();
	self.close();
}
</script>
</head>
<body>
<form name="myform">
	<input type="text" hidden name="school_num" value="<%=school_num%>">
	<label>학교명</label>
	<input type="text" name="school_name" value="<%=school_name%>"><br>
	<label>전공</label>
	<input type="text" name="major" value="<%=major%>"><br>
	<label>근무기간</label>
	<input type="text" name="term" value="<%=term%>"><br>
	<label>소재지</label>
	<input type="text" name="location" value="<%=location%>"><br>
	<input type="button" value="저장" onclick="check();">
	<input type="reset" value="초기화">
</form>
</body>
</html>