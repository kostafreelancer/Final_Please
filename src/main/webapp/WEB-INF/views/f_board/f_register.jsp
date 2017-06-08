<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../../resources/f_board_css/join.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="../../../resources/f_board_css/reset.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="../c_common/header.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../c_common/footer.css" type="text/css"
	media="screen" />
<title>프리랜서 자유게시판</title>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
</head>
<body>
	<%@include file="../c_common/header.jsp"%>
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
				<h2>글쓰기</h2>
				<p class="tit_txt">
					프리랜서를 위한 공간입니다.<span>욕설과 비난은 자제해주세요.</span>
				</p>

				<!-- //market : e -->
				<div class="table_tit">

					<div class="fr">
						<p>
							<span class="txt_or">&nbsp</span>
						</p>
					</div>
				</div>

				<!-- //tb_box : e -->
				<div class="tb_box">
				<h1>&nbsp</h1>
					<table class="tb_st01">
						<caption></caption>
						<colgroup>
							<col style="width: 23%" />
							<col style="width: 25%" />
							<col style="width: 25%" />
							<col style="width: 27%" />

						</colgroup>
						<tbody>
							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="fm_name">제목</label></th>
								<td colspan="3">
								<input type="text" id="f_board_title" name="f_board_title" class="wid" />
								</td>
							</tr>

							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="p_content">상세내용</label></th>
								<td colspan="3">
								<textarea id="f_board_content" name="f_board_content" class="txt_area">
                                </textarea>
                                </td>
							</tr>
							<tr>
								<th scope="row" colspan="1" class="ac"><span class="txt_or"></span>
								<label for="p_file">첨부파일</label></th>
								<td colspan="3">
									<div>
										<input type="file" id="f_file" name="f_file" class="wid">
									</div>
								</td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="btn_box">
					<input type="submit" id="checkValue" class="btn_check04"  value="등록하기">
				</div>
			</div>
		</div>
		</form>
	</div>
	<%@include file="../c_common/footer.jsp"%>
</body>
</html>