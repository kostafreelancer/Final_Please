
$(function(){
	
	//아이디 중복확인 창 띄우기

$('#idCheckbox').click(function(){
    var id = document.getElementById("e_id").value;
    
    if (!id) {
        alert("아이디를 입력하지 않았습니다.");
        return false;
    } 
    else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
        alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
        return false;
    }
    else
    {
       $('#checkForm').submit();
    }
});

   
	/*        $('#idCheckbox').click(function(){
                 if($('input[name="e_id"]').val() == ""){           //속성을 통해 접근, var : name에 있는 값을 뽑아옴
                            $('input[name="e_id"]').css('border', '1px solid red');
                            $('#idCheckbox').after("<span>아이디을 입력하세요.</span>");               //after : 동생, 뒤에 붙여줌
                  }
                  if($('input[name="e_id]').val()==${e_id}){
                	  $('input[name="e_id"]').css('border', '1px solid red');
                  $('#idCheckbox').after("<span>이미 존재하는 아이디입니다.</span>");
                  }
                  return false;                   //form이 submit로 하려는 기본이벤트를 가지고 있다
                  
                  
        });*/
	

	//사진이미지 미리보기

	//이메일 주소
	   $('#manager_mail3').change(function(){
		      var e_mail = $(this).val();
		      if(e_mail == ""){
		         $('#manager_mail2').removeAttr('readonly');
		      }else{
		         $('#manager_mail2').attr('readonly', 'true')
		      }
		      $('#manager_mail2').val(e_mail);
		   });
	   $('#e_mail3').change(function(){
		   var e_mail = $(this).val();
		   if(e_mail == ""){
			   $('#e_mail2').removeAttr('readonly');
		   }else{
			   $('#e_mail2').attr('readonly', 'true')
		   }
		   $('#e_mail2').val(e_mail);
	   });
	   $('#f_email3').change(function(){
		   var e_mail = $(this).val();
		   if(e_mail == ""){
			   $('#f_email2').removeAttr('readonly');
		   }else{
			   $('#f_email2').attr('readonly', 'true')
		   }
		   $('#f_email2').val(e_mail);
	   });

	
	

	
	
	//회원가입 빈칸 확인
	$('#checkValue').click(function(){
		var form = document.userInfo;
        
		//기업
        if(!form.e_id.value){
            alert("아이디를 입력하세요.");
            return false;
        }
/*       if(form.idDuplication.value != "idCheck"){
            alert("아이디 중복체크를 해주세요.");
            return false;
        }*/
        
        if(!form.e_pwd.value){
            alert("비밀번호를 입력하세요.");
            return false;
        }
        if(form.e_pwd.value != form.e_pwdcheck.value ){
            alert("비밀번호를 동일하게 입력하세요.");
            return false;
        }    
        if(!form.e_name.value){
        	alert("가입자명을 입력하세요.");
        	return false;
        }
        if(!form.e_ename.value){
            alert("회사명을 입력하세요.");
            return false;
        }
        if(!form.e_owner.value){
            alert("대표자명을 입력하세요.");
            return false;
        }
        if(!form.e_mail1.value){
        	alert("회사이메일을 입력하세요.");
        	return false;
        }
        if(!form.e_mail2.value){
        	alert("회사이메일을 입력하세요.");
        	return false;
        }
        if(!form.e_regno1.value){
        	alert("사업자등록번호를 입력하세요.");
        	return false;
        }
        
        if(isNaN(form.e_regno1.value)){
            alert("사업자등록번호는 숫자만 입력가능합니다.");
            return false;
        }
        if(!form.e_regno2.value){
        	alert("사업자등록번호를 입력하세요.");
        	return false;
        }
        
        if(isNaN(form.e_regno2.value)){
        	alert("사업자등록번호는 숫자만 입력가능합니다.");
        	return false;
        }
        if(!form.e_regno3.value){
        	alert("사업자등록번호를 입력하세요.");
        	return false;
        }
        
        if(isNaN(form.e_regno3.value)){
        	alert("사업자등록번호는 숫자만 입력가능합니다.");
        	return false;
        }

        
        if(!form.e_bf.value){
            alert("주요사업내용을 입력하세요.");
            return false;
        }
        if(!form.manager_name.value){
        	alert("담당자이름을 입력하세요.");
        	return false;
        }
        
        if(form.manager_hphone1.value == ""){
            alert("번호를 선택하세요.");
            return false;
        }
        if(!form.manager_hphone2.value){
        	alert("담당자연락처를 입력하세요.");
        	return false;
        }
        if(isNaN(form.manager_hphone2.value)){
            alert("담당자연락처는 숫자만 입력해주세요.");
            return false;
        }

        if(!form.manager_hphone3.value){
        	alert("담당자연락처를 입력하세요.");
        	return false;
        }
        if(isNaN(form.manager_hphone3.value)){
            alert("담당자연락처는 숫자만 입력해주세요.");
            return false;
        }
        
        if(form.e_phone1.value == ""){
        	alert("대표전화번호를 선택하세요.");
        	return false;
        }
        if(!form.e_phone2.value){
        	alert("대표전화를 입력하세요.");
        	return false;
        }
        if(isNaN(form.e_phone2.value)){
        	alert("대표전화를 숫자만 입력해주세요.");
        	return false;
        }
        
        if(!form.e_phone3.value){
        	alert("대표전화를 입력하세요.");
        	return false;
        }
        if(isNaN(form.e_phone3.value)){
        	alert("대표전화를 숫자만 입력해주세요.");
        	return false;
        }
        
        if(!form.address2.value){
        	alert("회사주소를 입력하세요.");
        	return false;
        }
/*        if(!form.e_licensefile.value){
        	alert("사업자등록증을 등록해주세요.");
        	return false;
        }*/
	});
	
	
	
	
	
	 //프리랜서
	$('#f_checkValue').click(function(){
		var form1 = document.f_userInfo;  
        if(!form1.f_id.value){
        	alert("아이디를 입력하세요.");
        	return false;
        }
        
        /*       if(form.idDuplication.value != "idCheck"){
            alert("아이디 중복체크를 해주세요.");
            return false;
        }*/
        
        if(!form1.f_pwd.value){
        	alert("비밀번호를 입력하세요.");
        	return false;
        }
        
        if(form1.f_pwd.value != form1.f_pwdcheck.value ){
        	alert("비밀번호를 동일하게 입력하세요.");
        	return false;
        }    
        
        if(!form1.f_name.value){
        	alert("성명을 입력하세요.");
        	return false;
        }
        if(!form1.f_birth.value){
        	alert("생일을 입력하세요.");
        	return false;
        }
        if(isNaN(form1.f_birth.value)){
        	alert("생년월일은 숫자만 입력해주세요.");
        	return false;
        }
        if(form1.f_hphone1.value == ""){
        	alert("핸드폰번호를 선택하세요.");
        	return false;
        }
        if(!form1.f_hphone2.value){
        	alert("핸드폰번호를 입력하세요.");
        	return false;
        }
        if(isNaN(form1.f_hphone2.value)){
        	alert("핸드폰번호는 숫자만 입력해주세요.");
        	return false;
        }
        
        if(!form1.f_hphone3.value){
        	alert("핸드폰번호를 입력하세요.");
        	return false;
        }
        if(isNaN(form1.f_hphone3.value)){
        	alert("핸드폰번호는 숫자만 입력해주세요.");
        	return false;
        }
        if(!form1.f_email1.value){
        	alert("이메일을 입력하세요.");
        	return false;
        }
        if(!form1.f_email2.value){
        	alert("이메일을 입력하세요.");
        	return false;
        }
        if(!form1.f_address2.value){
        	alert("주소를 입력하세요.");
        	return false;
        }        
        if($('input:checkbox[name="f_major"]:checked').length != 1){
        	alert("주 분야를 선택하세요.");
        	return false;
        }
        if($('input:checkbox[name="fm_new_keyword[]"]:checked').length == 0){
        	alert("기본 분야를 선택하세요.");
        	return false;
        }
   });

        $(".f_major").click(function() { 
        	$(".f_major").attr("checked", false); 
        	$(this).attr("checked", true);
});

});








	




