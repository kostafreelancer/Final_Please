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


function g_chk(obj1,obj2,value){
	if( obj1.checked ){
		$("#"+obj2).html(insertComma(value));
	}else{
		$("#"+obj2).html("0");
	}
	g_hop();//소득공제금액
	h1_inp('lbl_a1');//계산
}
var g = 0;
function g_inp(obj1,obj2,value){
	g = obj1.value;
	if( g == "" ){
		g = 0;
	}	
	$("#"+obj2).html(insertComma(value * g));
	g_hop();//소득공제금액
	h1_inp('lbl_a1');//계산
}
function g_sam(obj1,obj2){
	$("#"+obj2).val(obj1.value);
	if( obj1.value < 2 ){
		$("#lbl_c6").html(insertComma(0));	
	}else{
		$("#lbl_c6").html(insertComma(1000000+(obj1.value-2)*2000000));	
	}
	g_hop();//소득공제금액
	h1_inp('lbl_a1');//계산
}
function g_hop(){	//소득공제금액
	var g = 600000+1500000;
	g += parseInt(del_comma($("#lbl_g1").html()),10)+parseInt(del_comma($("#lbl_g2").html()),10)+parseInt(del_comma($("#lbl_g3").html()),10)+parseInt(del_comma($("#lbl_g4").html()),10);//소득공제금액	
	g += parseInt(del_comma($("#lbl_c1").html()),10)+parseInt(del_comma($("#lbl_c2").html()),10)+parseInt(del_comma($("#lbl_c3").html()),10)+parseInt(del_comma($("#lbl_c4").html()),10)+parseInt(del_comma($("#lbl_c5").html()),10)+parseInt(del_comma($("#lbl_c6").html()),10)+parseInt(del_comma($("#lbl_c7").val()),10);//소득공제금액	

	$("#lbl_a4").val( insertComma( g ) );
	$("#lbl_b4").val( insertComma( g ) );
	return g;
}
function h1_inp(){//기준경비
	ab_sam('lbl_a1','lbl_b1');
	g = g_2;
	if( g == "" ){
		g = rate[0][1];
	}
	//alert(g);
		
	var a1 = del_comma( $("#lbl_a1").val() );//수입금액
	var a2 = a1 * g / 100;//기준경비
	$("#lbl_a2").val( insertComma( a2 ) );//기준경비
	var a3 = a1 - a2;//소득금액
	$("#lbl_a3").val( insertComma( a3 ) );//소득금액
	
	var a4 = g_hop();//소득공제
	
	//과세표준
	var g2 = a3 - a4;
	var a5;//과세표준금액
	if( g2 <= 0 ){
		a5 = 0;
	}else{
		a5 = g2;
	}
	$("#lbl_a5").val( insertComma(a5) );
	
	var a6;//결정세액금액
	if( a5 > 88000000 ){
		a6 = (a5 * 35 / 100)-14900000;
	}else if( a5 > 46000000 ){	
		a6 = (a5 * 24 / 100)-5220000;
	}else if( a5 > 12000000 ){	
		a6 = (a5 * 15 / 100)-1080000;
	}else{
		a6 = (a5 * 6 / 100);
	}
	a6 = parseInt(a6 * 1.1, 10);
	$("#lbl_a6").val( insertComma(a6) );
	
	var a7;//원천징수
	a7 = a1 * 3.3 / 100;
	$("#lbl_a7").val( insertComma(a7) );
	
	var a8;//환급세액금액
	a8 = a7 - a6;
	$("#lbl_a8").val( insertComma(a8) );
	
	var a9;//환급세액금액2
	a9 = a8 / a7 * 100;
	$("#lbl_a9").val( insertComma(a9) );
}

function ab_sam(obj1, obj2){
	$("#"+obj2).val($("#"+obj1).val());
	h2_inp();//단순경비
}
function h2_inp(){//단순경비
	g = g_1;
	if( g == "" ){
		g = rate[0][0];
	}
	var b1 = del_comma($("#lbl_b1").val());//수입금액
	var b2 = b1 * g / 100;//지출비용금액
	$("#lbl_b2").val( insertComma( b2 ) );//지출비용금액
	var b3 = b1 - b2;//소득금액
	$("#lbl_b3").val( insertComma( b3 ) );//소득금액
	
	var b4 = g_hop();//소득공제
	
	//과세표준
	var g2 = b3 - b4;
	var b5;//과세표준금액
	if( g2 <= 0 ){
		b5 = 0;
	}else{
		b5 = g2;
	}
	$("#lbl_b5").val( insertComma(b5) );
		
	var b6;//결정세액금액
	if( b5 > 88000000 ){
		b6 = (b5 * 35 / 100)-14900000;
	}else if( b5 > 46000000 ){	
		b6 = (b5 * 24 / 100)-5220000;
	}else if( b5 > 12000000 ){	
		b6 = (b5 * 15 / 100)-1080000;
	}else{
		b6 = (b5 * 6 / 100);
	}
	b6 = parseInt(b6 * 1.1, 10);
	$("#lbl_b6").val( insertComma(b6) );
	
	var b7;//원천징수
	b7 = b1 * 3.3 / 100;
	$("#lbl_b7").val( insertComma(b7) );
	
	var b8;//환급세액금액
	b8 = b7 - b6;
	$("#lbl_b8").val( insertComma(b8) );
	
	var b9;//환급세액금액2
	b9 = b8 / b7 * 100;
	$("#lbl_b9").val( insertComma(b9) );
}

var rate = new Array();//단순, 기본
rate[ 0] = Array(61.7,29.2);
rate[ 1] = Array(75  ,40.8);
rate[ 2] = Array(77.6,40.9);
rate[ 3] = Array(65.8,32.7);
rate[ 4] = Array(67.4,35.7);
rate[ 5] = Array(64.1,32.7);
rate[ 6] = Array(62.6,32.1);
rate[ 7] = Array(72.3,24.7);
rate[ 8] = Array(69  ,32.1);
rate[ 9] = Array(49.2,25.1);
rate[10] = Array(57.9,25.1);
rate[11] = Array(56.8,26.7);
rate[12] = Array(66.8,29.8);
rate[13] = Array(73.6,34.4);
rate[14] = Array(62.3,30.4);
rate[15] = Array(73.2,30.4);
rate[16] = Array(68.1,29.1);
rate[17] = Array(59.7,32.7);
rate[18] = Array(80  ,42.9);
rate[19] = Array(67.8,28.7);
rate[20] = Array(67.3,32.8);
rate[21] = Array(71.4,18.5);
rate[22] = Array(72.3,31.2);
rate[23] = Array(64  ,31.2);
rate[24] = Array(67.6,32.8);
rate[25] = Array(62  ,32.7);
rate[26] = Array(73.9,31.2);
rate[27] = Array(64.4,32.8);

var g_1 = rate[0][0];//단순
var g_2 = rate[0][1];//기준
function g_select(obj){//율
	g_1 = rate[parseInt(obj.value,10)][0];	
	g_2 = rate[parseInt(obj.value,10)][1];
	g_hop();//소득공제금액
	h1_inp('lbl_a1');//계산
}

$("#g_rate1").html( g_1 );
$("#g_rate2").html( g_2 );