<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../c_common/header.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../c_common/footer.css" type="text/css" media="screen" />
<title>Insert title here</title>

</head>
 <%@include file="../c_common/header.jsp" %>
<body>
    <table style="width:700px">
        <c:forEach var="row" items="${list}">
        <tr>    
            <td>
                ${row.f_num}(<fmt:formatDate value="${row.reply_date}" pattern="yyyy-MM-dd HH:mm:ss"/>)
                <br>
                ${row.reply_content}
            </td>
        </tr>
        </c:forEach>
    </table>
    
    <%@include file="../c_common/footer.jsp" %>
</body>
</html>
