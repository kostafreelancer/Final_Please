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
</head>
<body>
<h3>������ �߰�</h3>
<form name="myform">
<label>�����̸�</label>
<input type="text" name="contents"><br>
<label>������</label>
<input type="text" name="startdate"><br>
<label>������</label>
<input type="text" name="enddate"><br>
<input type="button" value="����" onclick="check();">
<input type="reset" value="�ʱ�ȭ">
</form>
</body>
</html>