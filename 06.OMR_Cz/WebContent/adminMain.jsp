<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
</head>
<body>
	<div align="center">
		<h3>관리자모드 메인</h3>
		<div class="btns">
			<input type="button" value="응시자 결과"
				onclick="location.href='admin_PassFail.jsp'" />
		</div>
		<div class="btns">
			<input type="button" value="응시자격 목록 수정"
				onclick="location.href='admin_Testers.jsp'" />
		</div>
		<div class="btns">
			<input type="button" value="처음으로"
				onclick="location.href='OmrMain.html'" />
		</div>
	</div>
</body>
</html>