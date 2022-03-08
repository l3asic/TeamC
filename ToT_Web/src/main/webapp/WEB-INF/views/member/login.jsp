<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#login { 
	width: 100%; 
	padding: 50px 0; 
	float: left; 
	background: #BDEDFF;
	text-align: center;
}
img.social { width : 200px; height: 45px; }
#userid, #userpw { width: 48%; height:45px; padding: 5px 10%; margin-bottom: 10px;}
</style>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>

<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<!-- <h3>로그인 페이지</h3> -->
<div style="width: 700px; border: 1px solid #ccc;" class='center'>
	<div id='login'>
		<div style='height: 70px;'>
			<a href='<c:url value="home" />'><img src="images/logo_60.png"></a>
		</div>
		<div>
			<input type="text" placeholder="아이디" id='userid' autofocus /><br/>
			<input type="password" placeholder="비밀번호" id='userpw'
					onkeypress="if (event.keyCode == 13) { go_login() }" />
		</div>
			<a style="width: 25%" class='btn btn-outline-primary' onclick="go_login()">로 그 인</a>
		<div >
			<a href="findid">아이디 찾기 |</a>
			<a href="findpw">비밀번호 찾기</a>
		</div>	
		<div>
			<div style="width: 80%; margin: 25px auto; border: 1px solid #ccc"></div>
			<a href='naverLogin'><img src='images/naver_login.png' class='social' /></a>
			<a href='kakaoLogin'><img src='images/kakao_login.png' class='social' /></a>
			
		</div>
	</div>
</div>

<script type="text/javascript">
function go_login() {
	if($('#userid').val() == '') { // 아이디 입력값이 없으면
		alert('아이디를 입력하세요!');
		$('#userid').focus();
		return;
	} else if ($('#userpw').val() == '') { // 비밀번호 입력값이 없으면
		alert('비밀번호를 입력하세요!');
		$('#userpw').focus();
		return;
	}
	
	$.ajax({
		url : 'ToTLogin'
		, data : {member_id:$('#userid').val(), member_pw:$('#userpw').val()}
		, success: function( response ) {
			if (response) {
				location = '<c:url value="home" />';
			} else {
				alert('아이디나 비밀번호가 일치하지 않습니다.');
			}
		}, error : function (req, text) {
			alert(text + ':' + req.status);
		}
	});
	
}

</script>

</body>
</html>