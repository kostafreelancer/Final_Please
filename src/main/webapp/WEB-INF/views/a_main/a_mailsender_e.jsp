<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet"
	href="../../../resources/membercenter_css/center_css.css">
	<script type="text/javascript" src="/resources/a_main_js/a_main.js"></script>

<title>Insert title here</title>
</head>
<body>

<br><br>

<div class="tit_box">
			<h2>회원 메일보내기</h2>
			<p class="tit_txt">
				회원에게 메일을 발송할 수 있습니다. <span>제목과 내용을 작성 한 후 메일발송 버튼을 누르면 메일이 전송됩니다.<br />
					
				</span>
			</p>
		</div>
					<form action="/a_main/a_mailsenderSubmit" method="POST">
					<table class="email_table">
						<colgroup>
							<col style="width: 15%">
							<col style="width: 35%">
							<col style="width: 15%">
							<col style="width: 35%">
						</colgroup>
						<tbody>
							
							<tr>
								<th scope="row"><span class="text_star">*</span> <label
									for="q_name">작성자</label></th>
								<td colspan="3" class="join">
								
								<input type="text"
									id="fm_name" name="writer" class="wid02"
									value="${enterprise.e_name }">
								
								</td>
							</tr>
							<tr>
								<th scope="row"><span class="text_star">*</span> <label
									for="fm_phone">연락처</label></th>
								<td colspan="3" class="join"><input type="text"
									id="fm_phone" name="fm_phone" class="wid02"
									value="">
								</td>
							</tr>
							<tr>
								<th scope="row"><span class="text_star">*</span> 이메일</th>
								<td colspan="3"><label for></label> 
								 <input type="text" name="tomail" id="fm_email_1" name="fm_email_1" class="wid04"
									value="${enterprise.e_mail}">
								

								</td>
							</tr>
							<tr>
								<th scope="row"><span class="text_star">*</span> 제목</th>
								<td colspan="3" class="join"><input type="text"
									id="title" name="title" class="wid"></td>
							</tr>
							<tr>
								<th scope="row"><span class="text_star">*</span> 내용</th>
								<td colspan="3" class="join"><textarea id="content"
										name="content" class="text_area text_area2">
      					</textarea>
      				<%-- 	<input type="hidden" name="f_num" value=<c:choose>
									<c:when test="${identity.identity == 'freelancer' }">
										${client.f_num }
									</c:when>
									<c:when test="${indentity.identity == 'enterprise' }">
										${client.e_num }
									</c:when>
									
								</c:choose>>
      					<input type="hidden" name="e_num" value=""> --%>
      					<!-- <input type="hidden" name="asknum" value="1">
      					<input type="hidden" name="askdate" value="sysdate"> -->
      					
      					</td>
							</tr>

						</tbody>
					</table>
					<p class="email_send">
							<!-- <a href="#" class="email_btn">작성완료</a> -->
							<input type="submit" value="메일발송" class="btn" id="doAsk">
							

						</p>
					</form>
</body>
</html>