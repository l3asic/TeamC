<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserDAO dao = new UserDAO();
ArrayList<UserDTO> pf_list = dao.passFail();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fnDelete(id, name) {
		//alert("ID : " + id);
		if (confirm("정말 삭제하시겠습니까?")) {
			location.href = "delete.jsp?id=" + id;
		}
		return false;
	}

	function fnUpdate(id, name) {
		//alert("ID : " + id);
		location.href = "detail.jsp?id=" + id;
	}
</script>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<th>이름</th>
				<th>수험번호</th>
				<th>결과</th>
			</tr>
			<%
			if (pf_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
			} else {
			%>
			<%
			for (UserDTO dto : pf_list) {
			%>
			<tr>
				<td><%=dto.getName()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getPass()%></td>
				<td><input type="button" value="추가"
					onclick="fnAdd()" /></td>
				<td><input type="button" value="삭제"
					onclick="fnDelete('dto.getId()','dto.getName()')" /></td>
				<td><input type="button" value="수정"
					onclick="fnUpdate('dto.getId()','dto.getName()')" /></td>
			</tr>
			<%
			} //for
			%>
			<%
			} //if
			%>


		</table>
		<div align="center">
			<h3>관리자모드 메인</h3>
			<div class="btns">
				<input type="button" value="뒤로가기"
					onclick="location.href='adminMain.jsp'" />
			</div>
			<div class="btns">
				<input type="button" value="응시자 결과"
					onclick="location.href='admin_PassFail.html'" />
			</div>
			<div class="btns">
				<input type="button" value="처음으로"
					onclick="location.href='OmrMain.html'" />
			</div>
		</div>
</body>
</html>