$(window).load(function() {
	var list=[];
	$('#checkValue').click(function(){
		var url = location.pathname;
			 $.ajax({
					type:'POST',
					url:'/c_freelancerlist/f_complete',
					dataType: 'json',
					success:function(result){
						$.each(result,function(index,list){
						var tag = 
							"<tr class='che_list011'>"+
							"<td class='td_bor_bott1'>" +
							 list.p_name +"<button class='som' value="+list.e_pr_num+">제안</button>"
							"</td>" +
							"<br></tr>"
							
							$('.btn_box').append(tag);
							
						});
						$('.som').click(function(event){
							event.preventDefault();
							self.location = "/c_freelancerlist/f_complete?e_pr_num="+$(this).val()+"&f_num="+$('.sub_f_num').val();
						});
				}});
			
		
	});
	
});
