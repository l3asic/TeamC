<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#usertel{ width: 35%; height:45px; margin-bottom: 10px; text-align: left;}
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
		<div>
			<input type="text" placeholder="가입하신 전화번호를 입력하세요" id="usertel" 
				 onkeypress="if(event.keyCode ==13){ go_find_id();}" />
		</div>
		<div>
			<a style="width: 25%" class='btn btn-outline-primary btn-md' onclick='go_find_id()'>아이디 찾기</a>
			<a style="width: 25%" class='btn btn-outline-success btn-md' onclick="history.go(-1)">로그인 하러가기</a>
			<div style="width: 80%; margin: 25px auto; border: 1px solid #ccc"></div>
			
		</div>
	</div>
</div>

<script type="text/javascript">
function go_find_id() {
	if($('#usertel').val() == '') {
		alert('가입하신 전화번호를 입력하세요');
		$('#usertel').focus();
		return;
	}
	$.ajax({
		url : 'find_member_id'
		, data : {member_tel:$('#usertel').val()}
		, success : function (response) {
			if (response) {
				alert('당신의 아이디는 '+ response +' 입니다');
			}else {
				alert('가입하신 전화번호가 일치하지 않습니다');
			}
		}, error : function (req, text) {
			alert(text + ':' + req.status);
		}
	});
}

</script>

</body>
</html>