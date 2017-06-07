
$(document).ready(function() {
	
	
	$(".viewAnswer").click(function(){
		
		alert("^^");
		/*$.ajax({
			type : 'post',
			url : '/myanswer/{asknum}',
			headers : {
				"Content-Type" : "text/css",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify({
				answercontents : answercontents,
				answertitle : answertitle,
				answerdate : answerdate,
				ad_num : ad_num,
				
				
			}),
			
			success : function(result){
				if(result == 'SUCCESS' ){
					alert("asd");
				}
			}
		})*/
	});
    
	
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

// ajax를 해보자!

$("#viewAnswer").on("click",function(){
	 
	 /*var replyerObj = $("#newReplyWriter");
	 var replytextObj = $("#newReplyText");
	 var replyer = replyerObj.val();
	 var replytext = replytextObj.val();
	
	  
	  $.ajax({
			type:'post',
			url:'/replies/',
			headers: { 
			      "Content-Type": "application/json",
			      "X-HTTP-Method-Override": "POST" },
			dataType:'text',
			data: JSON.stringify({bno:bno, replyer:replyer, replytext:replytext}),
			success:function(result){
				console.log("result: " + result);
				if(result == 'SUCCESS'){
					alert("등록 되었습니다.");
					replyPage = 1;
					getPage("/replies/"+bno+"/"+replyPage );
					replyerObj.val("");
					replytextObj.val("");
				}
		}});*/
	
	console.log("aa'");
});