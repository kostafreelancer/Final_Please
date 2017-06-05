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
	window.opener.document.tempCertiModify.certi_num.value = document.myform.certi_num.value;
	window.opener.document.tempCertiModify.certi_name.value = document.myform.certi_name.value;
	window.opener.document.tempCertiModify.organization.value = document.myform.organization.value;
	window.opener.document.tempCertiModify.accept_date.value = document.myform.accept_date.value;
	window.opener.modifyCertiSubmit();
	self.close();
}
</script>
</head>
<body>

<form name="myform">
	<input type="text" hidden name="certi_num" value="<%=certi_num%>">
	<label>자격증명</label>
	<input type="text" name="certi_name" value="<%=certi_name%>"><br>
	<label>발행처</label>
	<input type="text" name="organization" value="<%=organization%>"><br>
	<label>취득일자</label>
	<input type="text" name="accept_date" value="<%=accept_date%>"><br>

	<input type="button" value="저장" onclick="check();">
	<input type="reset" value="초기화">
</form>
</body>
</html>