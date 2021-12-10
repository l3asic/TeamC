<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.CorrectAnsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");

	UserDAO dao = new UserDAO();
	ArrayList<CorrectAnsDTO> c_list = dao.CorrectAns();
	ArrayList<OmrDTO> m_list = dao.myAns(id);
	ArrayList<OmrDTO> ox_list = dao.OXOX(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 보여주는 페이지</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<style type="text/css">
body {
	background: url("images/note+pan.jpg") no-repeat top;
}

table, th, td {
	border-collapse: collapse;
	border: 1px solid #333;
	text-align: center;
}

input {
	outline: none;
}

body {
	background-color: #fff;
}

.ans {
	background-color: #b0e0e6;
	text-color: #ffffff;
}

.main {
	margin-top: 10%;
}
</style>
</head>
<body>
	<div align="center" style="margin-top: 100px;">
		<h3>[내 시험 결과 보기]</h3>
		<table border="1">
			<form>
				<input type="hidden" name="ox_list" val=<%=ox_list%> />
			</form>
			<tr>
				<th></th>
				<th>&nbsp;Q. 01&nbsp;</th>
				<th>&nbsp;Q. 02&nbsp;</th>
				<th>&nbsp;Q. 03&nbsp;</th>
				<th>&nbsp;Q. 04&nbsp;</th>
				<th>&nbsp;Q. 05&nbsp;</th>
				<th>&nbsp;Q. 06&nbsp;</th>
				<th>&nbsp;Q. 07&nbsp;</th>
				<th>&nbsp;Q. 08&nbsp;</th>
				<th>&nbsp;Q. 09&nbsp;</th>
				<th>&nbsp;Q. 10&nbsp;</th>
				<th rowspan="2">합격 여부</th>
				<th rowspan="2">&nbsp;점수&nbsp;</th>
			</tr>

			<%
				if (c_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">[ERROR] 정답 목록을 불러올 수 없습니다.</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (CorrectAnsDTO dto : c_list) {
			%>
			<tr align="center">
				<td>정답</td>
				<td><%=dto.getCa1()%></td>
				<td><%=dto.getCa2()%></td>
				<td><%=dto.getCa3()%></td>
				<td><%=dto.getCa4()%></td>
				<td><%=dto.getCa5()%></td>
				<td><%=dto.getCa6()%></td>
				<td><%=dto.getCa7()%></td>
				<td><%=dto.getCa8()%></td>
				<td><%=dto.getCa9()%></td>
				<td><%=dto.getCa10()%></td>


			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%>
			<%
				if (m_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">[ERROR] 제출된 답안을 불러올 수 없습니다.</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (OmrDTO dto : m_list) {
						ArrayList<UserDTO> u_list2 = dao.newUl(dto.getId());
			%>
			<tr align="center">
				<td>기입한 답</td>
				<td><%=dto.getAnswer1()%></td>
				<td><%=dto.getAnswer2()%></td>
				<td><%=dto.getAnswer3()%></td>
				<td><%=dto.getAnswer4()%></td>
				<td><%=dto.getAnswer5()%></td>
				<td><%=dto.getAnswer6()%></td>
				<td><%=dto.getAnswer7()%></td>
				<td><%=dto.getAnswer8()%></td>
				<td><%=dto.getAnswer9()%></td>
				<td><%=dto.getAnswer10()%></td>
				<th rowspan="2"><%=u_list2.get(0).getPass()%></th>
				<th rowspan="2"><%=u_list2.get(0).getScore()%></th>

			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%>
			<%
				if (ox_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">[ERROR] 정답 여부를 불러올 수 없습니다.</td>
			</tr>
			<%
				} else {
			%>
			<tr align="center">

				<%
					for (OmrDTO dto : ox_list) {
				%>
				<td>정답여부</td>

				<td><%=dto.getAnswer1()%></td>
				<td><%=dto.getAnswer2()%></td>
				<td><%=dto.getAnswer3()%></td>
				<td><%=dto.getAnswer4()%></td>
				<td><%=dto.getAnswer5()%></td>
				<td><%=dto.getAnswer6()%></td>
				<td><%=dto.getAnswer7()%></td>
				<td><%=dto.getAnswer8()%></td>
				<td><%=dto.getAnswer9()%></td>
				<td><%=dto.getAnswer10()%></td>

			</tr>
			<%
				}
				} //for
			%>
			<%
				// 				} //if
			%>

			<tr align="center">
				<td colspan="13"><input class="btn btn-outline-info btn-sm"
					type="button" value="처음으로" onclick="location.href='OmrMain.html'" />

				</td>
			</tr>
		</table>
	</div>
</body>
</html>