$(document).ready(function(){
	var f_score = $('#hiddenscore').val();
	var i = 0;
	   if(f_score == 5.0){
	      $('.star_rating').find('a:eq(4)').addClass('on').prevAll('a').addClass('on');
	   }else if(f_score > 4.0){
	      $('.star_rating').find('a:eq(3)').addClass('on').prevAll('a').addClass('on');
	      $('.star_rating').find('a:eq(4)').addClass('half');
	   }else if(f_score > 3.0){
	      $('.star_rating').find('a:eq(2)').addClass('on').prevAll('a').addClass('on');
	      $('.star_rating').find('a:eq(3)').addClass('half');
	   }else if(f_score > 2.0){
	      $('.star_rating').find('a:eq(1)').addClass('on').prevAll('a').addClass('on');
	      $('.star_rating').find('a:eq(2)').addClass('half');
	   }else if(f_score > 1.0){
	      $('.star_rating').find('a:eq(0)').addClass('on');
	      $('.star_rating').find('a:eq(1)').addClass('half');
	   }else if(f_score > 0.0){
	      $('.star_rating').find('a:eq(0)').addClass('half');
	   }
})

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
	
	if($('#evalTemp').val() == "success"){
		alert("평가가 완료되었습니다.");
	}
	
	
});