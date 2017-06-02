

$(window).load(function() {
	if($('.header_welcome_content span').text() != ''){
		$('.header_welcome_content span').append("<span>님 환영합니다</span>");
		$('.login_checking a').text("로그 아웃");
		$('.header_join').hide();
	}
	$('.login_checking a').click(function(){
		if($('.login_checking a').text() === "로그 아웃"){
			$('.login_checking a').text("로그인");
			$('.header_welcome_content span').text("");
			alert("우와");
			self.location = "/c_login/logout";
		}
	});

	
});
