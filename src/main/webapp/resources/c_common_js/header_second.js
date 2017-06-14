

$(window).load(function() {
	
	$('.exam').click(function(event){
		event.preventDefault();
		$('.iframe_id').remove();
	});
	if($('.header_welcome_content span').text() != ''){
		localStorage.setItem('username',$('.header_welcome_content span').text());
		$('.header_welcome_content span').append("<span>님 환영합니다</span>");
		$('.login_checking a').text("로그 아웃");
		$('.header_join').hide();
	}
	$('.c_home').click(function(event){
		event.preventDefault();
		
		if($('#c_freelancer').length!=0){
			$('.c_f_main').submit();
		}else if($('#enterprise').length!=0){
			$('.c_e_main').submit();
		}else if($('#admin').length!=0){
			
			$('.c_a_main').submit();
		}else{
			$('.c_f_main').submit();
		}
		
	});	
	$('.menus_one').click(function(event){
		event.preventDefault();
		if($('#c_freelancer').length!=0){
			$('.c_f_menus_one2').submit();
		}else if($('#enterprise').length!=0){
			$('.c_f_menus_one').submit();
		}else if($('#admin').length!=0){
			$('.c_f_menus_one2').submit();
		}else{
			$('.c_f_menus_one2').submit();
		}
	});
	$('.menus_two').click(function(event){
		event.preventDefault();
		if($('#admin').length!=0){
			$('.c_f_menus_two2').submit();
		}else{
			$('.c_f_menus_two').submit();
		}
	});
	$('.menus_three').click(function(event){
		event.preventDefault();
		if($('#admin').length!=0){
			$('.c_f_menus_three2').submit();
		}else{
			$('.c_f_menus_three').submit();
		}
	});
	$('.menus_four').click(function(event){
		
		event.preventDefault();
		if($('#admin').length!=0){
			$('.c_f_menus_four2').submit();
		}else if($('#enterprise').length!=0){
			
			$('.c_f_menus_four3').submit();
		}else{
			$('.c_f_menus_four').submit();
		}
	});
	
	if($('#admin').length!=0){
		$('.menus_five').hide();
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
						if($('.header_hidden').text() === 'enterprise'){
							self.location = '/f_main/f_main';
						}
						$('.header_join').show();
						window.location.reload();
				}});
		}else{
			 
			self.location = "/c_login/login";
		}
	});
	
	
	
	
	
});
