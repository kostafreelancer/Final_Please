$(document).ready(function() {
	$("#content div").hide(); // Initially hide all content
	$("#tabs li:first").attr("id","current"); // Activate first tab
	$("#content div:first").fadeIn(); // Show first tab content
    
    $('#tabs a').click(function(e) {
        e.preventDefault();        
        $("#content div").hide(); //Hide all content
        $("#tabs li").attr("id",""); //Reset id's
        $(this).parent().attr("id","current"); // Activate this
        $('#' + $(this).attr('title')).fadeIn(); // Show content for current tab
    });
});

$(function(){
	var $container = $('.main_slide'); // 슬라이드쇼 전체 컨테이너
	var $slideGroup = $('.slideshow_images'); // 슬라이드 그룹
	var $slides = $container.find('.slide') // slideshow 에 slide 를 갖고있는애들. 각각의 슬라이드
	var $nav = $container.find('.slideshow-nav'); // 네비게이션 (Prev/Next)
	var $indicator = $container.find('.slideshow-indicator')// 인디케이터
	
	var currentIndex = 0; // 현재의 인덱스
	var slideCount = $slides.length; // 슬라이드의 갯수
	var indecatorHTML = "";
	var timer;
	
	$slides.each(function(i){
		$(this).css({
			left : 100 * i +'%'
		});
		
		indecatorHTML += '<a href="#">'+(i+1)+'</a>';
		
	});
	
	$indicator.html(indecatorHTML);
	
	//슬라이드 이동함수
	function goToSlide(index){
		$slideGroup.animate({
			left : -100 * index + '%'
		},500);
		currentIndex = index;
		updateNav();
	}
	
	//네비게이션 이벤트
	$nav.find('a').click(function(event){
		event.preventDefault(); // 기본이벤트를 취소하는 방법, return false 와 같음
		if($(this).hasClass('prev')){
			goToSlide(currentIndex -1);
		}else{
			goToSlide(currentIndex + 1);
		}
	
	});
	
	//네비게이션 업데이트 함수
	function updateNav(){
		var $navPrev = $nav.find('.prev');
		var $navNext = $nav.find('.next');
		
		if(currentIndex == 0){
			$navPrev.addClass('disabled');
		}else{
			$navPrev.removeClass('disabled');
		}
		if(currentIndex == slideCount -1){
			$navNext.addClass('disabled');
		}else{
			$navNext.removeClass('disabled');
		}
		//해당 인디케이터에게 스타일을 줌 'active' 클래스명 주입
		//$indicator.on('click','a',function(){
			$indicator.find('a').removeClass('active').eq(currentIndex).addClass('active');
			
			
		//})
		
	}
	
	//인디케이터 이벤트
	
/*	$indicator.on('click','a',function(event){
		event.preventDefault();
		if(!$(this).hasClass('active')){
			goToSlide($(this).index());
		}
		
	});
	*/
	//타이머 시작함수
	function startTimer(){ //주기적으로 사진이 로테이션으로 돌아감
		timer = setInterval(function() {
			var nextIndex = (currentIndex + 1) % slideCount;
			goToSlide(nextIndex);
		}, 2000);			
	}
	
	//타이머 중지함수
	function stopTimer(){
		clearTimeout(timer);
	}
	
	//마우스 이벤트 설정 : mouseEnter, mouseLeave
	/*$container.on({
		mouseenter : stopTimer,
		mouseleave : startTimer
	})*/
	
	goToSlide(currentIndex);
	startTimer();

});