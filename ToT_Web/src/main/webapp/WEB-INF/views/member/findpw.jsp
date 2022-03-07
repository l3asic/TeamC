<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#findpw{ width: 35%; height:45px; margin-bottom: 10px; text-align: left;}
</style>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>

<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<div style="width: 700px; border: 1px solid #ccc; text-align: center;" class='center'>
	<div style="width: 100%; padding: 50px 0; float: left; background: #BDEDFF;">
		<div style='height: 70px;'>
			<a href='<c:url value="/" />'><img src="images/logo_60.png"></a>
		</div>
		<div >
			<input id="findpw" type="text" placeholder="아이디를 입력하세요" /><br/>
			<input id="findpw" type="text" placeholder="가입하신 전화번호를 입력하세요" 
				autofocus onkeypress="if (event.keyCode == 13) { go_findid() }" />
					<!-- onkeypress를 통해 Enter 키를 눌렀을 때 go_login() 동작 -->
		</div>
		<div>
			<a style="width: 25%" class='btn btn-outline-primary btn-md' onclick="go_findid()">비밀번호 찾기</a>
			<div style="width: 80%; margin: 25px auto; border: 1px solid #ccc"></div>
			
		</div>
	</div>
</div>

</body>
</html>