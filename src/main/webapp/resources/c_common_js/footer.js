/**
 * 
 */
$(function(){
	$('.footer_selects').change(function(){
		window.open($('.footer_selects option:selected').val());
	});
});