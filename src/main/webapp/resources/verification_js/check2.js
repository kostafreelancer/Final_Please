function check2() {

	if(document.form.num.value == ""){
		alert("인증번호를 입력하십시오.");
		document.form.num.focus();
		
		return false;
	}
	
	if($('num') != $('#codeNum')){
		alert("인증번호가 일치하지 않습니다.");
		document.form.num.focus();
		
		return false;
	}

}