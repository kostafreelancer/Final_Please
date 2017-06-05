<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>


</head>
<body>

<%@include file="../c_common/header_enterprise.jsp"%>
<section>

<table border="1">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>생년월일</th>
		<th>핸드폰</th>
		<th>이메일</th>
		<th>주소</th>
		<th>분야</th>
		<th>상태</th>
		<th>최근접속일</th>
		<th>-</th>
	</tr>

	<c:forEach var="f" items="${listFreelancer }">
		<tr>
			<td>${f.f_id }</td>
			<td>${f.f_name }</td>
			<td>${f.f_birth }</td>
			<td>${f.f_hphone }</td>
			<td>${f.f_email }</td>
			<td>${f.f_address }</td>
			<td>${f.f_major }</td>
			<td>${f.f_nowstate }</td>
			<td>${f.f_recentlogin }</td>
			<td><button>메일 발송</button><button>계정 삭제</button></td>
		</tr>
	</c:forEach>
</table>

<table border="1">
	<tr>
		<th>아이디</th>
		<th>가입자명</th>
		<th>기업명</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>주소</th>
		<th>규모</th>
		<th>사업자등록번호</th>
		<th>사업자등록증</th>
		<th>승인여부</th>
		<th>-</th>
	</tr>

	<c:forEach var="e" items="${listEnterprise }">
		<tr>
			<td>${e.e_id}</td>
			<td>${e.e_name}</td>
			<td>${e.e_ename}</td>
			<td>${e.e_phone}</td>
			<td>${e.e_mail}</td>
			<td>${e.e_address}</td>
			<td>${e.e_scale}</td>
			<td>${e.e_regno}</td>
			<td>${e.e_licensefile}</td>
			<td>${e.e_check}</td>
			<td><button>메일 발송</button><button>계정 삭제</button></td>
		</tr>
	</c:forEach>
</table>

<table border="1">
	<tr>
		<th>아이디</th>
		<th>가입자명</th>
		<th>기업명</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>주소</th>
		<th>규모</th>
		<th>사업자등록번호</th>
		<th>사업자등록증</th>
		<th>승인여부</th>
		<th>-</th>
	</tr>

	<c:forEach var="ep" items="${listEnterprisePermit }">
		<tr>
			<td>${ep.e_id}</td>
			<td>${ep.e_name}</td>
			<td>${ep.e_ename}</td>
			<td>${ep.e_phone}</td>
			<td>${ep.e_mail}</td>
			<td>${ep.e_address}</td>
			<td>${ep.e_scale}</td>
			<td>${ep.e_regno}</td>
			<td>${ep.e_licensefile}</td>
			<td>${ep.e_check}</td>
			<td><button>메일 발송</button><button>가입 승인</button></td>
		</tr>
	</c:forEach>
</table>


</section>

<%@include file="../c_common/footer.jsp"%>
</body>
</html>