$(document).ready(function() {
	$('input:checkbox').attr('disabled', true);
	
	$('#startProject').click(function(){
		if(confirm("프로젝트를 시작합니까?") == true){
			document.startProject.submit();
		}else{
			return;
		}		
	});
	
	$('.additional').click(function(e){
		if(confirm("추가 모집을 하시겠습니까?") == true){
			e.preventDefault();
			document.additionalRecruit.submit();
		}else{
			return;
		}		
	});
	
	$('#endProject').click(function(){
		if(confirm("프로젝트를 종료합니까?") == true){
			document.endProject.submit();
		}else{
			return;
		}		
	});
	
	$('#deleteProject').click(function(){
		if(confirm("프로젝트를 삭제합니까?") == true){
			document.deleteProject.submit();
		}else{
			return;
		}		
	});
	
	
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