<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
<script type="text/javascript" src="/resources/c_login_js/c_login.js"></script>
<script type="text/javascript">
/* 	var onloadCallback = function(){
		greCAPCHA.render('html_element', {
			'sitekey' : '6LfYlSYUAAAAAH7l4BXuLSs-t5VpAWhzylIBSu6j',
			'theme' : 'light'
		});
	}; */
</script>

<link rel="stylesheet" href="/resources/c_login_css/join.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/c_login_css/reset.css" type="text/css" media="screen" />


<%@include file="../c_common/header.jsp"%>
<%-- <%@include file="../c_chatting/chatting.html"%> --%>

<div id="conainer">
	<div id="nav">
		<div class="nav_txt">
			<p>
				<a href="/Matching_Project/f_main/f_main.jsp">Home</a> <span
					class="padd">&gt;</span> <span>로그인</span>
			</p>
		</div>
	</div>

	<div id="content">
		<div class="login_cont">
			<h2>
				LOGIN<span>DreamLancer 1TO1 로그인</span>
			</h2>
			<div class="log_box">
				<div class="log_lef">
				 <span id="checkEmailConfirm"></span>
				<form id="sleepMail" name="sleepMail" method="post" action="">
				<input type="hidden" name="sleepmail" value="${sleepemail}">
				</form>
					<p>로그인을 위해 아이디와 패스워드를 입력해 주세요.</p>
					<form method="post" name="MemberLoginFm" action="insert.c_login"
						class="c_login">
						<input type="hidden" name="emailConfirm" id="emailConfirm">
						<input type="hidden" name="fm_url" value=""> <input
							type="hidden" name="fm_str" value=""> <input
							type="hidden" class="checking_login"
							value="${msg}"> <label for="fm_id"
							class="tx_skip">아이디 입력</label>
						<div>
							<input type="text" id="fm_id" class="log_inp01" name="c_id" />
						</div>
						<div>
							<input type="password" id="fm_passwd" class="log_inp02"
								name="pwd" onKeyPress="javascript:LoginEnterCheck();" />
						</div>
						<label for="fm_passwd" class="tx_skip">비밀번호 입력</label>
						<div class="login_check">
							<p class="fl">
								<!--  <input type="checkbox" id="saveID" name="saveID" value="Y" checked="checked"/>
                                    <label for="saveID">로그인 상태유지</label><br> -->
								&nbsp; &nbsp; <input type="radio" name="checking"
									value="freelancer" checked="checked">프리랜서
								&nbsp;&nbsp; <input type="radio" name="checking"
									value="enterprise">기업
									&nbsp;&nbsp; <input type="radio" name="checking"
									value="admin">관리자

							</p>

							<a href="${pageContext.request.contextPath}/verification/verificationPop" onclick="window.open(this.href, '_blanck', 'width=620, height=270, top=100, left=100'); return false" class="pass_find">아이디 패스워드 찾기
								&gt;</a>
						</div>
						<!-- <div class="g-recaptcha" data-sitekey="6LfYlSYUAAAAAH7l4BXuLSs-t5VpAWhzylIBSu6j"></div> -->
						<br>
						<p>
							<!-- <a href="javascript:;" class="btn_login">로그인
                                	
                                </a>  -->
							<span class="btn_login">로그인</span>
							<!-- <input class = "login_submit" type="submit" value="로그인">  -->
							<a href=${pageContext.request.contextPath}"/c_join/c_join_step1"
								class="btn_join">회원가입</a>
						</p>
						   
					</form>
				</div>

			</div>
			<!-- log_box : e -->
		</div>
		<!-- login_cont : e -->
	</div>
</div>
<form method="post" name="HiddenFrame" style="display: inline;"
	onSubmit="return false;">
	<input type="hidden" name="fm_type" value=""> <input
		type="hidden" name="fm_format" value="">
</form>
<!-- container : e -->


</div>



</div>


</div>

<!--  <div id="message" style="color:#ff0000; "></div>
<div id="g-recaptcha"></div>
<input id="recaptchaCheck" type="button" value="Check"> -->

<!-- //wrap : e -->
<%@include file="../c_common/footer.jsp"%>
