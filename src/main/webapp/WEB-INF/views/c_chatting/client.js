/**
 * http://usejsdoc.org/
 */
/*$(function(){
		// 클라이언트에서 SEND 버튼을 클릭할 때
		alert("우왕");
		$('#datasend').click( function() {
			var message = $('#data').val();
			if(message === ''){
				return;
			}
			
			$('#data').val('');
			// 서버에서 sendchat 함수를 실행하도록 알려주며, 하나의 파라미터를 전달한다
			socket.emit('sendchat', message);
			$('.chat_content').append('<p class="client"><span>'+message+'</span></p>');
		});
		
		 $('.chat_menu').click(function(event){
			event.preventDefault();
			alert("여기 들어와?");
			socket.emit('alllist');
		});
		 
	});*/

$(document).ready(function() {
	// 클라이언트에서 SEND 버튼을 클릭할 때
	alert("우왕");
	$('#datasend').click( function() {
		var message = $('#data').val();
		if(message === ''){
			return;
		}
		
		$('#data').val('');
		// 서버에서 sendchat 함수를 실행하도록 알려주며, 하나의 파라미터를 전달한다
		socket.emit('sendchat', message);
		$('.chat_content').append('<p class="client"><span>'+message+'</span></p>');
	});
	
	 $('.chat_menu').click(function(event){
		event.preventDefault();
		alert("여기 들어와?");
		socket.emit('alllist');
	});
	
	
});