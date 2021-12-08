<%@page import="com.hanul.study.OmrDTO"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserDAO dao = new UserDAO();
	ArrayList<UserDTO> u_list = dao.displayTester();
	ArrayList<OmrDTO> m_list = dao.myAns("*");
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
				for (UserDTO dto : u_list) {
			%>
			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getScore()%></td>
				<td><%=dto.getOx()%></td>
				<td><%=dto.getPass()%></td>
				<td><%=dto.getCnt()%></td>
				<td><input type="button" value="삭제"
					onclick="fnDelete('${dto.id}')" /></td>
				<td><input type="button" value="수정"
					onclick="fnDelete('${dto.id}')" /></td>
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