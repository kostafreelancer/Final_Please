/*
* Skeleton V1.0.3
* Copyright 2011, Dave Gamache
* www.getskeleton.com
* Free to use under the MIT license.
* http://www.opensource.org/licenses/mit-license.php
* 7/17/2011
*/

jQuery(document).ready(function($) {


		/* Superfish
	================================================== */
	var xmlHttp	=	createXmlHttpRequestObject();

	function createXmlHttpRequestObject(){
		var xmlHttp;

		// IE
		if(window.ActiveXObject){
			try{
				xmlHttp	=	new	ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				xmlHttp	=	false;
			}
		}
		// Mozila or Somthing
		else{
			try{
				xmlHttp	=	new	XMLHttpRequest();
			}catch(e){
				xmlHttp	=	false;
			}
		}
		
		if(!xmlHttp)
			alert("XMLHttpRequest error!!");
		else
			return xmlHttp;
	}

	/*** 
	 *  jquery 를 사용한 ajax
	 */
	$('#test').click(function process(){
		//param	=	$('#inputName').val();
		// when xmlHttp is not busy
		
		$.ajax({
			  type:"POST",
			 // dataType:'json',
			  //url:"../php/quickstart.php?param="+param,
  			  url:"http://ctascy.dothome.co.kr/wordpress/index.php/counsel_post-2/",
			  success:function(data){
				  //$("#divMessage").text(data.documentElement.firstChild.data);
				 console.log(data);
			  },
			  error:function(){
				  setTimeout('process()',1000);
			  }
		});
	
	});

	$(function(){

		var mag= new Array(
			'이름을 정확하게 입력 해주세요',
			'전화번호를 정확하게 입력 해주세요',
			'휴대전화 번호를 정확하게 입력 해주세요',
			'이메일 주소를 정확하게 입력해주세요'
		);

		$('#test').click(function (){
			if(!$('#user_name').val()){
				alert(mag[0]);
				$('#user_name').focus();
				return false;
			}
			/*if(!$('#user_tel1').val()){
				alert(mag[1]);
				$('#user_tel1').focus();
				return false;
			}
			if(!$('#user_tel2').val()){
				alert(mag[1]);
				$('#user_tel2').focus();
				return false;
			}
			if(!$('#user_tel3').val()){
				alert(mag[1]);
				$('#user_tel3').focus();
				return false;
			}*/
			if(!$('#user_cel1').val()){
				alert(mag[2]);
				$('#user_cel1').focus();
				return false;
			}
			if(!$('#user_cel2').val()){
				alert(mag[2]);
				$('#user_cel2').focus();
				return false;
			}
			if(!$('#user_cel3').val()){
				alert(mag[2]);
				$('#user_cel3').focus();
				return false;
			}
			//$("#counsel").auction='./index.php/348-2/';
			$("#counsel").submit()
			alert('상담 신청이 완료되었습니니다.')
		});
	});

	$(function(){ // run after page loads
		$('#navigation ul.menu')
		.find('li.current_page_item,li.current_page_parent,li.current_page_ancestor,li.current-cat,li.current-cat-parent,li.current-menu-item')
			.addClass('active')
			.end()
			.superfish({autoArrows	: true});
	});

	// Forum Login

	$(function(){ // run after page loads
		$("#toggle").click(function() {
	    // hides matched elements if shown, shows if hidden
	    $("#login-form").slideToggle();
	  });
	});

	// Style Tags

	$(function(){ // run after page loads
		$('p.tags a')
		.wrap('<span class="st_tag" />');
	});


	// Toggle Slides

	$(function(){ // run after page loads
			$(".toggle_container").hide();
			//Switch the "Open" and "Close" state per click then slide up/down (depending on open/close state)
			$("p.trigger").click(function(){
				$(this).toggleClass("active").next().slideToggle("normal");
				return false; //Prevent the browser jump to the link anchor
			});
	});

	// valid XHTML method of target_blank
	$(function(){ // run after page loads
		$('a[rel*=external]').click( function() {
			window.open(this.href);
			return false;
		});
	});


	/* Tabs Activiation
	================================================== */
	var tabs = $('ul.tabs');
	tabs.each(function(i) {
		//Get all tabs
		var tab = $(this).find('> li > a');
		$("ul.tabs li:first-child").addClass("active").fadeIn('fast'); //Activate first tab
		$("ul.tabs li:first-child a").addClass("active").fadeIn('fast'); //Activate first tab
		$("ul.tabs-content li:first-child").addClass("active").fadeIn('fast'); //Activate first tab


		tab.click(function(e) {

			//Get Location of tab's content
			var contentLocation = $(this).attr('href') + "Tab";

			//Let go if not a hashed one
			if(contentLocation.charAt(0)=="#") {

				e.preventDefault();

				//Make Tab Active
				tab.removeClass('active');
				$(this).addClass('active');

				//Show Tab Content & add active class
				$(contentLocation).show().addClass('active').siblings().hide().removeClass('active');

			}
		});
	});

});





