<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	window.opener.document.scheduleAdd.contents.value = document.myform.contents.value;
	window.opener.document.scheduleAdd.startdate.value = document.myform.startdate.value;
	window.opener.document.scheduleAdd.enddate.value = document.myform.enddate.value;
	window.opener.addScheduleSubmit();
	self.close();
}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/f_mypage_css/newWindow.css" type="text/css" media="screen" />
</head>
<body>

<form name="myform" onsubmit="return check();">
	<fieldset>
	<label>�����̸�</label>
	<input type="text" name="contents" placeholder="���� ���" required><br>
	<label>������</label>
	<input type="text" name="startdate" placeholder="ex) 17/06/01" value="${clickDate}" required ><br>
	<label>������</label>
	<input type="text" name="enddate" placeholder="ex) 17/06/16" required><br>
	<center>
	<input type="submit" value="����">
	<input type="reset" value="�ʱ�ȭ">
	</center>
	</fieldset>
</form>
</body>
</html>