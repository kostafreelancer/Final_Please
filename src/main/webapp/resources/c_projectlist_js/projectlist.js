function button_event(num,e_num,from){
	if(confirm("프로젝트 신청하시겠습니까?")){
		
		location.href='/c_projectlist/complete?e_pr_num='+num+'&e_num='+e_num+'&from='+from;
	}
}

function button_Accept(e_pr_num, fromF_num, e_num){
	if(confirm("제안을 수락하시겠습니까?")){
		location.href='/f_mypage/suggestFinish?e_pr_num=' + e_pr_num + '&f_num='+fromF_num + '&e_num='+e_num;
	}
}

function button_Reject(e_pr_num, fromF_num, e_num){
	if(confirm("제안을 거절하시겠습니까?")){
		location.href='/f_mypage/suggestReject?e_pr_num=' + e_pr_num + '&f_num='+fromF_num + '&e_num='+e_num;
	}
}


/*$('#evalButton').click(function(){
	var e_score = $('#evalScore').val();
	if(confirm("평가하시겠습니까?")){
		document.getElementById('myscore').value = e_score;
		document.getElementById("eval").submit();
		
	}
})
*/
$(function(){
	if($('.checking_con').val()=="conCheck"){
		alert("이미 신청한 프로젝트입니다.");
	};
	
	
});