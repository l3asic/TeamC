<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserDAO dao = new UserDAO();
	ArrayList<UserDTO> u_list = dao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응시자 조회</title>
</head>
<body>
	<div align="center">
		.
		<h3>시험결과 목록</h3>
		<table border="1">


			<tr align="center">
				<td colspan="5">
					<form action="userResult.jsp" method="post">
						<select name="part">
							<option value="u_id">수험번호</option>
							<option value="u_name">성명</option>
						</select> <input type="text" name="searchData" required="required" /> <input
							type="submit" value="검색하기" /> <input type="button"
							value="관리자화면으로 돌아가기" onclick="location.href='adminMain.jsp'" />
					</form>
			<tr>
				<th>수험번호</th>
				<th>성명</th>
				<th>응시여부</th>
			</tr>
			</td>
			</tr>
			<%
				if (u_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (UserDTO dto : u_list) {
			%>

			<tr>
<<<<<<< HEAD
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td>아아아</td>
=======
				<th><%=dto.getId()%></th>
				<th><%=dto.getName()%></th>
>>>>>>> d8baf047f15f4885b4fd1c9d4e036ca9abdcf38f
				<%-- 				<th><%=dto.getId()%></th> --%>
				<%-- 				<th><%=dto.getName()%></th> --%>
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
		<h3>예쁘게 만드세요 ㅋㅋ</h3>
		<div class="btns">
			<input type="button" value="뒤로가기"
				onclick="location.href='adminMain.jsp'" />
		</div>
		<div class="btns">
			<input type="button" value="응시자격 목록 수정"
				onclick="location.href='admin_Testers.jsp'" />
		</div>
		<div class="btns">
			<input type="button" value="처음으로"
				onclick="location.href='OmrMain.html'" />
		</div>
	</div>
</body>
</html>