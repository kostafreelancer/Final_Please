<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet"
	href="../../../resources/membercenter_css/center_css.css">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function checkAuthNum() {
		console.log("인증페이지")
		var form = document.authenform;
		var authNum = ${authNum}
		//var opner = window.opener.document;
		
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
			var result = "인증완료"
			var parent = window.opener
			//alert(result);
			//var text = parent.document.f_userInfo.confirmEmail.txt
			var oldtext = opener.document.getElementById("checkEmailConfirm").innerHTML;
			if(oldtext == ''){
				opener.document.getElementById("checkEmailConfirm").innerHTML = "인증완료";
			}
			self.close();
		}

	}
</script>
<body>
<div class="tit_box" style="border-bottom: 1px solid">
			<h2>이메일인증</h2>
			<p class="tit_txt">
				입력하신 이메일 주소로 인증코드가 발송되었습니다. <span>인증 코드 7자리를 정확히 입력해 주세요.
				</span>
			</p>
		</div>
	<div class="container">
		<form method="get" name="authenform">
			<input type="text" name="authNum" id="authNum" value=""> 
			<input type="button" class="btn btn-info" value="인증하기" onclick="checkAuthNum()">
		</form>
		<div id="warning">
		
		</div>
	</div>

</body>
</html>