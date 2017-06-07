$(document).ready(function() {
	$('.mailSend').click(function(){
		// 해당 계정의 번호를 구함
		var num = $(this).parent().parent().prev().prev().find('td:eq(0)').text();
		alert(num);
	});
	
	$('.deleteAccountF').click(function(){
		if(confirm("해당 계정을 삭제 처리 하시겠습니까?") == true){
			// 해당 계정의 프리랜서번호를 구함
			var num = $(this).parent().parent().prev().prev().find('td:eq(0)').text();
			$('input[type="hidden"][name="deleteF_num"]').val(num);
			document.deleteFormF.submit();
		}else{
			return;
		}
	});
	
	$('.deleteAccountE').click(function(){
		if(confirm("해당 계정을 삭제 처리 하시겠습니까?") == true){
			// 해당 계정의 기업번호를 구함
			var num = $(this).parent().parent().prev().prev().find('td:eq(0)').text();
			$('input[type="hidden"][name="deleteE_num"]').val(num);
			document.deleteFormE.submit();
		}else{
			return;
		}
	});
	
	$('.permitJoin').click(function(){
		if(confirm("해당 계정의 가입을 승인 하시겠습니까?") == true){
			// 해당 계정의 아이디를 구함
			var num = $(this).parent().parent().prev().prev().find('td:eq(0)').text();
			$('input[type="hidden"][name="permitE_num"]').val(num);
			document.permitForm.submit();
		}else{
			return;
		}
	});
});