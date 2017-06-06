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
<h3>스케줄 추가</h3>
<form name="myform">
<label>일정이름</label>
<input type="text" name="contents"><br>
<label>시작일</label>
<input type="text" name="startdate"><br>
<label>종료일</label>
<input type="text" name="enddate"><br>
<input type="button" value="저장" onclick="check();">
<input type="reset" value="초기화">
</form>
</body>
</html>