<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/resources/c_common_css/chatting.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="/resources/c_common_css/chatting_chang.css"
	type="text/css" media="screen" />
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="/resources/c_common_js/chatting.js"></script>
<script type="text/javascript">
$(function(){
	$('.chatting').click(function(){
		alert("걸리는거야?");
	$(this).load('/webapp/WEB-INF/views/c_common/chatting_chang.html');
});
});
</script>


</head>
<body>
	<div class="chatting">
		<div class="chatting_Detail">
			<img class="chatting_img" alt="catting_open"
				src="/resources/c_common_img/chatting.PNG">
			<p>채팅 문의</p>
		</div>
	</div>
</body>
</html>