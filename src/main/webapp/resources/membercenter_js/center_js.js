

$(document).ready(function() {
	$(".viewAnswer button").on("click",function(){
		
		
		var asknum = $(this).parent().parent().find("td:eq(0)").text();
		var f_num = $(this).parent().parent().find("input:eq(0)").val();	
			$.getJSON("/answer/all/" + asknum + "/" + f_num, function(data){
				var str = "";
				
				
				$(data).each(function(){
				/*str += "<li data-rno='"+this.ad_num+"' class='answerLi'>" + '관리자번호 : ' + this.ad_num + "," + '답변날짜 : ' +this.answerdate + "," + '답변내용 : ' + this.answercontents + "</li>";*/
				str += "<table class='email_table'><tbody><tr><th>관리자번호</th><td>"+this.ad_num+"</td><tr><th>답변내용</th><td>"+this.answercontents+"</td></tr><tr><th>답변날짜</th><td>"+this.answerdate+"</tr>"
				}) //end each
				
				$(".myAnswer").html(str);			
				$(".myAnswer").toggle();
				
				
			})
		})    
	
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
    
    $("#doAsk").click(function(){
    	var form = document.wantAsk

    	if(!form.asktitle.value){
    		alert("제목을 입력해 주세요.");
    		return false;
    	}
    	
    	if(!$("#askcontents").val()){
    		alert("내용을 입력해 주세요");
    		return false;
    	}
    })

   
});



// ajax를 해보자!

