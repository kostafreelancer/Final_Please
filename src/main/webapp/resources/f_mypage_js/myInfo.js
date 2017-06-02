
$(document).ready(function() {
	$("#content>div").hide(); // Initially hide all content
	$("#tabs li:first").attr("id","current"); // Activate first tab
	$("#content>div:first").fadeIn(); // Show first tab content
    
    $('#tabs a').click(function(e) {
        e.preventDefault();        
        $("#content>div").hide(); //Hide all content
        $("#tabs li").attr("id",""); //Reset id's
        $(this).parent().attr("id","current"); // Activate this
        $('#' + $(this).attr('title')).fadeIn(); // Show content for current tab
    });
   
    $('#fm_emailSel1').change(function(){
        var e_mail = $(this).val();
        if(e_mail == ""){
           $('#fm_email12').removeAttr('readonly');
        }else{
           $('#fm_email12').attr('readonly', 'true')
        }
        $('#fm_email12').val(e_mail);
     });
});


function check(){
	var form = document.updateForm;
	if(form.f_pwd.value == ""){
		alert("비밀번호를 입력해주세요.");
		updateForm.f_pwd.focus();
		return false;
	}else if(form.f_pwd2.value == ""){
		alert("비밀번호 확인란을 입력해주세요.");
		updateForm.f_pwd2.focus();
		return false;
	}else if(form.f_pwd.value != form.f_pwd2.value){
		alert("비밀번호를 동일하게 입력해주세요.");
		updateForm.f_pwd.focus();
		return false;
	}else if(form.f_name.value == ""){
		alert("이름을 입력해주세요.");
		updateForm.f_name.focus();
		return false;
	}else if(form.f_birth.value == ""){
		alert("생년월일을 입력해주세요.");
		updateForm.f_birth.focus();
		return false;
	}else if(form.f_sex.value == ""){
		alert("성별을 입력해주세요.");
		updateForm.f_sex.focus();
		return false;
	}else if(form.fm_tel1.value == ""){
		alert("전화번호를 입력해주세요.");
		updateForm.fm_tel1.focus();
		return false;
	}else if(form.fm_tel2.value == ""){
		alert("전화번호를 입력해주세요.");
		updateForm.fm_tel2.focus();
		return false;
	}else if(form.fm_tel3.value == ""){
		alert("전화번호를 입력해주세요.");
		updateForm.fm_tel3.focus();
		return false;
	}else if(form.fm_phone1.value == ""){
		alert("휴대번 번호를 입력해주세요.");
		updateForm.fm_tel1.focus();
		return false;
	}else if(form.fm_phone2.value == ""){
		alert("휴대폰 번호를 입력해주세요.");
		updateForm.fm_tel2.focus();
		return false;
	}else if(form.fm_phone3.value == ""){
		alert("휴대폰 번호를 입력해주세요.");
		updateForm.fm_tel3.focus();
		return false;
	}else if(form.fm_email11.value == ""){
		alert("이메일을 입력해주세요.");
		updateForm.fm_email11.focus();
		return false;
	}else if(form.fm_email12.value == ""){
		alert("이메일을 입력해주세요.");
		updateForm.fm_email12.focus();
		return false;
	}else if(form.fm_zip.value == ""){
		alert("우편번호를 입력해주세요.");
		updateForm.fm_zip.focus();
		return false;
	}else if(form.fm_address.value == ""){
		alert("주소를 입력해주세요.");
		updateForm.fm_address.focus();
		return false;
	}else if(form.fm_address_etc.value == ""){
		alert("주소를 입력해주세요.");
		updateForm.fm_address_etc.focus();
		return false;
	}
	else{
		return true;
	}
}

function openDaumZipAddress() {

    new daum.Postcode({
        
        oncomplete:function(data) {

       	  // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('fm_zip').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('fm_address').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('fm_address_etc').value="";
            document.getElementById('fm_address_etc').focus();
        }
    }).open();
}
function addCareer(){
	window.open('/Matching_Project/f_mypage/careerAdd.jsp','win','width=350, height=250');
}
function addSchool(){
	window.open('/Matching_Project/f_mypage/schoolAdd.jsp','win','width=350, height=250');
}
function addCerti(){
	window.open('/Matching_Project/f_mypage/certiAdd.jsp','win','width=350, height=250');
}

function addCareerSubmit(){
	document.tempCareerAdd.submit();
}
function addSchoolSubmit(){
	document.tempSchoolAdd.submit();
}
function addCertiSubmit(){
	document.tempCertiAdd.submit();
}


function modifyCareer(num){
    window.open('about:blank','popup_window','width=350, height=250');
    var wantForm = 'careerForm'+num;
    var frm =document.getElementById(wantForm);
    frm.submit();
}
function modifySchool(num){
    window.open('about:blank','popup_window','width=350, height=250');
    var wantForm = 'schoolForm'+num;
    var frm =document.getElementById(wantForm);
    frm.submit();
}
function modifyCerti(num){
    window.open('about:blank','popup_window','width=350, height=250');
    var wantForm = 'certiForm'+num;
    var frm =document.getElementById(wantForm);
    frm.submit();
}


function modifyCareerSubmit(){
	document.tempCareerModify.submit();
}
function modifySchoolSubmit(){
	document.tempSchoolModify.submit();
}
function modifyCertiSubmit(){
	document.tempCertiModify.submit();
}


function deleteCareer(num){
	document.tempCareerDelete.deleteCareer_num.value = num;
	document.tempCareerDelete.submit();
}

function deleteSchool(num){
	document.tempSchoolDelete.deleteSchool_num.value = num;
	document.tempSchoolDelete.submit();
}
function deleteCerti(num){
	document.tempCertiDelete.deleteCerti_num.value = num;
	document.tempCertiDelete.submit();
}