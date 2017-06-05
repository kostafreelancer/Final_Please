$(document).ready(function() {

	// 별점표시
	var e_score = $('#e_score').html();
	var i = 0;
	if(e_score == 5.0){
		$('.star_rating').find('a:eq(4)').addClass('on').prevAll('a').addClass('on');
	}else if(e_score > 4.0){
		$('.star_rating').find('a:eq(3)').addClass('on').prevAll('a').addClass('on');
		$('.star_rating').find('a:eq(4)').addClass('half');
	}else if(e_score > 3.0){
		$('.star_rating').find('a:eq(2)').addClass('on').prevAll('a').addClass('on');
		$('.star_rating').find('a:eq(3)').addClass('half');
	}else if(e_score > 2.0){
		$('.star_rating').find('a:eq(1)').addClass('on').prevAll('a').addClass('on');
		$('.star_rating').find('a:eq(2)').addClass('half');
	}else if(e_score > 1.0){
		$('.star_rating').find('a:eq(0)').addClass('on');
		$('.star_rating').find('a:eq(1)').addClass('half');
	}else if(e_score > 0.0){
		$('.star_rating').find('a:eq(0)').addClass('half');
	}
	
	
	
	// 기업이메일 설정
	var e_mail = $('#e_mail_2').val();
	$('#e_mail_select > option[value=e_mail]').attr('selected', 'true');
	
	// 기업이메일 선택하기
	$('#e_mail_select').change(function(){
		var e_mail = $(this).val();
		if(e_mail == ""){
			$('#e_mail_2').removeAttr('readonly');
		}else{
			$('#e_mail_2').attr('readonly', 'true')
		}
		$('#e_mail_2').val(e_mail);
	});
	
	// 담당자 이메일 설정
	var manager_mail = $('#manager_mail').val();
	$('#manager_mail_select > option[value=manager_mail]').attr('selected', 'true');
	
	// 담당자 이메일 선택하기
	$('#manager_mail_select').change(function(){
		var manager_mail = $(this).val();
		if(manager_mail == ""){
			$('#manager_mail_2').removeAttr('readonly');
		}else{
			$('#manager_mail_2').attr('readonly', 'true')
		}
		$('#manager_mail_2').val(manager_mail);
	});
	
});




	
