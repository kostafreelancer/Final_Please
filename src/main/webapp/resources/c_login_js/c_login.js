/**
 * 
 */
$(function(){
	
	if($('.checking_login').val() === 'no'){
		alert("잘못된 회원의 정보를 입력하였습니다.");
		$('.checking_login').val('');
		$('#fm_id').focus();
	};
	
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