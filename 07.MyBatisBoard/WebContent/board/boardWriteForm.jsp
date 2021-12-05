<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write Form</title>
<script type="text/javascript">
function fnSubmit(){
	if(confirm("작성하신 글을 등록하시겠습니까?")){
		return true;
	}
	return false;
}

function fnReset(){
	var msg = "입력하신 내용이 모두 초기화 됩니다.";
	msg += "\n계속 진행하시겠습니까?";
	if(confirm(msg)){
		return true;
	}
	return false;
}
</script>
</head>
<body>
<div align="center">
<h3>[게시판 글쓰기]</h3>
<form action="boardInsert.do" method="post" onsubmit="return fnSubmit()" onreset="return fnReset()">
<table border="1" style="width: 80%">
	<tr>
		<th>작성자</th>
		<td><input type="text" name="b_writer" maxlength="20" required="required"/></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="b_subject" maxlength="50" required="required"/></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="50" name="b_content" maxlength="2000" required="required"></textarea></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="b_pwd" maxlength="20" required="required"/></td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input type="submit" value="등록하기"/>
			<input type="reset" value="초기화하기"/>
			<input type="button" value="목록보기" onclick="location.href='boardList.do'"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>