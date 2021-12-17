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
	
	//비밀번호 유효성 검사
	$("#member_pw, #member_pw_check").keyup(function(){
		var pw = $("#member_pw").val();
		var num = pw.search(/[0-9]/g);
		var eng = pw.search(/[a-z]/ig);
		var spe = pw.search(/[~!@#$%^&*]/gi);
			
		
		if(pw.search(/\s/) != -1){
			var msg = "비밀번호는 공백문자를 사용할 수 없습니다!";
			$("#pwCheck").text(msg);
			$("#pwCheck").css("color", "red");
			$("#member_pw").focus();
		}else if(pw.length < 8 || pw.length > 15){
			var msg = "비밀번호는 8 ~ 15 자리 이내로 입력해 주세요!";
			$("#pwCheck").text(msg);
			$("#pwCheck").css("color", "red");
			$("#member_pw").focus();			
		}else if( (num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
			var msg = "영문자, 숫자, 특수문자를 혼합하여 입력해 주세요!";
			$("#pwCheck").text(msg);
			$("#pwCheck").css("color", "red");
			$("#member_pw").focus();
		}else{
			var msg = "사용 가능한 비밀번호 입니다.";
			$("#pwCheck").text(msg);
			$("#pwCheck").css("color", "blue");			
			
			var pwReCheck = $("#member_pw_check").val();
			if(pw != pwReCheck){
				var msg = "비밀번호가 일치하지 않습니다!";
				$("#pwReCheck").text(msg);
				$("#pwReCheck").css("color", "red");
			}else{
				var msg = "비밀번호가 일치합니다!";
				$("#pwReCheck").text(msg);
				$("#pwReCheck").css("color", "blue");
				pwCheck = 1;
			}
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

function fnSubmit(){
	if(idCheck == 0 || pwCheck == 0){
		alert("아이디나 비밀번호가 형식에 맞지 않습니다!");
		return false;
	}else{
		var msg = "입력하신 내용으로 회원가입이 됩니다";
		msg += "\n가입 하시겠습니까?";
		if(confirm(msg)){
			return true;
		}else{
			return false;
		}
	}
}//fnSubmit()

function fnReset(){
	var msg = "작성하신 내용이 초기화 됩니다.";
	msg += "\n다시 작성하시겠습니까?";
	if(confirm(msg)){
		return true;
	}else{
		return false;
	}
}
</script>
</head>
<body>
<div align="center">
<h3>[회원가입]</h3>
<form action="memberJoinAction.me" method="post" 
	onsubmit="return fnSubmit()" onreset="return fnReset()">
<table border="1" >
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="member_id" id="member_id" required="required"/><br/>
			<span id="idCheck"></span><!-- ID 유효성 검사 및 중복여부 -->
		</td>
	</tr>
	
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="member_pw" id="member_pw" required="required"/><br/>
			<span id="pwCheck"></span><!-- 비밀번호 유효성 검사 -->
		</td>
	</tr>
	
	<tr>
		<th>비밀번호 확인</th>
		<td>
			<input type="password" id="member_pw_check" required="required"/><br/>
			<span id="pwReCheck"></span><!-- 비밀번호 확인 검사 -->
		</td>
	</tr>
	
	<tr>
		<th>이름</th>
		<td><input type="text" name="member_name" required="required"/></td>
	</tr>
	
	<tr>
		<th>나이</th>
		<td><input type="number" name="member_age" min="0" required="required"/></td>
	</tr>
	
	<tr>
		<th>성별</th>
		<td align="center">
			<input type="radio" name="member_gender" value="남" checked="checked"/>남자
			<input type="radio" name="member_gender" value="여" />여자
		</td>
	</tr>
	
	<tr>
		<th>이메일</th>
		<td><input type="text" name="member_email" maxlength="30"/></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="회원가입"/>
			<input type="reset" value="다시작성"/>
			<input type="button" value="로그인" onclick="location.href='memberLogin.me'"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>