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
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h3>응시자 정보</h3>
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


		</table>
	</div>

	<div align="center">
		<h3>예브게 꾸미세요</h3>
		<div class="btns">
			<input type="button" value="뒤로가기"
				onclick="location.href='adminMain.jsp'" />
		</div>
		<div class="btns">
			<input type="button" value="응시자 결과"
				onclick="location.href='admin_PassFail.jsp'" />
		</div>
		<div class="btns">
			<input type="button" value="처음으로"
				onclick="location.href='OmrMain.html'" />
		</div>
	</div>
</body>
</html>