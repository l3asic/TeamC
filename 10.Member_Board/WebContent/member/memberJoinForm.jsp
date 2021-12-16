<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Join Form</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="jquery/jquery-3.6.0.js"></script>
<script type="text/javascript">
var idCheck = 0;
var pwCheck = 0;
$(document).ready(function(){
	//ID 유효성 검사
	$("#member_id").keyup(function(){
		var id = document.querySelector("#member_id").value;		
		var regId = /^[a-z0-9]{8,15}$/;
		
		if(!regId.test(id)){
			var msg = "영문 소문자와 숫자 8 ~ 15 자리 이내로 입력해 주세요!";
			$("#idCheck").text(msg);
			$("#idCheck").css("color", "red");
			$("#member_id").focus();
		}else{
			//ID 중복 검사
			var check = true;
			$.ajax({
				dataType : "json",
				url : "member/idList.jsp",
				success : function(data){
					$.each(data, function(key, value){
						if(id == value.member_id){
							check = false;
						}
					});	//each()
					fnCheck(check);
				},
				error : function(){ alert("ID 중복 검사 오류!"); }
			});	//ajax()
		}//if
	});	//keyup()
	
	
});	//ready()

function fnCheck(check){
	if(!check){	//ID 중복
		var msg = "사용중인 아이디 입니다!";
		$("#idCheck").text(msg);
		$("#idCheck").css("display", "block");		
		$("#idCheck").css("color", "red");	
	}else{
		var msg = "사용가능한 아이디 입니다!";
		$("#idCheck").text(msg);
		$("#idCheck").css("display", "block");		
		$("#idCheck").css("color", "blue");	
		idCheck = 1;
	}
}//fnCheck()


</script>
</head>
<body>
<div align="center">
<h3>[회원가입]</h3>
<form action="memberJoinAction.me" method="post">
<table border="1" style="width: 50%">
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="member_id" id="member_id" required="required"/><br/>
			<span id="idCheck"></span><!-- ID 유효성 검사 및 중복여부 -->
		</td>
	</tr>
	
</table>
</form>
</div>
</body>
</html>