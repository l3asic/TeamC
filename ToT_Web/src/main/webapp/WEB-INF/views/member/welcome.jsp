<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome ToT</title>
<style type="text/css">
.center { 
	position: absolute; 
	left:10%; 
	top: 25%;
	
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div >
		<h3 style="text-align: center; font-size: 50px; margin-top: 20px;">
			 Trip Or Travel에 오신것을 <br/>환영합니다!</h3>
			<div style="text-align: center; margin-top: 10px">
				<a class='btn btn-outline-primary' href='login' >로그인 하러가기</a>
				<a class='btn btn-outline-warning' href='home' >메인으로 돌아가기</a>
			</div>
	</div>
	<div>
		<img class="center" alt="welcome" src="images/welcome.png">	
	</div>
	
</body>
</html>