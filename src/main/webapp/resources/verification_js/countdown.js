var second = 60;
function timer(){
   m = Math.floor(second/60) + "분" + (second%60) + "초";
   var msg = "남은 시간 : <font color='red'>" + m + "</font>";
   document.all.Timer.innerHTML = msg;
   
   second--;
   
   if(second < 0){
      clearInterval(tid);
      alert("인증요청 시간이 초과되었습니다.");
      //window.close();
   };
};

window.onload = function timerStart() {
   tid = setInterval('timer()', 1000);
 
};

