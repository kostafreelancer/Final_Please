 
$(document).ready(function(){
	
	listReply2();
	
	
	var formObj = $("form[role='form']");
	var formObj2 = $("form[role='form_test']");

	
	$(".btn_check04").click(function(){
		formObj.attr("action", "/f_board/f_modifyPage");
		formObj.attr("method", "get");
		formObj.submit();
	});
	$(".btn_remove").click(function(){
		if(confirm("삭제하시겠습니까?")){
		formObj.attr("action", "/f_board/f_remove");
		formObj.attr("method", "post");
		formObj.submit();
		}
	});
	$(".btn_list").click(function(){
		location.href="/f_board/f_list";

	}); 

    $("#btnReply").click(function(){
        replyJson(); // json으로 입력
    });
    
     $("#btnReplyClose").click(function(){
         $("#modifyReply").css("visibility", "hidden");
     	$("#modifyReply").css("display", "none");
     });



});





