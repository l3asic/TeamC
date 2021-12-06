<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.CorrectAnsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	request.getParameter("id");

	UserDAO dao = new UserDAO();
	ArrayList<CorrectAnsDTO> c_list = dao.CorrectAns();
/*  	ArrayList<OmrDTO> m_list = dao.myAns("id");
	ArrayList<UserDTO> ox_list = dao.OXOX("id");  */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 보여주는 페이지</title>
</head>
<body>
	<div align="center">
		<h3>[전체회원 목록보기]</h3>
		<table border="1">
			<tr>
				<th>ㅁㅁ</th>
				<th>Q1</th>
				<th>Q2</th>
				<th>Q3</th>
				<th>Q4</th>
				<th>Q5</th>
				<th>Q6</th>
				<th>Q7</th>
				<th>Q8</th>
				<th>Q9</th>
				<th>Q0</th>
			</tr>

			<%-- 단순 for문을 이용한 출력
	<%for(int i = 0; i < list.size(); i++){ %>
		<tr align="center">
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getId() %></td>
			<td><%= list.get(i).getPw() %></td>
			<td><%= list.get(i).getAge() %></td>
			<td><%= list.get(i).getAddr() %></td>
			<td><%= list.get(i).getTel() %></td>
		</tr>	
	<%}//for %>
	--%>

			<%-- 향상된 for문을 이용한 출력 --%>
			<%
				if (c_list.size() ==0) {
			%>
			<tr align="center">
				<td colspan="9">등록된 회원목록이 없습니다!</td>
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
			<%-- <%
				if (m_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="10">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (OmrDTO dto : m_list) {
			%>
			<tr align="center">
				<td><%=dto.getId()%></td>
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
				} //for
			%>
			<%
				} //if
			%>
			<%
				if (ox_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (UserDTO dto : ox_list) {
			%>
			<tr align="center">
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
								<td><%=dto.ox_list()%></td>
								<td><%=dto.getOx1()%></td>
								<td><%=dto.getOx2()%></td>
								<td><%=dto.getOx3()%></td>
								<td><%=dto.getOx4()%></td>
								<td><%=dto.getOx5()%></td>
								<td><%=dto.getOx6()%></td>
								<td><%=dto.getOx7()%></td>
								<td><%=dto.getOx8()%></td>
								<td><%=dto.getOx9()%></td>
								<td><%=dto.getOx10()%></td>

			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%>
 --%>
			<tr align="center">
				<td colspan="11"><input type="button" value="처음으로"
					onclick="location.href='OmrMain.html'" /></td>
			</tr>
		</table>
	</div>
</body>
</html>