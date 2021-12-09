<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<style type="text/css">
body {
	background-color: #F3E7E7;
	display: flex;
	justify-content: center;
}

.omr {
	position: fixed;
	letter-spacing: 5px;
}
.check {
	background-color: #009900;
}
.btns {
	
	display: flex;
	justify-content: space-around;
}
.main {
	margin-top: 20%;
}
</style>
</head>
<body>
	<div class="main" align="center">
		<h3>관리자모드</h3>
		<h3></h3>
		<h3></h3>
		<div class="btns">
			<input class="btn btn-outline-success btn-sm" type="button" value="응시자 시험결과"
				onclick="location.href='admin_Select.jsp'" />
		</div>
		<div class="btns">
			<input class="btn btn-outline-primary btn-sm"type="button" value="응시자격 목록"
				onclick="location.href='admin_Testers.jsp'" />
		</div>
		<div class="btns">
			<input class="btn btn-outline-info btn-sm" type="button" value="처음으로"
				onclick="location.href='OmrMain.html'" />
		</div>
	</div>
</body>
</html>