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
	String year = request.getParameter("mycareer_career_year");
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
	window.opener.document.tempCareerModify.career_term.value = document.myform.term.value;
	window.opener.document.tempCareerModify.career_location.value = document.myform.location.value;
	window.opener.document.tempCareerModify.career_year.value = document.myform.year.value;
	window.opener.modifyCareerSubmit();
	self.close();
}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/f_mypage_css/newWindow.css" type="text/css" media="screen" />
</head>
<body>
	<form name="myform" onsubmit="return check();">
	<fieldset>
	<legend>경력수정</legend>
	<input type="text" hidden name="career_num" value="${career.career_num}">
	
	<label>회사명</label>
	<input type="text" name="company" value="${career.company}" required><br>
	<label>근무부서</label>
	<input type="text" name="dept" value="${career.dept}" required><br>
	<label>직위</label>
	<input type="text" name="rank" value="${career.rank}" required><br>
	<label>근무기간</label>
	<input type="text" name="term" value="${career.career_term }" required><br>
	<label>소재지</label>
	<input type="text" name="location" value="${career.career_location}" required><br>
	<label>근속년수</label>
	<input type="text" name="year" value="${career.career_year}" required><br>
	<input type="submit" value="저장">
	<input type="reset" value="초기화">
	</fieldset>
</form>
</body>
</html>