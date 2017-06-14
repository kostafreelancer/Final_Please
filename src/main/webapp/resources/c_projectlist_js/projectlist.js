function button_event(num){
	if(confirm("프로젝트 신청하시겠습니까?")){
		location.href='/c_projectlist/complete?e_pr_num='+num;
	}
}

