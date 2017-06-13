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
		$('.c_login').submit();
		
	});
	

})