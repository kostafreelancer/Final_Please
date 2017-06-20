
$(document).ready(function() {


	
	$('.mailSend').click(function(){
		// 해당 계정의 번호를 구함
		
		var num = $(this).parent().parent().prev().prev().find('td:eq(0)').text();
		alert(num);
		/*var tw = window.open("a_mailsender","test","width=1000,height=300,top=500,left=500")
		$('#f_info').target="test";
		$('#f_info').submit();
		*/
		var tw = window.open("/a_main/a_mailsender","test","width=1000,height=700");
		/*var f_num = $(".mailSend").parent().parent().prev().prev().find('td:eq(0)').text()
		$(tw.document.body).html("<input type='text' value='+num+'>")
		
		$(".f_info").taget = "test";
		$(".f_info").submit();*/
		
	});
	
	$('.deleteAccountF').click(function(e){
		e.preventDefault();
		if(confirm("해당 계정을 삭제 처리 하시겠습니까?") == true){
			// 해당 계정의 프리랜서번호를 구함
			var num = $(this).parent().parent().prev().prev().find('td:eq(0)').text();
			$('input[type="hidden"][name="deleteF_num"]').val(num);
			document.deleteFormF.submit();
		}else{
			return;
		}
	});
	
	$('.deleteAccountE').click(function(e){
		e.preventDefault();
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
	
	$('.permitRegedit').click(function(){
		if(confirm("해당 프로젝트의 등록을 승인 하시겠습니까?") == true){
			// 해당 프로젝트의 프로젝트 번호를 구함
			var num = $(this).parent().parent().prev().find('td:eq(0)').text();
			$('input[type="hidden"][name="permitE_pr_num"]').val(num);
			document.permitProjectForm.submit();
		}else{
			return;
		}
	});
	
	$('.license').click(function(e){
		e.preventDefault();
		var filenum = $(this).attr("href");
		if(filenum == ""){
			alert("파일이 없습니다");
			return false;
		}
		$('#file_num').val(parseInt(filenum));
		
		document.fileForm.submit();
	});
	

});

