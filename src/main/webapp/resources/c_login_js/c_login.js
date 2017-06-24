/**
 * 
 */
$(function(){
	
	
	if($('.checking_login').val() === "nocheck"){
		alert("승인대기 중입니다.");
		$('.checking_login').val('');
		$('#fm_id').focus();
	
	}else if($('.checking_login').val() === 'no'){
		alert("비밀번호가 틀렸습니다.");
		$('.checking_login').val('');
		$('#fm_id').focus();
	}else if($('.checking_login').val() === 'idcheck'){
		alert("가입되지 않는 아이디입니다.");
		$('.checking_login').val('');
		$('#fm_id').focus();
	}else if($('.checking_login').val() === 'sleep'){
		alert("휴면으로 변환된 계정입니다.");
		var url="/testEmail";
  	    var newWin = window.open(url,"new", "width=400,height=400,");
  	    var f = document.sleepMail;
  	    f.action="/c_login/testEmail";
  	    f.target="new";
  	    f.method="post";
  	    f.submit();  
		//window.open()
	}
	
	$('.btn_login').click(function(){
		if($('#fm_id').val() === ''){
			alert("아이디를 입력하세요.");
			$('#fm_id').focus();
			return 0;
		}
		if($('#fm_passwd').val() === ''){
			alert("비밀번호를 입력하세요.");
			$('#fm_passwd').focus();
			return 0;
		}
		/*if (grecaptcha.getResponse() == ""){ 
			alert("사람이 아니더냐?");
			return 0; 
		}*/
		if($('#checkEmailConfirm').html() === '인증완료'){
			$('#emailConfirm').val('인증완료');
		}
		
		$('.c_login').submit();
		
	

	});
	  
	/*
    var siteKey = "6LfYlSYUAAAAAH7l4BXuLSs-t5VpAWhzylIBSu6j";//Site key
    var div = "recaptcha";
    Recaptcha.create(siteKey, div, {theme: "red"});
         
    $("#recaptchaCheck").click(function(){
         
        var challenge = Recaptcha.get_challenge();
        var response = Recaptcha.get_response();
        var host = $(location).attr('host');
        console.log("띠용");
        $.ajax({
            type: "POST",
            url: "/c_login/validateRecaptcha",
            async: false,
            data: {
                host: host,
                challenge: challenge,
                response: response
            },
            success: function(data) {
                if(data == "Y") {
                    document.getElementById("message").innerHTML = "Success!";
                }else{
                    document.getElementById("message").innerHTML = "Incorrect Recaptcha! Please try again!";
                    Recaptcha.reload();
                }
            }
        });
         
    });
	*/
	

})