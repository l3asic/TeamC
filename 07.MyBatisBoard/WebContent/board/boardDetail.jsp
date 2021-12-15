<%@page import="com.hanul.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
request.setCharacterEncoding("utf-8");
BoardDTO dto = (BoardDTO) request.getAttribute("dto");
pageContext.setAttribute("enter", "\r\n");	//줄바꿈처리
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
<script type="text/javascript">
function fnDelete(b_pwd){
	var userPwd = document.getElementById("userPwd").value;
	//alert("User Pwd : " + userPwd + "\nDB Pwd : " + b_pwd);
	
	if(userPwd.trim() == ""){	//비밀번호 미입력
		alert("비밀번호를 입력하세요!");
		document.getElementById("userPwd").value = "";
		document.getElementById("userPwd").focus();
	}else if(userPwd != b_pwd){	//비밀번호 불일치
		alert("비밀번호가 잘못 입력되었습니다!");
		document.getElementById("userPwd").value = "";
		document.getElementById("userPwd").focus();
	}else{	//비밀번호 일치
		if(confirm("정말 삭제하시겠습니까?")){
			location.href = "boardDelete.do?b_num=" + ${dto.b_num};
		}else{
			document.getElementById("userPwd").value = "";
			document.getElementById("userPwd").focus();
		}
	}
}//fnDelete()

function fnUpdate(b_pwd){
	var userPwd = document.getElementById("userPwd").value;
	//alert("User Pwd : " + userPwd + "\nDB Pwd : " + b_pwd);
	
	if(userPwd.trim() == ""){	//비밀번호 미입력
		alert("비밀번호를 입력하세요!");
		document.getElementById("userPwd").value = "";
		document.getElementById("userPwd").focus();
	}else if(userPwd != b_pwd){	//비밀번호 불일치
		alert("비밀번호가 잘못 입력되었습니다!");
		document.getElementById("userPwd").value = "";
		document.getElementById("userPwd").focus();
	}else{	//비밀번호 일치
		location.href = "boardUpdateForm.do?b_num=" + ${dto.b_num};
	}
}//fnUpdate()
</script>
</head>
<body>
<div align="center">
<h3>[글 내용 상세보기]</h3>
<table border="1" style="width: 80%">
	<tr>
		<th>작성자</th>
		<td>${dto.b_writer}</td>
		<th>조회수</th>
		<td align="center">${dto.b_readcount}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3">${dto.b_subject}</td>
	</tr>
	<tr>
		<th>내용</th>
		<%-- <td colspan="3">${dto.b_content}</td> --%>
		<%-- <td colspan="3"><%= dto.getB_content().replace("\r\n", "<br/>") %></td> --%>
		<td colspan="3">${fn:replace(dto.b_content, enter, "<br/>") }</td>
	</tr>
	<tr align="center">
		<th>비밀번호</th>
		<td colspan="3">
			<input type="password" id="userPwd"/>
			<input type="button" value="수정" onclick="fnUpdate('${dto.b_pwd}')"/>
			<input type="button" value="삭제" onclick="fnDelete('${dto.b_pwd}')"/>
			<input type="button" value="목록보기" onclick="location.href='boardList.do'"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>
