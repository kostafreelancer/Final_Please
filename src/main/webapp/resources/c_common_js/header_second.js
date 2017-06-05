

$(window).load(function() {
	if($('.header_welcome_content span').text() != ''){
		$('.header_welcome_content span').append("<span>님 환영합니다</span>");
		$('.login_checking a').text("로그 아웃");
		$('.header_join').hide();
	}
	$('.login_checking a').click(function(event){
		event.preventDefault();
		if($('.login_checking a').text() === "로그 아웃"){
			
			$('.login_checking a').text("로그인");
			$('.header_welcome_content span').text("");
			var url = location.pathname;
			
			 $.ajax({
					type:'POST',
					url:'/c_login/logout',
					headers: { 
					      "Content-Type": "application/json",
					      "X-HTTP-Method-Override": "POST" },
					data:JSON.stringify({url:url}), 
					dataType:'text', 
					success:function(result){
						$('.header_join').show();
						window.location.reload();
				}});
		}else{
			 /*$.ajax({
					type:'GET',
					url:'/c_login/login',
					headers: { 
					      "Content-Type": "application/json",
					      "X-HTTP-Method-Override": "GET" },
					dataType:'text', 
					success:function(result){
						console.log("result: " + result);
						if(result == 'SUCCESS'){
							alert("페이지가 이동이 됫나?");
						}
				}});*/
			
			self.location = "/c_login/login";
		}
	});

	
});
