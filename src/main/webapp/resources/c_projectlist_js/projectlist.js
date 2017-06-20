function button_event(num){
	if(confirm("프로젝트 신청하시겠습니까?")){
		location.href='/c_projectlist/complete?e_pr_num='+num;
	}
}

function button_Accept(e_pr_num, fromF_num){
	if(confirm("제안을 수락하시겠습니까?")){
		location.href='/f_mypage/suggestFinish?e_pr_num=' + e_pr_num + '&f_num='+fromF_num;
	}
}
