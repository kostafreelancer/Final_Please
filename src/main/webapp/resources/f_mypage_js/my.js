$( document).ready(function() {
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
});