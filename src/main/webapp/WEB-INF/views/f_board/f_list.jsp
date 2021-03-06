<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../../resources/f_board_css/join.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../../../resources/f_board_css/reset.css" type="text/css"
	media="screen" />
<title>프리랜서 자유게시판</title>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<style type="text/css">
#checkValue{
float: right;
}
</style>
<script type="text/javascript">
	var result='${msg}';
	if(result=='SUCCESS'){
		alert("처리가 완료되었습니다.");
	}
	
	$(document).ready(function(){

		$('.btn_check04').click(function(){
			location.href="/f_board/f_register";
		})

	});

</script>
</head>
<body>
 <%@include file="../c_common/header.jsp" %>

     <div  id="conainer">
    	<div id="nav">
        	<div class="nav_txt">
            	<p>
                	<a href="/index.php">Home</a>
                    <span class="padd">&gt;</span> 
                	<span>프리랜서 자유게시판</span>
            	</p>
            </div>
        </div>
        <div id="content">
        	<div class="tit_box">
            	<h2>프리랜서 자유게시판</h2>
                <p class="tit_txt">프리랜서들만의 공간!<span>궁금한 사항이 있다면 무엇이든 올려주세요.<br/>욕설과 비난은 자제해주세요. 서로를 존중해주는 우리는 드림랜서!</span></p>
            </div>
            <!-- //tit_box : e -->
            <form role="form">
            <dl  class="tab_d02">
                <dd>
                	<div class="tb_box" style="margin-top:15px; margin-left: 1px;">
                        <table class="tb_st05">
                            <caption>공지사항 : 번호, 제목, 등록일, 조회로 구성된 표</caption>
                            <colgroup>
                                <col style="width:10%" />
                                <col style="width:*" />
                                <col style="width:17%" />
                                <col style="width:17%" />
                                <col style="width:15%" />
                            </colgroup>
                            <thead>
                            	<tr>
                                	<th scope="col">번호</th>
                                    <th scope="col">제목</th>
                                    <th scope="col">글쓴이</th>
                                    <th scope="col">등록일</th>
                                    <th scope="col">조회</th>
                                </tr>
                            </thead>
                            
                     <c:forEach items="${list}" var="F_BoardVO">
                         <tbody>
							<tr>
							<td>${F_BoardVO.f_board_num }</td>
								<td class="al">&nbsp;&nbsp;&nbsp;
								<a href='/f_board/f_readPage${pageMaker.makeSearch(pageMaker.cri.page) }&f_board_num=${F_BoardVO.f_board_num}' class="SOLU_green">
								${F_BoardVO.f_board_title}<strong>&nbsp&nbsp[ ${F_BoardVO.f_reply_count} ]</strong></a></td>
								<td>${F_BoardVO.f_id}</td>
								<td><fmt:formatDate pattern="yyy-MM-dd HH:mm" value="${F_BoardVO.f_board_date }"/></td>
								<td>${F_BoardVO.f_board_hits }</td>
						</tr>
                            </tbody>
                            </c:forEach>
                        </table>
                       
                    </div>
                    

                  	
                  	<div class="box-footer">
                  	
           
                  	<div class="num_box">
                  	<c:choose>
								<c:when test="${pageMaker.prev}">
									<a href="f_list${pageMaker.makeSearch(pageMaker.startPage - 1) }" class="first"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="first"></a>
								</c:otherwise>
							</c:choose>
						
								
										<c:forEach begin="${pageMaker.startPage }"
											end="${pageMaker.endPage }" var="idx">
											<span
											<c:out value="${pageMaker.cri.page == idx?'class=on':''}"/>>
												<a href="f_list${pageMaker.makeSearch(idx)}">${idx}</a>
											</span>
										</c:forEach>
										
										
							<c:choose>
								<c:when test="${pageMaker.next && pageMaker.endPage > 0}">
									<a href="f_list${pageMaker.makeSearch(pageMaker.endPage +1) }" class="last"></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="last"></a>
								</c:otherwise>
							</c:choose>
							
							
										
										
								<br>
								<br>
								<br>
								
									</div>
								<c:if test="${client.f_id != null}">	
								<input type="button" id="checkValue" class="btn_check04"  value="작성하기">
								</c:if>
								<br><br><br><br><br><br>
								<br>
								<br>
		</div>


                </dd>
			</dl>
            </div>  
    
 

 </div>
<%@include file="../c_common/footer.jsp" %>
</body>
</html>