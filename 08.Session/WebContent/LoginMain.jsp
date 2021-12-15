<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Main</title>
</head>
<body>
<div align="center">
<table border="1" style="width: 80%">
	<tr height="100">
		<td colspan="2">
			<!-- 페이지 상단 영역(LoginTop.jsp) -->
			<jsp:include page="LoginTop.jsp"/>
		</td>
	</tr>
	
	<tr>
		<td width="30%" align="center" valign="top" height="300">
			<!-- 페이지 왼쪽 영역(LoginLeft.jsp) -->
			<jsp:include page="LoginLeft.jsp"/>
		</td>
		<td align="center" valign="middle">
			<!-- Contente 영역 -->
			<h3>메인페이지 입니다.</h3>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<!-- 페이지 하단 영역(LoginBottom.jsp)-->
			<jsp:include page="LoginBottom.jsp"/>
		</td>
	</tr>	
</table>
</div>
</body>
</html>