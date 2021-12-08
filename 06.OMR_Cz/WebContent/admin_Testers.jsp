<%@page import="com.hanul.study.OmrDTO"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	UserDAO dao = new UserDAO();

	ArrayList<UserDTO> u_list = dao.displayTester();

	dao.OXOX(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fnDelete(id) {
		//alert("ID : " + id);
		if (confirm("정말 삭제하시겠습니까?")) {
			location.href = "delete.jsp?id=" + id;
		}
		return false;
	}

	function fnUpdate(id) {
		//alert("ID : " + id);
		location.href = "detail.jsp?id=" + id;
	}
</script>
</head>
<body>
	<div align="center">
		<h3>응시자 정보</h3>
		<table border="1">
			<tr>
				<th>시험 응시여부</th>
				<th>수험번호</th>
				<th>이름</th>
				<th>점수</th>
				<th>OX는 출력안해도되나?</th>
				<th>합격여부</th>
				<th>맞은개수</th>
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
				// 				for (UserDTO dto : u_list) {
					for (int i = 0; i < u_list.size(); i++) {
			%>
			<tr>
				<%
					if (dao.myAns(id).get(i).getAnswer1() == null) {
				%>
				<td>시험 봤음</td>
				<%
					} else {
				%>
				<td>시험 아직 안봤음</td>
				<%
					}
				%>
				<td><%=u_list.get(i).getId()%></td>
				<td><%=u_list.get(i).getName()%></td>
				<td><%=u_list.get(i).getScore()%></td>
				<td><%=u_list.get(i).getOx()%></td>
				<td><%=u_list.get(i).getPass()%></td>
				<td><%=u_list.get(i).getCnt()%></td>
				<td><input type="button" value="삭제"
					onclick="fnDelete(<%=u_list.get(i).getId()%>)" /></td>

			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%>

			<tr>
				<td colspan="10" align="center"><div class="btns">
						<input type="button"
							value="응시자 추가(jsp->dao.addTester(String id, String name))"
							onclick="location.href='admin_Testers_Add.jsp'" />
					</div></td>
			</tr>
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