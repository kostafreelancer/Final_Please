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
<link rel="stylesheet" href="../c_common/header.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../c_common/footer.css" type="text/css" media="screen" />
<title>프리랜서 자유게시판</title>
 <script src="../../../resources/f_board_js/jquery-1.3.2.js"></script> 
 <script type="text/javascript">
$(document).ready(function(){
	var formObj = $("form[role='form']");
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
});
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
