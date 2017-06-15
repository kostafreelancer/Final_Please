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
	
	//console.log(formObj);

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
		
		/* formObj.attr("method", "get"); */
/* 		formObj.submit(); */
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
     var board_content=$("#board_content").val();
     var board_num="${F_BoardVO.f_board_num}"
     // ** 비밀댓글 체크여부
     var secretReply = "n";
     // 태그.is(":속성") 체크여부 true/false
     if( $("#secretReply").is(":checked") ){
         secretReply = "y";
     }
     $.ajax({                
         type: "post",
         url: "/reply/insertRest.do",
         headers: {
             "Content-Type" : "application/json"
         },
         dateType: "text",
         // param형식보다 편하다.
         data: JSON.stringify({
             board_num : board_num,
             reply_content : reply_content,
             secretReply : secretReply
         }),
         success: function(){
             alert("댓글이 등록되었습니다.");
             listReply2();
            // listReply("1");
         }
     });
 }
     
 // 댓글 쓰기(폼데이터 방식)
 function reply(){
     var reply_content=$("#reply_content").val();
     var board_num="${F_BoardVO.f_board_num}"
/*      // 비밀댓글 체크여부
     var secretReply = "n";
     // 태그.is(":속성") 체크여부 true/false
     if( $("#secretReply").is(":checked") ){
         secretReply = "y";
     }
     //alert(secretReply); */
     // 비밀댓글 파라미터 추가
     var param="reply_content="+reply_content+"&board_num="+board_num+"&";
     $.ajax({                
         type: "post",
         url: "/reply/insert.do",
         data: param,
         success: function(){
             alert("댓글이 등록되었습니다.");
             listReply2();
             //listReply("1");
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
             var output = "<table>";
             for(var i in result){
                 output += "<tr>";
                 /* output += "<td>"+result[i].f_num; */
                 output += "("+changeDate(result[i].reply_date)+")<br>";
                 output += result[i].reply_content+"</td>";
                 output += "<tr>";
             }
             output += "</table>";
             $("#listReply").html(output);
         }
     });
 }
 // **날짜 변환 함수 작성
 function changeDate(date){
     date = new Date(parseInt(date));
     year = date.getFullYear();
     month = date.getMonth();
     day = date.getDate();
     hour = date.getHours();
     minute = date.getMinutes();
     second = date.getSeconds();
     strDate = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
     return strDate;
 }

</script>
</head>
<body>
 <%@include file="../c_common/header.jsp" %>
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
								<input type="text" hidden name="f_board_num">${F_BoardVO.f_board_num}
								<!-- <input type="text" id="f_board_title" name="f_board_title" class="wid" />  -->
								</td>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">조회수</label></th>
								<td colspan="2">
								${F_BoardVO.f_board_hits}
								<!-- <input type="text" id="f_board_title" name="f_board_title" class="wid" /> -->
								</td>
							</tr>
							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">아이디</label></th>
								<td colspan="2">
								 ${F_BoardVO.f_id} 
								<!-- <input type="text" id="f_id" name="f_id" class="wid" /> -->
								</td>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">등록일</label></th>
								<td colspan="2">
								${F_BoardVO.f_board_date }
								<!-- <input type="text" id="f_board_title" name="f_board_title" class="wid" /> -->
								</td> 
							</tr>
							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">제목</label></th>
								<td colspan="5">
								${F_BoardVO.f_board_title }
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
								사진~
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
						<div class="myphoto">
							<img height="33" width="33" src="../../../resources/f_board_img/imggg.png">
						</div>
						<textarea class="dim ta taComment" id="commentText" rows="5" cols="50" style="ime-mode:active;"></textarea>
						<input type="image" class="input_btn registerComment btnArea" src="../../../resources/f_board_img/btn_reg_reply.gif">
					</fieldset>
					<ul class="opinion_list">
						<li>
							<div class="thumb">
								<img height="33" width="33" src="../../../resources/f_board_img/imggg.png">
							</div>
							<div class="cont">
								<p class="id">
									<strong class="answer">${F_BoardVO.f_id} </strong>
										<p class="desc">내용</p>
								</p>
							</div>
							</li>
					</ul>
				</div>
				
				
    <div style="width:650px; text-align: center;">
        <br>
        <!-- 로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
       <%--  <c:if test="${sessionScope.userId != null}">     --%>
        <textarea rows="5" cols="80" id="reply_content" placeholder="댓글을 작성해주세요"></textarea>
        <br>
        <!-- **비밀댓글 체크박스 -->
        <!-- <input type="checkbox" id="secretReply">비밀 댓글 -->
        <button type="button" id="btnReply">댓글 작성</button>
    <%--     </c:if> --%>
    <hr>
    </div>
    <!-- **댓글 목록 출력할 위치 -->
    <div id="listReply">
    adssd
    </div>
					

				
				
				
				
					</div>
				
				<div class="btn_box">
					<input type="submit" id="checkValue" class="btn_check04"  value="수정하기">
					<input type="submit" id="checkValue1" class="btn_remove"  value="     삭제하기">
					<input type="button" id="checkValue2" class="btn_list"  value="목록으로">
				</div>
			</div>
		</div>
</form>


<%@include file="../c_common/footer.jsp" %>

</body>


</html>
