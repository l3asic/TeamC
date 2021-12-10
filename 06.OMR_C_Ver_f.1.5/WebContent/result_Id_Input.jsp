<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	text-align: "center";
}

input {
	outline: none;
}

body {
	background-color: #F3E7E7;
}

.ans {
	background-color: #00ff00;
	text-color: #ffffff;
}

.main {
	margin-top: 10%;
}
</style>
</head>
<body>


	<div id="wrap" align="center">
		<div class="main">
			<h3>내 시험 결과 조회</h3>
			</br>
			<form action="result.jsp" method="post" onsubmit="return fnSubmit()"
				onreset="return fnReset()">
				<table border="1">
					<tr>
						<td><label>수험번호</label></td>
						<td><input type="text" name="id" required="required" /></td>
					</tr>
					<tr>
						<td><label>성명</label></td>
						<td><input type="text" name="name" required="required" /></td>
					</tr>
					<tr class="btns" align="center">
						<td><input class="btn btn-outline-info btn-sm" type="button"
							value="처음으로" onclick="location.href='OmrMain.html'" /></td>
						<td rowspan="2"><input class="btn btn-outline-success btn-sm"
							type="submit" value="결과조회" /></td>
					</tr>

				</table>

			</form>
		</div>
	</div>
</body>
</html>