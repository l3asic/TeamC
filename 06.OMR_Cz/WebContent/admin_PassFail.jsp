<%@page import="java.util.ArrayList"%>
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
<title>합불 여부</title>
</head>
<body>
	<div align="center">.
	<h3>시험결과 목록</h3>
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
				<th><%=dto.getName()%></th>
				<th><%=dto.getId()%></th>
				<th><%=dto.getPass()%></th>
			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%>
			<tr>
				<td colspan="10" align="center" class="btns">
						<input type="button" value="응시자 목록" onclick="location.href='admin_Testers.jsp'" />
						<input type="button" value="처음으로" onclick="location.href='OmrMain.html'" />
				</td>
			</tr>

		</table>
	</div>

	<div align="center">
		<h3>예쁘게 만드세요 ㅋㅋ</h3>
		
	</div>
</body>
</html>