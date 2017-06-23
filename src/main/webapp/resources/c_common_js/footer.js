/**
 * 
 */
$(function(){
	$('.footer_selects').change(function(){
		window.open($('.footer_selects option:selected').val());
	});
	/*alert($('.header_welcome_content span').text());*/
	localStorage.setItem('username',$('.header_welcome_content span').text());
	
});