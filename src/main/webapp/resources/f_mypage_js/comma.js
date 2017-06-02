// JavaScript Document
 function set_comma(val1){
  var newValue = val1.toString(); //숫자를 문자열로 변환
  var belowComma ="";
  var OverComma ="";
  if(newValue.indexOf(".")>0){
  	belowComma = "." + newValue.substring(newValue.indexOf(".")+1);
  	newValue = newValue.substring(0,newValue.indexOf("."));
  }
  var len = newValue.length;  
  var ch="";
  var j=1;
  var formatValue="";
  
  // 콤마제거  
  newValue = newValue.replace(/\,/gi, ' ');
  
  // comma제거된 문자열 길이
  len = newValue.length;
  
  for(i=len ; i>0 ; i--){
   ch = newValue.substring(i-1,i);
   formatValue = ch + formatValue;
   if ((j%3) == 0 && i>1 ){
    formatValue=","+formatValue;
   }
   j++
  }
  	formatValue = formatValue + belowComma;
  return formatValue;
 }
 
function insert_comma(cnj_str,decimalflag) { 
	//2009-12-09 기존 함수의 불편함(금액잘못입력시 0원으로 초기화, 00이 계속 들어감,음수일때 콤마 잘못찍힘등등)으로 재작성
	//소숫점 까지 처리했는데 돈에는 소숫점이 불필요할것 같아서 빼도 될것같음
	//3자리에 콤마는 위에 함수로 새로 만듬 아래것 안씀.
	
	if (decimalflag==1){
		decimalflag=1;
	}else{
		decimalflag=0;
	}		//1은 소숫점 있고, 0은 소숫점 제한
	
	var tmpMinus ='';
    temp_value = cnj_str.value.toString(); 
    regexp = /[^-\.0-9]/g; 
    repexp = ''; 
    temp_value = temp_value.replace(regexp,repexp);

	regexp = /^(-?)([0-9]*)(\.?)([^0-9]*)([0-9]*)([^0-9]*)/;
    repexp = '$1$2$3$5';
	if (temp_value.substring(0,2) == "0-"){
		temp_value = "-0";
	}
	if (temp_value == "-"){
		temp_value = "0";
	}	
    temp_value = temp_value.replace(regexp,repexp);
    temp_value = temp_value.replace(/\,/gi, '');
	if(temp_value.substring(0,1)=="-"){
		tmpMinus = "-"
	}
	temp_value = temp_value.replace(/-/gi, '');
	
	if(temp_value.length>0){
		if (decimalflag == 1){
			if(temp_value.substring(temp_value.indexOf(".")) == "."){
			}else if ((temp_value.indexOf(".")>0) &&(temp_value.substring(temp_value.length-1) == "0")){
			}else{temp_value = parseFloat(temp_value);}
		}else{
			temp_value = parseFloat(temp_value);
		}
    }else{
    	temp_value = 0
    }

    temp_value = tmpMinus + set_comma(temp_value)
    cnj_str.value = temp_value; 


/*
	var t_align = "right"; // 텍스트 필드 정렬
    var t_num = cnj_str.value.substring(0,1); // 첫글자 확인 변수
    var num =  /^[\/,\/,\-,0,1,2,3,4,5,6,7,8,9,\/]/; // 숫자와 , 만 가능
    var cnjValue = ""; 
    var cnjValue2 = "";
	if(cnj_str.value=="") 
		return false;

    if (!num.test(cnj_str.value))   {
    alert('숫자만 입력하십시오.\n\n특수문자와 한글/영문은 사용할수 없습니다');
    cnj_str.value=cnj_str.replace(num,"");
    cnj_str.focus();
    return false;
    }
    
     for(i=0; i<cnj_str.value.length; i++)      {   
         if(cnj_str.value.charAt(cnj_str.value.length - i -1) != ",") { 
             cnjValue2 = cnj_str.value.charAt(cnj_str.value.length - i -1) + cnjValue2; 
		 } 
	} 

	if (t_num == "-") {
			cnjValue2 = cnjValue2.substring(1,cnjValue2.length+1);
			cnjminus = "-";
	} else {
		cnjminus = "";
	}
	
	if(isNaN(cnjValue2)){
		alert("숫자만 입력해주세요.");
		cnj_str.value = cnj_str.replace(num,"");
		cnj_str.focus();
		return false;
	}

	for(i=0; i<cnjValue2.length; i++)         { 

                if(i > 0 && (i%3)==0) { 
                        cnjValue = cnjValue2.charAt(cnjValue2.length - i -1) + "," + cnjValue; 
                 } else { 
                        cnjValue = cnjValue2.charAt(cnjValue2.length - i -1) + cnjValue; 
			} 
	} 
	 cnj_str.value = cnjminus + cnjValue;
	 cnj_str.style.textAlign = t_align;
*/
}

function insertComma(pay){ 
	console.log("dd");
	var idx=0; 
	arrRev = new Array(); 
	var lpay = ""; 
	pay = pay.toString();
	pay_dot = pay.split(".");
	b_pay_k = false;	
	/**************/
	pay_a = pay.split("-");
	if( pay_a.length >= 2){
		b_pay_k = true;	
	}else{
		b_pay_k = false;
	}
	pay_k = pay_a[pay_a.length-1];
	pay = pay_k.toString();
	pay_dot = pay.split(".");
	/**************/
if (pay_dot.length > 0)
	lpay2 = pay_dot[1];

pay = pay_dot[0];
	  arr = pay.split("");

		//alert("arr" + arr); 
       //alert(arr.length); 
       for(i = arr.length; i > 0 ; i--){ 
           arrRev[idx] = arr[i-1]; 
           //alert(arrRev[idx] + "=>" + idx); 
           idx++; 
           if((idx ==3 || idx == 7 || idx == 11 || idx == 15 || idx == 19) && (i != 1)){ 
               arrRev[idx] = ","; 
               //alert(arrRev[idx] + "=>" + idx); 
               idx++; 
           } 
       } 
       //alert(arrRev.length); 
       for(i=arrRev.length; i>0; i--){ 
           lpay += arrRev[i-1]; 

       } 
   if (!isNaN(lpay2))
		lpay = lpay + "." + lpay2.substr(0,2);

	if( b_pay_k ){
		return "-"+lpay; 
	}else{
		return lpay;
	}
}

function del_comma(money) {
	for (i=0; i < (money.length-1)/3; i++)
		money = money.replace(",","");
	
	return money;
}
