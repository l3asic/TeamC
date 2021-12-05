<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP16</title>
<script type="text/javascript">
function fnTime(){
	var date = new Date();
	//alert(date);
	//Mon Nov 22 2021 16:05:11 GMT+0900 (한국 표준시) → 오후 4시 05분 11초
	
	var hour = date.getHours();		//현재 시각의 시 : 16
	var minute = date.getMinutes();	//현재 시각의 분 : 5
	var second = date.getSeconds();	//현재 시각의 초 : 11
	//alert("시 : " + hour + "\n분 : " + minute + "\n초 : " + second);
	
	var setTime = hour >= 12 ? "오후 " : "오전 ";
	setTime += (hour > 12 ? hour - 12 : hour) + "시 ";
	setTime += (minute < 10 ? "0" + minute : minute) + "분 ";
	setTime += (second < 10 ? "0" + second : second) + "초";
	//alert(setTime);
	
	document.getElementById("time").innerHTML = setTime;
	setTimeout("fnTime()", 1000);
}
</script>
</head>
<body onload="fnTime()">
<div align="center" id="time">현재시간</div>
<div align="center">
<table border="1">
	<tr align="center">
		<td colspan="2" height="150">회사로고/네비게이션 메뉴</td>
	</tr>
	<tr align="center">
		<td height="300">로그인이 들어갈 부분</td>
		<td>본문영역(Content)이 들어갈 부분</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<!-- 날짜와 시간정보가 들어갈 부분(jsp15.jsp) -->
			<%@ include file="jsp15.jsp" %>
			<br/>
			<jsp:include page="jsp15.jsp"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>