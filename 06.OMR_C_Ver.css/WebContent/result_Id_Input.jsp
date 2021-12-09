<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div id="wrap" align="center">
		<div class="main">
			<h3>결과를 확인할 수험번호입력창</h3>
			<form action="result.jsp" method="post" onsubmit="return fnSubmit()"
				onreset="return fnReset()">
				<table border="1">
					<tr>
						<td><label>수험번호</label></td>
						<td><input type="text" name="id" required="required" /></td>
						<td rowspan="2"><input type="submit" value="결과조회" /></td>

					</tr>
					<tr>
						<td><label>성명</label></td>
						<td><input type="text" name="name" required="required" /></td>
					</tr>


				</table>
				<div class="btns">
					<input type="button" value="처음으로"
						onclick="location.href='OmrMain.html'" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>