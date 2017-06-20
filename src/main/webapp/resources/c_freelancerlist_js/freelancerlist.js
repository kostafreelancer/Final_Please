$(window).load(function() {
	var list=[];
	if($('.checking_con').val()=="conCheck"){
		alert("해당 프리랜서에게 이미 제안한 프로젝트입니다.");
	};
	
	$('#checkValue').click(function(){
		var url = location.pathname;
			 $.ajax({
					type:'POST',
					url:'/c_freelancerlist/f_complete',
					dataType: 'json',
					success:function(result){
						$.each(result,function(index,list){
						var tag = 
							"<table class='tb_st01 exit'><caption></caption><colgroup>" +
								"<col style='width: 16%'>" +
								"<col style='width: 17%'>" +
								"<col style='width: 20%'>" +
								"<col style='width: 16%'>" +
								"<col style='width: *'></colgroup><tbody>" +
								"<tr>" +
								"<th><span class='txt_or'>*</span>프로젝트 "+(index+1)+"</th><td colspan='4'>" +
										 list.p_name +"<button class='som' value="+list.e_pr_num+">제안하기</button>" +
										 		"</td></tr></tbody></table>" 
							
							if($('.exit').length < result.length){
								$('#project').append(tag);
							}else{
								
							}
						
							
						});
						$('.som').click(function(event){
							event.preventDefault();
							if(confirm("프로젝트를 제안하시겠습니까?")){
							self.location = "/c_freelancerlist/f_complete?e_pr_num="+$(this).val()+"&f_num="+$('.sub_f_num').val();
							}
							});
				}});
			
		
	});
	
	
});




