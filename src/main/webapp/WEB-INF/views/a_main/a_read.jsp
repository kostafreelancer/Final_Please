<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="../../../resources/membercenter_css/center_css.css">
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
<div class="tit_box" style="border-bottom: 1px solid">
			<h2>답변하기</h2>
			<p class="tit_txt">
				해당 회원 질문에 답변을 할 수 있습니다. <span>내용을 작성 후 전송 버튼을 누르세요.
				</span>
			</p>
		</div>
<table class="email_table">

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
		<th>답변제목<th><input type="text" name="answertitle" class="wid">
		</tr>
		<tr>
		<th>답변하기</th>
		<th><textarea name="answercontents" class="text_area text_area2"></textarea></th>
		</tr>
		
		
		

</table>

<input type="hidden" id="ad_num" name ="ad_num" value="1">
<input type="hidden" id="asknum" name="asknum" value="${askcontents.asknum }">	

<input type="submit" value="전송" id="doAsk">
</form>
</body>
</html>