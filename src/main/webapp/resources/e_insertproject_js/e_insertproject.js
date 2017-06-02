$(function(){
	$('#checkValue').click(function(){
		var form = document.ProjectWriteFm;
	    
	    if(!form.p_name.value){
	        alert("프로젝트명를 입력하세요.");
	        return false;
	    }
	    if($(form.check).is(":checked")==false){
	        alert("기본분야를 선택하세요.");
	        return false;
	    }
	    
	    if(!form.p_lowerAge.value){
	        alert("연령을 선택하세요.");
	        return false;
	    }
	    
	    if(!form.p_upperAge.value){
	        alert("연령을 선택하세요.");
	        return false;
	    }
	    
	    if(!form.p_requireNum.value){
	        alert("모집인원을 입력하세요.");
	        return false;
	    }
	    if(!form.p_exDate.value){
	        alert("모집마감일자를 선택하세요.");
	        return false;
	    }
	    if(!form.p_lowerCost.value){
	        alert("프로젝트 금액을 입력하세요.");
	        return false;
	    }
	    if(!form.p_upperCost.value){
	        alert("프로젝트 금액을 입력하세요.");
	        return false;
	    }
	    if(!form.p_startDate.value){
	        alert("근무기간을 선택하세요.");
	        return false;
	    }
	    if(!form.p_endDate.value){
	        alert("근무기간을 선택하세요.");
	        return false;
	    }
	    if(!form.p_location1.value){
	        alert("근무지역을 선택하세요.");
	        return false;
	    }   
	    
	});
});
	