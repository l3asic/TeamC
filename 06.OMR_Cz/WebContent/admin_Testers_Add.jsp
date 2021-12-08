<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div id="wrap" align="center">
		<div class="main">
			<h3>추가 응시자 인적사항 입력 화면</h3>
			<h3>ㅁㅁㅁㅁㅁ</h3>
			<form action="admin_Testers_Add_Action.jsp" method="post"
				onsubmit="return fnSubmit()" onreset="return fnReset()">
				<table border="1">
					<tr>
						<td><label>추가할 수험번호</label></td>
						<td><input type="text" name="id" required="required" /></td>
					</tr>
					<tr>
						<td><label>추가할 성명</label></td>
						<td><input type="text" name="name" required="required" /></td>
					</tr>

				</table>
				<div class="btns">
					<input type="submit" value="수험번호 db에 추가" /> <input type="reset"
						value="초기화하기" />
				</div>
				<div class="btns">
					<input type="button" value="뒤로가기 (응시자목록 조회)"
						onclick="location.href='admin_Testers.jsp'" /> <input
						type="button" value="관리자메인으로"
						onclick="location.href='adminMain.jsp'" />
				</div>
			</form>
		</div>
	</div>


</body>
</html>