var SetTime = 60; //60초
function countdown(){
	m = SetTime % 60 + "초"; //남은 시간
	var msg = "현재 남은 시간 : <font color='red'>"+m+"</font>";
	document.all.Timmer.innerHTML = msg;//뷰로 보여줌.
	SetTime--; // 1초씩 감소
	if(SetTime < 0){ // 시간 종료
		clearInterval(tid); // 타이머 해제
		alert("인증번호 요청시간을 초과하였습니다.");
		
		window.open("about:blank", "_self").close();
	}
}