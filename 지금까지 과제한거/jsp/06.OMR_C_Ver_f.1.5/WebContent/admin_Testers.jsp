<%@page
	import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
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

	// 	dao.OXOX(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<style type="text/css">
table, th, td {
	border-collapse: collapse;
	border: 1px solid #333;
	text-align: center;
}

input {
	outline: none;
}

body {
	background-color: #F3E7E7;
}

.main {
	margin-top: 10%;
}
</style>
<script type="text/javascript">
	function fnDelete(id) {
		//alert("ID : " + id);
		if (confirm("응시 자격을 박탈합니다.")) {
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
	<div class="main" align="center">
		<h3>응시자격 확인</h3>
		<table border="1">
			<tr>
				<th>수험번호</th>
				<th>성명</th>
				<th>시험 응시여부</th>
				<th></th>

			</tr>
			<%
				if (u_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">허가된 응시자가 존재하지 않습니다.</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (int i = 0; i < u_list.size(); i++) {
			%>
			<tr>
				<td><%=u_list.get(i).getId()%></td>
				<td><%=u_list.get(i).getName()%></td>
				<%
					if (dao.checkTried(u_list.get(i).getId()) > 0) {
				%>
				<td>응시 완료</td>
				<%
					} else {
				%>
				<td>미응시</td>

				<%
					}
				%>
				<td><input class="btn btn-outline-danger" type="button"
					value="삭제" onclick="fnDelete(<%=u_list.get(i).getId()%>)" /></td>
			</tr>
			<%
				} //for
			%>
			<%
				} //else
			%>
			<tr>
				<td colspan="4" align="center"><input
					class="btn btn-outline-success btn-sm" type="button" value="응시자 추가"
					onclick="location.href='admin_Testers_Add.jsp'" /> <input
					class="btn btn-outline-warning btn-sm" type="button" value="응시자 목록"
					onclick="location.href='admin_Select.jsp'" /> <input
					class="btn btn-outline-info btn-sm" type="button" value="관리자모드 종료"
					onclick="location.href='OmrMain.html'" /></td>
			</tr>
		</table>
	</div>
</body>
</html>