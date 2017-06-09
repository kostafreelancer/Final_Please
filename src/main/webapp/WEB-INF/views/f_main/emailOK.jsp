<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function checkAuthNum() {
		console.log("인증페이지")
		var form = document.authenform;
		var authNum = ${authNum}
		
		if (!form.authNum.value) {
			alert("인증번호를 입력해 주세요.");
			return false;
		}
		if (form.authNum.value != authNum) {
			alert("인증번호가 다릅니다.");
			var str = "";
			str += "<h3>인증번호를 확인해주세요</h3>";
			
			$(".warning").html(str);

			return false;
		}
		if (form.authNum.value == authNum) {
			alert("인증되었습니다.");
			form.authNum.value = "인증완료";
			self.close();
		}

	}
</script>
<body>
	<div class="container">
		<form method="get" name="authenform">
			<input type="text" name="authNum" value=""> 
			<input type="button" class="btn btn-info" value="인증하기" onclick="checkAuthNum()">
		</form>
		<div class="warning">
		
		</div>
	</div>

</body>
</html>