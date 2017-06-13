$(window).load(function() {
	var list=[];
	$('#checkValue').click(function(){
		/*event.preventDefault();*/
		alert("노먀?");
		var url = location.pathname;
			 $.ajax({
					type:'POST',
					url:'/c_freelancerlist/f_complete',
					dataType: 'json',
					success:function(result){
						$.each(result,function(index,list){
							alert(index+" : "+list.p_name);
						});
				}});
		
	});
	
});
