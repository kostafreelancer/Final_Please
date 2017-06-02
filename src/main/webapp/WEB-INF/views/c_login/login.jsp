<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/resources/c_login_js/c_login.js"></script>
<link rel="stylesheet" href="/resources/c_login_css/join.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/c_login_css/reset.css" type="text/css" media="screen" />

<%@include file="../c_common/header.jsp"%>
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
					<p>로그인을 위해 아이디와 패스워드를 입력해 주세요.</p>
					<form method="post" name="MemberLoginFm" action="insert.c_login"
						class="c_login">
						<input type="hidden" name="fm_url" value=""> <input
							type="hidden" name="fm_str" value=""> <input
							type="hidden" class="checking_login"
							value="${identity.identity }"> <label for="fm_id"
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
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="checking"
									value="enterprise">기업

							</p>

							<a href="javascript:FindID();" class="pass_find">아이디 패스워드 찾기
								&gt;</a>
						</div>
						<p>
							<!-- <a href="javascript:;" class="btn_login">로그인
                                	
                                </a>  -->
							<span class="btn_login">로그인</span>
							<!-- <input class = "login_submit" type="submit" value="로그인">  -->
							<a href="/Matching_Project/c_join/c_join_step1.jsp"
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
<!-- //wrap : e -->
<%@include file="../c_common/footer.jsp"%>
