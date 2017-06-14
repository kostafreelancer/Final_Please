<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var update = function(){
		var f = document.updateAnswer
		f.action = "/a_main/updateAnswer";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body>

<form action="/a_main/updateAnswer" method="post" name="updateAnswer">
<table class="Answer_table">
	<tr>
		<th>글제목</th>
		<td>${askcontents.asktitle }</td>
		</tr>
		<tr>
		<th>글내용</th>
		<td>${askcontents.askcontents }</td>
		</tr>
		<tr>
		<th>글쓴이</th>
		<td>${askcontents.writer }</td>
		</tr>
		<tr>
		<th>답변제목<th><input type="text" name="answertitle">
		</tr>
		<tr>
		<th>답변하기</th>
		<th><textarea name="answercontents"></textarea></th>
		</tr>

</table>
	<!-- <input type="hidden" id="asknum" name="asknum"> -->
<input type="text" id="ad_num" name ="ad_num" value="1">
<input type="text" id="asknum" name="asknum" value="${askcontents.asknum }">	

<input type="submit" value="전송">
</form>
</body>
</html>