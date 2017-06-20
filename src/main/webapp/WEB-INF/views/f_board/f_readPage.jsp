<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="../../../resources/f_board_css/join.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../../../resources/f_board_css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../../../resources/f_board_css/reply.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../c_common/header.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../c_common/footer.css" type="text/css" media="screen" />
<title>프리랜서 자유게시판</title>
 <script src="../../../resources/f_board_js/jquery-1.3.2.js"></script> 
 <script type="text/javascript">
$(document).ready(function(){
	var formObj = $("form[role='form']");
	var formObj2 = $("form[role='form_test']");

	$(".btn_check04").click(function(){
		formObj.attr("action", "/f_board/f_modifyPage");
		formObj.attr("method", "get");
		formObj.submit();
	});
	$(".btn_remove").click(function(){
		formObj.attr("action", "/f_board/f_remove");
		formObj.attr("method", "post");
		formObj.submit();
	});
	$(".btn_list").click(function(){
		location.href="/f_board/f_list";

	}); 
	
	
	 //listReply("1"); // **댓글 목록 불러오기
     listReply2(); // ** json 리턴방식
     
     // ** 댓글 쓰기 버튼 클릭 이벤트 (ajax로 처리)
     $("#btnReply").click(function(){
         //reply(); // 폼데이터로 입력
         replyJson(); // json으로 입력
     });
     

});


 // ** 댓글 쓰기 (json방식)
 function replyJson(){
     var reply_content=$("#reply_content").val();
     var board_num="${F_BoardVO.f_board_num}";
     var f_num=$("#f_num").text();

     console.log("오잉이이이ㅣ이이이이");
     console.log($("#f_num").text());
     
/*      // ** 비밀댓글 체크여부
     var secretReply = "n";
     // 태그.is(":속성") 체크여부 true/false
     if( $("#secretReply").is(":checked") ){
         secretReply = "y";
     } */
     $.ajax({                
         type: "post",
         url: "/reply/insertRest.do",
         headers: {
             "Content-Type" : "application/json"
         },
         dateType: "text",
         // param형식보다 편하다.
         data: JSON.stringify({
        	 f_num : f_num,
             board_num : board_num,
             reply_content : reply_content,
         //    secretReply : secretReply
         }),
         success: function(){
             alert("댓글이 등록되었습니다.");
             listReply2();
            // listReply("1");
         }
     });
 }

     

 // RestController방식 (Json)
 // 댓글 목록2 (json)
 function listReply2(){
     $.ajax({
         type: "get",
         //contentType: "application/json", ==> 생략가능(RestController이기때문에 가능)
         url: "/reply/listJson.do?bno=${F_BoardVO.f_board_num}",
         success: function(result){
             console.log(result);
   	          
                 var output = "<table class='opinion_list'>";
                 for(var i in result){
                	 output += "<tbody class='replybody'>";
                     output += "<tr class='replyheader'>";
                     output += "<td class='replypic'></td>"
                     output += "<td class='replyname'><strong>"+result[i].f_id+"</strong></td>";
                     output += "<td class='replytime'>"+changeDate(result[i].reply_date)+"</td>";
                     output += "</tr>"
                     output += "<tr class='replycontent'>"
                     output += "<td class='replytext'>"+result[i].reply_content;+"</td>"
       					if($('#f_id').text() == result[i].f_id){
       						output += "<td class='replybuttons'>"
       						output += '<input type="button" id="btnModify" value="수정" onclick="showReplyModify('+result[i].reply_num+');">';
       	                	output += '<input type="button" id="btnReplyDelete" value="삭제" onclick="ReplyDelete('+result[i].reply_num+');">'; 
        	                output += "</td>";
        	            	output += "</tr>";
       					}else{
          	                 output += "</tr>";
       					} 
       					/* output += ""; */
                     output += "</tbody>";
                  }
             	     output += "</table>";
          	   $("#listReply").html(output);
         
         }
     })
 };

 
 function showReplyModify(num){
     $("#mynum").val(num);
	  $("#modifyReply").css("visibility", "visible");
 };
 
 function ReplyModify(num){
     var detailReplytext = $("#detailReplytext").val();
     console.log(num);
     $.ajax({
         type: "put",
         url: "/reply/update/"+num,
         // 기본값 text/html을 json으로 변경
         headers: {
             "Content-Type":"application/json"
         },
         // 데이터를 json형태로 변환
         data: JSON.stringify({
             reply_content : detailReplytext
         }),
         dataType: "text",
         success: function(result){
             if(result == "success"){
                 $("#modifyReply").css("visibility", "hidden");
                 alert("수정되었습니다.");
                 // 댓글 목록 갱신
                 listReply2();
             }
         }
     });
 }
  
function ReplyDelete(num){
	 if(confirm("삭제하시겠습니까?")){
	$.ajax({
        type: "delete",
        url: "/reply/delete/"+num,
        success: function(result){
            if(result == "success"){
                alert("삭제되었습니다.");
                $("#modifyReply").css("visibility", "hidden");
                listReply2();
            }
        }
    });
	 }
}



 // **날짜 변환 함수 작성
  function changeDate(reply_date){
	 console.log(reply_date);
     date = new Date(parseInt(reply_date));
     console.log(date);
     year = date.getFullYear();
     month = date.getMonth();
     day = date.getDate();
     hour = date.getHours();
     minute = date.getMinutes();
     strDate = year+"-"+month+"-"+day+" "+hour+":"+minute;
     return strDate;
  
 }

 
</script>
<style>
    #modifyReply {
        width: 600px;
        height: 130px;
        background-color: gray;
        padding: 10px;
        z-index: 10;
        visibility: hidden;
    }
</style>
</head>
<body>
 <%@include file="../c_common/header.jsp" %>
 <span id="f_id" style="display:none;">${client.f_id}</span>
 <span id="f_num" style="display:none;">${client.f_num}</span>
 
  <form role="form">
  	<input type='hidden' name='f_board_num' value="${F_BoardVO.f_board_num }">
  	 <input type='hidden' name='page' value="${cri.page}"> 
  	 <input type='hidden' name='perPageNum' value="${cri.perPageNum}">
     <input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

	<div id="conainer">
		<div id="nav">
			<div class="nav_txt">
				<p>
					<a href="/e_lan/index.php">Home</a> <span class="padd">&gt;</span>
					<span>프리랜서 자유게시판</span>
				</p>
			</div>
		</div>
		<div id="content">
			<div class="tit_box">
				<h2>프리랜서 자유게시판</h2>
				<p class="tit_txt">
					프리랜서들만의 공간!<span>궁금한 사항이 있다면 무엇이든 올려주세요.<br/>욕설과 비난은 자제해주세요. 서로를 존중해주는 우리는 드림랜서!</span>
				</p>
</div>

<!-- 				//market : e
				<div class="table_tit">

					<div class="fr">
						<p>
							<span class="txt_or">&nbsp</span>
						</p>
					</div>
				</div> -->

				<!-- //tb_box : e -->
				
				<div class="tb_box">
				<h1>&nbsp</h1>
					<table class="tb_st01">
						<caption></caption>
						<colgroup>
							<col style="width: 16%" />
							<col style="width: 16%" />
							<col style="width: 17%" />
							<col style="width: 17%" />
							<col style="width: 17%" />
							<col style="width: 17%" />

						</colgroup>
						<tbody>
							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">글번호</label></th>
								<td colspan="2">
								<input type="text" hidden name="f_board_num">&nbsp&nbsp${F_BoardVO.f_board_num}
								<!-- <input type="text" id="f_board_title" name="f_board_title" class="wid" />  -->
								</td>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">조회수</label></th>
								<td colspan="2">
								&nbsp&nbsp${F_BoardVO.f_board_hits}
								<!-- <input type="text" id="f_board_title" name="f_board_title" class="wid" /> -->
								</td>
							</tr>
							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">아이디</label></th>
								<td colspan="2">
								 &nbsp&nbsp${F_BoardVO.f_id} 
								<!-- <input type="text" id="f_id" name="f_id" class="wid" /> -->
								</td>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">등록일</label></th>
								<td colspan="2"><%-- 
								<c:out value="changeDate(${F_BoardVO.f_board_date });"></c:out> --%>
								&nbsp&nbsp${F_BoardVO.f_board_date }
								<!-- <input type="text" id="f_board_title" name="f_board_title" class="wid" /> -->
								</td> 
							</tr>
							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">제목</label></th>
								<td colspan="5">
								&nbsp&nbsp${F_BoardVO.f_board_title }
								<%-- <input type="text" id="f_board_title" name="f_board_title" class="wid" 
										readonly="readonly" value="${F_BoardVO.f_board_title }"/>  --%>
								</td>
							</tr>

							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="p_content">상세내용</label></th>
								<td colspan="5">
								
								<textarea id="f_board_content" name="f_board_content" class="txt_area" readonly="readonly" style="border:0">${F_BoardVO.f_board_content }</textarea>
                                </td>
							</tr>
							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="p_file">첨부파일</label></th>
								<td colspan="5">
								&nbsp사진~
									<!-- <div>
										<input type="file" id="f_file" name="f_file" class="wid">
									</div> -->
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="tit_box">
					<fieldset class="opinion_reg">
					 <ul class="condition">    </ul>
						<c:if test="${client.f_id != null}">
						<div class="myphoto">
							<img height="33" width="33" src="../../../resources/f_board_img/imggg.png">
						</div>
						<textarea class="dim ta taComment" id="reply_content" rows="5" cols="50" style="ime-mode:active;"></textarea>
						<input type="image" id="btnReply" class="input_btn registerComment btnArea" src="../../../resources/f_board_img/btn_reg_reply.gif">
						</c:if>
						
					</fieldset>
					<div id="listReply"></div>
<%-- 					<ul class="opinion_list">
						<li>
							<div class="thumb">
								<img height="33" width="33" src="../../../resources/f_board_img/imggg.png">
							</div>
							<div class="cont">
								<p class="id">
									<strong class="answer">${F_BoardVO.f_id} </strong>
										<div class="desc" id="listReply">내용</div>
								</p>
							</div>
							</li>
					</ul> --%>
				</div>

					<!-- 수정 댓글 목록 -->
 					<div id="modifyReply">
	<%-- 				댓글 번호 : ${F_ReplyVO.reply_num}<br>  --%>
					<form >
					<input type="hidden" id="mynum" name="reply_num">
				    <textarea id="detailReplytext" rows="5" cols="82"></textarea>
				    <div style="text-align: center;">
				        <!-- 본인 댓글만 수정, 삭제가 가능하도록 처리 -->
				         <button type="button" id="btnReplyUpdate" onclick="ReplyModify($('#mynum').val())">수정
				  </form>
				        <button type="button" id="btnReplyClose" >닫기</button>
				    </div>
					</div> 
					</div>
				
				<div class="btn_box">
				<c:if test="${client.f_id == F_BoardVO.f_id}">	
					<input type="submit" id="checkValue" class="btn_check04"  value="수정하기">
					<input type="submit" id="checkValue1" class="btn_remove"  value="     삭제하기">
				</c:if>
				<input type="button" id="checkValue2" class="btn_list"  value="목록으로">
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				</div>
			</div>
		</div>
</form>


<%@include file="../c_common/footer.jsp" %>

</body>


</html>
