function check() {
 
	if (document.form.id.value == "") {
		alert("아이디를 입력하세요.")
		document.form.id.focus();
		
		return false;
	}
	if (document.form.name.value == "") {
		alert("이름을 입력하세요.");
		document.form.name.focus();
		
		return false;
	}
	if (document.form.emailId.value == "") {
		alert("이메일을 입력하세요.");
		document.form.emailId.focus();
		
		return false;
	}
	
	if (document.form.emailId.value == "") {
			alert("이메일을 입력하세요.");
			document.form.emailId.focus();
			
		return false;
	}
	if(document.form.e_mail_select.value == "" 
		|| document.form.e_mail_select.value == "선택해주세요."){
				alert("이메일을 입력하세요.");
				document.form.e_mail_select.focus();
				
		return false;
	}
	if(document.form.sort.value < 1){
			alert("회원 분류를 선택해주십시오.");
			$('#f_btn').focus();
					
		return false;
	}

}

$(document).ready(function(){
	if($('#fail').text() == "true"){
		alert("해당하는 회원이 존재하지 않습니다.");
	}
	if($('#f_id').text() != ""){
		alert("회원님의 아이디는 "+$('#f_id').text()+"입니다.");
	}
	
	if($('#e_id').text() != ""){
		alert("회원님의 아이디는 "+$('#e_id').text()+"입니다.");
	}
	
	if($('#f_pwd').text() != ""){
		alert("회원님의 비밀번호는 "+$('#f_pwd').text()+"입니다.");
	}
	
	if($('#e_pwd').text() != ""){
		alert("회원님의 비밀번호는 "+$('#e_pwd').text()+"입니다.");
	}

})