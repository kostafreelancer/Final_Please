<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function checkAuthNum(){
		console.log("인증페이지")
		var form = document.authenform;
		var authNum = ${authNum};
		if(!form.authNum.value){
			alert("인증번호를 입력해 주세요.");
		}else if(form.authNum.value != authNum){
			alert("인증번호가 다릅니다.");
		}else if(form.authNum.value == authNum){
			alert("인증되었습니다.");
			self.close();
		}
			
	}
</script>
<body>
<div class="container">
	<form method="post" name="authenform" onsubmit="checkAuthNum()";>
		<input type="text" name="authNum" value="">
		<input type="submit" class="btn btn-info" value="인증하기">
	</form>
</div>

</body>
</html>