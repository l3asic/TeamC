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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<style type="text/css">
table, th, td {
	border-collapse: collapse;
	border: 1px solid #333;
}

input {
	outline: none;
}

body {
	background-color: #F3E7E7;
}

.main {
	margin-top: 10%;
}
</style>
</head>
<body>


	<div id="wrap" align="center">
		<div class="main">
			<h3>응시자격 추가</h3>
			<form action="admin_Testers_Add_Action.jsp" method="post"
				onsubmit="return fnSubmit()" onreset="return fnReset()">
				<table border="1">
					<tr>
						<td><label>수험번호</label></td>
						<td><input type="text" name="id" required="required" /></td>
					</tr>
					<tr>
						<td><label>성명</label></td>
						<td><input type="text" name="name" required="required" /></td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input
							class="btn btn-outline-warning btn-sm" type="submit"
							value="응시자 추가" /> <input class="btn btn-outline-info btn-sm"
							type="button" value="응시자목록 조회"
							onclick="location.href='admin_Testers.jsp'" /> <input
							class="btn btn-outline-success btn-sm" type="button"
							value="관리자메인" onclick="location.href='adminMain.jsp'" /></td>
					</tr>
				</table>

			</form>
		</div>
	</div>


</body>
</html>