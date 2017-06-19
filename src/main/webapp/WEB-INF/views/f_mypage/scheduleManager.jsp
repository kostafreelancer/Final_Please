<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../c_common/header.jsp" flush="true"/> 

<%-- <jsp:include page="../c_common/footer.jsp" flush="false"/> --%>
<%-- <jsp:include page="../c_common/footer.jsp" flush="true"/>  --%>
<%-- <jsp:include page="../c_common/footer.jsp"> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일정관리</title>
<!-- 
<link rel="stylesheet" href="../common/header.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../common/footer.css" type="text/css" media="screen" /> -->
<%-- <link rel="stylesheet" href="f_mypage_css/scheduleManager.css" type="text/css" media="screen" />
<link rel="stylesheet" href="f_mypage_css/fullcalendar.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/f_mypage/f_mypage_css/scheduleManager.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/f_mypage/f_mypage_css/fullcalendar.css" type="text/css" media="screen" /> --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/f_mypage_css/fullcalendar.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/f_mypage_css/scheduleManager.css"
	type="text/css" media="screen" />
<!-- <script  src="http://code.jquery.com/jquery-latest.min.js"></script> -->

<script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/fullcalendar/jquery.js"></script> 
<script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/fullcalendar/jquery-ui-custom.js"></script>
<!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.min.js"></script> -->
<%-- <script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/fullcalendar/fullcalendar.min.js"></script>
  --%>
 <script src="${pageContext.request.contextPath}/resources/f_mypage_js/fullcalendar/fullcalendar.min.js"></script>
 <script
	src="${pageContext.request.contextPath}/resources/f_mypage_js/fullcalendar/ko.js"></script>

<script type="text/javascript">

var newJquery = jQuery.noConflict(true);
//망했네망했어

newJquery(document).ready(function() {
//$(document).ready(function() {
	
	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();
/* 	
	var arrContents= new Array();
	var arrStart= new Array();
	var arrEnd= new Array();
	
	<c:forEach var="item" items="${scheduleList}">
		arrContents.push("${item.contents}");
		arrStart.push("${item.startdate}");
		arrEnd.push("${item.enddate}");
	</c:forEach> */

	
	
	  newJquery('#calendar').fullCalendar({
	//$('#calendar').fullCalendar({	    
		   header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
			editable: true,
			events : function(start, end, callback) {
				$.ajax({
				url : "scheduleInfoAjax",
				type : "get",
				data : {num : $('#clientnum').val()},
				dataType : 'json',
				success : function(data){
					/* $.each(responseData, function(index, scheduleList){
						$('#resultPrint').val = scheduleList.contents;	
					})
					 */
			        callback(data);
				}
				})
			},
		 	eventDrop: function(event, delta, revertFunc) {

		        alert(event.title + " was dropped on " + event.start);
				var start = event.start;
				var smonth = start.getMonth()+1;
				var end = event.end;
				var emonth = end.getMonth()+1;

		            $.ajax({
						url : "scheduleModify",
						type : "get",
						data : "title="+event.title+"&syear="+event.start.getFullYear()+
						"&smonth="+smonth+"&sdate="+event.start.getDate()+
						"&eyear="+event.end.getFullYear()+"&emonth="+emonth+
						"&edate="+event.end.getDate() + "&f_num=" + ${client.f_num},
						//dataType : 'json',
						success : function(){
							/* $.each(responseData, function(index, scheduleList){
								$('#resultPrint').val = scheduleList.contents;	
							})
							 */
							console.log("성공");
				            //revertFunc();
						}
						});

		    },  
		    
		    eventClick: function(event) {
		    	
		    		$.ajax({
						url : "scheduleDelete",
						type : "get",
						data : "title="+event.title+ "&f_num=" +${client.f_num},
						//dataType : 'json',
						success : function(){
							  newJquery('#calendar').fullCalendar('removeEvents' , function(ev){  
								    return (ev._id == event._id);
							  });
						}
					});
		   
		    },
		    dayClick: function() {
		    	window.open('/f_mypage/scheduleAdd','win','width=350, height=250');
		    }
			/* events: [
				{
					title: 'All메롱 Event',
					start: new Date(y, m, 1)
				},
				{
					title: 'Long Event',
					start: new Date(y, m, d-5),
					end: new Date(y, m, d-2)
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: new Date(y, m, d-3, 16, 0),
					allDay: false
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: new Date(y, m, d+4, 16, 0),
					allDay: false
				},
				{
					title: 'Meeting',
					start: new Date(y, m, d, 10, 30),
					allDay: false
				},
				{
					title: 'Lunch',
					start: new Date(y, m, d, 12, 0),
					end: new Date(y, m, d, 14, 0),
					allDay: false
				},
				{
					title: 'Birthday Party',
					start: new Date(y, m, d+1, 19, 0),
					end: new Date(y, m, d+1, 22, 30),
					allDay: false
				},
				{
					title: 'Click for Google',
					start: new Date(y, m, 28),
					end: new Date(y, m, 29),
					url: 'http://google.com/'
				}
			] */
			 
	    });
	
});	
 
function addScheduleSubmit(){
	document.scheduleAdd.submit();
}

</script>

<style type='text/css'>
/* body {
	margin-top: 40px;
	text-align: center;
	font-size: 14px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
} */

#calendar {
	width: 900px;
	margin: 0 auto;
}
</style>
</head>
<body>



	<div class="left_menu">
		<div class="left_menu_title">
			<h2>마이 페이지</h2>
		</div>
		<div class="left_menu_content">
			<ul class="left_menu_contents">
				<li><a href="/f_mypage/scheduleManager">일정 관리</a></li>
				<li><a href="/f_mypage/accountingManager">회계 관리</a></li>
				<li><a href="/f_mypage/myInfo">내 정보</a></li>
			</ul>
		</div>
	</div>

	<section id="firstsection">
	<div id="calendar"></div>
	<input type="text" hidden id="clientnum" name="clientnum"
		value="${client.f_num}">
	<div id="list">
		<table border="1px solid" cellpadding="0" cellspacing="0">
			<tr>
				<td>${proName}</td>
			</tr>
			<c:forEach var="schedule" items="${scheduleList}" varStatus="status">
				<%-- <input type="text" hidden name="calendar_num" value="${status.index+1}"> --%>
				<tr>
					<td><input type="text" hidden id="sch_num"
						name="calendar_num${status.index+1}">${schedule.contents}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="space"></div>
	<input type="text" id="resultPrint" value="">
	<ul>
		<li><span id="firstSch">첫번</span></li>
		<li><span id="secondSch">두번째</span></li>
		<li><span id="thirdSch">메롱</span></li>
	</ul>

	<form name="scheduleAdd" action="/f_mypage/scheduleAdd" method="post">
		<input type="text" hidden name="f_num" value="${client.f_num}">
		<input type="text" hidden name="contents"> 
		<input type="text" hidden name="startdate"> 
		<input type="text" hidden name="enddate">
	</form>


	</section>
	<%@include file="myfooter.jsp"%>
</body>
<script type="text/javascript">

/*  	 $.ajax({
	url : "scheduleInfoAjax.f_mypage",
	type : "get",
	data : {num : $('#clientnum').val()},
	dataType : 'json',
	success : function(responseData){
		 $.each(responseData, function(index, scheduleList){
			$('#resultPrint').val = scheduleList.contents;	
		})
		 
		$('#resultPrint').val = responseData;
	}
})   */
</script>
</html>
