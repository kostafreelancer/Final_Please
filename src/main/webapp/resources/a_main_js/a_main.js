	/*function postPopUp() {
		alert("aa");
		frm = document.getElementById(f_info);
		window.open('', 'viewer', 'width=1000, height=700');
		frm.action = '../../../WEB-INF/views/a_main/a_mailsender';
		frm.target = "viewer";
		frm.method = "post";
		frm.submit();
		
		var tw = window.open("","test","width=1000,height=700");
		var v1 = $(".mailSend").parent().parent().prev().prev().find('td:eq(0)').text()
		$(tw.document.body).html("<input type=text value="+v1+">")
		
		$(".f_info").taget = "test";
		$(".f_info").submit();
		}
	*/


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