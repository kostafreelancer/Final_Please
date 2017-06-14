<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%
	String certi_num = request.getParameter("mycerti_certi_num");
	String certi_name = request.getParameter("mycerti_certi_name");
	String organization = request.getParameter("mycerti_organization");
	String accept_date = request.getParameter("mycerti_accept_date");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	window.opener.document.tempCertiModify.certificate_num.value = document.myform.certi_num.value;
	window.opener.document.tempCertiModify.certificate_name.value = document.myform.certi_name.value;
	window.opener.document.tempCertiModify.organization.value = document.myform.organization.value;
	window.opener.document.tempCertiModify.accept_date.value = document.myform.accept_date.value;
	window.opener.modifyCertiSubmit();
	self.close();
}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/f_mypage_css/newWindow.css" type="text/css" media="screen" />
</head>
<body>

<form name="myform" onsubmit="return check();">
<fieldset>
<legend>자격증 수정</legend>
	<input type="text" hidden name="certi_num" value="${certi.certificate_num }">
	<label>자격증명</label>
	<input type="text" name="certi_name" value="${certi.certificate_name}" required><br>
	<label>발행처</label>
	<input type="text" name="organization" value="${certi.organization }" required><br>
	<label>취득일자</label>
	<input type="text" name="accept_date" value="${certi.accept_date }" required><br>

	<input type="submit" value="저장">
	<input type="reset" value="초기화">
	</fieldset>
</form>
</body>
</html>