$(document).ready(function() {
	$('input:checkbox').attr('disabled', true);
	
	$('.accept').click(function(e){
		e.preventDefault();
		if(confirm("가입을 수락합니까?") == true){
			// 프리랜서번호를 구함
			var num = $(this).parent().parent().find('td:eq(0)').text();
			$('input[type="hidden"][name="f_numAccept"]').val(num);
			document.acceptApplicant.submit();
		}else{
			return;
		}
	});
	
	$('.reject').click(function(e){
		e.preventDefault();
		if(confirm("가입을 거절합니까?") == true){
			// 프리랜서번호를 구함
			var num = $(this).parent().parent().find('td:eq(0)').text();
			$('input[type="hidden"][name="f_numReject"]').val(num);
			document.rejectApplicant.submit();
		}else{
			return;
		}
	});
	
	$('.cancel').click(function(e){
		e.preventDefault();
		if(confirm("제안을 취소합니까?") == true){
			// 프리랜서번호를 구함
			var num = $(this).parent().parent().find('td:eq(0)').text();
			$('input[type="hidden"][name="f_numCancel"]').val(num);
			document.cancelScout.submit();
		}else{
			return;
		}
	});
	
	
	
	
	
});