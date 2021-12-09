<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <script type="text/javascript">

fnSubmit(String adminPw){
	if(adminPw == "9999"){
		alert("관리자로그인성공");
		return true;
		
		
	}else{
		alert("관리자로그인실패");
		return false;
	}
	return false;
}

</script> -->
</head>
<body>
	<div id="wrap">
		<div class="main">
			<h3>404</h3>
			<h3>404</h3>
			<h3>404</h3>
			<h3>404</h3>
			<h3>404</h3>
			<form action="adminMain.jsp" method="post"
				onsubmit="return fnSubmit(adminPw)">
				<div>
					<label>삭제된 페이지 입니다.</label> <input type="password"
						name="adminPw" required="required" />
				</div>


				<div class="btns">
					<input type="submit" value="관리자 로그인" />
				</div>
				<div class="btns">
					<input type="button" value="처음으로"
						onclick="location.href='OmrMain.html'" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>