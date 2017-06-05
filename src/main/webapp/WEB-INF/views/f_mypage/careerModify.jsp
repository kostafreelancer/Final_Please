<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<%
	String career_num = request.getParameter("mycareer_career_num");
	String company = request.getParameter("mycareer_company");
	String dept = request.getParameter("mycareer_dept");
	String rank = request.getParameter("mycareer_rank");
	String term = request.getParameter("mycareer_career_term");
	String location = request.getParameter("mycareer_career_location");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	window.opener.document.tempCareerModify.career_num.value = document.myform.career_num.value;
	window.opener.document.tempCareerModify.company.value = document.myform.company.value;
	window.opener.document.tempCareerModify.dept.value = document.myform.dept.value;
	window.opener.document.tempCareerModify.rank.value = document.myform.rank.value;
	window.opener.document.tempCareerModify.term.value = document.myform.term.value;
	window.opener.document.tempCareerModify.location.value = document.myform.location.value;
	window.opener.modifyCareerSubmit();
	self.close();
}
</script>
</head>
<body>
	<form name="myform">
	<input type="text" hidden name="career_num" value="<%=career_num%>">
	<label>회사명</label>
	<input type="text" name="company" value="<%=company%>"><br>
	<label>근무부서</label>
	<input type="text" name="dept" value="<%=dept%>"><br>
	<label>직위</label>
	<input type="text" name="rank" value="<%=rank%>"><br>
	<label>근무기간</label>
	<input type="text" name="term" value="<%=term%>"><br>
	<label>소재지</label>
	<input type="text" name="location" value="<%=location%>"><br>
	<input type="button" value="저장" onclick="check();">
	<input type="reset" value="초기화">
</form>
</body>
</html>