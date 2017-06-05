$(function(){

$('#checkValue').click(function(){
		var form = document.EnterpriseWriteFm;
	    
	    if(!form.e_pwd_1.value){
	        alert("비밀번호를 입력하세요.");
	        return false;
	    }
	    else if(!form.e_pwd_2.value){
	    	alert("비밀번호 확인을 입력하세요.");
	    	return false;
	    }
	    else if(!(form.e_pwd_1.value == form.e_pwd_2.value)){
	    	alert("비밀번호가 일치하지 않습니다.");
	    	return false;
	    }
	    else if(!form.e_mail_1.value || !form.e_mail_2.value){
	    	alert("이메일을 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_name.value){
	    	alert("가입자 명을 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_ename.value){
	    	alert("회사명을 입력하세요.");
	    	EnterpriseWriteFm.e_ename.focus();
	    	return false;
	    }
	    else if(!form.e_owner.value){
	    	alert("대표자명을 입력하세요.");
	    	return false;
	    }
	    else if(!form.regno_1.value || !form.regno_2.value || !form.regno_3.value){
	    	alert("사업자 등록번호를 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_phone_2.value || !form.e_phone_3.value){
	    	alert("회사 연락처를 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_bf.value){
	    	alert("주요사업내용을 입력하세요.");
	    	return false;
	    }
	    else if(!form.manager_hphone_2.value || !form.manager_hphone_3.value){
	    	alert("담당자명 핸드폰번호를 입력하세요.");
	    	return false;
	    }
	    else if(!form.manager_name.value){
	    	alert("담당자명을 입력하세요.");
	    	return false;
	    }
	    else if(!form.manager_mail_1.value || !form.manager_mail_2.value){
	    	alert("담당자 이메일을 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_address_1.value || !form.e_address_2.value || !form.e_address_3.value){
	    	alert("회사 주소를 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_homepage.value){
	    	alert("회사 홈페이지를 입력하세요.");
	    	return false;
	    }
	    else if(!form.start_year.value){
	    	alert("설립년도를 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_enum.value){
	    	alert("사원 수를 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_capital.value){
	    	alert("자본금을 입력하세요.");
	    	return false;
	    }
	    else if(!form.e_sales.value){
	    	alert("매출액을 입력하세요.");
	    	return false;
	    }
	    else{
	    	form.submit();
	    }
	});
});