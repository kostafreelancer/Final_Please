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
	if (document.form.EmailId.value == "") {
		alert("이메일을 입력하세요.");
		document.form.EmailId.focus();
		
		return false;
	}
	
	if (document.form.EmailId.value == "") {
			alert("이메일을 입력하세요.");
			document.form.EmailId.focus();
			
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